package com.example.bfmemiao.myapplication.mvp;

import com.example.bfmemiao.myapplication.Constant;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.http.conn.ssl.AllowAllHostnameVerifier;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by huangjunhui on 2017/3/1.17:13
 */
public abstract class RetrofitUtils {

    public static Retrofit mRetrofit;
    /**
     * 获取Retrofit对象
     *
     * @return
     */
    protected static Retrofit getRetrofit() {

        if (null == mRetrofit) {
            //Retrofit2后使用build设计模式
            Gson gson = new GsonBuilder().setLenient().create();
            mRetrofit = new Retrofit.Builder()
                    //设置服务器路径
                    .baseUrl(Constant.URL)
                    .client(client())
                    //添加转化库，默认是Gson
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    //添加回调库，采用RxJava
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
        }

        return mRetrofit;
    }
    private static final long TIMEOUT = 5 * 1000;
    private static OkHttpClient client(){
        LauncherTrust launcherTrust = new LauncherTrust();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(TIMEOUT, TimeUnit.MILLISECONDS)
                .sslSocketFactory(sslSocketFactory(launcherTrust))
                .hostnameVerifier(new AllowAllHostnameVerifier())
                .build();
        return okHttpClient;
    }



    static class LauncherTrust implements X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

        }
        @Override
        public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {

        }
        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    private static SSLSocketFactory sslSocketFactory(LauncherTrust launcherTrust){

        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null,new TrustManager[]{launcherTrust},new SecureRandom());
            return sslContext.getSocketFactory();
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }
        return null;
    }
}
