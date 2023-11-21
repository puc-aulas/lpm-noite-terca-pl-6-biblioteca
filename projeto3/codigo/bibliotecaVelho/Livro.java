package biblioteca;

public class Livro extends Item {
	final int vezesEmprestado;

	public Livro(String Title, String Author, int Year, int Quantity, int Emprestado) {
		super(Title, Author, Year, "Livro", Quantity);
		this.vezesEmprestado = Emprestado;
	}

	public int getEmprestado(){
        return this.vezesEmprestado;
    }
}
