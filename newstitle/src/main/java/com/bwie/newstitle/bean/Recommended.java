package com.bwie.newstitle.bean;
//                            _ooOoo_
//                           o8888888o
//                           88" . "88
//                           (| -_- |)
//                           O\  =  /O
//                        ____/`---'\____
//                      .'  \\|     |//  `.
//                     /  \\|||  :  |||//  \
//                    /  _||||| -:- |||||-  \
//                    |   | \\\  -  /// |   |
//                    | \_|  ''\---/''  |   |
//                    \  .-\__  `-`  ___/-. /
//                  ___`. .'  /--.--\  `. . __
//               ."" '<  `.___\_<|>_/___.'  >'"".
//              | | :  `- \`.;`\ _ /`;.`/ - ` : | |
//              \  \ `-.   \_ __\ /__ _/   .-` /  /
//         ======`-.____`-.___\_____/___.-`____.-'======
//                            `=---='
//        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
//                      佛祖保佑       永无BUG


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Recommended {
    private int feed_flag;
    private boolean has_more;
    private boolean has_more_to_refresh;
    private int login_status;
    private String message;
    private String post_content_hint;
    private int show_et_status;
    private TipsBean tips;
    private int total_number;
    private List<DataBean> data;

    public int getFeed_flag() {
        return feed_flag;
    }

    public void setFeed_flag(int feed_flag) {
        this.feed_flag = feed_flag;
    }

    public boolean isHas_more() {
        return has_more;
    }

    public void setHas_more(boolean has_more) {
        this.has_more = has_more;
    }

    public boolean isHas_more_to_refresh() {
        return has_more_to_refresh;
    }

    public void setHas_more_to_refresh(boolean has_more_to_refresh) {
        this.has_more_to_refresh = has_more_to_refresh;
    }

    public int getLogin_status() {
        return login_status;
    }

    public void setLogin_status(int login_status) {
        this.login_status = login_status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPost_content_hint() {
        return post_content_hint;
    }

    public void setPost_content_hint(String post_content_hint) {
        this.post_content_hint = post_content_hint;
    }

    public int getShow_et_status() {
        return show_et_status;
    }

    public void setShow_et_status(int show_et_status) {
        this.show_et_status = show_et_status;
    }

    public TipsBean getTips() {
        return tips;
    }

    public void setTips(TipsBean tips) {
        this.tips = tips;
    }

    public int getTotal_number() {
        return total_number;
    }

    public void setTotal_number(int total_number) {
        this.total_number = total_number;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Recommended{" +
                "feed_flag=" + feed_flag +
                ", has_more=" + has_more +
                ", has_more_to_refresh=" + has_more_to_refresh +
                ", login_status=" + login_status +
                ", message='" + message + '\'' +
                ", post_content_hint='" + post_content_hint + '\'' +
                ", show_et_status=" + show_et_status +
                ", tips=" + tips +
                ", total_number=" + total_number +
                ", data=" + data +
                '}';
    }

    public static class TipsBean {
        private String app_name;
        private int display_duration;
        private String display_info;
        private String display_template;
        private String download_url;
        private String open_url;
        private String package_name;
        private String type;
        private String web_url;

        public String getApp_name() {
            return app_name;
        }

        public void setApp_name(String app_name) {
            this.app_name = app_name;
        }

        public int getDisplay_duration() {
            return display_duration;
        }

        public void setDisplay_duration(int display_duration) {
            this.display_duration = display_duration;
        }

        public String getDisplay_info() {
            return display_info;
        }

        public void setDisplay_info(String display_info) {
            this.display_info = display_info;
        }

        public String getDisplay_template() {
            return display_template;
        }

        public void setDisplay_template(String display_template) {
            this.display_template = display_template;
        }

        public String getDownload_url() {
            return download_url;
        }

        public void setDownload_url(String download_url) {
            this.download_url = download_url;
        }

        public String getOpen_url() {
            return open_url;
        }

        public void setOpen_url(String open_url) {
            this.open_url = open_url;
        }

        public String getPackage_name() {
            return package_name;
        }

        public void setPackage_name(String package_name) {
            this.package_name = package_name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getWeb_url() {
            return web_url;
        }

        public void setWeb_url(String web_url) {
            this.web_url = web_url;
        }

        @Override
        public String toString() {
            return "TipsBean{" +
                    "app_name='" + app_name + '\'' +
                    ", display_duration=" + display_duration +
                    ", display_info='" + display_info + '\'' +
                    ", display_template='" + display_template + '\'' +
                    ", download_url='" + download_url + '\'' +
                    ", open_url='" + open_url + '\'' +
                    ", package_name='" + package_name + '\'' +
                    ", type='" + type + '\'' +
                    ", web_url='" + web_url + '\'' +
                    '}';
        }
    }

    public static class DataBean {
        @SerializedName("abstract")
        private String abstractX;
        private int aggr_type;
        private String article_alt_url;
        private int article_sub_type;
        private int article_type;
        private String article_url;
        private int ban_comment;
        private int behot_time;
        private int bury_count;
        private int cell_flag;
        private int cell_layout_style;
        private int cell_type;
        private int comment_count;
        private long cursor;
        private int digg_count;
        private String display_url;
        private long group_id;
        private boolean has_image;
        private int has_m3u8_video;
        private int has_mp4_video;
        private boolean has_video;
        private int hot;
        private int ignore_web_transform;
        private boolean is_stick;
        private boolean is_subject;
        private long item_id;
        private int item_version;
        private String keywords;
        private String label;
        private int label_style;
        private int level;
        private int like_count;
        private MiddleImageBean middle_image;
        private int preload_web;
        private int publish_time;
        private int read_count;
        private int repin_count;
        private String rid;
        private String share_url;
        private boolean show_portrait;
        private boolean show_portrait_article;
        private String source;
        private String source_avatar;
        private int source_icon_style;
        private String source_open_url;
        private String tag;
        private long tag_id;
        private int tip;
        private String title;
        private String url;
        private int user_repin;
        private int user_verified;
        private String verified_content;
        private int video_style;
        private int gallary_image_count;
        private MediaInfoBean media_info;
        private String media_name;
        private UserInfoBean user_info;
        private int group_flags;
        private VideoDetailInfoBean video_detail_info;
        private int video_duration;
        private String video_id;
        private double video_proportion_article;
        private String video_source;
        private List<ActionListBean> action_list;
        private List<?> filter_words;
        private List<?> image_list;
        private List<?> large_image_list;

        public String getAbstractX() {
            return abstractX;
        }

        public void setAbstractX(String abstractX) {
            this.abstractX = abstractX;
        }

        public int getAggr_type() {
            return aggr_type;
        }

        public void setAggr_type(int aggr_type) {
            this.aggr_type = aggr_type;
        }

        public String getArticle_alt_url() {
            return article_alt_url;
        }

        public void setArticle_alt_url(String article_alt_url) {
            this.article_alt_url = article_alt_url;
        }

        public int getArticle_sub_type() {
            return article_sub_type;
        }

        public void setArticle_sub_type(int article_sub_type) {
            this.article_sub_type = article_sub_type;
        }

        public int getArticle_type() {
            return article_type;
        }

        public void setArticle_type(int article_type) {
            this.article_type = article_type;
        }

        public String getArticle_url() {
            return article_url;
        }

        public void setArticle_url(String article_url) {
            this.article_url = article_url;
        }

        public int getBan_comment() {
            return ban_comment;
        }

        public void setBan_comment(int ban_comment) {
            this.ban_comment = ban_comment;
        }

        public int getBehot_time() {
            return behot_time;
        }

        public void setBehot_time(int behot_time) {
            this.behot_time = behot_time;
        }

        public int getBury_count() {
            return bury_count;
        }

        public void setBury_count(int bury_count) {
            this.bury_count = bury_count;
        }

        public int getCell_flag() {
            return cell_flag;
        }

        public void setCell_flag(int cell_flag) {
            this.cell_flag = cell_flag;
        }

        public int getCell_layout_style() {
            return cell_layout_style;
        }

        public void setCell_layout_style(int cell_layout_style) {
            this.cell_layout_style = cell_layout_style;
        }

        public int getCell_type() {
            return cell_type;
        }

        public void setCell_type(int cell_type) {
            this.cell_type = cell_type;
        }

        public int getComment_count() {
            return comment_count;
        }

        public void setComment_count(int comment_count) {
            this.comment_count = comment_count;
        }

        public long getCursor() {
            return cursor;
        }

        public void setCursor(long cursor) {
            this.cursor = cursor;
        }

        public int getDigg_count() {
            return digg_count;
        }

        public void setDigg_count(int digg_count) {
            this.digg_count = digg_count;
        }

        public String getDisplay_url() {
            return display_url;
        }

        public void setDisplay_url(String display_url) {
            this.display_url = display_url;
        }

        public long getGroup_id() {
            return group_id;
        }

        public void setGroup_id(long group_id) {
            this.group_id = group_id;
        }

        public boolean isHas_image() {
            return has_image;
        }

        public void setHas_image(boolean has_image) {
            this.has_image = has_image;
        }

        public int getHas_m3u8_video() {
            return has_m3u8_video;
        }

        public void setHas_m3u8_video(int has_m3u8_video) {
            this.has_m3u8_video = has_m3u8_video;
        }

        public int getHas_mp4_video() {
            return has_mp4_video;
        }

        public void setHas_mp4_video(int has_mp4_video) {
            this.has_mp4_video = has_mp4_video;
        }

        public boolean isHas_video() {
            return has_video;
        }

        public void setHas_video(boolean has_video) {
            this.has_video = has_video;
        }

        public int getHot() {
            return hot;
        }

        public void setHot(int hot) {
            this.hot = hot;
        }

        public int getIgnore_web_transform() {
            return ignore_web_transform;
        }

        public void setIgnore_web_transform(int ignore_web_transform) {
            this.ignore_web_transform = ignore_web_transform;
        }

        public boolean isIs_stick() {
            return is_stick;
        }

        public void setIs_stick(boolean is_stick) {
            this.is_stick = is_stick;
        }

        public boolean isIs_subject() {
            return is_subject;
        }

        public void setIs_subject(boolean is_subject) {
            this.is_subject = is_subject;
        }

        public long getItem_id() {
            return item_id;
        }

        public void setItem_id(long item_id) {
            this.item_id = item_id;
        }

        public int getItem_version() {
            return item_version;
        }

        public void setItem_version(int item_version) {
            this.item_version = item_version;
        }

        public String getKeywords() {
            return keywords;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public int getLabel_style() {
            return label_style;
        }

        public void setLabel_style(int label_style) {
            this.label_style = label_style;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getLike_count() {
            return like_count;
        }

        public void setLike_count(int like_count) {
            this.like_count = like_count;
        }

        public MiddleImageBean getMiddle_image() {
            return middle_image;
        }

        public void setMiddle_image(MiddleImageBean middle_image) {
            this.middle_image = middle_image;
        }

        public int getPreload_web() {
            return preload_web;
        }

        public void setPreload_web(int preload_web) {
            this.preload_web = preload_web;
        }

        public int getPublish_time() {
            return publish_time;
        }

        public void setPublish_time(int publish_time) {
            this.publish_time = publish_time;
        }

        public int getRead_count() {
            return read_count;
        }

        public void setRead_count(int read_count) {
            this.read_count = read_count;
        }

        public int getRepin_count() {
            return repin_count;
        }

        public void setRepin_count(int repin_count) {
            this.repin_count = repin_count;
        }

        public String getRid() {
            return rid;
        }

        public void setRid(String rid) {
            this.rid = rid;
        }

        public String getShare_url() {
            return share_url;
        }

        public void setShare_url(String share_url) {
            this.share_url = share_url;
        }

        public boolean isShow_portrait() {
            return show_portrait;
        }

        public void setShow_portrait(boolean show_portrait) {
            this.show_portrait = show_portrait;
        }

        public boolean isShow_portrait_article() {
            return show_portrait_article;
        }

        public void setShow_portrait_article(boolean show_portrait_article) {
            this.show_portrait_article = show_portrait_article;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getSource_avatar() {
            return source_avatar;
        }

        public void setSource_avatar(String source_avatar) {
            this.source_avatar = source_avatar;
        }

        public int getSource_icon_style() {
            return source_icon_style;
        }

        public void setSource_icon_style(int source_icon_style) {
            this.source_icon_style = source_icon_style;
        }

        public String getSource_open_url() {
            return source_open_url;
        }

        public void setSource_open_url(String source_open_url) {
            this.source_open_url = source_open_url;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public long getTag_id() {
            return tag_id;
        }

        public void setTag_id(long tag_id) {
            this.tag_id = tag_id;
        }

        public int getTip() {
            return tip;
        }

        public void setTip(int tip) {
            this.tip = tip;
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

        public int getUser_repin() {
            return user_repin;
        }

        public void setUser_repin(int user_repin) {
            this.user_repin = user_repin;
        }

        public int getUser_verified() {
            return user_verified;
        }

        public void setUser_verified(int user_verified) {
            this.user_verified = user_verified;
        }

        public String getVerified_content() {
            return verified_content;
        }

        public void setVerified_content(String verified_content) {
            this.verified_content = verified_content;
        }

        public int getVideo_style() {
            return video_style;
        }

        public void setVideo_style(int video_style) {
            this.video_style = video_style;
        }

        public int getGallary_image_count() {
            return gallary_image_count;
        }

        public void setGallary_image_count(int gallary_image_count) {
            this.gallary_image_count = gallary_image_count;
        }

        public MediaInfoBean getMedia_info() {
            return media_info;
        }

        public void setMedia_info(MediaInfoBean media_info) {
            this.media_info = media_info;
        }

        public String getMedia_name() {
            return media_name;
        }

        public void setMedia_name(String media_name) {
            this.media_name = media_name;
        }

        public UserInfoBean getUser_info() {
            return user_info;
        }

        public void setUser_info(UserInfoBean user_info) {
            this.user_info = user_info;
        }

        public int getGroup_flags() {
            return group_flags;
        }

        public void setGroup_flags(int group_flags) {
            this.group_flags = group_flags;
        }

        public VideoDetailInfoBean getVideo_detail_info() {
            return video_detail_info;
        }

        public void setVideo_detail_info(VideoDetailInfoBean video_detail_info) {
            this.video_detail_info = video_detail_info;
        }

        public int getVideo_duration() {
            return video_duration;
        }

        public void setVideo_duration(int video_duration) {
            this.video_duration = video_duration;
        }

        public String getVideo_id() {
            return video_id;
        }

        public void setVideo_id(String video_id) {
            this.video_id = video_id;
        }

        public double getVideo_proportion_article() {
            return video_proportion_article;
        }

        public void setVideo_proportion_article(double video_proportion_article) {
            this.video_proportion_article = video_proportion_article;
        }

        public String getVideo_source() {
            return video_source;
        }

        public void setVideo_source(String video_source) {
            this.video_source = video_source;
        }

        public List<ActionListBean> getAction_list() {
            return action_list;
        }

        public void setAction_list(List<ActionListBean> action_list) {
            this.action_list = action_list;
        }

        public List<?> getFilter_words() {
            return filter_words;
        }

        public void setFilter_words(List<?> filter_words) {
            this.filter_words = filter_words;
        }

        public List<?> getImage_list() {
            return image_list;
        }

        public void setImage_list(List<?> image_list) {
            this.image_list = image_list;
        }

        public List<?> getLarge_image_list() {
            return large_image_list;
        }

        public void setLarge_image_list(List<?> large_image_list) {
            this.large_image_list = large_image_list;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "abstractX='" + abstractX + '\'' +
                    ", aggr_type=" + aggr_type +
                    ", article_alt_url='" + article_alt_url + '\'' +
                    ", article_sub_type=" + article_sub_type +
                    ", article_type=" + article_type +
                    ", article_url='" + article_url + '\'' +
                    ", ban_comment=" + ban_comment +
                    ", behot_time=" + behot_time +
                    ", bury_count=" + bury_count +
                    ", cell_flag=" + cell_flag +
                    ", cell_layout_style=" + cell_layout_style +
                    ", cell_type=" + cell_type +
                    ", comment_count=" + comment_count +
                    ", cursor=" + cursor +
                    ", digg_count=" + digg_count +
                    ", display_url='" + display_url + '\'' +
                    ", group_id=" + group_id +
                    ", has_image=" + has_image +
                    ", has_m3u8_video=" + has_m3u8_video +
                    ", has_mp4_video=" + has_mp4_video +
                    ", has_video=" + has_video +
                    ", hot=" + hot +
                    ", ignore_web_transform=" + ignore_web_transform +
                    ", is_stick=" + is_stick +
                    ", is_subject=" + is_subject +
                    ", item_id=" + item_id +
                    ", item_version=" + item_version +
                    ", keywords='" + keywords + '\'' +
                    ", label='" + label + '\'' +
                    ", label_style=" + label_style +
                    ", level=" + level +
                    ", like_count=" + like_count +
                    ", middle_image=" + middle_image +
                    ", preload_web=" + preload_web +
                    ", publish_time=" + publish_time +
                    ", read_count=" + read_count +
                    ", repin_count=" + repin_count +
                    ", rid='" + rid + '\'' +
                    ", share_url='" + share_url + '\'' +
                    ", show_portrait=" + show_portrait +
                    ", show_portrait_article=" + show_portrait_article +
                    ", source='" + source + '\'' +
                    ", source_avatar='" + source_avatar + '\'' +
                    ", source_icon_style=" + source_icon_style +
                    ", source_open_url='" + source_open_url + '\'' +
                    ", tag='" + tag + '\'' +
                    ", tag_id=" + tag_id +
                    ", tip=" + tip +
                    ", title='" + title + '\'' +
                    ", url='" + url + '\'' +
                    ", user_repin=" + user_repin +
                    ", user_verified=" + user_verified +
                    ", verified_content='" + verified_content + '\'' +
                    ", video_style=" + video_style +
                    ", gallary_image_count=" + gallary_image_count +
                    ", media_info=" + media_info +
                    ", media_name='" + media_name + '\'' +
                    ", user_info=" + user_info +
                    ", group_flags=" + group_flags +
                    ", video_detail_info=" + video_detail_info +
                    ", video_duration=" + video_duration +
                    ", video_id='" + video_id + '\'' +
                    ", video_proportion_article=" + video_proportion_article +
                    ", video_source='" + video_source + '\'' +
                    ", action_list=" + action_list +
                    ", filter_words=" + filter_words +
                    ", image_list=" + image_list +
                    ", large_image_list=" + large_image_list +
                    '}';
        }

        public static class MiddleImageBean {
        }

        public static class MediaInfoBean {
            private String avatar_url;
            private boolean follow;
            private boolean is_star_user;
            private long media_id;
            private String name;
            private String recommend_reason;
            private int recommend_type;
            private long user_id;
            private boolean user_verified;
            private String verified_content;

            public String getAvatar_url() {
                return avatar_url;
            }

            public void setAvatar_url(String avatar_url) {
                this.avatar_url = avatar_url;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public boolean isIs_star_user() {
                return is_star_user;
            }

            public void setIs_star_user(boolean is_star_user) {
                this.is_star_user = is_star_user;
            }

            public long getMedia_id() {
                return media_id;
            }

            public void setMedia_id(long media_id) {
                this.media_id = media_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getRecommend_reason() {
                return recommend_reason;
            }

            public void setRecommend_reason(String recommend_reason) {
                this.recommend_reason = recommend_reason;
            }

            public int getRecommend_type() {
                return recommend_type;
            }

            public void setRecommend_type(int recommend_type) {
                this.recommend_type = recommend_type;
            }

            public long getUser_id() {
                return user_id;
            }

            public void setUser_id(long user_id) {
                this.user_id = user_id;
            }

            public boolean isUser_verified() {
                return user_verified;
            }

            public void setUser_verified(boolean user_verified) {
                this.user_verified = user_verified;
            }

            public String getVerified_content() {
                return verified_content;
            }

            public void setVerified_content(String verified_content) {
                this.verified_content = verified_content;
            }

            @Override
            public String toString() {
                return "MediaInfoBean{" +
                        "avatar_url='" + avatar_url + '\'' +
                        ", follow=" + follow +
                        ", is_star_user=" + is_star_user +
                        ", media_id=" + media_id +
                        ", name='" + name + '\'' +
                        ", recommend_reason='" + recommend_reason + '\'' +
                        ", recommend_type=" + recommend_type +
                        ", user_id=" + user_id +
                        ", user_verified=" + user_verified +
                        ", verified_content='" + verified_content + '\'' +
                        '}';
            }
        }

        public static class UserInfoBean {
            private String avatar_url;
            private String description;
            private boolean follow;
            private int follower_count;
            private String name;
            private long user_id;
            private boolean user_verified;
            private String verified_content;

            public String getAvatar_url() {
                return avatar_url;
            }

            public void setAvatar_url(String avatar_url) {
                this.avatar_url = avatar_url;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public boolean isFollow() {
                return follow;
            }

            public void setFollow(boolean follow) {
                this.follow = follow;
            }

            public int getFollower_count() {
                return follower_count;
            }

            public void setFollower_count(int follower_count) {
                this.follower_count = follower_count;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public long getUser_id() {
                return user_id;
            }

            public void setUser_id(long user_id) {
                this.user_id = user_id;
            }

            public boolean isUser_verified() {
                return user_verified;
            }

            public void setUser_verified(boolean user_verified) {
                this.user_verified = user_verified;
            }

            public String getVerified_content() {
                return verified_content;
            }

            public void setVerified_content(String verified_content) {
                this.verified_content = verified_content;
            }

            @Override
            public String toString() {
                return "UserInfoBean{" +
                        "avatar_url='" + avatar_url + '\'' +
                        ", description='" + description + '\'' +
                        ", follow=" + follow +
                        ", follower_count=" + follower_count +
                        ", name='" + name + '\'' +
                        ", user_id=" + user_id +
                        ", user_verified=" + user_verified +
                        ", verified_content='" + verified_content + '\'' +
                        '}';
            }
        }

        public static class VideoDetailInfoBean {
            private DetailVideoLargeImageBean detail_video_large_image;
            private int direct_play;
            private int group_flags;
            private int show_pgc_subscribe;
            private String video_id;
            private int video_preloading_flag;
            private int video_type;
            private int video_watch_count;
            private int video_watching_count;

            public DetailVideoLargeImageBean getDetail_video_large_image() {
                return detail_video_large_image;
            }

            public void setDetail_video_large_image(DetailVideoLargeImageBean detail_video_large_image) {
                this.detail_video_large_image = detail_video_large_image;
            }

            public int getDirect_play() {
                return direct_play;
            }

            public void setDirect_play(int direct_play) {
                this.direct_play = direct_play;
            }

            public int getGroup_flags() {
                return group_flags;
            }

            public void setGroup_flags(int group_flags) {
                this.group_flags = group_flags;
            }

            public int getShow_pgc_subscribe() {
                return show_pgc_subscribe;
            }

            public void setShow_pgc_subscribe(int show_pgc_subscribe) {
                this.show_pgc_subscribe = show_pgc_subscribe;
            }

            public String getVideo_id() {
                return video_id;
            }

            public void setVideo_id(String video_id) {
                this.video_id = video_id;
            }

            public int getVideo_preloading_flag() {
                return video_preloading_flag;
            }

            public void setVideo_preloading_flag(int video_preloading_flag) {
                this.video_preloading_flag = video_preloading_flag;
            }

            public int getVideo_type() {
                return video_type;
            }

            public void setVideo_type(int video_type) {
                this.video_type = video_type;
            }

            public int getVideo_watch_count() {
                return video_watch_count;
            }

            public void setVideo_watch_count(int video_watch_count) {
                this.video_watch_count = video_watch_count;
            }

            public int getVideo_watching_count() {
                return video_watching_count;
            }

            public void setVideo_watching_count(int video_watching_count) {
                this.video_watching_count = video_watching_count;
            }

            public static class DetailVideoLargeImageBean {
                /**
                 * height : 326
                 * uri : video1609/14d70003d7658b4c4fe5
                 * url : http://p2.pstatp.com/video1609/14d70003d7658b4c4fe5
                 * url_list : [{"url":"http://p2.pstatp.com/video1609/14d70003d7658b4c4fe5"},{"url":"http://p4.pstatp.com/video1609/14d70003d7658b4c4fe5"},{"url":"http://p.pstatp.com/video1609/14d70003d7658b4c4fe5"}]
                 * width : 580
                 */

                private int height;
                private String uri;
                private String url;
                private int width;
                private List<UrlListBean> url_list;

                public int getHeight() {
                    return height;
                }

                public void setHeight(int height) {
                    this.height = height;
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

                public int getWidth() {
                    return width;
                }

                public void setWidth(int width) {
                    this.width = width;
                }

                public List<UrlListBean> getUrl_list() {
                    return url_list;
                }

                public void setUrl_list(List<UrlListBean> url_list) {
                    this.url_list = url_list;
                }

                public static class UrlListBean {
                    /**
                     * url : http://p2.pstatp.com/video1609/14d70003d7658b4c4fe5
                     */

                    private String url;

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }
                }
            }

            @Override
            public String toString() {
                return "VideoDetailInfoBean{" +
                        "detail_video_large_image=" + detail_video_large_image +
                        ", direct_play=" + direct_play +
                        ", group_flags=" + group_flags +
                        ", show_pgc_subscribe=" + show_pgc_subscribe +
                        ", video_id='" + video_id + '\'' +
                        ", video_preloading_flag=" + video_preloading_flag +
                        ", video_type=" + video_type +
                        ", video_watch_count=" + video_watch_count +
                        ", video_watching_count=" + video_watching_count +
                        '}';
            }
        }

        public static class ActionListBean {
            /**
             * action : 1
             * desc :
             * extra : {}
             */

            private int action;
            private String desc;
            private ExtraBean extra;

            public int getAction() {
                return action;
            }

            public void setAction(int action) {
                this.action = action;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public ExtraBean getExtra() {
                return extra;
            }

            public void setExtra(ExtraBean extra) {
                this.extra = extra;
            }

            public static class ExtraBean {
            }

            @Override
            public String toString() {
                return "ActionListBean{" +
                        "action=" + action +
                        ", desc='" + desc + '\'' +
                        ", extra=" + extra +
                        '}';
            }
        }
    }
}
