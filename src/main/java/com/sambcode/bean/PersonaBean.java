package com.sambcode.bean;


import com.sambcode.dao.PersonaDAO;
import com.sambcode.model.Persona;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class PersonaBean {
    
    private Persona persona = new Persona();
    
    public Persona getPersona(){
        return persona;
    }
    
    public void setPersona (Persona persona){
        this.persona = persona;
    }
    
    public void registrar() throws Exception{
        PersonaDAO dao;
        
        try {
            dao = new PersonaDAO();
            dao.registrar(persona);
        } catch (Exception e) {
            throw e;
        }
    }
}
