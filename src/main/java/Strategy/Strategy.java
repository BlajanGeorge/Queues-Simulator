package Strategy;

import Server.Server;
import Task.Task;

import java.util.List;

public interface Strategy {
    void addTask(List<Server> servers, Task t) throws InterruptedException;
}
