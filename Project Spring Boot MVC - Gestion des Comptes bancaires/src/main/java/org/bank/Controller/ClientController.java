package org.bank.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bank.Model.Client;
import org.bank.Repositories.ClientRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class ClientController {
    final ClientRepository clientRepository;
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    @GetMapping("/admin/Clients")
    public ModelAndView Clients(Model model, @RequestParam(name="nom",defaultValue="") String nom, @RequestParam(name="type",defaultValue="normal") String type){
        model.addAttribute("clients", clientRepository.search("%"+nom+"%"));
        return new ModelAndView("clients"+((type.equals("normal")?"":"::liste")));
    }
    @PostMapping("/admin/Clients/add")
    public String add(@RequestBody Client c) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(clientRepository.save(c));
    }
    @RequestMapping(value="/403",method= RequestMethod.GET)
    public ModelAndView error(){
        return new ModelAndView("errors/403");
    }
}
