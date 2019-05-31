package View.clientes;

import Modelo.datos.Fecha;

import javax.swing.*;
import java.awt.*;

public class CambiarTarifa {
    private JTextField nifDia;
    private JTextField precioMinDia;
    private JTextField diaSemana;

    private JTextField nifHora;
    private JTextField precioMinHora;
    private JTextField horaIni;
    private JTextField horaFin;


    public JPanel porDia(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,2));

        JLabel lbl0 = new JLabel("NIF:");
        JLabel lbl1 = new JLabel("Precio por minuto de la oferta:");
        JLabel lbl2 = new JLabel("Dia aplicable:");

        nifDia = new JTextField();
        precioMinDia = new JTextField("5");
        diaSemana = new JTextField("MONDAY");

        panel.add(lbl0);
        panel.add(nifDia);
        panel.add(lbl1);
        panel.add(precioMinDia);
        panel.add(lbl2);
        panel.add(diaSemana);

        return panel;

    }

    public JPanel porHora(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,2));

        JLabel lbl0 = new JLabel("NIF:");
        JLabel lbl1 = new JLabel("Precio por minuto de la oferta:");
        JLabel lbl2 = new JLabel("Hora inicio:");
        JLabel lbl3 = new JLabel("Hora fin:");

        nifHora = new JTextField();
        precioMinHora = new JTextField("5");
        horaIni = new JTextField("14:00");
        horaFin = new JTextField("20:00");

        panel.add(lbl0);
        panel.add(nifHora);
        panel.add(lbl1);
        panel.add(precioMinHora);
        panel.add(lbl2);
        panel.add(horaIni);
        panel.add(lbl3);
        panel.add(horaFin);

        return panel;

    }

    public String getNifDia() { return nifDia.getText(); }

    public String getNifHora(){ return nifHora.getText(); }

    public double getPercioMinDia(){ return Double.valueOf(precioMinDia.getText()); }

    public String getDiaSemana(){
        return diaSemana.getText();
    }

    public double getPrecioMinHora(){
        return Double.valueOf(precioMinHora.getText());
    }

    public String getHoraIni(){
        return horaIni.getText();
    }
    public String getHoraFin(){
        return horaFin.getText();
    }

}
