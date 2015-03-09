package br.com.tairoroberto.sistemafinanceiro.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by tairo on 28/02/15.
 */

@Entity
@Table(name = "ramo_atividade")
public class RamoAtividade implements Serializable, Cloneable {
    private Integer codigo;
    private String descricao;

    public RamoAtividade() {
    }


    public RamoAtividade(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    @Id
    @GeneratedValue
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Column(name = "descricao")
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RamoAtividade that = (RamoAtividade) o;

        if (codigo != null ? !codigo.equals(that.codigo) : that.codigo != null) return false;
        if (descricao != null ? !descricao.equals(that.descricao) : that.descricao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codigo != null ? codigo.hashCode() : 0;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        return result;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
