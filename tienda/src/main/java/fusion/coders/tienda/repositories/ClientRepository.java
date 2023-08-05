package fusion.coders.tienda.repositories;

import fusion.coders.tienda.models.Client;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClientRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<Client> findAll() {
        String sql = "SELECT * FROM clients";
        return entityManager
          .createNativeQuery(sql, Client.class)
          .getResultList();
    }

    public Client findById(Long id) {
        String sql = "SELECT * FROM clients WHERE id= :id";

        return (Client) entityManager
          .createNativeQuery(sql, Client.class)
          .setParameter("id", id)
          .getSingleResult();
    }

    public Client create(Client client) {
        String sql = "INSERT INTO clients (name, email, address, contact_information) VALUES (:name, :email, :address, :contact_information)";
        entityManager
          .createNativeQuery(sql, Client.class)
          .setParameter("name", client.getName())
          .setParameter("email", client.getEmail())
          .setParameter("address", client.getAddress())
          .setParameter("contact_information", client.getContactInformation())
          .executeUpdate();
        return client;
    }


    public Long update(Long id, Client client) {

        String sql = "UPDATE clients SET name= :name, email= :email, address= :address, contact_information= :contact_information" +
          " WHERE id= :id";
        entityManager
          .createNativeQuery(sql, Client.class)
          .setParameter("name", client.getName())
          .setParameter("email", client.getEmail())
          .setParameter("address", client.getAddress())
          .setParameter("contact_information", client.getContactInformation())
          .setParameter("id", id)
          .executeUpdate();
        return id;
    }

    public void delete(Long id) {
        String sql = "DELETE FROM clients WHERE id= :id";

        entityManager
          .createNativeQuery(sql, Client.class)
          .setParameter("id", id)
          .executeUpdate();
    }
}

