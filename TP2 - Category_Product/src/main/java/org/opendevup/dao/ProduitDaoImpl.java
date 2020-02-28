package org.opendevup.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.opendevup.entities.Produit;
import org.springframework.stereotype.Repository;
@Repository
@Transactional
public class ProduitDaoImpl implements IProduitDao {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public Produit save(Produit p) {
        entityManager.persist(p);
        return p;
    }
    @Override
    public List<Produit> findAll() {
        Query req=entityManager.createQuery("select p from Produit p");
        return req.getResultList();
    }
    @Override
    public Produit findOne(Long id) {
        Produit p=entityManager.find(Produit.class, id);
        return p;
    }
    @Override
    public void remove(Long id) {
        Produit p=entityManager.find(Produit.class, id);
        entityManager.remove(p);
    }
    @Override
    public List<Produit> findByDesignation(String des) {
        Query req=entityManager.createQuery("select p from Produit p where p.designation like :x");
        req.setParameter("x", des);
        return req.getResultList();
    }
    @Override
    public void update(Produit p) {
        entityManager.merge(p);
    }
    @Override
    public List<Produit> findByCategorie(Long idCat) {
        Query req=entityManager.createQuery("select p from Produit p where p.categorie.idCategorie=:x");
        req.setParameter("x", idCat);
        return req.getResultList();
    }
}