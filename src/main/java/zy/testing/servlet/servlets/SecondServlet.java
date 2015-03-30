package zy.testing.servlet.servlets;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import zy.testing.servlet.domains.Items;
import zy.testing.servlet.mustache.MustacheProcesser;

/**
 * Servlet implementation class SecondServlet
 */
public class SecondServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter pw = response.getWriter();
        pw.println("Welcome haha!");

        List<Items.Item> items = new Items().items();
        try (
            BufferedReader buffR =
                new BufferedReader(new FileReader(new File(new URI(
                    "file:///Users/zion/zy-testing/src/main/webapp/mustache-templates/test1.mustache"))))) {

            Map<String, Object> data = new HashMap<>();

            List<Object> itemList = new ArrayList<>();
            data.put("items", itemList);
            for (Items.Item item : items) {
                Map<String, Object> itemMap = new HashMap<>();
                itemMap.put("name", item.getName());
                itemMap.put("price", item.getPrice());

                List<Map<String, Object>> featureList = new ArrayList<>();
                for (Items.Feature featcher : item.getFeatures()) {
                    Map<String, Object> featureMap = new HashMap<>();
                    featureMap.put("description", featcher.getDescription());
                    featureList.add(featureMap);
                }

                itemMap.put("features", item.getPrice());
                itemList.add(item);
            }

            Map<String, Object> scopes = new HashMap<String, Object>();
            scopes.put("name", "Mustache");
            scopes.put("feature", new Items.Feature("Perfect!"));

            // MustacheProcesser.process(pw, new StringReader("{{name}}, {{feature.description}}!"), "my-name", scopes);

            // MustacheProcesser.process(pw, new StringReader(MUSTACHE_TEMPLATE), "test1.mustache", data);

            MustacheProcesser.process(pw, buffR, "test1.mustache", data);
        } catch (URISyntaxException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // TODO Auto-generated method stub
    }

    private final static String MUSTACHE_TEMPLATE = "{{#items}}\n Name: {{name}}\n" + "Price: {{price}}\n"
        + "  {{#features}}\n" + "  Feature: {{description}}\n" + "  {{/features}}\n" + "{{/items}}";

}
