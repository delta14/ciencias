/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.unam.fciencias.model.dto;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author guillermorojas
 */
@Entity
@Table(name = "alumno")
@NamedQueries(
        {
        @NamedQuery(name=AlumnoDto.SELECT_ALL,query="SELECT a FROM AlumnoDto a")
        }
)
public class AlumnoDto implements Serializable{
    public static final String SELECT_ALL="select all";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 
    
    @NotNull
    @Size(min = 2,max = 50)
    private String nombre;
    
    @NotNull
    @Size(min = 2,max = 50)
    private String apellidoPaterno;
    
    @NotNull
    @Size(min = 2,max = 50)
    private String apellidoMaterno;
    
    @NotNull
    @Size(max = 9)
    private String numeroCuenta;
    
    private Carrera carrera;
    
    private Collection<Profesor> profesores ;

    public AlumnoDto() {
    }

    public AlumnoDto(String nombre, String apellidoPaterno, String apellidoMaterno, String numeroCuenta) {
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.numeroCuenta = numeroCuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    
    
    @Override
    public boolean equals(Object object){
        if(!(object instanceof AlumnoDto) && object!=null){
            return false;
        }
        AlumnoDto alumno=(AlumnoDto)object;
        if(alumno.getNumeroCuenta()!=null && alumno.getNumeroCuenta().equals(this.numeroCuenta) ){
            return true;
        }
        else{
            return false;
        }
    
    
    }    

    private static class Profesor {

        public Profesor() {
        }
    }

    private static class Carrera {

        public Carrera() {
        }
    }
}
