package com.example.bfmemiao.myapplication.bean;

import java.util.List;

/**
 * Created by BFMe.miao on 2018/1/23.
 */

public class CategoryAllBean {


    private List<CategoryBean> Category;

    public List<CategoryBean> getCategory() {
        return Category;
    }

    public void setCategory(List<CategoryBean> Category) {
        this.Category = Category;
    }

    public static class CategoryBean {
        /**
         * Id : 580
         * Icon : http://img01.baifomi.com/areas/mobile/categories/20170912/temp/mzxs.png
         * Name : 美妆香水
         */

        private int Id;
        private String Icon;
        private String Name;

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getIcon() {
            return Icon;
        }

        public void setIcon(String Icon) {
            this.Icon = Icon;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }
    }
}
