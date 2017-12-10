package chencheng.bwie.com.chencheng_shalaishuanxin.model;


import chencheng.bwie.com.chencheng_shalaishuanxin.bean;
import chencheng.bwie.com.chencheng_shalaishuanxin.net.OnNetListener;

/**
 * Created by dell on 2017/12/9.
 */

public interface ICharModel {
    public void PostChar(String keywords, String page, OnNetListener<bean> onNetListener);
}
