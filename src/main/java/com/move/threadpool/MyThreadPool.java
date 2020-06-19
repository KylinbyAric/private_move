package com.move.threadpool;

import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description: TODO
 * @author: wu yang
 * @create: 2020-06-18 13:53
 */
public class MyThreadPool {
    //难点：工作线程的复用、多线程的一致性、顺序性问题

    //池子
    private HashSet<Worker> pool = new HashSet<Worker>();
    private final int poolMaxSize;
    private final int corePoolMaxSize;

    //等待队列
     BlockingQueue<Runnable> blockedQueue  = new LinkedBlockingDeque<Runnable>();
    private final int queueMaxSize;
    static volatile AtomicInteger count = new AtomicInteger();
    //工作线程实体
    class Worker implements Runnable {
        Runnable task;
        final Thread thread;

        Worker(Runnable firstTask) {
            task = firstTask;
            thread = new Thread(this);
        }

        @Override
        public void run() {
            while (!blockedQueue.isEmpty()) {
                try {
                    System.out.println(Thread.currentThread().getName() + "     " + count.addAndGet(1));
                    task.run();
                    task = blockedQueue.take();
                    blockedQueue.remove(task);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }


            }
        }

    }

    public void addWorker(Runnable task) {
        Worker worker = new Worker(task);
        pool.add(worker);
        worker.thread.start();
    }

    public void execute(Runnable task) {
        if (pool.size() < corePoolMaxSize) {
            addWorker(task);
        } else if (blockedQueue.size() < queueMaxSize) {
            try{
                blockedQueue.put(task);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        } else if (pool.size() < poolMaxSize) {
            addWorker(task);
        }
    }

    public MyThreadPool(int corePoolMaxSize, int poolMaxSize, int queueMaxSize) {
        this.poolMaxSize = poolMaxSize;
        this.corePoolMaxSize = corePoolMaxSize;
        this.queueMaxSize = queueMaxSize;
    }

    public static void main(String[] args) {
        MyThreadPool threadPool = new MyThreadPool(2, 10, 100);
        int i=0;
        for ( i = 0; i < 6000; i++) {
            final String target = "任务" + i;
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "  正在处理" + target);
                }
            });

        }
        System.out.println(i);
        System.out.println(MyThreadPool.count.addAndGet(0));
    }
}
