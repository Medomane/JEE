package org.opendevup.Repositories;

import org.opendevup.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Produit,Long> {  }