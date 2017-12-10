package chencheng.bwie.com.chencheng_shalaishuanxin.model;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;

import chencheng.bwie.com.chencheng_shalaishuanxin.bean;
import chencheng.bwie.com.chencheng_shalaishuanxin.net.HttpUtils;
import chencheng.bwie.com.chencheng_shalaishuanxin.net.OnNetListener;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by dell on 2017/12/9.
 */

public class CharModel implements ICharModel {
    Handler handler=new Handler(Looper.getMainLooper());
    @Override
    public void PostChar(String keywords, String page,  final OnNetListener<bean> onNetListener) {
          String url="http://120.27.23.105/product/searchProducts?keywords="+keywords+"&page="+page;
        HttpUtils.getHttpUtils().doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                       String str=response.body().string();
                final bean bean = new Gson().fromJson(str, bean.class);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        onNetListener.onSuccess(bean);
                        Log.i("TAG",bean+"");
                    }
                });
            }
        });
    }
}
