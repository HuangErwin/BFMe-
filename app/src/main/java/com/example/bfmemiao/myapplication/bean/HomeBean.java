package com.example.bfmemiao.myapplication.bean;

import java.util.List;

/**
 * Created by BFMe.miao on 2018/1/23.
 */

public class HomeBean{


    /**
     * homeData : {"topBanner":[{"ImageUrl":"http://img01.baifomi.com//Storage/Plat/Weixin/SlidAd/36760c51d1bd37c8.jpg","Url":"http://m.baifomi.com/m/topic/detail/394","Type":1},{"ImageUrl":"http://img01.baifomi.com//Storage/Plat/Weixin/SlidAd/9203e9d8a5e59191.jpg","Url":"http://m.baifomi.com/topic/detail/415","Type":1},{"ImageUrl":"http://img01.baifomi.com//Storage/Plat/Weixin/SlidAd/538e5dfd82325659.jpg","Url":"http://m.baifomi.com/Page/243.html","Type":1},{"ImageUrl":"http://img01.baifomi.com//Storage/Plat/Weixin/SlidAd/d1b06671529ec00d.jpg","Url":"http://m.baifomi.com/topic/detail/417","Type":1},{"ImageUrl":"http://img01.baifomi.com//Storage/Plat/Weixin/SlidAd/5ec7e7763a8134dc.jpg","Url":"http://m.baifomi.com/topic/detail/418","Type":1}],"product":[],"category":[{"ImageUrl":"http://img01.baifomi.com//Storage/Plat/UGCTopicCate/110/3300e9e6b3234124.jpg","TopicId":110,"Title":"美妆","ParticipateCount":61},{"ImageUrl":"http://img01.baifomi.com//Storage/Plat/UGCTopicCate/117/43aede96962f12ec.jpg","TopicId":117,"Title":"健康","ParticipateCount":14},{"ImageUrl":"http://img01.baifomi.com//Storage/Plat/UGCTopicCate/115/d2e9357267a4491c.jpg","TopicId":115,"Title":"旅游","ParticipateCount":7},{"ImageUrl":"http://img01.baifomi.com//Storage/Plat/UGCTopicCate/120/ff9a3218d632911a.jpg","TopicId":120,"Title":"母婴","ParticipateCount":6}],"bottonBanner":[{"ImageUrl":"http://img01.baifomi.com//a95748f9a731a0e0.jpg","Url":"http://m.baifomi.com/Page/218.html","Type":1}]}
     */

    private HomeDataBean homeData;

    public HomeDataBean getHomeData() {
        return homeData;
    }

    public void setHomeData(HomeDataBean homeData) {
        this.homeData = homeData;
    }

    public static class HomeDataBean {
        private List<TopBannerBean> topBanner;
        private List<String> product;
        private List<CategoryBean> category;
        private List<BottonBannerBean> bottonBanner;

        public List<TopBannerBean> getTopBanner() {
            return topBanner;
        }

        public void setTopBanner(List<TopBannerBean> topBanner) {
            this.topBanner = topBanner;
        }

        public List<String> getProduct() {
            return product;
        }

        public void setProduct(List<String> product) {
            this.product = product;
        }

        public List<CategoryBean> getCategory() {
            return category;
        }

        public void setCategory(List<CategoryBean> category) {
            this.category = category;
        }

        public List<BottonBannerBean> getBottonBanner() {
            return bottonBanner;
        }

        public void setBottonBanner(List<BottonBannerBean> bottonBanner) {
            this.bottonBanner = bottonBanner;
        }

        public static class TopBannerBean {
            /**
             * ImageUrl : http://img01.baifomi.com//Storage/Plat/Weixin/SlidAd/36760c51d1bd37c8.jpg
             * Url : http://m.baifomi.com/m/topic/detail/394
             * Type : 1
             */

            private String ImageUrl;
            private String Url;
            private int Type;

            public String getImageUrl() {
                return ImageUrl;
            }

            public void setImageUrl(String ImageUrl) {
                this.ImageUrl = ImageUrl;
            }

            public String getUrl() {
                return Url;
            }

            public void setUrl(String Url) {
                this.Url = Url;
            }

            public int getType() {
                return Type;
            }

            public void setType(int Type) {
                this.Type = Type;
            }
        }

        public static class CategoryBean {
            /**
             * ImageUrl : http://img01.baifomi.com//Storage/Plat/UGCTopicCate/110/3300e9e6b3234124.jpg
             * TopicId : 110
             * Title : 美妆
             * ParticipateCount : 61
             */

            private String ImageUrl;
            private int TopicId;
            private String Title;
            private int ParticipateCount;

            public String getImageUrl() {
                return ImageUrl;
            }

            public void setImageUrl(String ImageUrl) {
                this.ImageUrl = ImageUrl;
            }

            public int getTopicId() {
                return TopicId;
            }

            public void setTopicId(int TopicId) {
                this.TopicId = TopicId;
            }

            public String getTitle() {
                return Title;
            }

            public void setTitle(String Title) {
                this.Title = Title;
            }

            public int getParticipateCount() {
                return ParticipateCount;
            }

            public void setParticipateCount(int ParticipateCount) {
                this.ParticipateCount = ParticipateCount;
            }
        }

        public static class BottonBannerBean {
            /**
             * ImageUrl : http://img01.baifomi.com//a95748f9a731a0e0.jpg
             * Url : http://m.baifomi.com/Page/218.html
             * Type : 1
             */

            private String ImageUrl;
            private String Url;
            private int Type;

            public String getImageUrl() {
                return ImageUrl;
            }

            public void setImageUrl(String ImageUrl) {
                this.ImageUrl = ImageUrl;
            }

            public String getUrl() {
                return Url;
            }

            public void setUrl(String Url) {
                this.Url = Url;
            }

            public int getType() {
                return Type;
            }

            public void setType(int Type) {
                this.Type = Type;
            }
        }
    }
}
