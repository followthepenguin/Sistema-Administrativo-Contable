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
public class Productos 
{
    private Integer idProducto;
    private String nombreProducto;
    private Double precioProducto;
    private Integer stockProducto;
    private String descripcionProducto;
    
    public Productos()
    {
        
    }
    
    public Productos(Integer idProducto,String nombreProducto,Double precioProducto,Integer stockProducto,String descripcionProducto)
    {
        this.idProducto=idProducto;
        this.nombreProducto=nombreProducto;
        this.precioProducto=precioProducto;
        this.stockProducto=stockProducto;
        this.descripcionProducto=descripcionProducto;
    }
    
    public void guardar(Connection conexion, ArrayList datos)
    {
        try{
            setNombreProducto((String)datos.get(0));
            setPrecioProducto((Double)datos.get(1));
            setStockProducto((Integer)datos.get(2));
            setDescripcionProducto((String)datos.get(3));
            
            PreparedStatement consulta;
                
            consulta = conexion.prepareStatement("INSERT INTO Productos(nombre_producto,precio_producto,stock_producto,descripcion_producto)VALUES('"+getNombreProducto()+"',"+getPrecioProducto()+","+getStockProducto()+",'"+getDescripcionProducto()+"');");
            consulta.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Producto registrado");
            
            }catch(SQLException e)
                {
                    JOptionPane.showMessageDialog(null, "No se pudo registrar el producto");
                };
    }
    
    public ArrayList consultarNombre(Connection conexion)
    {
        ArrayList datos=new ArrayList();
        try
        {
            PreparedStatement consulta;
            consulta=conexion.prepareStatement("select * from Productos");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next())
                datos.add(resultado.getString("nombre_producto"));
      }catch(SQLException ex){
         JOptionPane.showMessageDialog(null, "No existen datos");
      }
        return datos;
    }
    
    public ArrayList consultarTodo(Connection conexion) {
        ArrayList<Productos> datos = new ArrayList();
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("select * from Productos");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                datos.add(new Productos(resultado.getInt("id_producto"),resultado.getString("nombre_producto"),resultado.getDouble("precio_producto"),resultado.getInt("stock_producto"),resultado.getString("descripcion_producto")));
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
                
                consulta = conexion.prepareStatement("DELETE FROM Productos WHERE nombre_producto = '"+s+"'");
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
            PreparedStatement consulta = conexion.prepareStatement("UPDATE Productos SET " + valor + " WHERE id_producto= " + id);
            consulta.execute();
            ok=true;
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al modificar");
        }
        return ok;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public Double getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Integer getStockProducto() {
        return stockProducto;
    }

    public void setStockProducto(Integer stockProducto) {
        this.stockProducto = stockProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }
}
