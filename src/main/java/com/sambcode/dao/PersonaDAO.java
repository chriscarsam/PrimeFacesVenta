package com.sambcode.dao;


import com.sambcode.model.Persona;
import java.sql.PreparedStatement;

public class PersonaDAO extends DAO{
    
    public void registrar(Persona per) throws Exception{
        try {
            this.Conectar();
            PreparedStatement st = this.getCn().prepareStatement("INSERT INTO persona (nombre, sexo) VALUES(?,?)");
            st.setString(1, per.getNombre());
            st.setString(2, per.getSexo());
            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        }finally{
            this.Cerrar();
        }
    }
}
