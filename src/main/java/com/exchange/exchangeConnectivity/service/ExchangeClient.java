package com.exchange.exchangeConnectivity.service;

import com.exchange.exchangeConnectivity.model.PostOrder;
import com.exchange.exchangeConnectivity.model.deleteOrder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ExchangeClient {

    RestTemplate restTemplate = new RestTemplate();

    public String createOrder(PostOrder p){

        String url="https://exchange.matraining.com/4ce06004-76ce-4d27-a2d5-5e379c62d280/order";

        String result= restTemplate.postForObject(url,p,String.class);

        return result.toString();

    }



    public String updateOrder(PostOrder p){

        String url="https://exchange.matraining.com/4ce06004-76ce-4d27-a2d5-5e379c62d280/order";

        String result= restTemplate.postForObject(url,p,String.class);

        return result.toString();

    }



    public String deleteExchangeOrder(String orderId){

        var orderId1=orderId;

        deleteOrder d = new deleteOrder();

        String url="https://exchange.matraining.com/4ce06004-76ce-4d27-a2d5-5e379c62d280/order/"+orderId1;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<deleteOrder> entity = new HttpEntity<deleteOrder>(d,headers);

        return restTemplate.exchange(url,HttpMethod.DELETE,entity, String.class).getBody();
    }












}
