package lista;
//@author marcus.vgsampaio
public interface Lista {
    public boolean insere(double valor);
    public boolean insere(double valor, int pos);
    
    public boolean remove();
    public boolean remove(int pos);
    
    public double get();
    public double get(int pos);
    
    public String print();
    
    public boolean listaVazia();
    
    public int tamanhoLista();
    
}
