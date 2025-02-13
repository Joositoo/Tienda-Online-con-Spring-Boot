package org.example.tiendaonlineconspringboot.Repository;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.example.tiendaonlineconspringboot.Modelo.Producto;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductoRepository extends CrudRepository<Producto, Integer> {

    Producto findProductoByNombre(@Size(max = 100) @NotNull @Pattern(regexp = "^\\w{2,100}$", message = "Nombre del producto debe tener caracteres alfanuméricos.") String nombre);
}
