package com.ltkpmm2015821;

import android.app.Activity;
import android.os.Handler;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import org.cocos2dx.cpp.JNIUtil;

public class AdMobManager implements RewardedVideoAdListener {

    private static AdMobManager instance;
    private RewardedVideoAd mRewardedVideoAd;
    private InterstitialAd mInterstitialAd;
    private Activity _act;
    private int currentTag;
    public static AdMobManager getInstance(Activity act) {
        if(instance == null) {
            instance = new AdMobManager(act);
        }
        return instance;
    }

    private AdMobManager(Activity act) {
        _act = act;

//        MobileAds.initialize(act, "ca-app-pub-3940256099942544~3347511713");//test
        MobileAds.initialize(act, "ca-app-pub-1180600649063291~9282994937");

        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(_act);
        mRewardedVideoAd.setRewardedVideoAdListener(this);
        loadRewardedVideoAd();


        mInterstitialAd = new InterstitialAd(_act);
        //mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");//test
        mInterstitialAd.setAdUnitId("ca-app-pub-1180600649063291/6219973049");
//        loadInstAd();
    }
    private void loadRewardedVideoAd() {
//        mRewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917", new AdRequest.Builder().build());//test
      mRewardedVideoAd.loadAd("ca-app-pub-1180600649063291/5856005379", new AdRequest.Builder().build());
    }

//    private void loadInstAd() {
//        mInterstitialAd.loadAd(new AdRequest.Builder().build());
//        mInterstitialAd.setAdListener(new AdListener() {
//            @Override
//            public void onAdLoaded() {
//                super.onAdLoaded();
//                //mInterstitialAd.show();
//            }
//
//            @Override
//            public void onAdClicked() {
//                super.onAdClicked();
//
//
//            }
//
//            @Override
//            public void onAdOpened() {
//                super.onAdOpened();
//                JNIUtil.runNativePaySucceedCallback(currentTag);
//            }
//
//            @Override
//            public void onAdClosed() {
//                super.onAdClosed();
//                loadInstAd();
//
//            }
//
//            @Override
//            public void onAdFailedToLoad(int i) {
//                super.onAdFailedToLoad(i);
//                Toast.makeText(_act, "inst fail " + i, Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    public void showAdByTag(int tag) {
        currentTag = tag;
//        String adid = "";
//        switch (tag) {
//            case JNIUtil.LIMIT_GIFT://限时礼包
//                adid = "ca-app-pub-1180600649063291/6867782252";
//                break;
//
//            case JNIUtil.NEW_GIFT://新手礼包
//                adid = "ca-app-pub-1180600649063291/5856005379";
//                break;
//
//
//            case JNIUtil.CHOOSE_TYPE://游戏模式选择
//                adid = "ca-app-pub-1180600649063291/7638740777";
//                break;
//
//
//            case JNIUtil.LITTLE_GOLD_GIFT_6://金币小宝箱
//                adid = "ca-app-pub-1180600649063291/3122864978";
//                break;
//
//            case JNIUtil.BIG_GOLD_GIFT_10://金币大宝箱
//                adid = "ca-app-pub-1180600649063291/9598565998";
//                break;
//            case JNIUtil.SUPER_GOLD_GIFT://超级金币宝箱
//                adid = "ca-app-pub-1180600649063291/2152564088";
//                break;
//
//            case JNIUtil.DEBLOCK_PET_GIFT://解锁小宠物
//                adid = "ca-app-pub-1180600649063291/1397755736";
//                break;
//            case JNIUtil.BRONZE_GIFT_10://铜牌礼包
//                adid = "ca-app-pub-1180600649063291/9003793333";
//                break;
//            case JNIUtil.SILVER_GIFT://银牌礼包
//                adid = "ca-app-pub-1180600649063291/2274733459";
//                break;
//            case JNIUtil.GOLD_GIFT://金牌大礼包
//                adid = "ca-app-pub-1180600649063291/9080934512";
//                break;
//            case JNIUtil.ADD_HEART3_10://补充爱心*3
//                adid = "ca-app-pub-1180600649063291/2709724010";
//                break;
//            case JNIUtil.ADD_HEART10://补充爱心*10
//                adid = "ca-app-pub-1180600649063291/9717985492";
//                break;
//            case JNIUtil.SHIELD_GIFT://护盾大礼包
//                adid = "ca-app-pub-1180600649063291/6289197751";
//                break;
//            case JNIUtil.REVERSE_GIFT://原地复活
//                adid = "ca-app-pub-1180600649063291/5637341504";
//                break;
//            case JNIUtil.LOGIN_GIFT://登陆奖励5倍
//                adid = "ca-app-pub-1180600649063291/2553132725";
//                break;
//            case JNIUtil.PASS_GIFT://跳过关卡
//                adid = "ca-app-pub-1180600649063291/9291567942";
//                break;
//            default:
//                break;
//        }


        //去展示广告
//        mRewardedVideoAd.loadAd(adid,
//                new AdRequest.Builder().build());
        _act.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(mRewardedVideoAd.isLoaded()) {
                    mRewardedVideoAd.show();
                } else {
                    Toast.makeText(_act, "VIDEOS IS NOT READY ", Toast.LENGTH_SHORT).show();
                    loadRewardedVideoAd();
//                    if(mInterstitialAd.isLoaded()) {
//                        mInterstitialAd.show();
//                    } else {
//                        Toast.makeText(_act, "inst ad not load ", Toast.LENGTH_SHORT).show();
//                        loadInstAd();
//                    }
                }
            }
        });


    }



    @Override
    public void onRewardedVideoAdLoaded() {

        //mRewardedVideoAd.show();
    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {
        loadRewardedVideoAd();
    }

    @Override
    public void onRewarded(RewardItem reward) {
//        Toast.makeText(_act, "onRewarded! currency: " + reward.getType() + "  amount: " +
//                reward.getAmount(), Toast.LENGTH_SHORT).show();
        JNIUtil.runNativePaySucceedCallback(currentTag);
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
//        Toast.makeText(_act, "reward fail " + i, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoCompleted() {

    }
}
