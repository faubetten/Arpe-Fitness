package pt.iade.ArpeFitness.models.tables;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;




@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int user_id;
    
    @Column(name = "user_name",nullable = false)
    private String user_name;
    
    @Column(name = "user_password")
    private String user_password;
    
    @Column(nullable = false, name = "user_bdate")
    private Date user_bdate;
    
    @Column(nullable = false, name = "user_gender")
    private char user_gender;
    
    @Column( name = "user_email")
    private String user_email;

    public User() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public Date getUser_bdate() {
        return user_bdate;
    }

    public void setUser_bdate(Date user_bdate) {
        this.user_bdate = user_bdate;
    }

    public char getUser_gender() {
        return user_gender;
    }

    public void setUser_gender(char user_gender) {
        this.user_gender = user_gender;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }

}    
