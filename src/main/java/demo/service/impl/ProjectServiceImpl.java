package demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.dao.ProjectRepository;
import demo.entity.Project;
import demo.service.ProjectService;

@Component
public class ProjectServiceImpl implements ProjectService {
    
    @Autowired
    private ProjectRepository repository;
    
    @Override
    public Iterable<Project> searchByName(String searchString) {
        return repository.findByNameContaining(searchString);
    }

    @Override
    public Project getById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Project save(Project project) {
        return repository.save(project);
    }

    @Override
    public Iterable<Project> findAll() {
        return repository.findAll();
    }
}
