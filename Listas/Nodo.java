public class Nodo {
    int valor;
    Nodo siguente;

    public void Nodo() {
        this.valor = 0;    
        this.siguente = null;
    }
    public int getValor() { return valor; }
    public void setValor(int valor) { this.valor = valor; }
    public Nodo getSiguente() { return siguente; }
    public void setSiguente(Nodo siguente) { this.siguente = siguente; }
}
