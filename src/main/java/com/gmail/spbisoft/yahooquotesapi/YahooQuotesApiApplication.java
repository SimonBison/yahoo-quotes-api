package com.gmail.spbisoft.yahooquotesapi;

import com.gmail.spbisoft.yahooquotesapi.dto.QuoteDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;

@SpringBootApplication
public class YahooQuotesApiApplication {

    public QuoteDto getStock(String stockName) throws IOException {

        QuoteDto dto = null;
        Stock stock = YahooFinance.get(stockName);
        dto = new QuoteDto(stock.getName(), stock.getQuote().getPrice(), stock.getQuote().getChange(),
                stock.getCurrency(), stock.getQuote().getBid());
        return dto;
    }

    public static void main(String[] args) throws IOException {
        SpringApplication.run(YahooQuotesApiApplication.class, args);

        YahooQuotesApiApplication yahooQuotesApiApplication = new YahooQuotesApiApplication();
        System.out.println(yahooQuotesApiApplication.getStock("GE"));
    }

}

