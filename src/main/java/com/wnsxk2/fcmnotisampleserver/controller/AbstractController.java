package com.wnsxk2.fcmnotisampleserver.controller;

import com.wnsxk2.fcmnotisampleserver.dto.ResponseDTO;
import com.wnsxk2.fcmnotisampleserver.dto.ResultObject;

public abstract class AbstractController {

    protected <T> ResponseDTO<T> ok() {
        return ok(null, ResultObject.getSuccess());
    }

    protected <T> ResponseDTO<T> ok(T data) {
        return ok(data, ResultObject.getSuccess());
    }

    protected <T> ResponseDTO<T> ok(T data, ResultObject result) {
        ResponseDTO<T> obj = new ResponseDTO<>();
        obj.setResult(result);
        obj.setData(data);

        return obj;
    }
}
