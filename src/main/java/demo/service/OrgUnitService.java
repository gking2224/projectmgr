package demo.service;

import demo.entity.OrgUnit;

public interface OrgUnitService {
    
    OrgUnit getById(Long id);

    OrgUnit getByName(String name);

    Iterable<OrgUnit> findAll();
}
