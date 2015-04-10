package demo.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "orgunit")
public class OrgUnit {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @NotNull
    private String name;
    @NotNull
    private String lead;
//    @ManyToOne(optional=true, fetch=FetchType.LAZY)
//    @JoinColumn(name="parent_id")
//    private OrgUnit parent;
    @OneToMany(fetch=FetchType.LAZY)
    @JoinColumn(name="parent_id")
    private Set<OrgUnit> children;
    
    public OrgUnit() {
        super();
    }
    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getLead() {
        return lead;
    }
//    public OrgUnit getParent() {
//        return parent;
//    }
    public Set<OrgUnit> getChildren() {
        return children;
    }
}
