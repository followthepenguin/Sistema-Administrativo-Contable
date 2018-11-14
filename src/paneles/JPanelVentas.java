package paneles;
import frames.JFramePrincipal;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modulos.Clientes;
import servicios.Conexion;
import modulos.Productos;
import modulos.Trabajadores;
import modulos.Ventas;
import servicios.EditorTablaVentas;
/**
 *
 * @author t0ken
 */
public class JPanelVentas extends javax.swing.JPanel 
{
    private static final String TITULO_PANEL="Ventas";
    private static final String TITULO_BOTON_SALIR="Salir";
    private static final String TITULO_NOMBRE_TRABAJADOR_VENTA="Nombre del trabajador ";
    private static final String TITULO_NOMBRE_CLIENTE_VENTA="Nombre del cliente ";
    private static final String TITULO_TOTAL_VENTA="Total de la venta *";
    private static final String TITULO_DESCRIPCION_VENTA="Descripción de la venta ";
    
    private static final String TITULO_PRODUCTO_VENTA="Productos de la venta *";
    private static final String TITULO_CANTIDAD_PRODUCTO_VENTA="Cantidad de productos *";
    
    private static final String TITULO_BOTON_AGREGAR_PRODUCTO="Agregar producto";
    private static final String TITULO_BOTON_AGREGAR_VENTA="Agregar Venta";
    private static final String TITULO_BOTON_DETALLES_VENTA="Detalles";
    private static final String TITULO_BOTON_ELIMINAR_VENTA="Borrar Venta";
    
    private String nombreTrabajadorVenta;
    private String nombreClienteVenta;
    private Double totalVenta=0.0;
    private String descripcionVenta;
    
    private ArrayList<String> productosVenta=new ArrayList();
    private ArrayList<Integer> cantidadProductosVenta=new ArrayList();
    
    private Ventas ventas=new Ventas();
    private Trabajadores trabajadores=new Trabajadores();
    private Clientes clientes=new Clientes();
    private Productos productos=new Productos();
    
    private DefaultTableModel modeloTabla=new DefaultTableModel();
    
    public JPanelVentas() 
    {
        initComponents();
        
        jComboBoxTrabajadorVenta.removeAllItems();
        jComboBoxTrabajadorVenta.addItem("");
        for(Object o:trabajadores.consultarNombre(Conexion.getConexion()))
        {
            jComboBoxTrabajadorVenta.addItem(o.toString());
        }
        
        jComboBoxClienteVenta.removeAllItems();
        jComboBoxClienteVenta.addItem("");
        for(Object o:clientes.consultarNombre(Conexion.getConexion()))
        {
            jComboBoxClienteVenta.addItem(o.toString());
        }
        
        jComboBoxProductoVenta.removeAllItems();
        jComboBoxProductoVenta.addItem("");
        for(Object o:productos.consultarNombre(Conexion.getConexion()))
        {
            jComboBoxProductoVenta.addItem(o.toString());
        }
        jFormattedTextFieldTotalVenta.setEditable(false);
        jFormattedTextFieldTotalVenta.setText("0.0");
        jButtonAgregarVenta.setEnabled(false);
        
        cargarTabla();
    }
    
