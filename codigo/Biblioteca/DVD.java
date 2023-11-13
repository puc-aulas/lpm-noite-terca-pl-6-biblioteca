package Biblioteca;
public class DVD extends Item {
    int vezesEmprestado;

    public DVD(String Title, String Author, int Year, int Quantity, int Emprestado){
        super(Title, Author, Year, "DVD", Quantity);
        this.vezesEmprestado = Emprestado;
    }

    public DVD(String Title, String Author, int Year, int Quantity){
        super(Title, Author, Year, "DVD", Quantity);
    }

    public int getEmprestado(){
        return this.vezesEmprestado;
    }
}
