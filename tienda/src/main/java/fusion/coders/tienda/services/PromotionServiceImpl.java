package fusion.coders.tienda.services;

import fusion.coders.tienda.models.Promotion;
import fusion.coders.tienda.repositories.PromotionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromotionServiceImpl implements IPromotionService{
    @Autowired
    PromotionRepository promotionRepository;
    @Override
    public List<Promotion> Listar() {
        return null;
    }

    @Override
    public Promotion ListarPorId() {
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
