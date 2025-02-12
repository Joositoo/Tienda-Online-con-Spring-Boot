package org.example.tiendaonlineconspringboot.Repository;

import org.example.tiendaonlineconspringboot.Modelo.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {
}
