/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.sql.*;
public class Dbconfig {
    
    //conexion con php myadmin
    private String driver="com.mysql.jdbc.Driver";
    private String connectString="jdbc:mysql://127.0.0.1/Testing_bd";
    private String user="root";
    private String password="";
    public Connection con;
        
    public Dbconfig(){
        con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(connectString, user , password);
        }catch ( Exception e ){
            System.out.println("error: no se pudo conectar a la base de datos: "+e.getMessage());
        }
        if(con!=null)
        {
            System.out.println("Conexión establecida");
        }
    }
    //check_connection
    
    public static void main(String[]args) throws SQLException{
        Statement stm;
        Dbconfig db = new Dbconfig();
        stm = db.con.createStatement();
        ResultSet query = stm.executeQuery("Select * from usuarios");
        System.out.println("test de conexión "+query);
        
    }
    
    
}