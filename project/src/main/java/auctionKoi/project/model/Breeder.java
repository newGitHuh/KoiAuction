package auctionKoi.project.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Breeder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "breeder_name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "location")
    private String location;

    @Column(name = "status")
    private boolean status;

    @JsonIgnore
    @OneToMany(mappedBy = "breeder", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<RequestAuction> requestAuctions;

    @OneToMany(mappedBy = "breeder", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<KoiFish> koiFishes;

}
