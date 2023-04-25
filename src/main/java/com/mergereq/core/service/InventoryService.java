package com.mergereq.core.service;

import com.mergereq.core.bo.InventoryBo;
import com.mergereq.core.request.UserRequest;
import com.mergereq.core.result.Result;
import jakarta.servlet.http.HttpServletRequest;

public interface InventoryService {

    /**
     * 扣减
     * @param request
     * @return
     */
    Result deduction(UserRequest request) throws Exception;
}
