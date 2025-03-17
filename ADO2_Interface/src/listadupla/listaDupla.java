package listadupla;
//@author marcus.vgsampaio

public class ListaDupla {
    
    private No inicio;
    private No fim;
    
    public ListaDupla(){
        this.inicio = null;
        this.fim = null;
    }
    
    public boolean listaVazia(){
        return ( (this.inicio == null) &&
                 (this.fim == null));
    }
    
    public String print(){        
        if (listaVazia())return "lista Vazia";
        
        No aux = this.inicio;
        String temp = " " + aux.getProx() + " ";
        
        while (aux.getProx() != null){
            aux = aux.getProx(); 
            temp = temp + " " + aux.getProx() + " ";
        }        
        return temp;
    }
    
    public int tamanhoLista(){
//        verifica se a lista esta vazia, se esta vazia é 0
        if (listaVazia()) return 0;
        
//        se não for, exite pelo menos m elemento na lista
        int tamanho  = 0;
        
        No aux = this.inicio;        
        while(aux.getProx() != null){ //vai contando ate o proximo ser NULL
            tamanho ++;
            aux = aux.getProx();
        }
        return tamanho;
    }
    
    public No buscaNo(int pos){
        if ( (pos < 0 ) || (pos >= tamanhoLista()) ) {
            return null;  }
        
        if (pos <= tamanhoLista()/2 + 1){
            No aux = this.inicio;
            for (int i = 1; i < pos; i++) {
                aux = aux.getProx();
            }
            return aux;
        } else{
            No aux = this.fim;
            for (int i = tamanhoLista()- 2; i > pos; i--) {
                aux = aux.getProx();
            }     
            return aux;
        }   
    }
    
    public boolean inserirPrimeiroNo(double valor){
        if (!listaVazia()){return false; }
        
        No aux = new No(valor);  
        this.inicio = aux;
        this.fim = aux;        
        return true;
    }
    
    public boolean insereInicioLista(double valor){
        if (listaVazia()){
            inserirPrimeiroNo(valor);
            return false; 
        }
        
        No aux = new No(valor);        
        aux.setProx(this.inicio);//definiu pro novo quem vem depois dele
        this.inicio.setAnt(aux); //definiu pro antigo quem vem antes dele
        this.inicio = aux;       //define o novo ponto de referencia
        return true;
    }
        
    public boolean insereFinalLista(double valor){
        if (listaVazia()){
            inserirPrimeiroNo(valor);
            return true;
        }
        
        No aux = new No(valor); //cria
        aux.setAnt(this.fim);   //definiu que antes do novo ultimo tem alguem
        
        this.fim.setProx(aux);  //
        this.fim = aux;
        return true;
    }
    
    public boolean insereMeioLista(double valor, int pos){
        if ( (pos < 0 ) || (pos >= tamanhoLista()) ) {
            return false;  }
        
        No anterior = buscaNo(pos);
        No novo = new No(valor); // crie o novo
        No proximo = anterior.getProx(); //cria o proximo

        novo.setProx(anterior.getProx()); //quem vem depois do novo
        novo.setAnt(anterior);            //quem vem antes do novo
        anterior.setProx(novo);       //quem vem depois do anterior
        proximo.setAnt(novo);         //quem vem antes do proximo
        return true;
    }
    
    public boolean insere(double valor){
        if (listaVazia()){
            inserirPrimeiroNo(valor);
            return true;
        }
        return insereFinalLista(valor);
    }
    
    public boolean insere(double valor, int pos){
        if ( (pos < 0 ) || (pos >= tamanhoLista()) ) {
            return false;  }
        
        return insereMeioLista(valor, pos);
    }
    
    
    public boolean removeUnicoLista(){
        if (listaVazia()){return false; }
        
        No aux = this.inicio; // encontra o primeiro elemento
        this.inicio = null;   // a referencia inicio agora é vazia
        this.fim = null;      // a referencia fim agora é vazia
        aux = null;           // o ele mento agora é vazio 
        
        System.gc();
        return true;        
    }
    
    public boolean removePrimeiroLista(){
        if (listaVazia()){return false; }
        
        No aux = this.inicio; // encontra o primeiro elemento
        this.inicio = this.inicio.getProx(); // a referencia inicio agora é o "Segundo"
        No prox = this.inicio.getAnt();      // pegamos o anterior do novo INICIO
        prox = null;      // a referencia inicio agora é vazia
        aux = null;       // o ele mento agora é vazio 
        
        System.gc();
        return true;
    }
    
    public boolean removeUltimoLista(){
        if (listaVazia()){return false; }
        
        No aux = this.fim;
        
        this.fim = this.fim.getAnt();
        No prox = this.fim.getProx();
        prox = null;
        aux = null;
        
        System.gc();
        return true;
    }
    
    public boolean remodeMeioLista(int pos){
        if (listaVazia()){return false; }
        No aux = buscaNo(pos -1); // achamos o No 
        
        No ant = aux.getAnt();   //encontramos o No anterior
        No prox = aux.getProx(); //encontramos o No proximo        
        ant.setProx(prox); // verificamos o 
        prox.setAnt(ant);
        
        aux = null;
        return true;
    }
    
}