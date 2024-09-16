package auctionKoi.project.controller.auctionController;


import auctionKoi.project.model.Auction;
import auctionKoi.project.response.SingleResponseModel;
import auctionKoi.project.service.auctionService.AuctionService;
import auctionKoi.project.service.auctionService.AuctionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auction")
public class AuctionController {

    private final AuctionServiceImpl auctionService;

    @PostMapping("/create")
    public SingleResponseModel<String> createAuction(@RequestBody Auction auction) {

        auctionService.createAuction(auction);

        return new SingleResponseModel<>(HttpStatus.OK.value(), "Auction created");
    }

    @GetMapping("/getinfo/{id}")
    public SingleResponseModel<Auction> getAuctionById(@PathVariable("id") int auctionId) {

        Auction auction = auctionService.getAuction(auctionId);

        return new SingleResponseModel<>(HttpStatus.OK.value(), "Auction found",auction);
    }
}
