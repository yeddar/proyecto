package View.clientes;

import Modelo.datos.Cartera;
import Modelo.datos.clientes.Cliente;
import View.DatosClientes;
import View.InterrogaVista;

import javax.swing.*;
import java.awt.*;

public class FormCliente extends JPanel implements DatosClientes {
    private JTextField jtfNif;
    private JTextField jtfName;
    private JTextField jtfEmail;
    private JTextField jtfCity;
    private JTextField jtfZip;
    private JTextField jtfProvince;
    private JTextField jtfDate;

    private JLabel lblNif;
    private JLabel lblName;
    private JLabel lblEmail;
    private JLabel lblCity;
    private JLabel lblZip;
    private JLabel lblProvince;
    private JLabel lblDate;

    private JTextField jtfSurnames;
    private JLabel lblSurnames;

    public FormCliente(){ }

    public JPanel getPanel(boolean setTextField){
        // Crear paneles y definir layout
        JPanel form = new JPanel(new GridLayout());
        form.setLayout(new GridLayout(8,2));

        // Componentes etiquetas
        lblName = new JLabel("Nombre: ");
        lblSurnames = new JLabel("Apellidos: ");
        lblNif = new JLabel("NIF: ");
        lblEmail = new JLabel("E-mail: ");
        lblCity = new JLabel("Población: ");
        lblZip = new JLabel("Código postal: ");
        lblProvince = new JLabel("Provincia: ");
        lblDate = new JLabel("Fecha de alta: ");


        // Componentes campo de texto
        jtfNif = new JTextField(10);
        jtfName = new JTextField( 10);
        jtfSurnames = new JTextField(15);
        jtfEmail = new JTextField( 15);
        jtfZip = new JTextField( 5);
        jtfProvince = new JTextField( 10);
        jtfCity = new JTextField( 10);
        jtfDate = new JTextField( 15);


        // Añadir componentes a los paneles
        form.add(lblName);
        form.add(jtfName);
        form.add(lblSurnames);
        form.add(jtfSurnames);
        form.add(lblNif);
        form.add(jtfNif);
        form.add(lblCity);
        form.add(jtfCity);
        form.add(lblZip);
        form.add(jtfZip);
        form.add(lblProvince);
        form.add(jtfProvince);
        form.add(lblEmail);
        form.add(jtfEmail);
        form.add(lblDate);
        form.add(jtfDate);

        jtfSurnames.setEnabled(setTextField);

        return form;
    }


    @Override
    public String getNif() {
        return jtfNif.getText();
    }

    @Override
    public String getEmail() {
        return jtfEmail.getText();
    }

    @Override
    public String getCity() {
        return jtfCity.getText();
    }

    @Override
    public String getZip() {
        return jtfZip.getText();
    }

    @Override
    public String getProvince() {
        return jtfProvince.getText();
    }

    @Override
    public String getDate() {
        return jtfDate.getText();
    }

    @Override
    public String getName() {
        return jtfName.getText();
    }

    @Override
    public String getSurnames() {
        return jtfSurnames.getText();
    }

}

