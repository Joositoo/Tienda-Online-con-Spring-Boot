package org.example.tiendaonlineconspringboot.Repository;

import org.example.tiendaonlineconspringboot.Modelo.Historial;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialRepository extends CrudRepository<Historial, Integer> {
}
