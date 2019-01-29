package edu.redcom.util;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;


import net.sf.json.JSONObject;

public class HttpClientUtil {
    //
    public static final String learnSelUrl = "http://192.168.0.124:8080/site/trdcredit/jxlxxwactivereq";

    /**
     * post请求
     *
     * @param url
     * @param
     * @return
     * @throws IOException
     */
    public static JSONObject postJsonData(String url, Map<String, String> params) {
        CloseableHttpClient httpclient = HttpClientUtil.createDefault();
        HttpPost httpPost = new HttpPost(url);
        //拼接参数
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            System.out.println("key=" + key + " value=" + value);
            NameValuePair pair = new BasicNameValuePair(key, value);
            list.add(pair);
        }
        CloseableHttpResponse response = null;
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(list));
            response = httpclient.execute(httpPost);
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**请求发送成功，并得到响应**/
        JSONObject jsonObject = null;
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            HttpEntity httpEntity = response.getEntity();
            String result = null;
            try {
                result = EntityUtils.toString(httpEntity);
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }// 返回json格式：
            jsonObject = JSONObject.fromObject(result);
        }
        return jsonObject;
    }

    /**
     * Creates {@link CloseableHttpClient} instance with default
     * configuration.
     */
    public static CloseableHttpClient createDefault() {
        return HttpClientBuilder.create().build();
    }

    /**
     * http发送post请求
     *
     * @param url
     * @param
     * @return
     */
    @SuppressWarnings({"resource"})
    public static JSONObject sendPost(String url, Map<String, String> params) {
        //DefaultHttpClient client = new DefaultHttpClient();
        CloseableHttpClient client = HttpClientUtil.createDefault();

        /**NameValuePair是传送给服务器的请求参数    param.get("name") **/
        List<NameValuePair> list = new ArrayList<NameValuePair>();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            System.out.println("key=" + key + " value=" + value);
            NameValuePair pair = new BasicNameValuePair(key, value);
            list.add(pair);
        }
        UrlEncodedFormEntity entity = null;
        try {
            /**设置编码 **/
            entity = new UrlEncodedFormEntity(list, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        /**新建一个post请求**/
        HttpPost post = new HttpPost(url);
        post.setEntity(entity);
        HttpResponse response = null;
        try {
            /**客服端向服务器发送请求**/
            response = client.execute(post);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /**请求发送成功，并得到响应**/
        JSONObject jsonObject = null;
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            HttpEntity httpEntity = response.getEntity();
            String result = null;
            try {
                result = EntityUtils.toString(httpEntity);
            } catch (ParseException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }// 返回json格式：
            jsonObject = JSONObject.fromObject(result);
        }
        return jsonObject;
    }
}