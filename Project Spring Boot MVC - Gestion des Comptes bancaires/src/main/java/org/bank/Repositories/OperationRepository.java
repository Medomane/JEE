package org.bank.Repositories;

import org.bank.Model.Compte;
import org.bank.Model.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;

public interface OperationRepository extends JpaRepository<Operation,Long> {
    Page<Operation> findByCompte(Compte cpt, Pageable pageable);
}
