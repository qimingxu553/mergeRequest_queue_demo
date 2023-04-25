package com.mergereq.core.controller;

import com.mergereq.core.bo.InventoryBo;
import com.mergereq.core.request.UserRequest;
import com.mergereq.core.result.Result;
import com.mergereq.core.service.InventoryService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品库存
 */
@RestController
@RequestMapping(value = "/inventory")
public class InventoryController {

    @Autowired
    private InventoryService service;

    /**
     * 扣减
     * @param request
     * @return
     */
    @RequestMapping(value = "/deduction", method = RequestMethod.POST)
    public Result deduction(@RequestBody UserRequest request) throws Exception{
        return service.deduction(request);
    }
}
