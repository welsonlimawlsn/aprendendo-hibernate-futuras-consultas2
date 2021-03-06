package br.com.welson.hibernate.persistence;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cliente")
public class Funcionario extends Pessoa {

    private BigDecimal salario;
    private String cargo;

    @Column(nullable = true)
    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    @Column(length = 60, nullable = true)
    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "salario=" + salario +
                ", cargo='" + cargo + '\'' +
                '}';
    }
}
