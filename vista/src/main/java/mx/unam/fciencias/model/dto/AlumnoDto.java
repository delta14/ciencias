/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.unam.fciencias.model.dto;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
        @NamedQuery(name=AlumnoDto.SELECT_ALL,query="SELECT a FROM AlumnoDto a"),
        @NamedQuery(name=AlumnoDto.SELECT_WHERE_NOMBRE,query="SELECT a FROM AlumnoDto a WHERE a.nombre=?1")
        }
)
public class AlumnoDto implements Serializable{
    public static final String SELECT_ALL="select all alumnos";
    public static final String SELECT_WHERE_NOMBRE="select alumnos WHERE nombre";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    
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
    
    @ManyToOne(targetEntity = CarreraDto.class,cascade = CascadeType.MERGE)
    private CarreraDto carrera;
    
    @OneToOne(cascade = CascadeType.MERGE)
    private DatosPersonalesDto datos;
    
    
    @JoinTable(name = "alumno_materia",
            joinColumns = {@JoinColumn(name = "ID_ALUMNO")},
            inverseJoinColumns = {@JoinColumn(name = "ID_MATERIA")}
            )
    @ManyToMany
    private List<MateriaDto> materias;
    
    
     


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
       public CarreraDto getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraDto carrera) {
        this.carrera = carrera;
    }

    public DatosPersonalesDto getDatos() {
        return datos;
    }

    public void setDatos(DatosPersonalesDto datos) {
        this.datos = datos;
    }

    public List<MateriaDto> getMaterias() {
        return materias;
    }

    public void setMaterias(List<MateriaDto> materias) {
        this.materias = materias;
    }
    
    
    
    @Override
    public boolean equals(Object object){
        if( object==null || !(object instanceof AlumnoDto) ){
            return false;
        }
        
        
        AlumnoDto alumno=(AlumnoDto)object;
         if ((this.id == null && alumno.id != null) || (this.id != null && !this.id.equals(alumno.id))) {
            return false;
        }
        if(alumno.getNumeroCuenta()!=null && alumno.getNumeroCuenta().equals(this.numeroCuenta) ){
            return true;
        }
        else{
            return false;
        }
    
    
    }    

 
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    
    @Override
    public String toString() {
    return "Nombre:"+nombre+"\n"+
            "Ap:"+apellidoPaterno+"\n"+
            "Am:"+apellidoMaterno+"\n"+
            "No cuenta:"+numeroCuenta+"\n";
    
    }

 
}
