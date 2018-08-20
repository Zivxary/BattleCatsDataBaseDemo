package zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class JsoupCollection implements IJsoupString, IJsoupURL
{
    @Override
    public Document parse(final String html) {
        return Jsoup.parse(html);
    }

    @Override
    public Document parse(final URL url, final int timeoutMillis) throws IOException {
        return Jsoup.parse(url, timeoutMillis);
    }
}
