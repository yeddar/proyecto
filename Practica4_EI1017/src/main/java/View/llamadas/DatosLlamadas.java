package View.llamadas;

import Modelo.datos.clientes.Cliente;
// import com.sun.org.apache.xml.internal.security.utils.JDKXPathAPI;

import javax.swing.*;
import java.awt.*;

public class DatosLlamadas extends JPanel {

    public DatosLlamadas(Cliente cliente){
        super(new GridLayout(1,0));

        String[] columnNames = {"Telefono",
                "Duracion",
                "Fecha de realizacion"
        };


        int numCols = columnNames.length;

        Object[][] matrix = new Object[1][numCols];
        matrix[0][0] = cliente.getNombre();
        matrix[0][1] = cliente.getNif();
        matrix[0][2] = cliente.getFecha();

        final JTable table = new JTable(matrix, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    public void showGUI(){
        JFrame ventana = new JFrame("Datos cliente");
        JPanel panel;
    }
}
