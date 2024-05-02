package main.DTO;

import java.util.List;

public class GenerateAccountDTO {
    
 private List<Integer> numbers;

    public List<Integer> getAccountNumberGenerated(){
        return this.numbers;
    }

    public void setAccountNumberToGenerate(List<Integer> accountNumber){
         this.numbers = accountNumber;
    }
}
