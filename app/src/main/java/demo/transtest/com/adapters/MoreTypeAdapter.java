package demo.transtest.com.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import demo.transtest.com.Bean.MoreTypeBean;

/**
 * @author jxy
 * @data 2020/5/9.
 */

public class MoreTypeAdapter extends RecyclerView.Adapter {
    //定义三个常量，因为有三种类型
    private static final int TYPE_FULL_IMAGE = 0;
    private static final int TYPE_LEFT_IMAGE = 2;
    private static final int TYPE_THREE_IMAGE = 2;
    private final List<MoreTypeBean> mData;

    public MoreTypeAdapter(List<MoreTypeBean> data) {
        this.mData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return null == mData ? 0 : mData.size();
    }
    //我们要复写一个方法，这个方法是根据条件来返回条目

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
