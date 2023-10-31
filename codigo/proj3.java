
import java.util.List;
import java.util.Scanner;

import Biblioteca.Biblioteca;
import Biblioteca.Item;
import Usuarios.ControladorUser;

public class proj3 {
	// public Tese(String Title, String Author, int Year, int Quantity)

	private static Biblioteca bib = new Biblioteca();
	private static ControladorUser users = new ControladorUser();
	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
		int escolha;
		do {
			mostrarMenuPrincipal();
			escolha = in.nextInt();
			processarEscolhaPrincipal(escolha);
		} while (escolha != 0);

		in.close();
	}

	private static void mostrarMenuPrincipal() {
		System.out.println("\nMenu da Biblioteca");
		System.out.println("Selecione uma das opções abaixo: \n");
		System.out.println("1 -- Popular o Banco com os testes");
		System.out.println("2 -- Visualizar todos os itens da biblioteca");
		System.out.println("3 -- Listar itens em ordem");
		System.out.println("4 -- Gerenciar usuários");
		System.out.println("5 -- Editar itens cadastrados");
		System.out.println("6 -- Empréstimos");
		System.out.println("7 -- Devoluções");
		System.out.println("0 -- Sair");
	}

	private static void processarEscolhaPrincipal(int escolha) {
		switch (escolha) {
		case 1:
			AddTests(bib);
			break;
		case 2:
			bib.listarTodos();
			break;
		case 3:
			listarDadosOrdenados();
			break;
		case 4:
			gerenciarUsuarios();
			break;
		case 5:
			editarItens();
			break;
		case 6:
		case 7:
			System.out.println("A ser implementado!");
			break;
		case 0:
			System.out.println("Encerrando o sistema...");
			break;
		default:
			System.out.println("Opção inválida!");
			break;
		}
	}

	private static void listarDadosOrdenados() {
		int escolha;
		do {
			System.out.println("De qual a forma que deseja ordenar?\n");
			System.out.println("1 -- Título");
			System.out.println("2 -- Autor");
			System.out.println("3 -- Ano");
			System.out.println("4 -- Tipo");
			System.out.println("5 -- Listar Itens de um somente tipo");
			System.out.println("0 -- Voltar");
			escolha = in.nextInt();
			switch (escolha) {
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
				listarItensPorTipo();
				break;
			case 0:
				return;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		} while (escolha != 0);
	}

	private static void listarItensPorTipo() {

		int escolhaTipo;
		do {
			System.out.println("Qual o tipo que deseja listar?\n");
			System.out.println("1 -- Tese");
			System.out.println("2 -- Revista");
			System.out.println("3 -- DVD");
			System.out.println("4 -- CD");
			System.out.println("5 -- Livro");
			System.out.println("0 -- Voltar");
			escolhaTipo = in.nextInt();
			switch (escolhaTipo) {
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
			case 0:
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		} while (escolhaTipo != 0);
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
			escolha = in.nextInt();
			switch (escolha) {
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
			case 0:
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		} while (escolha != 0);
	}

	private static void editarItens() {
		int escolha;
		do {
			System.out.println("\nGerenciamento de itens da Biblioteca");
			System.out.println("Selecione uma das opções abaixo: \n");
			System.out.println("1 -- Cadastrar novos exemplares dos itens existentes");
			System.out.println("2 -- Editar exemplares cadastrados");
			System.out.println("3 -- Excluir exemplar cadastrado");
			System.out.println("0 -- Voltar");
			escolha = in.nextInt();
			switch (escolha) {
			case 1:
				cadastrarNovosExemplares();
				break;
			case 2:
				editarExemplaresCadastrados();
				break;
			case 3:
				excluirExemplarCadastrado();
				break;
			case 0:
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
		} while (escolha != 0);
	}

	private static void cadastrarNovosExemplares() {
		in.nextLine();
		String titulo = validaTituloDaObra();
		String autor = validaAutorDaObra();
		int ano = validaAnoDaObra();
		int quantidade = validaQtdDeExemplares();

		int tipo;
		System.out.println("Selecione o tipo de item para adicionar:");
		System.out.println("1 -- Tese");
		System.out.println("2 -- Revista");
		System.out.println("3 -- DVD");
		System.out.println("4 -- CD");
		System.out.println("5 -- Livro");
		System.out.println("0 -- Cancelar");
		tipo = in.nextInt();
		switch (tipo) {
		case 1:
			bib.addTeses(genID(), titulo, autor, ano, quantidade);
			break;
		case 2:
			bib.addRevista(genID(), titulo, autor, ano, quantidade);
			break;
		case 3:
			bib.addDVD(genID(), titulo, autor, ano, quantidade);
			break;
		case 4:
			bib.addCD(genID(), titulo, autor, ano, quantidade);
			break;
		case 5:
			bib.addLivro(genID(), titulo, autor, ano, quantidade);
			break;
		case 0:
			break;
		default:
			System.out.println("Opção inválida!");
			break;
		}

	}

	public static String validaTituloDaObra() {
		System.out.println("Digite o título do item:");
		String titulo = in.nextLine();
		while (!titulo.matches("[a-zA-Z\\s]+")) {
			System.out.println("Título inválido. Digite novamente (apenas letras e espaços):");
			titulo = in.nextLine();
		}
		return titulo;
	}

	public static String validaAutorDaObra() {
		System.out.println("Digite o autor do item:");
		String autor = in.nextLine();
		while (!autor.matches("[a-zA-Z\\s]+")) {
			System.out.println("Autor inválido. Digite novamente (apenas letras e espaços):");
			autor = in.nextLine();
		}
		return autor;
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

	public static int validaQtdDeExemplares() {
		System.out.println("Digite a quantidade de exemplares a serem adicionados:");
		int quantidade = in.nextInt();
		while (quantidade <= 0) {
			System.out.println("Quantidade inválida. Digite um número maior que zero:");
			quantidade = in.nextInt();
		}
		return quantidade;
	}

	private static void editarExemplaresCadastrados() {
	    int op;
	    do {
	        System.out.println("\nSelecione o tipo de item para editar:");
	        System.out.println("1 -- Tese");
	        System.out.println("2 -- Revista");
	        System.out.println("3 -- DVD");
	        System.out.println("4 -- CD");
	        System.out.println("5 -- Livro");
	        System.out.println("0 -- Cancelar");
	        op = in.nextInt();
	        in.nextLine();  

	        List<? extends Item> lista = null;

	        switch (op) {
	            case 1:
	                lista = bib.getTeses();
	                break;
	            case 2:
	                lista = bib.getRevistas();
	                break;
	            case 3:
	                lista = bib.getDVDs();
	                break;
	            case 4:
	                lista = bib.getCDs();
	                break;
	            case 5:
	                lista = bib.getLivros();
	                break;
	            case 0:
	                return; 
	            default:
	                System.out.println("Opção inválida!");
	                break;
	        }

	        if (lista != null && !lista.isEmpty()) {
	            for (Item item : lista) {
	                item.printItem();
	            }

	            System.out.println("Digite o ID do item que deseja Editar:");
	            int id = in.nextInt();
	            in.nextLine();  

	            Item itemParaEditar = lista.stream().filter(item -> item.getID() == id).findFirst().orElse(null);

	            if (itemParaEditar != null) {
	                editarItem(itemParaEditar);
	                op = 0;
	            } else {
	                System.out.println("ID não encontrado.");
	            }
	        } else {
	            System.out.println("Não há itens cadastrados neste tipo.");
	        }

	    } while (op != 0);
	}

	private static void editarItem(Item itemParaEditar) {
	    System.out.println("Editando o item: ");
	    itemParaEditar.printItem(); 
	    System.out.println();
	    
	    System.out.println("Digite o novo título (ou deixe em branco para não alterar):");
	    String titulo = in.nextLine();
	    if (!titulo.trim().isEmpty()) {
	        itemParaEditar.setTitulo(titulo);
	    }

	    System.out.println("Digite o novo autor (ou deixe em branco para não alterar):");
	    String autor = in.nextLine();
	    if (!autor.trim().isEmpty()) {
	        itemParaEditar.setAutor(autor);
	    }

	    System.out.println("Digite o novo ano (ou digite 0 para não alterar):");
	    int ano = in.nextInt();
	    if (ano != 0) {
	        itemParaEditar.setAno(ano);
	    }
	    in.nextLine(); 

	    System.out.println("Digite a nova quantidade (ou digite 0 para não alterar):");
	    int quantidade = in.nextInt();
	    if (quantidade != 0) {
	        itemParaEditar.setQuantidade(quantidade);
	    }
	    System.out.println("Editado com sucesso!\n");
	    itemParaEditar.printItem();
	    System.out.println();
	    in.nextLine();
	}
	  
	
	
	private static void excluirExemplarCadastrado() {
		int op;
		do {
			System.out.println("Selecione o tipo de item para editar:");
			System.out.println("1 -- Tese");
			System.out.println("2 -- Revista");
			System.out.println("3 -- DVD");
			System.out.println("4 -- CD");
			System.out.println("5 -- Livro");
			System.out.println("0 -- Cancelar");
			op = in.nextInt();
			in.nextLine(); 

			List<? extends Item> lista = null;
			boolean itemRemovido = false;

			switch (op) {
			case 1:
				lista = bib.getTeses();
				break;
			case 2:
				lista = bib.getRevistas();
				break;
			case 3:
				lista = bib.getDVDs();
				break;
			case 4:
				lista = bib.getCDs();
				break;
			case 5:
				lista = bib.getLivros();
				break;
			case 0:
				break;
			default:
				System.out.println("Opção inválida!");
				break;
			}
			if (lista != null) {
	            if (lista.isEmpty()) {
	                System.out.println("Não há itens cadastrados neste tipo.");
	                break;
	            }

	            for (Item item : lista) {
	                item.printItem();
	            }

	            System.out.println("Digite o ID do item que deseja excluir:");
	            int id = in.nextInt();
	            in.nextLine(); 

	            Item itemParaRemover = lista.stream().filter(item -> item.getID() == id).findFirst().orElse(null);

	            if (itemParaRemover != null) {
	                itemParaRemover.printItem();
	                System.out.println("Tem certeza de que deseja excluir este item? (sim/nao)");
	                String resposta = in.nextLine();

	                if (resposta.equalsIgnoreCase("sim")) {
	                    lista.remove(itemParaRemover);
	                    System.out.println("Item excluído com sucesso.");
	                    itemRemovido = true;
	                } else {
	                    System.out.println("Ação de exclusão cancelada.");
	                }
	            } else {
	                System.out.println("ID não encontrado.");
	            }
	        }

	        if (itemRemovido) {
	            break; 
	        }

	    } while (op != 0);
	}

	public static Biblioteca AddTests(Biblioteca bib) {
		bib.addTeses(genID(), "As Sombras do Amanhã", "Cecília Meireles", 2021, 7);
		bib.addTeses(genID(), "Mares de Tempo", "Fabio", 2020, 6);
		bib.addTeses(genID(), "Ecos da Verdade", "Clarice", 2018, 5);

		bib.addRevista(genID(), "Ondas de Calmaria", "Machado de Assis", 2018, 4);
		bib.addRevista(genID(), "Reflexos do Futuro", "Lygia Fagundes Telles", 2020, 6);
		bib.addRevista(genID(), "Além das Estrelas", "Carlos Drummond de Andrade", 1968, 8);

		bib.addDVD(genID(), "Sinfonia da Nova Era", "Manuel Bandeira", 1998, 7);
		bib.addDVD(genID(), "Fragmentos de Uma Vida", "Hilda Hilst", 2021, 10);
		bib.addDVD(genID(), "Labirintos da Memória", "Jorge Amado", 2009, 12);

		bib.addCD(genID(), "Sombras da Noite", "50 Pesos", 2007, 14);
		bib.addCD(genID(), "Espelhos Distantes", "Jay-A", 1996, 2);
		bib.addCD(genID(), "O Rio do Esquecimento", "Charlie Brown Sr.", 2000, 6);

		bib.addLivro(genID(), "Horizontes Perdidos", "Loki", 1552, 10);
		bib.addLivro(genID(), "O Voo da Serpente", "Odin", 1358, 5);
		bib.addLivro(genID(), "Véus do Amanhecer", "Thor", 859, 1);

		return bib;
	}

	private static int userCounter = 1;

	public static int genUserID() {
		return userCounter++;
	}

	private static int idCounter = 1;

	public static int genID() {
		return idCounter++;
	}
}
