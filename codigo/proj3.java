import java.util.Scanner;

import Biblioteca.Biblioteca;
import Biblioteca.Item;
import Biblioteca.RelatorioEmprestimo;
import Usuario.ControladorUser;

public class proj3{
	private static ControladorUser users = new ControladorUser();
	private static Biblioteca bib = new Biblioteca();
	private static Scanner in = new Scanner(System.in);
    private static RelatorioEmprestimo rel = new RelatorioEmprestimo();

    public static void main(String[] args) {
        int escolha;
        AddTests();
        AddTestsUser();

		do {
			mostrarMenuPrincipal();
            try{
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

        bib.listarEmprestavel();

        System.out.println("\nQual o ID do item?");
        int sucesso = 0;
            try{
                int id = in.nextInt();

                int emprestavel = bib.emprestavel(id);
                while(emprestavel == 0){
                    System.out.println("Item não pode ser emprestado!");
                    System.out.println("Qual o ID do item?");
                    id = in.nextInt();
                    emprestavel = bib.emprestavel(id);
                }

                if(users.getSize() <= 0){
                    System.out.println("Não há usuários cadastrados!");
                    return;
                }

                users.listarUsuarios();

                    System.out.println("\nQual o ID do usuário?");
                    int idUser = in.nextInt();


                    if(users.verificarEmprestar(idUser, bib.get(id))){
                        Item item = bib.pegarEmprestado(id);
                        users.pegarEmprestado(idUser, item, id);
                        rel.addItem(item);
                        System.out.println("Item emprestado com sucesso!");
                        return;
                    }else{
                        System.out.println("Usuário não pode pegar mais itens emprestados ou tem itens com atrasos!");
                        return;
                    }
                
            }catch(Exception e){
                System.out.println("Usuario inválida!");
            }
        while(sucesso == 0);
    }

    public static void devolver(){
        if(users.getSize() <= 0){
            System.out.println("Não há usuários cadastrados!");
            return;
        }

        users.listarUsuarios();

        try{
            System.out.println("\nQual o ID do usuário?");
            int idUser = in.nextInt();

            if(users.verificarSeTemItens(idUser)){
                System.out.println("Usuário não tem itens emprestados!");
                return;
            }

            users.listarItensEmprestados(idUser);

            System.out.println("\nQual o ID do item?");
            try{
                int idItem = in.nextInt();
                int id = users.devolverItem(idUser, idItem, rel);
                bib.devolverItem(id);
                System.out.println("Item devolvido com sucesso!");
            }catch(Exception e){
                System.out.println("Opção inválida!");
            }
        }catch(Exception e){
            System.out.println("Opção inválida!");
        }
    }

    public static void pesquisarItens(){
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
                busca = in.nextLine();
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
		} while (escolha != 0);
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
			System.out.println("0 -- Voltar");
            try{
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
                case 0:
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
                }
            }catch(Exception e){
                System.out.println("Opção inválida!");
                in.next();
                escolha = -1;
            }
		} while (escolha != 0);
	}

    public static void editarItem(){
        bib.listarItems();
        System.out.println("Digite o ID do item que deseja editar: ");
        int escolha = in.nextInt();

        bib.editarItem(escolha);
    }

    public static void AddTests() {
		bib.addTeses("As Sombras do Amanhã", "Cecília Meireles", 2021, 7);
		bib.addTeses("Mares de Tempo", "Fabio", 2020, 6);
		bib.addTeses("Ecos da Verdade", "Clarice", 2018, 5);

		bib.addRevista("Ondas de Calmaria", "Machado de Assis", 2018, 4);
		bib.addRevista("Reflexos do Futuro", "Lygia Fagundes Telles", 2020, 6);
		bib.addRevista("Além das Estrelas", "Carlos Drummond de Andrade", 1968, 8);

		bib.addDVD("Sinfonia da Nova Era", "Manuel Bandeira", 1998, 7);
		bib.addDVD("Fragmentos de Uma Vida", "Hilda Hilst", 2021, 10);
		bib.addDVD("Labirintos da Memória", "Jorge Amado", 2009, 12);

		bib.addCD("Sombras da Noite", "50 Pesos", 2007, 14);
		bib.addCD("Espelhos Distantes", "Jay-A", 1996, 2);
		bib.addCD("O Rio do Esquecimento", "Charlie Brown Sr.", 2000, 6);

		bib.addLivro("Horizontes Perdidos", "Loki", 1552, 3);
		bib.addLivro("O Voo da Serpente", "Odin", 1358, 3);
		bib.addLivro("Véus do Amanhecer", "Thor", 859, 1);
	}

    public static void AddTestsUser(){
        users.cadastrarUsuario("Marcos");
        users.cadastrarUsuario("Maria");
        users.cadastrarUsuario("Luiz");
    }
}