package com.example.demo.demo3;

import java.util.concurrent.*;

/**
 * @description:多线程
 * @author: qiaohy
 * @time: 2021/12/16
 */
public class TestThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(50);

        for(int i = 0; i < 10; i++){

            CountDownLatch latch = new CountDownLatch(3);

            //甲线程
            Future<String> submit = executorService.submit(new Task1(latch));
            System.out.println(submit.get());

            //乙线程
            Future<String> submit2 = executorService.submit(new Task2(latch));
            System.out.println(submit2.get());

            //丙线程
            Future<String> submit3 = executorService.submit(new Task3(latch));
            System.out.println(submit3.get());

            latch.await();

        }

    }

    static class Task1 implements Callable {

        private CountDownLatch latch;

        Task1(CountDownLatch latch){
            this.latch = latch;
        }

        @Override
        public Object call() throws Exception {
            latch.countDown();
            return "A";
        }
    }

    static class Task2 implements Callable {

        private CountDownLatch latch;

        Task2(CountDownLatch latch){
            this.latch = latch;
        }

        @Override
        public Object call() throws Exception {
            latch.countDown();
            return "B";
        }
    }

    static class Task3 implements Callable {

        private CountDownLatch latch;

        Task3(CountDownLatch latch){
            this.latch = latch;
        }

        @Override
        public Object call() throws Exception {
            latch.countDown();
            return "C";
        }
    }






}
