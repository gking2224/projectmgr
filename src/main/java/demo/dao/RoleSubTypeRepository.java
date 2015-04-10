package demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import demo.entity.RoleSubType;

@Component
public interface RoleSubTypeRepository extends CrudRepository<RoleSubType, Long> {

    Iterable<RoleSubType> getByRoleTypeId(Long roleTypeId);
    
}
