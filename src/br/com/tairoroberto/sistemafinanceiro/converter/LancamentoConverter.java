package br.com.tairoroberto.sistemafinanceiro.converter;

import br.com.tairoroberto.sistemafinanceiro.model.Lancamento;
import br.com.tairoroberto.sistemafinanceiro.repository.Lancamentos;
import br.com.tairoroberto.sistemafinanceiro.util.Repositorios;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * Created by tairo on 08/03/15.
 */
@FacesConverter(forClass = Lancamento.class)
public class LancamentoConverter implements Converter {

    Repositorios repositorios = new Repositorios();

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        Lancamento lancamento = null;
        Lancamentos lancamentos = this.repositorios.getLacamentos();
        if (value != null && !value.equals("")){
            lancamento = lancamentos.porCodigo(new Integer(value));

            if (lancamento == null){
                String descricaoErro = "Lançamento não existe!";
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,descricaoErro,descricaoErro);
                throw new ConverterException(message);
            }
        }
        return lancamento;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value != null){
            Integer codigo = ((Lancamento)value).getCodigo();
            return codigo == null ? "" : codigo.toString();
        }
        return null;
    }
}
