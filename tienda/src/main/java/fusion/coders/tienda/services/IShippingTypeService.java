package fusion.coders.tienda.services;

import fusion.coders.tienda.models.ShippingType;
import fusion.coders.tienda.models.User;

import java.util.List;
import java.util.Optional;

public interface IShippingTypeService {
    List<ShippingType> Listar();

    Optional<ShippingType> ListarPorId(Long id);

    ShippingType agregar(ShippingType shippingType);

    Optional<ShippingType> modificar(Long id, ShippingType shippingType);

    void elimninar(Long id);
}

