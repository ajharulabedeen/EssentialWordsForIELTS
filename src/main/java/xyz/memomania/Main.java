package xyz.memomania;

import org.jsoup.helper.Validate;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class Main {
    public static void main(String[] args) throws IOException {
//        Validate.isTrue(args.length == 1, "usage: supply url to fetch");
        String baseUrl = "https://app.memrise.com/course/421128/essential-words-for-the-ielts-3/";
        print("Fetching %s...", baseUrl);
        for (int i = 1; i <= 20; i++) {
            String url = "https://app.memrise.com/course/421128/essential-words-for-the-ielts-3/"+""+"/";
            getWords(url);
        }
    }

    private static void getWords(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements header = doc.select("div.infos");
        System.out.println(header.text());
        Elements words = doc.select("div.thing");
        List<String> list = words.eachText();
        words.eachText().forEach(s -> {
            System.out.println(s.split(" ")[0]);
        });
    }


    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }
}
