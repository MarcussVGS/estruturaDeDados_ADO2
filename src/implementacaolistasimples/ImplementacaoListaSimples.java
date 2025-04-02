package implementacaolistasimples;
import listadupla.*;
import listasimples.*;
import listaestatica.*;
import lista.*;
//@author marcus.vgsampaio

public class ImplementacaoListaSimples {

    public static void main(String[] args) {
       
        ListaSimples ls = new ListaSimples();
        
        
        ls.insere(15);
        ls.insere(12);
        ls.insere(60, 0);
        ls.insere(30, ls.tamanhoLista());
        ls.insere(99, 1);
        
        System.out.println(ls.tamanhoLista());
        System.out.println(ls.print());
        
        System.out.println("");
        System.out.println(ls.get());
        
        
        
        
        
        
    }
    
}
