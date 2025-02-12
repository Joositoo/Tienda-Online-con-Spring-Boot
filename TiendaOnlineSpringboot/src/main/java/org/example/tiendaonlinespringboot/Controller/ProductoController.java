package org.example.tiendaonlinespringboot.Controller;

import org.example.tiendaonlinespringboot.Modelo.Producto;
import org.example.tiendaonlinespringboot.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("/listar")
    public ResponseEntity<Iterable<Producto>>getAll(){
        return ResponseEntity.ok(productoService.getProductos());
    }

    @GetMapping("/producto/{id}")
    public ResponseEntity<Optional<Producto>>getProductoById(@PathVariable int id){
        return ResponseEntity.ok(productoService.getProductoById(id));
    }

    @PostMapping("/alta")
    public ResponseEntity<Producto> saverOrUpdateProducto(@RequestBody Producto producto){
        productoService.saveOrUpdate(producto);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/baja/{id}")
    public ResponseEntity<String> deleteProductoById(@PathVariable int id){
        productoService.deleteById(id);
        return ResponseEntity.ok("Producto con id " +id+ "eliminado.");
    }
}
