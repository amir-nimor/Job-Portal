package ir.maktabsharif.model;

import ir.maktabsharif.model.Enums.AdStatus;
import ir.maktabsharif.model.Enums.PositionType;
import ir.maktabsharif.model.baseMode.BaseMode;
import jakarta.persistence.*;
import org.hibernate.annotations.Check;

@Entity
@Table(name = "job_positions")
public class JobPosition extends BaseMode<Long> {

    private String title;

    @Lob
    private String description;


    @ManyToOne
    private Company company;


    @Enumerated(EnumType.STRING)
    private PositionType positionType;


    @Column(name = "Minimum_Salary")
    @Check(constraints = "MinimumSalary > 0")
    private Double MinimumSalary;


    @Column(name = "maximum_Salary")
    @Check(constraints = "maximumSalary > 0")
    private Double maximumSalary;


    @Enumerated(EnumType.STRING)
    private AdStatus adStatus;

    public JobPosition(String title, String description, Company company, PositionType positionType, Double minimumSalary, Double maximumSalary) {
        this.title = title;
        this.description = description;
        this.company = company;
        this.positionType = positionType;
        MinimumSalary = minimumSalary;
        this.maximumSalary = maximumSalary;
        this.adStatus = AdStatus.OPEN;
    }


    public JobPosition() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public Double getMinimumSalary() {
        return MinimumSalary;
    }

    public void setMinimumSalary(Double minimumSalary) {
        MinimumSalary = minimumSalary;
    }

    public Double getMaximumSalary() {
        return maximumSalary;
    }

    public void setMaximumSalary(Double maximumSalary) {
        this.maximumSalary = maximumSalary;
    }

    public AdStatus getAdStatus() {
        return adStatus;
    }

    public void setAdStatus(AdStatus adStatus) {
        this.adStatus = adStatus;
    }

    @Override
    public String toString() {
        return "JobPosition{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", company=" + company +
                ", positionType=" + positionType +
                ", MinimumSalary=" + MinimumSalary +
                ", maximumSalary=" + maximumSalary +
                ", adStatus=" + adStatus +
                '}';
    }
}
