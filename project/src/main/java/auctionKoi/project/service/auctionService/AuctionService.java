package auctionKoi.project.service.auctionService;

import auctionKoi.project.model.Auction;

public interface AuctionService {

    public void createAuction(Auction auction);

    public Auction getAuction(int auctionId);
}
