package com.mergereq.core.conf;

import com.mergereq.core.promise.RequestPromise;
import com.mergereq.core.util.PubUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MergeThreadInitConfig implements InitializingBean {

    private static MergeThreadInitConfig ins;

    /**
     * 日志
     */
    Logger logger = LoggerFactory.getLogger(MergeThreadInitConfig.class);

    /**
     * 请求合并队列
     */
    private BlockingQueue<RequestPromise> queue = new LinkedBlockingQueue<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        init();
        startMergeThread();
    }

    /**
     * 初始化
     */
    private void init(){
        ins = this;
    }

    /**
     * 启动合并线程
     */
    private void startMergeThread(){
        new Thread(()->{
            List<RequestPromise> promiseList = new ArrayList<>();
            while (true) {
                // 防止cpu空转
                if (queue.isEmpty()) {
                    try {
                        Thread.sleep(10);
                        continue;
                    } catch (InterruptedException e) {
                        logger.info("==========异常，原因："+e);
                    }
                }

                try {
                    promiseList.add(queue.take());
                } catch (InterruptedException e) {
                    logger.info("==========异常，原因："+e);
                }
            }

        },"merge thread").start();
    }

    /**
     * 获取合并请求队列
     * @return
     */
    public static BlockingQueue<RequestPromise> getQueue(){
        return ins.queue;
    }
}
