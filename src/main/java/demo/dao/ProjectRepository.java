package demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import demo.entity.Project;

@Component
public interface ProjectRepository extends CrudRepository<Project, Long> {

    Project findByName(String name);
    
    Iterable<Project> findByNameContaining(String q);

    Iterable<Project> findByOrgUnitId(Long valueOf);
    
    
}
