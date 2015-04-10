package demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name="resource")
public class Resource {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="projectbudgetresource_id", nullable=false)
    @OrderBy("month asc")
    private List<Forecast> forecast;
    
    @ManyToOne
    @JoinColumn(name="rolesubtype_id")
    private RoleSubType roleSubType;
    
    public Resource() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }

    public RoleSubType getRoleSubType() {
        return roleSubType;
    }

    public void setRoleSubType(RoleSubType roleSubType) {
        this.roleSubType = roleSubType;
    }
}
