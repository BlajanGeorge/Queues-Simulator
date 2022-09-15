package Strategy;

import Server.Server;
import Task.Task;

import java.util.List;

public class ConcreteStrategyTime implements Strategy {

    @Override
    public void addTask(List<Server> servers, Task t) {
        int min = servers.get(0).getWaitingPeriod();
        for (int i = 1; i < servers.size(); i++)
            if (min > servers.get(i).getWaitingPeriod())
                min = servers.get(i).getWaitingPeriod();

        for (Server server : servers)
            if (min == server.getWaitingPeriod()) {
                t.setWaitTime(min + t.getProcessingTime());
                server.addTask(t);
                break;
            }
    }


    }

