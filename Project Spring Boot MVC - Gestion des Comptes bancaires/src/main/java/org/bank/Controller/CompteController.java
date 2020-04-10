package org.bank.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bank.Model.CompteCourant;
import org.bank.Model.CompteEpargne;
import org.bank.Repositories.CompteRepository;
import org.springframework.web.bind.annotation.*;

@RestController

public class CompteController {
    final CompteRepository comptes ;
    public CompteController(CompteRepository comptes) {
        this.comptes = comptes;
    }
    @GetMapping("/admin/Comptes/CC/{id}")
    public CompteCourant CC(@PathVariable String id){
        return (CompteCourant)comptes.findById(id).get();
    }
    @GetMapping("/admin/Comptes/CE/{id}")
    public CompteEpargne CE(@PathVariable String id){
        return (CompteEpargne)comptes.findById(id).get();
    }
    @PostMapping("/admin/Comptes/addCC")
    public String add(@RequestBody CompteCourant cpt) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(comptes.save(cpt));
    }
    @PostMapping("/admin/Comptes/addCE")
    public String add(@RequestBody CompteEpargne cpt) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(comptes.save(cpt));
    }
}
