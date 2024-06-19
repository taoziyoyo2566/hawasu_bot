package net.taoziyoyo.haawasu_bot;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.CopyMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Log4j2
public class Hello extends TelegramLongPollingBot {

    Logger logger = LoggerFactory.getLogger(TelegramLongPollingBot.class);
    /**
     * @param update Update
     */
    @Override
    public void onUpdateReceived(Update update) {
        var msg = update.getMessage();
        var user = msg.getFrom();
        System.out.println(user.getFirstName()+" wrote: "+ msg.getText());
        // Log the chat ID
        System.out.println("Chat ID: " + msg.getChatId());
        var id = user.getId();
        sendText(id, msg.getText());
        logger.info(user.toString());
    }

    public void inonUpdateReceived(Long who, Integer msgId){
        CopyMessage cm = CopyMessage.builder()
                .fromChatId(who.toString())  //We copy from the user
                .chatId(who.toString())      //And send it back to him
                .messageId(msgId)            //Specifying what message
                .build();
        try {
            execute(cm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

    }
    public void sendText(Long who, String what){
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString())
                .text(what)
                .build();
        try {
            execute(sm);

        } catch (TelegramApiException e) {
            logger.error("Error sending message: {}", e.getMessage(), e);

        }
    }

    /**
     * @return botUsername
     */
    @Override
    public String getBotUsername() {
        return "hawasu_bot";
    }


    @Override
    public String getBotToken(){
        return "7090950882:AAFKsJOhJKsiwg_CDtuNb_-C9cL332LYlFc";
    }
}
