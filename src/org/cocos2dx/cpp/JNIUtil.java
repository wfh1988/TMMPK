package org.cocos2dx.cpp;

import org.cocos2dx.lib.Cocos2dxActivity;
import org.cocos2dx.lib.Cocos2dxGLSurfaceView;

import android.app.AlertDialog;
import android.content.DialogInterface;

import com.ltkpmm2015821.LTKP_MM317;
import com.qn.jackcat.R;
public class JNIUtil {
	private static LTKP_MM317 _act;

	public final static int LIMIT_GIFT = 0;
	public final static int NEW_GIFT = 1;
	public final static int CHOOSE_TYPE=2;
	public final static int LITTLE_GOLD_GIFT_6=3;
	public final static int BIG_GOLD_GIFT_10=4;
	public final static int SUPER_GOLD_GIFT=5;
	public final static int DEBLOCK_PET_GIFT=6;
	public final static int BRONZE_GIFT_10=7;
	//非法值
	public final static int SILVER_GIFT = 8;
	public final static int GOLD_GIFT=9;
	public final static int ADD_HEART3_10=10;
	public final static int ADD_HEART10=11;
	public final static int SHIELD_GIFT=12;
	public final static int REVERSE_GIFT=13;
	public final static int LOGIN_GIFT=14;
	public final static int PASS_GIFT=15;

	private static final int WY_POINTID = 70281125;//微云计费点id


	public static void init(LTKP_MM317 act) {
		_act = act;
//		QN.WY_PRICE_ID = WY_POINTID;
//		QN.getInstance(act).initSdks(act);

	}
	public static boolean isDistinct(){//清晰模糊开关
//		if(QN.GLOBAL_CLEAR_TIPS_TOGGLE == 1)
//			return true;
//		else
		return true;
	}

