package cl.duoc.elvolcan.service;

import cl.duoc.elvolcan.model.Producto;
import cl.duoc.elvolcan.repository.ProductoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductoService {

    private final ProductoRepository productoRepository;

    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Optional<Producto> buscarPorId(Long id) {
        return productoRepository.findById(id);
    }

    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    public Optional<Producto> actualizar(Long id, Producto datos) {
        return productoRepository.findById(id).map(prodExistente -> {
            prodExistente.setNombre(datos.getNombre());
            prodExistente.setMarca(datos.getMarca());
            prodExistente.setPrecio(datos.getPrecio());
            prodExistente.setStock(datos.getStock());
            prodExistente.setCategoria(datos.getCategoria());
            prodExistente.setActivo(datos.getActivo());
            return productoRepository.save(prodExistente);
        });
    }

    public boolean eliminarPorId(Long id) {
        if (productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}