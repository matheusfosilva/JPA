package br.com.sdconecta.loja.dao;

import br.com.sdconecta.loja.modelo.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDao extends Dao<Produto,Long>{
    public ProdutoDao(EntityManager em) {
        super(em, Produto.class);
    }

    public List<Produto> searchByName(String nome){
        String jpql =  "Select p FROM Produto p WHERE p.nome = :nome"; //Named Parameter
        return em.createQuery(jpql, Produto.class )
                .setParameter("nome", nome )
                .getResultList();
    }

    public List<Produto> searchByCategoryName(String nome){
        String jpql =  "Select p FROM Produto p WHERE p.categoria.nome = :nome"; //Named Parameter
        return em.createQuery(jpql, Produto.class )
                .setParameter("nome", nome )
                .getResultList();
    }

    public BigDecimal searchPriceByName(String nome){
        String jpql =  "Select p.preco FROM Produto p WHERE p.nome = :nome"; //Named Parameter
        return em.createQuery(jpql, BigDecimal.class )
                .setParameter("nome", nome )
                .getSingleResult();
    }


}
