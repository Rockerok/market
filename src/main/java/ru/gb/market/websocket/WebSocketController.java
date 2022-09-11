package ru.gb.market.websocket;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;
import ru.gb.market.controllers.FileController;
import ru.gb.market.model.FileSaveRequest;
import ru.gb.market.model.Product;

import java.time.LocalDate;
import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@RequestMapping("/export")
public class WebSocketController {

    FileSaveRequest fileSaveRequest;
    FileController fileController;
    private final SimpMessagingTemplate simpMessagingTemplate;
//

    @MessageMapping("/hello")
    // @SendTo("/topic/greetings")
    public WebSocketContent greeting(WebSocketMessage message) {
        return new WebSocketContent("You have chosen to export products with a category: " + HtmlUtils.htmlEscape(message.getNameCategories()) + "!");
    }

    @PutMapping
    public WebSocketContent put(@RequestBody WebSocketMessage message) {
        message.setNameCategories(message.getNameCategories());
        fileSaveRequest = new FileSaveRequest();
        fileSaveRequest.setNameFile(message.getNameCategories()+ LocalDate.now());
        HashMap <Long, Product> content = new HashMap<>();
        fileSaveRequest.setText(String.valueOf(content));
        WebSocketContent greeting;
        if (fileController.saveString(fileSaveRequest)) {
            greeting = new WebSocketContent("Export products with a category:  " + HtmlUtils.htmlEscape(message.getNameCategories()) + " is Complete! ");

        } else{
            greeting = new WebSocketContent("Export products with a category:  " + HtmlUtils.htmlEscape(message.getNameCategories()) + " NOT Complete! ");
        }
        simpMessagingTemplate.convertAndSend("/topic/greetings", greeting);
        return greeting;
    }

}
