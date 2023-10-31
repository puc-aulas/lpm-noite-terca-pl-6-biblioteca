package Biblioteca;

public class Livro extends Item {
	int vezesEmprestado;

	public Livro(int id, String Title, String Author, int Year, int Quantity, int Emprestado) {
		super(id, Title, Author, Year, "Livro", Quantity);
		this.vezesEmprestado = Emprestado;
	}
}
