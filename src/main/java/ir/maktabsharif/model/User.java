package ir.maktabsharif.model;

import ir.maktabsharif.model.Enums.Rols;
import ir.maktabsharif.model.baseMode.BaseMode;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User extends BaseMode<Integer> {

    @Column(name = "Full_name")
    private String fullName;

    private String phoneNumber;

    @Embedded
    private Address address;

    @Lob
    private String description;

    private int monthWork;

    private String resume;

    @Enumerated(EnumType.STRING)
    private Rols rols;


    private String username;

    private String password;

    public User(String fullName, String phoneNumber, Address address, String description, int monthWork, String resume  ) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.description = description;
        this.monthWork = monthWork;
        this.resume = resume;
        this.rols = rols;
    }

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rols getRols() {
        return rols;
    }

    public void setRols(Rols rols) {
        this.rols = rols;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMonthWork() {
        return monthWork;
    }

    public void setMonthWork(int monthWork) {
        this.monthWork = monthWork;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    @Override
    public String toString() {
        return "User{" +
                "fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address=" + address +
                ", description='" + description + '\'' +
                ", monthWork=" + monthWork +
                ", resume='" + resume + '\'' +
                '}';
    }
}
