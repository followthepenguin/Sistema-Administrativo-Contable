package modulos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author t0ken
 */
public class Clientes 
{
    private Integer idCliente;
    private String nombreCliente;
    private String apellidoPaternoCliente;
    private String apellidoMaternoCliente;
    private String direccionCliente;
    private String telefonoCliente;
    private String emailCliente;
    
    public Clientes()
    {
        
    }
    
    public Clientes(Integer idCliente,String nombreCliente,String apellidoPaternoCliente,String apellidoMaternoCliente,String direccionCliente,String telefonoCliente,String emailCliente)
    {
        this.idCliente=idCliente;
        this.nombreCliente=nombreCliente;
        this.apellidoPaternoCliente=apellidoPaternoCliente;
        this.apellidoMaternoCliente=apellidoMaternoCliente;
        this.direccionCliente=direccionCliente;
        this.telefonoCliente=telefonoCliente;
        this.emailCliente=emailCliente;
    }
    
    public void guardar(Connection conexion, ArrayList<Object> datos)
    {
        try{
            setNombreCliente((String)datos.get(0));
            setApellidoPaternoCliente((String)datos.get(1));
            setApellidoMaternoCliente((String)datos.get(2));
            setDireccionCliente((String)datos.get(3));
            setTelefonoCliente((String)datos.get(4));
            setEmailCliente((String)datos.get(5));
            
            PreparedStatement consulta;
                
            consulta = conexion.prepareStatement("INSERT INTO Clientes(nombre_cliente,a_paterno_cliente,a_materno_cliente,direccion_cliente,telefono_cliente,email_cliente)VALUES('"+getNombreCliente()+"','"+getApellidoPaternoCliente()+"','"+getApellidoMaternoCliente()+"','"+getDireccionCliente()+"','"+getTelefonoCliente()+"','"+getEmailCliente()+"');");
            consulta.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente registrado");
            
            }catch(SQLException e)
                {JOptionPane.showMessageDialog(null, "No se pudo registrar el cliente");
                //e.printStackTrace();
                };
    }
    
    public ArrayList consultarNombre(Connection conexion)
    {
        ArrayList datos=new ArrayList();
        try
        {
            PreparedStatement consulta;
            consulta=conexion.prepareStatement("select * from Clientes");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next())
                datos.add(resultado.getString("nombre_cliente"));
      }catch(SQLException ex){
         JOptionPane.showMessageDialog(null, "No existen datos");
      }
        return datos;
    }
    
    public ArrayList consultarNombrePorId(Connection conexion,Integer id)
    {
        ArrayList datos=new ArrayList();
        try
        {
            PreparedStatement consulta;
            consulta=conexion.prepareStatement("select * from Clientes where id_cliente="+id);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next())
                datos.add(resultado.getString("nombre_cliente"));
      }catch(SQLException ex){
         JOptionPane.showMessageDialog(null, "No existen datos");
      }
        return datos;
    }
    
    public ArrayList consultarTodo(Connection conexion) {
        ArrayList<Clientes> datos = new ArrayList();
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("select * from Clientes");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                datos.add(new Clientes(resultado.getInt("id_cliente"),resultado.getString("nombre_cliente"),resultado.getString("a_paterno_cliente"),resultado.getString("a_materno_cliente"),resultado.getString("direccion_cliente"),resultado.getString("telefono_cliente"),resultado.getString("email_cliente")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No existen datos");
        }
        return datos;
    }
    
    public Boolean borrar(Connection conexion,ArrayList<Object> registros)
    {
        Boolean ok=false;
        ArrayList<String> nombresRegistros=new ArrayList();
        try
        {
            for(Object o:registros)
                nombresRegistros.add(o.toString());
            
            PreparedStatement consulta;
            for(String s:nombresRegistros)
            {   
                consulta = conexion.prepareStatement("DELETE FROM Clientes WHERE nombre_cliente = '"+s+"'");
                consulta.executeUpdate();
            }
            ok=true;
        }catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Error al eliminar");
        }
         return ok;   
    }
    
    public Boolean modificar(Connection conexion, String valor, String id)
    {
        Boolean ok = false;
        try {
            PreparedStatement consulta = conexion.prepareStatement("UPDATE Clientes SET " + valor + " WHERE id_cliente= " + id);
            consulta.execute();
            ok=true;
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al modificar");
        }
        return ok;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getApellidoPaternoCliente() {
        return apellidoPaternoCliente;
    }

    public void setApellidoPaternoCliente(String apellidoPaternoCliente) {
        this.apellidoPaternoCliente = apellidoPaternoCliente;
    }

    public String getApellidoMaternoCliente() {
        return apellidoMaternoCliente;
    }

    public void setApellidoMaternoCliente(String apellidoMaternoCliente) {
        this.apellidoMaternoCliente = apellidoMaternoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }
}
