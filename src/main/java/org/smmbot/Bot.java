package org.smmbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Bot extends TelegramLongPollingBot {

    public Bot(String botToken) {
        super(botToken);
    }

    @Override
    public String getBotUsername() {
        return "smmbot";
    }

    @Override
    public void onUpdateReceived(Update update) {
    }
}
