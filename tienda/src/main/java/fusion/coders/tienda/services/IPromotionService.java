package fusion.coders.tienda.services;

import fusion.coders.tienda.models.Promotion;

import java.util.List;

public interface IPromotionService {
    List<Promotion> Listar();
    Promotion ListarPorId();
    boolean agregar();
    boolean modificar();
    boolean elimninar();
}
