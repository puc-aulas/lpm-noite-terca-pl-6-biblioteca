package Biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Biblioteca implements IPesquisavel {

	List<Tese> teses = new ArrayList<>();
	List<Revista> revistas = new ArrayList<>();
	List<DVD> DVDs = new ArrayList<>();
	List<CD> CDs = new ArrayList<>();
	List<Livro> livros = new ArrayList<>();
	List<Item> Items = new ArrayList<>();

	// Cadastrar Teses na Bibilioteca
	public void addTeses(int id, String Title, String Author, int Year, int Quantity) {
		getTeses().add(new Tese(id, Title, Author, Year, Quantity));
		System.out.println("\nTese cadastrada com sucesso!");
	}

	// Cadastrar Revistas na Biblioteca
	public void addRevista(int id, String Title, String Author, int Year, int Quantity) {
		getRevistas().add(new Revista(id, Title, Author, Year, Quantity));
		System.out.println("\nRevista cadastrada com sucesso");
	}

	// Cadastrar DVDs na Biblioteca
	public void addDVD(int id, String Title, String Author, int Year, int Quantity) {
		getDVDs().add(new DVD(id, Title, Author, Year, Quantity, 0));
		System.out.println("\nDVD cadastrado com sucesso");
	}

	// Cadastrar CDs na Biblioteca
	public void addCD(int id, String Title, String Author, int Year, int Quantity) {
		getCDs().add(new CD(id, Title, Author, Year, Quantity, 0));
		System.out.println("\nDVD cadastrado com sucesso");
	}

	// Cadastrar Livros na Biblioteca
	public void addLivro(int id, String Titulo, String Author, int Year, int Quantity) {
		getLivros().add(new Livro(id, Titulo, Author, Year, Quantity, 0));
		System.out.println("\nLivro Cadastrado com Sucesso!");
	}

	public Biblioteca() {
	}

	public Item pegarLivroEmprestado(int idEmp) {
		for (Item a : Items) {
			if (a.getID() == idEmp) {
				a.subQuantidade(1);
				return a;
			}
		}
		return null;
	}

	public boolean podeSerEmprestado(int IdEmp) {
		for (Item a : Items) {
			if (a.getID() == IdEmp) {
				if (a.getQuantidade() <= 1) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean validaIdLivro(int idEmp) {
		for (Item a : Items) {
			if (a.getID() == idEmp && a.getTipo().toUpperCase().equals("LIVRO")) {
				return true;
			}
		}
		return false;
	}
	
	public boolean validaIdDVD(int idEmp) {
		for (Item a : Items) {
			if (a.getID() == idEmp) {
				if (a.getTipo().equals("DVD")) {
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean validaIdCd(int idEmp) {
		for (Item a : Items) {
			if (a.getID() == idEmp) {
				if (a.getTipo().equals("CD")) {
					return true;
				}
			}
		}
		return false;
	}
	

	public void listarTodos() {
		List<Item> Items = new ArrayList<>();

		Items = addTodos();

		for (int i = 0; i < Items.size(); i++) {
			Items.get(i).printItem();
		}
	}

	// Ordenar os Items pelo titulo
	public void listarTitulo(String busca) {
		List<Item> Items = new ArrayList<>();
		Items = addTodos();
		List<Item> result = new ArrayList<>();

		for (Item a : Items) {
			if (a.getTitulo().toUpperCase().contains(busca.toUpperCase())) {
				result.add(a);
			}
		}

		Collections.sort(result, new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				return o1.titulo.compareTo(o2.titulo);
			}
		});

		for (int i = 0; i < result.size(); i++) {
			result.get(i).printItem();
		}
	}

	// Ordenar os Items pelo Autor

	public void listarAutor(String busca) {
		List<Item> Items = new ArrayList<>();
		Items = addTodos();
		List<Item> result = new ArrayList<>();

		for (Item a : Items) {
			if (a.getAutor().toUpperCase().contains(busca.toUpperCase())) {
				result.add(a);
			}
		}

		Collections.sort(result, new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				return o1.titulo.compareTo(o2.titulo);
			}
		});

		for (int i = 0; i < result.size(); i++) {
			result.get(i).printItem();
		}
	}

	// Ordenar os Items pelo Ano

	public void listarAno(int ano) {
		List<Item> Items = new ArrayList<>();

		Items = addTodos();
		List<Item> result = new ArrayList<>();

		for (Item a : Items) {
			if (a.getAno() == ano) {
				result.add(a);
			}
		}

		Collections.sort(result, new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				return o1.titulo.compareTo(o2.titulo);
			}
		});

		for (int i = 0; i < result.size(); i++) {
			result.get(i).printItem();
		}
	}

	// Ordenar os Items pelo Tipo
	public void listarTipo() {
		List<Item> Items = new ArrayList<>();

		Items = addTodos();

		Collections.sort(Items, new Comparator<Item>() {
			@Override
			public int compare(Item o1, Item o2) {
				return o1.tipo.compareTo(o2.tipo);
			}
		});

		for (int i = 0; i < Items.size(); i++) {
			Items.get(i).printItem();
		}
	}

	// Listar somente Teses
	public void listarTese() {
		for (int i = 0; i < getTeses().size(); i++) {
			getTeses().get(i).printItem();
		}
	}

	// Listar somente Revistas
	public void listarRevista() {
		for (int i = 0; i < getRevistas().size(); i++) {
			getRevistas().get(i).printItem();
		}
	}

	// Listar somente DVDs
	public void listarDVD() {
		for (int i = 0; i < getDVDs().size(); i++) {
			getDVDs().get(i).printItem();
		}
	}

	// Listar somente CDs
	public void listarCD() {
		for (int i = 0; i < getCDs().size(); i++) {
			getCDs().get(i).printItem();
		}
	}

	// Listar somente Livros
	public void listarLivro() {
		for (int i = 0; i < getLivros().size(); i++) {
			getLivros().get(i).printItem();
		}
	}

	public List<Item> addTodos() {
		List<Item> Items = new ArrayList<>();

		for (int i = 0; i < getTeses().size(); i++) {
			Items.add(getTeses().get(i));
		}
		for (int i = 0; i < getRevistas().size(); i++) {
			Items.add(getRevistas().get(i));
		}
		for (int i = 0; i < getDVDs().size(); i++) {
			Items.add(getDVDs().get(i));
		}
		for (int i = 0; i < getCDs().size(); i++) {
			Items.add(getCDs().get(i));
		}
		for (int i = 0; i < getLivros().size(); i++) {
			Items.add(getLivros().get(i));
		}

		return Items;
	}

	public List<Tese> getTeses() {
		return teses;
	}

	public List<Revista> getRevistas() {
		return revistas;
	}

	public List<DVD> getDVDs() {
		return DVDs;
	}

	public List<CD> getCDs() {
		return CDs;
	}

	public List<Livro> getLivros() {
		return livros;
	}
}
