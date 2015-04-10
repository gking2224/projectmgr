package demo.service;

import demo.entity.Project;

public interface ProjectService {
    
    Iterable<Project> searchByName(String searchString);
    
    Project getById(Long id);
    
    Project save(Project project);

    Iterable<Project> findAll();
}
