package View.facturas;

import javax.swing.*;
import java.awt.*;

public class FormFacturas {
    private JTextField jtfNif;
    private JTextField jtfCode;
    private JTextField jtfFIni;
    private JTextField jtfFFin;

    private JLabel lblNif;
    private JLabel lblCode;
    private JLabel lblFIni;
    private JLabel lblFFin;

    public FormFacturas(){}

    public JPanel getPanel(){
        JPanel form = new JPanel(new GridLayout());
        form.setLayout(new GridLayout(4,2));

        lblNif = new JLabel("NIF:");
        lblCode = new JLabel("Codigo:");
        lblFIni = new JLabel("Fecha inicio:");
        lblFFin = new JLabel("Fecha final:");


        jtfNif = new JTextField(10);
        jtfCode = new JTextField(10);
        jtfFIni = new JTextField(15);
        jtfFFin = new JTextField(15);

        form.add(lblNif);
        form.add(jtfNif);
        form.add(lblCode);
        form.add(jtfCode);
        form.add(lblFIni);
        form.add(jtfFIni);
        form.add(lblFFin);
        form.add(jtfFFin);

        return form;
    }

    public String getNif(){
        return jtfNif.getText();
    }

    public String getCode(){
        return jtfCode.getText();
    }

    public String getFIni(){
        return jtfFIni.getText();
    }

    public String getFFin(){
        return jtfFFin.getText();
    }
}
