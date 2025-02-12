package org.example.tiendaonlineconspringboot.Controller;

import jakarta.validation.Valid;
import org.example.tiendaonlineconspringboot.Modelo.Historial;
import org.example.tiendaonlineconspringboot.Service.HistorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/historial")
public class HistorialController {
    @Autowired
    private HistorialService historialService;

    @GetMapping
    public ResponseEntity<Iterable<Historial>> getAll(){
        return ResponseEntity.ok(historialService.getHistoriales());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Historial>> getHistorialById(@PathVariable int id){
        return ResponseEntity.ok(historialService.getHistorialById(id));
    }

    @PostMapping
    public ResponseEntity<Historial> saveOrUpdateHistorial(@Valid @RequestBody Historial historial) throws Exception {
        historialService.saveOrUpdate(historial);
        return ResponseEntity.ok(historial);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteHistorialById(@PathVariable int id){
        historialService.deleteById(id);
        return ResponseEntity.ok("Historial con id " +id+ " eliminado.");
    }
}
