package org.opendevup.dao;

import org.opendevup.entities.Categorie;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
@Repository
@Transactional
public class CategorieDaoImpl implements ICategorieDao{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Categorie save(Categorie c) {
        entityManager.persist(c);
        return c;
    }
    @Override
    public List<Categorie> findAll() {
        return entityManager.createQuery("select c from Categorie c").getResultList();
    }
    @Override
    public Categorie findOne(Long id) {
        return entityManager.find(Categorie.class,id);
    }
    @Override
    public void remove(Long id) {
        entityManager.remove(findOne(id));
    }
    @Override
    public void update(Categorie c) {
        entityManager.merge(c);
    }
}