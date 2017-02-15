package com.mzjf;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class Rest {

    public static void main(String args[]) {
        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setConnectTimeout(30000);
        RestTemplate restTemplate = new RestTemplate(
                simpleClientHttpRequestFactory);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        map.add("Accept-Encoding", "gzip, deflate, br");
        map.add("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
        map.add("Cache-Control", "max-age=0");
        map.add("Connection", "keep-alive");
        map.add("Cookie",
                "JSESSIONID=D43A35AB8ED7B3BB470AAC22A0150588; Hm_lvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1484793276; Hm_lpvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1484879477; user_trace_token=20170119103438-e3cd0e0aa3384a948e7de17c46b1206c; _ga=GA1.2.1151811972.1484793277; LGRID=20170120103119-86651df8-deb8-11e6-b4a2-525400f775ce; LGUID=20170119103439-d37cce4d-ddef-11e6-8c9a-5254005c3644; index_location_city=%E5%8C%97%E4%BA%AC; TG-TRACK-CODE=index_navigation; SEARCH_ID=283282adb0584e2fae29d6308f70c104; _gat=1; LGSID=20170120103058-7a0fef0c-deb8-11e6-8cf2-5254005c3644; PRE_UTM=m_cf_cpt_baidu_pc; PRE_HOST=; PRE_SITE=; PRE_LAND=https%3A%2F%2Fwww.lagou.com%2F%3Futm_source%3Dm_cf_cpt_baidu_pc");
        map.add("Host", "www.lagou.com");
        map.add("Referer", "https://www.lagou.com/zhaopin/Java/?labelWords=label");
        map.add("Upgrade-Insecure-Requests", "1");
        map.add("User-Agent",
                "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:50.0) Gecko/20100101 Firefox/50.0");

        for (int i = 430813; i < 430818; i++) {
            String url = "https://www.lagou.com/jobs/" + i + ".html";
            ResponseEntity<String> response = restTemplate
                    .exchange(
                            url,
                            HttpMethod.GET, new HttpEntity<Object>(map),
                            new ParameterizedTypeReference<String>() {
                            });
            if (response.getStatusCode() == HttpStatus.OK) {
                System.out.println(response.getBody());
            } else {
                System.err.println("httpCode=" + response.getStatusCode() + ": " + url);
            }

        }
    }
}
