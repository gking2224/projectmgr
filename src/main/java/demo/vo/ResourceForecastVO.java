package demo.vo;

import java.util.List;

import demo.entity.Forecast;
import demo.entity.Resource;
import demo.entity.RoleSubType;

public class ResourceForecastVO {

    private Long resourceId;
    private String roleType;
    private String roleSubType;
    private Double janFTE;
    private Double febFTE;
    private Double marFTE;
    private Double aprFTE;
    private Double mayFTE;
    private Double junFTE;
    private Double julFTE;
    private Double augFTE;
    private Double sepFTE;
    private Double octFTE;
    private Double novFTE;
    private Double decFTE;
    
    public ResourceForecastVO() {
        super();
    }
    public ResourceForecastVO(Resource r) {
        List<Forecast> forecast = r.getForecast();
        this.resourceId = r.getId();
        RoleSubType rst = r.getRoleSubType();
        this.roleType = rst.getRoleType().getName();
        this.roleSubType = rst.getName();
        this.janFTE = forecast.get(0).getFte();
        this.febFTE = forecast.get(1).getFte();
        this.marFTE = forecast.get(2).getFte();
        this.aprFTE = forecast.get(3).getFte();
        this.mayFTE = forecast.get(4).getFte();
        this.junFTE = forecast.get(5).getFte();
        this.julFTE = forecast.get(6).getFte();
        this.augFTE = forecast.get(7).getFte();
        this.sepFTE = forecast.get(8).getFte();
        this.octFTE = forecast.get(9).getFte();
        this.novFTE = forecast.get(10).getFte();
        this.decFTE = forecast.get(11).getFte();
    }
    
    public Long getResourceId() {
        return resourceId;
    }
    public void setResourceId(Long resourceId) {
        this.resourceId = resourceId;
    }
    public String getRoleType() {
        return roleType;
    }
    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
    public String getRoleSubType() {
        return roleSubType;
    }
    public void setRoleSubType(String roleSubType) {
        this.roleSubType = roleSubType;
    }
    public Double getJanFTE() {
        return janFTE;
    }
    public void setJanFTE(Double janFTE) {
        this.janFTE = janFTE;
    }
    public Double getFebFTE() {
        return febFTE;
    }
    public void setFebFTE(Double febFTE) {
        this.febFTE = febFTE;
    }
    public Double getMarFTE() {
        return marFTE;
    }
    public void setMarFTE(Double marFTE) {
        this.marFTE = marFTE;
    }
    public Double getAprFTE() {
        return aprFTE;
    }
    public void setAprFTE(Double aprFTE) {
        this.aprFTE = aprFTE;
    }
    public Double getMayFTE() {
        return mayFTE;
    }
    public void setMayFTE(Double mayFTE) {
        this.mayFTE = mayFTE;
    }
    public Double getJunFTE() {
        return junFTE;
    }
    public void setJunFTE(Double junFTE) {
        this.junFTE = junFTE;
    }
    public Double getJulFTE() {
        return julFTE;
    }
    public void setJulFTE(Double julFTE) {
        this.julFTE = julFTE;
    }
    public Double getAugFTE() {
        return augFTE;
    }
    public void setAugFTE(Double augFTE) {
        this.augFTE = augFTE;
    }
    public Double getSepFTE() {
        return sepFTE;
    }
    public void setSepFTE(Double sepFTE) {
        this.sepFTE = sepFTE;
    }
    public Double getOctFTE() {
        return octFTE;
    }
    public void setOctFTE(Double octFTE) {
        this.octFTE = octFTE;
    }
    public Double getNovFTE() {
        return novFTE;
    }
    public void setNovFTE(Double novFTE) {
        this.novFTE = novFTE;
    }
    public Double getDecFTE() {
        return decFTE;
    }
    public void setDecFTE(Double decFTE) {
        this.decFTE = decFTE;
    }
    
}
