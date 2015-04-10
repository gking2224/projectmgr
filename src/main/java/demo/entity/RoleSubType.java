package demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="rolesubtype")
public class RoleSubType {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;
    
    @ManyToOne
    @JoinColumn(name="roletype_id")
    private RoleType roleType;
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public RoleSubType() {
        super();
    }
    public RoleType getRoleType() {
        return roleType;
    }
    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
    
}
