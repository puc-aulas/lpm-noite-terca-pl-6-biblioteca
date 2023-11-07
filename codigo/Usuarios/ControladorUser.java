package Usuarios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Biblioteca.Item;

public class ControladorUser {
	List<Usuario> users;

	public ControladorUser() {
		users = new ArrayList<>();
	}

	public void cadastrarUsuario(int id, String nome) {
		Usuario user = new Usuario(id, nome);
		users.add(user);
	}

	public void cadastrarUser(int id) {
		Scanner in = new Scanner(System.in);

		System.out.println("\nQual o nome do usuário?");
		String nome = in.nextLine();
		System.out.println("Usuário Cadastrado com sucesso!\n");
		cadastrarUsuario(id, nome);
	}

	public void removeUser() {
		Scanner in = new Scanner(System.in);
		boolean itemRemovido = false;
		listarUsers();
		int id;
		if (users != null) {
			if (users.isEmpty()) {
				System.out.println("Não há itens cadastrados neste tipo.");
				return;
			}
			
			do {
				System.out.println("\nQual o id do usuario?");
				id = in.nextInt();
			} while (vaidaId(id));
			
			int op = id;
			Usuario userParaRemover = users.stream().filter(item -> item.getID() == op).findFirst().orElse(null);
			Usuario user = new Usuario();
			
			if (userParaRemover != null) {
				userParaRemover.printItem();
				System.out.println("Tem certeza de que deseja excluir este item? (sim/nao)");
				String resposta = in.nextLine();

				if (resposta.equalsIgnoreCase("sim")) {
					users.remove(userParaRemover);
					System.out.println("Item excluído com sucesso.");
					itemRemovido = true;
				} else {
					System.out.println("Ação de exclusão cancelada.");
				}
			} else {
				System.out.println("ID não encontrado.");
			}

			users.set(id, user);
		}
	}

	public void listarUsers() {
		for (int i = 0; i < users.size(); i++) {
			users.get(i).listarUsuario();
		}
	}

	public void atualizarUser() {
		Scanner in = new Scanner(System.in);
		listarUsers();
		System.out.println("\nQual o id do usuario que deseja atualizar?");
		int id = in.nextInt();
		id--;

		if (id < 0 || id >= users.size()) {
			System.out.println("Usuario não encontrado");
			return;
		}

		Usuario user = users.get(id);
		System.out.println("\nQual o novo nome do usuario?");
		in.nextLine();
		String nome = in.nextLine();

		user.atualizarUsuario(user.getID(), nome, Arrays.asList(user.getItensEmprestados()));
		users.set(id, user);
	}

	public boolean vaidaId(int idUser) {
		for (Usuario a : users) {
			if (a.getID() == idUser) {
				return true;
			}
		}
		return false;
	}

	public String getNomeByID(int id) {
		for (Usuario a : users) {
			if (a.getID() == id) {
				return a.getNome();
			}
		}
		return null;
	}

	public boolean podePegarEmprestado(int idUser) {
		for (Usuario a : users) {
			if (a.getID() == idUser) {
				if (a.getContadorItens() < 3) {
					return true;
				}
			}
		}
		return false;
	}
}
