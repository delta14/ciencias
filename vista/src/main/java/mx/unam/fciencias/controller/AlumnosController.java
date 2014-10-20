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
import mx.unam.fciencias.model.dto.AlumnoDto;
import mx.unam.fciencias.model.dto.CarreraDto;
import mx.unam.fciencias.model.dto.MateriaDto;
import mx.unam.fciencias.service.AlumnoService;
import org.primefaces.model.DualListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


/**
 *
 * @author guillermorojas
 */
//@Controller("alumnosController")
//@Scope("session")
@ManagedBean(name="alumnosController")
@SessionScoped
public class AlumnosController {
    
    //@Autowired
    private AlumnoService alumnoService=new AlumnoService();
    
    private AlumnoDto alumno;
      
    private List<AlumnoDto> alumnos;
    
    private List<CarreraDto> carreras;
    
    private List<MateriaDto> materias;
    
    private AlumnoDto alumnoSeleccionado;
    
   private DualListModel<MateriaDto> pickListMaterias;
    
    @PostConstruct
    public void init(){
        alumno=new AlumnoDto();
        alumno.setMaterias(new ArrayList<MateriaDto>());
        alumnos=new ArrayList<AlumnoDto>();
        alumnos.addAll(alumnoService.selectAllAlumnos());
        
        carreras=alumnoService.selectAllCarreras();
        materias=alumnoService.selectAllMaterias();
        
        pickListMaterias = new DualListModel<MateriaDto>(materias, alumno.getMaterias());
        
    }
    
    public void guardaAlumno(){
        if(alumnos.contains(alumno) ){
           FacesContext fc=FacesContext.getCurrentInstance();
            fc.addMessage("validacion", 
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error","Alumno repetido"));
        }else{
            alumno.setMaterias(pickListMaterias.getTarget());
            alumnoService.guardaAlumno(alumno);
        }
       init();
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
       init();
    }

    public AlumnoDto getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoDto alumno) {
        this.alumno = alumno;
    }

    public List<AlumnoDto> getAlumnos() {
        return alumnos;
    }

   

    public AlumnoDto getAlumnoSeleccionado() {
        return alumnoSeleccionado;
    }

    public void setAlumnoSeleccionado(AlumnoDto alumnoSeleccionado) {
        this.alumnoSeleccionado = alumnoSeleccionado;
    }

    public List<CarreraDto> getCarreras() {
        return carreras;
    }

    public Collection<MateriaDto> getMaterias() {
        return materias;
    }

 

    public void setAlumnos(List<AlumnoDto> alumnos) {
        this.alumnos = alumnos;
    }

  

    public void setCarreras(List<CarreraDto> carreras) {
        this.carreras = carreras;
    }

 

    public void setMaterias(List<MateriaDto> materias) {
        this.materias = materias;
    }

    public DualListModel<MateriaDto> getPickListMaterias() {
        return pickListMaterias;
    }

    public void setPickListMaterias(DualListModel<MateriaDto> pickListMaterias) {
        this.pickListMaterias = pickListMaterias;
    }

  

      
}
