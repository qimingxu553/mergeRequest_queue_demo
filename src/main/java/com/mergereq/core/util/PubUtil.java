package com.mergereq.core.util;

import org.springframework.boot.CommandLineRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 公共工具类
 */
public class PubUtil implements CommandLineRunner {

    private static PubUtil ins;

    /**
     * 线程池
     */
    private ExecutorService executorService;

    @Override
    public void run(String... args) throws Exception {
        ins = this;
        int n = Runtime.getRuntime().availableProcessors();
        this.executorService = Executors.newScheduledThreadPool(2 * n);
    }

    public static ExecutorService getExecutorService(){
        return ins.executorService;
    }
}
