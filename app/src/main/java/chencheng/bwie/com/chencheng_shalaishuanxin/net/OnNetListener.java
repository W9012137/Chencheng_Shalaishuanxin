package chencheng.bwie.com.chencheng_shalaishuanxin.net;

/**
 * Created by dell on 2017/12/9.
 */

public interface OnNetListener<T> {
    //成功
    public void onSuccess(String str);


    public void onSuccess(T t);
//失败

    public void onFailure(Exception e);
}
