package br.com.tairoroberto.sistemafinanceiro.converter;

import br.com.tairoroberto.sistemafinanceiro.model.Pessoa;
import br.com.tairoroberto.sistemafinanceiro.repository.Pessoas;
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
@FacesConverter(forClass = Pessoa.class)//"br.com.tairoroberto.PessoaConverter"
public class PessoaConverter implements Converter {

    private Repositorios repositorios = new Repositorios();

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
        Pessoa pessoa = null;
        Pessoas pessoas = this.repositorios.getPessoas();

        if (value != null && !value.equals("")){
            pessoa = pessoas.porCodigo(new Integer(value));

            if (pessoa == null){
                String descricaoErro = FacesUtil.getMessageI18n("person_does_not_exist");
                FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,descricaoErro,descricaoErro);
                throw new ConverterException(message);
            }
        }
        return pessoa;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
        if (value != null){
            Integer codigo = ((Pessoa)value).getCodigo();
            return codigo == null ? "" : codigo.toString();
        }
        return null;
    }
}

