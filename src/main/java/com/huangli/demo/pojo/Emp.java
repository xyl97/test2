package com.huangli.demo.pojo;

import lombok.Data;

/**
 * 职工实体类
 */
@Data
public class Emp {

    //员工id
    private int id;

    //员工姓名
    private String emp_name;

    //员工性别
    private String sex;

    //员工年龄
    private String age;

    //员工部门名称
    private String dept_name;

    //员工学历
    private String emp_degree_name;
}
