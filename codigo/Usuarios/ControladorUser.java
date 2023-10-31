package Usuarios;

import java.util.*;

public class ControladorUser {
	List<Usuario> users;

	public ControladorUser() {
		users = new ArrayList<>();
	}

	public void cadastrarUsuario(int id, String nome) {
		Usuario user = new Usuario(id, nome, 0, null);
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
		listarUsers();
		System.out.println("\nQual o id do usuario?");
		int id = in.nextInt();
		id--;

		Usuario user = new Usuario();

		users.set(id, user);
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
		try {
			if (id < 0 || id > users.size()) {
				System.out.println("Usuario não encontrado");
			} else {
				Usuario user = new Usuario();
				user = users.get(id);
				Scanner Nome = new Scanner(System.in);

				System.out.println("\nQual o novo nome do usuario?");
				String nome = Nome.nextLine();

				user = user.atualizarUsuario(user.getID(), nome, user.getContadorItens(), user.getItensEmprestados());

				users.set(id, user);
			}
		} catch (Exception e) {
			System.out.println("Usuario não encontrado");
		}
	}
}
