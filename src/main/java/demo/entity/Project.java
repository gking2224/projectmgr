package demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String status;
    @ManyToOne
    @JoinColumn(name="org_unit_id")
    private OrgUnit orgUnit;
    
    public Project() {
        super();
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Project [id=");
        builder.append(id);
        builder.append(", name=");
        builder.append(name);
        builder.append(", status=");
        builder.append(status);
        builder.append(", orgUnit=");
        builder.append(orgUnit);
        builder.append("]");
        return builder.toString();
    }

    public OrgUnit getOrgUnit() {
        return orgUnit;
    }
    
}