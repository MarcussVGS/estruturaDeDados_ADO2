package listasimples;
import lista.*;
//@author marcus.vgsampaio
public class ListaSimples implements Lista{
    
    private No inicio;
    
    public ListaSimples(){
        this.inicio = null;
    }
    
    @Override
    public boolean listaVazia(){
        return (this.inicio == null);
    }
    
    public boolean inserePrimeiroNo(double valor){
        if (!listaVazia()) {return false;}
        
        No aux = new No(valor);
        this.inicio = aux;
        return true;
    }
    
    public No localizaUltimo(){
        if (listaVazia()) return null;
        
        No aux = this.inicio;
        while(aux.getProx() != null){
            aux = aux.getProx();
        }
        return aux;
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
        if (listaVazia()) {
            inserePrimeiroNo(valor);
            return true;}
        
        No aux = new No(valor);
        localizaUltimo().setProx(aux);
        return true;   
    }
    
    public boolean insereInicioLista(double valor){
        if (listaVazia()) {
            inserePrimeiroNo(valor);
            return true;
        }
        
        No aux = new No(valor);
        aux.setProx(this.inicio);
        this.inicio = aux;
        return true;
    }
    
    public boolean insereMeioLista(double valor, int pos){
        if ((pos < 1) || (pos >= tamanhoLista())) {
            return false;
        }
        
        No aux = this.inicio;
        for (int i = 0; i < pos-1; i++){
            aux = aux.getProx();
        }
        No aux1 = new No(valor);
        aux1.setProx(aux.getProx());
        aux.setProx(aux1);
        return true;
    }

    @Override
    public boolean insere(double valor){
        if (listaVazia()) {return inserePrimeiroNo(valor);}
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
    
    public boolean removeInicioLista(){
        if (listaVazia()) return false;
        
        No aux = this.inicio;
        No temp = aux.getProx();
        this.inicio = temp;
        aux = null;
        System.gc();
        return true;
    }
    
    public boolean removeFinalLista(){
       if (listaVazia()) return false;
        
        No aux = this.inicio;
        No temp = aux;
        do{
            temp = aux;
            aux = aux.getProx() ;     
        }while(aux.getProx() != null);
            
        temp.setProx(null);
        aux = null;
        System.gc();
        
        return true;
    }
    
    public boolean removeMeioLista(int pos){
        if ((pos < 0) || (pos > tamanhoLista()-1)) {
            return false;}
        
        No aux = this.inicio;
        for(int i = 1; i < pos; i++){
            aux = aux.getProx();
        }
        No aux2 = aux.getProx();
        aux.setProx(aux2.getProx());
        aux2 = null;
        System.gc();
        return true;
    }
    
    public boolean removeUnicoLista(){
        if ( tamanhoLista() > 1){
            return false;
        }
        No aux = this.inicio;
        this.inicio = null;
        aux = null;
        System.gc();
        return true;
    }

    @Override
    public boolean remove() { // remove ultimo elemento
        if (tamanhoLista() == 1){
            removeUnicoLista();
        }
        return removeFinalLista();
    }

    @Override
    public boolean remove(int pos) {
        if ((pos < 0) || (pos > tamanhoLista()-1)) {
            return false;}
        if (pos == 0) {return removeInicioLista();}
        if (pos == tamanhoLista()) {return removeFinalLista();}
        return removeMeioLista(pos);
    }

    @Override
    public double get() {
        if ( listaVazia()){
            return -1;
        }
        double aux = this.inicio.getValor();
        return aux;
    }

    @Override
    public double get(int pos) {
        if ((pos < 0) || (pos > tamanhoLista()-1)) {
            return -1;}
        No aux = this.inicio;
        for(int i = 1; i <= pos; i++){
            aux = aux.getProx();
        }
        double valor = aux.getValor();
        return valor;
    }

    
    
}






