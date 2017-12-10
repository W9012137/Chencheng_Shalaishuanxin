package chencheng.bwie.com.chencheng_shalaishuanxin;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

/**
 * Created by dell on 2017/12/9.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration imageLoaderConfiguration=new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader.getInstance().init(imageLoaderConfiguration);
    }
}
