package Usuarios;

import java.util.ArrayList;
import java.util.List;

import Biblioteca.Item;

public class Usuario implements IUsuario {
    private int ID;
    private String nome;
    private int contadorItens;
    private List<Item> itensEmprestados; 

    public Usuario(int id, String nome) {
        this.ID = id;
        this.nome = nome;
        this.contadorItens = 0;
        this.itensEmprestados = new ArrayList<>();
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
        return this.itensEmprestados.toArray(new Item[0]); 
    }

    public Usuario(int ID, String nome, List<Item> itensEmprestados) {
        this.ID = ID;
        this.nome = nome;
        this.itensEmprestados = itensEmprestados;
        this.contadorItens = 0;
    }

    public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public void cadastrarUsuario(int ID, String nome) {
        this.ID = ID;
        this.nome = nome;
        this.itensEmprestados = new ArrayList<>(); 
        this.contadorItens = 0;
    }

	public Usuario removerUsuario(Usuario usuario) {
		usuario.ID = 0;
		usuario.nome = "";
		usuario.contadorItens = 0;
		usuario.itensEmprestados.clear();

		return usuario;
	}

    public Usuario atualizarUsuario(int ID, String nome, List<Item> itensEmprestados) {
        this.ID = ID;
        this.nome = nome;
        this.itensEmprestados = itensEmprestados;
        this.contadorItens = itensEmprestados.size();

        return this;
    }

    public void listarUsuario() {
        System.out.println("\nID: " + this.ID + ", Nome: " + this.nome + ", Quantidade de itens emprestados: " + this.contadorItens);
        System.out.println("Itens Emprestados: ");
        if (this.itensEmprestados == null) {
            System.out.println("Nenhum item emprestado");
        } else {
            for (Item item : this.itensEmprestados) {
                item.printItem();
            }
        }
    }

    public void pegarEmprestado(Item item) {
    	 this.contadorItens += 1;
        if (this.itensEmprestados == null) {
            this.itensEmprestados = new ArrayList<>();
        }
        this.itensEmprestados.add(item);
    }
    

    public void devolver(Item item) {
        this.itensEmprestados.removeIf(i -> i.getID() == item.getID());
        this.contadorItens --;
    }

	public void printItem() {
		System.out.println("Nome: "+ nome + " Id: "+ ID );
		
	}



}
