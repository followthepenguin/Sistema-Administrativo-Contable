package paneles;
import frames.JFramePrincipal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modulos.Categorias;
import servicios.Conexion;
import servicios.EditorTablaCategorias;
/**
 *
 * @author t0ken
 */
public class JPanelCategorias extends javax.swing.JPanel 
{
    private static final String TITULO_PANEL="Categorías";
    private static final String TITULO_BOTON_SALIR="Salir";
    private static final String TITULO_NOMBRE_CATEGORIA="Nombre de la categoría *";
    private static final String TITULO_SALARIO_CATEGORIA="Salario de la categoría *";
    private static final String TITULO_DESCRIPCION_CATEGORIA="Descripción de la categoría *";
    private static final String TITULO_BOTON_AGREGAR_CATEGORIA="Agregar categoría";
    private static final String TITULO_BOTON_ELIMINAR_CATEGORIA="Borrar categoría";
    
    private String nombreCategoria;
    private Double salarioCategoria;
    private String descripcionCategoria;
    private Categorias categorias=new Categorias();
    private DefaultTableModel modeloTabla=new DefaultTableModel();
    
    public JPanelCategorias() 
    {
        initComponents();
        cargarTabla();
    }
        
    private void cargarTabla()
    {
        ArrayList <Categorias> datos= categorias.consultarTodo(Conexion.getConexion());
        String[] columnas={"ID CATEGORIA","NOMBRE","SALARIO","DESCRIPCIÓN"};
        modeloTabla.setColumnIdentifiers(columnas);
        Object[] fila = new Object[modeloTabla.getColumnCount()];
        
        for (int i = jTableCategorias.getRowCount() -1; i >= 0; i--)
        {
            modeloTabla.removeRow(i);
        }
        
        for(int i=0;i<datos.size();i++)
        {
            fila[0]=datos.get(i).getIdCategoria();
            fila[1]=datos.get(i).getNombreCategoria();
            fila[2]=datos.get(i).getSalarioCategoria();
            fila[3]=datos.get(i).getDescripcionCategoria();
            
            modeloTabla.addRow(fila);
        }
        
        jTableCategorias.setModel(modeloTabla);
        
        jTableCategorias.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableCategorias.getColumnModel().getColumn(0).setMinWidth(0);
        jTableCategorias.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jTableCategorias.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        jTableCategorias.getColumnModel().getColumn( 1 ).setCellEditor(new EditorTablaCategorias(categorias,"nombre_categoria"));
        jTableCategorias.getColumnModel().getColumn( 2 ).setCellEditor(new EditorTablaCategorias(categorias,"salario_categoria"));
        jTableCategorias.getColumnModel().getColumn( 3 ).setCellEditor(new EditorTablaCategorias(categorias,"descripcion_categoria"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jButtonSalir = new javax.swing.JButton();
        jLabelNombreCategoria = new javax.swing.JLabel();
        jLabelSalarioCategoria = new javax.swing.JLabel();
        jLabelDescripcionCategoria = new javax.swing.JLabel();
        jTextFieldNombreCategoria = new javax.swing.JTextField();
        jFormattedTextFieldSalarioCategoria = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescripcionCategoria = new javax.swing.JTextArea();
        jButtonAgregarCategoria = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableCategorias = new javax.swing.JTable();
        jButtonEliminarCategoria = new javax.swing.JButton();
        jButtonLogo = new javax.swing.JButton();

        jLabelTitulo.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabelTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Categorias.png"))); // NOI18N
        jLabelTitulo.setText(TITULO_PANEL);

        jButtonSalir.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/SalirPanel.png"))); // NOI18N
        jButtonSalir.setText(TITULO_BOTON_SALIR);
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jLabelNombreCategoria.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelNombreCategoria.setText(TITULO_NOMBRE_CATEGORIA);

        jLabelSalarioCategoria.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelSalarioCategoria.setText(TITULO_SALARIO_CATEGORIA);

        jLabelDescripcionCategoria.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelDescripcionCategoria.setText(TITULO_DESCRIPCION_CATEGORIA);

        jTextFieldNombreCategoria.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N

        jFormattedTextFieldSalarioCategoria.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextFieldSalarioCategoria.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N

        jTextAreaDescripcionCategoria.setColumns(20);
        jTextAreaDescripcionCategoria.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jTextAreaDescripcionCategoria.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDescripcionCategoria);

        jButtonAgregarCategoria.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jButtonAgregarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AgregarCategoria.png"))); // NOI18N
        jButtonAgregarCategoria.setText(TITULO_BOTON_AGREGAR_CATEGORIA);
        jButtonAgregarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarCategoriaActionPerformed(evt);
            }
        });

        jTableCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableCategorias);

        jButtonEliminarCategoria.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jButtonEliminarCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eliminar.png"))); // NOI18N
        jButtonEliminarCategoria.setText(TITULO_BOTON_ELIMINAR_CATEGORIA);
        jButtonEliminarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarCategoriaActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonSalir)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelNombreCategoria)
                                    .addComponent(jLabelSalarioCategoria)
                                    .addComponent(jLabelDescripcionCategoria))
                                .addGap(90, 90, 90)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextFieldNombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jFormattedTextFieldSalarioCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabelTitulo)
                            .addComponent(jButtonAgregarCategoria, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLogo))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonEliminarCategoria)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 138, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonLogo)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jTextFieldNombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFormattedTextFieldSalarioCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelSalarioCategoria)))
                            .addComponent(jLabelNombreCategoria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDescripcionCategoria))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAgregarCategoria)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEliminarCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jButtonSalir)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarCategoriaActionPerformed
        // TODO add your handling code here:
        
        ArrayList<Object> datos=new ArrayList();
        
        if(jTextFieldNombreCategoria.getText().equals("") || jFormattedTextFieldSalarioCategoria.getText().equals("") || jTextAreaDescripcionCategoria.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Complete los campos");
        }
        else
        {
            try
            {
                this.nombreCategoria=jTextFieldNombreCategoria.getText();
                this.salarioCategoria=Double.valueOf(jFormattedTextFieldSalarioCategoria.getText());
                this.descripcionCategoria=jTextAreaDescripcionCategoria.getText();
                
                datos.add(this.nombreCategoria);
                datos.add(this.salarioCategoria);
                datos.add(this.descripcionCategoria);
                
                categorias.guardar(Conexion.getConexion(),datos);
                
                jTextFieldNombreCategoria.setText("");
                jFormattedTextFieldSalarioCategoria.setText("");
                jTextAreaDescripcionCategoria.setText("");
                
                this.categorias=new Categorias();
                cargarTabla();
            }catch(NumberFormatException e)
            {
                JOptionPane.showMessageDialog(null, "Algunos campos sólo aceptan números");
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Compruebe que los datos son correctos");
            }
        }
    }//GEN-LAST:event_jButtonAgregarCategoriaActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        JFramePrincipal.mostrarMenu(JFramePrincipal.getNombreCategoriaTrabajador());
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonEliminarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarCategoriaActionPerformed
        // TODO add your handling code here:
        ArrayList<Object> registros=new ArrayList();
        int[] indicesRegistros=jTableCategorias.getSelectedRows();
        
        for(int i:indicesRegistros)
        {
            if(!(i==0 || i==1))
                registros.add(jTableCategorias.getValueAt(i, 1));
        }
        
        if(registros.isEmpty())
            JOptionPane.showMessageDialog(null, "Ningún registro seleccionado");
        else
        {
            if(categorias.borrar(Conexion.getConexion(),registros))
                JOptionPane.showMessageDialog(null, "Categoría borrada");
        }
        cargarTabla();
    }//GEN-LAST:event_jButtonEliminarCategoriaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarCategoria;
    private javax.swing.JButton jButtonEliminarCategoria;
    private javax.swing.JButton jButtonLogo;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JFormattedTextField jFormattedTextFieldSalarioCategoria;
    private javax.swing.JLabel jLabelDescripcionCategoria;
    private javax.swing.JLabel jLabelNombreCategoria;
    private javax.swing.JLabel jLabelSalarioCategoria;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableCategorias;
    private javax.swing.JTextArea jTextAreaDescripcionCategoria;
    private javax.swing.JTextField jTextFieldNombreCategoria;
    // End of variables declaration//GEN-END:variables

}
