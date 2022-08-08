package com.example.demo.demo2;

import java.util.concurrent.*;

/**
 * @description:
 * @author: qiaohy
 * @time: 2021/12/16
 */
public class TestC {


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++){
            CountDownLatch latch = new CountDownLatch(3);

            Future<String> submit1 = executorService.submit(new Task1(latch));
            System.out.println(submit1.get());

            Future<String> submit2 = executorService.submit(new Task2(latch));
            System.out.println(submit2.get());

            Future<String> submit3 = executorService.submit(new Task3(latch));
            System.out.println(submit3.get());

            latch.await();
        }
    }
    static class Task1 implements Callable<String> {

        private CountDownLatch latch;

        Task1(CountDownLatch latch){
            this.latch = latch;
        }

        @Override
        public String call() throws Exception {
            latch.countDown();
            return "A";

        }
    }

    static class Task2 implements Callable<String> {

        private CountDownLatch latch;

        Task2(CountDownLatch latch){
            this.latch = latch;
        }

        @Override
        public String call() throws Exception {
            latch.countDown();
            return "B";

        }
    }

    static class Task3 implements Callable<String> {

        private CountDownLatch latch;

        Task3(CountDownLatch latch){
            this.latch = latch;
        }

        @Override
        public String call() throws Exception {
            latch.countDown();
            return "C";

        }
    }


}
