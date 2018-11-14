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
public class Ventas 
{
    private Integer idVenta;
    private String nombreTrabajadorVenta;
    private String nombreClienteVenta;    
    private Double totalVenta;
    private String fechaVenta;
    private String descripcionVenta;
    private ArrayList<String> productosVenta;
    private ArrayList<Integer> cantidadProductosVenta;
    
    private Integer idTrabajadorVenta;
    private Integer idClienteVenta;
    private Integer idDetalleVenta;
    private Integer idProductoVenta;
    
    private PreparedStatement consulta;
    private ResultSet resultado;
    
    
    public Ventas()
    {
        
    }
    
    public Ventas(Integer idVenta,Integer idTrabajadorVenta,Integer idClienteVenta,Double totalVenta,String fechaVenta,String descripcionVenta)
    {
        this.idVenta=idVenta;
        this.idTrabajadorVenta=idTrabajadorVenta;
        this.idClienteVenta=idClienteVenta;
        this.totalVenta=totalVenta;
        this.fechaVenta=fechaVenta;
        this.descripcionVenta=descripcionVenta;
    }
    
    
    public void guardar(Connection conexion, ArrayList<Object> datos)
    {
        int contadorCantidadProductoVenta=0;
        try{
            setNombreTrabajadorVenta((String)datos.get(0));
            setNombreClienteVenta((String)datos.get(1));
            setDescripcionVenta((String)datos.get(2));
            setTotalVenta((Double)datos.get(3));
            setProductosVenta((ArrayList<String>)datos.get(4));
            setCantidadProductosVenta((ArrayList<Integer>)datos.get(5));
            
            setConsulta(conexion.prepareStatement("select id_trabajador from Trabajadores where nombre_trabajador='" + getNombreTrabajadorVenta() + "';"));
            setResultado(getConsulta().executeQuery());
            if(getResultado().next())
                setIdTrabajadorVenta((Integer) getResultado().getInt("id_trabajador"));
            
            setConsulta(conexion.prepareStatement("select id_cliente from Clientes where nombre_cliente='" + getNombreClienteVenta() + "';"));
            setResultado(getConsulta().executeQuery());
            if(getResultado().next())
                setIdClienteVenta((Integer) getResultado().getInt("id_cliente"));
                
            setConsulta(conexion.prepareStatement("INSERT INTO Ventas(id_trabajador_venta,id_cliente_venta,total_venta,fecha_venta,descripcion_venta)VALUES(" + getIdTrabajadorVenta() + "," + getIdClienteVenta() + "," + getTotalVenta() + ",now(),'" + getDescripcionVenta() + "');"));
            getConsulta().executeUpdate();
            
            setConsulta(conexion.prepareStatement("select id_venta from Ventas order by id_venta desc;"));
            setResultado(getConsulta().executeQuery());
            if(getResultado().next())
                setIdDetalleVenta((Integer) getResultado().getInt("id_venta"));
            
            for(String s:getProductosVenta())
            {
                setConsulta(conexion.prepareStatement("select id_producto from Productos where nombre_producto='"+s+"';"));
                setResultado(getConsulta().executeQuery());
                if(getResultado().next())
                    setIdProductoVenta((Integer) getResultado().getInt("id_producto"));
                
                setConsulta(conexion.prepareStatement("INSERT INTO DetallesVenta(id_detalle_venta,id_producto_venta,cantidad_producto_venta)VALUES(" + getIdDetalleVenta() + "," + getIdProductoVenta() + "," + getCantidadProductosVenta().get(contadorCantidadProductoVenta) + ");"));
                getConsulta().executeUpdate();
                contadorCantidadProductoVenta++;
            }
            
            JOptionPane.showMessageDialog(null, "Venta registrada");
            
            }catch(SQLException e)
                {
                    JOptionPane.showMessageDialog(null, "No se pudo registrar la venta");
                };
    }
    
