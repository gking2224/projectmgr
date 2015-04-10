package demo.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;

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
import demo.entity.Project;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
@TestExecutionListeners({
    DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class,
    DbUnitTestExecutionListener.class})
@DatabaseSetup(value="dbUnit.xml", type=DatabaseOperation.INSERT)
public class ProjectTests {

    @Autowired
    private ProjectRepository projectRepo;
    
    @Test
    @Transactional
    public void testFindOne() {
        Long id = Long.valueOf(10001L);
        Project project = projectRepo.findOne(id);
        assertNotNull(project);
        assertEquals(id, project.getId());
    }
    
    @Test
    @Transactional
    public void findByNameContaining() {
        Iterable<Project> projects = projectRepo.findByNameContaining("Test Project 1");
        assertNotNull(projects);
        Iterator<Project> it = projects.iterator();
        assertTrue(it.hasNext());
        assertEquals("Test Project 1", it.next().getName());
        assertTrue(!it.hasNext());
    }
    
    @Test
    @Transactional
    public void findByOrgUnit() {
        Iterable<Project> projects = projectRepo.findByOrgUnitId(Long.valueOf(5L));
        assertNotNull(projects);
        assertTrue(projects.iterator().hasNext());
    }

}
