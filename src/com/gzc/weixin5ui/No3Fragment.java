/**
 * 
 */
package com.gzc.weixin5ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 使用V4包的Fragment可以向下兼容SDK版本，我这就直接用V4的。
 * 注意一定要统一使用，要么都V4包，
 * 要么都是VIEW包的，不要混着用，不然会报错。
 * 
 * @author gzc
 *
 */
public class No3Fragment extends Fragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.tab3, container, false);
	}
	

}
