package fusion.coders.tienda.services;

import fusion.coders.tienda.models.Product;
import fusion.coders.tienda.models.Promotion;

import java.util.List;
import java.util.Optional;

public interface IPromotionService {
    List<Promotion> Listar();

    Optional<Promotion> ListarPorId(Long id);

    Promotion agregar(Promotion promotion);

    Optional<Promotion> modificar(Long id, Promotion promotion);

    void elimninar(Long id);
}
