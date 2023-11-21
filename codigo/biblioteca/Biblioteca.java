package biblioteca;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.util.Comparator.comparing;

public class Biblioteca {
    final List<Item> itens = new ArrayList<>();


    public int getSize() {
        return itens.size();
    }

    public Item pegarEmprestado(int i) {
        Item item = itens.get(i);
        item.subQuantidade(1);
        System.out.println("Quantidade: " + item.getQuantidade());
        return item;
    }

    public void addTeses(String Title, String Author, int Year, int Quantity, int categoria) {
        itens.add(new Tese(Title, Author, Year, Quantity, categoria));
        System.out.println("\nTese cadastrada com sucesso!");
    }

    public void addRevista(String Title, String Author, int Year, int Quantity, int categoria) {
        itens.add(new Revista(Title, Author, Year, Quantity, categoria));
        System.out.println("\nRevista cadastrada com sucesso");
    }

    public void addDVD(String Title, String Author, int Year, int Quantity, int categoria) {
        itens.add(new DVD(Title, Author, Year, Quantity, 0, categoria));
        System.out.println("\nDVD cadastrado com sucesso");
    }

    public void addCD(String Title, String Author, int Year, int Quantity, int categoria) {
        itens.add(new CD(Title, Author, Year, Quantity, 0, categoria));
        System.out.println("\nCD Cadastrado com Sucesso!");
    }

    public void addLivro(String Titulo, String Author, int Year, int Quantity, int categoria) {
        itens.add(new Livro(Titulo, Author, Year, Quantity, 0, categoria));
        System.out.println("\nLivro Cadastrado com Sucesso!");
    }

    public void listarItems() {
        for (int i = 0; i < itens.size(); i++) {
            System.out.print("ID: " + i + ", ");
            itens.get(i).printItem();
        }
    }

    public Item get(int index) {
        return itens.get(index);
    }

    // Ordenar os Items pelo titulo
    public void listarTitulo(String busca) {
        List<Item> result = new ArrayList<>();

        for (Item a : itens) {
            if (a.getTitulo().toUpperCase().contains(busca.toUpperCase())) {
                result.add(a);
            }
        }

        result.sort(comparing(Item::getTitulo));

        for (Item item : result) {
            item.printItem();
        }
    }

    public void listarAutor(String busca) {
        List<Item> result = new ArrayList<>();

        for (Item a : itens) {
            if (a.getAutor().toUpperCase().contains(busca.toUpperCase())) {
                result.add(a);
            }
        }

        result.sort(comparing(Item::getTitulo));

        for (Item item : result) {
            item.printItem();
        }
    }

    // Ordenar os Items pelo Ano
    public void listarAno(int ano) {
        List<Item> result = new ArrayList<>();

        for (Item a : itens) {
            if (a.getAno() == ano) {
                result.add(a);
            }
        }
        result.sort(comparing(Item::getTitulo));

        for (Item item : result) {
            item.printItem();
        }
    }

