package main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import main.service.AccountService;
import main.dto.AccountDTO;
import main.dto.HttpResponseDTO;
import main.entity.AccountEntity;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/v1/api/account")
public class CreateAccountController {

    @Autowired
    private AccountService accountService;

    /**
     * Create a new customer account.
     * 
     * @param accountDTO - Data Transfer Object containing account information.
     * @return HttpResponseDTO - Standardized response with success message.
     */
    @PostMapping("/create-account-details")
    public HttpResponseDTO createAccount(@RequestBody CreateAccountDTO accountDTO) {
        accountService.createAccountDetails(accountDTO);

        HttpResponseDTO response = new HttpResponseDTO();
        response.setResponseMessage("Your account has been created successfully!");
        return response;
    }

    /**
     * Retrieve customer account details by CIF ID.
     * 
     * @param cifId - Customer Identification File ID.
     * @return ResponseEntity with account details or an error message.
     */
    @GetMapping("/fetch-account-profile/{cifId}")
    public ResponseEntity<Map<String, Object>> getAccountByCifId(@PathVariable String cifId) {
        if (cifId == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "cifId cannot be null");
        }

        Optional<AccountEntity> accountEntity = accountService.getByCifId(cifId);

        if (accountEntity.isPresent()) {
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("message", "Your account details have been retrieved successfully.");
            responseBody.put("details", accountEntity.get());
            return ResponseEntity.ok(responseBody);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Account with the specified cifId not found.");
        }
    }

    /**
     * Get customer account balance by account number.
     * 
     * @param accountNumber - The account number to fetch the balance for.
     * @return ResponseEntity with account balance or an error message.
     */
    @GetMapping("/fetch-account-balance")
    public ResponseEntity<Map<String, Object>> getCustomerAccountBalance(@RequestParam("accountNumber") String accountNumber) {
        if (accountNumber == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Account number cannot be null.");
        }

        Long accountBalance = accountService.getAccountBalanceValue(accountNumber);

        if (accountBalance != null) {
            Map<String, Object> responseBody = new HashMap<>();
            responseBody.put("message", "Your account balance has been retrieved successfully.");
            responseBody.put("accountBalance", accountBalance);
            return ResponseEntity.ok(responseBody);
        } else {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("message", "Account not found for the provided account number.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        }
    }
}
