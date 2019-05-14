    /*
     * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
     *
     * Redistribution and use in source and binary forms, with or without
     * modification, are permitted provided that the following conditions
     * are met:
     *
     *   - Redistributions of source code must retain the above copyright
     *     notice, this list of conditions and the following disclaimer.
     *
     *   - Redistributions in binary form must reproduce the above copyright
     *     notice, this list of conditions and the following disclaimer in the
     *     documentation and/or other materials provided with the distribution.
     *
     *   - Neither the name of Oracle or the names of its
     *     contributors may be used to endorse or promote products derived
     *     from this software without specific prior written permission.
     *
     * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
     * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
     * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
     * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
     * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
     * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
     * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
     * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
     * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
     * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
     * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
     */

    package View.clientes;

    import Modelo.datos.clientes.Cliente;

    import javax.swing.JPanel;
    import javax.swing.JScrollPane;
    import javax.swing.JTable;
    import java.awt.Dimension;
    import java.awt.GridLayout;
    import java.util.ArrayList;
    import java.util.Iterator;

    import java.util.List;
    import java.util.Map;


    public class ShowTable extends JPanel {

        public ShowTable(List<Cliente> list) {
            super(new GridLayout(1,0));

            String[] columnNames = {"Nombre",
                    "NIF",
                    "Fecha de alta"
            };

            int numCols = columnNames.length;
            int numClientes = list.size();

            Object[][] matrix = new Object[numClientes][numCols];

            for(int i = 0; i<numClientes; i++) {
                matrix[i][0] = list.get(i).getNombre();
                matrix[i][1] = list.get(i).getNif();
                matrix[i][2] = list.get(i).getFecha();
            }
            createTable(matrix,columnNames);
        }

        public ShowTable(Map<String, Cliente> clientes) {
            super(new GridLayout(1,0));

            String[] columnNames = {"Nombre",
                    "NIF",
                    "Fecha de alta"
                    };


            int numClientes = clientes.size();
            int numCols = columnNames.length;


            ArrayList<Cliente> l = new ArrayList<>();
            Iterator<String> iter = clientes.keySet().iterator();
            while (iter.hasNext()){
                l.add(clientes.get(iter.next()));
            }

            Object[][] matrix = new Object[numClientes][numCols];

            for(int i = 0; i<numClientes; i++) {
                matrix[i][0] = l.get(i).getNombre();
                matrix[i][1] = l.get(i).getNif();
                matrix[i][2] = l.get(i).getFecha();
            }

            createTable(matrix,columnNames);
        }

        private void createTable(Object[][] matrix, String[] columnNames){
            final JTable table = new JTable(matrix, columnNames);
            table.setPreferredScrollableViewportSize(new Dimension(500, 70));
            table.setFillsViewportHeight(true);

            //Create the scroll pane and add the table to it.
            JScrollPane scrollPane = new JScrollPane(table);

            //Add the scroll pane to this panel.
            add(scrollPane);
        }

    }


