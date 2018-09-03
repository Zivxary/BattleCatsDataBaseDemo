package zxary.project.com.tw.battlecatsdatabasedemo.parseWeb.data.buildUrl;

import java.net.URL;

import zxary.project.com.tw.battlecatsdatabasedemo.unitAttribute.utility.StringRes;

public class CatImageUrl extends BaseUrl {

    @Override
    public URL get(final String id) {
        String uid = "000-0".substring(0, 5 - id.length()) + id;
        String url = StringRes.getWebCatImageFormatUrl(uid);
        return create(url);
    }
}
