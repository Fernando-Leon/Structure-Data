public class ListaSimple {
    int size;
    Nodo primero;

    public void ListaSimple() {
        size = 0;
        primero = null;
    }

    public boolean ListEmpty() { return primero == null; }

    public int getSize() { return size; }

    public void InsertToEnd(int value) {
        Nodo n = new Nodo();
        n.setValor(value);
        if(ListEmpty()) {
            primero = n;
        }else {
            Nodo aux;
            aux = primero;
            while(aux.getSiguente() != null){
                aux=aux.getSiguente();
            }
            aux.setSiguente(n);
            size++;
        }
    }

    public void InsertToStart(int value) {
        Nodo n = new Nodo();
        n.setValor(value);
        
        if (ListEmpty()) {
            primero = n;
        } else {
            // Establecer el nuevo nodo como el primero y ajustar la referencia siguiente
            n.setSiguente(primero);
            primero = n;
        }
        size++;
    }

    public void DeleteToEnd() {
        if (ListEmpty()) {
            System.out.println("No se puede eliminar nada porque la lista está vacía");
        } else if (primero.getSiguente() == null) {
            // Caso especial: si solo hay un nodo en la lista, se elimina directamente.
            primero = null;
            size--;
        } else {
            // Caso general: se busca el penúltimo nodo.
            Nodo aux = primero;
            while (aux.getSiguente().getSiguente() != null) {
                aux = aux.getSiguente();
            }
            // Se establece que el siguiente del penúltimo nodo es null, eliminando así el último nodo.
            aux.setSiguente(null);
            size--;
        }
    }

    public void DeleteToStart() {
        if(ListEmpty()){
            System.out.println("No se puede eliminar nada porque la lista está vacía");
        }else {
            primero = null;
            size--;
        }
    }
    
    // Print list
    public void Print() {
        if(!ListEmpty()){
            Nodo aux = primero;
            int i=0;
            while (aux != null) {
                System.out.print(i+" [ "+aux.getValor()+" ] -> ");
                aux=aux.getSiguente();
                i++;
            }
            System.out.println("");
        }else {
            System.out.println("La lista esta vacia por favor ingrese elementos");
        }
    }

}
