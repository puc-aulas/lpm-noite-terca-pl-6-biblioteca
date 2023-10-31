package Biblioteca;
public class DVD extends Item {
    int vezesEmprestado;

    public DVD(int id, String Title, String Author, int Year, int Quantity, int Emprestado){
        super(id, Title, Author, Year, "DVD", Quantity);
        this.vezesEmprestado = Emprestado;
    }
}
