package cl.duoc.elvolcan.service;

import cl.duoc.elvolcan.model.Cliente;
import cl.duoc.elvolcan.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente guardar(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> actualizar(Long id, Cliente datos) {
        return clienteRepository.findById(id).map(clienteExistente -> {
            clienteExistente.setNombre(datos.getNombre());
            clienteExistente.setApellido(datos.getApellido());
            clienteExistente.setEmail(datos.getEmail());
            clienteExistente.setTelefono(datos.getTelefono());
            clienteExistente.setDireccion(datos.getDireccion());
            clienteExistente.setTipoConsumo(datos.getTipoConsumo());
            return clienteRepository.save(clienteExistente);
        });
    }

    public boolean eliminarPorId(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}