package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.entity.Project;
import demo.service.ProjectService;

@RestController
@RequestMapping("/api/project")
public class ProjectRestController {
    
    @Autowired
    private ProjectService projectService;
    
    @RequestMapping("/search/{q}")
    public Iterable<Project> searchProjects(
            @PathVariable String q) {
        return projectService.searchByName(q);
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public Project getById(
            @PathVariable Long id) {
        return projectService.getById(id);
    }
    
    @RequestMapping(method=RequestMethod.GET)
    public Iterable<Project> findAll() {
        return projectService.findAll();
    }
    
    @RequestMapping(method=RequestMethod.POST)
    public Project save(@RequestBody Project project) {
        return projectService.save(project);
    }
}
