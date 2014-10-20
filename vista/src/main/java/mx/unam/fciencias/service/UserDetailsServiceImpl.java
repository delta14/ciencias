/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.fciencias.service;

/**
 *
 * @author guillermorojas
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import mx.unam.fciencias.dao.UsuarioDAO;
import mx.unam.fciencias.model.dto.UsuarioDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService,Serializable {


  //  @Autowired
    private UsuarioDAO usuarioDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        UsuarioDto user;
        List<GrantedAuthority> autoridades = new ArrayList<GrantedAuthority>();

        user = usuarioDAO.selectFirtsByUserName(username);
        if (user != null) {
            autoridades.add(new GrantedAuthorityImpl( user.getRol().getNombreRol() ) );
            
            User springUser=new User(user.getUsername(),user.getPassword(),autoridades);
            return springUser;
        } else {
            throw new UsernameNotFoundException("User " + username + " no se encontro");
        }
    }
}
