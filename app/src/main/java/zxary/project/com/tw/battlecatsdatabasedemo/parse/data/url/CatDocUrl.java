package zxary.project.com.tw.battlecatsdatabasedemo.parse.data.url;

import java.net.URL;

import zxary.project.com.tw.battlecatsdatabasedemo.attribute.utility.StringRes;

public class CatDocUrl extends BaseUrl {

    @Override
    public URL get(final String id) {
    
        String uid = "000".substring(0, 3 - id.length()) + id;
        String url = StringRes.getWebCatFormatUrl(uid);

        return create(url);
    }
}
