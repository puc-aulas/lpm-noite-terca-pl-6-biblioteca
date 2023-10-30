public class Item{
    int ID = 0;
    String titulo;
    String autor;
    int ano;
    String tipo;
    int quantidade;

    public Item(String Title, String Author, int Year, String Type, int Quantity){
        this.ID++;
        this.titulo = Title;
        this.autor = Author;
        this.ano = Year;
        this.tipo = Type;
        this.quantidade = Quantity;
    }

    public String getTitulo(){
        return this.titulo;
    }
}