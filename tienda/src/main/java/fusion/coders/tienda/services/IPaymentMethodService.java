package fusion.coders.tienda.services;

import fusion.coders.tienda.models.PaymentMethod;

import java.util.List;
import java.util.Optional;

public interface IPaymentMethodService {
    List<PaymentMethod> Listar();

    Optional<PaymentMethod> ListarPorId(Long id);

    PaymentMethod agregar(PaymentMethod paymentMethod);

    Optional<PaymentMethod> modificar(Long id, PaymentMethod paymentMethod);

    void elimninar(Long id);
}
