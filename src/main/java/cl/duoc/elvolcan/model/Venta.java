package cl.duoc.elvolcan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ventas")
public class Venta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_cliente", nullable = false)
    private Long idCliente;

    private LocalDateTime fecha = LocalDateTime.now();

    @Column(nullable = false)
    private Integer total;

    @Column(length = 50)
    private String estado = "PENDIENTE";

    @Column(name = "direccion_despacho", nullable = false, length = 200)
    private String direccionDespacho;
}