package biblioteca;

public class Item {
	String titulo;
	String autor;
	int ano;
	String tipo;
	int quantidade;
	int categoria;

	public Item(String Title, String Author, int Year, String Type, int Quantity, int categoria) {
		this.titulo = Title;
		this.autor = Author;
		this.ano = Year;
		this.tipo = Type.toUpperCase();
		this.quantidade = Quantity;
		this.categoria = categoria;
	}


	// Getters

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

	public int getCategoria(){
		return this.categoria;
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

	public void setCategoria(int categoria){
		this.categoria = categoria;
	}

	public void printItem() {
		System.out.println("Titulo: " + this.titulo + ", Autor: " + this.autor + ", Ano: " + this.ano
				+ ", Tipo: " + this.tipo + ", Quantidade: " + this.quantidade + ", Categoria: " + CategoriaName(this.categoria));
	}

	public String CategoriaName(int id){
		switch(id){
			case 1:
				return "Engenharia";
			case 2: 
				return "Software";
			case 3:
				return "Matemática";
			case 4:
				return "Física";
			case 5:
				return "Medicina";
			default:
				return "Outros";
		}
	}
}
