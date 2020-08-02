
package com.huupt.clonetiki.models.quicklink;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class QuickLinkResponse {

    @SerializedName("data")
    private List<List<QuickLinkItem>> data;

    public List<List<QuickLinkItem>> getData() {
        return data;
    }
}
