package modulos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Conexion {
    String url = "db.db";
    Connection con;
    
    public Connection conectar() throws ClassNotFoundException{
        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:" + url);
            
        } catch (SQLException ex) {
            System.out.println("error " + ex);
        }
        return con;
    }
    
    public void cerrarConexion(){
        try {
           con.close();
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName());
        }
    }
    
}
