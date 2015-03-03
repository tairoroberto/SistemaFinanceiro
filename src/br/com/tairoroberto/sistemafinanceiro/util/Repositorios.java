package br.com.tairoroberto.sistemafinanceiro.util;

import br.com.tairoroberto.sistemafinanceiro.repository.Lancamentos;
import br.com.tairoroberto.sistemafinanceiro.repository.Pessoas;
import br.com.tairoroberto.sistemafinanceiro.repository.RamosAtividades;
import br.com.tairoroberto.sistemafinanceiro.repository.infra.LancamentosHibernate;
import br.com.tairoroberto.sistemafinanceiro.repository.infra.PessoasHibernate;
import br.com.tairoroberto.sistemafinanceiro.repository.infra.RamosAtividadesHibernate;
import org.hibernate.Session;

import java.io.Serializable;

/**
 * Created by tairo on 02/03/15.
 */
public class Repositorios implements Serializable{

    public Pessoas getPessoas(){
        return new PessoasHibernate(this.getSession());
    }

    public RamosAtividades getRamosAtividates(){
        return new RamosAtividadesHibernate(this.getSession());
    }

    public Lancamentos getLacamentos(){
        return new LancamentosHibernate(this.getSession());
    }

    private Session getSession(){
        return (Session) FacesUtil.getRequestAttribute("session");
    }

}
