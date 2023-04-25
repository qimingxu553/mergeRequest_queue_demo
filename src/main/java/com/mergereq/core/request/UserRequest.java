package com.mergereq.core.request;

import lombok.Data;

/**
 * 用户请求
 */
@Data
public class UserRequest {

    /**
     * 订单标识
     */
    private Long orderId;

    /**
     * 用户标识
     */
    private Long userId;

    /**
     * 库存
     */
    private Integer count;
}
