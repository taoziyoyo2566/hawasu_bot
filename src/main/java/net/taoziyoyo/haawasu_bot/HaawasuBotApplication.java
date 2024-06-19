package net.taoziyoyo.haawasu_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class HaawasuBotApplication {

    public static void main(String[] args) throws TelegramApiException {
        SpringApplication.run(HaawasuBotApplication.class, args);

        TelegramBotsApi botsApi = new
                TelegramBotsApi(DefaultBotSession.class);

        Hello bot = new Hello();
        botsApi.registerBot(bot);
        bot.sendText(6236317990L,"Hello hawasu_bot");

    }

}
