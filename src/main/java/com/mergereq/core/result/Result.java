package com.mergereq.core.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 响应
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    /**
     * 响应结果
     */
    private Boolean success;

    /**
     * 响应信息
     */
    private String msg;
}
