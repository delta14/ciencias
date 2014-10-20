/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.fciencias.dao;

import java.util.List;
import mx.unam.fciencias.model.dto.CarreraDto;
import mx.unam.fciencias.model.dto.MateriaDto;
import org.springframework.stereotype.Repository;

/**
 *
 * @author guillermorojas
 */
//@Repository("materiaDAO")
public class MateriaDAO extends AbstractDAO<MateriaDto> {

    public MateriaDAO() {
        super(MateriaDto.class);
    }
    
    public List<MateriaDto> selectAll(){
        return em.createNamedQuery(MateriaDto.SELECT_ALL).getResultList();
    }

    
}