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
 * ʹ��V4����Fragment�������¼���SDK�汾�������ֱ����V4�ġ�
 * ע��һ��Ҫͳһʹ�ã�Ҫô��V4����
 * Ҫô����VIEW���ģ���Ҫ�����ã���Ȼ�ᱨ��
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
