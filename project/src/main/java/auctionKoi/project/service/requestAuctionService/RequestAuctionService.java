package auctionKoi.project.service.requestAuctionService;

import auctionKoi.project.model.RequestAuction;
import auctionKoi.project.requestDTO.RequestDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface RequestAuctionService {

    public void createRequest(RequestDTO requestDTO, MultipartFile file) throws IOException;

    public void acceptRequest(Long id);

    public Optional<RequestAuction> getRequestAuction(Long id);

    public List<RequestAuction> getAllRequestAuctions();

    public void updateRequestAuction(Long id,String status);

    public Optional<List<RequestAuction>> getAllRequestAuctionsByStatus(String status);
}
