package View.facturas;

import javax.swing.*;
import java.awt.*;

public class PedirFacturaCliente {
    private JTextField jtfNif;
    private JTextField jtfCode;
    private JLabel lblNif;
    private JLabel lblCode;

    public PedirFacturaCliente(){ }

    public JPanel getPanel(){
        // Crear paneles y definir layout
        JPanel form = new JPanel(new GridLayout());
        form.setLayout(new GridLayout(2,2));

        // Componentes etiquetas

        lblNif = new JLabel("NIF: ");
        lblCode = new JLabel("Código de factura:");


        // Componentes campo de texto
        jtfNif = new JTextField(10);
        jtfCode = new JTextField(10);

        // Añadir componentes a los paneles

        form.add(lblNif);
        form.add(jtfNif);
        form.add(lblCode);
        form.add(jtfCode);


        return form;
    }

    public String getNif() {
        return jtfNif.getText();
    }

    public String getCode() {
        return jtfCode.getText();
    }

}

