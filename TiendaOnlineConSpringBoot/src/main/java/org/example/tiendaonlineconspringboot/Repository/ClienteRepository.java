package org.example.tiendaonlineconspringboot.Repository;

import org.example.tiendaonlineconspringboot.Modelo.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
}
