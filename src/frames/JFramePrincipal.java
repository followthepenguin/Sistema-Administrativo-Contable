package frames;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import modulos.Categorias;
import modulos.Login;
import modulos.Trabajadores;
import paneles.*;
import servicios.Conexion;

/**
 *
 * @author t0ken
 */
public class JFramePrincipal extends javax.swing.JFrame 
{

    private static final String TITULO_JFRAME="Sistema de Administración Contable";
    private static final String TITULO_CATEGORIAS="Categorías";
    private static final String TITULO_TRABAJADORES="Trabajadores";
    private static final String TITULO_CLIENTES="Clientes";
    private static final String TITULO_PRODUCTOS="Productos";
    private static final String TITULO_VENTAS="Ventas";
    private static final String TITULO_EVENTOS="Eventos";
    private static final String TITULO_SALIR="Salir";
    
    private Trabajadores trabajadores=new Trabajadores();
    private Categorias categorias=new Categorias();
    
    private static String nombreCategoriaTrabajador;
    
    private static JPanel jPanelActivo;
    
    public JFramePrincipal() {
        initComponents();
        setLayout(new FlowLayout(FlowLayout.CENTER));
        ocultarMenu();
        validarMenu(Login.getUsuario());
    }
    
    @Override
    public Image getIconImage() {
        Image imagen = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("imagenes/IconoJframeMasPequeno.png"));


        return imagen;
    }
    
    private void mostrarPanel(JPanel jPanel)
    {
        try
        {
            this.remove(jPanelActivo);
        }catch(Exception e){}

        jPanelActivo = jPanel;
        this.add(jPanelActivo);
        jPanelActivo.setSize(this.getSize());
        this.pack();
    }
    
    private void ocultarMenu()
    {
        jButtonCategorias.setVisible(false);
        jButtonTrabajadores.setVisible(false);
        jButtonClientes.setVisible(false);
        jButtonProductos.setVisible(false);
        jButtonVentas.setVisible(false);
        jButtonEventos.setVisible(false);
        jButtonSalir.setVisible(false);
        jButtonLogo.setVisible(false);
    }
    
    public static void mostrarMenu(String categoria)
    {
        jButtonClientes.setVisible(true);
        jButtonProductos.setVisible(true);
        jButtonVentas.setVisible(true);
        jButtonSalir.setVisible(true);
        jButtonLogo.setVisible(true);
        if(categoria.equals("Gerente"))
        {
            jButtonCategorias.setVisible(true);
            jButtonTrabajadores.setVisible(true);
            jButtonEventos.setVisible(true);
        }
        else if(categoria.equals("Supervisor"))
        {
            jButtonEventos.setVisible(true);
        }
    }
    
    private void validarMenu(String usuario)
    {
        try
        {
            ArrayList<Trabajadores> alTrabajadores=trabajadores.consultarPorUsuario(Conexion.getConexion(),usuario);
            Integer idCategoriaTrabajador=alTrabajadores.get(0).getIdCategoriaTrabajador();
            ArrayList<Categorias> alCategorias=categorias.consultarPorId(Conexion.getConexion(),idCategoriaTrabajador);
            JFramePrincipal.nombreCategoriaTrabajador=alCategorias.get(0).getNombreCategoria();
            
            mostrarMenu(getNombreCategoriaTrabajador());
            
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "¡Usted no tiene ningún control, salga de aquí!");
        };
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonClientes = new javax.swing.JButton();
        jButtonTrabajadores = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jButtonCategorias = new javax.swing.JButton();
        jButtonEventos = new javax.swing.JButton();
        jButtonProductos = new javax.swing.JButton();
        jButtonVentas = new javax.swing.JButton();
        jButtonLogo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(TITULO_JFRAME);
        setAlwaysOnTop(true);
        setExtendedState(MAXIMIZED_BOTH);
        setResizable(false);

        jButtonClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Clientes.png"))); // NOI18N
        jButtonClientes.setText(TITULO_CLIENTES);
        jButtonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientesActionPerformed(evt);
            }
        });

        jButtonTrabajadores.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Trabajadores.png"))); // NOI18N
        jButtonTrabajadores.setText(TITULO_TRABAJADORES);
        jButtonTrabajadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTrabajadoresActionPerformed(evt);
            }
        });

        jButtonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Salir.png"))); // NOI18N
        jButtonSalir.setText(TITULO_SALIR);
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        jButtonCategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Categorias.png"))); // NOI18N
        jButtonCategorias.setText(TITULO_CATEGORIAS);
        jButtonCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCategoriasActionPerformed(evt);
            }
        });

        jButtonEventos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Eventos.png"))); // NOI18N
        jButtonEventos.setText(TITULO_EVENTOS);
        jButtonEventos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEventosActionPerformed(evt);
            }
        });

        jButtonProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Productos.png"))); // NOI18N
        jButtonProductos.setText(TITULO_PRODUCTOS);
        jButtonProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonProductosActionPerformed(evt);
            }
        });

        jButtonVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Ventas.png"))); // NOI18N
        jButtonVentas.setText(TITULO_VENTAS);
        jButtonVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVentasActionPerformed(evt);
            }
        });

        jButtonLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LogoFramePrincipal.png"))); // NOI18N
        jButtonLogo.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 400, 320, 400, new java.awt.Color(254, 254, 254)));
        jButtonLogo.setFocusable(false);
        jButtonLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonTrabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonEventos, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(jButtonLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonTrabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEventos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(jButtonLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientesActionPerformed
        // TODO add your handling code here:
        ocultarMenu();
        mostrarPanel(new JPanelClientes());
    }//GEN-LAST:event_jButtonClientesActionPerformed

    private void jButtonTrabajadoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTrabajadoresActionPerformed
        // TODO add your handling code here:
        ocultarMenu();
        mostrarPanel(new JPanelTrabajadores());
    }//GEN-LAST:event_jButtonTrabajadoresActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCategoriasActionPerformed
        // TODO add your handling code here:
        ocultarMenu();
        mostrarPanel(new JPanelCategorias());
    }//GEN-LAST:event_jButtonCategoriasActionPerformed

    private void jButtonEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEventosActionPerformed
        // TODO add your handling code here:
        ocultarMenu();
        mostrarPanel(new JPanelEventos());
    }//GEN-LAST:event_jButtonEventosActionPerformed

    private void jButtonProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonProductosActionPerformed
        // TODO add your handling code here:
        ocultarMenu();
        mostrarPanel(new JPanelProductos());
    }//GEN-LAST:event_jButtonProductosActionPerformed

    private void jButtonVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVentasActionPerformed
        // TODO add your handling code here:
        ocultarMenu();
        mostrarPanel(new JPanelVentas());
    }//GEN-LAST:event_jButtonVentasActionPerformed

    private void jButtonLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonLogoActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton jButtonCategorias;
    public static javax.swing.JButton jButtonClientes;
    public static javax.swing.JButton jButtonEventos;
    public static javax.swing.JButton jButtonLogo;
    public static javax.swing.JButton jButtonProductos;
    public static javax.swing.JButton jButtonSalir;
    public static javax.swing.JButton jButtonTrabajadores;
    public static javax.swing.JButton jButtonVentas;
    // End of variables declaration//GEN-END:variables

    public static String getNombreCategoriaTrabajador() {
        return nombreCategoriaTrabajador;
    }
}
