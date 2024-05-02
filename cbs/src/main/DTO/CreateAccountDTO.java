package main.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Setter @Getter
@Data


public class CreateAccountDTO {
    private Long id;
    private String bvn;
    private String title;
    private String firstName;
    private String middleName;
    private String lastName;
    private String dob;
    private String email;
    private String phoneNumber;
    private String address;
    private String occupation;
    private String gender;
    private String maritalStatus;
    private String countryOfResidence;
}
