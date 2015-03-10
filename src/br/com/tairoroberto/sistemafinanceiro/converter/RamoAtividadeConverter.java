package br.com.tairoroberto.sistemafinanceiro.converter;

import br.com.tairoroberto.sistemafinanceiro.model.RamoAtividade;
import br.com.tairoroberto.sistemafinanceiro.repository.RamosAtividades;
import br.com.tairoroberto.sistemafinanceiro.util.FacesUtil;
import br.com.tairoroberto.sistemafinanceiro.util.Repositorios;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by tairo on 28/02/15.
 */
@FacesConverter(forClass = RamoAtividade.class)
public class RamoAtividadeConverter implements Converter{

    private Repositorios repositorios = new Repositorios();
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        RamoAtividade ramoAtividade = null;

        if (value != null && !value.equals("")){
            RamosAtividades ramosAtividades = this.repositorios.getRamosAtividates();
            ramoAtividade = ramosAtividades.porCodigo(new Integer(value));

            if (ramoAtividade == null){
                String descricaoErro = FacesUtil.getMessageI18n("activity_does_not_exist");
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,descricaoErro,descricaoErro);
                throw new ConverterException(message);
            }
        }
        return ramoAtividade;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {

        if (value != null){
            Integer codigo = ((RamoAtividade)value).getCodigo();
            return codigo == null ? "" : codigo.toString();
        }
        return null;
    }
}
