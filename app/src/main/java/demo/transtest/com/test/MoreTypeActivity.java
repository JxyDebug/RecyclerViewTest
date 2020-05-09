package demo.transtest.com.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import demo.transtest.com.Bean.Datas;
import demo.transtest.com.Bean.MoreTypeBean;
import demo.transtest.com.adapters.MoreTypeAdapter;

public class MoreTypeActivity extends AppCompatActivity {
    private static final String TAG = "MoreTypeActivity";
    private List<MoreTypeBean> mData;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_type);

        recyclerView = findViewById(R.id.more_type_list);
        //准备数据
        mData = new ArrayList<>();
        initData();
        //创建和设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //创建适配器
        MoreTypeAdapter adapter = new MoreTypeAdapter();
        recyclerView.setAdapter(adapter);
    }

    private void initData() {
        Random random = new Random();
        for (int i = 0; i < Datas.icons.length; i++) {
            MoreTypeBean data = new MoreTypeBean();
            data.pic = Datas.icons[i];
            data.type = random.nextInt(3);
            mData.add(data);
        }
    }
}
