import java.util.ArrayList;
import java.util.List;

public class Biblioteca {

    List<Tese> teses = new ArrayList<>();
    List<Revista> revistas = new ArrayList<>();
    List<DVD> DVDs = new ArrayList<>();
    List<CD> CDs = new ArrayList<>();
    List<Livro> livros = new ArrayList<>();
    List<Item> Items = new ArrayList<>();

    //Cadastrar Teses na Bibilioteca
    public void addTeses(String Title, String Author, int Year, int Quantity){
        teses.add(new Tese(Title, Author, Year, Quantity));
        System.out.println("Tese cadastrada com sucesso!");
    }

    //Cadastrar Revistas na Biblioteca
    public void addRevista(String Title, String Author, int Year, int Quantity){
        revistas.add(new Revista(Title, Author, Year, Quantity));
        System.out.println("Revista cadastrada com sucesso");
    }

    //Cadastrar DVDs na Biblioteca
    public void addDVD(String Title, String Author, int Year, int Quantity){
        DVDs.add(new DVD(Title, Author, Year, Quantity, 0));
        System.out.println("DVD cadastrado com sucesso");
    }

    //Cadastrar CDs na Biblioteca
    public void addCD(String Title, String Author, int Year, int Quantity){
        CDs.add(new CD(Title, Author, Year, Quantity, 0));
        System.out.println("DVD cadastrado com sucesso");
    }

    //Cadastrar Livros na Biblioteca
    public void addLivro(String Titulo, String Author, int Year, int Quantity){
        livros.add(new Livro(Titulo, Author, Year, Quantity, 0));
        System.out.println("Livro Cadastrado com Sucesso!");
    }

    public Biblioteca(){

    }

    public void getAll(){
        for(int i = 0; i < teses.size(); i++){
            System.out.println(teses.get(i).titulo);
        }
        for(int i = 0; i < revistas.size(); i++){
            System.out.println(revistas.get(i).titulo);
        }
        for(int i = 0; i < DVDs.size(); i++){
            System.out.println(DVDs.get(i).titulo);
        }
        for(int i = 0; i < CDs.size(); i++){
            System.out.println(CDs.get(i).titulo);
        }
        for(int i = 0; i < livros.size(); i++){
            System.out.println(livros.get(i).titulo);
        }
    }

    public void listarTitulo(){
        List<String> Titles = new ArrayList<>();

        for(int i = 0; i < teses.size(); i++){
            Titles.add(teses.get(i).titulo);
        }
        for(int i = 0; i < revistas.size(); i++){
            Titles.add(revistas.get(i).titulo);
        }
        for(int i = 0; i < DVDs.size(); i++){
            Titles.add(DVDs.get(i).titulo);
        }
        for(int i = 0; i < CDs.size(); i++){
            Titles.add(CDs.get(i).titulo);
        }
        for(int i = 0; i < livros.size(); i++){
            Titles.add(livros.get(i).titulo);
        }

        Titles.sort(null);

        for(int i = 0; i < Titles.size(); i++){
            System.out.println(Titles.get(i));
        }
    }   

    public void listarAutor(){
        List<String> Titles = new ArrayList<>();

        for(int i = 0; i < teses.size(); i++){
            Titles.add(teses.get(i).autor);
        }
        for(int i = 0; i < revistas.size(); i++){
            Titles.add(revistas.get(i).autor);
        }
        for(int i = 0; i < DVDs.size(); i++){
            Titles.add(DVDs.get(i).autor);
        }
        for(int i = 0; i < CDs.size(); i++){
            Titles.add(CDs.get(i).autor);
        }
        for(int i = 0; i < livros.size(); i++){
            Titles.add(livros.get(i).autor);
        }

        Titles.sort(null);

        for(int i = 0; i < Titles.size(); i++){
            System.out.println(Titles.get(i));
        }
    }  

    public void listarAno(){
        List<Integer> Titles = new ArrayList<>();

        for(int i = 0; i < teses.size(); i++){
            Titles.add(teses.get(i).ano);
        }
        for(int i = 0; i < revistas.size(); i++){
            Titles.add(revistas.get(i).ano);
        }
        for(int i = 0; i < DVDs.size(); i++){
            Titles.add(DVDs.get(i).ano);
        }
        for(int i = 0; i < CDs.size(); i++){
            Titles.add(CDs.get(i).ano);
        }
        for(int i = 0; i < livros.size(); i++){
            Titles.add(livros.get(i).ano);
        }

        Titles.sort(null);

        for(int i = 0; i < Titles.size(); i++){
            System.out.println(Titles.get(i));
        }
    }  

    public void listarTipo(){
        List<String> Titles = new ArrayList<>();

        for(int i = 0; i < teses.size(); i++){
            Titles.add(teses.get(i).tipo);
        }
        for(int i = 0; i < revistas.size(); i++){
            Titles.add(revistas.get(i).tipo);
        }
        for(int i = 0; i < DVDs.size(); i++){
            Titles.add(DVDs.get(i).tipo);
        }
        for(int i = 0; i < CDs.size(); i++){
            Titles.add(CDs.get(i).tipo);
        }
        for(int i = 0; i < livros.size(); i++){
            Titles.add(livros.get(i).tipo);
        }

        Titles.sort(null);

        for(int i = 0; i < Titles.size(); i++){
            System.out.println(Titles.get(i));
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
