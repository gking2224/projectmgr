package demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import demo.dao.BudgetRepository;
import demo.dao.ResourceRepository;
import demo.dao.RoleSubTypeRepository;
import demo.entity.Budget;
import demo.entity.Forecast;
import demo.entity.Project;
import demo.entity.Resource;
import demo.entity.RoleSubType;
import demo.service.BudgetService;
import demo.service.ProjectService;
import demo.vo.ResourceForecastVO;

@Component
public class BudgetServiceImpl implements BudgetService {
    
    private static Logger logger = Logger.getLogger(BudgetServiceImpl.class);
    
    @Autowired
    private BudgetRepository budgetRepo;
    @Autowired
    private RoleSubTypeRepository roleSubTypeRepo;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private ResourceRepository resourceRepo;
    @Autowired
    private EntityManager em;

    @Override
    public Iterable<Budget> findByProject(Long id) {
        return budgetRepo.findByProjectId(id);
    }

    @Override
    public Budget getById(Long id) {

        return budgetRepo.findOne(id);
    }

    @Override
    public Budget create(Long projectId, String name) {
        Project p = projectService.getById(projectId);
        Budget b = new Budget();
        b.setName(name);
        b.setBaselined(false);
        b.setProject(p);
        return budgetRepo.save(b);
    }

    @Override
    @Transactional
    public ResourceForecastVO addResource(
            Long budgetId, Long roleSubTypeId, Double fte) {
        Budget b = budgetRepo.findOne(budgetId);
        Resource resource = new Resource();
        RoleSubType rst = roleSubTypeRepo.findOne(roleSubTypeId);
        resource.setRoleSubType(rst);
        resource.setForecast(createFlatForecast(fte));
        b.getResources().add(resource);
        em.flush(); // flush to get the newly generated key
        return new ResourceForecastVO(resource);
    }

    private List<Forecast> createFlatForecast(Double fte) {
        List<Forecast> forecast = new ArrayList<Forecast>(12);
        for (int i = 1; i <= 12; i++)
            forecast.add(new Forecast(Integer.valueOf(i), fte));
        return forecast;
    }

    @Override
    public List<ResourceForecastVO> getForecasts(Long budgetId) {
        Budget budget = budgetRepo.findOne(budgetId);
        List<Resource> resources = budget.getResources();
        logger.error("Got "+resources.size()+" resources");
        List<ResourceForecastVO> rv = new ArrayList<ResourceForecastVO>(
                resources.size());
        for (Resource resource : resources) {
            rv.add(new ResourceForecastVO(resource));
        }
        return rv;
    }

    @Override
    public void deleteResourceForecast(Long resourceId) {
        resourceRepo.delete(resourceId);
    }

    @Override
    @Transactional
    public void saveResourceForecast(ResourceForecastVO resourceForecast) {
        Resource resource = resourceRepo.findOne(resourceForecast.getResourceId());
        List<Forecast> forecast = resource.getForecast();
        forecast.get(0).setFte(resourceForecast.getJanFTE());
        forecast.get(1).setFte(resourceForecast.getFebFTE());
        forecast.get(2).setFte(resourceForecast.getMarFTE());
        forecast.get(3).setFte(resourceForecast.getAprFTE());
        forecast.get(4).setFte(resourceForecast.getMayFTE());
        forecast.get(5).setFte(resourceForecast.getJunFTE());
        forecast.get(6).setFte(resourceForecast.getJulFTE());
        forecast.get(7).setFte(resourceForecast.getAugFTE());
        forecast.get(8).setFte(resourceForecast.getSepFTE());
        forecast.get(9).setFte(resourceForecast.getOctFTE());
        forecast.get(10).setFte(resourceForecast.getNovFTE());
        forecast.get(11).setFte(resourceForecast.getDecFTE());
    }
}
