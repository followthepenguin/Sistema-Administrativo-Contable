package paneles;
import frames.JFramePrincipal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import servicios.Conexion;
import modulos.Eventos;
import modulos.Trabajadores;
import servicios.EditorTablaEventos;
/**
 *
 * @author t0ken
 */
public class JPanelEventos extends javax.swing.JPanel 
{
    private static final String TITULO_PANEL="Eventos";
    private static final String TITULO_BOTON_SALIR="Salir";
    private static final String TITULO_NOMBRE_EVENTO="Nombre del evento *";
    private static final String TITULO_FECHA_EVENTO="Fecha del evento *";
    private static final String TITULO_DESCRIPCION_EVENTO="Descripción del evento *";
    private static final String TITULO_TRABAJADOR_EVENTO="Trabajador del evento *";
    
    private static final String TITULO_BOTON_AGREGAR_EVENTO="Agregar evento";
    private static final String TITULO_BOTON_ELIMINAR_EVENTO="Borrar evento";
    
    private String nombreEvento;
    private String fechaEvento;
    private String descripcionEvento;
    private String trabajadorEvento;
    
    private Trabajadores trabajadores=new Trabajadores();
    private Eventos eventos=new Eventos();
    private DefaultTableModel modeloTabla=new DefaultTableModel();
    
    public JPanelEventos() 
    {
        initComponents();
        
        jComboBoxTrabajadorEvento.removeAllItems();
        jComboBoxTrabajadorEvento.addItem("");
        for(Object o:trabajadores.consultarNombre(Conexion.getConexion()))
        {
            jComboBoxTrabajadorEvento.addItem(o.toString());
        }
        cargarTabla();
    }
    
