/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.fciencias.dao;

import java.util.List;
import mx.unam.fciencias.model.dto.AlumnoDto;
import mx.unam.fciencias.model.dto.CarreraDto;
import org.springframework.stereotype.Repository;

/**
 *
 * @author guillermorojas
 */
//@Repository("carreraDAO")
public class CarreraDAO extends AbstractDAO<CarreraDto> {

    public CarreraDAO() {
        super(CarreraDto.class);
    }
    
    public List<CarreraDto> selectAll(){
        return em.createNamedQuery(CarreraDto.SELECT_ALL).getResultList();
    }

    
}