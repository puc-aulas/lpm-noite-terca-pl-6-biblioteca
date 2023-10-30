public class DVD extends Item {
    int vezesEmprestado;

    public DVD(String Title, String Author, int Year, int Quantity, int Emprestado){
        super(Title, Author, Year, "DVD", Quantity);
        this.vezesEmprestado = Emprestado;
    }
}
