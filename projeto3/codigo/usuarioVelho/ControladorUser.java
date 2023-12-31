package usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import biblioteca.Item;

public class ControladorUser {
    final List<Usuario> users;

    public ControladorUser() {
		users = new ArrayList<>();
	}

    public int getSize(){
        return users.size();
    }

	public void cadastrarUsuario(String nome) {
		Usuario user = new Usuario(nome);
		users.add(user);
	}

    public void listarUsuarios() {
        for(int i = 0; i < users.size(); i++){
            System.out.print("ID: " + i + ", ");
            users.get(i).printUsuario();
        }
    }

    public void cadastrarUser() {
		Scanner in = new Scanner(System.in);
        
        try{
            System.out.println("\nQual o nome do usuário?");
            String nome = in.nextLine();
            System.out.println("Usuário Cadastrado com sucesso!\n");
            cadastrarUsuario(nome);
        }catch(Exception e){
            System.out.println("Erro ao cadastrar usuário!");
        }
		
	}

    public boolean verificarSeTemItens(int i){
        if(users.get(i).getContadorItens() <= 0){
            System.out.println("Não há itens emprestado!");
            users.get(i).printUsuario();
            return true;
        }else{
            return false;
        }
        //return true;
    }

    public void listarItensEmprestados(int id){
        for(int i = 0; i < users.get(id).getContadorItens(); i++){
            System.out.print("ID: " + i + ", ");
            users.get(id).getItensEmprestados().get(i).printEmprestimo();
        }
    }

    public int devolverItem(int idUser, int idItem){
        int id = users.get(idUser).getItensEmprestados().get(idItem).getIdItem();
        users.get(idUser).getItensEmprestados().remove(idItem);
        users.get(idUser).setContadorItens(users.get(idUser).getContadorItens() - 1);
        
        return id;
    }

    public void removeUser() {
        Scanner in = new Scanner(System.in);

        if(users.isEmpty()){
            System.out.println("Não há usuários cadastrados!");
            return;
        }

        try{
            listarUsuarios();
            System.out.println("\nQual o ID do usuário?");
            int id = in.nextInt();
            users.remove(id);
            System.out.println("Usuário removido com sucesso!\n");
        }catch(Exception e){
            System.out.println("Erro ao remover usuário!");
        }
    }

    public void atualizarUsuario(){
        Scanner in = new Scanner(System.in);

        if(users.isEmpty()){
            System.out.println("Não há usuários cadastrados!");
            return;
        }

        try{
            listarUsuarios();
            System.out.println("\nQual o ID do usuário?");
            int id = in.nextInt();
            System.out.println("Qual o novo nome do usuário?");
            String nome = in.nextLine();
            users.get(id).setNome(nome);
            System.out.println("Usuário atualizado com sucesso!\n");
        }catch(Exception e){
            System.out.println("Erro ao atualizar usuário!");
        }
    }

    public boolean verificarEmprestar(int id, Item item){
        int amount = users.get(id).getItensEmprestados().size();

        List<Emprestimo> items2 = users.get(id).getItensEmprestados();

        for (Emprestimo emprestimo : items2) {
            if (emprestimo.getItem() == item) {
                System.out.println("Já tem esse item emprestado!");
                return false;
            }
        }

        if(amount < 3){
            return users.get(id).verificarAtraso();
        }else{
            return false;
        }
    }

    public void pegarEmprestado(int id, Item item, int idItem){
        users.get(id).pegarEmprestado(item, idItem);
    }
}
