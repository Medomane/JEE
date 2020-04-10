package org.bank.Repositories;

import org.bank.Model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client,Long> {
    @Query("select c from Client c where c.nom like :x order by c.code DESC")
    List<Client> search(@Param("x") String name);
}
