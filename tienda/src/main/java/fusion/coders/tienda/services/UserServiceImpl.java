package fusion.coders.tienda.services;

import fusion.coders.tienda.models.Country;
import fusion.coders.tienda.models.User;
import fusion.coders.tienda.repositories.CountryRepository;
import fusion.coders.tienda.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Override
    @Transactional(readOnly = true)
    public List<User> Listar() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<User> ListarPorId(Long id) {
        return userRepository.findById(id);
    }

    @Override
    @Transactional
    public User agregar(User user) {
        Country country = countryRepository.findById(user.getCountry().getId()).orElseThrow();

        if(country != null){
            user.setCountry(country);
            return userRepository.save(user);
        }
        return  null;

    }

    @Override
    @Transactional
    public Optional<User> modificar(Long id, User user) {
        Optional<User> userOptional = this.ListarPorId(id);

        if (userOptional.isPresent()) {
            User userBd = userOptional.orElseThrow();
            userBd.setName(user.getName());
            userBd.setEmail(user.getEmail());
            userBd.setCountry(user.getCountry());
            userBd.setPassword(user.getPassword());
            return Optional.of(agregar(userBd));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public void elimninar(Long id) {
        userRepository.deleteById(id);
    }
}

