package demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Forecast {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Integer month;
    private Double fte;
//    @ManyToOne(optional=false)
//    @JoinColumn(name="projectbudgetresource_id")
//    private BudgetResource resource;
    
    public Forecast(Integer month, Double fte) {
        super();
        this.month = month;
        this.fte = fte;
    }

    public Forecast() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Double getFte() {
        return fte;
    }

    public void setFte(Double fte) {
        this.fte = fte;
    }

//    public BudgetResource getResource() {
//        return resource;
//    }
//
//    public void setResource(BudgetResource resource) {
//        this.resource = resource;
//    }
}
