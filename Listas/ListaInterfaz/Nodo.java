package ListaInterfaz;

public class Nodo {
    int value;
    Nodo next;

    public void Nodo() {
        this.value = 0;    
        this.next = null;
    }
    
    public int getValue() { return value; }
    public void setValue(int valor) { this.value = valor; }
    public Nodo getNext() { return next; }
    public void setNext(Nodo next) { this.next = next; }
}
