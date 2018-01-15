package br.com.welson.hibernate.persistence;

import javax.persistence.*;

@Entity
@Table(name = "produto")
public class Produto {

    private Long id;
    private String nome;
    private Categoria categoria;

    public Produto(){

    }

    public Produto (String nome, Categoria categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(length = 60, nullable = false)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //ManyToOne e @OneToOne por padrao tem o comportamento EAGER - já procura tudo no banco de dados mesmo sem necessidade dos dados
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Produto produto = (Produto) o;

        return id != null ? id.equals(produto.id) : produto.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
