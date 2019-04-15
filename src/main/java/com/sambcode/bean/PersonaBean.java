package com.sambcode.bean;


import com.sambcode.dao.PersonaDAO;
import com.sambcode.model.Persona;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class PersonaBean {
    
    private Persona persona = new Persona();
    private List<Persona> lstPersonas;

    public List<Persona> getLstPersonas() {
        return lstPersonas;
    }

    public void setLstPersonas(List<Persona> lstPersonas) {
        this.lstPersonas = lstPersonas;
    }  
        
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
    
    public void listar() throws Exception{
        PersonaDAO dao;
        
        try {
            dao = new PersonaDAO();
            lstPersonas = dao.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void leerID(Persona per) throws Exception{
        PersonaDAO dao;
        Persona temp;
        
        try {
            dao = new PersonaDAO();
            temp = dao.leerID(per);
            
            if(temp != null){
                this.persona = temp;
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void modificar() throws Exception{
        PersonaDAO dao;
        
        try {
            dao = new PersonaDAO();
            dao.modificar(persona);
            this.listar();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminar(Persona per) throws Exception{
        PersonaDAO dao;
        
        try {
            dao = new PersonaDAO();
            dao.eliminar(per);
        } catch (Exception e) {
            throw e;
        }
    }
}
