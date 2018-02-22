/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Jesus
 */
public class operaciones {  

    private Statement stmt;

    public Statement getStmt() {
        return stmt;
    }

    public void setStmt(Statement stmt) {
        this.stmt = stmt;
    }
       
    public operaciones() throws SQLException{
    }
    
    public ResultSet ConsultaBase(String consulta) {
        ResultSet resultado=null;
        try {
            
            Dbconfig conexion=new Dbconfig();
            stmt = conexion.con.createStatement();
            resultado=stmt.executeQuery(consulta);
            conexion.con.close(); 
            return resultado;
        } catch (SQLException ex) {
            Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
           return resultado;
    }
    
    
        public boolean InsercionBase(String consulta) {
            boolean respuesta=true;
        try {
            
            Dbconfig conexion=new Dbconfig();
            stmt = conexion.con.createStatement();
            respuesta=stmt.execute(consulta);
            conexion.con.close();
            return respuesta;
        } catch (SQLException ex) {
            Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }
        
         public boolean ActualizacionBase(String consulta) {
            boolean respuesta=true;
        try {
            
            Dbconfig conexion=new Dbconfig();
            stmt = conexion.con.createStatement();
            respuesta=stmt.execute(consulta);
            conexion.con.close();
            return respuesta;
        } catch (SQLException ex) {
            Logger.getLogger(operaciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;          
        
    }
}
