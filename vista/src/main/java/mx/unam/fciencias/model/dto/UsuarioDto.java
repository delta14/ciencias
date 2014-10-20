/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.fciencias.model.dto;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author guillermorojas
 */
@Entity
@Table(name = "usuario")
@NamedQueries(
        {
        @NamedQuery(name=UsuarioDto.SELECT_ALL,query="SELECT u FROM UsuarioDto u"),
        @NamedQuery(name=UsuarioDto.FIND_BY_USUSERNAME,query="SELECT u FROM UsuarioDto u WHERE u.username=?1")
        }
)
public class UsuarioDto implements Serializable{
    
    public static final String SELECT_ALL="Select All Usuario";
    
    public static final String FIND_BY_USUSERNAME="Select By username";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    
    @NotNull
    private String username;
    
    @NotNull
    private String password;
    
   @OneToOne(cascade = CascadeType.MERGE)
   private RolDto rol;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RolDto getRol() {
        return rol;
    }

    public void setRol(RolDto rol) {
        this.rol = rol;
    }
   
   
   
    
}
