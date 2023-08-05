package fusion.coders.tienda.services;

import fusion.coders.tienda.models.*;
import fusion.coders.tienda.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Autowired
    private ShippingTypeRepository shippingTypeRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Order> Listar() {
        return (List<Order>) orderRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Order> ListarPorId(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    @Transactional
    public Order agregar(Order order) {
        Client client = clientRepository.findById(order.getClient().getId());
        Shipment shipment = shipmentRepository.findById(order.getShipment().getId()).orElseThrow();
        PaymentMethod paymentMethod = paymentMethodRepository.findById(order.getPaymentMethod().getId()).orElseThrow();
       // ShippingType shippingType = shippingTypeRepository.findById(order.getShippingType().getId()).orElseThrow();

        List<Product> productList = new ArrayList<>();
        for (Product p : order.getProducts()) {
            Product productBd = productRepository.findById(p.getId()).orElseThrow();

            //Agrego a la Orden de Compra
            productList.add(productBd);

            //Modifico el stock
            productBd.setStock(productBd.getStock() - 1);
            productRepository.save(productBd);
        }
        order.setShipment(shipment);
        order.setClient(client);
        order.setPaymentMethod(paymentMethod);
        //order.setShippingType(shippingType);
        order.setProducts(productList);

        return orderRepository.save(order);
    }

    @Override
    @Transactional
    public Optional<Order> modificar(Long id, Order order) {
        Optional<Order> orderOptional = this.ListarPorId(id);

        if (orderOptional.isPresent()) {
            Order orderBD = orderOptional.orElseThrow();
            orderBD.setClient(order.getClient());
            orderBD.setProducts(order.getProducts());
            orderBD.setDate(order.getDate());
           // orderBD.setShippingType(order.getShippingType());
            orderBD.setPaymentMethod(order.getPaymentMethod());
            return Optional.of(agregar(orderBD));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public void elimninar(Long id) {
        orderRepository.deleteById(id);
    }
}
