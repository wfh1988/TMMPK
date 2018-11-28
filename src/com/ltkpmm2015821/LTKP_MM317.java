/****************************************************************************
 Copyright (c) 2010-2011 cocos2d-x.org

 http://www.cocos2d-x.org

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 THE SOFTWARE.
 ****************************************************************************/
package com.ltkpmm2015821;

import org.cocos2dx.cpp.JNIUtil;
import org.cocos2dx.lib.Cocos2dxActivity;
import org.cocos2dx.lib.Cocos2dxGLSurfaceView;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class LTKP_MM317 extends Cocos2dxActivity {
	private Handler handler = new Handler();

//	private Mr mgr;

	public AdMobManager adMobManager;
	protected void onCreate(Bundle savedInstanceState) {
//		DecRawso.NewInstance(this, handler, true);
//		System.load(DecRawso.GetInstance().GetPath("cocos2dcpp"));
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);

		// 禁止锁屏
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		// 音量调节（为了区分开铃声的音量）
		setVolumeControlStream(AudioManager.STREAM_MUSIC);
		// JniTestHelper.init(this, this);
		// MobileAgent.init(this, "300008835893", "0000000000");
		JNIUtil.init(this);


		// 初始化广告
		String channel = "";
		try {
			ApplicationInfo appInfo = getPackageManager().getApplicationInfo(getPackageName(),
					PackageManager.GET_META_DATA);
			channel = appInfo.metaData.getString("UMENG_CHANNEL");
		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
		}
//		mgr = Mr.getInstance(this, "1810b16ebf0f46adad73b1e1a613150c", channel + "-01");

		adMobManager = AdMobManager.getInstance(this);


	}

	@Override
	protected void onStop() {
		super.onStop();

//		mgr.showRemind();
	}

	public Cocos2dxGLSurfaceView onCreateView() {
		Cocos2dxGLSurfaceView glSurfaceView = new Cocos2dxGLSurfaceView(this);
		// LTKP_MM317 should create stencil buffer
		glSurfaceView.setEGLConfigChooser(5, 6, 5, 0, 16, 8);

		return glSurfaceView;
	}

	static {

		// System.load(DecRawso.GetInstance().GetPath("cocos2dcpp"));
		System.loadLibrary("cocos2dcpp");
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
//		UMGameAgent.onResume(this);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
//		UMGameAgent.onPause(this);
	}

}
