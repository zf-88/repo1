package com.bdqn.config.util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;




import java.io.IOException;


/**
 * @author zf
 * @create 2020-02-15 16:53
 */
public class PageDownLoadUtil {
    public static void main(String[] args) throws XPatherException {
        String content=PageDownLoadUtil.getPageContent("https://ncov.dxy.cn/ncovh5/view/pneumonia");
    // System.out.println(content);
      PageDownLoadUtil.htmlcleaner(content);

    }
    public  static  String getPageContent(String url){
        String content=null;

       // HttpClientBuilder builder= HttpClients.custom();
      CloseableHttpClient client= HttpClients.createDefault();
        HttpGet request=new HttpGet(url);
        CloseableHttpResponse  response=null;
        try {
            response=client.execute(request);
           HttpEntity entity= response.getEntity();
          content=  EntityUtils.toString(entity,"utf-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  content;
    }

    public static  void  htmlcleaner(String content) throws XPatherException{
        HtmlCleaner cleaner = new HtmlCleaner();
        TagNode node = cleaner.clean(content);

        //Object []  ns = node.getElementsByAttValue("id", "getAreaStat", true, true);
        Object []  ns=node.evaluateXPath("//*[@id=\"getAreaStat\"]");

        if(ns.length > 0) {
           String str= ((TagNode)ns[0]).getText().toString();

String json=str.substring(str.indexOf("=")+1,str.lastIndexOf("a")-2).trim();
System.out.println(json);



            JSONArray jsonArray= JSONArray.fromObject(json);//并将DS内容取出转为json数组  
            for (int i=0;i< jsonArray.size(); i++){//遍历json数组内容  

    JSONObject object=jsonArray.getJSONObject(i);
    if(object.getString("provinceName").equals("四川省")){
       String json2=object.getString("cities");

        System.out.println("   城市  ："+object.getString("provinceShortName"));
        System.out.println("目前患者："+object.getString("currentConfirmedCount"));
        System.out.println("确诊人数："+object.getString("confirmedCount"));
        System.out.println("治愈人数："+ object.getString("curedCount"));
        System.out.println("死亡人数："+object.getString("deadCount"));
        JSONArray jsonArray2= JSONArray.fromObject(json2);
   for (int j=0;j<jsonArray2.size();j++){
           JSONObject object2=jsonArray2.getJSONObject(j);
System.out.println("   城市  ："+object2.getString("cityName"));
    System.out.println("目前患者："+object2.getString("currentConfirmedCount"));
    System.out.println("确诊人数："+object2.getString("confirmedCount"));
    System.out.println("治愈人数："+ object2.getString("curedCount"));
    System.out.println("死亡人数："+object2.getString("deadCount"));

}

    }


            }

            }


        }

    }




