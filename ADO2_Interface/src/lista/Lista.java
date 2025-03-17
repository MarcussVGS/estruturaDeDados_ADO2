
package lista;

public interface Lista {
    public boolean Insere(double valor); //v insere no final
    public boolean Insere(double valor, int pos); //v
    
    public boolean remove(); // remove no final
    public boolean remove(int pos);
    
    public double get(); // pega do inicio
    public double get(int pos);
    
    public String print(); //v
    
    public boolean listaVazia(); //v
    
    public int tamanhoLista(); //v
    
}
