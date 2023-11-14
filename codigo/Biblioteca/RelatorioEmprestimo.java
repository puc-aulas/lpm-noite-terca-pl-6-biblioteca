package Biblioteca;

import java.util.*;

public class RelatorioEmprestimo{
    List<Item> relatorio;

    public RelatorioEmprestimo(){
        relatorio = new ArrayList<>();;
    }

    public void addItem(Item item){
        this.relatorio.add(item);
    }

    public void removerRelatorio(Item item){
        int index = relatorio.indexOf(item);
        Item tempItem = relatorio.get(index);
        if(tempItem.getQuantidade() == 1){
            relatorio.remove(index);
        }else{
            int quant = tempItem.getQuantidade();
            quant--;
            tempItem.setQuantidade(quant);
            this.relatorio.set(index, tempItem);
        }
    }

    public void printRelatorio(){
        if(relatorio.size() == 0) System.out.println("Relatorio Vazio");
        for(int i = 0; i < relatorio.size(); i++){
            System.out.print("ID: " + i + ", ");
            this.relatorio.get(i).printItem();
        }
    }
}