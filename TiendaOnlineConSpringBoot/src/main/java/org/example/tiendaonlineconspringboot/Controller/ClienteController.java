package org.example.tiendaonlineconspringboot.Controller;

import jakarta.validation.Valid;
import org.example.tiendaonlineconspringboot.Modelo.Cliente;
import org.example.tiendaonlineconspringboot.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> getAll(){
        return ResponseEntity.ok(clienteService.getClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> getClienteById(@PathVariable int id){
        return ResponseEntity.ok(clienteService.getClienteById(id));
    }

    @PostMapping()
    public ResponseEntity<Cliente> saveOrUpdateCliente(@Valid @RequestBody Cliente cliente){
        clienteService.saveOrUpdate(cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable int id){
        clienteService.deleteById(id);
        return ResponseEntity.ok("Cliente con id " +id+" eliminado.");
    }
}
