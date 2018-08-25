package zxary.project.com.tw.battlecatsdatabasedemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Assert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import zxary.project.com.tw.battlecatsdatabasedemo.ParseWeb.FakeDocument;

public class TestUtility {

    private static final String TEST_URL = "https://test.com";

    private static final String TEST_HTML
            = "<html>\n <head> \n  <title>test</title> \n </head> \n <body>  \n </body>\n</html>";

    private static final String TEST_NULL_HTML
            = "<html>\n <head></head>\n <body></body>\n</html>";

    private static String getPath(final String fileName) {
        return Object.class.getResource("/" + fileName).getPath();
    }

    private static File getFile(final String fileName) {
        return new File(getPath(fileName));
    }

    private static void printLn(final String str) {
        System.out.println(str);
    }

    public static Document getDocument(final String fileName) {
        File file = getFile(fileName);
        try {
            return Jsoup.parse(file, "UTF-8");
        } catch (IOException e) {
            printLn("Jsoup解析失敗：" + file.getAbsolutePath());
            e.printStackTrace();
        }
        return null;
    }

    public static URL getURL() {
        return getURL(TEST_URL);
    }

    public static URL getURL(final String url) {
        try {
            return new URL(url);
        } catch (MalformedURLException e) {
            printLn("URL create Error：" + url);
            e.printStackTrace();
        }
        return  null;
    }

    public static Bitmap getBitmap(final String fileName) {
        InputStream inputStream = null;
        if (fileName == null) {
            return null;
        }
        try {
            inputStream = new FileInputStream(getFile(fileName));
            return BitmapFactory.decodeStream(inputStream);
        } catch (FileNotFoundException e) {
            System.out.println("TestUtility_GetBitmap : Can't get ImageFile");
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.out.println("TestUtility_GetBitmap : Can't close inputStream");
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public static void assertEquals(final String name, final Object expected, final Object actual) {
        printValue(name, expected, actual);
        Assert.assertEquals(expected, actual);
    }

    private static void printValue(final String name, final Object expected, final Object actual) {

        String str = (name != null ? name : "null")
                + "\t: expected = "
                + (expected != null ? expected.toString() : "null")
                + "\tactual = "
                + (actual != null ? actual.toString() : "null");
        printLn(str);
    }

    public static Document getDocument() {
        return Jsoup.parse(TEST_HTML);
    }

    public static String getTestHtml() {
        return TEST_HTML;
    }

    public static Document getFakeDoc() {
        return getFakeDoc(TEST_HTML);
    }

    public static Document getFakeDoc(final String html) {
        return new FakeDocument(html);
    }

    public static Document getFakeDocNull(){
        return getFakeDoc(TEST_NULL_HTML);
    }
	
	public static String getString(String fileName) {
		StringBuilder sb = new StringBuilder(1024);
		try {
			BufferedReader br = new BufferedReader(new FileReader(getPath(fileName)));
			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (FileNotFoundException e) {
			printLn("FileNotFound：" + fileName);
			e.printStackTrace();
		} catch (IOException e) {
			printLn("Reader Error");
			e.printStackTrace();
		}
		return sb.toString();
	}
}
