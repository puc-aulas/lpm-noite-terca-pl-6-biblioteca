package Biblioteca;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Biblioteca implements IPesquisavel {

    List<Tese> teses = new ArrayList<>();
    List<Revista> revistas = new ArrayList<>();
    List<DVD> DVDs = new ArrayList<>();
    List<CD> CDs = new ArrayList<>();
    List<Livro> livros = new ArrayList<>();
    List<Item> Items = new ArrayList<>();

    //Cadastrar Teses na Bibilioteca
    public void addTeses(int id, String Title, String Author, int Year, int Quantity){
        teses.add(new Tese(id, Title, Author, Year, Quantity));
        System.out.println("Tese cadastrada com sucesso!");
    }

    //Cadastrar Revistas na Biblioteca
    public void addRevista(int id, String Title, String Author, int Year, int Quantity){
        revistas.add(new Revista(id, Title, Author, Year, Quantity));
        System.out.println("Revista cadastrada com sucesso");
    }

    //Cadastrar DVDs na Biblioteca
    public void addDVD(int id, String Title, String Author, int Year, int Quantity){
        DVDs.add(new DVD(id, Title, Author, Year, Quantity, 0));
        System.out.println("DVD cadastrado com sucesso");
    }

    //Cadastrar CDs na Biblioteca
    public void addCD(int id, String Title, String Author, int Year, int Quantity){
        CDs.add(new CD(id, Title, Author, Year, Quantity, 0));
        System.out.println("DVD cadastrado com sucesso");
    }

    //Cadastrar Livros na Biblioteca
    public void addLivro(int id, String Titulo, String Author, int Year, int Quantity){
        livros.add(new Livro(id, Titulo, Author, Year, Quantity, 0));
        System.out.println("Livro Cadastrado com Sucesso!");
    }

    public Biblioteca(){}

    public void listarTodos(){
        List<Item> Items = new ArrayList<>();

        Items = addTodos();

        for(int i = 0; i < Items.size(); i++){
            Items.get(i).printItem();
        }
    }


    //Ordenar os Items pelo titulo
    public void listarTitulo(){
        List<Item> Items = new ArrayList<>();

        Items = addTodos();

        Collections.sort(Items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.titulo.compareTo(o2.titulo);
            }
        });

        for(int i = 0; i < Items.size(); i++){
            Items.get(i).printItem();
        }
    }   

    //Ordenar os Items pelo Autor

    public void listarAutor(){
        List<Item> Items = new ArrayList<>();

        Items = addTodos();

        Collections.sort(Items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.autor.compareTo(o2.autor);
            }
        });

        for(int i = 0; i < Items.size(); i++){
            Items.get(i).printItem();
        }
    }  

    //Ordenar os Items pelo Ano

    public void listarAno(){
        List<Item> Items = new ArrayList<>();

        Items = addTodos();

        Collections.sort(Items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return Integer.valueOf(o1.ano).compareTo(o2.ano);
            }
        });

        for(int i = 0; i < Items.size(); i++){
            Items.get(i).printItem();
        }
    }  


    //Ordenar os Items pelo Tipo
    public void listarTipo(){
        List<Item> Items = new ArrayList<>();

        Items = addTodos();

        Collections.sort(Items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.tipo.compareTo(o2.tipo);
            }
        });

        for(int i = 0; i < Items.size(); i++){
            Items.get(i).printItem();
        }
    }  

    //Listar somente Teses
    public void listarTese(){
        for(int i = 0; i < teses.size(); i++){
            teses.get(i).printItem();
        }
    }

    //Listar somente Revistas
    public void listarRevista(){
        for(int i = 0; i < revistas.size(); i++){
            revistas.get(i).printItem();
        }
    }

    //Listar somente DVDs
    public void listarDVD(){
        for(int i = 0; i < DVDs.size(); i++){
            DVDs.get(i).printItem();
        }
    }

    //Listar somente CDs
    public void listarCD(){
        for(int i = 0; i < CDs.size(); i++){
            CDs.get(i).printItem();
        }
    }

    //Listar somente Livros
    public void listarLivro(){
        for(int i = 0; i < livros.size(); i++){
            livros.get(i).printItem();
        }
    }    

    public List<Item> addTodos(){
        List<Item> Items = new ArrayList<>();

        for(int i = 0; i < teses.size(); i++){
            Items.add(teses.get(i));
        }
        for(int i = 0; i < revistas.size(); i++){
            Items.add(revistas.get(i));
        }
        for(int i = 0; i < DVDs.size(); i++){
            Items.add(DVDs.get(i));
        }
        for(int i = 0; i < CDs.size(); i++){
            Items.add(CDs.get(i));
        }
        for(int i = 0; i < livros.size(); i++){
            Items.add(livros.get(i));
        }

        return Items;
    }
}
