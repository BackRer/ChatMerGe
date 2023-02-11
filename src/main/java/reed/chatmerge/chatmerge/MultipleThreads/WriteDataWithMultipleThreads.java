package reed.chatmerge.chatmerge.MultipleThreads;

import reed.chatmerge.chatmerge.method;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WriteDataWithMultipleThreads {
    private int threadCount;
    private Executor executor;

    public void shutdown(){
        ((ExecutorService) executor).shutdown();
    }

    public WriteDataWithMultipleThreads(int threadCount) {
        this.threadCount = threadCount;
        this.executor = Executors.newFixedThreadPool(threadCount);
    }

    public void writeData(OutputStream outputStream, String data) {
        executor.execute(new WriteTask(outputStream, data));
    }

    private static class WriteTask implements Runnable {
        private OutputStream outputStream;
        private String data;

        public WriteTask(OutputStream outputStream, String data) {
            this.outputStream = outputStream;
            this.data = data;
        }

        @Override
        public void run() {
            try {
                outputStream.write(data.getBytes());
            } catch (IOException e) {
                method.plugin.getLogger().info(method.prefix+"§4Failed! Disconnected from the server!");
                method.ConnectInfo = false;
                //e.printStackTrace();
            }
        }

    }
}
