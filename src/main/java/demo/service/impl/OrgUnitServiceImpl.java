package demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import demo.dao.OrgUnitRepository;
import demo.entity.OrgUnit;
import demo.service.OrgUnitService;

@Component
public class OrgUnitServiceImpl implements OrgUnitService {
    
    @Autowired
    private OrgUnitRepository repository;

    @Override
    public OrgUnit getById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public OrgUnit getByName(String name) {
        try {
            return repository.findByName(name);
        } catch (Throwable e) {
            System.err.print(e);
            throw e;
        }
    }

    @Override
    public Iterable<OrgUnit> findAll() {
        return repository.findAll();
    }
}
