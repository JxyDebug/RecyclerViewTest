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
 * @data 2020/5/8.
 */

public class GridViewAdapter extends BaseAdapter {

    @Override
    protected View getSubView(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_gird_view, null);
        return view;
    }

    public GridViewAdapter(List<TestBean> data) {
      super(data);
    }


}
