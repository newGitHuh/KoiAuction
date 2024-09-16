package auctionKoi.project.requestDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AuctionSlotDto implements Serializable {
    private float startingPrice;

    private float endingPrice;

    private String bidderEmail;

    private String status;
}
