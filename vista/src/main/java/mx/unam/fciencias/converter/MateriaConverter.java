/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.unam.fciencias.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import mx.unam.fciencias.model.dto.MateriaDto;

/**
 *
 * @author guillermorojas
 */

@FacesConverter("materiaConverter")
public class MateriaConverter implements Converter {
    
      @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        MateriaDto materia = new MateriaDto();
            String cad[] = string.split("__");
            if(cad.length==3){
                materia.setId(Long.parseLong(cad[0]));
                materia.setNombre(cad[1]);
                materia.setSemestre(cad[2]);
                return materia;
            }else{
                return null;
            }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        MateriaDto materia;
        if(o instanceof MateriaDto){
            materia = (MateriaDto)o;
            return materia.getId()+"__"+materia.getNombre()+"__"+materia.getSemestre();
        }
        else{
            return null;
        }
    }
    
}
