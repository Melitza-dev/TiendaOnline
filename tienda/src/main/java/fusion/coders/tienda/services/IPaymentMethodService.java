package fusion.coders.tienda.services;

import fusion.coders.tienda.models.PaymentMethod;

import java.util.List;

public interface IPaymentMethodService {
    List<PaymentMethod> Listar();
    PaymentMethod ListarPorId();
    boolean agregar();
    boolean modificar();
    boolean elimninar();
}
