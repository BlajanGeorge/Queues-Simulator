package Server;

import Task.Task;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable {
    private final BlockingQueue<Task> tasks;
    private final AtomicInteger waitingPeriod;
    private static float sumWait = 0;

    public Server(int maxTasksPerServer) {
        tasks = new ArrayBlockingQueue<>(maxTasksPerServer);
        waitingPeriod = new AtomicInteger();
    }

    public void addTask(Task newTask) {
        tasks.offer(newTask);
        waitingPeriod.addAndGet(newTask.getProcessingTime());
    }

    @Override
    public void run() {
        while (true) {
            if (!tasks.isEmpty()) {
                int x = tasks.peek().getProcessingTime();
                if (tasks.peek() != null) {
                    sumWait += tasks.peek().getWaitTime();
                }
                try {
                    Thread.sleep((x * 1000L));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tasks.poll();
                waitingPeriod.addAndGet((-x));
            }
        }
    }

    public Task[] getTasks() {
        Task[] passArray = new Task[tasks.size()];
        tasks.toArray(passArray);
        return passArray;
    }

    public int getWaitingPeriod() {
        return waitingPeriod.get();
    }

    public int getNumberOfTasks() {
        return tasks.size();
    }

    public static float getSumWait() {
        return sumWait;
    }

    public void clear()
    {
        tasks.clear();
    }

}
