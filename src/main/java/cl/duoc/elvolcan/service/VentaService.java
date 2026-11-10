package cl.duoc.elvolcan.service;

import cl.duoc.elvolcan.model.Venta;
import cl.duoc.elvolcan.repository.VentaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VentaService {

    private final VentaRepository ventaRepository;

    public List<Venta> obtenerTodos() {
        return ventaRepository.findAll();
    }

    public Optional<Venta> buscarPorId(Long id) {
        return ventaRepository.findById(id);
    }

    public Venta guardar(Venta venta) {
        return ventaRepository.save(venta);
    }

    public Optional<Venta> actualizar(Long id, Venta datos) {
        return ventaRepository.findById(id).map(ventaExistente -> {
            ventaExistente.setIdCliente(datos.getIdCliente());
            ventaExistente.setTotal(datos.getTotal());
            ventaExistente.setEstado(datos.getEstado());
            ventaExistente.setDireccionDespacho(datos.getDireccionDespacho());
            return ventaRepository.save(ventaExistente);
        });
    }

    public boolean eliminarPorId(Long id) {
        if (ventaRepository.existsById(id)) {
            ventaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}