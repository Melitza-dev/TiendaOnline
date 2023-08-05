package fusion.coders.tienda.services;

import fusion.coders.tienda.models.Promotion;
import fusion.coders.tienda.models.Shipment;
import fusion.coders.tienda.models.ShippingType;
import fusion.coders.tienda.repositories.OrderRepository;
import fusion.coders.tienda.repositories.PromotionRepository;
import fusion.coders.tienda.repositories.ShipmentRepository;
import fusion.coders.tienda.repositories.ShippingTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ShipmentServiceImpl implements IShipmentService{
    @Autowired
    private ShipmentRepository shipmentRepository;

    @Autowired
    private ShippingTypeRepository shippingTypeRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Shipment> Listar() {
        return (List<Shipment>) shipmentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Shipment> ListarPorId(Long id) {
        return shipmentRepository.findById(id);
    }

    @Override
    @Transactional
    public Shipment agregar(Shipment shipment) {
        ShippingType shippingType = shippingTypeRepository.findById(shipment.getShippingType().getId()).orElseThrow();
        shipment.setShippingType(shippingType);
        System.out.println("descripcion:" + shipment.getInformacionAdicional());
        return shipmentRepository.save(shipment);
    }

    @Override
    @Transactional
    public Optional<Shipment> modificar(Long id, Shipment shipment) {
        Optional<Shipment> shipmentOptional = this.ListarPorId(id);

        if (shipmentOptional.isPresent()) {
            Shipment shipmentBd = shipmentOptional.orElseThrow();
            //shipmentBd.setShippingMethod(shipment.getShippingMethod());
            shipmentBd.setShippingStatus(shipment.getShippingStatus());
            shipmentBd.setShippingDate(shipment.getShippingDate());
            shipmentBd.setShippingType(shippingTypeRepository.findById(shipment.getShippingType().getId()).orElseThrow());

            return Optional.of(agregar(shipmentBd));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public void elimninar(Long id) {
        shipmentRepository.deleteById(id);
    }
}
