package auctionKoi.project.repository;

import auctionKoi.project.model.RequestAuction;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RequestAuctionRepository extends CrudRepository<RequestAuction, Long> {

    List<RequestAuction> findByStatusLike(String status);

}
