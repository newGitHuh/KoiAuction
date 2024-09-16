package auctionKoi.project.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Variety {
    @Id
    @Column(name = "variety_id", nullable = false)
    private String varietyId;

    @Column(name = "variety_name", nullable = false)
    private String varietyName;

    @Column(name = "isDeleted")
    private Boolean status;


    @OneToMany(mappedBy = "variety", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<KoiFish> koiFish;

}
