package org.bank.Controller;

import org.bank.Model.Client;
import org.bank.Repositories.ClientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    final ClientRepository clients;

    public ClientController(ClientRepository clients) {
        this.clients = clients;
    }
    @GetMapping({"/Clients/index","/Clients"})
    public List<Client> Clients(){
        return clients.findAll();
    }
    @GetMapping("/Clients/{nom}")
    public List<Client> ClientsByName(@PathVariable String nom){
        return clients.findAllByNom(nom);
    }
    @PostMapping("/Clients/add")
    public Client Add(@RequestBody Client clt){
        return clients.save(clt);
    }
}
