package Biblioteca;
public class CD extends Item{
    int vezesEmprestado;

    public CD(int id, String Title, String Author, int Year, int Quantity, int Emprestado){
        super(id, Title, Author, Year, "CD", Quantity);
        this.vezesEmprestado = Emprestado;
    }
}
