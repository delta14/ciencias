/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.unam.fciencias.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mx.unam.fciencias.dao.AlumnoDAO;
import mx.unam.fciencias.dao.jdbc.JdbcAlumnoDAO;
import mx.unam.fciencias.data.AlumnoDAOInterface;
import mx.unam.fciencias.model.dto.AlumnoDto;
import mx.unam.fciencias.model.dto.CarreraDto;
import mx.unam.fciencias.service.AlumnoService;


/**
 *
 * @author guillermorojas
 */
@ManagedBean
@SessionScoped
public class AlumnosController {
    
    private AlumnoDto alumno;
      
    private Collection<AlumnoDto> alumnos;
    
    private AlumnoDto alumnoSeleccionado;
    
    private AlumnoService alumnoService;
    
    @PostConstruct
    public void init(){
        alumnoService=new AlumnoService();  
        alumno=new AlumnoDto();        
        alumnos=new ArrayList<AlumnoDto>();
        alumnos.addAll(alumnoService.selectAllAlumnos());
    }
    
    public void guardaAlumno(){
        if(alumnos.contains(alumno) ){
           FacesContext fc=FacesContext.getCurrentInstance();
            fc.addMessage("validacion", 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Alumno repetido"));
        }else{
    
          alumnoService.guardaAlumno(alumno);
           
            
            alumno=new AlumnoDto();
        }
        alumnos=new ArrayList<AlumnoDto>();
        alumnos.addAll(alumnoService.selectAllAlumnos());
    }
    
    public void borraAlumno(AlumnoDto almn){
        if(alumnos.contains(almn)){    
            alumnoService.eliminaAlumno(almn);
        }
        else{
             FacesContext fc=FacesContext.getCurrentInstance();
            fc.addMessage("validacion", 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Error en la operacion"));
   
       }
        alumnos=new ArrayList<AlumnoDto>();
        alumnos.addAll(alumnoService.selectAllAlumnos());
    }

    public AlumnoDto getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoDto alumno) {
        this.alumno = alumno;
    }

    public Collection<AlumnoDto> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Collection<AlumnoDto> alumnos) {
        this.alumnos = alumnos;
    }

    public AlumnoDto getAlumnoSeleccionado() {
        return alumnoSeleccionado;
    }

    public void setAlumnoSeleccionado(AlumnoDto alumnoSeleccionado) {
        this.alumnoSeleccionado = alumnoSeleccionado;
    }



      
}
