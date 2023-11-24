package ListasCirculares;

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

    public boolean isEmpty() {
        return first == null;
    }

    public int getSize() {
        return size;
    }

    public String insertToEnd(int value) {
        Nodo neww = new Nodo();
        neww.setValue(value);
        if (isEmpty()) {
            first = neww;
        } else {
            Nodo aux = first;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(neww);
            size++;
        }
        return "Elemento insertado al final: " + value;
    }

    public String insertToStart(int value) {
        Nodo neww = new Nodo();
        neww.setValue(value);
        if (isEmpty()) {
            first = neww;
        } else {
            neww.setNext(first);
            first = neww;
        }
        size++;
        return "Elemento insertado al inicio: " + value;
    }

    public String insertByPosition(int position, int value) {
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
            return "Elemento insertado en la posición " + position + ": " + value;
        } else {
            return "Posición inválida para la inserción";
        }
    }

    public String deleteToStart() {
        if (!isEmpty()) {
            first = first.getNext();
            size--;
            return "Elemento eliminado al inicio";
        } else {
            return "La lista está vacía, no se puede eliminar";
        }
    }

    public String deleteToEnd() {
        if (!isEmpty()) {
            if (first.getNext() == null) {
                first = null;
            } else {
                Nodo aux = first;
                while (aux.getNext().getNext() != null) {
                    aux = aux.getNext();
                }
                aux.setNext(null);
            }
            size--;
            return "Elemento eliminado al final";
        } else {
            return "La lista está vacía, no se puede eliminar";
        }
    }

    public String deleteByPosition(int position) {
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
            size--;
            return "Elemento eliminado en la posición " + position;
        } else {
            return "Posición inválida para la eliminación";
        }
    }

    public String search(int reference) {
        Nodo aux = first;
        boolean found = false;
        while (aux != null && !found) {
            if (reference == aux.getValue()) {
                found = true;
            } else {
                aux = aux.getNext();
            }
        }
        return "Elemento " + (found ? "encontrado" : "no encontrado");
    }

    public String searchByPosition(int position) {
        Nodo aux = first;
        int count = 0;

        while (aux != null && count != position) {
            aux = aux.getNext();
            count++;
        }
        if (aux == null) {
            return "Esta posición no existe";
        } else {
            return "El valor en la posición " + position + " es: " + aux.getValue();
        }
    }

    public String add() {
        Nodo aux = first;
        while (aux != null) {
            suma += aux.getValue();
            aux = aux.getNext();
        }
        return "La suma de los valores de los nodos es: " + suma;
    }

    public String products() {
        Nodo aux = first;
        while (aux != null) {
            producto *= aux.getValue();
            aux = aux.getNext();
        }
        return "El producto del valor de los nodos es: " + producto;
    }

    public String pairAndOdd() {
        Nodo aux = first;
        StringBuilder result = new StringBuilder();
        while (aux != null) {
            if (aux.getValue() % 2 == 0) {
                result.append("num.Par ").append(aux.getValue()).append(",");
            } else {
                result.append("num.Impar ").append(aux.getValue()).append(",");
            }
            aux = aux.getNext();
        }
        return result.toString();
    }

    public String primeNumbers() {
        Nodo aux = first;
        StringBuilder result = new StringBuilder();
        while (aux != null) {
            if (isPrime(aux.getValue())) {
                result.append("Número primo: ").append(aux.getValue()).append(", ");
            }
            aux = aux.getNext();
        }
        return result.toString();
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

    public String repeatedNumbers() {
        Nodo aux = first;
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> repeats = new ArrayList<>();
        StringBuilder result = new StringBuilder();

        while (aux != null) {
            int value = aux.getValue();
            if (numbers.contains(value)) {
                if (!repeats.contains(value)) {
                    repeats.add(value);
                    result.append("Número repetido: ").append(value).append(", ");
                }
            } else {
                numbers.add(value);
            }
            aux = aux.getNext();
        }
        return result.toString();
    }

    public String print() {
        Nodo aux = first;
        StringBuilder result = new StringBuilder();
        if (isEmpty()) {
            result.append(aux);
            int i = 0;
            while (aux != null) {
                result.append(i).append("[").append(aux.getValue()).append("]_>");
                aux = aux.getNext();
                i++;
            }
        } else {
            int i = 0;
            while (aux != null) {
                result.append(i).append("[").append(aux.getValue()).append("]");
                aux = aux.getNext();
                i++;
            }
        }
        return result.toString();
    }
}
