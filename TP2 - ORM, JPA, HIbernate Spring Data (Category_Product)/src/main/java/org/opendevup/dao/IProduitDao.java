package org.opendevup.dao;
import java.util.List;
import org.opendevup.entities.Produit;
public interface IProduitDao {
    public Produit save(Produit p);
    public List<Produit> findAll();
    public Produit findOne(Long id);
    public void remove(Long id);
    public void update(Produit p);
    public List<Produit> findByDesignation(String des);
    public List<Produit> findByCategorie(Long idCat);
}