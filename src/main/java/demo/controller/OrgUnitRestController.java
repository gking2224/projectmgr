package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.entity.OrgUnit;
import demo.service.OrgUnitService;

@RestController
@RequestMapping("/orgunit")
public class OrgUnitRestController {
    
    @Autowired
    private OrgUnitService service;
//    
//    @RequestMapping("/id/{id}")
//    public Project getById(
//            @PathVariable Long id) {
//        return service.getById(id);
//    }
    
    @RequestMapping("/name/{name}")
    public OrgUnit getByName(
            @PathVariable String name) {
        return service.getByName(name);
    }

    @RequestMapping("/list")
    public Iterable<OrgUnit> findAll() {
        return service.findAll();
    }
}
