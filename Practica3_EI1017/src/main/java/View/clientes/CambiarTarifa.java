package View.clientes;

import javax.swing.*;
import java.awt.*;

public class CambiarTarifa {
    private JTextField precioMinDia;
    private JTextField diaSemana;

    private JTextField precioMinHora;
    private JTextField horaIni;
    private JTextField horaFin;


    public JPanel porDia(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,2));

        JLabel lbl1 = new JLabel("Precio por minuto de la oferta:");
        JLabel lbl2 = new JLabel("Dia aplicable:");

        precioMinDia = new JTextField("5");
        diaSemana = new JTextField("MONDAY");

        panel.add(lbl1);
        panel.add(precioMinDia);
        panel.add(lbl2);
        panel.add(diaSemana);

        return panel;

    }

    public JPanel porHora(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3,2));

        JLabel lbl1 = new JLabel("Precio por minuto de la oferta:");
        JLabel lbl2 = new JLabel("Hora inicio:");
        JLabel lbl3 = new JLabel("Hora fin:");

        precioMinHora = new JTextField("5");
        horaIni = new JTextField("14:00");
        horaFin = new JTextField("20:00");

        panel.add(lbl1);
        panel.add(precioMinHora);
        panel.add(lbl2);
        panel.add(horaIni);
        panel.add(lbl3);
        panel.add(horaFin);

        return panel;

    }

    public String getPercioMinDia(){
        return precioMinDia.getText();
    }

    public String getDiaSemana(){
        return diaSemana.getText();
    }

    public String getPrecioMinHora(){
        return precioMinHora.getText();
    }

    public String getHoraIni(){
        return horaIni.getText();
    }
    public String getHoraFin(){
        return horaFin.getText();
    }

}
