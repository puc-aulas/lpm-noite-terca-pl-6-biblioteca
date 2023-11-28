import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import biblioteca.Biblioteca;
import biblioteca.Item;
import biblioteca.RelatorioEmprestimo;
import usuario.ControladorUser;
import recomendacao.recomendacao;

public class proj4GUI extends JFrame {
	private static final ControladorUser users = new ControladorUser();
	private static final Biblioteca bib = new Biblioteca();
	private static final RelatorioEmprestimo rel = new RelatorioEmprestimo();
	private static final recomendacao recom = new recomendacao();

	private JTextArea itemListTextArea; // Add this line

	public proj4GUI() {
		super("Biblioteca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 500);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		JButton pesquisarItensButton = new JButton("Pesquisar itens");
		JButton gerenciarUsuariosButton = new JButton("Gerenciar usuários");
		JButton cadastrarItensButton = new JButton("Cadastrar itens");
		JButton editarItensButton = new JButton("Editar itens cadastrados");
		JButton emprestarButton = new JButton("Menu Empréstimos");
		JButton devolverButton = new JButton("Menu Devoluções");
		JButton listarItensButton = new JButton("Visualizar todos os itens da biblioteca");
		JButton relatorioButton = new JButton("Visualizar o relatório da biblioteca");
		JButton sairButton = new JButton("Sair");

		pesquisarItensButton.addActionListener(e -> pesquisarItens());
		gerenciarUsuariosButton.addActionListener(e -> gerenciarUsuarios());
		cadastrarItensButton.addActionListener(e -> cadastrarItens());
		editarItensButton.addActionListener(e -> editarItem());
		emprestarButton.addActionListener(e -> emprestar());
		devolverButton.addActionListener(e -> devolver());
		listarItensButton.addActionListener(e -> bib.listarItems(itemListTextArea));
		relatorioButton.addActionListener(e -> rel.printRelatorio());
		sairButton.addActionListener(e -> System.exit(0));

		add(pesquisarItensButton);
		add(gerenciarUsuariosButton);
		add(cadastrarItensButton);
		add(editarItensButton);
		add(emprestarButton);
		add(devolverButton);
		add(listarItensButton);
		add(relatorioButton);
		add(sairButton);

		setVisible(true);

		itemListTextArea = new JTextArea();
		itemListTextArea.setEditable(false); // Make it non-editable
		JScrollPane scrollPane = new JScrollPane(itemListTextArea);
		add(scrollPane);
	}

	private void pesquisarItens() {
		int escolha;
		String busca;

		do {
			escolha = Integer.parseInt(JOptionPane.showInputDialog(
					"O que deseja Buscar?\n" + "1 -- Título\n" + "2 -- Autor\n" + "3 -- Ano\n" + "0 -- Voltar"));

			switch (escolha) {
			case 1:
				busca = validaString("Qual o título da obra?");
				itemListTextArea.setText("");
				itemListTextArea.append("Melhores resultados para a busca por título " + busca + "\n");
				bib.listarTitulo(busca, itemListTextArea);
				break;
			case 2:
				busca = validaString("Qual o autor da obra?");
				itemListTextArea.setText("");
				itemListTextArea.append("Melhores resultados para a busca por autor " + busca + "\n");
				bib.listarAutor(busca, itemListTextArea);
				break;
			case 3:
				int ano = validaAnoDaObra("Digite o ano de publicação:");
				itemListTextArea.setText("");
				itemListTextArea.append("Obras do ano: \"" + ano + "\"\n");
				bib.listarAno(ano, itemListTextArea);
				break;
			case 0:
				return;
			default:
				JOptionPane.showMessageDialog(this, "Opção inválida!");
				break;
			}
		} while (true);
	}

	private String validaString(String mensagem) {
		String input;
		do {
			input = JOptionPane.showInputDialog(mensagem);
		} while (input == null || input.trim().isEmpty());

		return input;
	}

	private int validaAnoDaObra(String mensagem) {
		int ano;
		do {
			try {
				ano = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
			} catch (NumberFormatException e) {
				ano = -1;
			}
		} while (ano < 0);

		return ano;
	}

	private int validaQuantidadeDaObra(String mensagem) {
		int quantidade;
		do {
			try {
				quantidade = Integer.parseInt(JOptionPane.showInputDialog(mensagem));
			} catch (NumberFormatException e) {
				quantidade = -1;
			}
		} while (quantidade < 0);

		return quantidade;
	}

	private void cadastrarItens() {
		int escolha;

		String titulo = validaString("Qual o título da obra?");
		itemListTextArea.setText("");
		String autor = validaString("Qual o autor da obra?");
		itemListTextArea.setText("");
		int ano = validaAnoDaObra("Digite o ano de publicação:");
		itemListTextArea.setText("");
		int quantidade = validaQuantidadeDaObra("Digite a quantidade de exemplares");
		int categoria = Integer.parseInt(JOptionPane.showInputDialog("Qual a categoria da Obra?" + "\n1 -- Engenharia"
				+ "\n2 -- Software" + "\n3 -- Matemática" + "\n4 -- Física" + "\n5 -- Medicina" + "\n6 -- Outros"));

		
			escolha = Integer.parseInt(JOptionPane.showInputDialog("O que deseja Cadastrar?\n" + "1 -- Tese\n"
					+ "2 -- Livro\n" + "3 -- Revista\n" + "4 -- CD" + "5 -- DVD"));
			switch (escolha) {
			case 1:
				bib.addTeses(titulo, autor, ano, quantidade, categoria);
				break;
			case 2:
				bib.addLivro(titulo, autor, ano, quantidade, categoria);
				break;
			case 3:
				bib.addRevista(titulo, autor, ano, quantidade, categoria);
				break;
			case 4:
				bib.addCD(titulo, autor, ano, quantidade, categoria);
				break;
			case 5:
				bib.addDVD(titulo, autor, ano, quantidade, categoria);
				break;
			case 0:
				break;
			default:
				JOptionPane.showMessageDialog(this, "Opção inválida!");
				break;

			}

		

	}

	private void gerenciarUsuarios() {
		int escolha;

		do {
			escolha = Integer.parseInt(JOptionPane.showInputDialog(
					"Gerenciamento de usuários\n" + "Selecione uma das opções abaixo: \n" + "1 -- Cadastrar Usuário\n"
							+ "2 -- Remover Usuário\n" + "3 -- Atualizar Usuário\n" + "4 -- Listar Usuário\n"
							+ "5 -- Recommendação de itens\n" + "6 -- Listar Historico\n" + "0 -- Voltar"));

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
				JOptionPane.showMessageDialog(this, "Opção inválida!");
				break;
			}
		} while (escolha != 0);
	}

