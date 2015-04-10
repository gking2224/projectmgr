package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.dao.RoleSubTypeRepository;
import demo.dao.RoleTypeRepository;
import demo.entity.RoleSubType;
import demo.entity.RoleType;

@RestController
@RequestMapping("/api/staticdata")
public class StaticDataRestController {
    
    @Autowired
    private RoleTypeRepository roleTypeRepo;
    @Autowired
    private RoleSubTypeRepository roleSubTypeRepo;
    
    @RequestMapping(value="/roletypes", method=RequestMethod.GET)
    public Iterable<RoleType> getRoleTypes() {
        
        return roleTypeRepo.findAll();
    }
    
    @RequestMapping(value="/rolesubtypes/{roleTypeId}", method=RequestMethod.GET)
    public Iterable<RoleSubType> getRoleSubTypes(
            @PathVariable Long roleTypeId) {
        
        return roleSubTypeRepo.getByRoleTypeId(roleTypeId);
    }
}
