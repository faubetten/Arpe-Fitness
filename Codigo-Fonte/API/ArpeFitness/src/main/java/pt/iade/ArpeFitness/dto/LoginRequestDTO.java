package pt.iade.ArpeFitness.dto;

public class LoginRequestDTO {
    private String userName;
    private String userEmail;
    private String userPassword;

    // Getters e Setters
    public String getUserName (){
        return userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String UserEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

}
