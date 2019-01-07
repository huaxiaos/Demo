package com.huaxiao.demo.retrofit;

import com.huaxiao.demo.annotation.BindGet;
import com.huaxiao.demo.utils.LogUtils;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by sunhuaxiao on 2019/1/7.
 */
public class RetrofitManager {

    private static volatile RetrofitManager mInstance;
    private BaseRetrofitService mBaseRetrofitService;
    private Map<String, String> mHostMap = new HashMap<>();

    public static RetrofitManager getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitManager.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitManager();
                }
            }
        }

        return mInstance;
    }

    public RetrofitManager() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HostSelectionInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://www.v2ex.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mBaseRetrofitService = createService(retrofit, BaseRetrofitService.class);
        setHostMap(BaseRetrofitService.class);
    }

    private <T> T createService(Retrofit retrofit, Class<T> service) {
        setHostMap(service);
        return retrofit.create(service);
    }

    public Map<String, String> getHostMap() {
        return mHostMap;
    }

    private void setHostMap(Class<?> service) {
        Method[] methods = service.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Domain.class)) {
                Domain domain = method.getAnnotation(Domain.class);
                String value = domain.value();
                LogUtils.i("huaxiao", "domain value " + value);
            }
        }
    }

    public void test() {
        Call<V2EXBean> call = mBaseRetrofitService.getV2EX("python");
        call.enqueue(new Callback<V2EXBean>() {
            @Override
            public void onResponse(Call<V2EXBean> call, Response<V2EXBean> response) {
                LogUtils.i("huaxiao", "response " + response.body().header);
            }

            @Override
            public void onFailure(Call<V2EXBean> call, Throwable t) {
                LogUtils.i("huaxiao", "response fail " + t.getMessage());
            }
        });
    }

}