    public ArrayList consultarId(Connection conexion)
    {
        ArrayList datos=new ArrayList();
        try
        {
            setConsulta(conexion.prepareStatement("select * from Ventas"));
            setResultado(getConsulta().executeQuery());
            while(getResultado().next())
                datos.add(getResultado().getString("id_venta"));
      }catch(SQLException ex){
         JOptionPane.showMessageDialog(null, "No existen datos");
      }
        return datos;
    }
    
    
    public boolean checarStock(Connection conexion,String nombreProductoVenta,Integer cantidadProductoVenta)
    {
        Integer stockProducto=0;
        try
        {
            setConsulta(conexion.prepareStatement("select stock_producto from Productos where nombre_producto='"+nombreProductoVenta+"'"));
            setResultado(getConsulta().executeQuery());
            while(getResultado().next())
                stockProducto=getResultado().getInt("stock_producto");
      }catch(SQLException ex){
         JOptionPane.showMessageDialog(null, "No existen datos del producto");
      }
        if(cantidadProductoVenta>stockProducto)
            return false;
        else
            return true;
    }
    
    public Double agregarProducto(Connection conexion,String nombreProductoVenta,Integer cantidadProductoVenta)
    {
        Double totalVentaProducto=0.0;
        try
        {
            setConsulta(conexion.prepareStatement("select precio_producto from Productos where nombre_producto='"+nombreProductoVenta+"'"));
            setResultado(getConsulta().executeQuery());
            while(getResultado().next())
                totalVentaProducto=getResultado().getDouble("precio_producto");
      }catch(SQLException ex){
         JOptionPane.showMessageDialog(null, "No existen datos del producto");
      }
        return totalVentaProducto*cantidadProductoVenta;
    }
    
    public ArrayList consultarTodo(Connection conexion) {
        ArrayList<Ventas> datos = new ArrayList();
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("select * from Ventas");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) 
            {
                datos.add(new Ventas(resultado.getInt("id_venta"),resultado.getInt("id_trabajador_venta"),resultado.getInt("id_cliente_venta"),resultado.getDouble("total_venta"),resultado.getDate("fecha_venta").toString(),resultado.getString("descripcion_venta")));
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
                consulta = conexion.prepareStatement("DELETE FROM Ventas WHERE id_venta = '"+s+"'");
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
            PreparedStatement consulta = conexion.prepareStatement("UPDATE Ventas SET " + valor + " WHERE id_venta= " + id);
            consulta.execute();
            ok=true;
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al modificar");
        }
        return ok;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public String getNombreTrabajadorVenta() {
        return nombreTrabajadorVenta;
    }

    public void setNombreTrabajadorVenta(String nombreTrabajadorVenta) {
        this.nombreTrabajadorVenta = nombreTrabajadorVenta;
    }

    public String getNombreClienteVenta() {
        return nombreClienteVenta;
    }

    public void setNombreClienteVenta(String nombreClienteVenta) {
        this.nombreClienteVenta = nombreClienteVenta;
    }

    public String getDescripcionVenta() {
        return descripcionVenta;
    }

    public void setDescripcionVenta(String descripcionVenta) {
        this.descripcionVenta = descripcionVenta;
    }

    public Double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public ArrayList<String> getProductosVenta() {
        return productosVenta;
    }

    public void setProductosVenta(ArrayList<String> productosVenta) {
        this.productosVenta = productosVenta;
    }

    public ArrayList<Integer> getCantidadProductosVenta() {
        return cantidadProductosVenta;
    }

    public void setCantidadProductosVenta(ArrayList<Integer> cantidadProductosVenta) {
        this.cantidadProductosVenta = cantidadProductosVenta;
    }

    public Integer getIdTrabajadorVenta() {
        return idTrabajadorVenta;
    }

    public void setIdTrabajadorVenta(Integer idTrabajadorVenta) {
        this.idTrabajadorVenta = idTrabajadorVenta;
    }

    public Integer getIdClienteVenta() {
        return idClienteVenta;
    }

    public void setIdClienteVenta(Integer idClienteVenta) {
        this.idClienteVenta = idClienteVenta;
    }

    public Integer getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(Integer idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public Integer getIdProductoVenta() {
        return idProductoVenta;
    }

    public void setIdProductoVenta(Integer idProductoVenta) {
        this.idProductoVenta = idProductoVenta;
    }

    public PreparedStatement getConsulta() {
        return consulta;
    }

    public void setConsulta(PreparedStatement consulta) {
        this.consulta = consulta;
    }

    public ResultSet getResultado() {
        return resultado;
    }

    public void setResultado(ResultSet resultado) {
        this.resultado = resultado;
    }

    public String getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(String fechaVenta) {
        this.fechaVenta = fechaVenta;
    }
}
