package edu.redcom.util;

import net.sf.json.JSONObject;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.concurrent.Callable;

public class HttpRequestThread implements Callable<String> {
    //private CountDownLatch begin;
    //private CountDownLatch end;
   // private String sign;
    private String url = "http://localhost:8080/drawPrize";

   /* public HttpRequestThread(CountDownLatch begin, CountDownLatch end, String sign) {
        this.begin = begin;
        this.end = end;
        this.sign = sign;
    }*/

    public static CloseableHttpClient createDefault() {
        return HttpClientBuilder.create().build();
    }


    public String call() {
        try {
            CloseableHttpClient httpclient = HttpClientUtil.createDefault();
            HttpGet getMethod = new HttpGet("http://localhost:8080/webauth?userID=123&name=赤色彗星");
            HttpPost postMethod = new HttpPost("http://localhost:8080/drawPrize");
            //begin.await();
            //System.out.println("线程" + Thread.currentThread().getName() +
            //        "已接受命令," + "时间为：" + System.nanoTime() + "|" + System.nanoTime() / 1000000L);
            CloseableHttpResponse response = httpclient.execute(getMethod);
            //printResponse(response);

            postMethod.setEntity(response.getEntity());
            CloseableHttpResponse response2 = httpclient.execute(postMethod);
            //printResponse(response2);
            String strResult = EntityUtils.toString(response2.getEntity());
            System.out.println(strResult);
           // System.out.println("线程" + Thread.currentThread().getName() + "命令已结束");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //end.countDown();
        }
        return "ok";
    }

    public static void printResponse(HttpResponse httpResponse) throws ParseException, IOException {
        // 获取响应消息实体
        HttpEntity entity = httpResponse.getEntity();
        // 响应状态
        System.out.println("status:" + httpResponse.getStatusLine());
        System.out.println("headers:");
        HeaderIterator iterator = httpResponse.headerIterator();
        while (iterator.hasNext()) {
            System.out.println("\t" + iterator.next());
        }
        // 判断响应实体是否为空
        if (entity != null) {
            //		String responseString = EntityUtils.toString(entity);
            //		System.out.println("response length:" + responseString.length());
            //		System.out.println("response content:" + responseString.replace("\r\n", ""));
        }
        System.out.println("------------------------------------------------------------------------------------------\r\n");
    }


}

