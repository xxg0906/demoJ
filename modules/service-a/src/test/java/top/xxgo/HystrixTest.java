package top.xxgo;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.jupiter.api.Test;

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
            for (int i = 0; i < 10; i++) {
                Call call = okHttpClient.newCall(request);
                Response execute = call.execute();
                System.out.println(execute);
                String string = execute.body().string();
                System.out.println(string);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
//        4242
//        8094

    }@Test
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
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
