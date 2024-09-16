package auctionKoi.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuctionSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private float startingPrice;

    private float endingPrice;

    private String bidderEmail;

    private String status;

    @ManyToOne
    @JoinColumn(name = "auction_id")
    @JsonIgnore
    private Auction auction;

    @OneToMany(mappedBy = "auctionSlot",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Bid> bidList;


    @OneToOne(mappedBy = "auctionSlot",cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    private KoiFish koiFish;

}
