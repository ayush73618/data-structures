package com.company;

import java.util.concurrent.*;

public class FutureBasic {
    public static void main(String[] args) throws InterruptedException,ExecutionException,TimeoutException {
        System.out.println("Starting Future Class");
        ExecutorService es = Executors.newSingleThreadExecutor();
        ExecutorService es1 = Executors.newSingleThreadExecutor();

        Future<String> future = es.submit(()->{
                Thread.sleep(3000);
               return "Finally Learning Thread and future Class";

        });

        while(!future.isDone()){
            System.out.println("Waiting Games continue");
            Thread.sleep(1000);
        }
        System.out.println("Waiting game over");
        String result = future.get();
        System.out.println(result);
        es.shutdown();

      Future<String> future1 = es1.submit(()->{
            Thread.sleep(3000);
            return "Thread Which will not Execute";

        });

  //     future1.cancel(false);
        try{
            String res = future1.get(1000,TimeUnit.MILLISECONDS);
            System.out.println(res);
        }catch (TimeoutException e){
            es1.shutdown();
        }



    }
}
