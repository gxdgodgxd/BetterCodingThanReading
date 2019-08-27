package com.gxd.Concurrent.s6.task.execution;

import java.util.concurrent.*;

/**
 * Created by gxdgodgxd on 18/1/16.
 */
public class RenderPageWithAd {

    ExecutorService exec = Executors.newFixedThreadPool(1);

    public void renderPageWithAd(){
        Future<Data> future = exec.submit(new Callable<Data>() {
            @Override
            public Data call() throws Exception {
                Thread.sleep(10000);
                System.out.println("still requesting data");
                return new Data("new ad");
            }
        });

        String ad = null;
        System.out.println("text");
        try {
            ad = future.get(1000, TimeUnit.MILLISECONDS).toString();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
            ad = "old ad";
        } catch (TimeoutException e) {
            e.printStackTrace();
            future.cancel(true);
            ad = "timeout old ad";
        }
        System.out.println(ad);


    }

    public static void main(String[] args) {
        RenderPageWithAd rpwa = new RenderPageWithAd();
        rpwa.renderPageWithAd();
        rpwa.exec.shutdown();
    }
}
