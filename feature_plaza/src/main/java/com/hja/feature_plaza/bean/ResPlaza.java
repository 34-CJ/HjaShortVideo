package com.hja.feature_plaza.bean;

import java.util.List;

public class ResPlaza {

    private String type;

    private List<PlazaDetail> lists;

    public List<PlazaDetail> getLists() {
        return lists;
    }

    public void setLists(List<PlazaDetail> lists) {
        this.lists = lists;
    }

    public static class PlazaDetail {
        /**
         * id : 29
         * name : 搞笑
         * image : http://ali-img.kaiyanapp.com/f2b803d3c383bba5a3888b2709160b6e.jpeg?image_process=image/auto-orient
         * icon : http://ali-img.kaiyanapp.com/df984c07284ff284184eaf3bc9b65133.png
         * description : 哈哈哈哈哈哈哈哈
         * url : /cms/29.html
         * fullurl : https://titok.fzqq.fun/cms/29.html
         */

        private int id;
        private String name;
        private String image;
        private String icon;
        private String description;
        private String url;
        private String fullurl;
        /**
         * title : 和老韩一起去看青山流水
         * images : ["https://pic.rmb.bdstatic.com/bjh/240305/654445218841bf7a9cbd6b80a856cf1d2196.jpeg","http://ali-img.kaiyanapp.com/302209431/9c40f4d0392212e3cecb34b9e84aa595.png?image_process=image/auto-orient,1/resize,w_480/format,webp/interlace,1/quality,q_80","http://ali-img.kaiyanapp.com/302209431/9c40f4d0392212e3cecb34b9e84aa595.png?image_process=image/auto-orient,1/resize,w_480/format,webp/interlace,1/quality,q_80","http://ali-img.kaiyanapp.com/304398712/0-6c1f1e2417b947f8fed0e5b69e5cff52.jpeg?image_process=image/auto-orient,1/resize,w_480/format,webp/interlace,1/quality,q_80"]
         * author : 李白
         * avatar : https://titok.fzqq.fun/uploads/20240826/50d42d478612bb3f289dd6258caa046b.jpeg
         * cover : http://ali-img.kaiyanapp.com/302209431/9c40f4d0392212e3cecb34b9e84aa595.png?image_process=image/auto-orient,1/resize,w_480/format,webp/interlace,1/quality,q_80
         */

        private String title;
        private String author;
        private String avatar;
        private String cover;
        private List<String> images;




        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getFullurl() {
            return fullurl;
        }

        public void setFullurl(String fullurl) {
            this.fullurl = fullurl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }


}