	private void recomendarItem() {
		if (users.getSize() <= 0) {
			JOptionPane.showMessageDialog(this, "Não há usuários cadastrados!");
			return;
		}

		users.listarUsuarios();

		try {
			int idUser = Integer.parseInt(JOptionPane.showInputDialog("Qual o ID do usuário?"));
			recom.recomendar(users.getUser(idUser), bib);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Opção inválida!");
		}
	}

	private void listarHistorico() {
		if (users.getSize() <= 0) {
			JOptionPane.showMessageDialog(this, "Não há usuários cadastrados!");
			return;
		}

		users.listarUsuarios();

		try {
			int idUser = Integer.parseInt(JOptionPane.showInputDialog("Qual o ID do usuário?"));
			users.listarHistorico(idUser);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Opção inválida!");
		}
	}

	private void editarItem() {
		bib.listarItems(itemListTextArea);
		try {
			int escolha = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do item que deseja editar: "));
			bib.editarItem(escolha);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Opção inválida!");
		}
	}

	private void emprestar() {
		if (bib.getSize() <= 0) {
			JOptionPane.showMessageDialog(this, "Não há itens cadastrados!");
			return;
		}

		do {
			bib.listarEmprestavel(itemListTextArea);
			try {
				int id = Integer.parseInt(JOptionPane.showInputDialog("Qual o ID do item?"));
				int emprestavel = bib.emprestavel(id);

				while (emprestavel == 0) {
					JOptionPane.showMessageDialog(this, "Item não pode ser emprestado!");
					id = Integer.parseInt(JOptionPane.showInputDialog("Qual o ID do item?"));
					emprestavel = bib.emprestavel(id);
				}

				if (users.getSize() <= 0) {
					JOptionPane.showMessageDialog(this, "Não há usuários cadastrados!");
					return;
				}

				users.listarUsuarios();

				int idUser = Integer.parseInt(JOptionPane.showInputDialog("Qual o ID do usuário?"));

				if (users.verificarEmprestar(idUser, bib.get(id))) {
					Item item = bib.pegarEmprestado(id);
					users.pegarEmprestado(idUser, item, id);
					rel.addItem(item);
					JOptionPane.showMessageDialog(this, "Item emprestado com sucesso!");
				} else {
					JOptionPane.showMessageDialog(this,
							"Usuário não pode pegar mais itens emprestados ou tem itens com atrasos!");
				}
				return;

			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Usuário inválido!");
			}
		} while (true);
	}

