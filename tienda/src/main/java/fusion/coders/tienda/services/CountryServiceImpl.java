package fusion.coders.tienda.services;

import fusion.coders.tienda.models.Country;
import fusion.coders.tienda.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements ICountryService{
    @Autowired
    private CountryRepository countryRepository;
    @Override
    @Transactional(readOnly = true)
    public List<Country> Listar() {
        return (List<Country>)countryRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Country> ListarPorId(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    @Transactional
    public Country agregar(Country country) {
        return countryRepository.save(country);
    }

    @Override
    @Transactional
    public Optional<Country> modificar(Long id, Country country) {
        Optional<Country> countryOptional = this.ListarPorId(id);

        if (countryOptional.isPresent()) {
            Country countryBD = countryOptional.orElseThrow();
            countryBD.setName(country.getName());
            countryBD.setZipCode(country.getZipCode());
            return Optional.of(agregar(countryBD));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public void elimninar(Long id) {
        countryRepository.deleteById(id);
    }
}
