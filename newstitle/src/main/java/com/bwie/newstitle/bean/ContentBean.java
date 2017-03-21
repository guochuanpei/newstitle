package com.bwie.newstitle.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/1/9.
 */

public class ContentBean {
    private List<DataBean> data;

    public ContentBean(List<DataBean> data) {
        this.data = data;
    }

    public ContentBean() {
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ContentBean{" +
                "data=" + data +
                '}';
    }

    public class DataBean {
        private String article_type;
        private String article_url;
        private String comment_count;
        private String cursor;
        private String display_url;
        private boolean has_image;
        private boolean has_video;
        private List<Image_list> image_list;
        private List<Large_image_list> large_image_list;
        private String media_name;
        private Middle_image middle_image;
        private String publish_time;
        private String source;
        private String tag_id;
        private String title;
        private String url;

        public DataBean(List<Image_list> image_list, String article_type, String article_url, String comment_count, String cursor, String display_url, boolean has_image, boolean has_video, List<Large_image_list> large_image_list, String media_name, Middle_image middle_image, String publish_time, String source, String tag_id, String title, String url) {
            this.image_list = image_list;
            this.article_type = article_type;
            this.article_url = article_url;
            this.comment_count = comment_count;
            this.cursor = cursor;
            this.display_url = display_url;
            this.has_image = has_image;
            this.has_video = has_video;
            this.large_image_list = large_image_list;
            this.media_name = media_name;
            this.middle_image = middle_image;
            this.publish_time = publish_time;
            this.source = source;
            this.tag_id = tag_id;
            this.title = title;
            this.url = url;
        }

        public DataBean() {
        }

        public String getArticle_url() {
            return article_url;
        }

        public void setArticle_url(String article_url) {
            this.article_url = article_url;
        }

        public List<Image_list> getImage_list() {
            return image_list;
        }

        public void setImage_list(List<Image_list> image_list) {
            this.image_list = image_list;
        }

        public String getArticle_type() {
            return article_type;
        }

        public void setArticle_type(String article_type) {
            this.article_type = article_type;
        }

        public String getComment_count() {
            return comment_count;
        }

        public void setComment_count(String comment_count) {
            this.comment_count = comment_count;
        }

        public String getCursor() {
            return cursor;
        }

        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public String getDisplay_url() {
            return display_url;
        }

        public void setDisplay_url(String display_url) {
            this.display_url = display_url;
        }

        public boolean isHas_image() {
            return has_image;
        }

        public void setHas_image(boolean has_image) {
            this.has_image = has_image;
        }

        public boolean isHas_video() {
            return has_video;
        }

        public void setHas_video(boolean has_video) {
            this.has_video = has_video;
        }

        public List<Large_image_list> getLarge_image_list() {
            return large_image_list;
        }

        public void setLarge_image_list(List<Large_image_list> large_image_list) {
            this.large_image_list = large_image_list;
        }

        public String getMedia_name() {
            return media_name;
        }

        public void setMedia_name(String media_name) {
            this.media_name = media_name;
        }

        public Middle_image getMiddle_image() {
            return middle_image;
        }

        public void setMiddle_image(Middle_image middle_image) {
            this.middle_image = middle_image;
        }

        public String getPublish_time() {
            return publish_time;
        }

        public void setPublish_time(String publish_time) {
            this.publish_time = publish_time;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getTag_id() {
            return tag_id;
        }

        public void setTag_id(String tag_id) {
            this.tag_id = tag_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "article_type='" + article_type + '\'' +
                    ", article_url='" + article_url + '\'' +
                    ", comment_count='" + comment_count + '\'' +
                    ", cursor='" + cursor + '\'' +
                    ", display_url='" + display_url + '\'' +
                    ", has_image=" + has_image +
                    ", has_video=" + has_video +
                    ", image_list=" + image_list +
                    ", large_image_list=" + large_image_list +
                    ", media_name='" + media_name + '\'' +
                    ", middle_image=" + middle_image +
                    ", publish_time='" + publish_time + '\'' +
                    ", source='" + source + '\'' +
                    ", tag_id='" + tag_id + '\'' +
                    ", title='" + title + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    public class Image_list {
        private String uri;
        private String url;

        public Image_list(String uri, String url) {
            this.uri = uri;
            this.url = url;
        }

        public Image_list() {
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "Image_list{" +
                    "uri='" + uri + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    public class Large_image_list {
        private String uri;
        private String url;

        public Large_image_list(String uri, String url) {
            this.uri = uri;
            this.url = url;
        }

        public Large_image_list() {
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "Large_image_list{" +
                    "uri='" + uri + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    public class Middle_image {
        private String uri;
        private String url;

        public Middle_image(String uri, String url) {
            this.uri = uri;
            this.url = url;
        }

        public Middle_image() {
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "Middle_image{" +
                    "uri='" + uri + '\'' +
                    ", url='" + url + '\'' +
                    '}';
        }
    }
}

