package auctionKoi.project.service.auctionService;

import auctionKoi.project.model.Auction;
import auctionKoi.project.repository.AuctionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuctionServiceImpl implements AuctionService{

    private final AuctionRepository auctionRepository;

    @Override
    public void createAuction(Auction auction) {
        auctionRepository.save(auction);
    }

    @Override
    public Auction getAuction(int auctionId) {
        return auctionRepository.findById(auctionId).get();
    }


}
