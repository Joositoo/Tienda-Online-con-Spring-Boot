package org.example.tiendaonlinespringboot.Controller;

import org.example.tiendaonlinespringboot.Modelo.Cliente;
import org.example.tiendaonlinespringboot.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping("listar")
    public ResponseEntity<Iterable<Cliente>> getAll(){
        return ResponseEntity.ok(clienteService.getClientes());
    }

    @GetMapping("cliente/{id}")
    public ResponseEntity<Optional<Cliente>> getClienteById(@PathVariable int id){
        return ResponseEntity.ok(clienteService.getClienteById(id));
    }

    @PostMapping("/alta")
    public ResponseEntity<Cliente> saveOrUpdateCliente(@RequestBody Cliente cliente){
        clienteService.saveOrUpdate(cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/baja/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable int id){
        clienteService.deleteById(id);
        return ResponseEntity.ok("Cliente con id " +id+" eliminado");
    }
}
