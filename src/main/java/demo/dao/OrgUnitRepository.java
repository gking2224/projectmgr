package demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import demo.entity.OrgUnit;

@Component
public interface OrgUnitRepository extends CrudRepository<OrgUnit, Long> {

    OrgUnit findByName(String name);
}
