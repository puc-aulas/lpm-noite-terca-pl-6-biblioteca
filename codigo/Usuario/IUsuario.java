package Usuario;

import java.util.List;

import Biblioteca.Item;

public interface IUsuario {
	public void cadastrarUsuario(String nome);

	public Usuario removerUsuario(Usuario usuario);

	public Usuario atualizarUsuario(String nome);

	public void printUsuario();

	public void pegarEmprestado(Item item, int idItem);

	public String getNome();

	public int getContadorItens();

	public List<Emprestimo> getItensEmprestados();
}
