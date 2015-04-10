package demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.entity.Budget;
import demo.service.BudgetService;
import demo.vo.ResourceForecastVO;

@RestController
@RequestMapping("/api/budget")
public class BudgetRestController {
    
    @Autowired
    private BudgetService budgetService;
    
    @RequestMapping("/byproject/{id}")
    public Iterable<Budget> findByProject(
            @PathVariable Long id) {
        return budgetService.findByProject(id);
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Budget getById(
            @PathVariable Long id) {
        return budgetService.getById(id);
    }

    @RequestMapping(value="/create/{projectId}/{name}",
            method=RequestMethod.POST)
    public Budget create(@PathVariable Long projectId,
            @PathVariable String name) {
        return budgetService.create(projectId, name);
    }

    @RequestMapping(value="/createresource/{budgetId}/{roleSubTypeId}/{fte}",
            method=RequestMethod.POST)
    public ResourceForecastVO create(
            @PathVariable Long budgetId, @PathVariable Long roleSubTypeId,
            @PathVariable Double fte) {
        return budgetService.addResource(budgetId, roleSubTypeId, fte);
    }
    
    @RequestMapping(value="/forecast/{budgetId}", method=RequestMethod.GET)
    public List<ResourceForecastVO> getForecasts(
            @PathVariable Long budgetId) {
        return budgetService.getForecasts(budgetId);
    }
    
    @RequestMapping(value="/resource/{resourceId}", method=RequestMethod.DELETE)
    public void removeResource(
            @PathVariable Long resourceId) {
        budgetService.deleteResourceForecast(resourceId);
    }
    
    @RequestMapping(value="/resource", method=RequestMethod.POST)
    public void saveResource(
            @RequestBody ResourceForecastVO resourceForecast) {
        budgetService.saveResourceForecast(resourceForecast);
    }
}
