package zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Data.BuildUrl;

import java.net.URL;

import zxary.project.com.tw.battlecatsdatabasedemo.StringRes;

import static java.lang.String.format;

public class CatDocUrl extends BaseUrl {

    @Override
    public URL get(final String id) {

        String uid = "000".substring(0 , 3 - id.length()) + id;
        String url = StringRes.getWebCatFormatUrl(uid);

        return create(url);
    }
}
