package modulos;

import frames.JFramePrincipal;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import servicios.Conexion;

/**
 *
 * @author t0ken
 */
public class Login
{
    private static String usuario;
    private static String contrasena;
    
    
    public Login()
    {}
    
    private void iniciarFramePrincipal()
    {
                /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFramePrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFramePrincipal().setVisible(true);
            }
        });
    }
    
    private boolean limpiarTextoLogin(JTextField usr, JPasswordField con)
    {
        boolean work=false;
        String usuario=usr.getText().trim(),contrasena=con.getText().trim();
        if(!usuario.isEmpty() && !contrasena.isEmpty())
        {
            if(!(usuario.length()>25 && contrasena.length()>30))
            {
                Login.usuario=usuario;
                Login.contrasena=contrasena;
                work=true;
            }
        }
        else
            work=false;
        return work;
    }
    
    public void login(JTextField jTextFieldUsuario,JPasswordField jPasswordFieldContrasena,JFrame contexto)
    {
        try{
        if(limpiarTextoLogin(jTextFieldUsuario,jPasswordFieldContrasena))
        {   
            Conexion.conectar(getUsuario(), getContrasena());
            iniciarFramePrincipal();
            contexto.dispose();
        }
        else
            JOptionPane.showMessageDialog(null, "Complete los campos");
        }catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, "Usuario y/o Contrasena incorrecto");
            jPasswordFieldContrasena.setText("");
        }
    }

    public static String getUsuario() {
        return usuario;
    }

    public static String getContrasena() {
        return contrasena;
    }
}
