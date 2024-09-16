package auctionKoi.project.service.koiFishService;

import auctionKoi.project.model.KoiFish;

import java.util.Optional;

public interface KoiFishService {
    public void createKoiFish(KoiFish koiFish);

    public KoiFish getKoiFishInfo(Long fishId);
}
