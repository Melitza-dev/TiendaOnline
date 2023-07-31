package fusion.coders.tienda.services;

import fusion.coders.tienda.models.Order;

import java.util.List;

public interface IOrderService {
    List<Order> Listar();
    Order ListarPorId();
    boolean agregar();
    boolean modificar();
    boolean elimninar();
}
