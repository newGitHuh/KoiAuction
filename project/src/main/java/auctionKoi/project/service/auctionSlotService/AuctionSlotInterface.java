package auctionKoi.project.service.auctionSlotService;

import auctionKoi.project.model.AuctionSlot;
import auctionKoi.project.requestDTO.AuctionSlotDto;

import java.util.List;

public interface AuctionSlotInterface {

    public void createListAuctionSlot(List<AuctionSlot> auctionSlots);

    public void createAuctionSlot(Long fishId, int auctionId, AuctionSlotDto auctionSlotDto);


    public AuctionSlot getAuctionSlot(int id);
}
