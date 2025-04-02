package listaestatica;

import lista.Lista;
//@author marcus.vgsampaio
public class ListaEstatica implements Lista{
    
    private double[] vetor;
    private int nElemento;
    
    public ListaEstatica(){
        this.vetor = new double[5];
        this.nElemento = 0;
    }
    
    public ListaEstatica(int tamanhoInicial){
        if (tamanhoInicial < 3) {
            this.vetor = new double[3];    
        } else {
            this.vetor = new double[tamanhoInicial];
        }
        this.nElemento = 0;
    }
    
    public boolean listaVazia(){
        return (this.nElemento <= 0);
    }
    
    public boolean inserePrimeiroNo(double valor){
        if (!listaVazia()) return false;
        
        this.vetor[0] = valor;
        this.nElemento = 1;
        return true;
    }
    
    public boolean insereFinalLista(double valor){
        if (listaVazia()) return inserePrimeiroNo(valor);
        
        this.vetor[this.nElemento] = valor;
        this.nElemento = this.nElemento + 1;
        return true;
    }
    
    public boolean insereInicioLista(double valor){
         if (listaVazia()) return inserePrimeiroNo(valor);
         
         for (int i = this.nElemento; i > 0; i--){
             this.vetor[i] = this.vetor[i-1];
         }
         this.vetor[0] = valor;
         this.nElemento = this.nElemento + 1;
         return true;
    }
    
    public int tamanhoLista(){
        return this.nElemento;
    }
    
    public boolean insereMeioLista(double valor, int pos){
        if ((pos < 1) || pos >= tamanhoLista()){
            return false;
        }
        
        for (int i = this.nElemento; i >= pos; i--){
            this.vetor[i] = this.vetor[i-1];
        }
        
        this.vetor[pos] = valor;
        this.nElemento = this.nElemento + 1;
        return true;
    }
    
    
    
    public boolean insere(double valor){
        return insereFinalLista(valor);
    }
    
    public boolean insere(double valor, int pos){
        
        if (tamanhoLista() >= this.vetor.length - 2) {
            redimensionaVetor();
        }
        
        if ((tamanhoLista() == 0) && (pos == 0)) { 
            return inserePrimeiroNo(valor);
        }
        if ((tamanhoLista() > 0) && (pos == 0)) { 
            return insereInicioLista(valor);
        }
        if ((tamanhoLista() > 0) && (pos == tamanhoLista())) {
            return insereFinalLista(valor);
        }
        return insereMeioLista(valor, pos);
    }
    
    
    public String print(){
        String aux = "";
        for (int i = 0; i < tamanhoLista(); i++){
            aux = aux + this.vetor[i] + " - ";
        }
        return aux;  
    }

    
    public boolean removeFinalElemento(){
        this.nElemento = this.nElemento - 1;
        return true;
    }

    public boolean removeInicioElemento(){
        if (listaVazia()) {return false;}
        
        for (int i = 0; i < this.nElemento; i++){
            this.vetor[i] = this.vetor[i+1];
        }
        this.nElemento = this.nElemento - 1;
        return true;
        
    }
    
    public boolean removeMeioLista(int pos){
        if (listaVazia()) {return false;}
        
        for (int i = pos; i < this.nElemento; i++){
            this.vetor[i] = this.vetor[i+1];
        }
        this.nElemento = this.nElemento - 1;
        return true;
    }
    
    public boolean removeUnicoElemento(){
        if (tamanhoLista() > 1) {return false;}
        this.nElemento = 0;
        return true;       
    }
    
    public void redimensionaVetor(){
        double[] temp = new double[this.vetor.length];
        
        for (int i = 0; i < this.vetor.length; i++){
            temp[i] = this.vetor[i];
        }
        this.vetor = null;
        this.vetor = new double[temp.length * 2];
         for (int i = 0; i < temp.length; i++){
            this.vetor[i] = temp[i];
        }
    }
    
    
    @Override
    public boolean remove() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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






