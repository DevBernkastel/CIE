package software;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class Conexion 
{
    
    Connection con = null;
    Statement st = null;
    
    public Conexion() throws ClassNotFoundException
    {
        try
        {
            String database="student.mdb";//Here database exists in the current directory  
            String url="jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)}; DBQ=" + database + ";DriverID=22;READONLY=true";
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver"); 
            con = DriverManager.getConnection(url);
            st = (Statement) con.createStatement();
        } catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Conexión erronea " + e);
        }
    }
    
    public Connection getConnection()
    {
        return con;
    }
    
    public void Desconexion()
    {
        try
        {
            con.close();
            System.exit(0);
        } catch(SQLException ex)
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
