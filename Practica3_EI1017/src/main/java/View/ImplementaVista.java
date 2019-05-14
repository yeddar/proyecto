package View;

import Modelo.datos.Fecha;
import Modelo.datos.clientes.Cliente;
import Modelo.exceptions.ClienteNoExiste;
import View.Emergente;
import View.clientes.*;
import com.sun.org.apache.xml.internal.security.utils.JDKXPathAPI;
import controlador.Controlador;
import Modelo.InterrogaModelo;
import View.InformaVista;
import View.InterrogaVista;
import controlador.Utilidades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImplementaVista extends JDialog implements InterrogaVista, InformaVista {
    private Controlador controlador;
    private InterrogaModelo modelo;
    private FormCliente formCliente;
    private ShowTable table;
    private PedirCliente pedirCliente;


    public ImplementaVista(){
        //controlador.cargarCartera();
        formCliente = new FormCliente();
        pedirCliente = new PedirCliente();


    }

    public void setModelo(InterrogaModelo modelo) {
        this.modelo = modelo;
    }

    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    @Override
    public String getNif() { return formCliente.getNif(); }
    @Override
    public String getName() {
        return formCliente.getName();
    }
    @Override
    public String getSurnames() { return formCliente.getSurnames(); }
    @Override
    public String getEmail() {
        return formCliente.getEmail();
    }
    @Override
    public String getCity() { return formCliente.getCity(); }
    @Override
    public String getZip() {
        return formCliente.getZip();
    }
    @Override
    public String getProvince() {
        return formCliente.getProvince();
    }
    @Override
    public String getDate() {
        return formCliente.getDate();
    }

    private void formCliente(){

    }

    private JPanel menuFactura(){
        //EscuchadorMenu escuchador = new EscuchadorMenu();
        JPanel panel = new JPanel();

        JButton jb1 = new JButton("Emitir factura");
        //jb1.addActionListener(escuchador);
        JButton jb2 = new JButton("Mostrar facturas");
        //jb2.addActionListener(escuchador);

        panel.add(jb1);
        panel.add(jb2);

        return panel;
    }

    private JPanel menuLlamada(){
        //EscuchadorMenu escuchador = new EscuchadorMenu();
        JPanel panel = new JPanel();

        JButton jb1 = new JButton("Alta llamada");
        //jb1.addActionListener(escuchador);
        JButton jb2 = new JButton("Listado llamadas");
        //jb2.addActionListener(escuchador);

        panel.add(jb1);
        panel.add(jb2);

        return panel;
    }
    private JPanel listarPorFecha(){
        ActionListener actionListener;
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        JPanel form = new JPanel();
        form.setLayout(new GridLayout(2,2));

        JLabel lbl1 = new JLabel("Fecha inicio:");
        JLabel lbl2 = new JLabel("Fecha fin:");

        JTextField jtf1 = new JTextField("DD/MM/AAAA");
        JTextField jtf2 = new JTextField("DD/MM/AAAA");

        JPanel buttons = new JPanel();
        JButton b1 = new JButton("Aceptar");
        JButton b2 = new JButton("Cancelar");
        buttons.add(b1);
        buttons.add(b2);

        form.add(lbl1);
        form.add(jtf1);
        form.add(lbl2);
        form.add(jtf2);

        panel.add(form);
        panel.add(buttons);

        b1.addActionListener(actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventana = new JFrame("Listado de clientes por fecha");
                Fecha fechaIni = Utilidades.setFecha(jtf1.getText());
                Fecha fechaFin = Utilidades.setFecha(jtf2.getText());
                ShowTable table = new ShowTable(controlador.clientesFecha(fechaIni,fechaFin));
                ventana.add(table);
                ventana.pack();
                ventana.setVisible(true);
            }
        });
        return panel;
    }


    private JPanel datosCliente(){
        ActionListener actionListener;
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        JButton b1 = new JButton("Aceptar");
        JButton b2 = new JButton("Cancelar");

        JPanel form = pedirCliente.getPanel();
        JPanel buttons = new JPanel();
        buttons.add(b1);
        buttons.add(b2);
        panel.add(form);
        panel.add(buttons);

        b1.addActionListener(actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nif = pedirCliente.getNif();
                    Cliente cliente = modelo.clienteExiste(nif);
                    JFrame ventana = new JFrame("Datos cliente");
                    DatosCliente table = new DatosCliente(cliente);
                    ventana.add(table,BorderLayout.CENTER);
                    ventana.pack();
                    ventana.setVisible(true); // Hacer visible
                } catch (ClienteNoExiste f){
                    new Emergente().showDialog("No existe ningín cliente con ese NIF.");
                    f.printStackTrace();
                }
            }
        });

        return panel;
    }


    private JPanel menuCliente(){
        ActionListener actionListener;
        JPanel panel = new JPanel();

        JButton jb1 = new JButton("Alta Empresa");
        JButton jb2 = new JButton("Alta Particular");
        JButton jb3 = new JButton("Baja cliente");
        JButton jb4 = new JButton("Mostrar datos");
        JButton jb5 = new JButton("Modificar tarifa");

        panel.add(jb1);
        panel.add(jb2);
        panel.add(jb3);
        panel.add(jb4);
        panel.add(jb5);



        jb1.addActionListener(actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionListener actionListener;
                EscuchadoraBoton escuchadoraBoton = new EscuchadoraBoton();
                JFrame ventana = new JFrame("Alta empresa");

                JButton b1 = new JButton("Aceptar");
                b1.addActionListener(escuchadoraBoton);
                JButton b2 = new JButton("Cerrar");

                JPanel formEmpresa = formCliente.getPanel(false);
                JPanel buttons = new JPanel();
                buttons.add(b1);
                buttons.add(b2);

                ventana.add(formEmpresa,BorderLayout.CENTER);
                ventana.add(buttons, BorderLayout.SOUTH);

                ventana.pack();
                ventana.setVisible(true); // Hacer visible

                b2.addActionListener(actionListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ventana.setVisible(false);
                        ventana.dispose();
                    }
                });
            }
        });


        jb2.addActionListener(actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionListener actionListener;
                System.out.println("Particular");
                EscuchadoraBoton escuchadoraBoton = new EscuchadoraBoton();
                JFrame ventana = new JFrame("Alta particular");


                JButton b1 = new JButton("Aceptar");
                b1.addActionListener(escuchadoraBoton);
                JButton b2 = new JButton("Cerrar");

                JPanel formEmpresa = formCliente.getPanel(true);
                JPanel buttons = new JPanel();
                buttons.add(b1);
                buttons.add(b2);

                ventana.add(formEmpresa,BorderLayout.CENTER);
                ventana.add(buttons, BorderLayout.SOUTH);

                ventana.pack();
                ventana.setVisible(true); // Hacer visible

                b2.addActionListener(actionListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ventana.setVisible(false);
                        ventana.dispose();
                    }
                });
            }
        });

        jb3.addActionListener(actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionListener actionListener;
                JFrame ventana = new JFrame("Borrar cliente");
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
                JButton b1 = new JButton("Aceptar");
                panel.add(pedirCliente.getPanel());
                panel.add(b1);

                ventana.add(panel);
                ventana.pack();
                ventana.setVisible(true);

                b1.addActionListener(actionListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            String nif = pedirCliente.getNif();
                            modelo.clienteExiste(nif);
                            controlador.borrarCliente(nif);
                            ventana.setVisible(false);
                            ventana.dispose();

                        } catch (ClienteNoExiste f){
                            new Emergente().showDialog("No existe ningín cliente con ese NIF.");
                            f.printStackTrace();
                        }
                    }
                });
            }
        });

        jb4.addActionListener(actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventana = new JFrame("Mostrar datos");
                JTabbedPane tabs = new JTabbedPane();
                tabs.add("Listado de clientes",new ShowTable(modelo.getClientes()));
                tabs.add("Mostrar datos cliente",datosCliente());
                tabs.add("Listar clientes por fecha",listarPorFecha());
                ventana.add(tabs);
                ventana.pack();
                ventana.setVisible(true);
            }
        });

        jb5.addActionListener(actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame ventana = new JFrame("Modificar tarifa");
                CambiarTarifa tarifa = new CambiarTarifa();
                EscuchadoraModificarTarifa escuchadora = new EscuchadoraModificarTarifa();
                // Panel tarifa por hora
                JPanel panelTarifaHora = new JPanel();
                panelTarifaHora.setLayout(new BoxLayout(panelTarifaHora,BoxLayout.PAGE_AXIS));
                JButton jb1 = new JButton("Añadir tarifa hora");
                jb1.addActionListener(escuchadora);
                panelTarifaHora.add(tarifa.porHora());
                panelTarifaHora.add(jb1);

                // Panel tarifa por día
                JPanel panelTarifaDia = new JPanel();
                panelTarifaDia.setLayout(new BoxLayout(panelTarifaDia,BoxLayout.PAGE_AXIS));
                JButton jb2 = new JButton("Añadir tarifa día");
                jb2.addActionListener(escuchadora);
                panelTarifaDia.add(tarifa.porDia());
                panelTarifaDia.add(jb2);

                JTabbedPane tabs = new JTabbedPane();
                tabs.add("Tarifa por hora",panelTarifaHora);
                tabs.add("Tarifa por día",panelTarifaDia);

                ventana.add(tabs);
                ventana.pack();
                ventana.setVisible(true);


            }
        });
        return panel;
    }

    public void createAndShowGUI() {
        // Crear ventana y contenedor
        JFrame ventana = new JFrame("Programa");
        ventana.addWindowListener(new EscuchadorVentana());
        Container contenedor = ventana.getContentPane();

        // Tabla con el listado de clientes
        table = new ShowTable(modelo.getClientes());

        // Panel Cliente
        JPanel panelCliente = new JPanel(new GridLayout());
        panelCliente.setLayout(new GridLayout(2,2));
        panelCliente.add(table);
        panelCliente.add(menuCliente());

        JPanel panelRefresco = new JPanel();
        JButton btRefresh = new JButton("Refresh");
        panelRefresco.add(btRefresh);

        ActionListener actionListener;
        btRefresh.addActionListener(actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                table = new ShowTable(modelo.getClientes());
                panelCliente.update(panelCliente.getGraphics());
                ventana.update(ventana.getGraphics());
                ventana.pack();

            }
        });

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Clientes",panelCliente);
        tabs.add("Llamadas",menuLlamada());
        tabs.add("Facturas",menuFactura());
        tabs.add("Refresco",panelRefresco);


        contenedor.add(tabs,BorderLayout.CENTER);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // La aplicación se cerrará al cerrar la ventana.
        ventana.pack(); //Tamaño de ventana ajustable
        ventana.setVisible(true); // Hacer visible


    }
    class EscuchadorVentana extends WindowAdapter {
        @Override
        public void windowOpened(WindowEvent e) { }

        @Override
        public void windowClosing(WindowEvent e){
            controlador.guardarCartera();
            System.out.println("Se ha guardado la cartera!");
            System.exit(0);
        }


    }

    class EscuchadoraModificarTarifa implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton button = (JButton)e.getSource(); // Devuelve un objeto Object.
            String txtButton = button.getText();
            if(txtButton.equals("Añadir tarifa día"))
                System.out.println("Añadir tarifa día");
            else if(txtButton.equals("Añadir tarifa hora"))
                System.out.println("Añadir tarifa hora");
        }
    }



    class EscuchadoraBoton implements ActionListener {

        public void actionPerformed(ActionEvent e)  {
            JButton button = (JButton)e.getSource(); // Devuelve un objeto Object.
            String txtButton = button.getText();
            if(txtButton.equals("Aceptar")) {
                controlador.pedirCliente();

            }
            else if(txtButton.equals("Cancelar"))
                System.out.println("Has cancelado.");
        }
    }

   /* class EscuchadorMenu implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton boton = (JButton)e.getSource();
            String texto = boton.getText();
            if(texto.equals("Baja cliente"))
                System.out.println("Baja cliente");
            else if(texto.equals("Mostrar datos"))
                System.out.println("Mostrar datos");
            else if(texto.equals("Modificar tarifa"))
                System.out.println("Modificar tarifa");

        }
    }*/

    public void creaGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
