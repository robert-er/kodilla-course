package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CompanyDaoTestSuite {
    @Autowired
    CompanyDao companyDao;
    @Autowired
    EmployeeDao employeeDao;

    private Employee johnSmith = new Employee("John", "Smith");
    private Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
    private Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

    private Company softwareMachine = new Company("Software Machine");
    private Company dataMaesters = new Company("Data Maesters");
    private Company greyMatter = new Company("Grey Matter");

    private int softwareMachineId;
    private int dataMaestersId;
    private int greyMatterId;

    @Test
    public void testSaveManyToMany(){
        //Given + When
       createTestData();

        //Then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);

        //CleanUp
       cleanUpTestData();
    }

    @Test
    public void testEmployeeFindByLastname() {
        //Given
        createTestData();

        //When
        List<Employee> employeeList = employeeDao.findByLastname("Smith");

        //Then
        Assert.assertEquals(1, employeeList.size());

        //CleanUp
        cleanUpTestData();
    }

    @Test
    public void testCompanyFindByFirstThreeCharacters() {
        //Given
        createTestData();

        //When
        List<Company> companyList = companyDao.findByFirstThreeCharacters("Datzzzzzzzzzzzz");

        //Then
        Assert.assertEquals(1, companyList.size());

        //CleanUp
        cleanUpTestData();
    }

    private void createTestData() {
        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        companyDao.save(softwareMachine);
        companyDao.save(dataMaesters);
        companyDao.save(greyMatter);

        softwareMachineId = softwareMachine.getId();
        dataMaestersId = dataMaesters.getId();
        greyMatterId = greyMatter.getId();
    }

    private void cleanUpTestData() {
        try {
            companyDao.deleteById(softwareMachineId);
            companyDao.deleteById(dataMaestersId);
            companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }
}
