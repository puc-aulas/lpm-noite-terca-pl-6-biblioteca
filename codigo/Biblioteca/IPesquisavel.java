package Biblioteca;

public interface IPesquisavel {
	public void listarTodos();

	public void listarTitulo(String busca);

	public void listarAutor(String busca);

	public void listarAno(int busca);

	public void listarTipo();

	public void listarTese();

	public void listarRevista();

	public void listarDVD();

	public void listarCD();

	public void listarLivro();
}
