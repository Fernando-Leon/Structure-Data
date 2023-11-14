import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        
        ListaSimple list = new ListaSimple();

        while (true) {
            int desicion = Integer.parseInt(JOptionPane.showInputDialog("Ingresa una operacion: \n Menu\n 1. Insertar al final\n2. Insertar enfrente\n3. Mostrar\n4. Eliminar primer nodo\n5. Eliminar ultimo nodo\n6. Salir\n\n"));
            int n;
            if(desicion != 1 && desicion != 2 && desicion != 3 && desicion != 4 && desicion != 5){ return; }

            switch (desicion) {
                case 1:
                    n = InputC("Ingresa el numero: ");
                    list.InsertToEnd(n); break;
                case 2:
                    n = InputC("Ingrese el numero: "); 
                    list.InsertToStart(n); break;
                case 3:
                    list.Print(); break;   
                case 4:
                    list.DeleteToStart(); break; 
                case 5:
                    list.DeleteToEnd(); break;
                default:
                break;
            }
        }
    }

    public static int InputC(String msg){ return Integer.parseInt(JOptionPane.showInputDialog(msg)); }

}