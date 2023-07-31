package fusion.coders.tienda.services;

import fusion.coders.tienda.models.Category;
import fusion.coders.tienda.models.Client;

import java.util.List;

public interface IClientService {
    List<Client> listar();
    Client listarPorId(Long id);
    void agregar(Client client);
    boolean modificar(Long id, Client client);
    boolean elimninar(Long id);
}