	public static void pay(final int id) {

		_act.adMobManager.showAdByTag(id);


		/*
		//runNativePaySucceedCallback(id);  //默认支付成功

		LocalPayInfo localInfo = new LocalPayInfo();
		switch (id) {
		case LIMIT_GIFT:
			localInfo.dmPointId = "ujgszkfe27xm6ov4pk5zAli3";
			localInfo.lmPointId = "002053";
			localInfo.zzPointId = "23580";
			localInfo.yyPointId = "1";
			localInfo.tkPointId = "0201";
			localInfo.payMsg="限时送礼";
			localInfo.money=2000;
			localInfo.jzfPointId = 70117770;
			localInfo.xmPointId = 6299;
			localInfo.xzfPointId = "GAGGAA00F0AF";
			localInfo.yzfPointId = "7";
			break;

		case NEW_GIFT:
			localInfo.dmPointId = "fbum48xvmpyuguewc1em5nqr";
			localInfo.lmPointId = "002053";
			localInfo.zzPointId = "23581";
			localInfo.yyPointId = "2";
			localInfo.tkPointId = "0202";
			localInfo.payMsg="新手礼包";
			localInfo.money=2000;
			localInfo.jzfPointId = 70345420;
			localInfo.xmPointId = 6300;
			localInfo.xzfPointId = "GAF0A00GGYFG";
			localInfo.yzfPointId = "7";
			break;


		case CHOOSE_TYPE:
			localInfo.dmPointId = "logcBofc2EfloxhkEqfhBvc6";
			localInfo.lmPointId = "002053";
			localInfo.zzPointId = "23582";
			localInfo.yyPointId = "3";
			localInfo.tkPointId = "0203";
			localInfo.payMsg="挑战进击模式/经典模式";
			localInfo.money=2000;
			localInfo.jzfPointId = 70778960;
			localInfo.xmPointId = 6301;
			localInfo.xzfPointId = "GAGFFGF0A0AF";
			localInfo.yzfPointId = "7";
			break;


		case LITTLE_GOLD_GIFT_6:
			localInfo.dmPointId = "lvgrozmfC8nembrE6oabjhcD";
			localInfo.lmPointId = "002051";
			localInfo.zzPointId = "23583";
			localInfo.yyPointId = "4";
			localInfo.tkPointId = "0061";
			localInfo.payMsg="金币小宝箱";
			localInfo.money=600;
			localInfo.jzfPointId = 70949407;
			localInfo.xmPointId = 6302;
			localInfo.xzfPointId = "GAF0AAGFAYG0";
			localInfo.yzfPointId = "3";
			break;

		case BIG_GOLD_GIFT_10:
			localInfo.dmPointId = "pDtCbxkB3655e4qciplidz68";
			localInfo.lmPointId = "002052";
			localInfo.zzPointId = "23584";
			localInfo.yyPointId = "5";
			localInfo.tkPointId = "0101";
			localInfo.payMsg="金币大宝箱";
			localInfo.money=1000;
			localInfo.jzfPointId = 70647932;
			localInfo.xmPointId = 6303;
			localInfo.xzfPointId = "GAF00FYYG0FY";
			localInfo.yzfPointId = "5";
			break;
		case SUPER_GOLD_GIFT:
			localInfo.dmPointId = "zxjE8mx0tbcBf14tD2oovs60";
			localInfo.lmPointId = "002053";
			localInfo.zzPointId = "23585";
			localInfo.yyPointId = "6";
			localInfo.tkPointId = "0204";
			localInfo.payMsg="超级金币宝箱";
			localInfo.money=2000;
			localInfo.jzfPointId = 70264431;
			localInfo.xmPointId = 6304;
			localInfo.xzfPointId = "GAF0YAYF0AYF";
			localInfo.yzfPointId = "7";
			break;

		case DEBLOCK_PET_GIFT:
			localInfo.dmPointId = "45qlgd6u84Cejazhw4ua2tEs";
			localInfo.lmPointId = "002053";
			localInfo.zzPointId = "23586";
			localInfo.yyPointId = "7";
			localInfo.tkPointId = "0205";
			localInfo.payMsg="解锁小宠物";
			localInfo.money=2000;
			localInfo.jzfPointId = 70765122;
			localInfo.xmPointId = 6305;
			localInfo.xzfPointId = "GAGGFFGA0YFF";
			localInfo.yzfPointId = "7";
			break;
		case BRONZE_GIFT_10:
			localInfo.dmPointId = "nn76s31hx99ooeuhD41Cklj1";
			localInfo.lmPointId = "002052";
			localInfo.zzPointId = "23587";
			localInfo.yyPointId = "8";
			localInfo.tkPointId = "0102";
			localInfo.payMsg="铜牌礼包";
			localInfo.money=1000;
			localInfo.jzfPointId = 70429152;
			localInfo.xmPointId = 6306;
			localInfo.xzfPointId = "GAGFGG0YAFAF";
			localInfo.yzfPointId = "5";
			break;
		case SILVER_GIFT:
			localInfo.dmPointId = "04Cwy5gi6fvrmh4EEDp31jyt";
			localInfo.lmPointId = "002053";
			localInfo.zzPointId = "23588";
			localInfo.yyPointId = "9";
			localInfo.tkPointId = "0206";
			localInfo.payMsg="银牌礼包";
			localInfo.money=2000;
			localInfo.jzfPointId = 70292692;
			localInfo.xmPointId = 6307;
			localInfo.xzfPointId = "GAGFGG0YAFAF";
			localInfo.yzfPointId = "7";
			break;
		case GOLD_GIFT:
			localInfo.dmPointId = "bvpEww6Bwa7Aqe0s472pjsz7";
			localInfo.lmPointId = "002053";
			localInfo.zzPointId = "23589";
			localInfo.yyPointId = "10";
			localInfo.tkPointId = "0207";
			localInfo.payMsg="金牌大礼包";
			localInfo.money=2000;
			localInfo.jzfPointId = 70998791;
			localInfo.xmPointId = 6308;
			localInfo.xzfPointId = "GAGFFFYAFF0A";
			localInfo.yzfPointId = "7";
			break;
		case ADD_HEART3_10:
			localInfo.dmPointId = "ce53aj85n7Bw87Bzctnm69ps";
			localInfo.lmPointId = "002052";
			localInfo.zzPointId = "23590";
			localInfo.yyPointId = "11";
			localInfo.tkPointId = "0103";
			localInfo.payMsg="补充爱心*3";
			localInfo.money=1000;
			localInfo.jzfPointId = 70429603;
			localInfo.xmPointId = 6309;
			localInfo.xzfPointId = "GAGGGYGYGGG0";
			localInfo.yzfPointId = "5";
			break;
		case ADD_HEART10:
			localInfo.dmPointId = "sA1BAhsi6hDBe17e130eqDgt";
			localInfo.lmPointId = "002053";
			localInfo.zzPointId = "23591";
			localInfo.yyPointId = "12";
			localInfo.tkPointId = "0208";
			localInfo.payMsg="补充爱心*10";
			localInfo.money=2000;
			localInfo.jzfPointId = 70736017;
			localInfo.xmPointId = 6310;
			localInfo.xzfPointId = "GAGFGAFFGAGG";
			localInfo.yzfPointId = "7";
			break;
		case SHIELD_GIFT:
			localInfo.dmPointId = "Abnxj7wih172vt1ned1kl8nx";
			localInfo.lmPointId = "002053";
			localInfo.zzPointId = "23592";
			localInfo.yyPointId = "13";
			localInfo.tkPointId = "0209";
			localInfo.payMsg="护盾大礼包";
			localInfo.money=2000;
			localInfo.jzfPointId = 70363707;
			localInfo.xmPointId = 6311;
			localInfo.xzfPointId = "GAF0A00AY0AG";
			localInfo.yzfPointId = "7";
			break;
		case REVERSE_GIFT:
			localInfo.dmPointId = "51sn138wfuhqd46508pADp9f";
			localInfo.lmPointId = "002053";
			localInfo.zzPointId = "23593";
			localInfo.yyPointId = "14";
			localInfo.tkPointId = "0210";
			localInfo.payMsg="原地复活";
			localInfo.money=2000;
			localInfo.jzfPointId = 70196012;
			localInfo.xmPointId = 6312;
			localInfo.xzfPointId = "GAF0YG0YAAGF";
			localInfo.yzfPointId = "7";
			break;
		case LOGIN_GIFT:
			localInfo.dmPointId = "xc38xjjz74luaizjEEfhq2cl";
			localInfo.lmPointId = "002053";
			localInfo.zzPointId = "23594";
			localInfo.yyPointId = "15";
			localInfo.tkPointId = "0211";
			localInfo.payMsg="登陆奖励5倍";
			localInfo.money=2000;
			localInfo.jzfPointId = 70254628;
			localInfo.xmPointId = 6313;
			localInfo.xzfPointId = "GAGFYFFAGFAF";
			localInfo.yzfPointId = "7";
			break;
		case PASS_GIFT:
			localInfo.dmPointId = "9w4qi9kCnjzzmtasgl4isnnC";
			localInfo.lmPointId = "002053";
			localInfo.zzPointId = "23595";
			localInfo.yyPointId = "16";
			localInfo.tkPointId = "0212";
			localInfo.payMsg="跳过关卡";
			localInfo.money=2000;
			localInfo.jzfPointId = 70315045;
			localInfo.xmPointId = 6314;
			localInfo.xzfPointId = "GAGFFYAYFG0G";
			localInfo.yzfPointId = "7";
			break;
		default:
			break;
		}

		localInfo.tag = id;
		localInfo.ztPointId = "0000031001";
		localInfo.wyPointId = WY_POINTID;


		int money = localInfo.money;

		localInfo.desc = "购买此产品需" + money / 100
				+ "元，由运营商代收（不含通讯费）， 客服电话：4006571610";

		QN.getInstance(_act).pay(_act, localInfo);
		//runNativePaySucceedCallback(id);

		//runNativeCallback(id);
		QN.getInstance(_act).setPayResultCallback(new PayResultCallback() {

			@Override
			public void payResultCallback(LocalPayInfo info, int payState) {
				if (payState == QN.PAY_SUCCESS) {
					runNativePaySucceedCallback(id);
				} else {
					runNativeCallback(id);
				}
			}
		});
	*/

	}



	//原生方法，调用c++的paySucceed和payFail
	public native static void paySucceed();
	public native static void payFail();
	public static native void notFinishGame();



	public static void runNativePaySucceedCallback(final int id) {
		Cocos2dxGLSurfaceView.getInstance().queueEvent(new Runnable() {
			@Override
			public void run() {
				paySucceed();
			}
		});
	}
	public static void runNativeCallback(final int id) {
		Cocos2dxGLSurfaceView.getInstance().queueEvent(new Runnable() {
			@Override
			public void run() {
				payFail();
			}
		});
	}



	public static void finishGame() {
		_act.runOnUiThread(new Runnable() {
			@Override
			public void run() {


				new AlertDialog.Builder(_act)
						.setTitle(R.string.title)
						.setMessage(R.string.content)
						.setNegativeButton(R.string.concel,
								new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog,
														int which) {
										_act.runOnGLThread(new Runnable() {

											@Override
											public void run() {
												notFinishGame();
											}
										});
									}
								})
						.setPositiveButton(R.string.confirm,
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
														int whichButton) {
										_act.finish();
										System.exit(0);
									}
								}).show();

			}

		});
	}


}
