import java.util.*;

public class proj3{
    //public Tese(String Title, String Author, int Year, int Quantity)
    public static void main(String[] args){
        Biblioteca bib = new Biblioteca();
        Scanner in = new Scanner(System.in);

        int escolha = 1;

        while(escolha != 0){
            System.out.println("O que deseja fazer?");
            System.out.println("0 -- Sair");
            System.out.println("1 -- Popular o Banco com os testes");
            System.out.println("2 -- Listar Todos os dados dentro da bibliteca");
            System.out.println("3 -- Listar todos os dados dentro da biblioteca em ordem alfabetica");

            escolha = in.nextInt();

            switch(escolha){
                case 0:
                    break;
                case 1: 
                    AddTests(bib);
                    break;
                case 2: 
                    bib.getAll();
                    break;
                case 3:
                    System.out.println("Qual a forma que deseja utilizar?");
                    System.out.println("0 - Sair");
                    System.out.println("1 -- Título");
                    System.out.println("2 -- Autor");
                    System.out.println("3 -- Ano");
                    System.out.println("4 -- Tipo");
                    escolha = in.nextInt();

                    switch(escolha){
                        case 0: 
                            escolha = 1;
                            break;
                        case 1: 
                            bib.listarTitulo();
                            break;
                        case 2:
                            bib.listarAutor();
                            break;
                        case 3: 
                            bib.listarAno();
                            break;
                        case 4: 
                            bib.listarTipo();
                            break;
                    }
                    break;

                case 4: 
                    bib.addTodos();
                    break;
            }
        }  
    }

    public static Biblioteca AddTests(Biblioteca bib){
        bib.addTeses("Test1Tese", "Mario", 2002, 100);
        bib.addTeses("Test2Tese", "Fabio", 1995, 50);
        bib.addTeses("Test3Tese", "Claudio", 1856, 10);

        bib.addRevista("Teste1Revista", "Lucio", 2005, 150);
        bib.addRevista("Teste2Revista", "Andre", 1945, 100);
        bib.addRevista("Teste3Revista", "Lucas", 1968, 175);

        bib.addDVD("Teste1DVD", "Lucas Cabral", 1998, 175);
        bib.addDVD("Teste2DVD", "Anderson", 1986, 100);
        bib.addDVD("Teste3DVD", "Oliver", 2009, 157);

        bib.addCD("Teste1CD", "50 Pesos", 2007, 100);
        bib.addCD("Teste2CD", "Jay-A", 1996, 95);
        bib.addCD("Teste3CD", "Charlie Brown Sr.", 2000, 152);

        bib.addLivro("Teste1Livro", "Loki", 1552, 10);
        bib.addLivro("Teste2Livro", "Odin", 1358, 5);
        bib.addLivro("Teste3Livro", "Thor", 859, 1);

        return bib;
    }
}