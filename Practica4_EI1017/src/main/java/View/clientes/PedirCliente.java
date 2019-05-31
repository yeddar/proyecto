package View.clientes;

import javax.swing.*;
import java.awt.*;

public class PedirCliente {
    private JTextField jtfNif;
    private JLabel lblNif;

    public PedirCliente(){ }

    public JPanel getPanel(){
        // Crear paneles y definir layout
        JPanel form = new JPanel(new GridLayout());
        form.setLayout(new GridLayout(1,2));

        // Componentes etiquetas

        lblNif = new JLabel("NIF: ");


        // Componentes campo de texto
        jtfNif = new JTextField(10);


        // Añadir componentes a los paneles

        form.add(lblNif);
        form.add(jtfNif);


        return form;
    }

    public String getNif() {
        return jtfNif.getText();
    }

}

