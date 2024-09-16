package auctionKoi.project.model;

import jakarta.persistence.Table;
import lombok.*;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {
    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "display_name")
    private String display_name;

    @Column(name = "password")
    private String password;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "role")
    private String role;

    @Column(name = "isDelete")
    private boolean status;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Bid bid;

}
