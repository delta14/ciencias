/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.fciencias.dao;

import java.util.List;
import mx.unam.fciencias.model.dto.AlumnoDto;
import mx.unam.fciencias.model.dto.UsuarioDto;
import org.springframework.stereotype.Repository;

/**
 *
 * @author guillermorojas
 */
@Repository("usuarioDAO")
public class UsuarioDAO extends AbstractDAO<UsuarioDto> {

    public UsuarioDAO() {
        super(UsuarioDto.class);
    }
    
  
    public List<UsuarioDto> selectAll(){
        return em.createNamedQuery(UsuarioDto.SELECT_ALL).getResultList();
    }
    
    /*se da por hecho que la base de datos solo regresa un elemento*/
    public UsuarioDto selectFirtsByUserName(String username){
        List<UsuarioDto> usuarios= em.createNamedQuery(UsuarioDto.FIND_BY_USUSERNAME).setParameter(1, username).getResultList();
        if(usuarios.size()==0){
            return null;
        }
        else {
            return usuarios.get(0);
        }
    }
 
}
