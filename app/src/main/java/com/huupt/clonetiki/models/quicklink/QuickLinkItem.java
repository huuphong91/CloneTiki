
package com.huupt.clonetiki.models.quicklink;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuickLinkItem {

    @Expose
    private Boolean authentication;
    @Expose
    private String content;
    @SerializedName("image_url")
    private String imageUrl;
    @Expose
    private String title;
    @Expose
    private String url;
    @SerializedName("web_url")
    private String webUrl;

    public Boolean getAuthentication() {
        return authentication;
    }

    public String getContent() {
        return content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getWebUrl() {
        return webUrl;
    }
}
