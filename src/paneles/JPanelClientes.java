package paneles;
import frames.JFramePrincipal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modulos.Clientes;
import servicios.Conexion;
import servicios.EditorTablaClientes;
/**
 *
 * @author t0ken
 */
public class JPanelClientes extends javax.swing.JPanel 
{
    private static final String TITULO_PANEL="Clientes";
    private static final String TITULO_BOTON_SALIR="Salir";
    private static final String TITULO_NOMBRE_CLIENTE="Nombre del cliente *";
    private static final String TITULO_APELLIDO_PATERNO_CLIENTE="Apellido paterno del cliente *";
    private static final String TITULO_APELLIDO_MATERNO_CLIENTE="Apellido materno del cliente ";
    private static final String TITULO_DIRECCION_CLIENTE="Dirección del cliente *";
    private static final String TITULO_TELEFONO_CLIENTE="Teléfono del cliente ";
    private static final String TITULO_EMAIL_CLIENTE="E-mail del cliente ";
    
    private static final String TITULO_BOTON_AGREGAR_CLIENTE="Agregar cliente";
    private static final String TITULO_BOTON_ELIMINAR_CLIENTE="Borrar cliente";
    
    private String nombreCliente;
    private String apellidoPaternoCliente;
    private String apellidoMaternoCliente;
    private String direccionCliente;
    private String telefonoCliente;
    private String emailCliente;
    private DefaultTableModel modeloTabla=new DefaultTableModel();
    private Clientes clientes = new Clientes();
    
    public JPanelClientes() 
    {
        initComponents();
        cargarTabla();
    }
    
