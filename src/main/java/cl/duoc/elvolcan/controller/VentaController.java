package cl.duoc.elvolcan.controller;

import cl.duoc.elvolcan.model.Venta;
import cl.duoc.elvolcan.service.VentaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class VentaController {

    private final VentaService ventaService;

    @GetMapping
    public ResponseEntity<List<Venta>> obtenerTodos() {
        return ResponseEntity.ok(ventaService.obtenerTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> buscarPorId(@PathVariable Long id) {
        return ventaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Venta> guardar(@RequestBody Venta venta) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ventaService.guardar(venta));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venta> actualizar(@PathVariable Long id, @RequestBody Venta venta) {
        return ventaService.actualizar(id, venta)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
        if (ventaService.eliminarPorId(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}