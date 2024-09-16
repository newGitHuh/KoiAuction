package auctionKoi.project.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private AuctionSlot auctionSlot;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    private float amount;

    private Date biddingDate;

    private boolean status;
}
