package normal.cat1.cat12.cat123.p1206;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

interface HtmlParser {
    List<String> getUrls(String url);
}

public class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        List<String> qu = new ArrayList<>();
        Set<String> vis = new HashSet<>();

        int end = startUrl.indexOf('/', 8);
        String prefix = end == -1 ? startUrl : startUrl.substring(0, end);
        System.out.println(prefix);

        qu.add(startUrl);
        vis.add(startUrl);
        int quStart = 0;
        while (quStart < qu.size()) {
            for (int sz = qu.size(); quStart < sz; ++quStart) {
                List<String> sons = htmlParser.getUrls(qu.get(quStart));
                for (String son : sons) {
                    if (vis.contains(son)) continue;
                    if (prefix.equals(son) || son.startsWith(prefix + "/")) {
                        vis.add(son);
                        qu.add(son);
                    }
                }
            }
        }
        return qu;
    }
}
