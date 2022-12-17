package br.com.sdconecta.loja.dao;

import br.com.sdconecta.loja.modelo.Categoria;

import javax.persistence.EntityManager;

public class CategoriaDao extends Dao<Categoria,Long> {
    public CategoriaDao(EntityManager em) {
        super(em, Categoria.class);
    }
}
