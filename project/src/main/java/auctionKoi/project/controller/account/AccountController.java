package auctionKoi.project.controller.account;


import auctionKoi.project.model.Account;
import auctionKoi.project.response.SingleResponseModel;
import auctionKoi.project.service.accountService.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;


    @PostMapping("/getAccountDetail/{email}")
    public SingleResponseModel<Account> getAccountDetail(@PathVariable("email") String email){
        Account account = accountService.getAccountByEmail(email);

        return new SingleResponseModel<>(HttpStatus.OK.value(), "Account with email {} found", account);
    }

    @PostMapping("/saveAccount")
    public SingleResponseModel<Account> saveAccount(@RequestBody Account account){
        accountService.saveAccount(account);

        return new SingleResponseModel<>(HttpStatus.OK.value(), "Account saved");
    }
}
