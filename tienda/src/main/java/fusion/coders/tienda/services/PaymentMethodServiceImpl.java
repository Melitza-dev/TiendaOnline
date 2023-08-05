package fusion.coders.tienda.services;

import fusion.coders.tienda.models.Order;
import fusion.coders.tienda.models.PaymentMethod;
import fusion.coders.tienda.repositories.OrderRepository;
import fusion.coders.tienda.repositories.PaymentMethodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentMethodServiceImpl implements IPaymentMethodService{

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;
    @Override
    @Transactional(readOnly = true)
    public List<PaymentMethod> Listar() {
        return (List<PaymentMethod>)paymentMethodRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<PaymentMethod> ListarPorId(Long id) {
        return paymentMethodRepository.findById(id);
    }

    @Override
    @Transactional
    public PaymentMethod agregar(PaymentMethod paymentMethod) {
        return paymentMethodRepository.save(paymentMethod);
    }

    @Override
    @Transactional
    public Optional<PaymentMethod> modificar(Long id, PaymentMethod paymentMethod) {
        Optional<PaymentMethod> paymentMethodOptional = this.ListarPorId(id);

        if (paymentMethodOptional.isPresent()) {
            PaymentMethod paymentMethodBd = paymentMethodOptional.orElseThrow();
            paymentMethodBd.setName(paymentMethod.getName());
            return Optional.of(agregar(paymentMethodBd));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public void elimninar(Long id) {
        paymentMethodRepository.deleteById(id);
    }
}