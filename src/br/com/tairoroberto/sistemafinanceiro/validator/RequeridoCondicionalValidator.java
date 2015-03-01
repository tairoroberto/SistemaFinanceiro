package br.com.tairoroberto.sistemafinanceiro.validator;

import com.sun.faces.util.MessageFactory;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by tairo on 28/02/15.
 * Validador se o campo contaPaga estiver checado
 * deverpa ser inserica a data do pagamento, senão for informada
 * uma data será apresentado uma mesnagem de erro.
 */
@FacesValidator("br.com.tairoroberto.RequeridoCondicional")
public class RequeridoCondicionalValidator implements Validator{
    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object value)
            throws ValidatorException {

        Boolean checked = (Boolean)uiComponent.getAttributes().get("checked");

        if (checked != null && checked && value == null){
            Object label = MessageFactory.getLabel(facesContext,uiComponent);
            String descricaoErro = "Preencha o campo " + label + ".";

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR,descricaoErro,descricaoErro);
            throw new ValidatorException(message);
        }
    }
}
