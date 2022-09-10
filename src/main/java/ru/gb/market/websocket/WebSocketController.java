package ru.gb.market.websocket;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;
import ru.gb.market.model.FileSaveRequest;
import ru.gb.market.model.Product;
import ru.gb.market.services.FileService;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/export")
public class WebSocketController {

    private final SimpMessagingTemplate simpMessagingTemplate;
    private final FileSaveRequest fileSaveRequest;

    @MessageMapping("/hello")
    // @SendTo("/topic/greetings")
    public WebSocketContent greeting(WebSocketMessage message) {
        return new WebSocketContent("You have chosen to export products with a category: " + HtmlUtils.htmlEscape(message.getNameCategories()) + "!");
    }

    @PutMapping
    public WebSocketContent put(@RequestBody WebSocketMessage message) {
        message.setNameCategories(message.getNameCategories());
        fileSaveRequest.setName(message.getNameCategories()+ LocalDate.now());
        HashMap <Long, Product> content = new HashMap<>();
        fileSaveRequest.setText(String.valueOf(content));
        WebSocketContent greeting = new WebSocketContent("Export products with a category:  " + HtmlUtils.htmlEscape(message.getNameCategories()) + "! ");
        simpMessagingTemplate.convertAndSend("/topic/greetings", greeting);
        return greeting;
    }

}
