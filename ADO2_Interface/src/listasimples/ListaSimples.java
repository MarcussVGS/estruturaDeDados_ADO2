package listasimples;
//@author marcus.vgsampaio

public class ListaSimples {
    
    private No inicio;
    
    public ListaSimples(){
        this.inicio = null;
               
    }
    
    public boolean insere(double valor){
        if (listaVazia()) {return inserePrimeiroNo(valor);}
        return insereFinalLista(valor);
        
    }
    public boolean insere(double valor, int pos){
        if (listaVazia()) {return inserePrimeiroNo(valor);}
        if(pos == 0){return insereInicioLista(valor);}
        if(pos == tamanhoLista()){return insereFinalLista(valor);}
        return insereMeioLista(valor, pos);
    } 
    
    public boolean remove (){
        if (listaVazia()){
            return false; }
        if (this.inicio.getProx() == null){
            return removeUnicoLista(); }        
        return removeUltimoLista();        
    }
    
    public boolean remove (int pos){
        if (listaVazia()) {
            return false; }
        No aux = buscaNo(pos);
        if ((pos >0) || (pos < tamanhoLista()-1)){ // remove se o elemento esta no meio
            return removeMeioLista(pos); }
        if (aux == this.inicio && aux.getProx() == null){ // remove se o elemento for unico
            return removeUnicoLista();
        }
        if (aux == this.inicio){ // remove se o elemento se é o primeiro
            return removePrimeiroLista();
        }
        if (aux.getProx() == null){ // remove se o elemento se é o ultimo
            return removeUltimoLista();
        }
        else{ return false; } // retorna falso se a pos não existe
    }
    
    public No get(){
        return buscaNo(0);
    }
    
    public No get(int pos){
        return buscaNo(pos);
    }
    
    public String print(){
        if (listaVazia()) return "lista vazia";
         
        No aux = this.inicio;
        String temp = "" + aux.getValor() + " " ;
        while(aux.getProx()!= null){
        aux = aux.getProx();
        temp = temp + aux.getValor() +" ";
             
        }         
        return temp;
    }
    
    public boolean listaVazia(){
        return (this.inicio == null);
        
    }
    
    public int tamanhoLista(){
        if (listaVazia()){ return 0;}
        
        int tamanho = 1;
        No aux = this.inicio;
        while(aux.getProx()!= null){
            tamanho++;
            aux = aux.getProx();
        }
        return tamanho;
    }
    
    public No buscaNo(int pos){
        if ( (pos < 0 ) || (pos >= tamanhoLista()) ) {
            return null;  }
        No aux = this.inicio;
            for (int i = 1; i < pos; i++) {
                aux = aux.getProx();
            }
            return aux;
    }
    
    public boolean inserePrimeiroNo(double valor){
       if (!listaVazia()){return false;}
     
       No aux = new No(valor);
       this.inicio = aux;
       return true;     
    }
    
    public boolean insereInicioLista(double valor){
        if(listaVazia()){
            inserePrimeiroNo(valor);
            return true;
        }
        
        No aux = new No(valor);
        aux.setProx(this.inicio);
        this.inicio = aux;
        return true; 
    }
    
    public boolean insereFinalLista(double valor){
        if (listaVazia()){
            inserePrimeiroNo(valor);
            return true;
        }
        
        No aux = new No(valor);
        localizaUltimo().setProx(aux);
        return true;
    }
    
    public boolean insereMeioLista(double valor, int pos){
        if ((pos < 1) || (pos >= tamanhoLista())){
            return false;
            
        }
        
        No aux = buscaNo(pos);
        No aux1 = new No(valor);
        aux1.setProx(aux.getProx());
        aux.setProx(aux1);
        return true;
        
    }
    
    public boolean removeUnicoLista(){
        if (listaVazia()){
            return false;
        }
        
        No aux = this.inicio;
        if (aux.getProx() == null){
            aux = null;
            this.inicio = null;
            System.gc();
            return true;
        }
        return false;        
    }
    
    public boolean removePrimeiroLista(){
        if (listaVazia()){
            return false;
        }
        No aux = this.inicio;
        No aux2 = aux.getProx();
        
        this.inicio = aux2;
        aux = null;
        System.gc();
        return true;
    }
    
    public boolean removeUltimoLista(){
        if (listaVazia()){
            return false;
        }
        
        No aux = this.inicio;
        for (int i = 1; i < tamanhoLista() - 1; i++){
        aux = aux.getProx();
        }
        No aux2 = aux.getProx();
        
        aux.setProx(null);
        aux2 = null;
        System.gc();
        return true;
        
    }
    
    public boolean removeMeioLista(int pos){
        if ((pos <0) || (pos > tamanhoLista()-1)){
        return false;
    }
        No aux = buscaNo(pos);
        No aux2 = aux.getProx();
        aux.setProx(aux2.getProx());
        aux2 = null;
        System.gc();
        return true;
    }    
    
    
    
    public No localizaUltimo(){
        if (listaVazia()) return null;
         
        No aux = this.inicio;
        while(aux.getProx()!= null){
            aux = aux.getProx();
        }         
        return aux;
    }
        
}
