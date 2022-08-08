package com.example.demo.demo1;

import java.util.concurrent.*;

/**
 * @description:
 * @author: qiaohy
 * @time: 2021/12/16
 */
public class Test06 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for(int i=0;i<10;i++){
            CountDownLatch countDownLatch = new CountDownLatch(3);
            //甲
            FutureTask<String> futureTask1 = new FutureTask<>(new Task1("A",countDownLatch));
            //乙
            FutureTask<String> futureTask2 = new FutureTask<>(new Task2(futureTask1,"B",countDownLatch));
            //丙
            FutureTask<String> futureTask3 = new FutureTask<>(new Task3(futureTask2,"C",countDownLatch));
            executorService.submit(futureTask1);
            executorService.submit(futureTask2);
            executorService.submit(futureTask3);
            countDownLatch.await();
        }
    }

    /**
     * 输出A
     */
    static class Task1 implements Callable<String>{

        private String value;

        private CountDownLatch countDownLatch;

        Task1(String value,CountDownLatch countDownLatch){
            this.value = value;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public String call() throws Exception {
            System.out.println(value);
            countDownLatch.countDown();
            return value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }


    static class Task2 implements Callable<String> {

        private FutureTask<String> futureTask1;

        private String value;

        private CountDownLatch countDownLatch;

        public Task2(FutureTask<String> futureTask,String value,CountDownLatch countDownLatch){
            this.futureTask1 = futureTask;
            this.value = value;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public String call() throws Exception {
            futureTask1.get();
            System.out.println(value);
            countDownLatch.countDown();
            return value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

    static class Task3 implements Callable<String>{

        private String value;

        private FutureTask<String> futureTask2;

        private CountDownLatch countDownLatch;

        public Task3(FutureTask<String> futureTask,String value,CountDownLatch countDownLatch){
            this.futureTask2 = futureTask;
            this.value = value;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public String call() throws Exception {
            String resultMsg = futureTask2.get();
            System.out.println(value);
            countDownLatch.countDown();
            return value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }



}
