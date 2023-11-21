package usuario;

import java.time.LocalDate ;
import java.util.ArrayList;
import java.util.List;

import biblioteca.Item;


public class Usuario implements IUsuario{
    private String nome;
    private int contadorItens;
    private List<Emprestimo> itensEmprestados; 
    private int interesse;
    private int curso;
    private List<Item> Historico;

    //Construtor
    public Usuario(String nome, int interesse, int curso) {
        this.nome = nome;
        this.contadorItens = 0;
        this.itensEmprestados = new ArrayList<>();
        this.curso = curso;
        this.interesse = interesse;
        this.Historico = new ArrayList<>();
    }

    //Construtor Vázio
    public Usuario() {
        this.nome = "";
        this.contadorItens = 0;
        this.itensEmprestados = new ArrayList<>();
        this.curso = 0;
        this.interesse = 0;
        this.Historico = new ArrayList<>();
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

    public void setInteresse(int interesse) {
        this.interesse = interesse;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public void setHistorico(List<Item> Historico) {
        this.Historico = Historico;
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

    public int getInteresse() {
        return this.interesse;
    }

    public int getCurso() {
        return this.curso;
    }

    public List<Item> getHistorico() {
        return this.Historico;
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
        System.out.println("Nome: " + this.nome + ", Curso: " + Curso(this.curso) + ", Interesse: " + Curso(this.interesse) + ", Quantidade de itens emprestados: " + this.contadorItens);
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
        this.Historico.add(item);
    }   
    
    //Verifica se tem algum item em atraso
    public boolean verificarAtraso() {
        LocalDate now = LocalDate.now();
        for (Emprestimo itensEmprestado : this.itensEmprestados) {
            LocalDate dataEmprestimo = itensEmprestado.getDataEmprestimo();
            if (dataEmprestimo.plusDays(10).isBefore(now)) {
                return false; //Existe item em atraso
            }
        }
        return true; //Nenhum item está em atraso
    }

    public String Curso(int id){
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
