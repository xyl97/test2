package com.huangli.demo.pojo.dto;

import lombok.Data;

/**
 * 添加职工实体类
 */
@Data
public class AddEmpDto {

    //职工id
    private Integer id;
    //职工姓名
    private String empName;
    //职工性别
    private String empSex;
    //职工年龄
    private Integer empAge;
    //职工部门名称
    private String empDeptName;

    //职工学历
    private String empDegreeName;
}
