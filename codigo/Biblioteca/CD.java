package Biblioteca;
public class CD extends Item{
    int vezesEmprestado;

    public CD(String Title, String Author, int Year, int Quantity, int Emprestado){
        super(Title, Author, Year, "CD", Quantity);
        this.vezesEmprestado = Emprestado;
    }

    public int getEmprestado(){
        return this.vezesEmprestado;
    }
}