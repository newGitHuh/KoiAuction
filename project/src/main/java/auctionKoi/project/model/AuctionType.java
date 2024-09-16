package auctionKoi.project.model;

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
@Table(name = "auction_type")
public class AuctionType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auction_type", nullable = false)
    private int auctionTypeId;

    @Column(name = "type_name", nullable = false)
    private String typeName;


}
