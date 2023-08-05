package fusion.coders.tienda.services;

import fusion.coders.tienda.models.Promotion;
import fusion.coders.tienda.models.Shipment;

import java.util.List;
import java.util.Optional;

public interface IShipmentService {
    List<Shipment> Listar();

    Optional<Shipment> ListarPorId(Long id);

    Shipment agregar(Shipment shipment);

    Optional<Shipment> modificar(Long id, Shipment shipment);

    void elimninar(Long id);
}
