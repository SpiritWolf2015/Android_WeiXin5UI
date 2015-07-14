package com.gzc.weixin5ui;

import java.util.ArrayList;
import java.util.List;

import com.jauker.widget.BadgeView;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends FragmentActivity {

	private ViewPager mViewPager = null;
	private FragmentPagerAdapter mAdapter = null;
	private List<Fragment> mDatas = null;

	private TextView mTextView1;
	private TextView mTextView2;
	private TextView mTextView3;

	final String CHANGE_COLOR = "#EE0000";

	private ImageView mTabLine = null;
	/** 屏幕三分之1宽度 */
	private int mScreen1_3;
	private int mSceen;
	
	BadgeView mBadgeView = null;
	LinearLayout mLinearLayout = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		
		//去掉ActionBar，一定要放在setContentView函数前面执行，否则报错。
		requestWindowFeature(Window.FEATURE_NO_TITLE);		
		setContentView(R.layout.activity_main);

		initTabLine();
		initView();
	}

	private void initTabLine() {
		mTabLine = (ImageView) this.findViewById(R.id.id_iv_tabline);

		Display display = this.getWindowManager().getDefaultDisplay();
		DisplayMetrics outMetrics = new DisplayMetrics();
		display.getMetrics(outMetrics);
		// 得到屏幕宽度的三分之1
		mScreen1_3 = outMetrics.widthPixels / 3;
		mSceen = outMetrics.widthPixels;

		android.view.ViewGroup.LayoutParams lp = mTabLine.getLayoutParams();
		lp.width = mScreen1_3;
		Log.e("指示线", "宽度 = " + mScreen1_3);
		// 相当于在代码里设置XML界面参数
		mTabLine.setLayoutParams(lp);
	}

	private void initView() {
		
		mLinearLayout = (LinearLayout)findViewById(R.id.id_ll_chat);
		
		mTextView1 = (TextView) findViewById(R.id.id_tv_chat);
		mTextView2 = (TextView) findViewById(R.id.id_tv_friend);
		mTextView3 = (TextView) findViewById(R.id.id_tv_contact);

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
			public Fragment getItem(int location) {
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

				switch (position) {
				case 0:
					if(null != mBadgeView){
						mLinearLayout.removeView(mBadgeView);
					}
					mBadgeView = new BadgeView(MainActivity.this);
					// 设置提示数量
					mBadgeView.setBadgeCount(48);
					mLinearLayout.addView(mBadgeView);
					
					// 滑动到这个页面，改变字体颜色。
					mTextView1.setTextColor(Color.parseColor(CHANGE_COLOR));
					break;
				case 1:
					// 滑动到这个页面，改变字体颜色。
					mTextView2.setTextColor(Color.parseColor(CHANGE_COLOR));
					break;
				case 2:
					// 滑动到这个页面，改变字体颜色。
					mTextView3.setTextColor(Color.parseColor(CHANGE_COLOR));
					break;
				}
			}

			@Override
			public void onPageScrollStateChanged(int state) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void onPageScrolled(int position, float positionOffset,
					int positionOffsetPx) {

				LinearLayout.LayoutParams lp = (LayoutParams) mTabLine
						.getLayoutParams();

					lp.leftMargin = (int) (positionOffset * mScreen1_3 + position
							* mScreen1_3);
//				lp.leftMargin = (int)((position + positionOffset) * mSceen);
				Log.i("onPageScrolled", "leftMargin = "+lp.leftMargin);
				
				mTabLine.setLayoutParams(lp);
			}
		});
	}

	private void resetTextView() {
		mTextView1.setTextColor(Color.BLACK);
		mTextView2.setTextColor(Color.BLACK);
		mTextView3.setTextColor(Color.BLACK);
	}

}
