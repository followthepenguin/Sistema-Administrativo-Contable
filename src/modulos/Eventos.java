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
public class Eventos 
{
    private Integer idEvento;
    private String nombreEvento;
    private String fechaEvento;
    private String descripcionEvento;
    private String trabajadorEvento;
    private Integer idTrabajadorEvento;
    
    public Eventos()
    {
    
    }
    
    public Eventos(Integer idEvento,String nombreEvento,String fechaEvento,String descripcionEvento,Integer idTrabajadorEvento)
    {
        this.idEvento=idEvento;
        this.nombreEvento=nombreEvento;
        this.fechaEvento=fechaEvento;
        this.descripcionEvento=descripcionEvento;
        this.idTrabajadorEvento=idTrabajadorEvento;
    }
    
    public void guardar(Connection conexion, ArrayList<Object> datos)
    {
        try
        {
            setNombreEvento((String)datos.get(0));
            setFechaEvento((String)datos.get(1));
            setDescripcionEvento((String)datos.get(2));
            setTrabajadorEvento((String)datos.get(3));
            
            PreparedStatement consulta;
            
            consulta = conexion.prepareStatement("select id_trabajador from Trabajadores where nombre_trabajador='"+getTrabajadorEvento()+"';");
            ResultSet resultado = consulta.executeQuery();
            if(resultado.next())
                setIdTrabajadorEvento((Integer) resultado.getInt("id_trabajador"));
                
            consulta = conexion.prepareStatement("INSERT INTO Eventos(nombre_evento,fecha_evento,descripcion_evento,id_trabajador_evento)VALUES('"+getNombreEvento()+"','"+getFechaEvento()+"','"+getDescripcionEvento()+"',"+getIdTrabajadorEvento()+");");
            consulta.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Evento registrado");
            
            }catch(SQLException e)
                {
                    JOptionPane.showMessageDialog(null, "No se pudo registrar el evento");
                };
    }
    
    public ArrayList consultarNombre(Connection conexion) {
        ArrayList datos = new ArrayList();
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("select * from Eventos");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                datos.add(resultado.getString("nombre_evento"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No existen datos");
        }
        return datos;
    }
    
    
    public ArrayList consultarTodo(Connection conexion) {
        ArrayList<Eventos> datos = new ArrayList();
        try {
            PreparedStatement consulta;
            consulta = conexion.prepareStatement("select * from Eventos");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) 
            {
                datos.add(new Eventos(resultado.getInt("id_evento"),resultado.getString("nombre_evento"),resultado.getDate("fecha_evento").toString(),resultado.getString("descripcion_evento"),resultado.getInt("id_trabajador_evento")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No existen datos");
            System.out.print(ex);
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
                consulta = conexion.prepareStatement("DELETE FROM Eventos WHERE nombre_evento = '"+s+"'");
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
            PreparedStatement consulta = conexion.prepareStatement("UPDATE Eventos SET " + valor + " WHERE id_evento= " + id);
            consulta.execute();
            ok=true;
         }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al modificar");
        }
        return ok;
    }
    
    


    public Integer getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(Integer idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getFechaEvento() {
        return fechaEvento;
    }

    public void setFechaEvento(String fechaEvento) {
        this.fechaEvento = fechaEvento;
    }

    public String getDescripcionEvento() {
        return descripcionEvento;
    }

    public void setDescripcionEvento(String descripcionEvento) {
        this.descripcionEvento = descripcionEvento;
    }

    public String getTrabajadorEvento() {
        return trabajadorEvento;
    }

    public void setTrabajadorEvento(String trabajadorEvento) {
        this.trabajadorEvento = trabajadorEvento;
    }

    public Integer getIdTrabajadorEvento() {
        return idTrabajadorEvento;
    }

    public void setIdTrabajadorEvento(Integer idTrabajadorEvento) {
        this.idTrabajadorEvento = idTrabajadorEvento;
    }
    
}
