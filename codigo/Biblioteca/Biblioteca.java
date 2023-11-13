package Biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Biblioteca {
    List<Item> itens = new ArrayList<Item>();


    public int getSize(){
        return itens.size();
    }

    public Item pegarEmprestado(int i){
        Item item = itens.get(i);
		item.subQuantidade(1);
		System.out.println("Quantidade: " + item.getQuantidade());
        return item;
    }

    public void addTeses(String Title, String Author, int Year, int Quantity) {
        itens.add(new Tese(Title, Author, Year, Quantity));
		System.out.println("\nTese cadastrada com sucesso!");
	}

	public void addRevista(String Title, String Author, int Year, int Quantity) {
		itens.add(new Revista(Title, Author, Year, Quantity));
		System.out.println("\nRevista cadastrada com sucesso");
	}

	public void addDVD(String Title, String Author, int Year, int Quantity) {
		itens.add(new DVD(Title, Author, Year, Quantity, 0));
		System.out.println("\nDVD cadastrado com sucesso");
	}

	public void addCD(String Title, String Author, int Year, int Quantity) {
        itens.add(new CD(Title, Author, Year, Quantity, 0));
		System.out.println("\nCD Cadastrado com Sucesso!");
	}

	public void addLivro(String Titulo, String Author, int Year, int Quantity) {
        itens.add(new Livro(Titulo, Author, Year, Quantity, 0));
	    System.out.println("\nLivro Cadastrado com Sucesso!");
	}

    public void listarItems(){
        for(int i = 0; i < itens.size(); i++){
            System.out.print("ID: " + i + ", ");
            itens.get(i).printItem();
        }
    }

	public Item get(int index){
		return itens.get(index);
	}

    // Ordenar os Items pelo titulo
	public void listarTitulo(String busca) {
		List<Item> Items = new ArrayList<>();
		Items = itens;
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

    public void listarAutor(String busca) {
		List<Item> Items = new ArrayList<>();
		Items = itens;
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

		Items = itens;
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

		Items = itens;

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

    public void listarEmprestavel(){
        for(int i = 0; i < itens.size(); i++){
            if(itens.get(i) instanceof DVD){
                System.out.print("ID: " + i + ", ");
                itens.get(i).printItem();
            }else if(itens.get(i) instanceof CD){
                System.out.print("ID: " + i + ", ");
                itens.get(i).printItem();
            }else if(itens.get(i) instanceof Livro){
                System.out.print("ID: " + i + ", ");
                itens.get(i).printItem();
            }
        }
    }

    public int emprestavel(int i){
        if(itens.get(i).getQuantidade() > 1){
            if(itens.get(i) instanceof DVD){
                return 1;
            }else if(itens.get(i) instanceof CD){
                return 1;
            }else if(itens.get(i) instanceof Livro){
                return 1;
            }
        }
        return 0;
    }

    public void devolverItem(int i){
        itens.get(i).setQuantidade(itens.get(i).getQuantidade() + 1);
    }

	public void editarItem(int id){
		Scanner in = new Scanner(System.in);

		if(itens.get(id) instanceof DVD){
			System.out.println("Digite o Titulo do DVD: ");
			String titulo = in.nextLine();

			System.out.println("Digite o autor do DVD: ");
			String autor = in.nextLine();

			System.out.println("Digite o ano que o DVD lançou: ");
			int ano = in.nextInt();

			System.out.println("Digite a quantidade de DVDs: ");
			int quantidade = in.nextInt();

			DVD item = (DVD) itens.get(id);
			DVD dvd = new DVD(titulo, autor, ano, quantidade, item.getEmprestado());

			itens.set(id, dvd);
		}else if(itens.get(id) instanceof CD){
			System.out.println("Digite o Titulo do CD: ");
			String titulo = in.nextLine();

			System.out.println("Digite o autor do CD: ");
			String autor = in.nextLine();

			System.out.println("Digite o ano que o CD lançou: ");
			int ano = in.nextInt();

			System.out.println("Digite a quantidade de CDs: ");
			int quantidade = in.nextInt();

			CD item = (CD) itens.get(id);
			CD cd = new CD(titulo, autor, ano, quantidade, item.getEmprestado());


			itens.set(id, cd);
		}else if(itens.get(id) instanceof Livro){
			System.out.println("Digite o Titulo do Livro: ");
			String titulo = in.nextLine();

			System.out.println("Digite o autor do Livro: ");
			String autor = in.nextLine();

			System.out.println("Digite o ano que o Livro lançou: ");
			int ano = in.nextInt();

			System.out.println("Digite a quantidade de Livros: ");
			int quantidade = in.nextInt();

			Livro item = (Livro) itens.get(id);
			Livro Livro = new Livro(titulo, autor, ano, quantidade, item.getEmprestado());

			itens.set(id, Livro);
		}
		else if(itens.get(id) instanceof Tese){
			System.out.println("Digite o Titulo do Tese: ");
			String titulo = in.nextLine();

			System.out.println("Digite o autor do Tese: ");
			String autor = in.nextLine();

			System.out.println("Digite o ano que o Tese lançou: ");
			int ano = in.nextInt();

			System.out.println("Digite a quantidade de Tese: ");
			int quantidade = in.nextInt();

			Tese Tese = new Tese(titulo, autor, ano, quantidade);
			itens.set(id, Tese);
		}
		else if(itens.get(id) instanceof Revista){
			System.out.println("Digite o Titulo do Revista: ");
			String titulo = in.nextLine();

			System.out.println("Digite o autor do Revista: ");
			String autor = in.nextLine();

			System.out.println("Digite o ano que o Revista lançou: ");
			int ano = in.nextInt();

			System.out.println("Digite a quantidade de Revistas: ");
			int quantidade = in.nextInt();

			Revista Revista = new Revista(titulo, autor, ano, quantidade);
			itens.set(id, Revista);
		}
	}
}
