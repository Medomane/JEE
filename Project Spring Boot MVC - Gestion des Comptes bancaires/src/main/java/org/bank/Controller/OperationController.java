package org.bank.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bank.Model.Compte;
import org.bank.Model.Operation;
import org.bank.Model.Retrait;
import org.bank.Model.Versement;
import org.bank.Repositories.CompteRepository;
import org.bank.Repositories.OperationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class OperationController {
    final OperationRepository operations ;
    final CompteRepository comptes ;
    public OperationController(OperationRepository operations, CompteRepository comptes) {
        this.operations = operations;
        this.comptes = comptes;
    }
    @GetMapping("/admin/Operations/{compte_id}")
    public ModelAndView operations(Model model,
                                   @PathVariable String compte_id,
                                   @RequestParam(name="page",defaultValue="0")int page,
                                   @RequestParam(name="type",defaultValue="normal")String type){
        Page<Operation> lst = operations.findByCompte(comptes.findById(compte_id).get(), PageRequest.of(page, 5));
        model.addAttribute("operations",lst);
        model.addAttribute("comptes",comptes.findAll());
        model.addAttribute("page",page);
        model.addAttribute("compte_id",compte_id);
        int[] pages=new int[lst.getTotalPages()];
        for(int i=0;i<pages.length;i++) pages[i]=i;
        model.addAttribute("pages", pages);
        return new ModelAndView("operations"+((type.equals("normal")?"":"::liste")));
    }
    @GetMapping("/admin/Operations")
    public String save(Model model,
                            @RequestParam(name="compte_id",required = true) String compte_id,
                            @RequestParam(name="montant",defaultValue="0") String montant,
                            @RequestParam(name="type",defaultValue="v") String type) throws JsonProcessingException {
        return operation(compte_id,Double.parseDouble(montant),type);
    }
    @GetMapping("/admin/Operations/virement")
    @Transactional(propagation = Propagation.REQUIRED)
    public String virement(Model model,
                            @RequestParam(name="de",required = true) String de,
                            @RequestParam(name="vers",required = true) String vers,
                            @RequestParam(name="montant",defaultValue="0") String montant) throws JsonProcessingException {
        operation(vers,Double.parseDouble(montant),"v");
        return operation(de,Double.parseDouble(montant),"r");
    }
    private String operation(String compte_id, double montant, String type) throws JsonProcessingException {
        Compte cpt = comptes.findById(compte_id).get();
        Operation op = null;
        if(type.equals("v") && montant >= 0) {
            cpt.setSolde(cpt.getSolde()+montant);
            op = new Versement();
        }
        if(type.equals("r") && montant <= cpt.getSolde()) {
            cpt.setSolde(cpt.getSolde()-montant);
            op = new Retrait();
        }
        if(op != null){
            op.setMontant(montant);
            op.setCompte(cpt);
            operations.save(op);
        }
        return new ObjectMapper().writeValueAsString(comptes.save(cpt));
    }
}
