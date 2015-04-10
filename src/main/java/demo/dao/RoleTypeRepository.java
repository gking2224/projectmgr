package demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import demo.entity.RoleType;

@Component
public interface RoleTypeRepository extends CrudRepository<RoleType, Long> {}
