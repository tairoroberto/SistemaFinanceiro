package br.com.tairoroberto.sistemafinanceiro.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 * Created by tairo on 02/03/15.
 */
public class FacesUtil {
    public static void adicionarMensagem(FacesMessage.Severity severity, String msg){
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(severity, msg, msg));
    }
}
