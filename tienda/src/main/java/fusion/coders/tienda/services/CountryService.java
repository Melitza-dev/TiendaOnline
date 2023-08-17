package fusion.coders.tienda.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fusion.coders.tienda.models.Country;
import fusion.coders.tienda.repositories.CountryRepository;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country getCountryById(Long id) {
        return countryRepository.findById(id).orElse(null);
    }

    public Country createCountry(Country country){
        return countryRepository.save(country);
    }
    public Country updateCountry(Long id, Country updateCountry) {
        Country existingCountry = countryRepository.findById(id).orElse(null);
        if ( existingCountry != null) {
            //Actualizar los campos necesarios
            existingCountry.setNombre(updateCountry.getNombre());
            return countryRepository.save(existingCountry);
        }
        return null;
    }
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}
