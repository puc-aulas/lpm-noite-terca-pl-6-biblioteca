package biblioteca;

public interface IPesquisavel {
	void listarTodos();

	void listarTitulo(String busca);

	void listarAutor(String busca);

	void listarAno(int busca);

	void listarTipo();

	void listarTese();

	void listarRevista();

	void listarDVD();

	void listarCD();

	void listarLivro();
}
