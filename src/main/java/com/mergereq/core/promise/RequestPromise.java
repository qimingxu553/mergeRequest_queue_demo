package com.mergereq.core.promise;

import com.mergereq.core.request.UserRequest;
import com.mergereq.core.result.Result;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 请求指针
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestPromise {
    /**
     * 请求对象
     */
    private UserRequest userRequest;

    /**
     * 响应对象
     */
    private Result result;

    public RequestPromise(UserRequest userRequest) {
        this.userRequest = userRequest;
    }
}
