package top.xxgo;

import okhttp3.*;
import okio.BufferedSink;
import org.junit.jupiter.api.Test;

import javax.annotation.Nullable;
import java.io.IOException;

public class HystrixTest {

    @Test
    public  void request(){
        OkHttpClient okHttpClient = new OkHttpClient();



        final Request request = new Request.Builder()
                .url("http://localhost:8001/v5/test")
                .get()//默认就是GET请求，可以不写
                .build();
        long start = System.currentTimeMillis();
        System.out.println();
        try {
            for (int i = 0; i < 50; i++) {

                Call call = okHttpClient.newCall(request);

                Response execute = call.execute();
                System.out.println(execute);
                String string = execute.body().string();
                System.out.println(string);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
//        4242
//        8094

    }
    @Test
    public  void request2(){
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url("http://localhost:8001/service-b/fallbackTest?name=sssd")
                .get()//默认就是GET请求，可以不写
                .build();

        try {
            for (int i = 0; i < 2; i++) {
                Call call = okHttpClient.newCall(request);
                call.execute();
                Response execute = call.execute();
                System.out.println(execute);
                String string = String.valueOf(execute.body());
                System.out.println(string);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public  void request3(){
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url("http://localhost:8001/service-a/sen/hello")
                .get()//默认就是GET请求，可以不写
                .build();

        try {
            for (int i = 0; i < 5; i++) {
                Call call = okHttpClient.newCall(request);
                Response execute = call.execute();
                System.out.println(execute);
                String string = String.valueOf(execute.body());
                System.out.println(string);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public  void request4(){
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url("http://localhost:8001/service-a/sen/hello")
                .get()//默认就是GET请求，可以不写
                .build();
        final Request request2 = new Request.Builder()
                .url("http://localhost:8001/service-a/sen/hello2")
                .get()//默认就是GET请求，可以不写
                .build();
        try {
            for (int i = 0; i < 5; i++) {
                Call call = okHttpClient.newCall(request);
                Response execute = call.execute();
                System.out.println(execute);
                String string = String.valueOf(execute.body());
                System.out.println(string);
                okHttpClient.newCall(request2).execute();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public  void request5(){
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url("http://localhost:8001/service-a/type2/hello")
                .get()//默认就是GET请求，可以不写
                .build();
        final Request request2 = new Request.Builder()
                .url("http://localhost:8001/service-a/type2/hello2")
                .get()//默认就是GET请求，可以不写
                .build();
        try {
            for (int i = 0; i < 5; i++) {
                Call call = okHttpClient.newCall(request);
                Response execute = call.execute();
                System.out.println(execute);
                String string = String.valueOf(execute.body());
                System.out.println(string);
                okHttpClient.newCall(request2).execute();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
