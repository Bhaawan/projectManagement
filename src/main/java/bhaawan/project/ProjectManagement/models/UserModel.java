package bhaawan.project.ProjectManagement.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserModel {

    @Id
    private long id;

    private String userName;
    private String email;
    private String password;
    private Boolean profileVerified;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getProfileVerified() {
        return profileVerified;
    }

    public void setProfileVerified(Boolean profileVerified) {
        this.profileVerified = profileVerified;
    }
}
