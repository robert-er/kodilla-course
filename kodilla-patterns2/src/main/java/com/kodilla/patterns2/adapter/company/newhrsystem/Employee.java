package com.kodilla.patterns2.adapter.company.newhrsystem;

import java.math.BigDecimal;
import java.util.Objects;

public class Employee {
    private final String peselId;
    private final String name;
    private final String surname;
    private final BigDecimal baseSalary;

    public Employee(String peselId, String name, String surname, BigDecimal baseSalary) {
        this.peselId = peselId;
        this.name = name;
        this.surname = surname;
        this.baseSalary = baseSalary;
    }

    public String getPeselId() {
        return peselId;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public BigDecimal getBaseSalary() {
        return baseSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return peselId.equals(employee.peselId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(peselId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "peselId='" + peselId + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", baseSalary=" + baseSalary +
                '}';
    }
}
