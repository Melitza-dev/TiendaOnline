package fusion.coders.tienda.services;

import fusion.coders.tienda.models.Order;
import fusion.coders.tienda.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> Listar() {
        return null;
    }

    @Override
    public Order ListarPorId() {
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
