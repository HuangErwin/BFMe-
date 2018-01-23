package com.example.bfmemiao.myapplication.bean;

/**
 * Created by BFMe.miao on 2018/1/23.
 */

public class BaseBean {

    /**
     * ErrCode : 0
     * ResponseMsg : success
     * Data : {"homeData":{"topBanner":[{"ImageUrl":"http://img01.baifomi.com//Storage/Plat/Weixin/SlidAd/36760c51d1bd37c8.jpg","Url":"http://m.baifomi.com/m/topic/detail/394","Type":1},{"ImageUrl":"http://img01.baifomi.com//Storage/Plat/Weixin/SlidAd/9203e9d8a5e59191.jpg","Url":"http://m.baifomi.com/topic/detail/415","Type":1},{"ImageUrl":"http://img01.baifomi.com//Storage/Plat/Weixin/SlidAd/538e5dfd82325659.jpg","Url":"http://m.baifomi.com/Page/243.html","Type":1},{"ImageUrl":"http://img01.baifomi.com//Storage/Plat/Weixin/SlidAd/d1b06671529ec00d.jpg","Url":"http://m.baifomi.com/topic/detail/417","Type":1},{"ImageUrl":"http://img01.baifomi.com//Storage/Plat/Weixin/SlidAd/5ec7e7763a8134dc.jpg","Url":"http://m.baifomi.com/topic/detail/418","Type":1}],"product":[],"category":[{"ImageUrl":"http://img01.baifomi.com//Storage/Plat/UGCTopicCate/110/3300e9e6b3234124.jpg","TopicId":110,"Title":"美妆","ParticipateCount":61},{"ImageUrl":"http://img01.baifomi.com//Storage/Plat/UGCTopicCate/117/43aede96962f12ec.jpg","TopicId":117,"Title":"健康","ParticipateCount":14},{"ImageUrl":"http://img01.baifomi.com//Storage/Plat/UGCTopicCate/115/d2e9357267a4491c.jpg","TopicId":115,"Title":"旅游","ParticipateCount":7},{"ImageUrl":"http://img01.baifomi.com//Storage/Plat/UGCTopicCate/120/ff9a3218d632911a.jpg","TopicId":120,"Title":"母婴","ParticipateCount":6}],"bottonBanner":[{"ImageUrl":"http://img01.baifomi.com//a95748f9a731a0e0.jpg","Url":"http://m.baifomi.com/Page/218.html","Type":1}]}}
     */

    private String ErrCode;
    private String ResponseMsg;
    private String Data;

    public String getErrCode() {
        return ErrCode;
    }

    public void setErrCode(String ErrCode) {
        this.ErrCode = ErrCode;
    }

    public String getResponseMsg() {
        return ResponseMsg;
    }

    public void setResponseMsg(String ResponseMsg) {
        this.ResponseMsg = ResponseMsg;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

}
