package auctionKoi.project.service.koiFishService;

import auctionKoi.project.model.KoiFish;
import auctionKoi.project.repository.KoiFishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KoiFishImp implements KoiFishService {

    private final KoiFishRepository koiFishRepository;

    @Override
    public void createKoiFish(KoiFish koiFish) {
        koiFishRepository.save(koiFish);
    }

    @Override
    public KoiFish getKoiFishInfo(Long fishId) {
        return koiFishRepository.findById(fishId).orElseThrow(()-> new RuntimeException("KoiFish not found"));
    }
}
