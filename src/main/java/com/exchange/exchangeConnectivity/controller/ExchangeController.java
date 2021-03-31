package com.exchange.exchangeConnectivity.controller;
import com.exchange.exchangeConnectivity.ExchangeApplication;
import com.exchange.exchangeConnectivity.helper.RedisPoolConfig;
import com.exchange.exchangeConnectivity.model.*;
import com.exchange.exchangeConnectivity.repo.OrderRepository;
import com.exchange.exchangeConnectivity.service.ExchangeClient;
import com.exchange.exchangeConnectivity.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;



import java.util.List;
//import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.exchange.exchangeConnectivity.helper.Helper.removeQuotesFromStartAndEndOfString;


@RestController

@RequestMapping(path="/exchange")
public class ExchangeController {

    //private static final Logger logger = LoggerFactory.getLogger(ExchangeApplication.class);

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;


    OrderInfo n = new OrderInfo();
    ExchangeClient ec= new ExchangeClient();
    PostOrder p = new PostOrder();



    @PostMapping(path="/receiveOrders")
    public @ResponseBody
    OrderServiceResponse postBody(@RequestBody OrderInfo order)  {

        var oderIds= order.getOrderId();
        var orderPrice = order.getPrice();
        var quantity = order.getQuantity();
        var clientId=order.getClientId();
        var side=order.getSide();
        var product=order.getProduct();
        var portfolioId=order.getPortfolioId();

        n.setOrderId(oderIds);
        n.setPrice(orderPrice);
        n.setQuantity(quantity);
        n.setClientId(clientId);
        n.setSide(side);
        n.setProduct(product);
        n.setPortfolioId(portfolioId);


        p.price=orderPrice; //2
        p.quantity=quantity; //4
        p.side=side;//BUY
        p.product=product; //"IBM";



        String result = ec.createOrder(p);

       String trimmedResult = removeQuotesFromStartAndEndOfString(result);

        n.setExchangeOrderId(trimmedResult);


        Client client= new Client();
        client.setClientId(clientId);


        ClientOrder c = new ClientOrder();
        c.setClient(client);

        c.setExchangeOrderId(trimmedResult);
        c.setStatus("PENDING");


        var data=  orderService.data(c);

        return data;

    }




    @PostMapping(path="/updateOrders")
    public @ResponseBody
    String updateOrder(@RequestBody PostOrder order)  {

        var exchangeOrderId= order.exchangeOrderId;
        var orderPrice = order.price;
        var quantity = order.quantity;
        var orderId = order.OrderId;
        var side=order.side;
        var product=order.product;

        var clientId= order.clientId;

        var  malonExchange =order.MalonExchange;

        p.price=orderPrice; //2
        p.quantity=quantity; //4
        p.side=side;//BUY
        p.product=product; //"IBM";
        //p.clientId=clientId;
       // p.MalonExchange=malonExchange;


        String result = ec.updateOrder(p,clientId,malonExchange,orderId,exchangeOrderId);

        return  result;
    }




//    @Scheduled(fixedRate = 5000)
//    public void getOrderFromQueue() {
//        try(Jedis jedis = RedisPoolConfig.getJedisPool().getResource()) {
//            List<String> orderList = jedis.blpop(3, "trade-order-queue");
//            logger.debug("Received: "+ orderList.get(0));
//        }catch (Exception e) {
//            logger.error("jedis client failed: "+ e.getMessage());
//        }
//    }




    @PostMapping(path="/deleteOrders")
    public @ResponseBody
   String deleteOrder(@RequestBody deleteOrder order)  {

        var orderId= order.getOrderId();
        var data = ec.deleteExchangeOrder(orderId);
        return data;
    }


}
