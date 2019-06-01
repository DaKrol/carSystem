package project.springmvc.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class User {

    @Id
    private UUID id;
    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private UUID clientID;
    private UUID mechanicId;


    public User() {
    this.id= UUID.randomUUID();
    }

    public User(UUID id, String login, String password, String firstName, String lastName, UUID clientID, UUID mechanicId) {
        this.id=UUID.randomUUID();
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.clientID = clientID;
        this.mechanicId = mechanicId;
    }

    public User(String s) {
        this.login=s;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UUID getClientID() {
        return clientID;
    }

    public void setClientID(UUID clientID) {
        this.clientID = clientID;
    }

    public UUID getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(UUID mechanicId) {
        this.mechanicId = mechanicId;
    }
}
