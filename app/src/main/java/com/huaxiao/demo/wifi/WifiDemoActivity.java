package com.huaxiao.demo.wifi;

import android.content.Context;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.huaxiao.demo.R;

import java.util.List;

public class WifiDemoActivity extends AppCompatActivity {

    enum WifiEncType {
        WEP, WPA, OPEN
    }

    private WifiManager mWifiManager;
    private static final String TAG = WifiDemoActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_demo);

        mWifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        Button button = findViewById(R.id.btn_wifi_demo);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                connectWifi("小米手机", "huaxiao666", WifiEncType.WPA);
                WifiConfiguration wifiConfiguration = createWifiInfo("小米手机", "huaxiao666", WifiEncType.WPA);
                boolean status = addNetwork(wifiConfiguration);
                Log.i(TAG, "status " + status);
            }
        });
    }

    // 添加一个网络并连接
    private boolean addNetwork(WifiConfiguration wcg) {
        if (wcg == null) {
            return false;
        }
        int wcgID = mWifiManager.addNetwork(wcg);
        return mWifiManager.enableNetwork(wcgID, true);
    }

//    public void connectWifi(String targetSsid, String targetPsd, WifiEncType enc) {
//        // 1、注意热点和密码均包含引号，此处需要需要转义引号
////        String ssid = "\"" + targetSsid + "\"";
////        String psd = "\"" + targetPsd + "\"";
//
//        String ssid = targetSsid;
//        String psd = targetPsd;
//
//        //2、配置wifi信息
//        WifiConfiguration conf = new WifiConfiguration();
//        conf.SSID = ssid;
//        switch (enc) {
//            case WEP:
//                // 加密类型为WEP
//                conf.wepKeys[0] = psd;
//                conf.wepTxKeyIndex = 0;
//                conf.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
//                conf.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP40);
//                break;
//            case WPA:
//                // 加密类型为WPA
//                conf.preSharedKey = psd;
//                break;
//            case OPEN:
//                //开放网络
//                conf.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
//        }
//
//        //3、链接wifi
//        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
//        wifiManager.addNetwork(conf);
////        List<WifiConfiguration> list = wifiManager.getConfiguredNetworks();
////        for (WifiConfiguration i : list) {
////            if (i.SSID != null && i.SSID.equals(ssid)) {
////                wifiManager.disconnect();
////                wifiManager.enableNetwork(i.networkId, true);
////                wifiManager.reconnect();
////                break;
////            }
////        }
//
//        wifiManager.disconnect();
//        wifiManager.enableNetwork(conf.networkId, true);
//        wifiManager.reconnect();
//    }

    private WifiConfiguration createWifiInfo(String SSID, String Password, WifiEncType Type) {
        WifiConfiguration config = new WifiConfiguration();
        config.allowedAuthAlgorithms.clear();
        config.allowedGroupCiphers.clear();
        config.allowedKeyManagement.clear();
        config.allowedPairwiseCiphers.clear();
        config.allowedProtocols.clear();
        config.SSID = "\"" + SSID + "\"";

        //注意：在低版本可以移除，在6.0以上如果是自己的应用之前连接过，通过removeWifi()可以移除
        //但是 如果是其他应用的configrRation 那么在本应用是不可以移除的 此时 直接连接即可
        //因此会做一个判断，判断removeWifi 后集合的数量是否减少，若没有则表示没有移除成功，直接连接即可
        WifiConfiguration tempConfig = this.IsExsits(SSID);
        List<WifiConfiguration> beforeConfig = mWifiManager.getConfiguredNetworks();
        if (tempConfig != null) {
            removeWifi(tempConfig.networkId);
        }
        List<WifiConfiguration> afterConfig = mWifiManager.getConfiguredNetworks();
        if (tempConfig != null && beforeConfig.size() == afterConfig.size()) {
            return tempConfig;
        } else {
            if (Type == WifiEncType.OPEN) {  //WIFICIPHER_NOPASS
                //                config.wepKeys[0] = "";
                //                config.wepTxKeyIndex = 0;
                config.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
            }
            if (Type == WifiEncType.WEP) { //WIFICIPHER_WEP
                config.hiddenSSID = true;
                config.wepKeys[0] = "\"" + Password + "\"";
                config.allowedAuthAlgorithms.set(WifiConfiguration.AuthAlgorithm.SHARED);
                config.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP);
                config.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP);
                config.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP40);
                config.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP104);
                config.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
                config.wepTxKeyIndex = 0;
            }
            if (Type == WifiEncType.WPA) { //WIFICIPHER_WPA
                config.preSharedKey = "\"" + Password + "\"";
                config.hiddenSSID = true;
                config.allowedAuthAlgorithms.set(WifiConfiguration.AuthAlgorithm.OPEN);
                config.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP);
                config.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.WPA_PSK);
                config.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.TKIP);
                //config.allowedProtocols.set(WifiConfiguration.Protocol.WPA);
                config.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP);
                config.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.CCMP);
                config.status = WifiConfiguration.Status.ENABLED;
            }
            return config;
        }
    }

    private WifiConfiguration IsExsits(String SSID) {
        List<WifiConfiguration> existingConfigs = mWifiManager.getConfiguredNetworks();
        if (existingConfigs != null) {
            for (WifiConfiguration existingConfig : existingConfigs) {
                if (existingConfig.SSID.equals("\"" + SSID + "\"")) {
                    return existingConfig;
                }
            }
        }
        return null;
    }

    private void removeWifi(int netId) {
        disconnectWifi(netId);
        mWifiManager.removeNetwork(netId);
        mWifiManager.saveConfiguration();
    }

    // 断开指定ID的网络
    private void disconnectWifi(int netId) {
        mWifiManager.disableNetwork(netId);
        mWifiManager.disconnect();
    }

}
