package chencheng.bwie.com.chencheng_shalaishuanxin.net;

import java.util.Map;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by dell on 2017/12/9.
 */

public class HttpUtils {
    private static HttpUtils httpUtils;
    private final OkHttpClient client;

    private HttpUtils(){
        client = new OkHttpClient.Builder()
                .addInterceptor(new MyInterceptor())
                .build();
    }
    public static HttpUtils getHttpUtils(){
        if (httpUtils==null){
            synchronized (HttpUtils.class){
                if (httpUtils==null){
                    httpUtils=new HttpUtils();
                }
            }
        }
        return httpUtils;
    }
    /**
     * GET  请求
     *
     * @param url      请求的地址
     * @param callback
     */
    public void doGet(String url, Callback callback) {

        //2.创建一个Request
        Request request = new Request.Builder().url(url).build();
        //3.发送请求
        client.newCall(request).enqueue(callback);
    }
    public void doPost(String url, Map<String, String> params, Callback callback) {
        //2.创建一个请求
        FormBody.Builder builder = new FormBody.Builder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            builder.add(entry.getKey(), entry.getValue());
        }
        FormBody formBody = builder.build();
        Request request = new Request.Builder().url(url).post(formBody).build();
        //发送请求
        client.newCall(request).enqueue(callback);
    }

}
