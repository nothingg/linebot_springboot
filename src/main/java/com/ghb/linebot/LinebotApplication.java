package com.ghb.linebot;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;



@SpringBootApplication
public class LinebotApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(LinebotApplication.class, args);
	}
	

	
	

}
