package org.opendevup.dao;
import java.util.List;import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query; import org.opendevup.entities.Categorie;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
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
        Query req=entityManager.createQuery("select c from Categorie c");
        return req.getResultList();
    }
    @Override
    public Categorie findOne(Long id) {
        Categorie c=entityManager.find(Categorie.class,id);
        return c;
    }
    @Override
    public void remove(Long id) {
        Categorie c=findOne(id);
        entityManager.remove(c);
    }
    @Override
    public void update(Categorie c) {
        entityManager.merge(c);
    }
}