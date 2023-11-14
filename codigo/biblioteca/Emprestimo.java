package biblioteca;

public class Emprestimo {

    private final String nome;
    private final String obra;
    private final int idLivro;
    private final int userID;

    public Emprestimo(String nome, String obra, int idLivro, int userID) {
        this.nome = nome;
        this.obra = obra;
        this.idLivro = idLivro;
        this.userID = userID;
    }

    public void printItem() {
        System.out.println("Emprestimo{" +
                "nome='" + nome + '\'' +
                ", obra='" + obra + '\'' +
                ", idLivro=" + idLivro +
                ", userID=" + userID +
                '}');
    }
}
