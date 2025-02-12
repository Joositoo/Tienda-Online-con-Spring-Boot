package org.example.tiendaonlinespringboot.Repository;

import org.example.tiendaonlinespringboot.Modelo.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
}