    private void cargarTabla()
    {
        ArrayList <Ventas> datos= ventas.consultarTodo(Conexion.getConexion());
        String[] columnas={"ID VENTA","TRABAJADOR","CLIENTE","TOTAL","FECHA","DESCRIPCIÓN"};
        modeloTabla.setColumnIdentifiers(columnas);
        Object[] fila = new Object[modeloTabla.getColumnCount()];
        
        for (int i = jTableVentas.getRowCount() -1; i >= 0; i--)
        {
            modeloTabla.removeRow(i);
        }
        
        for(int i=0;i<datos.size();i++)
        {
            fila[0]=datos.get(i).getIdVenta();
            fila[1]=trabajadores.consultarNombrePorId(Conexion.getConexion(),datos.get(i).getIdTrabajadorVenta());
            fila[2]=clientes.consultarNombrePorId(Conexion.getConexion(),datos.get(i).getIdClienteVenta());
            fila[3]=datos.get(i).getTotalVenta();
            fila[4]=datos.get(i).getFechaVenta();
            fila[5]=datos.get(i).getDescripcionVenta();
            
            modeloTabla.addRow(fila);
        }
        
        jTableVentas.setModel(modeloTabla);
        
        //jTableVentas.getColumnModel().getColumn(0).setMaxWidth(0);
        //jTableVentas.getColumnModel().getColumn(0).setMinWidth(0);
        //jTableVentas.getTableHeader().getColumnModel().getColumn(0).setMaxWidth(0);
        //jTableVentas.getTableHeader().getColumnModel().getColumn(0).setMinWidth(0);
        
        jTableVentas.getColumnModel().getColumn( 1 ).setCellEditor(new EditorTablaVentas(ventas,"id_trabajador_venta"));
        jTableVentas.getColumnModel().getColumn( 2 ).setCellEditor(new EditorTablaVentas(ventas,"id_cliente_venta"));
        jTableVentas.getColumnModel().getColumn( 3 ).setCellEditor(new EditorTablaVentas(ventas,"total_venta"));
        jTableVentas.getColumnModel().getColumn( 4 ).setCellEditor(new EditorTablaVentas(ventas,"fecha_venta"));
        jTableVentas.getColumnModel().getColumn( 5 ).setCellEditor(new EditorTablaVentas(ventas,"descripcion_venta"));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitulo = new javax.swing.JLabel();
        jLabelNombreTrabajadorVenta = new javax.swing.JLabel();
        jLabelNombreClienteVenta = new javax.swing.JLabel();
        jLabelDescripcionVenta = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescripcionVenta = new javax.swing.JTextArea();
        jLabelProductoVenta = new javax.swing.JLabel();
        jComboBoxTrabajadorVenta = new javax.swing.JComboBox<>();
        jButtonAgregarVenta = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jButtonAgregarProducto = new javax.swing.JButton();
        jLabelCantidadProductoVenta = new javax.swing.JLabel();
        jComboBoxClienteVenta = new javax.swing.JComboBox<>();
        jComboBoxProductoVenta = new javax.swing.JComboBox<>();
        jFormattedTextFieldCantidadProductoVenta = new javax.swing.JFormattedTextField();
        jLabelTotalVenta = new javax.swing.JLabel();
        jFormattedTextFieldTotalVenta = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableVentas = new javax.swing.JTable();
        jButtonEliminarVenta = new javax.swing.JButton();
        jButtonLogo = new javax.swing.JButton();

        jLabelTitulo.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabelTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Ventas.png"))); // NOI18N
        jLabelTitulo.setText(TITULO_PANEL);

        jLabelNombreTrabajadorVenta.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelNombreTrabajadorVenta.setText(TITULO_NOMBRE_TRABAJADOR_VENTA);

        jLabelNombreClienteVenta.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelNombreClienteVenta.setText(TITULO_NOMBRE_CLIENTE_VENTA
        );

        jLabelDescripcionVenta.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelDescripcionVenta.setText(TITULO_DESCRIPCION_VENTA);

        jTextAreaDescripcionVenta.setColumns(20);
        jTextAreaDescripcionVenta.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jTextAreaDescripcionVenta.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDescripcionVenta);

        jLabelProductoVenta.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelProductoVenta.setText(TITULO_PRODUCTO_VENTA);

        jComboBoxTrabajadorVenta.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jComboBoxTrabajadorVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButtonAgregarVenta.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jButtonAgregarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AgregarVenta.png"))); // NOI18N
        jButtonAgregarVenta.setText(TITULO_BOTON_AGREGAR_VENTA);
        jButtonAgregarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarVentaActionPerformed(evt);
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

