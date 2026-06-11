package org.smmbot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {
    private final Gemini gemini = new Gemini();

    public Bot(String botToken) {
        super(botToken);
    }

    @Override
    public String getBotUsername() {
        return "maleshko_smm_bot";
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (!update.hasMessage() || !update.getMessage().hasText()) return;

        String text = update.getMessage().getText();
        Long chatId = update.getMessage().getChatId();

        if (text.equals("/start")) {
            sendText(chatId, "Я живий");
            return;
        }

        try {
            sendText(chatId, "Генерую пост...");
            String post = gemini.generatePost(text);
            sendText(chatId, post);
        } catch (Exception e) {
            System.err.println("Помилка Gemini: " + e.getMessage());
            sendText(chatId, "Помилка генерації. Спробуй ще раз.");
        }
    }

    private void sendText(Long chatId, String text) {
        SendMessage message = SendMessage.builder()
                .chatId(chatId.toString())
                .text(text)
                .build();

        try {
            execute(message);
        } catch (TelegramApiException e) {
            System.err.println("Помилка надсилання: " + e.getMessage());
        }
    }
}
