package com.example.user.core.exception;



import com.example.user.core.utils.DateUtils;

import java.util.Date;

public class BaseConstant {

    public static final String FAIL = "0000";

    public static final String SUCCESS = "1111";

    public static final String BIZ_FAIL = "0111";

    public static final String SUCCESS_MSG = "操作成功";

    public static final String FAIL_MSG = "操作失败";

    /**
     * 默认页大小
     */
    public static final int DEFAULT_PAGE_SIZE = 10;

    /**
     * 默认当前页
     */
    public static final int DEFAULT_CURRENT_PAGE = 1;

    /**
     * token标识
     */
    public static final String TOKEN = "token";

    /**
     * 超级管理员
     */
    public static final String ROOT_USER = "admin";

    /**
     * token信息-userName
     */
    public static final String TOKEN_CLAIM_USERNAME = "username";

    /**
     * token信息-userName
     */
    public static final String REDIS_TOKEN = "mobile";

    /**
     * token过期时间
     */
    public static Integer TOKEN_EXPIRE_TIME = 30; //天

    /**
     * token过期时间
     */
    public static Long TOKEN_EXPIRE_TIMESEC = 30 * 24 * 60 * 60L; //天

    /**
     * 定义的权限定义前缀
     */
    public static final String ROLE_PREFIX = "ROLE_";


    /**
     * 100年之后永久日期
     */
    public static final Date FOR_EVER_DATE = DateUtils.getDayOffsetBegin(365 * 100);


    /**
     * 图片上传格式 jpg，jpeg，png
     */
    public static final String MAP_FILE_JPG = "JPG";

    public static final String MAP_FILE_JPEG = "JPEG";

    public static final String MAP_FILE_PNG = "PNG";

    /**
     * 语音电话固定配置
     */
    public static final String SMS_VOICE_VCCID = "200024";
    public static final String SMS_VOICE_PROID = "10417";
    public static final String SMS_VOICE_TOKEN = "4e4e9ae3c5e954e0227a093f2b78568fa9c9f425";


    public static void main(String args[]) {
        Date dd = BaseConstant.FOR_EVER_DATE;
        System.out.println(">>>>>" + dd);

    }

}