        jButtonAgregarProducto.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jButtonAgregarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/AgregarProductoBolsa.png"))); // NOI18N
        jButtonAgregarProducto.setText(TITULO_BOTON_AGREGAR_PRODUCTO);
        jButtonAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarProductoActionPerformed(evt);
            }
        });

        jLabelCantidadProductoVenta.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelCantidadProductoVenta.setText(TITULO_CANTIDAD_PRODUCTO_VENTA);

        jComboBoxClienteVenta.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jComboBoxClienteVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxProductoVenta.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jComboBoxProductoVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jFormattedTextFieldCantidadProductoVenta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jFormattedTextFieldCantidadProductoVenta.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N

        jLabelTotalVenta.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jLabelTotalVenta.setText(TITULO_TOTAL_VENTA);

        jFormattedTextFieldTotalVenta.setEditable(false);
        jFormattedTextFieldTotalVenta.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));
        jFormattedTextFieldTotalVenta.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N

        jTableVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(jTableVentas);

        jButtonEliminarVenta.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        jButtonEliminarVenta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eliminar.png"))); // NOI18N
        jButtonEliminarVenta.setText(TITULO_BOTON_ELIMINAR_VENTA);
        jButtonEliminarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarVentaActionPerformed(evt);
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
                            .addComponent(jLabelTitulo)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelNombreClienteVenta)
                                    .addComponent(jLabelNombreTrabajadorVenta))
                                .addGap(148, 148, 148)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jComboBoxTrabajadorVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonLogo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSalir)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDescripcionVenta)
                            .addComponent(jLabelProductoVenta)
                            .addComponent(jLabelCantidadProductoVenta))
                        .addGap(136, 136, 136)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jFormattedTextFieldCantidadProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelTotalVenta)
                                    .addComponent(jButtonAgregarProducto))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jFormattedTextFieldTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonAgregarVenta))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(122, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(684, 684, 684)
                        .addComponent(jButtonEliminarVenta)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonLogo)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNombreTrabajadorVenta)
                            .addComponent(jComboBoxTrabajadorVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxClienteVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNombreClienteVenta))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDescripcionVenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBoxProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelProductoVenta))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jFormattedTextFieldCantidadProductoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCantidadProductoVenta)
                    .addComponent(jButtonAgregarProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTotalVenta)
                    .addComponent(jFormattedTextFieldTotalVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAgregarVenta))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonEliminarVenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jButtonSalir)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    
    private void jButtonAgregarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarVentaActionPerformed
        // TODO add your handling code here:
        
        ArrayList<Object> datos=new ArrayList();
            String nombreTrabajadorVenta="";
            String nombreClienteVenta="";
            String descripcionVenta="";
            Double totalVenta=0.0;
            
            if(this.totalVenta==0)
                JOptionPane.showMessageDialog(null, "No existe ningún producto seleccionado");
            else 
            {
                try 
                {
                    this.nombreTrabajadorVenta = jComboBoxTrabajadorVenta.getSelectedItem().toString();
                    this.nombreClienteVenta = jComboBoxClienteVenta.getSelectedItem().toString();
                    this.descripcionVenta = jTextAreaDescripcionVenta.getText();
                    this.totalVenta = Double.valueOf(jFormattedTextFieldTotalVenta.getText());

                    datos.add(this.nombreTrabajadorVenta);
                    datos.add(this.nombreClienteVenta);
                    datos.add(this.descripcionVenta);
                    datos.add(this.totalVenta);
                    datos.add(this.productosVenta);
                    datos.add(this.cantidadProductosVenta);

                    ventas.guardar(Conexion.getConexion(), datos);

                    jComboBoxTrabajadorVenta.setSelectedItem("");
                    jComboBoxClienteVenta.setSelectedItem("");
                    jTextAreaDescripcionVenta.setText("");
                    jComboBoxProductoVenta.setSelectedItem("");
                    jFormattedTextFieldCantidadProductoVenta.setText("");
                    jFormattedTextFieldTotalVenta.setText("0.0");

                    this.nombreTrabajadorVenta = "";
                    this.nombreClienteVenta = "";
                    this.totalVenta = 0.0;
                    this.descripcionVenta = "";
                    this.productosVenta.clear();
                    this.cantidadProductosVenta.clear();
                    jButtonAgregarVenta.setEnabled(false);
                    this.ventas = new Ventas();
                    cargarTabla();
                    
                } catch (NumberFormatException e) 
                {
                    JOptionPane.showMessageDialog(null, "Algunos campos sólo aceptan números");
                }
                catch(Exception e)
                {
                    JOptionPane.showMessageDialog(null, "Compruebe que los datos son correctos");
                };
        }
    }//GEN-LAST:event_jButtonAgregarVentaActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        JFramePrincipal.mostrarMenu(JFramePrincipal.getNombreCategoriaTrabajador());
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarProductoActionPerformed
        // TODO add your handling code here:
        
        String productoVenta="";
        Integer cantidadProductoVenta=0;
        Double totalVenta=0.0;
        boolean repetido=false;
        Integer cantidadProductoVentaPlus=0;
        
        if (jComboBoxProductoVenta.getSelectedItem().toString().equals("") || jFormattedTextFieldCantidadProductoVenta.getText().equals("")) 
        {
            JOptionPane.showMessageDialog(null, "Complete los campos");
        }
        else 
        {
            try 
            {
                productoVenta = jComboBoxProductoVenta.getSelectedItem().toString();
                cantidadProductoVenta = Integer.valueOf(jFormattedTextFieldCantidadProductoVenta.getText());
                totalVenta = Double.valueOf(jFormattedTextFieldTotalVenta.getText());
                
                for(String s:this.productosVenta)
                {
                    int i = 0;
                    if (s.equals(productoVenta)) 
                    {   
                        cantidadProductoVentaPlus += cantidadProductoVenta+this.cantidadProductosVenta.get(i);
                        repetido=true;
                    }
                    i++;
                }
                
                if (repetido)
                {
                    if(ventas.checarStock(Conexion.getConexion(), productoVenta, cantidadProductoVentaPlus))
                    {
                        totalVenta=ventas.agregarProducto(Conexion.getConexion(), productoVenta, cantidadProductoVenta);
                        this.productosVenta.add(productoVenta);
                        this.cantidadProductosVenta.add(cantidadProductoVenta);
                        this.totalVenta+=totalVenta;
                        System.out.println(productoVenta+" "+cantidadProductoVenta);
                        
                        jComboBoxProductoVenta.setSelectedItem("");
                        jFormattedTextFieldCantidadProductoVenta.setText("");
                        jFormattedTextFieldTotalVenta.setText(this.totalVenta.toString());
                        jButtonAgregarVenta.setEnabled(true);
                    }else
                    {
                        JOptionPane.showMessageDialog(null, "No hay stock del producto");
                    }
                }
                
                else
                {
                    if (ventas.checarStock(Conexion.getConexion(), productoVenta, cantidadProductoVenta)) 
                    {
                        totalVenta = ventas.agregarProducto(Conexion.getConexion(), productoVenta, cantidadProductoVenta);
                        this.productosVenta.add(productoVenta);
                        this.cantidadProductosVenta.add(cantidadProductoVenta);
                        this.totalVenta += totalVenta;
                        //System.out.println(productoVenta+" "+cantidadProductoVenta);
                    
                        jComboBoxProductoVenta.setSelectedItem("");
                        jFormattedTextFieldCantidadProductoVenta.setText("");
                        jFormattedTextFieldTotalVenta.setText(this.totalVenta.toString());
                        jButtonAgregarVenta.setEnabled(true);
                    } 
                    else 
                    {
                        JOptionPane.showMessageDialog(null, "No hay stock del producto");
                    }
                } 
            }
            catch (NumberFormatException e) 
            {
                JOptionPane.showMessageDialog(null, "Algunos campos sólo aceptan números");
                //e.printStackTrace();
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, "Compruebe que los datos son correctos");
                //e.printStackTrace();
            };
        }
    }//GEN-LAST:event_jButtonAgregarProductoActionPerformed

    private void jButtonEliminarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarVentaActionPerformed
        // TODO add your handling code here:
        ArrayList<Object> registros=new ArrayList();
        int[] indicesRegistros=jTableVentas.getSelectedRows();
        
        for(int i:indicesRegistros)
        {
            registros.add(jTableVentas.getValueAt(i, 0));
        }
        
        if(registros.isEmpty())
           JOptionPane.showMessageDialog(null, "Ningún registro seleccionado");
        else
        {
            if(ventas.borrar(Conexion.getConexion(),registros))
                JOptionPane.showMessageDialog(null, "Venta borrada");
        }
        cargarTabla();
    }//GEN-LAST:event_jButtonEliminarVentaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarProducto;
    private javax.swing.JButton jButtonAgregarVenta;
    private javax.swing.JButton jButtonEliminarVenta;
    private javax.swing.JButton jButtonLogo;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JComboBox<String> jComboBoxClienteVenta;
    private javax.swing.JComboBox<String> jComboBoxProductoVenta;
    private javax.swing.JComboBox<String> jComboBoxTrabajadorVenta;
    private javax.swing.JFormattedTextField jFormattedTextFieldCantidadProductoVenta;
    private javax.swing.JFormattedTextField jFormattedTextFieldTotalVenta;
    private javax.swing.JLabel jLabelCantidadProductoVenta;
    private javax.swing.JLabel jLabelDescripcionVenta;
    private javax.swing.JLabel jLabelNombreClienteVenta;
    private javax.swing.JLabel jLabelNombreTrabajadorVenta;
    private javax.swing.JLabel jLabelProductoVenta;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelTotalVenta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableVentas;
    private javax.swing.JTextArea jTextAreaDescripcionVenta;
    // End of variables declaration//GEN-END:variables

}
