package com.huangli.demo.service.impl;


import com.huangli.demo.dao.EmpDao;
import com.huangli.demo.pojo.dto.AddEmpDto;
import com.huangli.demo.pojo.dto.SearchEmpDto;
import com.huangli.demo.pojo.dto.UpEmpDto;
import com.huangli.demo.pojo.vo.EmpListVo;
import com.huangli.demo.service.EmpService;
import com.huangli.demo.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 职工列表service实现类
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpDao empDao;

    //查询员工信息，并且根据员工姓名查询员工
    @Override
    public List<EmpListVo> getStaffList(SearchEmpDto searchEmpDto) {
        return empDao.selectStaff(searchEmpDto);
    }

    /**
     * 添加用户
     * @param addEmpDto  前端传到后端的数据
     * @return
     */
    @Override
    public ResponseResult addEmp(AddEmpDto addEmpDto) {
        boolean add = empDao.addEmp(addEmpDto);
        if (add){
            return ResponseResult.success("添加成功");

        }else {
            return ResponseResult.fail("添加失败");
        }
    }


    /**
     * 根据员工id删除员工
     * @param id 员工id
     * @return
     */
    @Override
    public ResponseResult deleteEmp(Integer id) {
        boolean del = empDao.deletEmp(id);
        if (del){
            return ResponseResult.success("删除成功");
        }else {
            return ResponseResult.fail("删除失败");
        }

    }

    /**
     * 修改员工数据
     * @param upEmpDto 前端获取修改后的员工数据
     * @return
     */
    @Override
    public ResponseResult upEmp(UpEmpDto upEmpDto) {
        boolean upd= empDao.upEmp(upEmpDto);
        if (upd){
            return ResponseResult.success("修改成功");
        }else {
            return ResponseResult.fail("修改失败");
        }
    }

}
