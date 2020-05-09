package demo.transtest.com.test;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import demo.transtest.com.Bean.Datas;
import demo.transtest.com.Bean.TestBean;
import demo.transtest.com.adapters.BaseAdapter;
import demo.transtest.com.adapters.GridViewAdapter;
import demo.transtest.com.adapters.ListViewAdapter;
import demo.transtest.com.adapters.StaggerAdapter;

/**
 * 总结:
 * 1、首先我们要有控件,这个RecyclerView它呢是在V7包下的,所以我们要打开这个 Module settings里的依赖,
 * 添加RecyclerView的依赖,这样子才能在布局文件里使用RecyclerView这个控件。
 * 2、通过findViewById找到控件
 * 3、准备好数据
 * 4、设置布局管理器
 * 5、就是创建适配器
 * 6、设置适配器
 * 7、数据就可以现实出来了
 */
public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView mList;
    private ArrayList<TestBean> mData;
    private BaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mList = findViewById(R.id.rl_list);

        initData();
        showList(true, true);

    }

    private void initListener() {
        adapter.setOnItemClickListener(new BaseAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                //这里处理条目点击事件
                Toast.makeText(MainActivity.this, "您点击了" + position + "个条目", Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initData() {
        //List<DataBea>---->Adapter------>setAdapter------>显示数据。
        //创建数据集合
        mData = new ArrayList<>();
        //创建模拟数据
        for (int i = 0; i < Datas.icons.length; i++) {
            //创建数据对象
            TestBean data = new TestBean();
            data.icon = Datas.icons[i];
            data.title = "我是第 " + i + " 个条目";
            //添加到集合里头
            mData.add(data);
        }
        Log.d(TAG, "===============" + mData.toString());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId();

        switch (itemId) {
            //ListView的部分
            case R.id.list_view_vertical_stander:
                Log.d(TAG, "点击了ListView里头的垂直标准");
                showList(true, false);
                break;
            case R.id.list_view_vertical_reverse:
                Log.d(TAG, "点击了ListView里头的垂直反向");
                showList(true, true);
                break;
            case R.id.list_view_horizontal_stander:
                Log.d(TAG, "点击了ListView里头的水平标准");
                showList(false, false);
                break;
            case R.id.list_view_horizontal_reverse:
                Log.d(TAG, "点击了ListView里头的水平反向");
                showList(false, true);
                break;

            //GridView部分
            case R.id.grid_view_vertical_stander:
                showGrid(true, false);
                break;
            case R.id.grid_view_vertical_reverse:
                showGrid(true, true);
                break;
            case R.id.grid_view_horizontal_stander:
                showGrid(false, false);
                break;
            case R.id.grid_view_horizontal_reverse:
                showGrid(false, true);
                break;

            //瀑布流部分
            case R.id.stagger_view_vertical_stander:
                showStagger(true, false);
                break;
            case R.id.stagger_view_vertical_reverse:
                showStagger(true, true);
                break;
            case R.id.stagger_view_horizontal_stander:
                showStagger(false, false);
                break;
            case R.id.stagger_view_horizontal_reverse:
                showStagger(false, true);
                break;

            // 多种条目类型被点击了
            case R.id.more_type:

                //跳到一个新的Activity里面去实现这个功能
                Intent intent = new Intent(this, MoreTypeActivity.class);
                startActivity(intent);
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    //实现瀑布流效果
    private void showStagger(boolean isVertical, boolean isReverse) {
        //准备布局管理器
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, isVertical ? StaggeredGridLayoutManager.VERTICAL : StaggeredGridLayoutManager.HORIZONTAL);
        //设置管理器方向
        layoutManager.setReverseLayout(isReverse);
        //设置布局管理器到Recycler里面
        mList.setLayoutManager(layoutManager);
        //创建适配器
        adapter = new StaggerAdapter(mData);
        mList.setAdapter(adapter);
        initListener();
    }

    private void showList(boolean isVertical, boolean isReverse) {
        //RecyclerView需要设置样式，其实就是设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //设置水平还是垂直
        linearLayoutManager.setOrientation(isVertical ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL);
        //设置正向还是反向
        linearLayoutManager.setReverseLayout(isReverse);

        mList.setLayoutManager(linearLayoutManager);
        //创建适配器
        adapter = new ListViewAdapter(mData);
        mList.setAdapter(adapter);
        initListener();
    }

    /**
     * 这个方法用于实现和GridView一样的效果
     */
    private void showGrid(boolean isVertical, boolean isReverse) {

        //创建布局管理器
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        //设置水平还是垂直
        layoutManager.setOrientation(isVertical ? GridLayoutManager.VERTICAL : GridLayoutManager.HORIZONTAL);
        //设置标准(正向)还是反向的
        layoutManager.setReverseLayout(isReverse);

        //设置布局管理器
        mList.setLayoutManager(layoutManager);

        //创建适配器
        adapter = new GridViewAdapter(mData);

        //设置适配器
        mList.setAdapter(adapter);

        //初始化事件
        initListener();
    }

}
