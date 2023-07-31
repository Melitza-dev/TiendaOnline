package fusion.coders.tienda.services;

import fusion.coders.tienda.models.PaymentMethod;
import fusion.coders.tienda.repositories.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentMethodServiceImpl implements IPaymentMethodService{
    @Autowired
    PaymentMethodRepository paymentMethodRepository;
    @Override
    public List<PaymentMethod> Listar() {
        return null;
    }

    @Override
    public PaymentMethod ListarPorId() {
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
