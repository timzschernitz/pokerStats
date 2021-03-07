package edu.matc.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 *
 * @author tzschernitz
 */
@Entity(name = "User")
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_name")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private String userName;

    @Column(name = "first_name")
    private String firstName;

    @Column (name = "last_name")
    private String lastName;

    private String location;

    private int admin;

    private String league;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Game> games = new HashSet<>();


    public User() {
    }

    public User(String userName, String firstName, String lastName, String location, int admin, String league) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
        this.admin = admin;
        this.league = league;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int isAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", location='" + location + '\'' +
                ", admin=" + admin +
                ", league='" + league + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userName == user.userName &&
                admin == user.admin &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(location, user.location) &&
                Objects.equals(league, user.league);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, firstName, lastName, location, admin, league);
    }
}
