package br.com.tairoroberto.sistemafinanceiro.validator;

import com.sun.faces.util.MessageFactory;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Date;

/**
 * Created by tairo on 28/02/15.
 */
@FacesValidator("br.com.tairoroberto.DataFutura")
public class DataFuturaValidator implements Validator{
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value)
            throws ValidatorException {
        Date data = (Date)value;

        if (data != null && data.after(new Date())){
            Object label = MessageFactory.getLabel(facesContext,uiComponent);
            String descricaoErro = label + " não pode ser uma data futura.";
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,descricaoErro,descricaoErro);
            throw new ValidatorException(message);
        }
    }
}
