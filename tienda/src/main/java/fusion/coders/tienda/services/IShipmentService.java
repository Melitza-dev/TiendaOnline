package fusion.coders.tienda.services;

import fusion.coders.tienda.models.Shipment;

import java.util.List;

public interface IShipmentService {
    List<Shipment> Listar();
    Shipment ListarPorId();
    boolean agregar();
    boolean modificar();
    boolean elimninar();
}
