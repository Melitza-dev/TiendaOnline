package fusion.coders.tienda.services;

import fusion.coders.tienda.models.ShippingType;
import fusion.coders.tienda.models.User;
import fusion.coders.tienda.repositories.ShippingTypeRepository;
import fusion.coders.tienda.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ShippingTypeServiceImpl implements IShippingTypeService{
    @Autowired
    private ShippingTypeRepository shippingTypeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ShippingType> Listar() {
        return (List<ShippingType>) shippingTypeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ShippingType> ListarPorId(Long id) {
        return shippingTypeRepository.findById(id);
    }

    @Override
    @Transactional
    public ShippingType agregar(ShippingType shippingType) {
        return shippingTypeRepository.save(shippingType);
    }

    @Override
    @Transactional
    public Optional<ShippingType> modificar(Long id, ShippingType shippingType) {
        Optional<ShippingType> shippingTypeOptional = this.ListarPorId(id);

        if (shippingTypeOptional.isPresent()) {
            ShippingType shippingTypeBd = shippingTypeOptional.orElseThrow();
            shippingTypeBd.setShippingMethod(shippingType.getShippingMethod());
            shippingTypeBd.setDescription(shippingType.getDescription());
            return Optional.of(agregar(shippingTypeBd));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public void elimninar(Long id) {
        shippingTypeRepository.deleteById(id);
    }
}

