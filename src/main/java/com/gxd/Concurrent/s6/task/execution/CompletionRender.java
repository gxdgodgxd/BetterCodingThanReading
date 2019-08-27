package com.gxd.Concurrent.s6.task.execution;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by gxdgodgxd on 18/1/16.
 */
public class CompletionRender {

    private static final int nThreads = 3;

    ExecutorService exec = Executors.newFixedThreadPool(nThreads);

    public void renderPage(String source) {
        final List<String> imageUrls = Arrays.asList(source.split(","));
        CompletionService<Data> completionService = new ExecutorCompletionService<Data>(exec);
        for (String imageUrl : imageUrls) {
            completionService.submit(new Callable<Data>() {
                @Override
                public Data call() throws Exception {
                    Random r = new Random();
                    long l = r.nextInt(10000);
                    Thread.sleep(l);
                    return new Data(imageUrl + " data, time : " + l);
                }
            });

        }

        //render text
        System.out.println("text");
        for (int i = 0; i < imageUrls.size(); i++) {
            try {
                Future<Data> f = completionService.take();
                Data data = f.get();
                System.out.println(data);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String source = "abc,def,ghi";
        CompletionRender cr = new CompletionRender();
        cr.renderPage(source);
        cr.exec.shutdown();
    }
}