    private void cargarTabla()
    {
        ArrayList <Clientes> datos= clientes.consultarTodo(Conexion.getConexion());
        String[] columnas={"ID","NOMBRE","APELLIDO PATERNO","APELLIDO MATERNO","DIRECCIÓN","TELÉFONO","E-MAIL"};
        modeloTabla.setColumnIdentifiers(columnas);
        Object[] fila = new Object[modeloTabla.getColumnCount()];
        
        for (int i = jTableClientes.getRowCount() -1; i >= 0; i--)
        {
            modeloTabla.removeRow(i);
        }
        
        for(int i=0;i<datos.size();i++)
        {
            fila[0]=datos.get(i).getIdCliente();
            fila[1]=datos.get(i).getNombreCliente();
            fila[2]=datos.get(i).getApellidoPaternoCliente();
            fila[3]=datos.get(i).getApellidoMaternoCliente();
            fila[4]=datos.get(i).getDireccionCliente();
            fila[5]=datos.get(i).getTelefonoCliente();
            fila[6]=datos.get(i).getEmailCliente();
            modeloTabla.addRow(fila);
        }
        
        jTableClientes.setModel(modeloTabla);
        
        jTableClientes.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableClientes.getColumnModel().getColumn(0).setMinWidth(0);
        jTableClientes.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jTableClientes.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        jTableClientes.getColumnModel().getColumn( 1 ).setCellEditor(new EditorTablaClientes(clientes,"nombre_cliente"));
        jTableClientes.getColumnModel().getColumn( 2 ).setCellEditor(new EditorTablaClientes(clientes,"a_paterno_cliente"));
        jTableClientes.getColumnModel().getColumn( 3 ).setCellEditor(new EditorTablaClientes(clientes,"a_materno_cliente"));
        jTableClientes.getColumnModel().getColumn( 4 ).setCellEditor(new EditorTablaClientes(clientes,"direccion_cliente"));
        jTableClientes.getColumnModel().getColumn( 5 ).setCellEditor(new EditorTablaClientes(clientes,"telefono_cliente"));
        jTableClientes.getColumnModel().getColumn( 6 ).setCellEditor(new EditorTablaClientes(clientes,"email_cliente"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jLabelNombreCliente = new javax.swing.JLabel();
        jLabelApellidoPaternoCliente = new javax.swing.JLabel();
        jLabelApellidoMaternoCliente = new javax.swing.JLabel();
        jTextFieldNombreCliente = new javax.swing.JTextField();
        jTextFieldApellidoPaternoCliente = new javax.swing.JTextField();
        jTextFieldApellidoMaternoCliente = new javax.swing.JTextField();
        jLabelDireccionCliente = new javax.swing.JLabel();
        jTextFieldDireccionCliente = new javax.swing.JTextField();
        jTextFieldTelefonoCliente = new javax.swing.JTextField();
        jLabelTelefonoCliente = new javax.swing.JLabel();
        jLabelEmailCliente = new javax.swing.JLabel();
        jTextFieldEmailCliente = new javax.swing.JTextField();
        jButtonAgregarCliente = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jButtonEliminarCliente = new javax.swing.JButton();
        jButtonLogo = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(950, 600));

        jLabelTitulo.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabelTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Clientes.png"))); // NOI18N
        jLabelTitulo.setText(TITULO_PANEL);

        jLabelNombreCliente.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelNombreCliente.setText(TITULO_NOMBRE_CLIENTE);

        jLabelApellidoPaternoCliente.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelApellidoPaternoCliente.setText(TITULO_APELLIDO_PATERNO_CLIENTE);

        jLabelApellidoMaternoCliente.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelApellidoMaternoCliente.setText(TITULO_APELLIDO_MATERNO_CLIENTE);

        jTextFieldNombreCliente.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N

        jTextFieldApellidoPaternoCliente.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N

        jTextFieldApellidoMaternoCliente.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N

        jLabelDireccionCliente.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelDireccionCliente.setText(TITULO_DIRECCION_CLIENTE);

        jTextFieldDireccionCliente.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N

        jTextFieldTelefonoCliente.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N

        jLabelTelefonoCliente.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelTelefonoCliente.setText(TITULO_TELEFONO_CLIENTE);

        jLabelEmailCliente.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelEmailCliente.setText(TITULO_EMAIL_CLIENTE);

        jTextFieldEmailCliente.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N

        jButtonAgregarCliente.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jButtonAgregarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AgregarCliente.png"))); // NOI18N
        jButtonAgregarCliente.setText(TITULO_BOTON_AGREGAR_CLIENTE);
        jButtonAgregarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarClienteActionPerformed(evt);
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

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableClientes);

        jButtonEliminarCliente.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jButtonEliminarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eliminar.png"))); // NOI18N
        jButtonEliminarCliente.setText(TITULO_BOTON_ELIMINAR_CLIENTE);
        jButtonEliminarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarClienteActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonAgregarCliente)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelTelefonoCliente)
                                            .addComponent(jLabelEmailCliente)
                                            .addComponent(jLabelApellidoMaternoCliente))
                                        .addGap(76, 76, 76))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelNombreCliente)
                                            .addComponent(jLabelApellidoPaternoCliente)
                                            .addComponent(jLabelDireccionCliente))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldApellidoPaternoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldApellidoMaternoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 363, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabelTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jButtonLogo))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonEliminarCliente)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jButtonSalir))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNombreCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelNombreCliente)))
                    .addComponent(jButtonLogo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldApellidoPaternoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelApellidoPaternoCliente))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldApellidoMaternoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelApellidoMaternoCliente))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDireccionCliente)
                    .addComponent(jTextFieldDireccionCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldTelefonoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTelefonoCliente))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldEmailCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEmailCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAgregarCliente)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEliminarCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSalir)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarClienteActionPerformed
        // TODO add your handling code here:
            
        ArrayList<Object> datos=new ArrayList();
        
        if(jTextFieldNombreCliente.getText().equals("") || jTextFieldApellidoPaternoCliente.getText().equals("") || jTextFieldDireccionCliente.getText().equals(""))
        {    
            JOptionPane.showMessageDialog(null, "Complete los campos");
        }
        else
        {
            try
            {
                this.nombreCliente=jTextFieldNombreCliente.getText();
                this.apellidoPaternoCliente=jTextFieldApellidoPaternoCliente.getText();
                this.apellidoMaternoCliente=jTextFieldApellidoMaternoCliente.getText();
                this.direccionCliente=jTextFieldDireccionCliente.getText();
                this.telefonoCliente=jTextFieldTelefonoCliente.getText();
                this.emailCliente=jTextFieldEmailCliente.getText();
            
                datos.add(this.nombreCliente);
                datos.add(this.apellidoPaternoCliente);
                datos.add(this.apellidoMaternoCliente);
                datos.add(this.direccionCliente);
                datos.add(this.telefonoCliente);
                datos.add(this.emailCliente);
                
                clientes.guardar(Conexion.getConexion(),datos);
                
                jTextFieldNombreCliente.setText("");
                jTextFieldApellidoPaternoCliente.setText("");
                jTextFieldApellidoMaternoCliente.setText("");
                jTextFieldDireccionCliente.setText("");
                jTextFieldTelefonoCliente.setText("");
                jTextFieldEmailCliente.setText("");
                clientes=new Clientes();
                cargarTabla();
            }
            catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "Algunos campos sólo aceptan números");
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Compruebe que los datos son correctos");
            }
        }
    }//GEN-LAST:event_jButtonAgregarClienteActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        JFramePrincipal.mostrarMenu(JFramePrincipal.getNombreCategoriaTrabajador());
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonEliminarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarClienteActionPerformed
        // TODO add your handling code here:
        ArrayList<Object> registros=new ArrayList();
        int[] indicesRegistros=jTableClientes.getSelectedRows();

        for(int i:indicesRegistros)
        {
            registros.add(jTableClientes.getValueAt(i, 1));
        }
        
        if(registros.isEmpty())
           JOptionPane.showMessageDialog(null, "Ningún registro seleccionado");
        else
        {
            if(clientes.borrar(Conexion.getConexion(),registros))
                JOptionPane.showMessageDialog(null, "Cliente borrado");
        }
        cargarTabla();
    }//GEN-LAST:event_jButtonEliminarClienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarCliente;
    private javax.swing.JButton jButtonEliminarCliente;
    private javax.swing.JButton jButtonLogo;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabelApellidoMaternoCliente;
    private javax.swing.JLabel jLabelApellidoPaternoCliente;
    private javax.swing.JLabel jLabelDireccionCliente;
    private javax.swing.JLabel jLabelEmailCliente;
    private javax.swing.JLabel jLabelNombreCliente;
    private javax.swing.JLabel jLabelTelefonoCliente;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTextField jTextFieldApellidoMaternoCliente;
    private javax.swing.JTextField jTextFieldApellidoPaternoCliente;
    private javax.swing.JTextField jTextFieldDireccionCliente;
    private javax.swing.JTextField jTextFieldEmailCliente;
    private javax.swing.JTextField jTextFieldNombreCliente;
    private javax.swing.JTextField jTextFieldTelefonoCliente;
    // End of variables declaration//GEN-END:variables

}
