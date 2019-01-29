package edu.redcom.tool;

import edu.redcom.util.HttpRequestThread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;


/**
 * 测试并发抽奖功能
 */
public class TestDrawPrize {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        System.out.println("----程序开始运行----");
        Date date1 = new Date();

        int taskSize = 100;

        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        List<Future> list = new ArrayList<Future>();
        for (int i = 0; i < taskSize; i++) {
            HttpRequestThread c = new HttpRequestThread();
            // 执行任务并获取Future对象
            Future f = pool.submit(c);

            list.add(f);
        }
        // 关闭线程池
        pool.shutdown();

        // 获取所有并发任务的运行结果
        for (Future f : list) {
            // 从Future对象上获取任务的返回值，并输出到控制台
            System.out.println(">>>" + f.get().toString());
        }

        Date date2 = new Date();
        System.out.println("----程序结束运行----，程序运行时间【"
                + (date2.getTime() - date1.getTime()) + "毫秒】");
    }


}
