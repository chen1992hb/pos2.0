package com.lcpay.pos.feature.ui.activity.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.lcpay.pos.R;
import com.lcpay.pos.db.util.DaoUtils;
import com.lcpay.pos.db.util.PersonHelper;
import com.lcpay.pos.feature.adapter.HomeFragmentPageAdapter;
import com.lcpay.pos.feature.adapter.SimpleFragmentPagerAdapter;
import com.lcpay.pos.feature.ui.activity.base.BaseActivity;
import com.lcpay.pos.feature.ui.fragment.home.InputFeeFragment;
import com.lcpay.pos.model.database.sample.Person;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/*
* 热更新需要执行代码
*  TinkerInstaller.onReceiveUpgradePatch(getApplicationContext(),
 *  Environment.getExternalStorageDirectory().getAbsolutePath() + "/patch_signed_7zip.apk");
 *  下载的文件路径，不一定要使用apk为后缀名
* */
public class MainActivity extends BaseActivity {

  @BindView(R.id.viewpager)
  ViewPager vpContent;


  @Override
  protected int getLayoutId() {
    return R.layout.activity_main;
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    ButterKnife.bind(this);
    setupView();

    DaoUtils.init(this); // 绑定数据库的context
    PersonHelper person = DaoUtils.getPerson();
    //操作数据库
    Person insertdata = new Person();
    insertdata.setId(null);//设置null会自增，没有设置默认为null
    person.insertObject(insertdata);
    Person personById = person.getPersonById(1L);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    DaoUtils.getPerson().CloseDataBase();//使用完毕可以在onDestory中选择关闭
  }

  private void setupView() {
    List<Fragment> mFragmentList = new ArrayList<>();
    mFragmentList.add(new InputFeeFragment());

    vpContent.setAdapter(new HomeFragmentPageAdapter(getSupportFragmentManager(), mFragmentList));
    vpContent.setCurrentItem(1);

    TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
    tabLayout.setupWithViewPager(vpContent);
    tabLayout.setTabMode(TabLayout.MODE_FIXED);
  }
}
