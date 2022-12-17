package br.com.sdconecta.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    //isolar a criacao de uma EntityManger ja que ela é uma interface
    private static final EntityManagerFactory FACTORY = Persistence
            .createEntityManagerFactory("Loja");

    public static EntityManager getEntityManager() {
        return FACTORY.createEntityManager();
    }
}
