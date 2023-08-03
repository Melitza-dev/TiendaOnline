package fusion.coders.tienda.services;

import fusion.coders.tienda.models.User;

import java.util.List;

public interface IUserService {
    List<User> Listar();
    User ListarPorId();
    boolean agregar();
    boolean modificar();
    boolean elimninar();
}
