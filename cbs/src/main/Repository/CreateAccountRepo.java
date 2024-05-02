package main.Repository;


import CBS_Technical_Assessment.CBS_Technical_Assessment.Entity.CreateAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CreateAccountRepo extends JpaRepository<CreateAccountEntity, Long> {

  Optional<CreateAccountEntity> findByCifId(String cifId);

  //@Query("SELECT a.accountNumber FROM CreateAccountEntity a") //where a stands for the first letter in CreateAccountEntity
  CreateAccountEntity findByAccountNumber(String accountNumber);

}
