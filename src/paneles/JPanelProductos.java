package paneles;
import frames.JFramePrincipal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modulos.Productos;
import servicios.Conexion;
import servicios.EditorTablaProductos;
/**
 *
 * @author t0ken
 */
public class JPanelProductos extends javax.swing.JPanel 
{
    private static final String TITULO_PANEL="Productos";
    private static final String TITULO_BOTON_SALIR="Salir";
    private static final String TITULO_NOMBRE_PRODUCTO="Nombre del producto *";
    private static final String TITULO_PRECIO_PRODUCTO="Precio del producto *";
    private static final String TITULO_STOCK_PRODUCTO="Stock del producto *";
    private static final String TITULO_DESCRIPCION_PRODUCTO="Descripción del producto *";
    
    private static final String TITULO_BOTON_AGREGAR_TRABAJADOR="Agregar producto";
    private static final String TITULO_BOTON_ELIMINAR_TRABAJADOR="Eliminar producto";
    
    private String nombreProducto;
    private Double precioProducto;
    private Integer stockProducto;
    private String descripcionProducto;
    Productos productos=new Productos();
    private DefaultTableModel modeloTabla=new DefaultTableModel();
    
    public JPanelProductos() 
    {
        initComponents();
        cargarTabla();
    }
    
    private void cargarTabla()
    {
        ArrayList <Productos> datos= productos.consultarTodo(Conexion.getConexion());
        String[] columnas={"ID PRODUCTO","NOMBRE","PRECIO","STOCK","DESCRIPCIÓN"};
        modeloTabla.setColumnIdentifiers(columnas);
        Object[] fila = new Object[modeloTabla.getColumnCount()];
        
        for (int i = jTableProductos.getRowCount() -1; i >= 0; i--)
        {
            modeloTabla.removeRow(i);
        }
        
        for(int i=0;i<datos.size();i++)
        {
            fila[0]=datos.get(i).getIdProducto();
            fila[1]=datos.get(i).getNombreProducto();
            fila[2]=datos.get(i).getPrecioProducto();
            fila[3]=datos.get(i).getStockProducto();
            fila[4]=datos.get(i).getDescripcionProducto();
            
            modeloTabla.addRow(fila);
        }
        
        jTableProductos.setModel(modeloTabla);
        
        jTableProductos.getColumnModel().getColumn(0).setMaxWidth(0);
        jTableProductos.getColumnModel().getColumn(0).setMinWidth(0);
        jTableProductos.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        jTableProductos.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        jTableProductos.getColumnModel().getColumn( 1 ).setCellEditor(new EditorTablaProductos(productos,"nombre_producto"));
        jTableProductos.getColumnModel().getColumn( 2 ).setCellEditor(new EditorTablaProductos(productos,"precio_producto"));
        jTableProductos.getColumnModel().getColumn( 3 ).setCellEditor(new EditorTablaProductos(productos,"stock_producto"));
        jTableProductos.getColumnModel().getColumn( 2 ).setCellEditor(new EditorTablaProductos(productos,"descripcion_producto"));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jLabelNombreProducto = new javax.swing.JLabel();
        jTextFieldNombreProducto = new javax.swing.JTextField();
        jLabelPrecioProducto = new javax.swing.JLabel();
        jFormattedTextFieldPrecioProducto = new javax.swing.JFormattedTextField();
        jLabelStockProducto = new javax.swing.JLabel();
        jFormattedTextFieldStockProducto = new javax.swing.JFormattedTextField();
        jLabelDescripcionProducto = new javax.swing.JLabel();
        jButtonAgregarProducto = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescripcionProducto = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProductos = new javax.swing.JTable();
        jButtonEliminarProducto = new javax.swing.JButton();
        jButtonLogo = new javax.swing.JButton();

        jLabelTitulo.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabelTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Productos.png"))); // NOI18N
        jLabelTitulo.setText(TITULO_PANEL);

        jLabelNombreProducto.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelNombreProducto.setText(TITULO_NOMBRE_PRODUCTO);

        jTextFieldNombreProducto.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N

        jLabelPrecioProducto.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelPrecioProducto.setText(TITULO_PRECIO_PRODUCTO
        );

        jFormattedTextFieldPrecioProducto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextFieldPrecioProducto.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N

        jLabelStockProducto.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelStockProducto.setText(TITULO_STOCK_PRODUCTO);

        jFormattedTextFieldStockProducto.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextFieldStockProducto.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N

        jLabelDescripcionProducto.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelDescripcionProducto.setText(TITULO_DESCRIPCION_PRODUCTO);

        jButtonAgregarProducto.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jButtonAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AgregarProducto.png"))); // NOI18N
        jButtonAgregarProducto.setText(TITULO_BOTON_AGREGAR_TRABAJADOR);
        jButtonAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarProductoActionPerformed(evt);
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

        jTextAreaDescripcionProducto.setColumns(20);
        jTextAreaDescripcionProducto.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jTextAreaDescripcionProducto.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDescripcionProducto);

        jTableProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableProductos);

        jButtonEliminarProducto.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jButtonEliminarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eliminar.png"))); // NOI18N
        jButtonEliminarProducto.setText(TITULO_BOTON_ELIMINAR_TRABAJADOR);
        jButtonEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarProductoActionPerformed(evt);
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
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTitulo)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelNombreProducto)
                                    .addComponent(jLabelPrecioProducto)
                                    .addComponent(jLabelStockProducto)
                                    .addComponent(jLabelDescripcionProducto))
                                .addGap(135, 135, 135)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jFormattedTextFieldPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jFormattedTextFieldStockProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButtonAgregarProducto, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLogo))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonEliminarProducto)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 200, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNombreProducto)
                            .addComponent(jTextFieldNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonLogo))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFormattedTextFieldPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelPrecioProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFormattedTextFieldStockProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelStockProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDescripcionProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAgregarProducto)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEliminarProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonSalir)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarProductoActionPerformed
        // TODO add your handling code here:
            
            ArrayList<Object> datos=new ArrayList();
         
            if(jTextFieldNombreProducto.getText().equals("") || jFormattedTextFieldPrecioProducto.getText().equals("") || jFormattedTextFieldStockProducto.getText().equals("") || jTextAreaDescripcionProducto.getText().equals(""))
            {    
                JOptionPane.showMessageDialog(null, "Complete los campos");
            }
            else
            {
                try
                {
                    this.nombreProducto=jTextFieldNombreProducto.getText();
                    this.precioProducto=Double.valueOf(jFormattedTextFieldPrecioProducto.getText());
                    this.stockProducto=Integer.valueOf(jFormattedTextFieldStockProducto.getText());
                    this.descripcionProducto=jTextAreaDescripcionProducto.getText();
                    
                    datos.add(this.nombreProducto);
                    datos.add(this.precioProducto);
                    datos.add(this.stockProducto);
                    datos.add(this.descripcionProducto);
            
                    productos.guardar(Conexion.getConexion(),datos);
                    
                    jTextFieldNombreProducto.setText("");
                    jFormattedTextFieldPrecioProducto.setText("");
                    jFormattedTextFieldStockProducto.setText("");
                    jTextAreaDescripcionProducto.setText("");
                    
                    productos=new Productos();
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
    }//GEN-LAST:event_jButtonAgregarProductoActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        JFramePrincipal.mostrarMenu(JFramePrincipal.getNombreCategoriaTrabajador());
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarProductoActionPerformed
        // TODO add your handling code here:
        ArrayList<Object> registros=new ArrayList();
        int[] indicesRegistros=jTableProductos.getSelectedRows();
        
        for(int i:indicesRegistros)
        {
            registros.add(jTableProductos.getValueAt(i, 1));
        }
        
        if(registros.isEmpty())
           JOptionPane.showMessageDialog(null, "Ningún registro seleccionado");
        else
        {
            if(productos.borrar(Conexion.getConexion(),registros))
                JOptionPane.showMessageDialog(null, "Producto borrado");
        }
        cargarTabla();
    }//GEN-LAST:event_jButtonEliminarProductoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarProducto;
    private javax.swing.JButton jButtonEliminarProducto;
    private javax.swing.JButton jButtonLogo;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JFormattedTextField jFormattedTextFieldPrecioProducto;
    private javax.swing.JFormattedTextField jFormattedTextFieldStockProducto;
    private javax.swing.JLabel jLabelDescripcionProducto;
    private javax.swing.JLabel jLabelNombreProducto;
    private javax.swing.JLabel jLabelPrecioProducto;
    private javax.swing.JLabel jLabelStockProducto;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableProductos;
    private javax.swing.JTextArea jTextAreaDescripcionProducto;
    private javax.swing.JTextField jTextFieldNombreProducto;
    // End of variables declaration//GEN-END:variables

}
