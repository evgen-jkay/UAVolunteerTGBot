package com.eugene_dev.handler.impl;

import com.eugene_dev.enums.ConversationState;
import com.eugene_dev.handler.UserRequestHandler;
import com.eugene_dev.helper.KeyboardHelper;
import com.eugene_dev.model.UserRequest;
import com.eugene_dev.model.UserSession;
import com.eugene_dev.service.TelegramService;
import com.eugene_dev.service.UserSessionService;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

@Component
public class CityEnteredHandler extends UserRequestHandler {

    private final TelegramService telegramService;
    private final KeyboardHelper keyboardHelper;
    private final UserSessionService userSessionService;

    public CityEnteredHandler(TelegramService telegramService, KeyboardHelper keyboardHelper, UserSessionService userSessionService) {
        this.telegramService = telegramService;
        this.keyboardHelper = keyboardHelper;
        this.userSessionService = userSessionService;
    }

    @Override
    public boolean isApplicable(UserRequest userRequest) {
        return isTextMessage(userRequest.getUpdate())
                && ConversationState.WAITING_FOR_CITY.equals(userRequest.getUserSession().getState());
    }

    @Override
    public void handle(UserRequest userRequest) {
        ReplyKeyboardMarkup replyKeyboardMarkup = keyboardHelper.buildMenuWithCancel();
        telegramService.sendMessage(userRequest.getChatId(),
                "✍️Тепер опишіть яка допомога вам потрібна⤵️",
                replyKeyboardMarkup);

        String city = userRequest.getUpdate().getMessage().getText();

        UserSession session = userRequest.getUserSession();
        session.setCity(city);
        session.setState(ConversationState.WAITING_FOR_TEXT);
        userSessionService.saveSession(userRequest.getChatId(), session);
    }

    @Override
    public boolean isGlobal() {
        return false;
    }

}