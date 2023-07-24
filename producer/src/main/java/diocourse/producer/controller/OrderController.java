package diocourse.producer.controller;

import diocourse.producer.data.OrderData;
import diocourse.producer.service.EventRegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final EventRegisterService eventRegisterService;

    @PostMapping("")
    public ResponseEntity<String> saveOrder(@RequestBody OrderData orderData) {
        eventRegisterService.addEvent("SaveOrder", orderData);
        return ResponseEntity.ok("Success");
    }
}
