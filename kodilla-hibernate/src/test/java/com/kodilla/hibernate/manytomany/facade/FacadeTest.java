package com.kodilla.hibernate.manytomany.facade;

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
class FacadeTest {

    @Autowired
    private Facade facade;

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
    public void testSave() {
        //given
        createTestData();

        //when
        softwareMachineId = facade.getCompanyFacadeDao().findByName(softwareMachine.getName()).get(0).getId();
        dataMaestersId = facade.getCompanyFacadeDao().findByName(dataMaesters.getName()).get(0).getId();
        greyMatterId = facade.getCompanyFacadeDao().findByName(greyMatter.getName()).get(0).getId();

        //then
        Assert.assertNotEquals(0, softwareMachineId);
        Assert.assertNotEquals(0, dataMaestersId);
        Assert.assertNotEquals(0, greyMatterId);

        //CleanUp
        cleanUpTestData();
    }

    @Test
    public void testCompanyFindByFragment() {
        //given
        createTestData();

        //when
        List<Company> companyList = facade.getCompanyFacadeDao().findByFragment("ware");

        //then
        Assert.assertNotEquals(0, companyList.size());

        //CleanUp
        cleanUpTestData();
    }

    @Test
    public void testEmployeeFindByFragment() {
        //given
        createTestData();

        //when
        List<Employee> employeeList = facade.getEmployeeFacadeDao().findByFragment("Koval");

        //then
        Assert.assertNotEquals(0, employeeList);

        //CleanUp
        cleanUpTestData();
    }

    private void createTestData() {
        facade.addEmployeeToCompany(softwareMachine, johnSmith);
        facade.addEmployeeToCompany(softwareMachine, stephanieClarckson);

        facade.addEmployeeToCompany(dataMaesters, johnSmith);
        facade.addEmployeeToCompany(dataMaesters, lindaKovalsky);

        facade.addEmployeeToCompany(greyMatter, johnSmith);
        facade.addEmployeeToCompany(greyMatter, stephanieClarckson);
        facade.addEmployeeToCompany(greyMatter, lindaKovalsky);

        facade.addCompany(softwareMachine);
        facade.addCompany(dataMaesters);
        facade.addCompany(greyMatter);

        facade.addEmployee(johnSmith);
        facade.addEmployee(stephanieClarckson);
        facade.addEmployee(lindaKovalsky);
    }

    private void cleanUpTestData() {
        try {
            facade.getCompanyFacadeDao().deleteByName(softwareMachine.getName());
            facade.getCompanyFacadeDao().deleteByName(dataMaesters.getName());
            facade.getCompanyFacadeDao().deleteByName(greyMatter.getName());
        } catch (Exception e) {
            //do nothing
        }
    }
}