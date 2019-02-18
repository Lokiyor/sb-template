package com.ljy.sbtemplate.util;

import com.google.common.collect.Maps;
import com.ljy.sbtemplate.exception.BusinessException;
import com.ljy.sbtemplate.model.enums.SbtEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * 调用接口类
 */
@Component
public class RestTemplateUtil {

    private static RestTemplateUtil restTemplateUtil;

    private static boolean useEurekaFlag = true;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @PostConstruct
    public void init() {
        restTemplateUtil = this;
        restTemplateUtil.loadBalancerClient = this.loadBalancerClient;
    }

    private static final RestTemplate INSTANCE = new RestTemplate();

    public static RestTemplate getInstance() {
        return RestTemplateUtil.INSTANCE;
    }

    public static String get(String url){
        ResponseEntity<String> entity = RestTemplateUtil.getInstance().
                getForEntity(url, String.class, new Object[]{});
        return entity.getBody();
    }

    public static <T> String post(String url, T data) throws Exception {
        //复杂构造函数的使用
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(300000);// 设置超时
        requestFactory.setReadTimeout(300000);


        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept-Charset", MediaType.APPLICATION_JSON.toString());

        HttpEntity<T> object = new HttpEntity<>(data, headers);
        //利用复杂构造器可以实现超时设置，内部实际实现为 HttpClient
        RestTemplate restTemplate = RestTemplateUtil.getInstance();
        restTemplate.setRequestFactory(requestFactory);
        /*ResponseEntity<String> responseEntity =
                RestTemplateUtil.getInstance().postForEntity(url.toString(), object, String.class);*/
        ResponseEntity<String> responseEntity =
                restTemplate.postForEntity(url, object, String.class);
//        String result = new String(responseEntity.getBody().getBytes("ISO-8859-1"), "utf-8");
        String result = responseEntity.getBody();
        return result;
    }

    public static <T> String post1(String url, T data) throws Exception {
        //复杂构造函数的使用
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(300000);// 设置超时
        requestFactory.setReadTimeout(300000);


//        HttpHeaders headers = new HttpHeaders();
//        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
//        headers.setContentType(type);
//        headers.add("Accept-Charset", MediaType.APPLICATION_JSON.toString());

        HttpEntity<T> object = new HttpEntity<>(data);
        //利用复杂构造器可以实现超时设置，内部实际实现为 HttpClient
        RestTemplate restTemplate = RestTemplateUtil.getInstance();
        restTemplate.setRequestFactory(requestFactory);
        /*ResponseEntity<String> responseEntity =
                RestTemplateUtil.getInstance().postForEntity(url.toString(), object, String.class);*/
        ResponseEntity<String> responseEntity =
                restTemplate.postForEntity(url, object, String.class);
        String result = new String(responseEntity.getBody().getBytes("utf-8"), "utf-8");
        return result;
    }



    public static String rpcGet(String serverId, String url, String finalUrl){
        finalUrl = getFinalUrl(serverId, url, finalUrl);
        return get(finalUrl);
    }


    public static <T> T rpcPostJson(String serverId, String url, String finalUrl,Object param,Class<T> respClass){
        finalUrl = getFinalUrl(serverId, url, finalUrl);
        ResponseEntity<T> responseEntity =
                RestTemplateUtil.getInstance().postForEntity(finalUrl, param, respClass);
        return responseEntity.getBody();
    }


    public static <T> String rpcPost(String serverId, String url, String finalUrl, T data) throws Exception {
        finalUrl = getFinalUrl(serverId, url, finalUrl);
        return post(finalUrl, data);
    }

    private static String getFinalUrl(String serverId, String url, String finalUrl){
        if(useEurekaFlag) {
            ServiceInstance serviceInstance = restTemplateUtil.loadBalancerClient.choose(serverId);
            if (serviceInstance == null) {
                throw new BusinessException(ErrorCode.ERROR_SERVER.getCode(), SbtEnum.val(serverId) + ErrorCode.ERROR_SERVER.getMsg());
            }
            finalUrl = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + url;
        }
        return finalUrl;
    }

    public static void main(String[] args){
        Map<String,Object> map = Maps.newHashMap();
//        mainInfoId,action,userName
        map.put("mainInfoId","dfe4407abf2442afb527b61940f2f3b3_k2admin");
        map.put("action","通过");
        map.put("userName","system");
        try {
            String s = post1("http://http://10.55.5.36:8080/api/autoReview", map);
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
