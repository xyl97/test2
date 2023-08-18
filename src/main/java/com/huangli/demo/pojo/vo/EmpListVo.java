package com.huangli.demo.pojo.vo;

import lombok.Data;

/**
 * 职工列表
 */
@Data
public class EmpListVo {


    //员工id
    private int id;

    //员工姓名
    private String empName;

    //员工性别
    private String sex;

    //员工年龄
    private String age;

    //员工部门名称
    private String deptName;

    //员工学历
    private String empDegreeName;
}
