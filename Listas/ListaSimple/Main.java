package ListaSimple;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        
        ListSimple list = new ListSimple();

        while (true) {
            int desicion = Integer.parseInt(JOptionPane.showInputDialog("Ingresa una operacion: \n Menu\n 1. Insertar al inicio\n2. Insertar final\n3. Mostrar\n6. Salir\n\n"));
            int n;
            if(desicion != 1 && desicion != 2 && desicion != 3 && desicion != 4 && desicion != 5){ return; }

            switch (desicion) {
                case 1:
                    n = InputC("Ingresa el numero: ");
                    list.insertToStart(n); break;
                case 2:
                    n = InputC("Ingrese el numero: "); 
                    list.insertToEnd(n); break;
                case 3:
                    list.print(); break;   
                default:
                    break;
            }
        }
    }

    public static int InputC(String msg){ return Integer.parseInt(JOptionPane.showInputDialog(msg)); }

}