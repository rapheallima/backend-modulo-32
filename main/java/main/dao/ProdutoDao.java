package main.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import main.Produto;

public class ProdutoDao implements IProdutoDao {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ExemploJPA");

	@Override
	public Produto cadastrarProduto(Produto produto) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		entityManager.persist(produto);
		entityManager.getTransaction().commit();

		entityManager.close();

		return produto;
	}

	@Override
	public Produto consultarProduto(String codigo) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<Produto> query = entityManager.createQuery("SELECT p FROM Produto p WHERE p.codigo = :codigo",
				Produto.class);
		query.setParameter("codigo", codigo);

		Produto produto = null;

		try {
			produto = query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("Produto não encontrado.");
		}

		entityManager.close();
		return produto;
	}

	@Override
	public Produto atualizarProduto(Produto produto) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Produto atualizado = entityManager.merge(produto);
		entityManager.getTransaction().commit();

		entityManager.close();
		return atualizado;
	}

	@Override
	public void excluirProduto(String codigo) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		TypedQuery<Produto> query = entityManager.createQuery("SELECT p FROM Produto p WHERE p.codigo = :codigo",
				Produto.class);
		query.setParameter("codigo", codigo);
		Produto produto = null;
		try {
			produto = query.getSingleResult();
			entityManager.remove(produto);
		} catch (NoResultException e) {
			System.out.println("Produto não encontrado para exclusão.");
		}

		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public static void fecharFactory() {

		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}

	}

}
