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
        for (int i = 1; i <= 30; i++) {
            String url = "https://app.memrise.com/course/421128/essential-words-for-the-ielts-3/" + i + "/";
            getWords(url);
        }
    }

    private static void getWords(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
//        no need the words heards, if words header requied then have to active this line.
//        Elements header = doc.select("div.infos");
//        System.out.println(header.text());

        Elements words = doc.select("div.thing");
        List<String> list = words.eachText();
        words.eachText().forEach(s -> {
            String[] ss = s.split(" ");
//            1st print the word,
//            System.out.print(ss[0] + ", ");

//            2nd meaning of the word.
            for (int i = 1; i < ss.length; i++) {
                System.out.print(ss[i] + " ");
            }
            System.out.println();
        });
    }

    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }
}
