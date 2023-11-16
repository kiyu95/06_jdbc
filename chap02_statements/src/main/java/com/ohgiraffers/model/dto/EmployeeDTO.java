package com.ohgiraffers.model.dto;

import java.util.Date;

public class EmployeeDTO {
    private String empId;
    private String empName;
    private String empNo;
    private String email;
    private String phone;
    private String deptCode;
    private String jobCode;
    private String salLevel;
    private int salary;
    private double bonus;
    private String managerId;
    private Date hireDate;
    private Date entDate;
    private String entYn;

    public EmployeeDTO() {
    }

    public EmployeeDTO(String empId, String empName, String empNo, String email, String phone, String deptCode, String jobCode, String salLevel, int salary, double bonus, String managerId, Date hireDate, Date entDate, String entYn) {
        this.empId = empId;
        this.empName = empName;
        this.empNo = empNo;
        this.email = email;
        this.phone = phone;
        this.deptCode = deptCode;
        this.jobCode = jobCode;
        this.salLevel = salLevel;
        this.salary = salary;
        this.bonus = bonus;
        this.managerId = managerId;
        this.hireDate = hireDate;
        this.entDate = entDate;
        this.entYn = entYn;
    }

    public EmployeeDTO setEmpId(String id) {
        this.empId = id;
        return this;
    }

    public EmployeeDTO setempName(String empName) {
        this.empName = empName;
        return this;
    }

    public EmployeeDTO setempNo(String empNo) {
        this.empNo = empNo;
        return this;
    }

    public EmployeeDTO setemail(String email) {
        this.email = email;
        return this;
    }

    public EmployeeDTO setphone(String phone) {
        this.phone = phone;
        return this;
    }

    public EmployeeDTO setdeptCode(String deptCode) {
        this.deptCode = deptCode;
        return this;
    }

    public EmployeeDTO setjobCode(String jobCode) {
        this.jobCode = jobCode;
        return this;
    }

    public EmployeeDTO setsalLevel(String salLevel) {
        this.salLevel = salLevel;
        return this;
    }

    public EmployeeDTO setsalary(int salary) {
        this.salary = salary;
        return this;
    }

    public EmployeeDTO setbonus(double bonus) {
        this.bonus = bonus;
        return this;
    }

    public EmployeeDTO setmanagerId(String managerId) {
        this.managerId = managerId;
        return this;
    }

    public EmployeeDTO sethireDate(Date hireDate) {
        this.hireDate = hireDate;
        return this;
    }

    public EmployeeDTO setentDate(Date entDate) {
        this.entDate = entDate;
        return this;
    }

    public EmployeeDTO setentYn(String entYn) {
        this.entYn = entYn;
        return this;
    }

    public EmployeeDTO builder(){
        return new EmployeeDTO(empId, empName, empNo, email, phone, deptCode, jobCode, salLevel, salary, bonus, managerId, hireDate, entDate, entYn);
    }

    public String getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpNo() {
        return empNo;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public String getJobCode() {
        return jobCode;
    }

    public String getSalLevel() {
        return salLevel;
    }

    public int getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }

    public String getManagerId() {
        return managerId;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public Date getEntDate() {
        return entDate;
    }

    public String getEntYn() {
        return entYn;
    }

    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", empNo='" + empNo + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", deptCode='" + deptCode + '\'' +
                ", jobCode='" + jobCode + '\'' +
                ", salLevel='" + salLevel + '\'' +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", managerId='" + managerId + '\'' +
                ", hireDate=" + hireDate +
                ", entDate=" + entDate +
                ", entYn='" + entYn + '\'' +
                '}';
    }
}