    public void listarEmprestavel() {
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i) instanceof DVD) {
                System.out.print("ID: " + i + ", ");
                itens.get(i).printItem();
            } else if (itens.get(i) instanceof CD) {
                System.out.print("ID: " + i + ", ");
                itens.get(i).printItem();
            } else if (itens.get(i) instanceof Livro) {
                System.out.print("ID: " + i + ", ");
                itens.get(i).printItem();
            }
        }
    }

    public int emprestavel(int i) {
        if (itens.get(i).getQuantidade() > 1) {
            if (itens.get(i) instanceof DVD) {
                return 1;
            } else if (itens.get(i) instanceof CD) {
                return 1;
            } else if (itens.get(i) instanceof Livro) {
                return 1;
            }
        }
        return 0;
    }

    public void devolverItem(int i) {
        itens.get(i).setQuantidade(itens.get(i).getQuantidade() + 1);
    }

    public void editarItem(int id) {
        Scanner in = new Scanner(System.in);

        if (itens.get(id) instanceof DVD) {
            System.out.println("Digite o Titulo do DVD: ");
            String titulo = in.nextLine();

            System.out.println("Digite o autor do DVD: ");
            String autor = in.nextLine();

            System.out.println("Digite o ano que o DVD lançou: ");
            int ano = in.nextInt();

            System.out.println("Digite a quantidade de DVDs: ");
            int quantidade = in.nextInt();

            ListarCategoria();
            System.out.println("Qual a categoria do DVD?");
            int categoria = in.nextInt();

            DVD item = (DVD) itens.get(id);
            DVD dvd = new DVD(titulo, autor, ano, quantidade, item.getEmprestado(), categoria);

            itens.set(id, dvd);
        } else if (itens.get(id) instanceof CD) {
            System.out.println("Digite o Titulo do CD: ");
            String titulo = in.nextLine();

            System.out.println("Digite o autor do CD: ");
            String autor = in.nextLine();

            System.out.println("Digite o ano que o CD lançou: ");
            int ano = in.nextInt();

            System.out.println("Digite a quantidade de CDs: ");
            int quantidade = in.nextInt();

            ListarCategoria();
            System.out.println("Qual a categoria do CD?");
            int categoria = in.nextInt();

            CD item = (CD) itens.get(id);
            CD cd = new CD(titulo, autor, ano, quantidade, item.getEmprestado(), categoria);


            itens.set(id, cd);
        } else if (itens.get(id) instanceof Livro) {
            System.out.println("Digite o Titulo do Livro: ");
            String titulo = in.nextLine();

            System.out.println("Digite o autor do Livro: ");
            String autor = in.nextLine();

            System.out.println("Digite o ano que o Livro lançou: ");
            int ano = in.nextInt();

            System.out.println("Digite a quantidade de Livros: ");
            int quantidade = in.nextInt();

            ListarCategoria();
            System.out.println("Qual a categoria do Livro?");
            int categoria = in.nextInt();

            Livro item = (Livro) itens.get(id);
            Livro Livro = new Livro(titulo, autor, ano, quantidade, item.getEmprestado(), categoria);

            itens.set(id, Livro);
        } else if (itens.get(id) instanceof Tese) {
            System.out.println("Digite o Titulo do Tese: ");
            String titulo = in.nextLine();

            System.out.println("Digite o autor do Tese: ");
            String autor = in.nextLine();

            System.out.println("Digite o ano que o Tese lançou: ");
            int ano = in.nextInt();

            System.out.println("Digite a quantidade de Tese: ");
            int quantidade = in.nextInt();

            ListarCategoria();
            System.out.println("Qual a categoria da Tese?");
            int categoria = in.nextInt();

            Tese Tese = new Tese(titulo, autor, ano, quantidade, categoria);
            itens.set(id, Tese);
        } else if (itens.get(id) instanceof Revista) {
            System.out.println("Digite o Titulo do Revista: ");
            String titulo = in.nextLine();

            System.out.println("Digite o autor do Revista: ");
            String autor = in.nextLine();

            System.out.println("Digite o ano que o Revista lançou: ");
            int ano = in.nextInt();

            System.out.println("Digite a quantidade de Revistas: ");
            int quantidade = in.nextInt();

            ListarCategoria();
            System.out.println("Qual a categoria da Revista?");
            int categoria = in.nextInt();

            Revista Revista = new Revista(titulo, autor, ano, quantidade, categoria);
            itens.set(id, Revista);
        }
    }

    public void listarItensCategoria(int categoria) {
        for (int i = 0; i < itens.size(); i++) {
            if (itens.get(i).getCategoria() == categoria) {
                System.out.print("ID: " + i + ", ");
                itens.get(i).printItem();
            }
        }
    }

    public void ListarCategoria(){
        System.out.println("1 - Engenharia");
        System.out.println("2 - Software");
        System.out.println("3 - Matemática");
        System.out.println("4 - Física");
        System.out.println("5 - Medicina");
        System.out.println("6 - Outros");
    }
}
