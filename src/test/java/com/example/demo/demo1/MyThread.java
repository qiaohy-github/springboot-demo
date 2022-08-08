package com.example.demo.demo1;

import java.util.concurrent.*;

public class MyThread {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);

       /* Future<String> future = executorService.submit(new Task2());
        final String result = future.get();
        System.out.println(result);*/


        for (int i = 0; i < 20; i ++){
            /*executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });*/
            executorService.execute(new Task());
        }
    }

    static class Task extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName());
        }
    }

    static class Task2 implements Callable {
        @Override
        public Object call() throws Exception {
            TimeUnit.SECONDS.sleep(2);

            return "this is future case";
        }
    }


}
