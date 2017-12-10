package chencheng.bwie.com.chencheng_shalaishuanxin.presenter;


import chencheng.bwie.com.chencheng_shalaishuanxin.bean;
import chencheng.bwie.com.chencheng_shalaishuanxin.model.CharModel;
import chencheng.bwie.com.chencheng_shalaishuanxin.model.ICharModel;
import chencheng.bwie.com.chencheng_shalaishuanxin.net.OnNetListener;
import chencheng.bwie.com.chencheng_shalaishuanxin.view.IMainActivity;

/**
 * Created by dell on 2017/12/9.
 */

public class MainPresenter {
    private IMainActivity iMainActivity;
    private final ICharModel iCharModel;

    public MainPresenter(IMainActivity iMainActivity){
        this.iMainActivity=iMainActivity;
        iCharModel = new CharModel();
    }
    public void Char(String key,String page){
        iCharModel.PostChar(key, page, new OnNetListener<bean>() {
            @Override
            public void onSuccess(String str) {

            }

            @Override
            public void onSuccess(bean bean) {
               iMainActivity.showRV(bean.getData());
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
 }
