package ua.artcode.week4.home;

import java.io.File;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.TemporalAccessor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by serhii on 10.06.16.
 */
public class FileSearch {
    public static void main(String[] args) {

        String searchName = "Cont";
        String searchName2 = "master";
        File root1 = new File(".");
        File root2 = new File(".");

        RecursiveSearcher recursiveSearcher = new RecursiveSearcher();

        ExecutorService service = Executors.newFixedThreadPool(2);


        Future future = service.submit(new SearchThread(root1, searchName, recursiveSearcher));
        Future future1 = service.submit(new SearchThread(root2, searchName2, recursiveSearcher));


        service.shutdown();
        while (!service.isTerminated()) {
            try {
                service.awaitTermination(1000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long sec1 = System.currentTimeMillis();
    }

}

class RecursiveSearcher {

    public void searchFile(File root, String searchedName) {
        File[] files = root.listFiles();

        if (root.getName().contains(searchedName)) {
            System.out.println(root.getName());
        }

        if (files == null || files.length == 0) {
            return;
        }

        for (File file : files) {
            if (file.getName().contains(searchedName)) {
                System.out.println("This is your file" + file.getName());
            }

            if (file.isDirectory()) {
                searchFile(root, searchedName);
            }
        }
    }
}

class SearchThread extends Thread implements Runnable {

    private File fileRoot;
    private String name;
    private RecursiveSearcher container;

    public SearchThread(File fileRoot, String name, RecursiveSearcher recursiveSearcher) {
        this.fileRoot = fileRoot;
        this.name = name;
        this.container = recursiveSearcher;
    }

    @Override
    public void run() {
        container.searchFile(fileRoot, name);
    }
}

