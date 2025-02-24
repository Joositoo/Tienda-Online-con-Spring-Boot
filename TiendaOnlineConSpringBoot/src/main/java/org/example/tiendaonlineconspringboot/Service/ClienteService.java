package org.example.tiendaonlineconspringboot.Service;

import org.example.tiendaonlineconspringboot.Modelo.Cliente;
import org.example.tiendaonlineconspringboot.Repository.ClienteRepository;
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
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()){
            return clienteRepository.findById(id);
        }
        else{
            throw new RuntimeException("Cliente con id " + id + " no encontrado.");
        }
    }

    public void saveOrUpdate(Cliente cliente) {
        clienteRepository.save(cliente);
    }

    public void deleteById(int id) {
        if (clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
        }
        else{
            throw new RuntimeException("Cliente con id " + id + " no existe.");
        }
    }
}
