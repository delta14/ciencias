/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.fciencias.data;

import java.io.Serializable;
import java.util.List;
import mx.unam.fciencias.model.dto.AlumnoDto;

/**
 *
 * @author guillermorojas
 */
public interface AlumnoDAOInterface<T> {
    
    public List<AlumnoDto> selectAll() ;
    public void create(T t);
     public void delete(Long t);
    
}