	private void devolver() {
		if (users.getSize() <= 0) {
			JOptionPane.showMessageDialog(this, "Não há usuários cadastrados!");
			return;
		}

		users.listarUsuarios();

		try {
			int idUser = Integer.parseInt(JOptionPane.showInputDialog("Qual o ID do usuário?"));

			if (users.verificarSeTemItens(idUser)) {
				JOptionPane.showMessageDialog(this, "Usuário não tem itens emprestados!");
				return;
			}

			users.listarItensEmprestados(idUser);

			try {
				int idItem = Integer.parseInt(JOptionPane.showInputDialog("Qual o ID do item?"));
				int id = users.devolverItem(idUser, idItem);
				bib.devolverItem(id);
				JOptionPane.showMessageDialog(this, "Item devolvido com sucesso!");
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Opção inválida!");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Opção inválida!");
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new proj4GUI());
		AddTests();
		AddTestsUser();
	}

	public static void AddTests() {
		bib.addTeses("Tese 1", "Autor 1", 2020, 3, 1); // Engenharia
		bib.addTeses("Tese 2", "Autor 2", 2021, 2, 2); // Software
		bib.addTeses("Tese 3", "Autor 3", 2019, 4, 3); // Matemática
		bib.addTeses("Tese 4", "Autor 4", 2022, 1, 4); // Física
		bib.addTeses("Tese 5", "Autor 5", 2018, 5, 5); // Medicina
		bib.addTeses("Tese 6", "Autor 6", 2023, 2, 6); // Outros

		bib.addRevista("Revista 1", "Autor 1", 2019, 2, 1); // Engenharia
		bib.addRevista("Revista 2", "Autor 2", 2020, 3, 2); // Software
		bib.addRevista("Revista 3", "Autor 3", 2021, 1, 3); // Matemática
		bib.addRevista("Revista 4", "Autor 4", 2022, 4, 4); // Física
		bib.addRevista("Revista 5", "Autor 5", 2023, 2, 5); // Medicina
		bib.addRevista("Revista 6", "Autor 6", 2018, 3, 6); // Outros

		bib.addDVD("DVD 1", "Autor 1", 2020, 1, 1); // Engenharia
		bib.addDVD("DVD 2", "Autor 2", 2019, 2, 2); // Software
		bib.addDVD("DVD 3", "Autor 3", 2021, 3, 3); // Matemática
		bib.addDVD("DVD 4", "Autor 4", 2018, 4, 4); // Física
		bib.addDVD("DVD 5", "Autor 5", 2022, 2, 5); // Medicina
		bib.addDVD("DVD 6", "Autor 6", 2023, 1, 6); // Outros

		bib.addCD("CD 1", "Autor 1", 2022, 3, 1); // Engenharia
		bib.addCD("CD 2", "Autor 2", 2020, 2, 2); // Software
		bib.addCD("CD 3", "Autor 3", 2019, 1, 3); // Matemática
		bib.addCD("CD 4", "Autor 4", 2021, 4, 4); // Física
		bib.addCD("CD 5", "Autor 5", 2018, 2, 5); // Medicina
		bib.addCD("CD 6", "Autor 6", 2023, 5, 6); // Outros

		bib.addLivro("Livro 1", "Autor 1", 2019, 4, 1); // Engenharia
		bib.addLivro("Livro 2", "Autor 2", 2020, 3, 2); // Software
		bib.addLivro("Livro 3", "Autor 3", 2021, 2, 3); // Matemática
		bib.addLivro("Livro 4", "Autor 4", 2018, 1, 4); // Física
		bib.addLivro("Livro 5", "Autor 5", 2022, 5, 5); // Medicina
		bib.addLivro("Livro 6", "Autor 6", 2023, 2, 6); // Outros
	}

	public static void AddTestsUser() {
		users.cadastrarUsuario("Marcos", 1, 1);
		users.cadastrarUsuario("Maria", 1, 2);
		users.cadastrarUsuario("Luiz", 4, 3);
	}
}
