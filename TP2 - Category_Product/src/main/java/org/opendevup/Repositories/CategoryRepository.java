package org.opendevup.Repositories;

import org.opendevup.entities.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Categorie,Long> {
}
