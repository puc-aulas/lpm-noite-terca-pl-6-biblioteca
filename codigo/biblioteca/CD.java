package biblioteca;

public class CD extends Item{
    final int vezesEmprestado;

    public CD(String Title, String Author, int Year, int Quantity, int Emprestado, int categoria){
        super(Title, Author, Year, "CD", Quantity, categoria);
        this.vezesEmprestado = Emprestado;
    }

    public int getEmprestado(){
        return this.vezesEmprestado;
    }
}