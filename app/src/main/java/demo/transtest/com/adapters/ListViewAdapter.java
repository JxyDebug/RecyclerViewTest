package demo.transtest.com.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import demo.transtest.com.Bean.TestBean;
import demo.transtest.com.test.R;

/**
 * @author jxy
 * @data 2020/5/7.
 */

public class ListViewAdapter extends BaseAdapter {
    @Override
    protected View getSubView(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_list_view, null);
        return view;
    }

    public ListViewAdapter(List<TestBean> data) {
        super(data);

    }

}
