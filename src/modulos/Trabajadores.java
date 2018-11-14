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
public class Trabajadores 
{
    private Integer idTrabajador;
    private String nombreTrabajador;
    private String apellidoPaternoTrabajador;
    private String apellidoMaternoTrabajador;
    private String direccionTrabajador;
    private String telefonoTrabajador;
    private String emailTrabajador;
    private String usuarioTrabajador;
    private String contrasenaTrabajador;
    private String categoriaTrabajador;
    private Integer idCategoriaTrabajador;
    
    
    public Trabajadores()
    {
        
    }
    
    public Trabajadores(Integer idTrabajador,String nombreTrabajador,String apellidoPaternoTrabajador,String apellidoMaternoTrabajador,String direccionTrabajador,String telefonoTrabajador,String emailTrabajador,String usuarioTrabajador,String contrasenaTrabajador,Integer idCategoriaTrabajador)
    {
        this.idTrabajador=idTrabajador;
        this.nombreTrabajador=nombreTrabajador;
        this.apellidoPaternoTrabajador=apellidoPaternoTrabajador;
        this.apellidoMaternoTrabajador=apellidoMaternoTrabajador;
        this.direccionTrabajador=direccionTrabajador;
        this.telefonoTrabajador=telefonoTrabajador;
        this.emailTrabajador=emailTrabajador;
        this.usuarioTrabajador=usuarioTrabajador;
        this.contrasenaTrabajador=contrasenaTrabajador;
        this.idCategoriaTrabajador=idCategoriaTrabajador;
    }
    public void guardar(Connection conexion, ArrayList<Object> datos)
    {
        try{
            setNombreTrabajador((String)datos.get(0));
            setApellidoPaternoTrabajador((String)datos.get(1));
            setApellidoMaternoTrabajador((String)datos.get(2));
            setDireccionTrabajador((String)datos.get(3));
            setTelefonoTrabajador((String)datos.get(4));
            setEmailTrabajador((String)datos.get(5));
            setUsuarioTrabajador((String)datos.get(6));
            setContrasenaTrabajador((String)datos.get(7));
            setCategoriaTrabajador((String)datos.get(8));     
            
            PreparedStatement consulta;
            
            consulta = conexion.prepareStatement("select id_categoria from Categorias where nombre_categoria='"+getCategoriaTrabajador()+"';");
            ResultSet resultado = consulta.executeQuery();
            if(resultado.next())
                setIdCategoriaTrabajador((Integer) resultado.getInt(1));
            
            consulta = conexion.prepareStatement("CREATE USER '"+getUsuarioTrabajador()+"' IDENTIFIED BY '"+getContrasenaTrabajador()+"';");
            consulta.executeUpdate();
            
            switch (getCategoriaTrabajador()) {
                case "Gerente":
                    consulta = conexion.prepareStatement("GRANT select,insert,update,delete on Eventos TO '"+getUsuarioTrabajador()+"';");
                    consulta.executeUpdate();
                    consulta = conexion.prepareStatement("GRANT select,insert,update,delete on Ventas TO '"+getUsuarioTrabajador()+"';");
                    consulta.executeUpdate();
                    consulta = conexion.prepareStatement("GRANT select,insert,update,delete on DetallesVenta TO '"+getUsuarioTrabajador()+"';");
                    consulta.executeUpdate();
                    consulta = conexion.prepareStatement("GRANT select,insert,update,delete on Productos TO '"+getUsuarioTrabajador()+"';");
                    consulta.executeUpdate();
                    consulta = conexion.prepareStatement("GRANT select,insert,update,delete on Clientes TO '"+getUsuarioTrabajador()+"';");
                    consulta.executeUpdate();
                    consulta = conexion.prepareStatement("GRANT select,insert,update,delete on Categorias TO '"+getUsuarioTrabajador()+"';");
                    consulta.executeUpdate();
                    consulta = conexion.prepareStatement("GRANT select,insert,update,delete on Trabajadores TO '"+getUsuarioTrabajador()+"';");
                    consulta.executeUpdate();
                    break;
                case "Supervisor":
                    consulta = conexion.prepareStatement("GRANT select,insert,update,delete on Eventos TO '"+getUsuarioTrabajador()+"';");
                    consulta.executeUpdate();
                    consulta = conexion.prepareStatement("GRANT select,insert,update,delete on Ventas TO '"+getUsuarioTrabajador()+"';");
                    consulta.executeUpdate();
                    consulta = conexion.prepareStatement("GRANT select,insert,update,delete on DetallesVenta TO '"+getUsuarioTrabajador()+"';");
                    consulta.executeUpdate();
                    consulta = conexion.prepareStatement("GRANT select,insert,update,delete on Productos TO '"+getUsuarioTrabajador()+"';");
                    consulta.executeUpdate();
                    consulta = conexion.prepareStatement("GRANT select,insert,update,delete on Clientes TO '"+getUsuarioTrabajador()+"';");
                    consulta.executeUpdate();
                    consulta = conexion.prepareStatement("GRANT select on Categorias TO '"+getUsuarioTrabajador()+"';");
                    consulta.executeUpdate();
                    consulta = conexion.prepareStatement("GRANT select on Trabajadores TO '"+getUsuarioTrabajador()+"';");
                    consulta.executeUpdate();
                    break;
                default:
                    consulta = conexion.prepareStatement("GRANT select on Categorias TO '" + getUsuarioTrabajador() + "';");
                    consulta.executeUpdate();
                    consulta = conexion.prepareStatement("GRANT select on Trabajadores TO '" + getUsuarioTrabajador() + "';");
                    consulta.executeUpdate();
                    consulta = conexion.prepareStatement("GRANT select on Eventos TO '"+getUsuarioTrabajador()+"';");
                    consulta.executeUpdate();
                    consulta = conexion.prepareStatement("GRANT select,insert,update,delete on Ventas TO '"+getUsuarioTrabajador()+"';");
                    consulta.executeUpdate();
                    consulta = conexion.prepareStatement("GRANT select,insert,update,delete on DetallesVenta TO '"+getUsuarioTrabajador()+"';");
                    consulta.executeUpdate();
                    consulta = conexion.prepareStatement("GRANT select,insert,update,delete on Productos TO '"+getUsuarioTrabajador()+"';");
                    consulta.executeUpdate();
                    consulta = conexion.prepareStatement("GRANT select,insert,update,delete on Clientes TO '"+getUsuarioTrabajador()+"';");
                    consulta.executeUpdate();
                    break;
            }
                
            consulta = conexion.prepareStatement("INSERT INTO Trabajadores(nombre_trabajador,a_paterno_trabajador,a_materno_trabajador,direccion_trabajador,telefono_trabajador,email_trabajador,usuario_trabajador,contrasena_trabajador,id_categoria_trabajador)VALUES('"+getNombreTrabajador()+"','"+getApellidoPaternoTrabajador()+"','"+getApellidoMaternoTrabajador()+"','"+getDireccionTrabajador()+"','"+getTelefonoTrabajador()+"','"+getEmailTrabajador()+"','"+getUsuarioTrabajador()+"',MD5('"+getContrasenaTrabajador()+"'),"+getIdCategoriaTrabajador()+");");
            consulta.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Trabajador registrado");
            
            }catch(SQLException e)
                {JOptionPane.showMessageDialog(null, "No se pudo registrar el trabajador");
                };
    }
    
