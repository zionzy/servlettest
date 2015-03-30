package zy.testing.servlet.mustache;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.util.Map;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

public class MustacheProcesser {

    public static void process(final PrintWriter pw, final Reader mustacheTemplateReader, final String mustacheName,
                               final Map<String, Object> data)
        throws IOException {

        // System.out.println("------- reader data 1:" + stringReaderToString(mustacheTemplateReader));

        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile(mustacheTemplateReader, mustacheName);
        mustache.execute(pw, data).flush();
    }

    public static void process(final PrintWriter pw, final Reader mustacheTemplateReader, final String mustacheName,
                               final Object data) throws IOException {

        // System.out.println("---------- reader data 2:" + stringReaderToString(mustacheTemplateReader));

        MustacheFactory mf = new DefaultMustacheFactory();
        Mustache mustache = mf.compile(mustacheTemplateReader, mustacheName);
        mustache.execute(pw, data).flush();
    }

    public static String stringReaderToString(final Reader reader) throws IOException {

        // use string builder to avoid unnecessary string creation.
        StringBuilder builder = new StringBuilder();
        int charsRead = -1;
        char[] chars = new char[100];
        do {
            charsRead = ((StringReader) reader).read(chars, 0, chars.length);
            // if we have valid chars, append them to end of string.
            if (charsRead > 0)
                builder.append(chars, 0, charsRead);
        } while (charsRead > 0);
        String stringReadFromReader = builder.toString();
        return stringReadFromReader;
    }
}
