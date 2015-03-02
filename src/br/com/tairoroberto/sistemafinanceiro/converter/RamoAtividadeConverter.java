package br.com.tairoroberto.sistemafinanceiro.converter;

import br.com.tairoroberto.sistemafinanceiro.model.RamoAtividade;
import br.com.tairoroberto.sistemafinanceiro.service.GestaoRamosAtividades;
import br.com.tairoroberto.sistemafinanceiro.util.HibernateUtil;
import org.hibernate.Session;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created by tairo on 28/02/15.
 */
@FacesConverter(forClass = RamoAtividade.class)
public class RamoAtividadeConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        RamoAtividade ramoAtividade = null;

        if (value != null){
            Session session = HibernateUtil.getSession();

            ramoAtividade = (RamoAtividade) session.get(RamoAtividade.class, new Integer(value));

            session.close();
        }
        return ramoAtividade;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value != null){
            return ((RamoAtividade)value).getCodigo().toString();
        }
        return null;
    }
}
