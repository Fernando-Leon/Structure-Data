package ListasCirculares;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaSimpleMenu extends JFrame {
    private ListSimple lista;
    private JTextArea textArea;

    public ListaSimpleMenu() {
        lista = new ListSimple();
        textArea = new JTextArea(20, 40);
        textArea.setEditable(false);

        JButton insertarAlFinalButton = new JButton("Insertar al Final");
        JButton insertarAlInicioButton = new JButton("Insertar al Inicio");
        JButton insertarPorPosicionButton = new JButton("Insertar por Posición");
        JButton eliminarAlInicioButton = new JButton("Eliminar al Inicio");
        JButton eliminarAlFinalButton = new JButton("Eliminar al Final");
        JButton eliminarPorPosicionButton = new JButton("Eliminar por Posición");
        JButton buscarButton = new JButton("Buscar");
        JButton buscarPorPosicionButton = new JButton("Buscar por Posición");
        JButton sumarButton = new JButton("Sumar");
        JButton productosButton = new JButton("Productos");
        JButton parEImparButton = new JButton("Pares e Impares");
        JButton primosButton = new JButton("Números Primos");
        JButton repetidosButton = new JButton("Números Repetidos");
        JButton imprimirButton = new JButton("Imprimir");

        insertarAlFinalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el numero a insertar"));
                String resultado = lista.insertToEnd(value); // Ejemplo, debes pasar el valor deseado
                updateTextArea(resultado);
            }
        });

        insertarAlInicioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el numero a insertar"));
                String resultado = lista.insertToStart(value); // Ejemplo
                updateTextArea(resultado);
            }
        });

        insertarPorPosicionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el numero a insertar"));
                int position = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa la posicion"));
                String resultado = lista.insertByPosition(position, value); // Ejemplo, debes pasar la posición y el valor
                updateTextArea(resultado);
            }
        });

        eliminarAlInicioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resultado = lista.deleteToStart();
                updateTextArea(resultado);
            }
        });

        eliminarAlFinalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resultado = lista.deleteToEnd();
                updateTextArea(resultado);
            }
        });

        eliminarPorPosicionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int position = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el numero de la posicion"));

                String resultado = lista.deleteByPosition(position);
                updateTextArea(resultado);
            }
        });

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el numero a buscar"));

                String resultado = lista.search(value); // Ejemplo, debes pasar el valor a buscar
                updateTextArea(resultado);
            }
        });

        buscarPorPosicionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el numero a buscar"));
                String resultado = lista.searchByPosition(value); // Ejemplo, debes pasar la posición
                updateTextArea(resultado);
            }
        });

        sumarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resultado = lista.add();
                updateTextArea(resultado);
            }
        });

        productosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resultado = lista.products();
                updateTextArea(resultado);
            }
        });

        parEImparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resultado = lista.pairAndOdd();
                updateTextArea(resultado);
            }
        });

        primosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resultado = lista.primeNumbers();
                updateTextArea(resultado);
            }
        });

        repetidosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resultado = lista.repeatedNumbers();
                updateTextArea(resultado);
            }
        });

        imprimirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resultado = lista.print();
                updateTextArea(resultado);
            }
        });

        JPanel panel1 = new JPanel(new FlowLayout());
        panel1.add(insertarAlFinalButton);
        panel1.add(insertarAlInicioButton);
        panel1.add(insertarPorPosicionButton);
        panel1.add(eliminarAlInicioButton);

        JPanel panel2 = new JPanel(new FlowLayout());
        panel2.add(eliminarAlFinalButton);
        panel2.add(eliminarPorPosicionButton);
        panel2.add(buscarButton);
        panel2.add(buscarPorPosicionButton);

        JPanel panel3 = new JPanel(new FlowLayout());
        panel3.add(sumarButton);
        panel3.add(productosButton);
        panel3.add(parEImparButton);
        panel3.add(primosButton);

        JPanel panel4 = new JPanel(new FlowLayout());
        panel4.add(repetidosButton);
        panel4.add(imprimirButton);

        setLayout(new BorderLayout());
        add(textArea, BorderLayout.CENTER);
        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.WEST);
        add(panel3, BorderLayout.EAST);
        add(panel4, BorderLayout.SOUTH);

        setTitle("Lista Simple Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void updateTextArea(String text) {
        textArea.setText(textArea.getText() + "\n" + text);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ListaSimpleMenu();
            }
        });
    }
}
    