package biblioteca;

public class DVD extends Item {
    int vezesEmprestado;

    public DVD(String Title, String Author, int Year, int Quantity, int Emprestado, int categoria){
        super(Title, Author, Year, "DVD", Quantity, categoria);
        this.vezesEmprestado = Emprestado;
    }

    public DVD(String Title, String Author, int Year, int Quantity, int categoria){
        super(Title, Author, Year, "DVD", Quantity, categoria);
    }

    public int getEmprestado(){
        return this.vezesEmprestado;
    }
}
