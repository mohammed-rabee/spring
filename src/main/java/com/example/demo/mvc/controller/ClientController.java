package com.example.demo.mvc.controller;

import com.example.demo.mvc.model.Client;
import com.example.demo.mvc.service.ClientService;
import javassist.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping( value = "" , consumes = "application/json")
    public void add (@RequestBody Client client) throws Exception {
        clientService.add(client);
    }

    @DeleteMapping( value = "/{id}" )
    public void delete (@PathVariable int id) throws NotFoundException {
        clientService.delete(id);
    }

    @PutMapping ( value = "" , consumes = "application/json")
    public void update (@RequestBody Client client) throws Exception {
        clientService.update(client);
    }

    @GetMapping(value = "/{id}")
    public Client view(@PathVariable int id) throws NotFoundException {
        return clientService.view(id);
    }

    @GetMapping(value = "" , produces = "application/json")
    public List<Client> viewAll(){
        return clientService.viewAll();

    }
}
