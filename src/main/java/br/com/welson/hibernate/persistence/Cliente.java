package br.com.welson.hibernate.persistence;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("C")
public class Cliente extends Pessoa {

    private BigDecimal limiteCredito;
    private BigDecimal rendaMensal;
    private boolean bloqueado;

    @Column(name = "limite_credito", nullable = true)
    public BigDecimal getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(BigDecimal limiteCredito) {
        this.limiteCredito = limiteCredito;
    }

    @Column(name = "renda_mensal", nullable = true)
    public BigDecimal getRendaMensal() {
        return rendaMensal;
    }

    public void setRendaMensal(BigDecimal rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    @Column(nullable = true)
    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "limiteCredito=" + limiteCredito +
                ", rendaMensal=" + rendaMensal +
                ", bloqueado=" + bloqueado +
                '}';
    }
}
