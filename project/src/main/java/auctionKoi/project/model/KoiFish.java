package auctionKoi.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class KoiFish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "breeder_id")
    @JsonIgnore
    private Breeder breeder;

    @ManyToOne
    @JoinColumn(name = "variety_id")
    private Variety variety;

    private String gender;
    private int age;
    private float size;
    private float price;
    private byte[] image;
    private String status;

    @OneToOne
    @JoinColumn(name = "auctionSlot_id")
    @JsonIgnore
    private AuctionSlot auctionSlot;


    @OneToOne
    @JoinColumn(name = "requestAuction_id")
    @JsonIgnore
    private RequestAuction requestAuction;
}
