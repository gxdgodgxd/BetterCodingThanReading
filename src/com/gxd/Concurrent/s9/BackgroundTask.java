package com.gxd.Concurrent.s9;

import java.util.concurrent.*;

/**
 * Created by gxdgodgxd on 18/2/2.
 */
public abstract class BackgroundTask<V> implements RunnableFuture<V> {

    private final FutureTask<V> task = new FutureTask<V>(new Callable<V>() {
        @Override
        public V call() throws Exception {
            return BackgroundTask.this.compute();
        }
    }) {
        @Override
        protected void done() {
            V v = null;
            boolean cancelled = false;
            Throwable throwable = null;
            try {
                v = task.get();
            } catch (CancellationException e) {
                cancelled = true;
            } catch (InterruptedException e) {
                throwable = e;
            } catch (ExecutionException e) {
                throwable = e.getCause();
            } finally {
                onCompletion(v, cancelled, throwable);
            }
        }
    };

    @Override
    public void run() {
        this.task.run();
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return this.task.cancel(mayInterruptIfRunning);
    }

    @Override
    public boolean isCancelled() {
        return this.task.isCancelled();
    }

    @Override
    public boolean isDone() {
        return this.task.isDone();
    }

    @Override
    public V get() throws InterruptedException, ExecutionException {
        return this.task.get();
    }

    @Override
    public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.task.get(timeout, unit);
    }

    public abstract V compute() throws InterruptedException;

    public abstract void onCompletion(V v, boolean cancelled, Throwable throwable);

}
