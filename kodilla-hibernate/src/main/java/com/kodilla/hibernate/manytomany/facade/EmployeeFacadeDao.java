package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface EmployeeFacadeDao extends CrudRepository<Employee, Integer> {

    @Query(nativeQuery = true)
    List<Employee> findByFragment(@Param("ARG") String employeeNameFragment);

}
