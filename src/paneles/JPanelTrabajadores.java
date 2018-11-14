package paneles;
import frames.JFramePrincipal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modulos.Categorias;
import modulos.Trabajadores;
import servicios.Conexion;
import servicios.EditorTablaTrabajadores;
/**
 *
 * @author t0ken
 */
public class JPanelTrabajadores extends javax.swing.JPanel 
{
    private static final String TITULO_PANEL="Trabajadores";
    private static final String TITULO_BOTON_SALIR="Salir";
    private static final String TITULO_NOMBRE_TRABAJADOR="Nombre del trabajador *";
    private static final String TITULO_APELLIDO_PATERNO_TRABAJADOR="Apellido paterno del trabajador *";
    private static final String TITULO_APELLIDO_MATERNO_TRABAJADOR="Apellido materno del trabajador ";
    private static final String TITULO_DIRECCION_TRABAJADOR="Dirección del trabajador *";
    private static final String TITULO_TELEFONO_TRABAJADOR="Teléfono del trabajador ";
    private static final String TITULO_EMAIL_TRABAJADOR="E-mail del trabajador ";
    private static final String TITULO_USUARIO_TRABAJADOR="Usuario del trabajador *";
    private static final String TITULO_CONTRASENA_TRABAJADOR="Contraseña del trabajador *";
    private static final String TITULO_CATEGORIA_TRABAJADOR="Categoría del trabajador *";
    
    private static final String TITULO_BOTON_AGREGAR_TRABAJADOR="Agregar Trabajador";
    private static final String TITULO_BOTON_ELIMINAR_TRABAJADOR="Borrar Trabajador";
    
    private String nombreTrabajador;
    private String apellidoPaternoTrabajador;
    private String apellidoMaternoTrabajador;
    private String direccionTrabajador;
    private String telefonoTrabajador;
    private String emailTrabajador;
    private String usuarioTrabajador;
    private String contrasenaTrabajador;
    private String categoriaTrabajador;
    
    private Trabajadores trabajadores=new Trabajadores();
    private Categorias categorias=new Categorias();
    private DefaultTableModel modeloTabla=new DefaultTableModel();
    
    public JPanelTrabajadores() {
        initComponents();
    
        jComboBoxCategoriaTrabajador.removeAllItems();
        jComboBoxCategoriaTrabajador.addItem("");
        for(Object o:categorias.consultarNombre(Conexion.getConexion()))
        {
            jComboBoxCategoriaTrabajador.addItem(o.toString());
        }
        cargarTabla();
    }
    
