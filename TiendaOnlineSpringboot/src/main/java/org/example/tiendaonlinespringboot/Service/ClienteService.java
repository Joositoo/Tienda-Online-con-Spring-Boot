package org.example.tiendaonlinespringboot.Service;

import org.example.tiendaonlinespringboot.Modelo.Cliente;
import org.example.tiendaonlinespringboot.Repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Iterable<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> getClienteById(int id) {
        return clienteRepository.findById(id);
    }

    public void saveOrUpdate(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void deleteById(int id) {
        clienteRepository.deleteById(id);
    }
}
