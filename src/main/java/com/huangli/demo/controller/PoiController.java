package com.huangli.demo.controller;


import com.huangli.demo.pojo.dto.SearchEmpDto;
import com.huangli.demo.service.PoiService;
import com.huangli.demo.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

/**
 * 导出
 */
@RestController
public class PoiController {

    @Autowired
    private PoiService poiService;


    /**
     * 导出
     * @param searchEmpDto  条件查询数据
     * @param response
     * @return
     */
    @PostMapping("downLoadExcel")
    public void downLoadExcel( @RequestBody SearchEmpDto searchEmpDto,HttpServletResponse response) {

//        return    poiService.downLoadExcel( searchEmpDto,response);
            poiService.downLoadExcel( searchEmpDto,response);

    }
}
