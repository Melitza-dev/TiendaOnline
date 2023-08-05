package fusion.coders.tienda.services;

import fusion.coders.tienda.models.Order;

import java.util.List;
import java.util.Optional;

public interface IOrderService {
    List<Order> Listar();

    Optional<Order> ListarPorId(Long id);

    Order agregar(Order order);

    Optional<Order> modificar(Long id, Order order);

    void elimninar(Long id);
}