    public ArrayList consultarNombre(Connection conexion)
    {
        ArrayList datos=new ArrayList();
        try
        {
            PreparedStatement consulta;
            consulta=conexion.prepareStatement("select * from Trabajadores");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next())
                datos.add(resultado.getString("nombre_trabajador"));
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
            consulta=conexion.prepareStatement("select * from Trabajadores where id_trabajador="+id);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next())
                datos.add(resultado.getString("nombre_trabajador"));
      }catch(SQLException ex){
         JOptionPane.showMessageDialog(null, "No existen datos");
      }
        return datos;
    }
    
    public ArrayList consultarPorUsuario(Connection conexion,String usuario)
    {
        ArrayList datos=new ArrayList();
        try
        {
            PreparedStatement consulta;
            consulta=conexion.prepareStatement("select * from Trabajadores where usuario_trabajador='"+usuario+"'");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next())
                datos.add(new Trabajadores(resultado.getInt("id_trabajador"),resultado.getString("nombre_trabajador"),resultado.getString("a_paterno_trabajador"),resultado.getString("a_materno_trabajador"),resultado.getString("direccion_trabajador"),resultado.getString("telefono_trabajador"),resultado.getString("email_trabajador"),resultado.getString("usuario_trabajador"),resultado.getString("contrasena_trabajador"),resultado.getInt("id_categoria_trabajador")));
      }catch(SQLException ex){
         JOptionPane.showMessageDialog(null, "No existen datos");
      }
        return datos;
    }
    
    public ArrayList consultarTodo(Connection conexion) {
        ArrayList<Trabajadores> datos = new ArrayList();
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("select * from Trabajadores");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) 
            {
                datos.add(new Trabajadores(resultado.getInt("id_trabajador"),resultado.getString("nombre_trabajador"),resultado.getString("a_paterno_trabajador"),resultado.getString("a_materno_trabajador"),resultado.getString("direccion_trabajador"),resultado.getString("telefono_trabajador"),resultado.getString("email_trabajador"),resultado.getString("usuario_trabajador"),resultado.getString("contrasena_trabajador"),resultado.getInt("id_categoria_trabajador")));
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
                consulta = conexion.prepareStatement("DROP USER '"+s+"'");
                consulta.executeUpdate();
                
                consulta = conexion.prepareStatement("DELETE FROM Trabajadores WHERE usuario_trabajador = '"+s+"'");
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
            PreparedStatement consulta = conexion.prepareStatement("UPDATE Trabajadores SET " + valor + " WHERE id_trabajador= " + id);
            consulta.execute();
            ok=true;
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al modificar");
        }
        return ok;
    }

    public Integer getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(Integer idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    public void setNombreTrabajador(String nombreTrabajador) {
        this.nombreTrabajador = nombreTrabajador;
    }

    public String getApellidoPaternoTrabajador() {
        return apellidoPaternoTrabajador;
    }

    public void setApellidoPaternoTrabajador(String apellidoPaternoTrabajador) {
        this.apellidoPaternoTrabajador = apellidoPaternoTrabajador;
    }

    public String getApellidoMaternoTrabajador() {
        return apellidoMaternoTrabajador;
    }

    public void setApellidoMaternoTrabajador(String apellidoMaternoTrabajador) {
        this.apellidoMaternoTrabajador = apellidoMaternoTrabajador;
    }

    public String getDireccionTrabajador() {
        return direccionTrabajador;
    }

    public void setDireccionTrabajador(String direccionTrabajador) {
        this.direccionTrabajador = direccionTrabajador;
    }

    public String getTelefonoTrabajador() {
        return telefonoTrabajador;
    }

    public void setTelefonoTrabajador(String telefonoTrabajador) {
        this.telefonoTrabajador = telefonoTrabajador;
    }

    public String getEmailTrabajador() {
        return emailTrabajador;
    }

    public void setEmailTrabajador(String emailTrabajador) {
        this.emailTrabajador = emailTrabajador;
    }

    public String getUsuarioTrabajador() {
        return usuarioTrabajador;
    }

    public void setUsuarioTrabajador(String usuarioTrabajador) {
        this.usuarioTrabajador = usuarioTrabajador;
    }

    public String getContrasenaTrabajador() {
        return contrasenaTrabajador;
    }

    public void setContrasenaTrabajador(String contrasenaTrabajador) {
        this.contrasenaTrabajador = contrasenaTrabajador;
    }

    public String getCategoriaTrabajador() {
        return categoriaTrabajador;
    }

    public void setCategoriaTrabajador(String categoriaTrabajador) {
        this.categoriaTrabajador = categoriaTrabajador;
    }

    public Integer getIdCategoriaTrabajador() {
        return idCategoriaTrabajador;
    }

    public void setIdCategoriaTrabajador(Integer idCategoriaTrabajador) {
        this.idCategoriaTrabajador = idCategoriaTrabajador;
    }
}
