package demo.service;

import java.util.List;

import demo.entity.Budget;
import demo.vo.ResourceForecastVO;

public interface BudgetService {

    Iterable<Budget> findByProject(Long id);

    Budget getById(Long id);

    Budget create(Long projectId, String name);

    ResourceForecastVO addResource(
            Long budgetId, Long roleSubTypeId, Double fte);

    List<ResourceForecastVO> getForecasts(Long budgetId);

    void deleteResourceForecast(Long resourceId);

    void saveResourceForecast(ResourceForecastVO resourceForecast);

}