    private void cargarTabla()
    {
        ArrayList <Trabajadores> datos= trabajadores.consultarTodo(Conexion.getConexion());
        String[] columnas={"ID TRABAJADOR","NOMBRE","APELLIDO PATERNO","APELLIDO MATERNO","DIRECCIÓN","TELÉFONO","E-MAIL","USUARIO","CATEGORIA"};
        modeloTabla.setColumnIdentifiers(columnas);
        Object[] fila = new Object[modeloTabla.getColumnCount()];
        
        for (int i = jTableTrabajadores.getRowCount() -1; i >= 0; i--)
        {
            modeloTabla.removeRow(i);
        }
        
        for(int i=0;i<datos.size();i++)
        {
            fila[0]=datos.get(i).getIdTrabajador();
            fila[1]=datos.get(i).getNombreTrabajador();
            fila[2]=datos.get(i).getApellidoPaternoTrabajador();
            fila[3]=datos.get(i).getApellidoMaternoTrabajador();
            fila[4]=datos.get(i).getDireccionTrabajador();
            fila[5]=datos.get(i).getTelefonoTrabajador();
            fila[6]=datos.get(i).getEmailTrabajador();
            fila[7]=datos.get(i).getUsuarioTrabajador();
            //fila[8]=datos.get(i).getContrasenaTrabajador();
            fila[8]=categorias.consultarNombrePorId(Conexion.getConexion(),datos.get(i).getIdCategoriaTrabajador());
            
            modeloTabla.addRow(fila);
        }
        
        jTableTrabajadores.setModel(modeloTabla);
        
        jTableTrabajadores.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableTrabajadores.getColumnModel().getColumn(0).setMinWidth(0);
        jTableTrabajadores.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jTableTrabajadores.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        jTableTrabajadores.getColumnModel().getColumn( 1 ).setCellEditor(new EditorTablaTrabajadores(trabajadores,"nombre_trabajador"));
        jTableTrabajadores.getColumnModel().getColumn( 2 ).setCellEditor(new EditorTablaTrabajadores(trabajadores,"a_paterno_trabajador"));
        jTableTrabajadores.getColumnModel().getColumn( 3 ).setCellEditor(new EditorTablaTrabajadores(trabajadores,"a_materno_trabajador"));
        jTableTrabajadores.getColumnModel().getColumn( 4 ).setCellEditor(new EditorTablaTrabajadores(trabajadores,"direccion_trabajador"));
        jTableTrabajadores.getColumnModel().getColumn( 5 ).setCellEditor(new EditorTablaTrabajadores(trabajadores,"telefono_trabajador"));
        jTableTrabajadores.getColumnModel().getColumn( 6 ).setCellEditor(new EditorTablaTrabajadores(trabajadores,"email_trabajador"));
        jTableTrabajadores.getColumnModel().getColumn( 7 ).setCellEditor(new EditorTablaTrabajadores(trabajadores,"usuario_trabajador"));
        //jTableTrabajadores.getColumnModel().getColumn( 8 ).setCellEditor(new EditorTablaTrabajadores(trabajadores,"contrasena_trabajador"));
        jTableTrabajadores.getColumnModel().getColumn( 8 ).setCellEditor(new EditorTablaTrabajadores(trabajadores,"id_categoria_trabajador"));
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jLabelNombreTrabajador = new javax.swing.JLabel();
        jLabelApellidoPaternoTrabajador = new javax.swing.JLabel();
        jLabelApellidoMaternoTrabajador = new javax.swing.JLabel();
        jTextFieldNombreTrabajador = new javax.swing.JTextField();
        jTextFieldApellidoPaternoTrabajador = new javax.swing.JTextField();
        jTextFieldApellidoMaternoTrabajador = new javax.swing.JTextField();
        jLabelDireccionTrabajador = new javax.swing.JLabel();
        jTextFieldDireccionTrabajador = new javax.swing.JTextField();
        jTextFieldTelefonoTrabajador = new javax.swing.JTextField();
        jLabelTelefonoTrabajador = new javax.swing.JLabel();
        jLabelEmailTrabajador = new javax.swing.JLabel();
        jTextFieldEmailTrabajador = new javax.swing.JTextField();
        jLabelUsuarioTrabajador = new javax.swing.JLabel();
        jTextFieldUsuarioTrabajador = new javax.swing.JTextField();
        jLabelContrasenaTrabajador = new javax.swing.JLabel();
        jPasswordFieldContrasenaTrabajador = new javax.swing.JPasswordField();
        jLabelCategoriaTrabajador = new javax.swing.JLabel();
        jComboBoxCategoriaTrabajador = new javax.swing.JComboBox<>();
        jButtonAgregarTrabajador = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTrabajadores = new javax.swing.JTable();
        jButtonEliminarTrabajador = new javax.swing.JButton();
        jButtonLogo = new javax.swing.JButton();

        jLabelTitulo.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabelTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Trabajadores.png"))); // NOI18N
        jLabelTitulo.setText(TITULO_PANEL);

        jLabelNombreTrabajador.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelNombreTrabajador.setText(TITULO_NOMBRE_TRABAJADOR);

        jLabelApellidoPaternoTrabajador.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelApellidoPaternoTrabajador.setText(TITULO_APELLIDO_PATERNO_TRABAJADOR);

        jLabelApellidoMaternoTrabajador.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelApellidoMaternoTrabajador.setText(TITULO_APELLIDO_MATERNO_TRABAJADOR);

        jTextFieldNombreTrabajador.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jTextFieldNombreTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNombreTrabajadorActionPerformed(evt);
            }
        });

        jTextFieldApellidoPaternoTrabajador.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N

        jTextFieldApellidoMaternoTrabajador.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N

        jLabelDireccionTrabajador.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelDireccionTrabajador.setText(TITULO_DIRECCION_TRABAJADOR);

        jTextFieldDireccionTrabajador.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N

        jTextFieldTelefonoTrabajador.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N

        jLabelTelefonoTrabajador.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelTelefonoTrabajador.setText(TITULO_TELEFONO_TRABAJADOR);

        jLabelEmailTrabajador.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelEmailTrabajador.setText(TITULO_EMAIL_TRABAJADOR);

        jTextFieldEmailTrabajador.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N

        jLabelUsuarioTrabajador.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelUsuarioTrabajador.setText(TITULO_USUARIO_TRABAJADOR);

        jTextFieldUsuarioTrabajador.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N

        jLabelContrasenaTrabajador.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelContrasenaTrabajador.setText(TITULO_CONTRASENA_TRABAJADOR);

        jPasswordFieldContrasenaTrabajador.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jPasswordFieldContrasenaTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordFieldContrasenaTrabajadorActionPerformed(evt);
            }
        });

        jLabelCategoriaTrabajador.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelCategoriaTrabajador.setText(TITULO_CATEGORIA_TRABAJADOR);

        jComboBoxCategoriaTrabajador.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jComboBoxCategoriaTrabajador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxCategoriaTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategoriaTrabajadorActionPerformed(evt);
            }
        });

        jButtonAgregarTrabajador.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jButtonAgregarTrabajador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AgregarUsuario.png"))); // NOI18N
        jButtonAgregarTrabajador.setText(TITULO_BOTON_AGREGAR_TRABAJADOR);
        jButtonAgregarTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarTrabajadorActionPerformed(evt);
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

        jTableTrabajadores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableTrabajadores);

        jButtonEliminarTrabajador.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jButtonEliminarTrabajador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eliminar.png"))); // NOI18N
        jButtonEliminarTrabajador.setText(TITULO_BOTON_ELIMINAR_TRABAJADOR);
        jButtonEliminarTrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarTrabajadorActionPerformed(evt);
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
                    .addComponent(jLabelTitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNombreTrabajador)
                            .addComponent(jLabelApellidoPaternoTrabajador)
                            .addComponent(jLabelApellidoMaternoTrabajador)
                            .addComponent(jLabelTelefonoTrabajador)
                            .addComponent(jLabelEmailTrabajador)
                            .addComponent(jLabelUsuarioTrabajador)
                            .addComponent(jLabelContrasenaTrabajador)
                            .addComponent(jLabelCategoriaTrabajador)
                            .addComponent(jLabelDireccionTrabajador))
                        .addGap(110, 110, 110)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldApellidoPaternoTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldNombreTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldApellidoMaternoTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldDireccionTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTelefonoTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldEmailTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldUsuarioTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPasswordFieldContrasenaTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxCategoriaTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonAgregarTrabajador, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonLogo))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButtonEliminarTrabajador)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonSalir)))
                .addGap(0, 150, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jButtonLogo)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldNombreTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNombreTrabajador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldApellidoPaternoTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelApellidoPaternoTrabajador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldApellidoMaternoTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelApellidoMaternoTrabajador))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldDireccionTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDireccionTrabajador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldTelefonoTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTelefonoTrabajador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldEmailTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelEmailTrabajador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldUsuarioTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelUsuarioTrabajador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordFieldContrasenaTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelContrasenaTrabajador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxCategoriaTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCategoriaTrabajador))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAgregarTrabajador)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEliminarTrabajador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jButtonSalir)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarTrabajadorActionPerformed
        // TODO add your handling code here:
        
        String contrasenaTrabajador = ""; 
        
        ArrayList<Object> datos=new ArrayList();

        if (jTextFieldNombreTrabajador.getText().equals("") || jTextFieldApellidoPaternoTrabajador.getText().equals("") || jTextFieldDireccionTrabajador.getText().equals("") || jTextFieldUsuarioTrabajador.getText().equals("") || jPasswordFieldContrasenaTrabajador.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete los campos");
        } else {
            try {
                this.nombreTrabajador = jTextFieldNombreTrabajador.getText();
                this.apellidoPaternoTrabajador = jTextFieldApellidoPaternoTrabajador.getText();
                this.apellidoMaternoTrabajador = jTextFieldApellidoMaternoTrabajador.getText();
                this.direccionTrabajador = jTextFieldDireccionTrabajador.getText();
                this.telefonoTrabajador = jTextFieldTelefonoTrabajador.getText();
                this.emailTrabajador = jTextFieldEmailTrabajador.getText();
                this.usuarioTrabajador = jTextFieldUsuarioTrabajador.getText();
                this.categoriaTrabajador = jComboBoxCategoriaTrabajador.getSelectedItem().toString();

                for (char c : jPasswordFieldContrasenaTrabajador.getPassword()) {
                    contrasenaTrabajador = contrasenaTrabajador + c;
                }
                
                this.contrasenaTrabajador = contrasenaTrabajador;

                datos.add(this.nombreTrabajador);
                datos.add(this.apellidoPaternoTrabajador);
                datos.add(this.apellidoMaternoTrabajador);
                datos.add(this.direccionTrabajador);
                datos.add(this.telefonoTrabajador);
                datos.add(this.emailTrabajador);
                datos.add(this.usuarioTrabajador);
                datos.add(this.contrasenaTrabajador);
                datos.add(this.categoriaTrabajador);

                trabajadores.guardar(Conexion.getConexion(), datos);

                jTextFieldNombreTrabajador.setText("");
                jTextFieldApellidoPaternoTrabajador.setText("");
                jTextFieldApellidoMaternoTrabajador.setText("");
                jTextFieldDireccionTrabajador.setText("");
                jTextFieldTelefonoTrabajador.setText("");
                jTextFieldEmailTrabajador.setText("");
                jTextFieldUsuarioTrabajador.setText("");
                jPasswordFieldContrasenaTrabajador.setText("");
                jComboBoxCategoriaTrabajador.setSelectedItem("");
                trabajadores=new Trabajadores();
                cargarTabla();
                
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Algunos campos sólo aceptan números");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Compruebe que los datos sean correctos");
            };

        }
    }//GEN-LAST:event_jButtonAgregarTrabajadorActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        JFramePrincipal.mostrarMenu(JFramePrincipal.getNombreCategoriaTrabajador());
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jPasswordFieldContrasenaTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordFieldContrasenaTrabajadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldContrasenaTrabajadorActionPerformed

    private void jComboBoxCategoriaTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategoriaTrabajadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCategoriaTrabajadorActionPerformed

    private void jButtonEliminarTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarTrabajadorActionPerformed
        // TODO add your handling code here:
        ArrayList<Object> registros=new ArrayList();
        int[] indicesRegistros=jTableTrabajadores.getSelectedRows();
        
        for(int i:indicesRegistros)
        {
            if(i!=0)
            registros.add(jTableTrabajadores.getValueAt(i, 7));
        }
        
        if(registros.isEmpty())
           JOptionPane.showMessageDialog(null, "Ningún registro seleccionado");
        else
        {
            if(trabajadores.borrar(Conexion.getConexion(),registros))
                JOptionPane.showMessageDialog(null, "Trabajador borrado");
        }
        cargarTabla();
    }//GEN-LAST:event_jButtonEliminarTrabajadorActionPerformed

    private void jTextFieldNombreTrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNombreTrabajadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNombreTrabajadorActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarTrabajador;
    private javax.swing.JButton jButtonEliminarTrabajador;
    private javax.swing.JButton jButtonLogo;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JComboBox<String> jComboBoxCategoriaTrabajador;
    private javax.swing.JLabel jLabelApellidoMaternoTrabajador;
    private javax.swing.JLabel jLabelApellidoPaternoTrabajador;
    private javax.swing.JLabel jLabelCategoriaTrabajador;
    private javax.swing.JLabel jLabelContrasenaTrabajador;
    private javax.swing.JLabel jLabelDireccionTrabajador;
    private javax.swing.JLabel jLabelEmailTrabajador;
    private javax.swing.JLabel jLabelNombreTrabajador;
    private javax.swing.JLabel jLabelTelefonoTrabajador;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelUsuarioTrabajador;
    private javax.swing.JPasswordField jPasswordFieldContrasenaTrabajador;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableTrabajadores;
    private javax.swing.JTextField jTextFieldApellidoMaternoTrabajador;
    private javax.swing.JTextField jTextFieldApellidoPaternoTrabajador;
    private javax.swing.JTextField jTextFieldDireccionTrabajador;
    private javax.swing.JTextField jTextFieldEmailTrabajador;
    private javax.swing.JTextField jTextFieldNombreTrabajador;
    private javax.swing.JTextField jTextFieldTelefonoTrabajador;
    private javax.swing.JTextField jTextFieldUsuarioTrabajador;
    // End of variables declaration//GEN-END:variables

}
