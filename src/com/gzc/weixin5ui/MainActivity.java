package com.gzc.weixin5ui;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

	private ViewPager mViewPager = null;
	private FragmentPagerAdapter mAdapter = null;
	private List<Fragment> mDatas = null;
	
	private TextView mTextView1;
	private TextView mTextView2;
	private TextView mTextView3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
	}

	private void initView() {
		mTextView1 = (TextView)findViewById(R.id.id_tv_chat);
		mTextView2 = (TextView)findViewById(R.id.id_tv_friend);
		mTextView3 = (TextView)findViewById(R.id.id_tv_contact);		
		
		mViewPager = (ViewPager) findViewById(R.id.id_viewpager);
		No1Fragment tab1 = new No1Fragment();
		No2Fragment tab2 = new No2Fragment();
		No3Fragment tab3 = new No3Fragment();

		mDatas = new ArrayList<Fragment>();
		mDatas.add(tab1);
		mDatas.add(tab2);
		mDatas.add(tab3);

		mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

			@Override
			public android.support.v4.app.Fragment getItem(int location) {
				return mDatas.get(location);
			}

			@Override
			public int getCount() {
				return mDatas.size();
			}

		};
		// 设置适配器
		this.mViewPager.setAdapter(mAdapter);

		mViewPager.setOnPageChangeListener(new OnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				resetTextView();
				
				switch(position){
				case 0:
					// 滑动到这个页面，改变字体颜色。
					mTextView1.setTextColor(Color.parseColor("#EE0000"));
					break;
				case 1:
					// 滑动到这个页面，改变字体颜色。
					mTextView2.setTextColor(Color.parseColor("#EE0000"));
					break;
				case 2:
					// 滑动到这个页面，改变字体颜色。
					mTextView3.setTextColor(Color.parseColor("#EE0000"));
					break;
				}
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO 自动生成的方法存根

			}
		});
	}
	
	private void resetTextView(){
		mTextView1.setTextColor(Color.BLACK);
		mTextView2.setTextColor(Color.BLACK);
		mTextView3.setTextColor(Color.BLACK);
	}

}
