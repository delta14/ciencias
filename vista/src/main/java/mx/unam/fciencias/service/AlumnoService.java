/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.fciencias.service;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import mx.unam.fciencias.dao.AlumnoDAO;
import mx.unam.fciencias.dao.CarreraDAO;
import mx.unam.fciencias.dao.MateriaDAO;
import mx.unam.fciencias.model.dto.AlumnoDto;
import mx.unam.fciencias.model.dto.CarreraDto;
import mx.unam.fciencias.model.dto.MateriaDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author guillermorojas
 */
//@Service("alumnoService")
public class AlumnoService implements Serializable{
    
   //@Autowired 
   private  AlumnoDAO alumnoDAO=new AlumnoDAO();
   
   //@Autowired 
   private  CarreraDAO carreraDAO=new CarreraDAO();
   
   //@Autowired 
   private  MateriaDAO materiaDAO=new MateriaDAO();
  
   public  AlumnoService(){
   }
   
   public List<MateriaDto> selectAllMaterias(){
       return materiaDAO.selectAll();
   }
   
   public List<AlumnoDto> selectAllAlumnos(){
       return alumnoDAO.selectAll();
   }
   
   public List<CarreraDto> selectAllCarreras(){
       return carreraDAO.selectAll();
   }
   
   public void eliminaAlumno(AlumnoDto alumno){
       alumnoDAO.delete(alumno.getId());
   
   }
   
   public void guardaAlumno(AlumnoDto alumno){
       alumnoDAO.create(alumno);
   
   }
    
}
