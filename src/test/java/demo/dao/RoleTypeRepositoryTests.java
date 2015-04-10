package demo.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
import demo.entity.RoleType;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebAppConfiguration
@TestExecutionListeners({
    DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
    TransactionalTestExecutionListener.class,
    DbUnitTestExecutionListener.class})
@DatabaseSetup(value="dbUnit.xml", type=DatabaseOperation.INSERT)
public class RoleTypeRepositoryTests {
    
    @Autowired
    private RoleTypeRepository roleTypeRepo;
    
    @Test
    @Transactional
    public void testfindRoleById() {
        Long roleId = Long.valueOf(10001L);
        RoleType rt = roleTypeRepo.findOne(roleId);
        assertNotNull(rt);
        assertEquals(roleId, rt.getId());
        
        RoleType rt2 = new RoleType();
        rt2.setName("Test Transaction");
        roleTypeRepo.save(rt2);
    }
    
}
