package chencheng.bwie.com.chencheng_shalaishuanxin.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.liaoinstan.springview.container.DefaultFooter;
import com.liaoinstan.springview.container.DefaultHeader;
import com.liaoinstan.springview.widget.SpringView;

import java.util.ArrayList;
import java.util.List;

import chencheng.bwie.com.chencheng_shalaishuanxin.MyAdapter;
import chencheng.bwie.com.chencheng_shalaishuanxin.R;
import chencheng.bwie.com.chencheng_shalaishuanxin.bean;
import chencheng.bwie.com.chencheng_shalaishuanxin.presenter.MainPresenter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener ,IMainActivity{

 boolean flag=true;
    private List<bean.DataBean> list=new ArrayList<>();
    private String name = "笔记本";
    int num = 1;
    /**
     * 搜索商品
     */
    private TextView mNutIv;
    private ImageView mImageView;
    /**
     * 请输入关键字
     */
    private EditText mEdText;
    /**
     * 搜索
     */
    private Button mBut;
    private RecyclerView mRv;
    private SpringView mSpr;
    private MyAdapter myAdapter;
  private MainPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter=new MainPresenter(this);
        String s = String.valueOf(num);
        presenter.Char(name,s);
        initView();


    }


    private void initView() {
        mNutIv = (TextView) findViewById(R.id.nut_iv);
        mImageView = (ImageView) findViewById(R.id.imageView);
        mImageView.setOnClickListener(this);
        mEdText = (EditText) findViewById(R.id.ed_text);
        mBut = (Button) findViewById(R.id.but);
        mBut.setOnClickListener(this);
        mRv = (RecyclerView) findViewById(R.id.rv);
        mSpr = (SpringView) findViewById(R.id.spr);
        setAdapter();
        mSpr.setHeader(new DefaultHeader(this));
        mSpr.setFooter(new DefaultFooter(this));
        mSpr.setListener(new SpringView.OnFreshListener() {
            @Override
            public void onRefresh() {
                presenter.Char(name,"1");
                setAdapter();
                mSpr.onFinishFreshAndLoad();
            }

            @Override
            public void onLoadmore() {
                 num++;
                String s1=String.valueOf(num);
                presenter.Char(name,s1);
                setAdapter();
                mSpr.onFinishFreshAndLoad();
            }
        });
    }

    private void setAdapter() {
        if (myAdapter==null){
            mRv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
            myAdapter=new MyAdapter(list,MainActivity.this,flag);
            mRv.setAdapter(myAdapter);
            myAdapter.notifyDataSetChanged();
        }else{
            myAdapter.notifyDataSetChanged();

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView:
                if (flag==false){
                    flag=true;
                    mImageView.setImageResource(R.drawable.lv_icon);
                    mRv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
                    myAdapter=new MyAdapter(list,MainActivity.this,flag);
                    mRv.setAdapter(myAdapter);
                    myAdapter.notifyDataSetChanged();
                }else{
                    flag =false;
                    mImageView.setImageResource(R.drawable.grid_icon);
                    mRv.setLayoutManager(new GridLayoutManager(this,2));
                    myAdapter=new MyAdapter(list,MainActivity.this,flag);
                    mRv.setAdapter(myAdapter);
                    myAdapter.notifyDataSetChanged();
                }
                break;
            case R.id.but:
                if(!TextUtils.isEmpty(mEdText.getText().toString())) {
                    Toast.makeText(MainActivity.this,mEdText.getText().toString(), Toast.LENGTH_SHORT).show();
                    presenter.Char(mEdText.getText().toString(), "1");
                    setAdapter();
                }
                break;
        }
    }

    @Override
    public void showRV(List<bean.DataBean> data) {
        for(int i=0;i<data.size();i++){
            list.addAll(data);
        }
        setAdapter();

    }
}
