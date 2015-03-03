package br.com.tairoroberto.sistemafinanceiro.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by tairo on 02/03/15.
 */
public class FacesUtil {
    public static void adicionarMensagem(FacesMessage.Severity severity, String msg){
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(severity, msg, msg));
    }

    public static Object getRequestAttribute(String name){
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        HttpServletRequest request = (HttpServletRequest) externalContext.getRequest();

        return  request.getAttribute(name);
    }
}
