package multithreading;

import java.util.concurrent.*;

import static org.junit.Assert.fail;

public class RunnerFactory {
    ExecutorService executorService;

    public void asd() throws ExecutionException, InterruptedException {
        executorService = Executors.newFixedThreadPool(10);
        Future<String> future = executorService.submit(() -> {
            System.exit(1);
            return "a";
        });

        future.get();
    }
}
