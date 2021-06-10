package com.imdsc.util;

import com.alibaba.fastjson.JSON;
import okhttp3.*;

import java.io.IOException;
import java.util.*;

/**
 * http util
 */
public class HttpUtil {

    public static final MediaType MEDIA_TYPE_JSON = MediaType.get("application/json; charset=utf-8");

    /**
     * send GET request
     * @param url url
     * @param uriVariables query string parameters
     * @return string of response
     * @throws IOException request exception
     */
    public static String sendGet(String url, Map<String, ?> uriVariables) throws IOException {
        if(uriVariables==null) {
            uriVariables = new HashMap<>();
        }
        url = autoSetUrl(url, uriVariables);
        Request request = initBuilder()
                .url(url)
                .build();

        OkHttpClient client = initOkHttpClient();
        try (Response response = client.newCall(request).execute()) {
            return Objects.requireNonNull(response.body()).string();
        }
    }

    /**
     *
     * @param url url
     * @param body request payload(application/json; charset=utf-8)
     * @param uriVariables query string parameters
     * @return string of response
     * @throws IOException request exception
     */
    public static String sendPost(String url, Object body, Map<String, ?> uriVariables) throws IOException {
        if (uriVariables == null) {
            uriVariables = new HashMap<>();
        }
        url = autoSetUrl(url, uriVariables);
        RequestBody requestBody = RequestBody.create(JSON.toJSONString(body), MEDIA_TYPE_JSON);
        Request request = initBuilder()
                .url(url)
                .post(requestBody)
                .build();

        OkHttpClient client = initOkHttpClient();
        try (Response response = client.newCall(request).execute()) {
            return Objects.requireNonNull(response.body()).string();
        }
    }

    private static OkHttpClient initOkHttpClient() {
        return new OkHttpClient();
    }

    private static Request.Builder initBuilder() {
        return new Request.Builder()
                .header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36");
    }

    private static String autoSetUrl(String url, Map<String,?> uriVariables) {
        if (uriVariables.size() > 0) {
            url = url.concat("?");
            Set<String> keySet = uriVariables.keySet();
            Iterator<String> iterator = keySet.iterator();

            String key = iterator.next();
            Object value = uriVariables.get(key);

            url = url.concat(key).concat("=").concat(String.valueOf(value)).concat("");

            while (iterator.hasNext()) {
                url = url.concat("&");

                key = iterator.next();

                value = uriVariables.get(key);

                url = url.concat(key).concat("=").concat(String.valueOf(value)).concat("");
            }

        }
        return url;
    }

}
