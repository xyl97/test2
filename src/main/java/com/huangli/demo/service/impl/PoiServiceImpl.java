package com.huangli.demo.service.impl;


import com.huangli.demo.dao.EmpDao;
import com.huangli.demo.pojo.dto.SearchEmpDto;
import com.huangli.demo.pojo.vo.EmpListVo;
import com.huangli.demo.service.PoiService;
import com.huangli.demo.utils.ResponseResult;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Service
public class PoiServiceImpl implements PoiService {


    @Autowired
    private EmpDao empDao;

    @Override
    public void downLoadExcel(SearchEmpDto searchEmpDto, HttpServletResponse response) {
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("信息表");

        List<EmpListVo> empListVos = empDao.selectStaff(searchEmpDto);


        String fileName = "emp" + ".xls";//设置要导出的文件的名字
        //新增数据行，并且设置单元格数据

        int rowNum = 1;

        String[] headers = {"id", "姓名", "性别", "年龄", "部门", "学历"};

        //headers表示excel表中第一行的表头

        HSSFRow row = sheet.createRow(0);
        //在excel表中添加表头

        for (int i = 0; i < headers.length; i++) {
            HSSFCell cell = row.createCell(i);
            HSSFRichTextString text = new HSSFRichTextString(headers[i]);
            cell.setCellValue(text);
        }

        //在表中存放查询到的数据放入对应的列
        for (EmpListVo empListVo : empListVos) {
            HSSFRow row1 = sheet.createRow(rowNum);
            row1.createCell(0).setCellValue(empListVo.getId());
            row1.createCell(1).setCellValue(empListVo.getEmpName());
            row1.createCell(2).setCellValue(empListVo.getSex());
            row1.createCell(3).setCellValue(empListVo.getAge());
            row1.createCell(4).setCellValue(empListVo.getDeptName());
            row1.createCell(5).setCellValue(empListVo.getEmpDegreeName());
            rowNum++;


        }
//        response.setContentType("application/octet-stream");

        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
//        Response.AppendHeader("Content-Disposition","attachment;filename=FileName.txt");



        try {
            response.flushBuffer();
            workbook.write(response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
//        return ResponseResult.success("下载成功");
    }

}
