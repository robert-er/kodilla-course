package com.kodilla.patterns2.adapter.company;

import com.kodilla.patterns2.adapter.company.oldhrsystem.Workers;
import org.junit.jupiter.api.Test;

class SalaryAdapterTest {
    @Test
    public void testTotalSalary() {
        //given
        Workers workers = new Workers();
        SalaryAdapter salaryAdapter = new SalaryAdapter();
        //when
        double totalSalary = salaryAdapter.TotalSalary(workers.getWorkers(), workers.getSalaries());
        //then
        System.out.println("Total salary: " + totalSalary);
        assertEquals(27750, totalSalary, 0);
    }

}