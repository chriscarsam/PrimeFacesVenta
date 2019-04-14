package com.sambcode.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
 
    public Connection cn;
    
    public Connection getCn(){
        return cn;
    }
    
    public void setCn(Connection cn){
        this.cn = cn;
    }
    
    public void Conectar() throws Exception{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://172.17.0.2:3306/PrimeFacesVenta?user=root&password=mysql2016");             
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }
    
    public void Cerrar() throws Exception{
        try {
            if(cn != null){
                if(cn.isClosed() == false){
                    cn.close();
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}