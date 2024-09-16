package auctionKoi.project.model;


import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "orders")
public class orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private AuctionSlot auctionSlot;

    private String bidderEmail;

    private float finalPrice;

    private float fee;

    private String address;

    private boolean paymentStatus;

    private String shippingStatus;

    private Date transactionDate;

}
