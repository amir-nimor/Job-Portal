package ir.maktabsharif.model;

import ir.maktabsharif.model.Enums.AdStatus;
import ir.maktabsharif.model.Enums.PositionType;
import ir.maktabsharif.model.baseMode.BaseMode;
import jakarta.persistence.*;
import org.hibernate.annotations.Check;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companys")
public class Company extends BaseMode<Integer> {

    private String name;

    @Lob
    private String description;

    @Enumerated
    private Address address;

    private String site;

    private String phoneNumber;

    @OneToMany
    private List<JobPosition> jobPositions;


    private String username;

    private String password;

    public Company(String name, String description, Address address, String site, String phoneNumber) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.site = site;
        this.phoneNumber = phoneNumber;
        this.jobPositions = new ArrayList<>();
    }

    public Company() {

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<JobPosition> getJobPositions() {
        return jobPositions;
    }

    public void setJobPositions(List<JobPosition> jobPositions) {
        this.jobPositions = jobPositions;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", address=" + address +
                ", site='" + site + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
