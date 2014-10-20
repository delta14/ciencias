/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.fciencias.converter;

/**
 *
 * @author guillermorojas
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import mx.unam.fciencias.model.dto.CarreraDto;


@FacesConverter("carreraConverter")
public class CarreraConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        CarreraDto carrera = new CarreraDto();
            String cad[] = string.split("__");
            if(cad.length==3){
                carrera.setId(Long.parseLong(cad[0]));
                carrera.setNombre(cad[1]);
                carrera.setPlan(cad[2]);
                return carrera;
            }else{
                return null;
            }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        CarreraDto carrera;
        if(o instanceof CarreraDto){
            carrera = (CarreraDto)o;
            return carrera.getId()+"__"+carrera.getNombre()+"__"+carrera.getPlan();
        }
        else{
            return null;
        }
    }
    
    
}

