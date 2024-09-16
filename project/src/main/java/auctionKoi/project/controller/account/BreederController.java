package auctionKoi.project.controller.account;


import auctionKoi.project.model.Breeder;
import auctionKoi.project.response.SingleResponseModel;
import auctionKoi.project.service.accountService.BreederService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/breeder")
@RequiredArgsConstructor
public class BreederController {

    private final BreederService breederService;

    @GetMapping("/{id}")
    public SingleResponseModel<Breeder> getBreeder(@PathVariable("id") Long id) {

        return new SingleResponseModel<>(HttpStatus.OK.value(),"Breeder with id: " + id ,breederService.getBreeder(id));

    }

    @PostMapping("/create")
    public SingleResponseModel<Breeder> createBreeder(@RequestBody Breeder breeder) {
            breederService.saveBreeder(breeder);
        return new SingleResponseModel<>(HttpStatus.OK.value(), "breeder created");
    }
}
