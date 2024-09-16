package auctionKoi.project.controller.requestAuctionController;

import auctionKoi.project.model.RequestAuction;
import auctionKoi.project.requestDTO.RequestDTO;
import auctionKoi.project.response.SingleResponseModel;
import auctionKoi.project.service.requestAuctionService.RequestAuctionImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/auctionrequest")
@RequiredArgsConstructor
public class requestAuctionController {
    private final RequestAuctionImpl requestAuction;

    @PostMapping("/create")
    public SingleResponseModel<RequestAuction> createRequest(@RequestParam("File") MultipartFile file,
                                                             RequestDTO requestDto
                                                             ) throws IOException
    {


        requestAuction.createRequest(requestDto, file);

        return new SingleResponseModel<>(HttpStatus.OK.value(), "created");

    }

    @GetMapping("/accept/{id}")
    public SingleResponseModel<String> acceptRequest(@PathVariable Long id) {
        requestAuction.acceptRequest(id);

        return new SingleResponseModel<>(HttpStatus.OK.value(), "accepted");
    }

    @GetMapping("/list")
    public SingleResponseModel<List<RequestAuction>> getAllRequestAuction() {

        List<RequestAuction> list = requestAuction.getAllRequestAuctions();

        return new SingleResponseModel<>(HttpStatus.OK.value(), "Request auction list", list);

    }

    @GetMapping("/update/{id}")
    public SingleResponseModel<String> updateRequest(@PathVariable Long id, @RequestParam("status") String status) {
        requestAuction.updateRequestAuction(id, status);

        return new SingleResponseModel<>(HttpStatus.OK.value(), "accepted");
    }

    @GetMapping("/listwithstatus")
    public SingleResponseModel<List<RequestAuction>> getAllRequestAuctionByStatus(@RequestParam("status") String status) {

        List<RequestAuction> list = requestAuction.getAllRequestAuctionsByStatus(status).get();

        return new SingleResponseModel<>(HttpStatus.OK.value(), "Request auction list", list);

    }
}
