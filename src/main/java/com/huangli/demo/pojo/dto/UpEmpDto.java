package com.huangli.demo.pojo.dto;

import lombok.Data;

/**
 * 修改职工实体类
 */
@Data
public class UpEmpDto {

    //员工id
    private Integer id;
    //员工姓名
    private String empName;
    //员工性别
    private String sex;
    //员工年龄
    private Integer age;
    //员工部门名称
    private String deptName;

    //员工学历
    private String empDegreeName;

}
