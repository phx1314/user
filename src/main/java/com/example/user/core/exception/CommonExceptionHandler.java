package com.example.user.core.exception;



import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangkl
 */
public class CommonExceptionHandler {

    /**
     * desc:统一包装异常返回数据
     *
     * @param message
     * @return
     */
    public Map<String, Object> randerFail(String code, String message) {
        Map<String, Object> randerJsonMap = new HashMap<String, Object>();
        randerJsonMap.put("code", code);
        randerJsonMap.put("msg", message);
        randerJsonMap.put("data", "");
        randerJsonMap.put("success", false);
        return randerJsonMap;
    }

    public Map<String, Object> randerFail(ErrorCode errorCode) {
        return randerFail(errorCode.getCode(), errorCode.getMsg());
    }
}
