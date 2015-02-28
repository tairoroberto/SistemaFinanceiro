package br.com.tairoroberto.sistemafinanceiro.converter;

import br.com.tairoroberto.sistemafinanceiro.model.Pessoa;
import br.com.tairoroberto.sistemafinanceiro.service.GestaoPessoas;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created by tairo on 28/02/15.
 */
@FacesConverter(forClass = Pessoa.class)
public class PessoaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        Pessoa pessoa = null;

        if (value != null){
            GestaoPessoas gestaoPessoas = new GestaoPessoas();
            pessoa = gestaoPessoas.buscarPorCodico(new Integer(value));
        }
        return pessoa;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value != null){
            return ((Pessoa) value).getCodigo().toString();
        }
        return null;
    }
}

