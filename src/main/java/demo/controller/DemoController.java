package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.dao.DataAccessObject;
import demo.dao.ProjectRepository;
import demo.entity.Project;

@Controller
public class DemoController {

    @Autowired
    private DataAccessObject dao;
    @Autowired
    private ProjectRepository projectDao;
    
    @RequestMapping("/")
    @ResponseBody
    String home() {
        Project projects = projectDao.findByName("Project 1");
        System.out.println("Found: "+projects);
        return "Hello World!";
    }
}
