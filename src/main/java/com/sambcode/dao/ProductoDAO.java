package com.sambcode.dao;


import com.sambcode.model.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO extends DAO{
    
    public void registrar(Producto pro) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO producto (nombre, precio) VALUES(?,?)");
            st.setString(1, pro.getNombre());
            st.setDouble(2, pro.getPrecio());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    
    public List<Producto> listar() throws Exception{
        List<Producto> lista;
        ResultSet rs;
        
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareCall("SELECT codigo, nombre, precio FROM producto");
            rs = st.executeQuery();
            lista = new ArrayList();
            while(rs.next()){
                Producto pro = new Producto();
                pro.setCodigo(rs.getInt("codigo"));
                pro.setNombre(rs.getString("nombre"));
                pro.setPrecio(rs.getDouble("precio"));
                
                lista.add(pro);
            }
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
        return lista;
    }
    
    public Producto leerID(Producto pro) throws Exception{
        Producto prod = null;
        ResultSet rs;
        
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("SELECT codigo, nombre, precio FROM producto WHERE codigo = ?");
            st.setInt(1, pro.getCodigo());
            rs = st.executeQuery();
            while(rs.next()){
                prod = new Producto();
                prod.setCodigo(rs.getInt("codigo"));
                prod.setNombre(rs.getString("nombre"));
                prod.setPrecio(rs.getDouble("precio"));
            }
        } catch (Exception e) {
            throw e;
        } finally{
            this.Cerrar();
        }
        return prod;
    }
    
    public void modificar(Producto pro) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("UPDATE producto SET nombre = ?, precio = ? WHERE codigo = ?");
            st.setString(1, pro.getNombre());
            st.setDouble(2, pro.getPrecio());
            st.setInt(3, pro.getCodigo());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
    
    public void eliminar(Producto pro) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("DELETE FROM producto WHERE codigo = ?");
            st.setInt(1, pro.getCodigo());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
}
