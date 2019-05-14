package View;

import javax.swing.*;

public class Emergente {

    public Emergente(){}

    public void showDialog(String text) {
        JDialog dialog = new JDialog(new JFrame(),"Error");
        JLabel jlbl = new JLabel(text);
        dialog.add(jlbl);
        dialog.setSize(300,100);
        dialog.setVisible(true);
    }



}
