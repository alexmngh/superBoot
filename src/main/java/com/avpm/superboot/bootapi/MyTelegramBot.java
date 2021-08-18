package com.avpm.superboot.bootapi;


import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Описание бина нашего бота
 */
@Slf4j
public class MyTelegramBot extends TelegramWebhookBot {
    private String webHookPath;
    private String botUserName;
    private String botToken;

    public MyTelegramBot(DefaultBotOptions botOptions) {
        super(botOptions);
    }

    public MyTelegramBot() {

    }


    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotPath() {
        return webHookPath;
    }

    @Override
    public BotApiMethod<?> onWebhookUpdateReceived(Update update) {
        log.info("onWebhookUpdateReceived - - -  start" );
    //Просто возвращаем ответ на любое сообщение
    if (update.getMessage() != null && update.getMessage().hasText()) {
      long chat_id = update.getMessage().getChatId();
      String user = update.getMessage().getFrom().getUserName();
      try {
//        execute(new SendMessage(chat_id, "привет мир " + update.getMessage().getText()));
        execute(new SendMessage(chat_id, "привет мир"));
//        log.info("user = " + user);
      } catch (TelegramApiException e) {
        e.printStackTrace();
      }
    }
    return null;



//        return replyMessageToUser;
    }


    public void setWebHookPath(String webHookPath) {
        this.webHookPath = webHookPath;
    }

    public void setBotUserName(String botUserName) {
        this.botUserName = botUserName;
    }

    public void setBotToken(String botToken) {
        this.botToken = botToken;
    }
}
