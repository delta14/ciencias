/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.unam.fciencias.controller;

import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mx.unam.fciencias.model.dto.AlumnoDto;


/**
 *
 * @author guillermorojas
 */
@ManagedBean
@SessionScoped
public class AlumnosController {
    
    private AlumnoDto alumno;
    
    private Collection<AlumnoDto> alumnos;
    
    @PostConstruct
    public void init(){
        alumno=new AlumnoDto();
        alumnos=new ArrayList<AlumnoDto>();
    }
    
    public void guardaAlumno(){
        if(alumnos.contains(alumno)){
        
        }else{
            alumnos.add(alumno);
            alumno=new AlumnoDto();
        }
    }
    
    public void borraAlumno(AlumnoDto almn){
        if(alumnos.contains(almn)){
            alumnos.remove(almn);
        }
        else{
            FacesContext fc=FacesContext.getCurrentInstance();
            fc.addMessage("validacion", 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Alumno repetido"));
            
       }
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
    
    
    
    
}
