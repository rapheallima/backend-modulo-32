package main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.AfterClass;
import org.junit.Test;

import main.dao.IProdutoDao;
import main.dao.ProdutoDao;

public class ProdutoTest {

	@AfterClass
	public static void fecharEntityManagerFactory() {
		ProdutoDao.fecharFactory();
	}

	private IProdutoDao produtoDao;

	public ProdutoTest() {
		produtoDao = new ProdutoDao();
	}

	@Test
	public void testarFluxoProduto() {
		// Criar um novo produto
		Produto produto = new Produto();
		produto.setCodigo("P3");
		produto.setNome("Teclado Mecânico");
		produto.setDescricao("Teclado RGB Switch Azul");
		produto.setValor(250.00);
		produto = produtoDao.cadastrarProduto(produto);

		assertNotNull(produto);
		assertNotNull(produto.getId());

		// Consultar o produto
		Produto produtoConsultado = produtoDao.consultarProduto("P3");
		assertNotNull(produtoConsultado);
		assertEquals("Teclado Mecânico", produtoConsultado.getNome());

		// Atualizar o produto
		produtoConsultado.setValor(280.00);
		Produto produtoAtualizado = produtoDao.atualizarProduto(produtoConsultado);
		assertEquals(280.00, produtoAtualizado.getValor(), 0.01);

		// Excluir o produto
		produtoDao.excluirProduto("P3");

		// Tentar consultar novamente (deve ser null)
		Produto produtoExcluido = produtoDao.consultarProduto("P3");
		assertNull(produtoExcluido);
	}

}
