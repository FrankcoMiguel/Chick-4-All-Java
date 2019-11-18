package Model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "USER")
@NamedQuery(name = "Users.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "UserId")
    private long UserId;

    @Column(name = "Phone", unique = true)
    private String Phone;

    @Column(name = "Username", unique = true)
    private String Username;

    @Column(name = "Password")
    private String Password;

    public User() { }

    public User(String phone, String username, String password) {
        Phone = phone;
        Username = username;
        Password = password;
    }

    public long getUserId() {
        return UserId;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return UserId == user.UserId &&
                Objects.equals(Phone, user.Phone) &&
                Objects.equals(Username, user.Username) &&
                Objects.equals(Password, user.Password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(UserId, Phone, Username, Password);
    }

    @Override
    public String toString() {
        return "User {" +
                "UserId=" + UserId +
                ", Phone='" + Phone + '\'' +
                ", Username='" + Username + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
