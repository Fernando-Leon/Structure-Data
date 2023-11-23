package ListaSimple;

import java.util.ArrayList;

public class ListSimple {
    int size;
    Nodo first;
    Nodo previous;
    int suma;
    double producto = 1;

    public ListSimple() {
        this.size = 0;
        this.first = null;
        this.previous = null;
    }

    public boolean Empty() { // True or False
        return first == null;
    }

    public int getSize() { // Get Size
        return size;
    }

    public void insertToEnd(int value) { // Insert to end
        Nodo neww = new Nodo();
        neww.setValue(value);
        if (Empty()) {
            first = neww;
        } else {
            Nodo aux;
            aux = first;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(neww);
            size++;
        }
    }

    public void insertToStart(int value) { // Insert to start
        Nodo neww = new Nodo();
        neww.setValue(value);
        if (Empty()) {
            first = neww;
        } else {
            neww.setNext(first);
            first = neww;
        }
        size++;
    }

    public void insertByPosition(int position, int value) { // Inserto by position
        if (position >= 0 && position <= size) {
            Nodo neww = new Nodo();
            neww.setValue(value);

            if (position == 0) {
                neww.setNext(first);
                first = neww;
            } else {
                if (position == size) {
                    Nodo aux = first;

                    while (aux.getNext() != null) {
                        aux = aux.getNext();
                    }
                    aux.setNext(neww);
                } else {
                    Nodo aux = first;
                    for (int i = 0; i < (position - 1); i++) {
                        aux = aux.getNext();
                    }
                    Nodo siguiente = aux.getNext();
                    aux.setNext(neww);
                    neww.setNext(siguiente);
                }
            }
            size++;
        }
    }

    public void deleteToStart() {
        if (first != null) {
            first = first.getNext();
            size--;
        }
    }

    public void deleteToEnd() {
        if (first == null || first.getNext() == null) {
            first = null;
        } else {
            Nodo aux;
            aux = first;
            while (aux.getNext().getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(null);
            size--;
        }
    }

    public void deleteByPosition(int position) { // Delete to position
        if (position >= 0 && position < size) {
            if (position == 0) {
                first = first.getNext();
            } else {
                Nodo aux = first;
                for (int i = 0; i < position - 1; i++) {
                    aux = aux.getNext();
                }
                Nodo sig = aux.getNext();
                aux.setNext(sig.getNext());
            }
        }
        size--;
    }

    public boolean search(int reference) { // Search
        Nodo aux = first;
        boolean found = false;
        while (aux != null && !found) {
            if (reference == aux.getValue()) {
                found = true;
            } else {
                aux = aux.getNext();
            }
        }
        System.out.println(found);
        return found;
    }

    public int searchByPosition(int position) { // Search by position
        Nodo aux = first;
        int count = 0;

        while (aux != null && count != position) {
            aux = aux.getNext();
            count++;
        }
        if (aux == null) {
            System.out.println("Esta posición no existe");
            return 0;
        } else {
            System.out.println("El valor en esta posición es: " + aux.getValue());
            return aux.getValue();
        }
    }

    public void add() { // Add
        Nodo aux = first;
        while (aux != null) {
            suma += aux.getValue();
            aux = aux.getNext();
        }
        System.out.println("La suma de los valores de los nodos es: " + suma);
    }

    public void products() { // Products
        Nodo aux = first;
        while (aux != null) {
            producto *= aux.getValue();
            aux = aux.getNext();
        }
        System.out.println("El producto del valor de los nodos es: " + producto);
    }

    public void pairAndOdd() { // Get Pares e impares
        Nodo aux = first;
        while (aux != null) {
            if (aux.getValue() % 2 == 0) {
                System.out.print("num.Par " + aux.getValue() + ",");
            } else {
                System.out.print("num.Impar " + aux.getValue() + ",");
            }
            aux = aux.getNext();
        }
    }

    public void primeNumbers() { // Prime Numbers
        Nodo aux = first;
        while (aux != null) {
            if (isPrime(aux.getValue())) {
                System.out.print("Número primo: " + aux.getValue() + ", ");
            }
            aux = aux.getNext();
        }
    }

    public boolean isPrime(int numero) {
        if (numero <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }

    public void repeatedNumbers() { // repeated numbers
        Nodo aux = first;
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> repeats = new ArrayList<>();

        while (aux != null) {
            int value = aux.getValue();
            if (numbers.contains(value)) {
                if (!repeats.contains(value)) {
                    repeats.add(value);
                    System.out.print("Número repetido: " + value + ", ");
                }
            } else {
                numbers.add(value);
            }
            aux = aux.getNext();
        }
    }

    public void print() {
        if (Empty()) {
            Nodo aux = first;
            System.out.println(aux);
            int i = 0;
            while (aux != null) {
                System.out.print(i + "[" + aux.getValue() + "]_>");
                aux = aux.getNext();
                i++;
            }
        } else {
            Nodo aux = first;
            int i = 0;
            while (aux != null) {
                System.out.print(i + "[" + aux.getValue() + "]");
                aux = aux.getNext();
                i++;
            }
        }
    }
}
