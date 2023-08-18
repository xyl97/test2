package com.huangli.demo.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.github.pagehelper.Page;
import lombok.Data;

import java.io.Serializable;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T>  implements Serializable {


    public ResponseResult() {
    }

    public ResponseResult(int code, boolean status, String msg, T result) {
        this.code = code;
        this.status = status;
        this.msg = msg;
        this.result = result;
    }

    public ResponseResult(int code, boolean status, String msg, T result, Integer total, Integer pages, Integer pageSize, Integer pageNo) {
        this.code = code;
        this.status = status;
        this.msg = msg;
        this.result = result;
        this.total = total;
        this.pages = pages;
        this.pageSize = pageSize;
        this.pageNo = pageNo;
    }

    private static final long serialVersionUID = 3822301873972629L;

    private int code;

    private boolean status;

    private String msg;

    private T result;

    //数据总数
    private Integer total;
    //总页数
    private Integer pages;
    //每页的数量
    private Integer pageSize;
    //当前页
    private Integer pageNo;



    public static <T> ResponseResult<T> success(String msg, T result) {
        return new ResponseResult<T>(ResultCode.BUSINESS_SUCCESS, true, msg, result);
    }

    public static <T> ResponseResult<T> success(T result) {
        return ResponseResult.success("Success", result);
    }

    public static <T> ResponseResult<T> success() {
        return new ResponseResult<T>(ResultCode.BUSINESS_SUCCESS, true, "Success", null);
    }

    //分页
    public static <T> ResponseResult<T> success(String msg, T result, Page page) {
        if (page == null) page = new Page();
        return new ResponseResult<T>(ResultCode.BUSINESS_SUCCESS, true, msg, result, (int) page.getTotal(),
                page.getPages(), page.getPageSize(), page.getPageNum());
    }

    public static <T> ResponseResult<T> success(T result, Page page) {
        return ResponseResult.success("Success", result, page);
    }

    public static <T> ResponseResult<T> success(T result, int total,int pageSize,int pageNum) {
        return new ResponseResult<T>(ResultCode.BUSINESS_SUCCESS, true, "Success", result,total,null, pageSize, pageNum);
    }

    //错误
    public static <T> ResponseResult<T> fail(String msg) {
        return new ResponseResult<T>(ResultCode.BUSIOPERACTION_FAILED, false, msg);
    }
    public static <T> ResponseResult<T> fail() {
        return ResponseResult.fail("Fail");
    }

    public static <T> ResponseResult<T> fail(Throwable throwable) {
        return new ResponseResult<T>(ResultCode.BUSIOPERACTION_FAILED, throwable.getMessage());
    }

    /**
     * 错误
     * @param code 自定义错误code
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> fail(int code,String msg) {
        return new ResponseResult<T>(code, false, msg);
    }


    /**
     * 验证失败的封装
     * 验证前台获取到的数据
     * @param msg
     * @param <T>
     * @return
     */
    public static <T> ResponseResult<T> verifyFailed(String msg) {
        return new ResponseResult<T>(ResultCode.DATAVERIFICATION_FAILED, false, msg);
    }


    public ResponseResult(int code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(int code, boolean status, String msg) {
        super();
        this.code = code;
        this.status = status;
        this.msg = msg;
    }
}
