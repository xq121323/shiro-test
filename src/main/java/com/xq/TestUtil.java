package com.xq;

import cn.hutool.http.HttpUtil;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Mechrevo
 * @version v1.0
 * 2020/3/11 18:01
 */
public class TestUtil {
    private static int i = 0;
    private static final int COUNT = 1000;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(COUNT);

        CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < COUNT; i++) {
            executor.execute(() -> send(countDownLatch));
        }
        countDownLatch.countDown();


    }

   private static void send(CountDownLatch latch){ String url = "http://localhost:8080/mq/getUser/";
       Random random = new Random();
       int i = random.nextInt(3)+1;
       url = url.concat(String.valueOf(i));

       String s = HttpUtil.get(url);
       try {
           latch.await();
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       System.out.println("第"+(TestUtil.i++)+"次输出："+ s);
   }



}
