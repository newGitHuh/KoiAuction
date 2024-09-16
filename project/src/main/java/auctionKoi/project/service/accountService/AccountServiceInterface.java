package auctionKoi.project.service.accountService;

import auctionKoi.project.model.Account;

public interface AccountServiceInterface {
    public Account getAccountByEmail(String email);

    public void saveAccount(Account account);
}
