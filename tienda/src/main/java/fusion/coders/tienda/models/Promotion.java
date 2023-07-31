package fusion.coders.tienda.models;

import jakarta.persistence.*;
import lombok.Data;

import javax.security.auth.callback.LanguageCallback;
import java.math.BigDecimal;
import java.time.LocalDateTime;

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
    private BigDecimal porcentagePromotion;

    @Column(name = "start_date", columnDefinition = "DATE", nullable = false)
    private LocalDateTime startDate;

    @Column(name = "date_end", columnDefinition = "DATE", nullable = false)
    private LocalDateTime dateEnd;





}
