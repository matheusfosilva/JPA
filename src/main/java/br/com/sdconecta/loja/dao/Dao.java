package br.com.sdconecta.loja.dao;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class Dao<T,U>{

    protected EntityManager em;
    private Class<T> clazz;

    public Dao(EntityManager em, Class<T> clazz) {
        this.em = em;
        this.clazz = clazz;
    }

    public void register(T o){
        this.em.persist(o);
    }

    public T searchById(U id){
        return em.find(clazz, id);
    }

    public List<T> list(){
        CriteriaQuery<T> cq =  em.getCriteriaBuilder().createQuery(clazz);
        cq.from(clazz);
        return em.createQuery(cq).getResultList();
    }

    public void update(T entity){
        this.em.merge(entity); //Merge utilizado para quando a entity estiver em estado detached sera feita uma copia da entidade para ser utilizada novamente
    }

    public void remove(T entity){
        entity = em.merge(entity);
        this.em.remove(entity);
    }


}
