package com.example.demo.mvc.service;

import com.example.demo.mvc.repository.ClientRepository;
import com.example.demo.mvc.model.Client;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void add(Client client) throws Exception {

        Optional<Client> oldClient = clientRepository.findById(client.getId());

        if (oldClient.isPresent()) {
            throw new Exception("client already there");
        } else {
            clientRepository.saveAndFlush(client);
        }
    }

    public void delete (int id) throws NotFoundException {

        Optional<Client> client = clientRepository.findById(id);

        if (client.isPresent()) {
            clientRepository.deleteById(id);
        } else {
            throw new NotFoundException("No such client to delete");
        }
    }

    public void update (Client client) throws Exception {
        Optional<Client> oldClient = clientRepository.findById(client.getId());
        if (oldClient.isPresent()) {
            Client newClient = oldClient.get();
            newClient.setFirstName(client.getFirstName());
            newClient.setLastName(client.getLastName());
            newClient.setMobile(client.getMobile());
            clientRepository.saveAndFlush(newClient);
        } else {
            throw new NotFoundException("client not exist");
        }

    }

    public Client view (int id) throws NotFoundException {
        Optional<Client> client =  clientRepository.findById(id);
        if (client.isPresent())
            return client.get();
        else
            throw new NotFoundException("NO such client with this ID");
    }

    public List<Client> viewAll () {
        return clientRepository.findAll();
    }
}
