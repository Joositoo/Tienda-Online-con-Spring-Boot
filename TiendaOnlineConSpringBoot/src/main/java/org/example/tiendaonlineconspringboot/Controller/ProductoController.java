package org.example.tiendaonlineconspringboot.Controller;

import jakarta.validation.Valid;
import org.example.tiendaonlineconspringboot.Modelo.Producto;
import org.example.tiendaonlineconspringboot.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public ResponseEntity<Iterable<Producto>>getAll(){
        return ResponseEntity.ok(productoService.getProductos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Producto>>getProductoById(@PathVariable int id){
        return ResponseEntity.ok(productoService.getProductoById(id));
    }

    @PostMapping
    public ResponseEntity<Producto> saverOrUpdateProducto(@Valid @RequestBody Producto producto){
        productoService.saveOrUpdate(producto);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductoById(@PathVariable int id){
        productoService.deleteById(id);
        return ResponseEntity.ok("Producto con id " +id+ "eliminado.");
    }
}
