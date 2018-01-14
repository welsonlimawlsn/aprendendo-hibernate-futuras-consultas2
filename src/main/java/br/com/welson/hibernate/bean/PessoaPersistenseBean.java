package br.com.welson.hibernate.bean;

import br.com.welson.hibernate.JpaUtil;
import br.com.welson.hibernate.persistence.Cliente;
import br.com.welson.hibernate.persistence.Funcionario;
import br.com.welson.hibernate.persistence.Pessoa;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Named
@RequestScoped
public class PessoaPersistenseBean implements Serializable {

    public void executa1() {
        EntityManager manager = JpaUtil.getEntityManger();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Fernando");
        funcionario.setCargo("Gerente");
        funcionario.setSalario(new BigDecimal(12_000));

        Cliente cliente = new Cliente();
        cliente.setNome("Mariana");
        cliente.setRendaMensal(new BigDecimal(8_500));
        cliente.setLimiteCredito(new BigDecimal(2_000));
        cliente.setBloqueado(true);

        manager.persist(funcionario);
        manager.persist(cliente);

        transaction.commit();
        manager.close();
        JpaUtil.close();
    }

    public void executa2() {
        EntityManager manager = JpaUtil.getEntityManger();

        List<Cliente> clientes = manager.createQuery("from Cliente ", Cliente.class).getResultList();

        List<Funcionario> funcionarios = manager.createQuery("from Funcionario ", Funcionario.class).getResultList();

        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }

        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }

        manager.close();
        JpaUtil.close();
    }

    public void executa3() {
        EntityManager manager = JpaUtil.getEntityManger();

        List<Pessoa> pessoas = manager.createQuery("from Pessoa ", Pessoa.class).getResultList();

        for (Pessoa pessoa : pessoas) {
            if (pessoa instanceof Cliente) {
                System.out.println("É cliente: " + pessoa.getNome());
            } else {
                System.out.println("É funcionario: " + pessoa.getNome());
            }
        }

        manager.close();
        JpaUtil.close();

    }
}
