package com.gxd.Concurrent.s6.task.execution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by gxdgodgxd on 18/1/16.
 */
public class FutureRenderer {

    ExecutorService exec = Executors.newFixedThreadPool(1);

    public void renderPage(String source) {
        final List<String> imageUrls = Arrays.asList(source.split(","));
        FutureTask<List<Data>> task = new FutureTask<List<Data>>(new Callable<List<Data>>() {
            @Override
            public List<Data> call() throws Exception {
                List<Data> data = new ArrayList<>();
                for (int i = 0; i < imageUrls.size() ; i++){
                    data.add(new Data(imageUrls.get(i)+"data"));
                }
                return data;
            }
        });
        exec.submit(task);

        //render text
        System.out.println("text");
        //render image
        try {
            List<Data> data = task.get();
            for (int i = 0; i < data.size(); i++) {
                System.out.println(data.get(i));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String source = "abc,def,ghi";
        FutureRenderer fr = new FutureRenderer();
        fr.renderPage(source);
    }
}
