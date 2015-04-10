package demo.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;

import demo.DemoApplication;
import demo.entity.Budget;
import demo.entity.Forecast;
import demo.entity.Project;
import demo.entity.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
@TestExecutionListeners({
    DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class,
    DbUnitTestExecutionListener.class})
@DatabaseSetup(value="dbUnit.xml", type=DatabaseOperation.INSERT)
public class BudgetTests {

    @Autowired
    private BudgetRepository budgetRepository;
    
    @Test
    @Transactional
    public void loadBudget() {
        Long projectId = Long.valueOf(10001L);
        Iterable<Budget> budgets = budgetRepository.findByProjectId(projectId);
        assertNotNull(budgets);
        Iterator<Budget> iterator = budgets.iterator();
        assertTrue(iterator.hasNext());
        
        Budget budget = iterator.next();
        Project project = budget.getProject();
        assertNotNull(project);
        assertEquals(projectId, project.getId());
        
        List<Resource> resources = budget.getResources();
        assertNotNull(resources);
        assertEquals(2, resources.size());
        
        Resource resource = resources.iterator().next();
        assertNotNull(resource);
        
        List<Forecast> forecast = resource.getForecast();
        assertNotNull(forecast);
        assertEquals(12, forecast.size());
    }

}
