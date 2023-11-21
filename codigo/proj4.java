import java.util.Scanner;

import biblioteca.Biblioteca;
import biblioteca.Item;
import biblioteca.RelatorioEmprestimo;
import usuario.ControladorUser;
import recomendacao.recomendacao;

public class proj4 {
    private static final ControladorUser users = new ControladorUser();
    private static final Biblioteca bib = new Biblioteca();
    private static final Scanner in = new Scanner(System.in);
    private static final RelatorioEmprestimo rel = new RelatorioEmprestimo();
    private static final recomendacao recom = new recomendacao();

    public static void main(String[] args) {
        int escolha;
        AddTests();
        AddTestsUser();

        do {
            mostrarMenuPrincipal();
            try {
                escolha = in.nextInt();
            } catch (Exception e) {
                System.out.println("Opção inválida!");
                in.next();
                escolha = -1;
            }
            switch (escolha) {
                case 1:
                    pesquisarItens();
                    break;
                case 2:
                    gerenciarUsuarios();
                    break;
                case 3:
                    editarItem();
                    break;
                case 4:
                    emprestar();
                    break;
                case 5:
                    devolver();
                    break;
                case 6:
                    bib.listarItems();
                    break;
                case 7:
                    rel.printRelatorio();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (escolha != 0);

        in.close();
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\nMenu da Biblioteca");
        System.out.println("Selecione uma das opções abaixo: \n");
        System.out.println("1 -- Pesquisar itens");
        System.out.println("2 -- Gerenciar usuários");
        System.out.println("3 -- Editar itens cadastrados");
        System.out.println("4 -- Menu Empréstimos");
        System.out.println("5 -- Menu Devoluções");
        System.out.println("6 -- Visualizar todos os itens da biblioteca");
        System.out.println("7 -- Visualizar o relatorio da biblioteca");
        System.out.println("0 -- Sair");
    }

    public static void emprestar() {
        if (bib.getSize() <= 0) {
            System.out.println("Não há itens cadastrados!");
            return;
        }
        do {
            bib.listarEmprestavel();
            System.out.println("\nQual o ID do item?");
            try {
                int id = in.nextInt();
                int emprestavel = bib.emprestavel(id);
                while (emprestavel == 0) {
                    System.out.println("Item não pode ser emprestado!");
                    System.out.println("Qual o ID do item?");
                    id = in.nextInt();
                    emprestavel = bib.emprestavel(id);
                }
                if (users.getSize() <= 0) {
                    System.out.println("Não há usuários cadastrados!");
                    return;
                }

                users.listarUsuarios();

                System.out.println("\nQual o ID do usuário?");
                int idUser = in.nextInt();


                if (users.verificarEmprestar(idUser, bib.get(id))) {
                    Item item = bib.pegarEmprestado(id);
                    users.pegarEmprestado(idUser, item, id);
                    rel.addItem(item);
                    System.out.println("Item emprestado com sucesso!");
                } else {
                    System.out.println("Usuário não pode pegar mais itens emprestados ou tem itens com atrasos!");
                }
                return;

            } catch (Exception e) {
                System.out.println("Usuario inválida!");
            }
        }
        while (true);
    }

    public static void devolver() {
        if (users.getSize() <= 0) {
            System.out.println("Não há usuários cadastrados!");
            return;
        }

        users.listarUsuarios();

        try {
            System.out.println("\nQual o ID do usuário?");
            int idUser = in.nextInt();

            if (users.verificarSeTemItens(idUser)) {
                System.out.println("Usuário não tem itens emprestados!");
                return;
            }

            users.listarItensEmprestados(idUser);

            System.out.println("\nQual o ID do item?");
            try {
                int idItem = in.nextInt();
                int id = users.devolverItem(idUser, idItem);
                bib.devolverItem(id);
                System.out.println("Item devolvido com sucesso!");
            } catch (Exception e) {
                System.out.println("Opção inválida!");
            }
        } catch (Exception e) {
            System.out.println("Opção inválida!");
        }
    }

    public static void pesquisarItens() {
        int escolha;
        String busca;
        do {
            System.out.println("O que deseja Buscar?\n");
            System.out.println("1 -- Título");
            System.out.println("2 -- Autor");
            System.out.println("3 -- Ano");
            System.out.println("0 -- Voltar");
            escolha = in.nextInt();
            switch (escolha) {
                case 1:
                    System.out.println("Qual o título da obra?");
                    in.nextLine();
                    busca = validaString();
                    System.out.println("Melhores resultados para a busca " + busca);
                    bib.listarTitulo(busca);
                    break;
                case 2:
                    in.nextLine();
                    busca = validaString();
                    System.out.println("Melhores resultados para a busca \"" + busca + "\"\n");
                    bib.listarAutor(busca);
                    System.out.println();
                    break;
                case 3:
                    in.nextLine();
                    int ano = validaAnoDaObra();
                    System.out.println("Obras do ano: \"" + ano + "\"\n");
                    bib.listarAno(ano);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (true);
    }

    public static String validaString() {
        System.out.println("Digite o título do item:");
        String titulo = in.nextLine();
        while (!titulo.matches("[a-zA-Z\\s]+")) {
            System.out.println("Digite novamente (apenas letras e espaços):");
            titulo = in.nextLine();
        }
        return titulo;
    }

    public static int validaAnoDaObra() {
        System.out.println("Digite o ano de publicação:");
        int ano = in.nextInt();
        int currentYear = java.time.Year.now().getValue();
        while (ano < 0 || ano > currentYear) {
            System.out.println("Ano de publicação inválido. Digite um ano entre 0000 e " + currentYear + ":");
            ano = in.nextInt();
        }
        return ano;
    }

    private static void gerenciarUsuarios() {
        int escolha;

        do {
            System.out.println("\nGerenciamento de usuários");
            System.out.println("Selecione uma das opções abaixo: \n");
            System.out.println("1 -- Cadastrar Usuário");
            System.out.println("2 -- Remover Usuário");
            System.out.println("3 -- Atualizar Usuário");
            System.out.println("4 -- Listar Usuário");
            System.out.println("5 -- Recommendação de itens");
            System.out.println("6 -- Listar Historico");
            System.out.println("0 -- Voltar");
            try {
                escolha = in.nextInt();
                switch (escolha) {
                    case 1:
                        users.cadastrarUser();
                        break;
                    case 2:
                        users.removeUser();
                        break;
                    case 3:
                        users.atualizarUsuario();
                        break;
                    case 4:
                        users.listarUsuarios();
                        break;
                    case 5:
                        recomendarItem();
                        break;
                    case 6:
                        listarHistorico();
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Opção inválida!");
                in.next();
                escolha = -1;
            }
        } while (escolha != 0);
    }

    public static void editarItem() {
        bib.listarItems();
        System.out.println("Digite o ID do item que deseja editar: ");
        int escolha = in.nextInt();

        bib.editarItem(escolha);
    }

    public static void listarHistorico() {
        if (users.getSize() <= 0) {
            System.out.println("Não há usuários cadastrados!");
            return;
        }

        users.listarUsuarios();

        try {
            System.out.println("\nQual o ID do usuário?");
            int idUser = in.nextInt();

            users.listarHistorico(idUser);
        } catch (Exception e) {
            System.out.println("Opção inválida!");
        }
    }

    public static void recomendarItem() {
        if (users.getSize() <= 0) {
            System.out.println("Não há usuários cadastrados!");
            return;
        }

        users.listarUsuarios();

        try {
            System.out.println("\nQual o ID do usuário?");
            int idUser = in.nextInt();

            recom.recomendar(users.getUser(idUser), bib);
            
        } catch (Exception e) {
            System.out.println("Opção inválida!");
        }
    }

    public static void AddTests() {        
        bib.addTeses("Tese 1", "Autor 1", 2020, 3, 1);  // Engenharia
        bib.addTeses("Tese 2", "Autor 2", 2021, 2, 2);  // Software
        bib.addTeses("Tese 3", "Autor 3", 2019, 4, 3);  // Matemática
        bib.addTeses("Tese 4", "Autor 4", 2022, 1, 4);  // Física
        bib.addTeses("Tese 5", "Autor 5", 2018, 5, 5);  // Medicina
        bib.addTeses("Tese 6", "Autor 6", 2023, 2, 6);  // Outros

        bib.addRevista("Revista 1", "Autor 1", 2019, 2, 1);  // Engenharia
        bib.addRevista("Revista 2", "Autor 2", 2020, 3, 2);  // Software
        bib.addRevista("Revista 3", "Autor 3", 2021, 1, 3);  // Matemática
        bib.addRevista("Revista 4", "Autor 4", 2022, 4, 4);  // Física
        bib.addRevista("Revista 5", "Autor 5", 2023, 2, 5);  // Medicina
        bib.addRevista("Revista 6", "Autor 6", 2018, 3, 6);  // Outros

        bib.addDVD("DVD 1", "Autor 1", 2020, 1, 1);  // Engenharia
        bib.addDVD("DVD 2", "Autor 2", 2019, 2, 2);  // Software
        bib.addDVD("DVD 3", "Autor 3", 2021, 3, 3);  // Matemática
        bib.addDVD("DVD 4", "Autor 4", 2018, 4, 4);  // Física
        bib.addDVD("DVD 5", "Autor 5", 2022, 2, 5);  // Medicina
        bib.addDVD("DVD 6", "Autor 6", 2023, 1, 6);  // Outros

        bib.addCD("CD 1", "Autor 1", 2022, 3, 1);  // Engenharia
        bib.addCD("CD 2", "Autor 2", 2020, 2, 2);  // Software
        bib.addCD("CD 3", "Autor 3", 2019, 1, 3);  // Matemática
        bib.addCD("CD 4", "Autor 4", 2021, 4, 4);  // Física
        bib.addCD("CD 5", "Autor 5", 2018, 2, 5);  // Medicina
        bib.addCD("CD 6", "Autor 6", 2023, 5, 6);  // Outros

        bib.addLivro("Livro 1", "Autor 1", 2019, 4, 1);  // Engenharia
        bib.addLivro("Livro 2", "Autor 2", 2020, 3, 2);  // Software
        bib.addLivro("Livro 3", "Autor 3", 2021, 2, 3);  // Matemática
        bib.addLivro("Livro 4", "Autor 4", 2018, 1, 4);  // Física
        bib.addLivro("Livro 5", "Autor 5", 2022, 5, 5);  // Medicina
        bib.addLivro("Livro 6", "Autor 6", 2023, 2, 6);  // Outros
    }

    public static void AddTestsUser() {
        users.cadastrarUsuario("Marcos", 1 , 1);
        users.cadastrarUsuario("Maria", 1, 2);
        users.cadastrarUsuario("Luiz", 4, 3);
    }
}