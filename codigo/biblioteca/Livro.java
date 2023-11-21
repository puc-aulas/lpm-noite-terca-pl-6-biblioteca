package biblioteca;

public class Livro extends Item {
	final int vezesEmprestado;

	public Livro(String Title, String Author, int Year, int Quantity, int Emprestado, int categoria) {
		super(Title, Author, Year, "Livro", Quantity, categoria);
		this.vezesEmprestado = Emprestado;
	}

	public int getEmprestado(){
        return this.vezesEmprestado;
    }
}
