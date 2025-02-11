package main.dao;

import main.Produto;

public interface IProdutoDao {

	Produto cadastrarProduto(Produto produto);

	Produto consultarProduto(String codigo);

	Produto atualizarProduto(Produto produto);

	void excluirProduto(String codigo);

}
