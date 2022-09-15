package SimulationManager;

import Server.Server;
import Strategy.Scheduler;
import Strategy.SelectionPolicy;
import Task.Task;
import View.SimulationFrame;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class SimulationManager implements Runnable {
    private final int timeLimit;
    private final int maxProccesingTime;
    private final int minProcessingTime;
    private final int minArrivalTime;
    private final int maxArrivalTime;
    private final int numberOfClients;
    private float avgProcess;
    private float peekHour;
    private int max;
    private final Writer myWriter;


    private final Scheduler scheduler;
    private final SimulationFrame frame;
    private List<Task> generatedTasks;

    public SimulationManager(int timpSimulare, int timpProcesareMaxim, int timpProcesareMinim, int timpSosireMaxim, int timpSosireMinim,
                             int numarCozi, int numarClienti) throws IOException {
        this.timeLimit = timpSimulare;
        this.numberOfClients = numarClienti;
        this.minArrivalTime = timpSosireMinim;
        this.maxArrivalTime = timpSosireMaxim;
        this.minProcessingTime = timpProcesareMinim;
        this.maxProccesingTime = timpProcesareMaxim;
        int maxTasksPerServer = 1000;
        this.scheduler = new Scheduler(numarCozi, maxTasksPerServer);
        SelectionPolicy selectionPolicy = SelectionPolicy.SHORTEST_TIME;
        this.scheduler.changeStrategy(selectionPolicy);
        this.myWriter = new FileWriter("LogEvents.txt");
        this.max = 0;
        frame = new SimulationFrame(numarCozi);
        frame.setVisible(true);
        this.generateNRandomTasks();
    }

    public void generateNRandomTasks() {
        Random r = new Random();
        this.generatedTasks = new ArrayList<>();
        for (int i = 0; i < numberOfClients; i++)
            generatedTasks.add(new Task(r.nextInt(this.maxArrivalTime - this.minArrivalTime) + this.minArrivalTime,
                    r.nextInt(this.maxProccesingTime - this.minProcessingTime) + this.minProcessingTime));

        for (int i = 0; i < numberOfClients - 1; i++) {
            for (int j = i + 1; j < numberOfClients; j++)
                if (generatedTasks.get(i).getArrivalTime() > generatedTasks.get(j).getArrivalTime()) {
                    Task aux = generatedTasks.get(i);
                    generatedTasks.set(i, generatedTasks.get(j));
                    generatedTasks.set(j, aux);
                }
        }

        for (int i = 0; i < numberOfClients; i++)
            avgProcess += generatedTasks.get(i).getProcessingTime();

        avgProcess = avgProcess / numberOfClients;
    }

    @Override
    public void run() {

        int currentTime = 0;
        String afisareCozi;
        String clientiInAsteptare;
        while (currentTime <= timeLimit) {
            try {
                myWriter.write("Timp simulare: " + currentTime + "\n" + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            int sum1 = 0;
            for (int i = 0; i < generatedTasks.size(); i++) {
                if (generatedTasks.get(i).getArrivalTime() == currentTime) {
                    try {
                        scheduler.dispatchTask(generatedTasks.get(i));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    generatedTasks.remove(i);
                    i--;
                }
            }
            for (int i = 0; i < scheduler.getServers().size(); i++)
                sum1 += scheduler.getServers().get(i).getWaitingPeriod();

            if (max < sum1) {
                max = sum1;
                peekHour = currentTime;
            }

            frame.setTimpSimulare(String.valueOf(currentTime));
            clientiInAsteptare = "";
            for (Task generatedTask : generatedTasks) clientiInAsteptare += generatedTask.toString();
            frame.setClientiInAsteptare(clientiInAsteptare);
            try {
                myWriter.write("Clienti in asteptare: " + clientiInAsteptare + "\n" + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }

            for (int i = 0; i < scheduler.getServers().size(); i++) {
                afisareCozi = "";
                for (int j = 0; j < scheduler.getServers().get(i).getNumberOfTasks(); j++) {
                    afisareCozi += scheduler.getServers().get(i).getTasks()[j].toString();
                }
                frame.setareContinutCozi(afisareCozi, i);
                try {
                    myWriter.write("Coada " + (i + 1) + ": " + afisareCozi + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < scheduler.getServers().size(); i++) {
                if (scheduler.getServers().get(i).getNumberOfTasks() != 0) {
                    if (scheduler.getServers().get(i).getTasks()[0].getProcessingTime() != 0)
                        scheduler.getServers().get(i).getTasks()[0].decrementProcessingTime();
                }
            }
            try {
                myWriter.write("\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            currentTime++;
            if (generatedTasks.isEmpty() && scheduler.checkClear()) {
                break;
            }


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        for(int i=0;i<scheduler.getServers().size();i++)
            if(scheduler.getServers().get(i).getNumberOfTasks()!=0)
                scheduler.getServers().get(i).clear();

        afisareCozi = "Simulare terminata";
        for (int i = 0; i < scheduler.getServers().size(); i++) {
            frame.setareContinutCozi(afisareCozi, i);
            try {
                myWriter.write("Coada " + i + ": " + afisareCozi + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            myWriter.write("Simulare terminata");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        frame.setAvgTimeWait("Timp mediu de asteptare: " + (Server.getSumWait() / numberOfClients));
        frame.setAvgTimeProcess("Timp mediu de procesare: " + avgProcess);
        frame.setPeekHour("Ora de varf: " + peekHour);
        Thread.currentThread().interrupt();

    }
}
