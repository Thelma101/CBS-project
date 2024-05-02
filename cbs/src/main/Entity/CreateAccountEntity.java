package main.Entity;

public class CreateAccountEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)

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

    private Long accountBalance;
    private String accountNumber;
    private String cifId;

//    public void setAccountDTO(AccountDTO accountDTO){
//        this.accountDTO = accountDTO;
//    }
//
//    public AccountDTO getAccountDTO(){
//        return  this.accountDTO;
//    }

    // Setter and Getter for id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Setter and Getter for bvn
    public String getBvn() {
        return bvn;
    }

    public void setBvn(String bvn) {
        this.bvn = bvn;
    }

    // Setter and Getter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Setter and Getter for firstName
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Setter and Getter for middleName
    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    // Setter and Getter for lastName
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Setter and Getter for dob
    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    // Setter and Getter for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Setter and Getter for phoneNumber
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Setter and Getter for address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Setter and Getter for occupation
    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    // Setter and Getter for gender
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // Setter and Getter for maritalStatus
    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    // Setter and Getter for countryOfResidence
    public String getCountryOfResidence() {
        return countryOfResidence;
    }

    public void setCountryOfResidence(String countryOfResidence) {
        this.countryOfResidence = countryOfResidence;
    }

    public Long getAccountBalance(){return  this.accountBalance;}
    public void setAccountBalance(Long accBalance){
        this.accountBalance = accBalance;
    }


    public String getAccountNumber(){
        return this.accountNumber;
    }
    public void setAccountNumber(String accNum){
        this.accountNumber = accNum;
    }

    public void setCifId(String cifId){
        this.cifId = cifId;
    }

    public String getCifId(){
        return this.cifId;
    }


}
