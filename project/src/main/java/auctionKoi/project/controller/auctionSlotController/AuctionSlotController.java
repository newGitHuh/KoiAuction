package auctionKoi.project.controller.auctionSlotController;


import auctionKoi.project.model.AuctionSlot;
import auctionKoi.project.requestDTO.AuctionSlotDto;
import auctionKoi.project.response.SingleResponseModel;
import auctionKoi.project.service.auctionSlotService.AuctionSlotImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auctionslot")
public class AuctionSlotController {

    private final AuctionSlotImpl auctionSlotImpl;


    @PostMapping("/createSlots")
    public SingleResponseModel<String> createSlots(@RequestParam("FishId") Long id,
                                                   @RequestParam("AuctionId") int auctionId,
                                                   @RequestBody AuctionSlotDto auctionSlotDto) {

        auctionSlotImpl.createAuctionSlot(id,auctionId, auctionSlotDto);

        return new SingleResponseModel<>(HttpStatus.OK.value(), "list created");
    }

    @GetMapping(value = "/getinfo/{id}")

    public SingleResponseModel<AuctionSlot> getAuctionSlot(@PathVariable("id") int id) {

        AuctionSlot auctionSlot = auctionSlotImpl.getAuctionSlot(id);

        return new SingleResponseModel<>(HttpStatus.OK.value(), "get auction slot",auctionSlot);
    }


}
