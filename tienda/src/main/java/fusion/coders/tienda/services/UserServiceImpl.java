package fusion.coders.tienda.services;

import fusion.coders.tienda.models.User;
import fusion.coders.tienda.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public List<User> Listar() {
        return null;
    }

    @Override
    public User ListarPorId() {
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
