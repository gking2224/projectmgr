package demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import demo.entity.Resource;

@Component
public interface ResourceRepository extends CrudRepository<Resource, Long> {

}
