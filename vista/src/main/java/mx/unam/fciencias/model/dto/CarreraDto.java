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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author guillermorojas
 */
@Entity
@Table(name = "carrera")
@XmlRootElement
@NamedQueries(
        {
        @NamedQuery(name=CarreraDto.SELECT_ALL,query="SELECT c FROM CarreraDto c")
        }
)
public class CarreraDto implements Serializable{
    
    public static final String SELECT_ALL="select all carreras";
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    
     @NotNull
    private Long clave;
     
     @NotNull
    private String nombre;
    
      @NotNull
    private String plan;
   
    @JoinColumn(name = "ID_CARRERA", referencedColumnName = "ID")
    @OneToMany(targetEntity = AlumnoDto.class,fetch = FetchType.LAZY,cascade = CascadeType.MERGE,mappedBy = "carrera")
    private List<AlumnoDto> alumnos;

    public CarreraDto() {
    }
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClave() {
        return clave;
    }

    public void setClave(Long clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }

    public List<AlumnoDto> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<AlumnoDto> alumnos) {
        this.alumnos = alumnos;
    }

    
    
    
    @Override
    public boolean equals(Object object){
        if( object==null || !(object instanceof CarreraDto) ){
            return false;
        }
        
        
        CarreraDto carrera=(CarreraDto)object;
         if ((this.id == null && carrera.id != null) || (this.id != null && !this.id.equals(carrera.id))) {
            return false;
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

    
}
