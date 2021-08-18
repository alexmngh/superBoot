package com.avpm.superboot.config;

import com.avpm.superboot.bootapi.MyTelegramBot;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.meta.ApiContext;

/**
 * Создание бина нашего бота
 */
@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "telegrambot")
public class BotConfig {

    private String webHookPath;
    private String botUserName;
    private String botToken;

//    private DefaultBotOptions.ProxyType proxyType;
//    private String proxyHost;
//    private int proxyPort;

    /**
     * Бин нашего бота
     * @return
     */
    @Bean
    public MyTelegramBot myTelegramBot() {
        DefaultBotOptions options = ApiContext.getInstance(DefaultBotOptions.class);

        MyTelegramBot settingTelegramBot = new MyTelegramBot(options);
        settingTelegramBot.setBotUserName(botUserName);
        settingTelegramBot.setBotToken(botToken);
        settingTelegramBot.setWebHookPath(webHookPath);

        return settingTelegramBot;
    }

}
