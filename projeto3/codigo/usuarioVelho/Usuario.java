package usuario;

import java.time.LocalDate ;
import java.util.ArrayList;
import java.util.List;

import biblioteca.Item;


public class Usuario implements IUsuario{
    private String nome;
    private int contadorItens;
    private List<Emprestimo> itensEmprestados; 

    //Construtor
    public Usuario(String nome) {
        this.nome = nome;
        this.contadorItens = 0;
        this.itensEmprestados = new ArrayList<>();
    }

    //Construtor Vázio
    public Usuario() {
        this.nome = "";
        this.contadorItens = 0;
        this.itensEmprestados = new ArrayList<>();
    }

    //Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setContadorItens(int contadorItens) {
        this.contadorItens = contadorItens;
    }

    public void setItensEmprestados(List<Emprestimo> itensEmprestados) {
        this.itensEmprestados = itensEmprestados;
    }

    //Getters
    public String getNome() {
        return this.nome;
    }

    public int getContadorItens() {
        return this.contadorItens;
    }

    public List<Emprestimo> getItensEmprestados() {
        return this.itensEmprestados;
    }

    public void cadastrarUsuario(String nome) {
        this.nome = nome;
        this.itensEmprestados = new ArrayList<>(); 
        this.contadorItens = 0;
    }

    public Usuario removerUsuario(Usuario usuario) {
		usuario.nome = "";
		usuario.contadorItens = 0;
		usuario.itensEmprestados.clear();

		return usuario;
	}

    public Usuario atualizarUsuario(String nome) {
        this.nome = nome;

        return this;
    }

    public void printUsuario() {
        System.out.println("Nome: " + this.nome + ", Quantidade de itens emprestados: " + this.contadorItens);
        System.out.println("Itens Emprestados: ");
        if (this.itensEmprestados.isEmpty()) {
            System.out.println("Nenhum item emprestado");
        } else {
            this.itensEmprestados.forEach(Emprestimo::printEmprestimo);
        }
    }

    public void pegarEmprestado(Item item, int idItem) {
        LocalDate dataEmprestimo = LocalDate.now();
        Emprestimo emprestimo = new Emprestimo(dataEmprestimo, item, idItem);
        this.itensEmprestados.add(emprestimo);
        this.contadorItens++;
    }   
    
    //Verifica se tem algum item em atraso
    public boolean verificarAtraso() {
        LocalDate now = LocalDate.now();
        for (Emprestimo itensEmprestado : this.itensEmprestados) {
            LocalDate dataEmprestimo = itensEmprestado.getDataEmprestimo();
            if (dataEmprestimo.plusDays(10).isBefore(now)) {
                return false; // Existe item em atraso
            }
        }
        return true; // Nenhum item está em atraso
    }

}
