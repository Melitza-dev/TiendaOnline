package fusion.coders.tienda.services;

import fusion.coders.tienda.models.Shipment;
import fusion.coders.tienda.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> Listar();

    Optional<User> ListarPorId(Long id);

    User agregar(User user);

    Optional<User> modificar(Long id, User user);

    void elimninar(Long id);
}

