package auctionKoi.project.service.auctionSlotService;

import auctionKoi.project.model.Auction;
import auctionKoi.project.model.AuctionSlot;
import auctionKoi.project.model.KoiFish;
import auctionKoi.project.repository.AuctionSlotRepository;
import auctionKoi.project.repository.KoiFishRepository;
import auctionKoi.project.requestDTO.AuctionSlotDto;
import auctionKoi.project.service.auctionService.AuctionService;
import auctionKoi.project.service.auctionService.AuctionServiceImpl;
import auctionKoi.project.service.koiFishService.KoiFishImp;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuctionSlotImpl implements AuctionSlotInterface {

    private final AuctionSlotRepository auctionSlotRepository;
    private final KoiFishImp koiFishImp;
    private final AuctionServiceImpl auctionService;
    private final KoiFishRepository koiFishRepository;

    @Override
    public void createListAuctionSlot(List<AuctionSlot> auctionList) {
        auctionSlotRepository.saveAll(auctionList);
    }

    @Override
    public void createAuctionSlot(Long fishId, int auctionId, AuctionSlotDto auctionSlotDto) {

        KoiFish koiFish =  koiFishImp.getKoiFishInfo(fishId);
        Auction auction = auctionService.getAuction(auctionId);

        AuctionSlot auctionSlot = AuctionSlot.builder()
                .auction(auction)
                .koiFish(koiFish)
                .bidderEmail(auctionSlotDto.getBidderEmail())
                .startingPrice(koiFish.getPrice())
                .endingPrice(auctionSlotDto.getEndingPrice())
                .status(auction.getStatus())
                .build();

        auctionSlotRepository.save(auctionSlot);
        koiFish.setAuctionSlot(auctionSlot);
        koiFishRepository.save(koiFish);
    }

    @Override
    public AuctionSlot getAuctionSlot(int id) {

        return auctionSlotRepository.findById(id).get();
    }
}
