package org.bank.Controller;

import org.bank.Model.Compte;
import org.bank.Model.CompteCourant;
import org.bank.Model.CompteEpargne;
import org.bank.Repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CompteController {
    final
    CompteRepository comptes ;

    public CompteController(CompteRepository comptes) {
        this.comptes = comptes;
    }

    @GetMapping("/Comptes/{id}")
    public Optional<Compte> index(@PathVariable String id){
        return comptes.findById(Long.parseLong(id));
    }
    @PostMapping("/Comptes/addCC")
    public Compte add(@RequestBody CompteCourant cpt){
        return comptes.save(cpt);
    }
    @PostMapping("/Comptes/addCE")
    public Compte add(@RequestBody CompteEpargne cpt){
        return comptes.save(cpt);
    }
}
