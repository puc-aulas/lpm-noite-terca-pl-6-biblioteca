  package recomendacao;

import java.util.ArrayList;
import java.util.List;

import biblioteca.Biblioteca;
import usuario.Usuario;

public class recomendacao {
    public recomendacao() {}

    private int[] CategoriaInteresse = new int[6];

    public void recomendar(Usuario user, Biblioteca biblioteca) {
        List<Integer> ordemDeRecomendacao = new ArrayList<>();

        for(int i = 0; i < user.getHistorico().size(); i++){
            if(user.getHistorico().get(i).getCategoria() == 1){
                CategoriaInteresse[1]++;
            }else if(user.getHistorico().get(i).getCategoria() == 2){
                CategoriaInteresse[2]++;
            }else if(user.getHistorico().get(i).getCategoria() == 3){
                CategoriaInteresse[3]++;
            }else if(user.getHistorico().get(i).getCategoria() == 4){
                CategoriaInteresse[4]++;
            }else if(user.getHistorico().get(i).getCategoria() == 5){
                CategoriaInteresse[5]++;
            }else{
                CategoriaInteresse[0]++;
            }
        }

        CategoriaInteresse[user.getInteresse()] += 3; //Aumenta o peso na area de interesse por 3
        CategoriaInteresse[user.getCurso()] += 2; //Aumenta o peso na area do curso por 2

        //Listar categoria com os seus pesos
        System.out.println("\nCategorias com seus pesos: ");
        for(int i = 0; i < CategoriaInteresse.length; i++){
            System.out.println(AreaTranslate(i) + ": " + CategoriaInteresse[i]);
        }

        ordemDeRecomendacao = Ordenar(CategoriaInteresse);

        //Listar a ordem de recomendação
        System.out.println("Ordem de Recomendação: ");
        for(int i = 0; i < ordemDeRecomendacao.size(); i++){
            System.out.println((i+1) + " - " + AreaTranslate(ordemDeRecomendacao.get(i)));
        }


        //Listar os itens de acordo com a ordem de recomendação
        System.out.println("\nItens Recomendados: ");
        for(int i = 0; i < ordemDeRecomendacao.size(); i++){
            if(ordemDeRecomendacao.get(i) == 0){
                biblioteca.listarItensCategoria(6);
            }else{
                biblioteca.listarItensCategoria(ordemDeRecomendacao.get(i));
            }

            if(i == 2) break; //Listar somente 3 dos itens recomendados.
        }
    }

    public ArrayList<Integer> Ordenar(int[] CategoriaInteresse){
        ArrayList<Integer> ordemDeRecomendacao = new ArrayList<>();
        int maior = 0;
        int posicao = 0;

        for(int i = 0; i < CategoriaInteresse.length; i++){
            for(int j = 0; j < CategoriaInteresse.length; j++){
                if(CategoriaInteresse[j] > maior){
                    maior = CategoriaInteresse[j];
                    posicao = j;
                }
            }
            ordemDeRecomendacao.add(posicao);
            CategoriaInteresse[posicao] = -1;
            maior = -1;
        }

        return ordemDeRecomendacao;
    }

    public String AreaTranslate(int id){
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
