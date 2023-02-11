package reed.chatmerge.chatmerge.MultipleThreads;

import org.bukkit.Bukkit;
import reed.chatmerge.chatmerge.method;

import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReadDataWithMultipleThreads {
    private ExecutorService executorService;
    public ReadDataWithMultipleThreads(int threadCount){
        this.executorService = Executors.newFixedThreadPool(threadCount);
    }
    public void readData(InputStream inputStream){
        if (method.ConnectInfo){
            executorService.submit(new ReadTask(inputStream));
        }else {
            shutdown();
        }

    }
    public void shutdown(){
        executorService.shutdown();
    }
    private static class ReadTask implements Runnable{
        private InputStream inputStream;

        public ReadTask(InputStream inputStream) {
            this.inputStream = inputStream;
        }

        @Override
        public void run() {
            byte[] bytes = new byte[1024];
            int len = 0;
            try{
                while ((len = inputStream.read(bytes))!=-1){
                    String s = new String(bytes,0,len);
                    //System.out.println("Received message: " + s);
                    Bukkit.broadcastMessage(s);
                }



            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try{
                    inputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }


        }
    }
}
