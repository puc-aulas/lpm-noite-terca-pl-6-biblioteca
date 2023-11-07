package Usuarios;

import java.util.List;

import Biblioteca.Item;

public interface IUsuario {
	public void cadastrarUsuario(int ID, String nome);

	public Usuario removerUsuario(Usuario usuario);

	public Usuario atualizarUsuario(int ID, String nome, List<Item> list);

	public void listarUsuario();

	public void pegarEmprestado(Item item);

	public void devolver(Item item);

	public int getID();

	public String getNome();

	public int getContadorItens();

	public Item[] getItensEmprestados();
}
