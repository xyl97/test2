package com.huangli.demo.pojo.dto;


import lombok.Data;

/**
 * 职工条件查询实体类
 */
@Data
public class SearchEmpDto {

    //职工姓名
    private String emp_name;
    //职工部门名称
    private String dept_name;

    //职工学历
    private String emp_degree_name;
}