    private void cargarTabla()
    {
        ArrayList <Eventos> datos= eventos.consultarTodo(Conexion.getConexion());
        String[] columnas={"ID EVENTO","NOMBRE","FECHA","DESCRIPCIÓN","TRABAJADOR EVENTO"};
        modeloTabla.setColumnIdentifiers(columnas);
        Object[] fila = new Object[modeloTabla.getColumnCount()];
        
        for (int i = jTableEventos.getRowCount() -1; i >= 0; i--)
        {
            modeloTabla.removeRow(i);
        }
        
        for(int i=0;i<datos.size();i++)
        {
            fila[0]=datos.get(i).getIdEvento();
            fila[1]=datos.get(i).getNombreEvento();
            fila[2]=datos.get(i).getFechaEvento();
            fila[3]=datos.get(i).getDescripcionEvento();
            fila[4]=trabajadores.consultarNombrePorId(Conexion.getConexion(),datos.get(i).getIdTrabajadorEvento());
            
            modeloTabla.addRow(fila);
        }
        
        jTableEventos.setModel(modeloTabla);
        
        jTableEventos.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableEventos.getColumnModel().getColumn(0).setMinWidth(0);
        jTableEventos.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jTableEventos.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        jTableEventos.getColumnModel().getColumn( 1 ).setCellEditor(new EditorTablaEventos(eventos,"nombre_evento"));
        jTableEventos.getColumnModel().getColumn( 2 ).setCellEditor(new EditorTablaEventos(eventos,"fecha_evento"));
        jTableEventos.getColumnModel().getColumn( 3 ).setCellEditor(new EditorTablaEventos(eventos,"descripcion_evento"));
        jTableEventos.getColumnModel().getColumn( 4 ).setCellEditor(new EditorTablaEventos(eventos,"id_trabajador_evento"));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jLabelNombreEvento = new javax.swing.JLabel();
        jTextFieldNombreEvento = new javax.swing.JTextField();
        jLabelFechaEvento = new javax.swing.JLabel();
        jFormattedTextFieldFechaEvento = new javax.swing.JFormattedTextField();
        jLabelDescripcionEvento = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescripcionEvento = new javax.swing.JTextArea();
        jLabelTrabajadorEvento = new javax.swing.JLabel();
        jComboBoxTrabajadorEvento = new javax.swing.JComboBox<>();
        jButtonAgregarEvento = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEventos = new javax.swing.JTable();
        jButtonEliminarEvento = new javax.swing.JButton();
        jButtonLogo = new javax.swing.JButton();

        jLabelTitulo.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabelTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eventos.png"))); // NOI18N
        jLabelTitulo.setText(TITULO_PANEL);

        jLabelNombreEvento.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelNombreEvento.setText(TITULO_NOMBRE_EVENTO);

        jTextFieldNombreEvento.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N

        jLabelFechaEvento.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelFechaEvento.setText(TITULO_FECHA_EVENTO
        );

        jFormattedTextFieldFechaEvento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("dd/MM/yyyy"))));
        jFormattedTextFieldFechaEvento.setText("DD/MM/AAAA");
        jFormattedTextFieldFechaEvento.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jFormattedTextFieldFechaEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFormattedTextFieldFechaEventoActionPerformed(evt);
            }
        });

        jLabelDescripcionEvento.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelDescripcionEvento.setText(TITULO_DESCRIPCION_EVENTO);

        jTextAreaDescripcionEvento.setColumns(20);
        jTextAreaDescripcionEvento.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jTextAreaDescripcionEvento.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDescripcionEvento);

        jLabelTrabajadorEvento.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelTrabajadorEvento.setText(TITULO_TRABAJADOR_EVENTO);

        jComboBoxTrabajadorEvento.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jComboBoxTrabajadorEvento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonAgregarEvento.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jButtonAgregarEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AgregarEvento.png"))); // NOI18N
        jButtonAgregarEvento.setText(TITULO_BOTON_AGREGAR_EVENTO);
        jButtonAgregarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarEventoActionPerformed(evt);
            }
        });

        jButtonSalir.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/SalirPanel.png"))); // NOI18N
        jButtonSalir.setText(TITULO_BOTON_SALIR);
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jTableEventos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableEventos);

        jButtonEliminarEvento.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jButtonEliminarEvento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eliminar.png"))); // NOI18N
        jButtonEliminarEvento.setText(TITULO_BOTON_ELIMINAR_EVENTO);
        jButtonEliminarEvento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarEventoActionPerformed(evt);
            }
        });

        jButtonLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/IconoJframeMasPequeno.png"))); // NOI18N
        jButtonLogo.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        jButtonLogo.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSalir)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTitulo)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelNombreEvento)
                                    .addComponent(jLabelFechaEvento)
                                    .addComponent(jLabelDescripcionEvento)
                                    .addComponent(jLabelTrabajadorEvento))
                                .addGap(99, 99, 99)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFormattedTextFieldFechaEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldNombreEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxTrabajadorEvento, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButtonAgregarEvento, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLogo))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonEliminarEvento)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 160, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldNombreEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelNombreEvento)))
                            .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonLogo))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelFechaEvento)
                    .addComponent(jFormattedTextFieldFechaEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDescripcionEvento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxTrabajadorEvento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTrabajadorEvento))
                .addGap(12, 12, 12)
                .addComponent(jButtonAgregarEvento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEliminarEvento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSalir)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarEventoActionPerformed
        // TODO add your handling code here:
        
        ArrayList<Object> datos=new ArrayList();
        String fechaEvento="";
        if(jTextFieldNombreEvento.getText().equals("") || jFormattedTextFieldFechaEvento.getText().equals("") || jTextAreaDescripcionEvento.getText().equals("") || jComboBoxTrabajadorEvento.getSelectedItem().toString().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Completa los campos");
        }
        
        
        else
        {
            try
            {
                this.nombreEvento=jTextFieldNombreEvento.getText();
                fechaEvento=jFormattedTextFieldFechaEvento.getText();
                this.descripcionEvento=jTextAreaDescripcionEvento.getText();
                this.trabajadorEvento=jComboBoxTrabajadorEvento.getSelectedItem().toString();
            
                this.fechaEvento=fechaEvento.substring(6,10)+fechaEvento.substring(3,5)+fechaEvento.substring(0,2);
            
                datos.add(this.nombreEvento);
                datos.add(this.fechaEvento);
                datos.add(this.descripcionEvento);
                datos.add(this.trabajadorEvento);
            
                eventos.guardar(Conexion.getConexion(),datos);
                
                jTextFieldNombreEvento.setText("");
                jFormattedTextFieldFechaEvento.setText("");
                jTextAreaDescripcionEvento.setText("");
                jComboBoxTrabajadorEvento.setSelectedItem("");
                
                eventos=new Eventos();
                cargarTabla();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Compruebe que los datos son correctos");
            };
        }
        
    }//GEN-LAST:event_jButtonAgregarEventoActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        JFramePrincipal.mostrarMenu(JFramePrincipal.getNombreCategoriaTrabajador());
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jFormattedTextFieldFechaEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFormattedTextFieldFechaEventoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFormattedTextFieldFechaEventoActionPerformed

    private void jButtonEliminarEventoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarEventoActionPerformed
        // TODO add your handling code here:
        ArrayList<Object> registros=new ArrayList();
        int[] indicesRegistros=jTableEventos.getSelectedRows();
        
        for(int i:indicesRegistros)
        {
            registros.add(jTableEventos.getValueAt(i, 1));
        }
        
        if(registros.isEmpty())
           JOptionPane.showMessageDialog(null, "Ningún registro seleccionado");
        else
        {
            if(eventos.borrar(Conexion.getConexion(),registros))
            JOptionPane.showMessageDialog(null, "Evento borrado");
        }
        cargarTabla();
    }//GEN-LAST:event_jButtonEliminarEventoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarEvento;
    private javax.swing.JButton jButtonEliminarEvento;
    private javax.swing.JButton jButtonLogo;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JComboBox<String> jComboBoxTrabajadorEvento;
    private javax.swing.JFormattedTextField jFormattedTextFieldFechaEvento;
    private javax.swing.JLabel jLabelDescripcionEvento;
    private javax.swing.JLabel jLabelFechaEvento;
    private javax.swing.JLabel jLabelNombreEvento;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTrabajadorEvento;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableEventos;
    private javax.swing.JTextArea jTextAreaDescripcionEvento;
    private javax.swing.JTextField jTextFieldNombreEvento;
    // End of variables declaration//GEN-END:variables

}
