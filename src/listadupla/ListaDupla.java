package listadupla;
import lista.*;
//@author marcus.vgsampaio
public class ListaDupla implements Lista{
    
    private No inicio;
    private No fim;
    
    public ListaDupla(){
        this.inicio = null;
        this.fim = null;
    }
    
    @Override
    public boolean listaVazia(){
        return ((this.inicio == null) && 
                (this.fim == null));
    }

     public boolean inserePrimeiroNo(double valor){
        if (!listaVazia()) return false;
        
        No aux = new No(valor);
        this.inicio = aux;
        this.fim = aux;
        return true;
    }
    
    @Override 
    public String print(){
        if (listaVazia()) return "lista vazia";
        
        No aux = this.inicio;
        String temp = "" + aux.getValor() + " ";
        while(aux.getProx() != null){
            aux = aux.getProx();
            temp = temp + aux.getValor() + " ";
        }
        return temp;
    }
    
    @Override
    public int tamanhoLista(){
        if (listaVazia()) {return 0;}
        
        int tamanho = 1;
        No aux = this.inicio;
        while(aux.getProx() != null){
            tamanho++;
            aux = aux.getProx();
        }
        return tamanho;
    }
    
    public boolean insereFinalLista(double valor){
        if (listaVazia()) return inserePrimeiroNo(valor);
        
        No aux = new No(valor);
        aux.setAnt(this.fim);
        this.fim.setProx(aux);
        this.fim = aux;
        return true;
    }
    
    public boolean insereInicioLista(double valor){
        if (listaVazia()) return inserePrimeiroNo(valor);
        
        No aux = new No(valor);
        aux.setProx(this.inicio);
        this.inicio.setAnt(aux);
        this.inicio = aux;
        return true;
    }
    
     public No buscaNo(int pos){
        if ((pos < 0) || (pos >= tamanhoLista())) {  return null;  }
        
        if (pos < tamanhoLista()/2 + 1){
            No aux = this.inicio;
            for (int i = 1; i <=pos; i++){ 
                aux = aux.getProx();  }
            return aux;
        }else {
            No aux = this.fim;
            for (int i = tamanhoLista()-1; i > pos; i--){ aux = aux.getAnt(); }
            return aux;
        }
    }
    
    public boolean insereMeioLista(double valor, int pos){
        if ((pos < 1) || (pos >= tamanhoLista())) {
            return false;
        }

        No anterior = buscaNo(pos-1);
        No novo = new No(valor);
        No proximo = anterior.getProx();

        novo.setProx(proximo);
        novo.setAnt(anterior);
        anterior.setProx(novo);
        proximo.setAnt(novo);
        return true;

    }


    public boolean removeMeioLista(int pos){
         if((pos < 0 )|| (pos >= tamanhoLista()-1)) { return false; }     
         
         No anterior = buscaNo(pos-1);
         No aux = anterior.getProx();
         No proximo = aux.getProx();
         
         anterior.setProx(proximo);
         proximo.setAnt(anterior);
         aux = null;
         System.gc();
         return true;
     }
         
     public boolean removeUnicoLista(){
         if (tamanhoLista() > 1) {return false; }
         No aux = this.inicio;
         this.inicio = null;
         this.fim = null;
         aux = null;
         System.gc();
         return true;
     }
     
     public boolean removeInicioLista(){
         if (tamanhoLista() <= 1) {return false; }
         
         No aux = this.inicio;
         this.inicio = aux.getProx();
         this.inicio.setAnt(null);
         aux = null;
         System.gc();
         return true;
     }
     
     public boolean removeFinalLista(){
         if (tamanhoLista() <= 1) {return false;}
         
         No aux = this.fim;
         this.fim = aux.getAnt();
         this.fim.setProx(null);
         aux = null;
         System.gc();
         return true;
         
     }

   @Override
    public boolean insere(double valor){
        if (listaVazia()) { return inserePrimeiroNo(valor);}
        return insereFinalLista(valor);
    }
    
    @Override
    public boolean insere(double valor, int pos){
        if ((pos < 0) || (pos > tamanhoLista()-1)) {
            return false;}
        if (pos == 0) {return insereInicioLista(valor);}
        if (pos == tamanhoLista()) {return insereFinalLista(valor);}
        return insereMeioLista(valor, pos);
        
    }

    @Override
    public boolean remove() {
        if (tamanhoLista() == 1){
            removeUnicoLista();
        }
        return removeFinalLista();
    }

    @Override
    public boolean remove(int pos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double get() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double get(int pos) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     

}
