package demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import demo.entity.Budget;

@Component
public interface BudgetRepository extends CrudRepository<Budget, Long> {
    Iterable<Budget> findByProjectId(Long id);
}
