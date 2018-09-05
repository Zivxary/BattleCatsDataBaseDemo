package zxary.project.com.tw.battlecatsdatabasedemo.parse.jsoup;

import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public interface IJsoup {
    Document parse(URL url, int timeoutMillis) throws IOException;
    
    Document parse(String html);
}
