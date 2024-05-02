package main.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service()
public class CreateAccountImplementation extends CreateAccountService{

    @Autowired()
    private CreateAccountRepo CreateAccountRepo;

    private ModelMapper modelMapper;
    @Autowired()
    public void CreateAccountService(ModelMapper modelMapper){ this.modelMapper = modelMapper;}

    private CreateAccountDTO convertToDTO(CreateAccountEntity account){
        return modelMapper.map(account, CreateAccountDTO.class, "account creation");
    }


//    private CreateAccountEntity convertToEntity(CreateAccountDTO CreateAccountDTO){
//        return modelMapper.map(CreateAccountDTO, CreateAccountEntity.class);
//    }
private CreateAccountEntity convertToEntity(CreateAccountDTO CreateAccountDTO, String accountNumber, String cifId){
   // Append the cifId and AccountNumber with the CreateAccountDTO before submitting to the CreateAccountEntity
        CreateAccountEntity CreateAccountEntity = new CreateAccountEntity();
        // copy the properties from the dto to the entity
    BeanUtils.copyProperties(CreateAccountDTO, CreateAccountEntity);
        CreateAccountEntity.setAccountNumber(accountNumber);
        CreateAccountEntity.setCifId(cifId);
        return CreateAccountEntity;
}

    @Override
    public void createAccountDetails(CreateAccountDTO CreateAccountDTO){

        //step1: Generate account number
        AccountNumberGenerationDTO accountGenerationDTO = new AccountNumberGenerationDTO();
        List<Integer> accountNumber = new ArrayList<>();
        Random random = new Random();
        for(int i=0; i<10; i++){
           int randomNumbers = random.nextInt(10);
            accountNumber.add(randomNumbers);
        }

        //convert accountNumber to a string
        List<List<Integer>> accNum = Arrays.asList(accountNumber);
        String AcctNumberArray = accNum.stream().map(Object::toString).collect(Collectors.joining());
        String requiredAcctNum = AcctNumberArray.replaceAll("[^0-9]", "");

        // Generate a unique 4-digit cifId attached to the account number
        Set<Integer> generatedCIFID = new HashSet<>();
        Random randomNumbers = new Random();
        while (generatedCIFID.isEmpty()){
            int randomcifId = randomNumbers.nextInt(9000) + 1000;
            generatedCIFID.add(randomcifId);
        }
        String requiredCifId = generatedCIFID.toString().replaceAll("[\\[\\]]", "");
      // System.out.println("unique cifId>>> " + requiredCifId);

       // Call the convertToEntity
        CreateAccountEntity accountVal = convertToEntity(CreateAccountDTO, requiredAcctNum, requiredCifId);
        CreateAccountEntity savedAccountData = CreateAccountRepo.save(accountVal);
        convertToDTO(savedAccountData);
    }

    @Override
    public Optional<CreateAccountEntity> getByCifId(String cifId){
//        Optional<CreateAccountEntity> CreateAccountEntityOptional = CreateAccountRepo.findByCifId(cifId);
//        return CreateAccountEntityOptional.map(this::convertToDTO).orElse(null);
        return CreateAccountRepo.findByCifId(cifId);
    }

    @Override
    public Long getAccountBalanceValue(String accountNumber){
        CreateAccountEntity CreateAccountEntity = CreateAccountRepo.findByAccountNumber(accountNumber);
        if(CreateAccountEntity != null){
            return CreateAccountEntity.getAccountBalance();
        }else{
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Account cannot be null");
        }
    }


}
