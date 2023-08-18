package com.huangli.demo.service;


import com.huangli.demo.pojo.dto.AddEmpDto;
import com.huangli.demo.pojo.dto.SearchEmpDto;
import com.huangli.demo.pojo.dto.UpEmpDto;
import com.huangli.demo.pojo.vo.EmpListVo;
import com.huangli.demo.utils.ResponseResult;

import java.util.List;

/**
 * 职工列表service
 */
public interface EmpService {
    /**
     * 查询全部员工列表  条件查询
     * @param searchEmpDto 条件查询数据
     * @return
     */
    List<EmpListVo> getStaffList(SearchEmpDto searchEmpDto);


    /**
     * 添加员工
     * @param addEmpDto  前端传到后端的数据
     * @return
     */
    ResponseResult addEmp(AddEmpDto addEmpDto);

    /**
     * 根据员工id删除员工
     * @param id 员工id
     * @return
     */
    ResponseResult deleteEmp(Integer id);


    /**
     * 修改员工信息
     * @param upEmpDto 前端获取修改后的员工数据
     * @return
     */
    ResponseResult upEmp(UpEmpDto upEmpDto);
}
