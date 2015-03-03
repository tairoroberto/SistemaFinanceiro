package br.com.tairoroberto.sistemafinanceiro.converter;

import br.com.tairoroberto.sistemafinanceiro.model.Pessoa;
import br.com.tairoroberto.sistemafinanceiro.repository.Pessoas;
import br.com.tairoroberto.sistemafinanceiro.util.Repositorios;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created by tairo on 28/02/15.
 */
@FacesConverter("br.com.tairoroberto.PessoaConverter")//forClass = Pessoa.class
public class PessoaConverter implements Converter {

    private Repositorios repositorios = new Repositorios();

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        Pessoa pessoa = null;
        Pessoas pessoas = this.repositorios.getPessoas();

        if (value != null){
            pessoa = pessoas.porCodigo(new Integer(value));
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

