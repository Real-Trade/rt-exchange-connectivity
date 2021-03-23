package com.exchange.exchangeConnectivity.model;
//import android.arch.persistence.room.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import java.util.Date;
@Entity
public class Portfolio {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int portfolioId;

    private int clientId;

    private String portfolioName;

    private Date createdAt;

    private Date updatedAt;


}
