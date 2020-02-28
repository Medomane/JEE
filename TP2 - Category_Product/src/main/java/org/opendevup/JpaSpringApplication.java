package org.opendevup;

import org.opendevup.dao.ICategorieDao;
import org.opendevup.dao.IProduitDao;
import org.opendevup.entities.Categorie;
import org.opendevup.entities.Produit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class JpaSpringApplication {
    public static void main(String[] args) {
        ApplicationContext ctx=SpringApplication.run(JpaSpringApplication.class, args);

        System.out.println("---------------------------------------------------------");
        IProduitDao produitDao=ctx.getBean(IProduitDao.class);
        ICategorieDao categorieDao=ctx.getBean(ICategorieDao.class);
        System.out.println("Ajouter des catégories");
        categorieDao.save(new Categorie("Ordinateurs")); categorieDao.save(new Categorie("Imprimantes"));
        categorieDao.save(new Categorie("Logiciels"));
        System.out.println("Ajouter des produits");
        produitDao.save(new Produit("Ord AX 453", 870,new Categorie(1L)));
        produitDao.save(new Produit("Ord TA 6753", 1230,new Categorie(1L)));
        produitDao.save(new Produit("Imp HP 153", 340,new Categorie(2L)));
        produitDao.save(new Produit("Camtasia Studio", 340,new Categorie(3L)));
        System.out.println("Liste des toutes les catégories:");
        categorieDao.findAll().forEach(c->System.out.println(c.getNomCategorie()));
        System.out.println("Liste des tous les produits:");
        produitDao.findAll().forEach(p->{
            System.out.println(p.getIdProduit()+"--"+p.getDesignation()+"--"+p.getPrix()+"--"+p.getCategorie().getNomCategorie());
        });
        System.out.println("Consulter Une catégorie :");
        Categorie c=categorieDao.findOne(1L);
        System.out.println("Nom Catégorie :"+c.getNomCategorie());
        /*c.getProduits().forEach(p->System.out.println(p.getDesignation()));*/
        System.out.println("Consulter les produits d'une catégorie :");
        List<Produit> prodsParCat=produitDao.findByCategorie(1L);
        prodsParCat.forEach(p->System.out.println(p.getDesignation()));
    }
}