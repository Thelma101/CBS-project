package main.DTO;

public class HttpResponseDTO {
    private String message;
    public void setResponseMessage(String message){
        this.message = message;
    }

    public String getResponseMessage(){
        return this.message;
    }
}
