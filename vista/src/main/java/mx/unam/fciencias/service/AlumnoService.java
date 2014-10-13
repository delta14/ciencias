/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.fciencias.service;

import java.io.Serializable;
import java.util.List;
import mx.unam.fciencias.dao.AlumnoDAO;
import mx.unam.fciencias.dao.jdbc.JdbcAlumnoDAO;
import mx.unam.fciencias.data.AlumnoDAOInterface;
import mx.unam.fciencias.model.dto.AlumnoDto;

/**
 *
 * @author guillermorojas
 */
public class AlumnoService implements Serializable{
    
   private  AlumnoDAOInterface alumnoDAO;
   
   public  AlumnoService(){
        alumnoDAO=new JdbcAlumnoDAO();
   }
   
   public List<AlumnoDto> selectAllAlumnos(){
       return alumnoDAO.selectAll();
   
   }
   
   public void eliminaAlumno(AlumnoDto alumno){
       alumnoDAO.delete(alumno.getId());
   
   }
   
   public void guardaAlumno(AlumnoDto alumno){
       alumnoDAO.create(alumno);
   
   }
    
}
