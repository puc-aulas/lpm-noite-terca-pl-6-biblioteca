package usuario;

import biblioteca.Item;
import java.time.LocalDate;

public class Emprestimo {
    LocalDate dataEmprestimo;
    Item item;
    int idItem;

    //Construtor vazio
    public Emprestimo() {

    }

    //Construtor
    public Emprestimo(LocalDate dataEmprestimo, Item item, int id) {
        this.dataEmprestimo = dataEmprestimo;
        this.item = item;
        this.idItem = id;
    }

    //Setters
    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setIdItem(int id){
        this.idItem = id;
    }

    //Getters
    public LocalDate getDataEmprestimo() {
        return this.dataEmprestimo;
    }

    public Item getItem() {
        return this.item;
    }
    
    public int getIdItem(){
        return this.idItem;
    }

    public void printEmprestimo() {
        System.out.println("Data do Emprestimo: " + this.dataEmprestimo);
        System.out.println("Item Emprestado: " + this.item.getTitulo());
    }
}
