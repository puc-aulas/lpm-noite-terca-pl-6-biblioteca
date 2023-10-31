package Biblioteca;

public class Item {
	int ID = 0;
	String titulo;
	String autor;
	int ano;
	String tipo;
	int quantidade;

	public Item(int id, String Title, String Author, int Year, String Type, int Quantity) {
		this.ID = id;
		this.titulo = Title;
		this.autor = Author;
		this.ano = Year;
		this.tipo = Type;
		this.quantidade = Quantity;
	}

	// Getters
	public int getID() {
		return this.ID;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public String getAutor() {
		return this.autor;
	}

	public int getAno() {
		return this.ano;
	}

	public String getTipo() {
		return this.tipo;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	// Setters

	public void setTitulo(String Title) {
		this.titulo = Title;
	}

	public void setAutor(String Author) {
		this.autor = Author;
	}

	public void setAno(int Year) {
		this.ano = Year;
	}

	public void setTipo(String Type) {
		this.tipo = Type;
	}

	public void setQuantidade(int Quantity) {
		this.quantidade = Quantity;
	}

	public void addQuantidade(int Quantity) {
		this.quantidade += Quantity;
	}

	public void subQuantidade(int Quantity) {
		this.quantidade -= Quantity;
	}

	public void printItem() {
		System.out.println("\nID: " + this.ID + ", Titulo: " + this.titulo + ", Autor: " + this.autor + ", Ano: " + this.ano
				+ ", Tipo: " + this.tipo + ", Quantidade: " + this.quantidade);
	}
}
