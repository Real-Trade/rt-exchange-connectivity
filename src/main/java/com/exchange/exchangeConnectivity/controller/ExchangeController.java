package com.exchange.exchangeConnectivity.controller;
import com.exchange.exchangeConnectivity.model.*;
import com.exchange.exchangeConnectivity.repo.OrderRepository;
import com.exchange.exchangeConnectivity.service.ExchangeClient;
import com.exchange.exchangeConnectivity.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.exchange.exchangeConnectivity.helper.Helper.removeQuotesFromStartAndEndOfString;


@RestController

@RequestMapping(path="/exchange")
public class ExchangeController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderService orderService;


    clientOrder n = new clientOrder();
    ExchangeClient ec= new ExchangeClient();
    PostOrder p = new PostOrder();



    @PostMapping(path="/receiveOrders")
    public @ResponseBody
    OrderServiceResponse postBody(@RequestBody clientOrder order)  {

        var oderIds= order.getOrderId();
        var orderPrice = order.getPrice();
        var quantity = order.getQuantity();
        var clientId=order.getClientId();
        var side=order.getSide();
        var product=order.getProduct();
        var exchangeOrderId=order.getExchangeOrderId();
        var status =order.getStatus();
        var portfolioId=order.getPortfolioId();

        n.setOrderId(oderIds);
        n.setPrice(orderPrice);
        n.setQuantity(quantity);
        n.setClientId(clientId);
        n.setSide(side);
        n.setProduct(product);
        n.setExchangeOrderId(exchangeOrderId);
        n.setStatus(status);
        n.setPortfolioId(portfolioId);


        p.price=orderPrice; //2
        p.quantity=quantity; //4
        p.side=side;//BUY
        p.product=product; //"IBM";



        String result = ec.createOrder(p);

       String trimmedResult = removeQuotesFromStartAndEndOfString(result);

        n.setExchangeOrderId(trimmedResult);

        var data=  orderService.data(n);

        return data;

    }




    @PostMapping(path="/updateOrders")
    public @ResponseBody
    String updateOrder(@RequestBody PostOrder order)  {

        var oderIds= order.id;
        var orderPrice = order.price;
        var quantity = order.quantity;

        var side=order.side;
        var product=order.product;

        p.price=orderPrice; //2
        p.quantity=quantity; //4
        p.side=side;//BUY
        p.product=product; //"IBM";

        String result = ec.updateOrder(p);

        return  result;
    }






    @PostMapping(path="/deleteOrders")
    public @ResponseBody
   String deleteOrder(@RequestBody deleteOrder order)  {

        var orderId= order.getOrderId();
        var data = ec.deleteExchangeOrder(orderId);
        return data;
    }








}
