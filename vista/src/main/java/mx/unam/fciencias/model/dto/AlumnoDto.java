/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mx.unam.fciencias.model.dto;

import java.io.Serializable;

/**
 *
 * @author guillermorojas
 */
public class AlumnoDto implements Serializable{
    
    private String nombre;
    
    private String apellidoPaterno;
    
    private String apellidoMaterno;
    
    private String numeroCuenta;

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
}
