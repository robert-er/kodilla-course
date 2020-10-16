package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Facade {

    @Autowired
    private CompanyFacadeDao companyFacadeDao;
    @Autowired
    private EmployeeFacadeDao employeeFacadeDao;

    public void addEmployee(Employee employee) {
        employeeFacadeDao.save(employee);
    }

    public void addCompany(Company company) {
        companyFacadeDao.save(company);
    }

    public void addEmployeeToCompany(Company company, Employee employee) {
       company.getEmployees().add(employee);
       employee.getCompanies().add(company);
    }

    public EmployeeFacadeDao getEmployeeFacadeDao() {
        return employeeFacadeDao;
    }

    public CompanyFacadeDao getCompanyFacadeDao() {
        return companyFacadeDao;
    }
}
