package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Emergente {
    JDialog dialog;

    public Emergente(){}

    public void showDialog(String text) {
        Escuchadora escuchadora = new Escuchadora();
        dialog = new JDialog(new JFrame(),"Advertencia");
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        JPanel panelText = new JPanel();
        JLabel jlbl = new JLabel(text);
        panelText.add(jlbl);
        JPanel panelButtons = new JPanel();
        JButton jb = new JButton("Aceptar");
        jb.addActionListener(escuchadora);
        panelButtons.add(jb);
        panel.add(panelText);
        panel.add(panelButtons);
        dialog.add(panel);
        dialog.pack();
        //dialog.setSize(300,100);
        dialog.setVisible(true);
    }

    class Escuchadora implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton)e.getSource(); // Devuelve un objeto Object.
            String txtButton = button.getText();
            if(txtButton.equals("Aceptar")) {
                dialog.setVisible(false);
                dialog.dispose();
            }
        }
    }



}
