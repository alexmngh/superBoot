package com.avpm.superboot.controller;

import com.avpm.superboot.bootapi.MyTelegramBot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

@RestController
@Slf4j
public class WebHookController {
    private final MyTelegramBot telegramBot;

    public WebHookController(MyTelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public BotApiMethod<?> onUpdateReceived(@RequestBody Update update) {
//        log.info("onUpdateReceived - start");
        return telegramBot.onWebhookUpdateReceived(update);
    }

}
