package org.opendevup.dao;
import java.util.List;
import org.opendevup.entities.Categorie;
public interface ICategorieDao {
    public Categorie save(Categorie c);
    public List<Categorie> findAll();
    public Categorie findOne(Long id);
    public void remove(Long id);
    public void update(Categorie c);
}