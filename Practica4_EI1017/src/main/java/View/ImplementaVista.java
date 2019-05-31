package View;

import Modelo.ImplementaModelo;
import Modelo.InterrogaModelo;
import Modelo.datos.Factura;
import Modelo.datos.Fecha;
import Modelo.datos.clientes.Cliente;
import Modelo.exceptions.ClientAlreadyExists;
import Modelo.exceptions.ClienteNoExiste;
import Modelo.exceptions.FechaInvalida;
import View.clientes.*;
// import com.sun.org.apache.xml.internal.security.utils.JDKXPathAPI;
import View.facturas.FormFacturas;
import View.facturas.PedirFacturaCliente;
import View.facturas.ShowTableFacturas;
import View.llamadas.FormLlamada;
import View.llamadas.ShowTableLlamadas;
import controlador.Controlador;
import controlador.ImplementaControlador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ImplementaVista extends JDialog implements InterrogaVista, InformaVista, DatosTarifa {

    private Controlador controlador;
    private InterrogaModelo modelo;


    private FormCliente formCliente;
    private FormLlamada formLlamada;
    private FormFacturas formFactura;
    private CambiarTarifa cambiarTarifa;
    private PedirCliente pedirCliente;
    private PedirFacturaCliente pedirFacturaCliente;


    public ImplementaVista(){
        formCliente = new FormCliente();
        pedirCliente = new PedirCliente();
        formLlamada = new FormLlamada();
        formFactura = new FormFacturas();
        pedirFacturaCliente = new PedirFacturaCliente();
        cambiarTarifa = new CambiarTarifa();
    }

    public void setModelo(ImplementaModelo modelo) {
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


    private JPanel menuFactura(){
        ActionListener actionListener;
        JPanel panel = new JPanel();

        JButton jb1 = new JButton("Emitir factura");
        JButton jb2 = new JButton("Mostrar facturas");

        panel.add(jb1);
        panel.add(jb2);

        jb1.addActionListener(actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionListener actionListener;
                JFrame ventana = new JFrame("Emitir Factura");
                JButton b1 = new JButton("Aceptar");
                b1.addActionListener(actionListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            controlador.emitirFactura();
                            ventana.setVisible(false);
                            ventana.dispose();
                        } catch (ClienteNoExiste clienteNoExiste){
                            clienteNoExiste.printStackTrace();
                            new Emergente().showDialog("El NIF introducido no pertenece a ningún cliente.");
                        }
                    }
                });
                JButton b2 = new JButton("Cerrar");

                JPanel formFacPanel = formFactura.getPanel();
                JPanel buttons = new JPanel();
                buttons.add(b1);
                buttons.add(b2);

                ventana.add(formFacPanel,BorderLayout.CENTER);
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
                JFrame ventana = new JFrame("Mostrar facturas");
                JTabbedPane tabs = new JTabbedPane();
                tabs.add("Listado de facturas", datosFactura());
                tabs.add("Factura en concreto", datosFacturaConcreto());
                tabs.add("Listar facturas por fecha", listarPorFechaFacturas());
                ventana.add(tabs);
                ventana.pack();
                ventana.setVisible(true);
            }
        });
        return panel;
    }

    private JPanel menuLlamada(){
        ActionListener actionListener;
        JPanel panel = new JPanel();

        JButton jb1 = new JButton("Alta llamada");
        JButton jb2 = new JButton("Listado llamadas");

        panel.add(jb1);
        panel.add(jb2);

        jb1.addActionListener(actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionListener actionListener;
                JFrame ventana = new JFrame("Alta llamada");

                JButton b1 = new JButton("Aceptar");
                b1.addActionListener(actionListener = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            controlador.anadirLlamada();
                            ventana.setVisible(false);
                            ventana.dispose();
                        } catch (ClienteNoExiste clienteNoExiste){
                            clienteNoExiste.printStackTrace();
                            new Emergente().showDialog("El cliente no se encuentra registrado.");
                        }
                    }
                });
                JButton b2 = new JButton("Cerrar");

                JPanel formLlamPanel = formLlamada.getPanel();
                JPanel buttons = new JPanel();
                buttons.add(b1);
                buttons.add(b2);

                ventana.add(formLlamPanel,BorderLayout.CENTER);
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
                JFrame ventana = new JFrame("Mostrar llamadas");
                JTabbedPane tabs = new JTabbedPane();
                tabs.add("Llamadas por cliente", datosLlamada());
                tabs.add("Listar llamadas por fecha",listarPorFechaLlamadas());
                ventana.add(tabs);
                ventana.pack();
                ventana.setVisible(true);
            }
        });


        return panel;
    }
    private JPanel listarPorFechaClientes(){
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
        buttons.add(b1);

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
                Fecha fechaIni = ImplementaControlador.setFecha(jtf1.getText());
                Fecha fechaFin = ImplementaControlador.setFecha(jtf2.getText());
                try {
                    controlador.fechasCorrectas(fechaIni, fechaFin);
                    ShowTable table = new ShowTable(modelo.clientesFecha(fechaIni, fechaFin));
                    ventana.add(table);
                    ventana.pack();
                    ventana.setVisible(true);
                } catch (FechaInvalida fechaInvalida){
                    fechaInvalida.printStackTrace();
                    new Emergente().showDialog("Error. La fecha de inicio no puede ser posterior a la de fin.");
                }
            }
        });
        return panel;
    }

    private JPanel listarPorFechaLlamadas(){
        ActionListener actionListener;
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        JPanel form = new JPanel();
        form.setLayout(new GridLayout(3,2));

        JLabel lbl0 = new JLabel("NIF:");
        JLabel lbl1 = new JLabel("Fecha inicio:");
        JLabel lbl2 = new JLabel("Fecha fin:");

        JTextField jtf0 = new JTextField();
        JTextField jtf1 = new JTextField("DD/MM/AAAA");
        JTextField jtf2 = new JTextField("DD/MM/AAAA");

        JPanel buttons = new JPanel();
        JButton b1 = new JButton("Aceptar");
        buttons.add(b1);

        form.add(lbl0);
        form.add(jtf0);
        form.add(lbl1);
        form.add(jtf1);
        form.add(lbl2);
        form.add(jtf2);

        panel.add(form);
        panel.add(buttons);

        //TODO Revisar cómo podemos quitar los static de ImplementaControlador

        b1.addActionListener(actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventana = new JFrame("Listado de llamadas por fecha");
                String nif = jtf0.getText();
                Fecha fechaIni = ImplementaControlador.setFecha(jtf1.getText());
                Fecha fechaFin = ImplementaControlador.setFecha(jtf2.getText());
                try {
                    controlador.fechasCorrectas(fechaIni, fechaFin);
                    ShowTableLlamadas table = new ShowTableLlamadas(modelo.llamadasFecha(nif, fechaIni, fechaFin));
                    ventana.add(table);
                    ventana.pack();
                    ventana.setVisible(true);
                } catch (FechaInvalida fechaInvalida){
                    fechaInvalida.printStackTrace();
                    new Emergente().showDialog("Error. La fecha de inicio no puede ser posterior a la de fin.");
                }
            }
        });
        return panel;
    }

    private JPanel listarPorFechaFacturas(){
        ActionListener actionListener;
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        JPanel form = new JPanel();
        form.setLayout(new GridLayout(3,2));

        JLabel lbl0 = new JLabel("NIF:");
        JLabel lbl1 = new JLabel("Fecha inicio:");
        JLabel lbl2 = new JLabel("Fecha fin:");

        JTextField jtf0 = new JTextField();
        JTextField jtf1 = new JTextField("DD/MM/AAAA");
        JTextField jtf2 = new JTextField("DD/MM/AAAA");

        JPanel buttons = new JPanel();
        JButton b1 = new JButton("Aceptar");
        buttons.add(b1);

        form.add(lbl0);
        form.add(jtf0);
        form.add(lbl1);
        form.add(jtf1);
        form.add(lbl2);
        form.add(jtf2);

        panel.add(form);
        panel.add(buttons);

        //TODO Revisar cómo podemos quitar los static de ImplementaControlador

        b1.addActionListener(actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventana = new JFrame("Listado de facturas por fecha");
                String nif = jtf0.getText();
                Fecha fechaIni = ImplementaControlador.setFecha(jtf1.getText());
                Fecha fechaFin = ImplementaControlador.setFecha(jtf2.getText());
                try {
                    controlador.fechasCorrectas(fechaIni, fechaFin);
                    ShowTableFacturas table = new ShowTableFacturas(modelo.facturasFecha(nif, fechaIni, fechaFin));
                    ventana.add(table);
                    ventana.pack();
                    ventana.setVisible(true);
                }catch (FechaInvalida fechaInvalida){
                    fechaInvalida.printStackTrace();
                    new Emergente().showDialog("Error. La fecha de inicio no puede ser posterior a la de fin.");
                }
            }
        });
        return panel;
    }

    private JPanel datosCliente(){
        ActionListener actionListener;
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        JButton b1 = new JButton("Aceptar");

        JPanel form = pedirCliente.getPanel();
        JPanel buttons = new JPanel();
        buttons.add(b1);
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

    private JPanel datosLlamada(){
        ActionListener actionListener;
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        JButton b1 = new JButton("Aceptar");

        JPanel form = pedirCliente.getPanel();
        JPanel buttons = new JPanel();
        buttons.add(b1);
        panel.add(form);
        panel.add(buttons);

        b1.addActionListener(actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nif = pedirCliente.getNif();
                    Cliente cliente = modelo.clienteExiste(nif);
                    JFrame ventana = new JFrame("Llamadas cliente");
                    ShowTableLlamadas table = new ShowTableLlamadas(cliente.getLlamadas());
                    ventana.add(table,BorderLayout.CENTER);
                    ventana.pack();
                    ventana.setVisible(true); // Hacer visible
                } catch (ClienteNoExiste clienteNoExiste){
                    new Emergente().showDialog("No existe ningín cliente con ese NIF.");
                    clienteNoExiste.printStackTrace();
                }
            }
        });

        return panel;
    }

    private JPanel datosFactura(){
        ActionListener actionListener;
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        JButton b1 = new JButton("Aceptar");

        JPanel form = pedirCliente.getPanel();
        JPanel buttons = new JPanel();
        buttons.add(b1);
        panel.add(form);
        panel.add(buttons);

        b1.addActionListener(actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nif = pedirCliente.getNif();
                    JFrame ventana = new JFrame("Facturas cliente");
                    ShowTableFacturas table = new ShowTableFacturas(modelo.clienteExiste(nif).getListaFacturas());
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

    private JPanel datosFacturaConcreto(){
        ActionListener actionListener;
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));
        JButton b1 = new JButton("Aceptar");

        JPanel form = pedirFacturaCliente.getPanel();
        JPanel buttons = new JPanel();
        buttons.add(b1);
        panel.add(form);
        panel.add(buttons);

        b1.addActionListener(actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String nif = pedirFacturaCliente.getNif();
                    String code = pedirFacturaCliente.getCode();
                    ArrayList<Factura> list = new ArrayList<Factura>();
                    list.add(modelo.clienteExiste(nif).getFactura(code));
                    JFrame ventana = new JFrame("Factura cliente");
                    ShowTableFacturas table = new ShowTableFacturas(list);
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

        // todo Los nombre de las referencias de estos botones debéis mejorarlos.
        // TODO Hecho!
        JButton jbAltaEmpresa = new JButton("Alta Empresa");
        JButton jbAltaPatricular = new JButton("Alta Particular");
        JButton jbBajaCliente = new JButton("Baja cliente");
        JButton jbMostrarDatos = new JButton("Mostrar datos");
        JButton jbModificarTarifa = new JButton("Modificar tarifa");

        panel.add(jbAltaEmpresa);
        panel.add(jbAltaPatricular);
        panel.add(jbBajaCliente);
        panel.add(jbMostrarDatos);
        panel.add(jbModificarTarifa);



        jbAltaEmpresa.addActionListener(actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionListener actionListener; // todo No lo habéis usasado ¿cuál era la idea para esta referencia?
                // TODO Se usa en la clase interna declarada en este mismo método. REVISAR
                EscuchadoraAnyadirCliente escuchadoraAnyadirCliente = new EscuchadoraAnyadirCliente();
                JFrame ventana = new JFrame("Alta empresa");

                JButton b1 = new JButton("Aceptar");
                b1.addActionListener(escuchadoraAnyadirCliente);
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


        jbAltaPatricular.addActionListener(actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ActionListener actionListener;
                System.out.println("Particular");
                EscuchadoraAnyadirCliente escuchadoraAnyadirCliente = new EscuchadoraAnyadirCliente();
                JFrame ventana = new JFrame("Alta particular");


                JButton b1 = new JButton("Aceptar");
                b1.addActionListener(escuchadoraAnyadirCliente);
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

        jbBajaCliente.addActionListener(actionListener = new ActionListener() {
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

        jbMostrarDatos.addActionListener(actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame ventana = new JFrame("Mostrar datos");
                JTabbedPane tabs = new JTabbedPane();
                tabs.add("Listado de clientes",new ShowTable(modelo.getClientes()));
                tabs.add("Mostrar datos cliente",datosCliente());
                tabs.add("Listar clientes por fecha",listarPorFechaClientes());
                ventana.add(tabs);
                ventana.pack();
                ventana.setVisible(true);
            }
        });

        jbModificarTarifa.addActionListener(actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame ventana = new JFrame("Modificar tarifa");
                EscuchadoraModificarTarifa escuchadora = new EscuchadoraModificarTarifa();

                // Panel tarifa por hora
                JPanel panelTarifaHora = new JPanel();
                panelTarifaHora.setLayout(new BoxLayout(panelTarifaHora,BoxLayout.PAGE_AXIS));
                JButton jb6 = new JButton("Añadir tarifa hora");
                jb6.addActionListener(escuchadora);
                panelTarifaHora.add(cambiarTarifa.porHora());
                panelTarifaHora.add(jb6);

                // Panel tarifa por día
                JPanel panelTarifaDia = new JPanel();
                panelTarifaDia.setLayout(new BoxLayout(panelTarifaDia,BoxLayout.PAGE_AXIS));
                JButton jb7 = new JButton("Añadir tarifa día");
                jb7.addActionListener(escuchadora);
                panelTarifaDia.add(cambiarTarifa.porDia());
                panelTarifaDia.add(jb7);

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
        JFrame ventana = new JFrame("Telefonia Movil");
        ventana.addWindowListener(new EscuchadorVentana());
        Container contenedor = ventana.getContentPane();

        // Panel Cliente
        JPanel panelCliente = new JPanel(new GridLayout());
        panelCliente.setLayout(new GridLayout(2,2));
        panelCliente.add(menuCliente());

        ActionListener actionListener;


        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Clientes",panelCliente);
        tabs.add("Llamadas",menuLlamada());
        tabs.add("Facturas",menuFactura());


        contenedor.add(tabs,BorderLayout.CENTER);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // La aplicación se cerrará al cerrar la ventana.
        ventana.pack(); //Tamaño de ventana ajustable
        ventana.setVisible(true); // Hacer visible


    }

    @Override
    public String getNifDia() {
        return cambiarTarifa.getNifDia();
    }

    @Override
    public String getNifHora() {
        return cambiarTarifa.getNifHora();
    }

    @Override
    public double getPercioMinDia() {
        return cambiarTarifa.getPercioMinDia();
    }

    @Override
    public String getDiaSemana() {
        return cambiarTarifa.getDiaSemana();
    }

    @Override
    public double getPrecioMinHora() {
        return cambiarTarifa.getPrecioMinHora();
    }

    @Override
    public String getHoraIni() {
        return cambiarTarifa.getHoraIni();
    }

    @Override
    public String getHoraFin() {
        return cambiarTarifa.getHoraFin();
    }

    public String getNifLlamada(){
        return formLlamada.getNif();
    }

    public String getTel(){
        return formLlamada.getTel();
    }

    public String getDur(){
        return formLlamada.getDur();
    }

    public String getFIni(){
        return formLlamada.getFIni();
    }

    public String getFHora(){
        return formLlamada.getFHora();
    }

    public String getNifFac(){
        return formFactura.getNif();
    }

    public String getCode(){
        return formFactura.getCode();
    }

    public String getFIniFac(){
        return formFactura.getFIni();
    }

    public String getFFinFac(){
        return formFactura.getFFin();
    }

    @Override
    public void clienteAnyadido() {
        new Emergente().showDialog("El cliente ha sido añadido con éxito.");
    }

    @Override
    public void clienteBorrado() {
        new Emergente().showDialog("El cliente ha sido borrado con éxito.");
    }


    class EscuchadorVentana extends WindowAdapter {
        @Override
        public void windowOpened(WindowEvent e) {
            controlador.cargarCartera();
            System.out.println("Se ha cargado la cartera!");
        }

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
            try {
                if (txtButton.equals("Añadir tarifa día")) {
                    controlador.cambiarTarifaDia();
                } else if (txtButton.equals("Añadir tarifa hora")) {
                    controlador.cambiarTarifaHora();

                }
            } catch (ClienteNoExiste clienteNoExiste) {
                clienteNoExiste.printStackTrace();
                new Emergente().showDialog("No existe ningún cliente con ese NIF");
            }
        }
    }


    class EscuchadoraAnyadirCliente implements ActionListener {

        public void actionPerformed(ActionEvent e)  {
            JButton button = (JButton)e.getSource(); // Devuelve un objeto Object.
            String txtButton = button.getText();
            if(txtButton.equals("Aceptar")) {
                try {
                    controlador.pedirCliente();
                } catch (ClientAlreadyExists clientAlreadyExists){
                    clientAlreadyExists.printStackTrace();
                    new Emergente().showDialog("Ya existe un cliente con ese NIF.");
                }
            }
            else if(txtButton.equals("Cancelar"))
                System.out.println("Has cancelado.");
        }
    }

    public void creaGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
