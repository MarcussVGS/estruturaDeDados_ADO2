
package ado2_interface;
import listasimples.*;

//@author Marcus Machine

public class Principal_ADO2_Interface {

    public static void main(String[] args) {
        
        ListaSimples ls = new ListaSimples();
        //ls.inserePrimeiroNo(15);
        //ls.insereFinalLista(12);
        //ls.insereInicioLista(60);
        //ls.insereMeioLista(100, 1);
        
        ls.insere(12);
        ls.insere(16);
        
        System.out.println(ls.tamanhoLista());
        System.out.println(ls.print());
        
             
        ls.removePrimeiroLista();
        System.out.println(ls.print());
       
        ls.removeMeioLista(3);
        System.out.println(ls.print());
        
        ls.removeUltimoLista();
        System.out.println(ls.print());
        
        ls.removeUnicoLista();
        System.out.println(ls.print());
    }
    
}
