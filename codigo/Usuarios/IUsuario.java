package Usuarios;

import Biblioteca.Item;

public interface IUsuario {
	public void cadastrarUsuario(int ID, String nome, int contadorItens);

	public Usuario removerUsuario(Usuario usuario);

	public Usuario atualizarUsuario(int ID, String nome, int contadorItens, Item[] itensEmprestados);

	public void listarUsuario();

	public void pegarEmprestado(int ID, Item item);

	public void devolver(int ID, Item item);

	public int getID();

	public String getNome();

	public int getContadorItens();

	public Item[] getItensEmprestados();
}
