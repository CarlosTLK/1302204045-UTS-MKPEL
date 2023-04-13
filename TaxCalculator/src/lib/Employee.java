package lib;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    
    private String employeeId;
    private String firstName;
    private String lastName;
    private String idNumber;
    private String address;

    private LocalDate dateJoined;
    private boolean isForeigner;
    private boolean isMale;
    private int monthlySalary;
    private int otherMonthlyIncome;
    private int annualDeductible;

    private String spouseName;
    private String spouseIdNumber;
    private List<Child> children;

    public Employee(String employeeId, String firstName, String lastName, String idNumber, String address, LocalDate dateJoined, boolean isForeigner, boolean isMale) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.address = address;
        this.dateJoined = dateJoined;
        this.isForeigner = isForeigner;
        this.isMale = isMale;
        this.children = new ArrayList<>();
    }

    public void setMonthlySalary(int grade) {
        int salary = 0;
        switch (grade) {
            case 1:
                salary = 3000000;
                break;
            case 2:
                salary = 5000000;
                break;
            case 3:
                salary = 7000000;
                break;
            default:
                break;
        }
        monthlySalary = isForeigner ? (int) (salary * 1.5) : salary;
    }

    public void setAnnualDeductible(int deductible) {
        this.annualDeductible = deductible;
    }

    public void setAdditionalIncome(int income) {
        this.otherMonthlyIncome = income;
    }

    public void setSpouse(String spouseName, String spouseIdNumber) {
        this.spouseName = spouseName;
        this.spouseIdNumber = spouseIdNumber;
    }

    public void addChild(String childName, String childIdNumber) {
        children.add(new Child(childName, childIdNumber));
    }

    public int getAnnualIncomeTax() {
        int monthWorkingInYear = 12;
        if (dateJoined.getYear() == LocalDate.now().getYear()) {
            monthWorkingInYear = LocalDate.now().getMonthValue() - dateJoined.getMonthValue();
        }
        return TaxFunction.calculateTax(monthlySalary, otherMonthlyIncome, monthWorkingInYear, annualDeductible, spouseIdNumber == null || spouseIdNumber.isEmpty(), children.size());
    }

    private static class Child {
        private String name;
        private String idNumber;

        public Child(String name, String idNumber) {
            this.name = name;
            this.idNumber = idNumber;
        }
    }
}
