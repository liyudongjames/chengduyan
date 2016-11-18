package bwf.chengduyan.net;


import com.alibaba.fastjson.JSON;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.HashMap;
import java.util.Map;

import bwf.chengduyan.entity.SplashInfo;
import bwf.chengduyan.utils.APIUtils;
import bwf.chengduyan.utils.LogUtils;
import bwf.chengduyan.utils.ToastUtil;
import okhttp3.Call;

/**
 * Created by Lizhangfeng on 2016/7/13 0013.
 * Description:
 */
public class HttpHelper {

    public static void getData() {

        OkHttpUtils.get().url(Act.ad).build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ToastUtil.showToast(response);
                        LogUtils.e("服务器返回结果: " + response);
                        SplashInfo info = JSON.parseObject(response, SplashInfo.class);
                        LogUtils.e("bean: " + info.toString());

                    }
                });

    }

    public static void login(String mobile,String pwd) {

        HashMap<String, String> params = new HashMap<>();
        params.put("username", mobile);
        params.put("password", pwd);

        OkHttpUtils.get().url(Act.login)
                .addHeader("X-PASSPORT-APITOKEN", APIUtils.getXPassportApitoken(params))
                .params(params)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ToastUtil.showToast(response);
                        LogUtils.e("服务器返回结果: " + response);

                    }
                });

    }

    public static void checkUserName(String phone) {

        HashMap<String, String> params = new HashMap<>();
        params.put("field", "mobile");
        params.put("value", phone);

        OkHttpUtils.get().url(Act.checkUserName)
                .addHeader("X-PASSPORT-APITOKEN", APIUtils.getXPassportApitoken(params))
                .params(params)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ToastUtil.showToast(response);
                        LogUtils.e("服务器返回结果: " + response);

                    }
                });

    }

    public static void getSms(String phone) {
        HashMap<String, String> params = new HashMap<>();
        params.put("type", "signup");//type = 0 为signup(注册) type = 1 为verify(验证)
        params.put("mobile", phone);

        OkHttpUtils.get().url(Act.getSms)
                .addHeader("X-PASSPORT-APITOKEN", APIUtils.getXPassportApitoken(params))
                .params(params)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ToastUtil.showToast(response);
                        LogUtils.e("服务器返回结果: " + response);

                    }
                });

    }

    public static void checkCode(String phone,String code) {
        HashMap<String, String> params = new HashMap<>();
        params.put("type", "signup");//type = 0 为signup(注册) type = 1 为verify(验证)
        params.put("mobile", phone);
        params.put("verify_code", code);

        OkHttpUtils.post().url(Act.checkCode)
                .addHeader("X-PASSPORT-APITOKEN", APIUtils.getXPassportApitoken(params))
                .params(params)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ToastUtil.showToast(response);
                        LogUtils.e("服务器返回结果: " + response);

                    }
                });

    }


    public static void setPassword(String mobile,String pwd,String code) {
        HashMap<String, String> params = new HashMap<>();
        params.put("mobile", mobile);
        params.put("password", pwd);
        params.put("verify_code", code);

        OkHttpUtils.get().url("https://passport.4c.cn/api/v1//signup?")
                .addHeader("X-PASSPORT-APITOKEN", APIUtils.getXPassportApitoken(params))
                .params(params)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ToastUtil.showToast(response);
                        LogUtils.e("服务器返回结果: " + response);

                    }
                });

    }


    public static void getResult(Map params) {

        OkHttpUtils.post().url("http://hui.17house.com/svc/payment-facade/housekeep/listBuildingSiteTrackByProgress")
                .params(params)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e, int id) {

                    }

                    @Override
                    public void onResponse(String response, int id) {
                        ToastUtil.showToast(response);
                        LogUtils.e("服务器返回结果: " + response);

                    }
                });

    }

}
