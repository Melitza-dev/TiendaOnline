package fusion.coders.tienda.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "shipping_type")
@Data
public class ShippingType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "shipping_methods", length = 50, nullable = false)
    private String shippingMethod;

    @Column(name = "description", columnDefinition = "TEXT", nullable = true)
    private String description;
}

