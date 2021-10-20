
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Danny
 */
public class conexion {
    static String bd = "alanlegacy";
    static String login ="root";
    static String password = "";
    static String url = "jdbc:mysql//localhost:3306/alanlegacy";
    
    Connection conn = null;
    
    public conexion() throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn= DriverManager.getConnection(url, login, password);
            if(conn!=null){
                System.out.println("CONEXIÓN");
            }}
        catch(SQLException ex){
            System.out.println(ex);
        }
    }
    
    public Connection getConnection(){
        return conn;
    }
    
    public void desconectar(){
        conn=null;
    }
}
