package com.huangli.demo.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.huangli.demo.dao.EmpDao;
import com.huangli.demo.pojo.dto.AddEmpDto;
import com.huangli.demo.pojo.dto.SearchEmpDto;
import com.huangli.demo.pojo.dto.UpEmpDto;
import com.huangli.demo.pojo.vo.EmpListVo;
import com.huangli.demo.service.EmpService;
import com.huangli.demo.utils.ResponseResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 员工控制器
 */
@Api(tags = "职工列表Controller")
@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 查询职工列表
     * @param searchEmpDto 条件查询数据
     * @param pageNo
     * @param pageSize
     * @return
     */
    @ApiOperation(value = "查询职工列表")
    @PostMapping("list")
    public ResponseResult<List<EmpListVo>> selectStaffList(@RequestBody SearchEmpDto searchEmpDto, @RequestParam(value = "pageNo" ,defaultValue = "1")Integer pageNo,
                                                           @RequestParam(value = "pageSize",defaultValue = "2") Integer pageSize){

        Page page = PageHelper.startPage(pageNo,pageSize);
        List<EmpListVo> getAllList = empService.getStaffList(searchEmpDto);

        return ResponseResult.success(getAllList,page);

    }

    /**
     *  添加员工
     * @param addEmpDto 前端发送的员工数据
     * @return
     */
    @ApiOperation(value = "添加职工")
    @PostMapping("add")
    public ResponseResult addEmp (@RequestBody AddEmpDto addEmpDto){
//        addEmpDto.setId();  //应该手动添加id
        //校验数据
        if ("".equals(addEmpDto.getEmpName())){
            return ResponseResult.verifyFailed("姓名不能为空！");
        }
        if (addEmpDto.getEmpAge()==null){
            return ResponseResult.verifyFailed("年龄不能为空！");
        }
        if ("".equals(addEmpDto.getEmpSex())){
            return ResponseResult.verifyFailed("性别不能为空！");
        }
        if ("".equals(addEmpDto.getEmpDeptName())){
            return ResponseResult.verifyFailed("部门不能为空！");
        }
        if ("".equals(addEmpDto.getEmpDegreeName())){
            return ResponseResult.verifyFailed("学历不能为空！");
        }
        return empService.addEmp(addEmpDto);
    }

    /**
     * 通过员工id删除员工
     * @param id 员工id
     * @return
     */
    @ApiOperation(value = "删除职工")
    @DeleteMapping("deleteEmp/{id}")
    public ResponseResult deleteEmp (@PathVariable(value = "id")  Integer id){

        if (id==null){
            return ResponseResult.verifyFailed("请选择员工");

        }
        return empService.deleteEmp(id);
    }

    /**
     * 修改员工信息
     * @param upEmpDto  前端获取修改后的员工数据
     * @return
     */
    @ApiOperation(value = "修改职工信息")
    @PutMapping("update")
    public ResponseResult updateEmp (@RequestBody UpEmpDto upEmpDto) {

        return empService.upEmp(upEmpDto);
    }
}
