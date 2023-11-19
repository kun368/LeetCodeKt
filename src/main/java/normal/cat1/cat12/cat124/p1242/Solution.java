package normal.cat1.cat12.cat124.p1242;

import java.util.*;
import java.util.stream.Collectors;

interface HtmlParser {
    List<String> getUrls(String url);
}

public class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        int end = startUrl.indexOf('/', 8);
        String prefix = end == -1 ? startUrl : startUrl.substring(0, end);
        Set<String> current = Collections.singleton(startUrl);
        Set<String> vis = new HashSet<>();
        vis.add(startUrl);
        while (!current.isEmpty()) {
            Set<String> validSons = current
                    .parallelStream()
                    .flatMap(s -> htmlParser.getUrls(s).stream()
                            .filter(son -> prefix.equals(son) || son.startsWith(prefix + "/"))
                            .filter(son -> !vis.contains(son)))
                    .collect(Collectors.toSet());
            current = validSons;
            vis.addAll(validSons);
        }
        return new ArrayList<>(vis);
    }
}
