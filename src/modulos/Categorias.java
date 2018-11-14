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
public class Categorias {

    private Integer idCategoria;
    private String nombreCategoria;
    private Double salarioCategoria;
    private String descripcionCategoria;
    
    public Categorias()
    {
        
    }
    
    public Categorias(Integer idCategoria, String nombreCategoria,Double salarioCategoria,String descripcionCategoria)
    {
        this.idCategoria=idCategoria;
        this.nombreCategoria=nombreCategoria;
        this.salarioCategoria=salarioCategoria;
        this.descripcionCategoria=descripcionCategoria;
    }

    public void guardar(Connection conexion, ArrayList<Object> datos) {
        try {
            setNombreCategoria((String) datos.get(0));
            setSalarioCategoria((Double) datos.get(1));
            setDescripcionCategoria((String) datos.get(2));

            //Todas las categorias serán hijas de VENDEDOR.
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("CREATE ROLE '" + getNombreCategoria() + "';");
            consulta.executeUpdate();
            consulta = conexion.prepareStatement("GRANT select on Categorias TO '" + getNombreCategoria() + "';");
            consulta.executeUpdate();
            consulta = conexion.prepareStatement("GRANT select on Trabajadores TO '" + getNombreCategoria() + "';");
            consulta.executeUpdate();
            consulta = conexion.prepareStatement("GRANT select on Eventos TO '" + getNombreCategoria() + "';");
            consulta.executeUpdate();
            consulta = conexion.prepareStatement("GRANT select,insert,update,delete on Ventas TO '" + getNombreCategoria() + "';");
            consulta.executeUpdate();
            consulta = conexion.prepareStatement("GRANT select,insert,update,delete on DetallesVenta TO '" + getNombreCategoria() + "';");
            consulta.executeUpdate();
            consulta = conexion.prepareStatement("GRANT select,insert,update,delete on Productos TO '" + getNombreCategoria() + "';");
            consulta.executeUpdate();
            consulta = conexion.prepareStatement("GRANT select,insert,update,delete on Clientes TO '" + getNombreCategoria() + "';");
            consulta.executeUpdate();

            consulta = conexion.prepareStatement("INSERT INTO Categorias(nombre_categoria,salario_categoria,descripcion_categoria)VALUES('" + getNombreCategoria() + "'," + getSalarioCategoria() + ",'" + getDescripcionCategoria() + "');");
            consulta.executeUpdate();

            JOptionPane.showMessageDialog(null, "Categoría registrada");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo registrar la categoría");
        };

    }

    public ArrayList consultarNombre(Connection conexion) {
        ArrayList datos = new ArrayList();
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("select * from Categorias");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                datos.add(resultado.getString("nombre_categoria"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No existen datos");
        }
        return datos;
    }
    
    public ArrayList consultarNombrePorId(Connection conexion,Integer id) {
        ArrayList datos = new ArrayList();
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("select * from Categorias where id_categoria="+id);
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                datos.add(resultado.getString("nombre_categoria"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No existen datos");
        }
        return datos;
    }
    
    public ArrayList consultarPorId(Connection conexion,Integer id) {
        ArrayList datos=new ArrayList();
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("select * from Categorias where id_categoria="+id);
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                datos.add(new Categorias(resultado.getInt("id_categoria"),resultado.getString("nombre_categoria"),resultado.getDouble("salario_categoria"),resultado.getString("descripcion_categoria")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No existen datos");
        }
        return datos;
    }
    
    public ArrayList consultarTodo(Connection conexion) {
        ArrayList<Categorias> datos = new ArrayList();
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("select * from Categorias");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                datos.add(new Categorias(resultado.getInt("id_categoria"),resultado.getString("nombre_categoria"),resultado.getDouble("salario_categoria"),resultado.getString("descripcion_categoria")));
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
                consulta = conexion.prepareStatement("DROP ROLE '"+s+"'");
                consulta.executeUpdate();
                
                consulta = conexion.prepareStatement("DELETE FROM Categorias WHERE nombre_categoria = '"+s+"'");
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
            PreparedStatement consulta = conexion.prepareStatement("UPDATE Categorias SET " + valor + " WHERE id_categoria= " + id);
            consulta.execute();
            ok=true;
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al modificar");
        }
        return ok;
    }


    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public Double getSalarioCategoria() {
        return salarioCategoria;
    }

    public void setSalarioCategoria(Double salarioCategoria) {
        this.salarioCategoria = salarioCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
}
