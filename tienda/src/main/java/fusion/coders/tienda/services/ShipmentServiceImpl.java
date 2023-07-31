package fusion.coders.tienda.services;

import fusion.coders.tienda.models.Shipment;
import fusion.coders.tienda.repositories.ShipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipmentServiceImpl implements IShipmentService{
    @Autowired
    ShipmentRepository shipmentRepository;
    @Override
    public List<Shipment> Listar() {
        return null;
    }

    @Override
    public Shipment ListarPorId() {
        return null;
    }

    @Override
    public boolean agregar() {
        return false;
    }

    @Override
    public boolean modificar() {
        return false;
    }

    @Override
    public boolean elimninar() {
        return false;
    }
}
