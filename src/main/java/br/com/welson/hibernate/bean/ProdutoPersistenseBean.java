package br.com.welson.hibernate.bean;

import br.com.welson.hibernate.JpaUtil;
import br.com.welson.hibernate.persistence.Categoria;
import br.com.welson.hibernate.persistence.Produto;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.io.Serializable;

@Named
@RequestScoped
public class ProdutoPersistenseBean implements Serializable {

    public void executa1() {

        EntityManager manager = JpaUtil.getEntityManger();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Categoria bebida = new Categoria();
        bebida.setNome("Bebidas");

        Produto refrigerante = new Produto("Refrigerante", bebida);

        Produto agua = new Produto("Água", bebida);

        Produto cerveja = new Produto("Cerveja", bebida);

        manager.persist(bebida);
        manager.persist(refrigerante);
        manager.persist(agua);
        manager.persist(cerveja);

        transaction.commit();
        manager.close();
        JpaUtil.close();
    }

    public void executa2() {
        EntityManager manager = JpaUtil.getEntityManger();

        Categoria categoria = manager.find(Categoria.class, 3L);

        System.out.println(categoria.getNome());

        for (Produto produto : categoria.getProdutos()) {
            System.out.println(produto.getNome());
        }

        manager.close();
        JpaUtil.close();
    }

    public void executa3() {
        EntityManager manager = JpaUtil.getEntityManger();

        Produto produto = manager.find(Produto.class, 4L);
        System.out.println(produto.getNome());
        System.out.println(produto.getCategoria().getNome());

        manager.close();
        JpaUtil.close();
    }

    public void executa4() {
        EntityManager manager = JpaUtil.getEntityManger();
        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        Categoria carne = new Categoria();
        carne.setNome("Carnes");

        Produto produto = new Produto("Picanha", carne);

        manager.persist(produto);

        transaction.commit();
        manager.close();
        JpaUtil.close();
    }

}
