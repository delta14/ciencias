/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.unam.fciencias.dao;

import java.util.List;
import mx.unam.fciencias.model.dto.AlumnoDto;
import org.springframework.stereotype.Repository;

/**
 *
 * @author guillermorojas
 */
@Repository("alumnoDAO")
public class AlumnoDAO extends AbstractDAO<AlumnoDto> {

    public AlumnoDAO() {
        super(AlumnoDto.class);
    }
    
  
    public List<AlumnoDto> selectAll(){
        return em.createNamedQuery(AlumnoDto.SELECT_ALL).getResultList();
    }
    
    public List<AlumnoDto> selectAll(String nombre){
        return em.createNamedQuery(AlumnoDto.SELECT_WHERE_NOMBRE).setParameter(1, nombre).getResultList();
    }

  
    
}
