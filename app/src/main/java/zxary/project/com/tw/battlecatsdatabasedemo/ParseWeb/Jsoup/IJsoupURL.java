package zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.Jsoup;

import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public interface IJsoupURL
{
    Document parse(URL url, int timeoutMillis) throws IOException;
}
