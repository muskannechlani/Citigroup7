package stock;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name = "username")
    private String userName;
    @Column (name = "password")
    private String passWord;
    @Column(name = "email")
    private String email="";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String firstName) {
        this.userName = firstName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String lastName) {
        this.passWord = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email+userName+passWord;
    }
}
