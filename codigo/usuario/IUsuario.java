package usuario;

import java.util.List;

import biblioteca.Item;

public interface IUsuario {
	void cadastrarUsuario(String nome);

	Usuario removerUsuario(Usuario usuario);

	Usuario atualizarUsuario(String nome);

	void printUsuario();

	void pegarEmprestado(Item item, int idItem);

	String getNome();

	int getContadorItens();

	List<Emprestimo> getItensEmprestados();
}
