package fusion.coders.tienda.services;

import fusion.coders.tienda.models.Product;
import fusion.coders.tienda.models.Promotion;
import fusion.coders.tienda.repositories.ProductRepository;
import fusion.coders.tienda.repositories.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PromotionServiceImpl implements IPromotionService {
    @Autowired
    private PromotionRepository promotionRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Promotion> Listar() {
        return (List<Promotion>) promotionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Promotion> ListarPorId(Long id) {
        return promotionRepository.findById(id);
    }

    @Override
    @Transactional
    public Promotion agregar(Promotion promotion) {
        return promotionRepository.save(promotion);
    }

    @Override
    @Transactional
    public Optional<Promotion> modificar(Long id, Promotion promotion) {
        Optional<Promotion> promotionOptional = this.ListarPorId(id);

        if (promotionOptional.isPresent()) {
            Promotion promotionBd = promotionOptional.orElseThrow();
            promotionBd.setPromotionCode(promotion.getPromotionCode());
            promotionBd.setPorcentagePromotion(promotion.getPorcentagePromotion());
            promotionBd.setStartDate(promotion.getStartDate());
            promotionBd.setDateEnd(promotion.getDateEnd());
            return Optional.of(agregar(promotionBd));
        }
        return Optional.empty();
    }

    @Override
    @Transactional
    public void elimninar(Long id) {
        promotionRepository.deleteById(id);
    }
}
