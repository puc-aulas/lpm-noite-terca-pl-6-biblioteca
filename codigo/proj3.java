import java.util.*;

import Biblioteca.Biblioteca;
import Usuarios.ControladorUser;
import Usuarios.Usuario;

public class proj3{
    //public Tese(String Title, String Author, int Year, int Quantity)
    public static void main(String[] args){
        Biblioteca bib = new Biblioteca();
        ControladorUser users = new ControladorUser();
        Scanner in = new Scanner(System.in);

        int escolha = 1;

        while(escolha != 0){
            System.out.println("O que deseja fazer?");
            System.out.println("0 -- Sair");
            System.out.println("1 -- Popular o Banco com os testes");
            System.out.println("2 -- Listar Todos os dados dentro da bibliteca");
            System.out.println("3 -- Listar todos os dados dentro da biblioteca em ordem alfabetica");
            System.out.println("4 -- Usuarios");
            System.out.println("5 -- Emprestimos");
            System.out.println("6 -- Devoluções");

            escolha = in.nextInt();

            switch(escolha){
                case 0:
                    break;
                case 1: 
                    AddTests(bib);
                    break;
                case 2: 
                    bib.listarTodos();
                    break;
                case 3:
                    System.out.println("Qual a forma que deseja utilizar?");
                    System.out.println("0 - Sair");
                    System.out.println("1 -- Título");
                    System.out.println("2 -- Autor");
                    System.out.println("3 -- Ano");
                    System.out.println("4 -- Tipo");
                    System.out.println("5 -- Listar Items de um somente tipo");
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
                        case 5:
                            System.out.println("Qual o tipo que deseja listar?");
                            System.out.println("0 - Sair");
                            System.out.println("1 -- Tese");
                            System.out.println("2 -- Revista");
                            System.out.println("3 -- DVD");
                            System.out.println("4 -- CD");
                            System.out.println("5 -- Livro");
                            escolha = in.nextInt();

                            switch(escolha){
                                case 0: 
                                    escolha = 1;
                                    break;
                                case 1: 
                                    bib.listarTese();
                                    break;
                                case 2:
                                    bib.listarRevista();
                                    break;
                                case 3: 
                                    bib.listarDVD();
                                    break;
                                case 4: 
                                    bib.listarCD();
                                    break;
                                case 5:
                                    bib.listarLivro();
                                    break;
                            }
                            break;
                    }
                    break;

                case 4: 
                    System.out.println("O que deseja fazer?");
                    System.out.println("0 -- Sair");
                    System.out.println("1 -- Cadastrar Usuario");
                    System.out.println("2 -- Remover Usuario");
                    System.out.println("3 -- Atualizar Usuario");
                    System.out.println("4 -- Listar Usuario");

                    escolha = in.nextInt();

                    switch(escolha){
                        case 0:
                            escolha = 1;
                            break;

                        case 1:
                            users.cadastrarUser(genUserID());
                            break; 
                            
                        case 2:
                            users.removeUser();
                            break;

                        case 3:
                            users.atualizarUser();
                            break;

                        case 4: 
                            users.listarUsers();
                            break;
                    }

                case 5:
                    System.out.println("A ser implementado!");
                    break;
                case 6:
                    System.out.println("A ser implementado!");
                    break;
            }
        }  
    }

    public static Biblioteca AddTests(Biblioteca bib){
        bib.addTeses(genID(), "Test1Tese", "Mario", 2002, 100);
        bib.addTeses(genID(), "Test2Tese", "Fabio", 1995, 50);
        bib.addTeses(genID(), "Test3Tese", "Claudio", 1856, 10);

        bib.addRevista(genID(), "Teste1Revista", "Lucio", 2005, 150);
        bib.addRevista(genID(), "Teste2Revista", "Andre", 1945, 100);
        bib.addRevista(genID(), "Teste3Revista", "Lucas", 1968, 175);

        bib.addDVD(genID(), "Teste1DVD", "Lucas Cabral", 1998, 175);
        bib.addDVD(genID(), "Teste2DVD", "Anderson", 1986, 100);
        bib.addDVD(genID(), "Teste3DVD", "Oliver", 2009, 157);

        bib.addCD(genID(), "Teste1CD", "50 Pesos", 2007, 100);
        bib.addCD(genID(), "Teste2CD", "Jay-A", 1996, 95);
        bib.addCD(genID(), "Teste3CD", "Charlie Brown Sr.", 2000, 152);

        bib.addLivro(genID(), "Teste1Livro", "Loki", 1552, 10);
        bib.addLivro(genID(), "Teste2Livro", "Odin", 1358, 5);
        bib.addLivro(genID(), "Teste3Livro", "Thor", 859, 1);

        return bib;
    }

    private static int userCounter = 1;

    public static int genUserID(){
        return userCounter++;
    }

    private static int idCounter = 1;

    public static int genID(){
        return idCounter++;
    }
}