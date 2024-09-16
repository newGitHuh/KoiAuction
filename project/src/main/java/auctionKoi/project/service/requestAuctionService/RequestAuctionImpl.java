package auctionKoi.project.service.requestAuctionService;

import auctionKoi.project.model.Breeder;
import auctionKoi.project.model.KoiFish;
import auctionKoi.project.model.RequestAuction;
import auctionKoi.project.repository.RequestAuctionRepository;
import auctionKoi.project.requestDTO.RequestDTO;
import auctionKoi.project.service.accountService.BreederServiceImp;
import auctionKoi.project.service.koiFishService.KoiFishImp;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RequestAuctionImpl implements RequestAuctionService {

    private final RequestAuctionRepository auctionRepository;
    private final KoiFishImp koiFishService;
    private final BreederServiceImp breederService;


    @Override
    public void createRequest(RequestDTO requestDTO, MultipartFile file) throws IOException {

        Breeder breeder = breederService.getBreeder(requestDTO.getBreederId());
        KoiFish koiFish = KoiFish.builder()
                .breeder(breeder)
                .gender("male")
                .age(2)
                .size(30)
                .image(file.getBytes())
                .status("waiting")
                .build();

        koiFishService.createKoiFish(koiFish);

        RequestAuction requestAuction = RequestAuction.builder()
                .auctionType("1")
                .koiFish(koiFish)
                .status("pending")
                .breeder(breeder)
                .build();

        auctionRepository.save(requestAuction);
    }


    @Override
    public Optional<RequestAuction> getRequestAuction(Long id) {
        return auctionRepository.findById(id);
    }

    @Override
    public List<RequestAuction> getAllRequestAuctions() {
        return (List<RequestAuction>) auctionRepository.findAll();
    }


    @Override
    public void acceptRequest(Long id) {
        RequestAuction requestAuction = auctionRepository.findById(id).orElse(null);
        if (requestAuction != null && !requestAuction.getStatus().equals("accepted")) {


            KoiFish koiFish = KoiFish.builder()
//                    .age(requestAuction.getAge())
//                    .size(requestAuction.getSize())
//                    .gender(requestAuction.getGender())
//                    .price(requestAuction.getPrice())
//                    .image(requestAuction.getImage())
                    .status("auctioning")
                    .breeder(requestAuction.getBreeder())
                    .build();

            requestAuction.setStatus("accepted");
            auctionRepository.save(requestAuction);
            koiFishService.createKoiFish(koiFish);
        } else {
            throw new EntityNotFoundException("RequestAuction not found or already accepted");
        }
    }

    @Override
    public void updateRequestAuction(Long id,String status) {
        RequestAuction auction = auctionRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("RequestAuction not found"));
        auction.setStatus(status);
        auctionRepository.save(auction);
    }

    @Override
    public Optional<List<RequestAuction>> getAllRequestAuctionsByStatus(String status) {
        return Optional.ofNullable(auctionRepository.findByStatusLike(status));
    }


}
