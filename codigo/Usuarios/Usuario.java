package Usuarios;

import Biblioteca.Item;

public class Usuario implements IUsuario {
	private int ID;
	private String nome;
	private int contadorItens;
	private Item[] itensEmprestados;

	public Usuario() {
		this.ID = 0;
		this.nome = "";
		this.contadorItens = 0;
		this.itensEmprestados = null;
	}

	// Getters
	public int getID() {
		return this.ID;
	}

	public String getNome() {
		return this.nome;
	}

	public int getContadorItens() {
		return this.contadorItens;
	}

	public Item[] getItensEmprestados() {
		return this.itensEmprestados;
	}

	public Usuario(int ID, String nome, int contadorItens, Item[] itensEmprestados) {
		this.ID = ID;
		this.nome = nome;
		this.contadorItens = contadorItens;
		this.itensEmprestados = itensEmprestados;
	}

	public void cadastrarUsuario(int ID, String nome, int contadorItens) {
		this.ID = ID;
		this.nome = nome;
		this.contadorItens = contadorItens;
		this.itensEmprestados = null;
	}

	public Usuario removerUsuario(Usuario usuario) {
		usuario.ID = 0;
		usuario.nome = "";
		usuario.contadorItens = 0;
		usuario.itensEmprestados = null;

		return usuario;
	}

	public Usuario atualizarUsuario(int ID, String nome, int contadorItens, Item[] itensEmprestados) {
		this.ID = ID;
		this.nome = nome;
		this.contadorItens = contadorItens;
		this.itensEmprestados = itensEmprestados;

		return this;
	}

	public void listarUsuario() {
		System.out.println("\nID: " + this.ID + ", Nome: " + this.nome + ", Quantidade de itens emprestados: " + this.contadorItens);
		System.out.println("Itens Emprestados: ");
		if (this.itensEmprestados == null) {
			System.out.println("Nenhum item emprestado");
		} else {
			for (int i = 0; i < (this.itensEmprestados).length; i++) {
				this.itensEmprestados[i].printItem();
			}
		}
	}

	public void pegarEmprestado(int ID, Item item) {
		this.itensEmprestados[this.contadorItens] = item;
		contEmp();
	}
	
	private void contEmp() {
		this.contadorItens ++;
	}

	public void devolver(int ID, Item item) {
		for (int i = 0; i < (this.itensEmprestados).length; i++) {
			if (this.itensEmprestados[i].getID() == item.getID()) {
				this.itensEmprestados[i] = null;
				this.contadorItens--;
			}
		}
	}
}
