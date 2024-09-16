package auctionKoi.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestAuction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String auctionType;

    @OneToOne(mappedBy = "requestAuction", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private KoiFish koiFish;

    private String status;

    @ManyToOne
    @JoinColumn(name = "breeder_id")
    private Breeder breeder;
}
