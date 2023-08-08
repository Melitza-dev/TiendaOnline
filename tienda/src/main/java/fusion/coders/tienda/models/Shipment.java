package fusion.coders.tienda.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "shipments")
@Data
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "aditional_information")
    private String aditionalInformation;

    @Column(name = "shipping_date", nullable = true)
    private LocalDate shippingDate;

    @Column(name = "shipping_status", columnDefinition = "boolean", nullable = false)
    private Boolean shippingStatus;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_shipping_type",  nullable = false)
    private ShippingType shippingType;


}
