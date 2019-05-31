package View.llamadas;

import javax.swing.*;
import java.awt.*;

public class FormLlamada {
    private JTextField jtfNif;
    private JTextField jtfTel;
    private JTextField jtfDur;
    private JTextField jtfFIni;
    private JTextField jtfFHora;

    private JLabel lblNif;
    private JLabel lblTel;
    private JLabel lblDur;
    private JLabel lblFIni;
    private JLabel lblFHora;

    public FormLlamada(){}

    public JPanel getPanel(){
        JPanel form = new JPanel(new GridLayout());
        form.setLayout(new GridLayout(5,2));

        lblNif = new JLabel("NIF:");
        lblTel = new JLabel("Teléfono:");
        lblDur = new JLabel("Duración:");
        lblFIni = new JLabel("Fecha:");
        lblFHora = new JLabel("Hora:");


        jtfNif = new JTextField(10);
        jtfTel = new JTextField(10);
        jtfDur = new JTextField(10);
        jtfFIni = new JTextField(15);
        jtfFHora = new JTextField(15);

        form.add(lblNif);
        form.add(jtfNif);
        form.add(lblTel);
        form.add(jtfTel);
        form.add(lblDur);
        form.add(jtfDur);
        form.add(lblFIni);
        form.add(jtfFIni);
        form.add(lblFHora);
        form.add(jtfFHora);

        return form;
    }

    public String getNif(){
        return jtfNif.getText();
    }

    public String getTel(){
        return jtfTel.getText();
    }

    public String getDur(){
        return jtfDur.getText();
    }

    public String getFIni(){
        return jtfFIni.getText();
    }

    public String getFHora(){
        return jtfFHora.getText();
    }
}
