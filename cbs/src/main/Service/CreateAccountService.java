package main.Service;

import java.util.Optional;

public abstract class CreateAccountService {
    public abstract void createAccountDetails(CreateAccountDTO CreateAccountDTO);

    public abstract Optional<CreateAccountEntity> getByCifId(String cifId);

    public abstract Long getAccountBalanceValue(String accountNumber);
}
