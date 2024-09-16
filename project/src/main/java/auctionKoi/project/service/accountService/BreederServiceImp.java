package auctionKoi.project.service.accountService;

import auctionKoi.project.model.Breeder;
import auctionKoi.project.repository.BreederRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BreederServiceImp implements BreederService {

    private final BreederRepository breederRepository;

    @Override
    public Breeder getBreeder(long id) {
        return breederRepository.findById(id).orElse(null);
    }

    @Override
    public Breeder saveBreeder(Breeder breeder) {
        return breederRepository.save(breeder);
    }
}
