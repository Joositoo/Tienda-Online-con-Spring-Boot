package org.example.tiendaonlinespringboot.Repository;

import org.example.tiendaonlinespringboot.Modelo.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {
}
