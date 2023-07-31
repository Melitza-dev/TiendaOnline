package fusion.coders.tienda.services;

import fusion.coders.tienda.models.Category;
import fusion.coders.tienda.models.Client;
import fusion.coders.tienda.repositories.CategoryRepository;
import fusion.coders.tienda.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientServiceImpl implements  IClientService{
    @Autowired
    ClientRepository clientRepository;
    @Transactional
    @Override
    public List<Client> listar() {
        return clientRepository.findAll();
    }

    @Transactional
    @Override
    public Client listarPorId(Long id) {
        try {
            return clientRepository.findById(id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Transactional
    @Override
    public void agregar(Client client) {
        clientRepository.create(client);
    }

    @Transactional
    @Override
    public boolean modificar(Long id, Client client) {
        Client clientBd = clientRepository.findById(id);

        try {
            if (clientBd != null) {
                clientRepository.update(id, client);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Transactional
    @Override
    public boolean elimninar(Long id) {

        try {
            Client categoryBd = clientRepository.findById(id);
            if (categoryBd != null) {
                clientRepository.delete(id);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
