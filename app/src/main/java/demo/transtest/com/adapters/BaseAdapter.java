package demo.transtest.com.adapters;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import demo.transtest.com.Bean.TestBean;
import demo.transtest.com.test.R;

/**
 * @author jxy
 * @data 2020/5/8.
 */

public abstract class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.InnerHolder> {

    private OnItemClickListener mOnItemClickListener;

    protected abstract View getSubView(ViewGroup parent, int viewType);

    private final List<TestBean> mData;

    public BaseAdapter(List<TestBean> data) {
        this.mData = data;
    }

    @Override
    public InnerHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = getSubView(parent, viewType);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(InnerHolder holder, int position) {
        holder.setData(mData.get(position),position);
    }

    @Override
    public int getItemCount() {
        return mData == null ? 0 : mData.size();
    }
/******************************************************************************/
    public void setOnItemClickListener(OnItemClickListener listener) {   //3
        //设置一个监听，其实就是要设置一个接口
        this.mOnItemClickListener = listener;
    }

    /**
     * 编写回调接口
     * 1、创建接口
     * 2、定义接口内部方法
     * 3、提供设置接口的方法（外部实现）
     * 4、接口方法的调用
     */
    public interface OnItemClickListener {   //1
        void onItemClick(int position);      //2
    }
    /******************************************************************************/
    public class InnerHolder extends RecyclerView.ViewHolder {
        private ImageView iv_icon;
        private TextView tv_title;
        private int mPosition;

        public InnerHolder(View itemView) {
            super(itemView);
            //找到条目的控件
            iv_icon = itemView.findViewById(R.id.ICON);
            tv_title = itemView.findViewById(R.id.TITLE);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (null != mOnItemClickListener){
                        mOnItemClickListener.onItemClick(mPosition);//向外暴露接口
                    }
                }
            });
        }

        /**
         * 这个方法用于设置数据
         *
         * @param data
         */
        public void setData(TestBean data,int position) {
            this.mPosition = position;
            //开始设置数据
            iv_icon.setImageResource(data.icon);
            tv_title.setText(data.title);
            Log.d("jxy", ">>>>>>>>>>>>>>>>>图片：" + data.icon + "标题：" + data.title);
        }
    }
}
