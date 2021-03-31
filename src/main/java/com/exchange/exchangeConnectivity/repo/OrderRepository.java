package com.exchange.exchangeConnectivity.repo;

import com.exchange.exchangeConnectivity.model.Client;
import com.exchange.exchangeConnectivity.model.ClientOrder;
import com.exchange.exchangeConnectivity.model.OrderInfo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OrderRepository  extends CrudRepository<ClientOrder, Integer> {

   // public ClientOrder findByOrderId(clientId);

    // ClientOrder findById(clientId);

//    @Query("select u from client_order u where u.order_id=?1 and u.client_id =?2")
//     ClientOrder findByOrderId( int orderId,
//                                  int clientId);


}