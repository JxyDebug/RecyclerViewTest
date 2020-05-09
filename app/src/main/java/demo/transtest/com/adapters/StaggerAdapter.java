package demo.transtest.com.adapters;

import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import demo.transtest.com.Bean.TestBean;
import demo.transtest.com.test.R;

/**
 * @author jxy
 * @data 2020/5/9.
 */

public class StaggerAdapter extends BaseAdapter {
    public StaggerAdapter(List<TestBean> data) {
        super(data);
    }

    @Override
    protected View getSubView(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_stagger_view, null);
        return view;
    }
}
