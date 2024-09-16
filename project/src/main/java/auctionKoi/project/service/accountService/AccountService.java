package auctionKoi.project.service.accountService;

import auctionKoi.project.model.Account;
import auctionKoi.project.repository.AccountRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService implements AccountServiceInterface{
    private final AccountRepository accountRepository;

    @Override
    public Account getAccountByEmail(String email){
        return accountRepository.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("Account not found"));
    }

    @Override
    public void saveAccount(Account account) {
        accountRepository.save(account);
    }


}
