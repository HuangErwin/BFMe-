package com.example.bfmemiao.myapplication.bean;

import java.util.List;

/**
 * Created by BFMe.miao on 2018/1/24.
 */

public class TalkBean {

    private List<TopicsListBean> TopicsList;

    public List<TopicsListBean> getTopicsList() {
        return TopicsList;
    }

    public void setTopicsList(List<TopicsListBean> TopicsList) {
        this.TopicsList = TopicsList;
    }

    public static class TopicsListBean {
        /**
         * Id : 783
         * ImageUrl : http://img01.baifomi.com//Storage/UGC/Member/55004/783/f11bb57b8e1f9168_350.jpg
         * ImageWidth : 0
         * ImageHeight : 0
         * UserId : 0
         * EncryptUserId : dvcRd3DpsGX6oWpIoWMFCzlxDFnXGG2jZ907eoKyhIHtftDMzjiBVgSX4gY6Xf0GMOeUQtfneGrwwzFp8scwTVmZPPr0uY4zO0tfYOcevk5apNzjF50+iF6eIY8L0dCmUGynsNnlTvxGUSAKlm/Yj1E23PCeZEKWeHEFL5DiE8R9pLCELbCba0WU6eVbXxnbGL3xqfGuXgnGZPGPfxi2jL9hpYjPhnki+9dti80w+mgMVciSzfsvzbPiAA5kI90deHTWzk5DCgyl+orGeg7hfUFmQNU8mwlFsMCd9dDpG3t80qshGTECIwMMPegYqo6dBZrkeNMva6UjKkofFt0EZg==
         * UserName : s
         * UserImage : http://img01.baifomi.com//Storage/Member/55004/ce83d8817e9dd676.jpeg
         * Content :   曼谷市中心的路边摊档，T
         * ParseCount : 0
         * IsPrase : 0
         */

        private int Id;
        private String ImageUrl;
        private int ImageWidth;
        private int ImageHeight;
        private int UserId;
        private String EncryptUserId;
        private String UserName;
        private String UserImage;
        private String Content;
        private int ParseCount;
        private int IsPrase;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getImageUrl() {
            return ImageUrl;
        }

        public void setImageUrl(String ImageUrl) {
            this.ImageUrl = ImageUrl;
        }

        public int getImageWidth() {
            return ImageWidth;
        }

        public void setImageWidth(int ImageWidth) {
            this.ImageWidth = ImageWidth;
        }

        public int getImageHeight() {
            return ImageHeight;
        }

        public void setImageHeight(int ImageHeight) {
            this.ImageHeight = ImageHeight;
        }

        public int getUserId() {
            return UserId;
        }

        public void setUserId(int UserId) {
            this.UserId = UserId;
        }

        public String getEncryptUserId() {
            return EncryptUserId;
        }

        public void setEncryptUserId(String EncryptUserId) {
            this.EncryptUserId = EncryptUserId;
        }

        public String getUserName() {
            return UserName;
        }

        public void setUserName(String UserName) {
            this.UserName = UserName;
        }

        public String getUserImage() {
            return UserImage;
        }

        public void setUserImage(String UserImage) {
            this.UserImage = UserImage;
        }

        public String getContent() {
            return Content;
        }

        public void setContent(String Content) {
            this.Content = Content;
        }

        public int getParseCount() {
            return ParseCount;
        }

        public void setParseCount(int ParseCount) {
            this.ParseCount = ParseCount;
        }

        public int getIsPrase() {
            return IsPrase;
        }

        public void setIsPrase(int IsPrase) {
            this.IsPrase = IsPrase;
        }
    }
}
