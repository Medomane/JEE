package org.bank.Controller;

import org.bank.Model.Client;
import org.bank.Model.Compte;
import org.bank.Model.CompteCourant;
import org.bank.Model.CompteEpargne;
import org.bank.Repositories.CompteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class CompteController {
    final
    CompteRepository comptes ;

    public CompteController(CompteRepository comptes) {
        this.comptes = comptes;
    }
    @GetMapping("/Comptes/CC/{id}")
    public CompteCourant CC(@PathVariable String id){
        return (CompteCourant)comptes.findById(Long.parseLong(id)).get();
    }
    @GetMapping("/Comptes/CE/{id}")
    public CompteEpargne CE(@PathVariable String id){
        return (CompteEpargne)comptes.findById(Long.parseLong(id)).get();
    }
    @PostMapping("/Comptes/addCC")
    public CompteCourant add(@RequestBody CompteCourant cpt){
        return comptes.save(cpt);
    }
    @PostMapping("/Comptes/addCE")
    public CompteEpargne add(@RequestBody CompteEpargne cpt){
        return comptes.save(cpt);
    }
}
