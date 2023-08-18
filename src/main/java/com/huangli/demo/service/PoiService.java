package com.huangli.demo.service;

import com.huangli.demo.pojo.dto.SearchEmpDto;
import com.huangli.demo.utils.ResponseResult;

import javax.servlet.http.HttpServletResponse;

/**
 * 导出service
 */

public interface PoiService {


    /**
     * 导出
     * @param response
     */
    void downLoadExcel(SearchEmpDto searchEmpDto, HttpServletResponse response);
}
