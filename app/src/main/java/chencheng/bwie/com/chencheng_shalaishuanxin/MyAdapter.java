package chencheng.bwie.com.chencheng_shalaishuanxin;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

/**
 * Created by dell on 2017/12/10.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<bean.DataBean> list;
    private Context context;
    boolean flag=true;

    public MyAdapter(List<bean.DataBean> list, Context context, boolean flag) {
        this.list = list;
        this.context = context;
        this.flag = flag;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (flag){
            View view=View.inflate(context,R.layout.linealayout,null);
            return new ViewOne(view);
        }else{
            View view=View.inflate(context,R.layout.grouplayout,null);
            return new ViewTwo(view);
        }

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
         if (flag){
             if (holder instanceof ViewOne){
                 ViewOne holder1= (ViewOne) holder;
                 holder1.text1.setText(list.get(position).getTitle());
                 holder1.text2.setText(list.get(position).getPrice()+"");
                 String[] split = list.get(position).getImages().split("\\|");
                 ImageLoader.getInstance().displayImage(split[0],holder1.iv);
             }else{
                 if (holder instanceof ViewTwo) {
                     ViewTwo holder1 = (ViewTwo) holder;
                     holder1.text1.setText(list.get(position).getTitle());
                     holder1.text2.setText(list.get(position).getPrice() + "");
                     String[] split = list.get(position).getImages().split("\\|");
                     ImageLoader.getInstance().displayImage(split[0], holder1.iv);
                 }
                 }
         }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    class ViewOne extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView text1,text2;
        public ViewOne(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            text1=itemView.findViewById(R.id.textView);
            text2=itemView.findViewById(R.id.textView2);
        }
    }
    class ViewTwo extends RecyclerView.ViewHolder{
        ImageView iv;
        TextView text1,text2;
        public ViewTwo(View itemView) {
            super(itemView);
            iv=itemView.findViewById(R.id.iv);
            text1=itemView.findViewById(R.id.textView4);
            text2=itemView.findViewById(R.id.textView5);
        }
    }
}
