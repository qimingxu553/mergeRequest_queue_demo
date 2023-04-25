package com.mergereq.core.service.impl;

import com.mergereq.core.bo.InventoryBo;
import com.mergereq.core.conf.MergeThreadInitConfig;
import com.mergereq.core.promise.RequestPromise;
import com.mergereq.core.request.UserRequest;
import com.mergereq.core.result.Result;
import com.mergereq.core.service.InventoryService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Override
    public Result deduction(UserRequest request) throws Exception {
        // 全局变量，是否拿得到? TODO
        BlockingQueue<RequestPromise> queue = MergeThreadInitConfig.getQueue();
        // 合并的是入参 TODO
        RequestPromise requestPromise = new RequestPromise(request);
        // 为什么加锁? park/unpark? TODO
        synchronized (requestPromise) {
            // 入队
            boolean enqueueSuccess = queue.offer(requestPromise, 100, TimeUnit.MILLISECONDS);
            if (! enqueueSuccess) {
                return new Result(false, "系统繁忙!");
            }
            // 超时判断
            try {
                requestPromise.wait(200);
                if (requestPromise.getResult() == null) {
                    return new Result(false, "等待超时!");
                }
            } catch (InterruptedException e) {
                return new Result(false, "中断异常!");
            }
        }

        return requestPromise.getResult();
    }
}
