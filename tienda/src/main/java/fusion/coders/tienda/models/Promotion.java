package fusion.coders.tienda.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "promotions")
@Data
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "promotion_code", length = 20, nullable = false)
    private String promotionCode;

    @Column(name = "porcentage_promotion", precision = 10, scale = 2, nullable = false)
    private double porcentagePromotion;

    @Column(name = "start_date", columnDefinition = "DATE", nullable = false)
    private String startDate;

    @Column(name = "date_end", columnDefinition = "DATE", nullable = false)
    private String dateEnd;





}
