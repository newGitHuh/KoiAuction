package auctionKoi.project.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestDTO implements Serializable {
    private int breederId;
    private String variety;
    private String gender;
    private int age;
    private float size;
    private float price;
}
