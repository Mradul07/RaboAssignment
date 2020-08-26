package com.employee.api.dao;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
 * Description:
 * This class is a DAO interface that acts as a repository for the actual application
 * This class inherits the CrudRepository interface that gives all the methods which acts as an operations on the database
 */

@Repository
public interface EmployeeDao extends CrudRepository<EmployeeEntity, Integer>{
	List<EmployeeEntity> findByemployeeName(String employeeName);
}
