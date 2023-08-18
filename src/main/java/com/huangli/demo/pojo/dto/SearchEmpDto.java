package com.huangli.demo.pojo.dto;


import lombok.Data;

/**
 * 职工条件查询实体类
 */
@Data
public class SearchEmpDto {
    private String emp_name;
    //员工部门名称
    private String dept_name;

    //员工学历
    private String emp_degree_name;
}
