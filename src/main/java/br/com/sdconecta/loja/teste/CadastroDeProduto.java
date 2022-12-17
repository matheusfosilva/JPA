package br.com.sdconecta.loja.teste;

import br.com.sdconecta.loja.dao.CategoriaDao;
import br.com.sdconecta.loja.dao.ProdutoDao;
import br.com.sdconecta.loja.modelo.Categoria;
import br.com.sdconecta.loja.modelo.Produto;
import br.com.sdconecta.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class CadastroDeProduto {

    public static void main(String[] args) {
        cadastrarProduto();

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);

        produtoDao.list().forEach(item -> System.out.println(item.getNome() + " valor: " + item.getPreco()));

    }

    private static void cadastrarProduto() {

        Categoria celulares = new Categoria("Celulares");
        Produto produto = new Produto("SAMSUNG A32", "celular muito util e pratico", new BigDecimal("3000"), celulares);

        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDao produtoDao = new ProdutoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        em.getTransaction().begin();
        categoriaDao.register(celulares);
        produtoDao.register(produto);
        em.getTransaction().commit();
        em.close();
    }
}
