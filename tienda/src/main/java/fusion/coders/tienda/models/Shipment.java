package fusion.coders.tienda.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "shipments")
@Data
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "shipping_methods", length = 50, nullable = false)
    private String shippingMethod;

    @Column(name = "shipping_date", columnDefinition = "DATE", nullable = false)
    private String shippingDate;

    @Column(name = "shipping_status", columnDefinition = "boolean", nullable = false)
    private boolean shippingStatus;


}
