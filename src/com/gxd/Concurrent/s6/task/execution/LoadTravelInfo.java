package com.gxd.Concurrent.s6.task.execution;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by gxdgodgxd on 18/1/16.
 */
public class LoadTravelInfo {

    ExecutorService exec = Executors.newFixedThreadPool(10);

    public List<Data> getDataInfo(String source) throws InterruptedException {
        List<String> urls = Arrays.asList(source.split(","));
        List<Callable<Data>> tasks = new ArrayList<>();
        for (String url : urls) {
            tasks.add(new Callable<Data>() {
                @Override
                public Data call() throws Exception {
                    Random r = new Random();
                    long l = r.nextInt(10000);
                    Thread.sleep(l);
                    return new Data(url + " data, time : " + l);
                }
            });
        }
        List<Future<Data>> futures = exec.invokeAll(tasks, 3, TimeUnit.SECONDS);

        List<Data> data = new ArrayList<>(urls.size());
        Iterator<String> iter = urls.iterator();
        for (Future<Data> future : futures) {
            String url = iter.next();
            try {
                data.add(future.get());
            } catch (ExecutionException e) {
                data.add(new Data("exec exception : " + url));
            } catch (CancellationException e) {
                data.add(new Data("cancel exception : " + url));
            }
        }
        return data;
    }

    public static void main(String[] args) throws InterruptedException {
        String source = "abc,def,ghi";
        LoadTravelInfo lti = new LoadTravelInfo();
        List<Data> dataInfo = lti.getDataInfo(source);
        for (Data data : dataInfo) {
            System.out.println(data);
        }
        lti.exec.shutdown();
    }


}
