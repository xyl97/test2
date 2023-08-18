package com.huangli.demo.utils;

public final class ResultCode {

    /**
     * 业务成功
     */
    public static final int BUSINESS_SUCCESS = 0;

    /**
     * User Forbidden!Does not has Permission! 没有登录的
     */
    public static final int UserForbidden_NoPermission = 430101;

    /**
     * 长轮询请求超时
     */
    public static final int AsyncRequestTimeout = 430000;

    /**
     * 没有设计系统权限
     */
    public static final int DEVISE_NOPERMISSION = 430102;

    /**
     * 项目没有该用户
     */
    public static final int PROJECT_NO_USER = 430103;

    /**
     * 项目没有模型
     */
    public static final int EOMS_NOPERMISSION = 430104;

    /**
     * 没有选择设计系统专业，请勿修改
     */
    public static final int DEVISE_CHOOSEDSPECIALTIES = 4301021;

    /**
     * 控制器 数据校验失败
     */
    public static final int DATAVERIFICATION_FAILED = 10001;

    /**
     * 业务处理失败
     */
    public static final int BUSIOPERACTION_FAILED = 10002;

    /**
     * 系统异常
     */
    public static final int APPEXCEPTION = 20000;

    /**
     * 在模型不存在时，客户端会进行处理，该 code 时客户端进行判断的标准，请勿修改
     */
    public static final int MODEL_FILE_NOT_FOUND = 20001;
}
