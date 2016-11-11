package completionService;


import org.apache.commons.io.IOUtils;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class UsingCompletionService {

    private static int howManyDownloads = 200;

    private static long time = -1;

    public void doIt() throws InterruptedException {
        timeBegin();

        try {
            Executor executor = Executors.newFixedThreadPool(100);
            CompletionService<String> completionService =
                    new ExecutorCompletionService<String>(executor);

            for (int i = 0; i < howManyDownloads; i++) {
                completionService.submit(new WebDownloader(getUrl()));
            }

            int received = 0;
            boolean errors = false;

            while (received < howManyDownloads && !errors) {
                Future<String> resultFuture = completionService.take();
                try {
                    String result = resultFuture.get();
                    System.out.println(result);
                    received++;

                } catch (Exception e) {
                    errors = true;
                }
            }
        } finally {
            timeEnd();
        }
    }

    private void timeBegin() {
        time = System.currentTimeMillis();
    }

    private void timeEnd() {
        long current = System.currentTimeMillis();

        long elapsed = current - time;

        double elapsedInSeconds = (elapsed / 1000.0);

        System.out.println("Total time: " + elapsedInSeconds);
    }

    private List<String> list = new ArrayList() {{
        add("http://www.google.com");
        add("http://stackoverflow.com/questions/5034370/retrieving-a-random-item-from-arraylist");
        add("http://stackoverflow.com/questions/19348248/waiting-on-a-list-of-future");
        add("http://stackoverflow.com/questions/6306132/java-thread-pool-with-a-bounded-queue");
        add("https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/ThreadPoolExecutor.html");
    }};

    private String getUrl() {
        return list.get(ThreadLocalRandom.current().nextInt(list.size()));
    }

    private class WebDownloader implements Callable<String> {

        private String url;

        public WebDownloader(String url) {
            this.url = url;
        }

        @Override
        public String call() throws Exception {
            return IOUtils.toString(new URL(url).openStream());
        }
    }


}
