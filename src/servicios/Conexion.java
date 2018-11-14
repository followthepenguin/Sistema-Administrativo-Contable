package servicios;
import java.sql.*;
/**
 *
 * @author t0ken
 */
public class Conexion 
{
   private static Connection conexion = null;
   public static Connection conectar(String usuario,String contrasena) throws SQLException, ClassNotFoundException 
   {
      if (conexion == null) {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/SistemaDeAdministracionContable", usuario, contrasena);
         } catch (SQLException ex) {
            throw new SQLException(ex);
         } catch (ClassNotFoundException ex) {
            throw new ClassCastException(ex.getMessage());
         }
      }
      return conexion;
   }
   
   public static Connection getConexion()
   {
       return conexion;
   }
   public static void cerrar() throws SQLException {
      if (conexion != null) {
         conexion.close();
      }
   }
}