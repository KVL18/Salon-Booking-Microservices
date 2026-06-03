package com.kvl.controller;


import com.kvl.domain.PaymentMethod;
import com.kvl.model.PaymentOrder;
import com.kvl.payload.dto.BookingDTO;
import com.kvl.payload.dto.UserDTO;
import com.kvl.payload.response.PaymentLinkResponse;
import com.kvl.service.PaymentService;
import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/create")
    public ResponseEntity<PaymentLinkResponse> createPaymentLink(
            @RequestBody BookingDTO booking,
            @RequestParam PaymentMethod paymentMethod
            ) throws StripeException, RazorpayException {
        UserDTO user =  new UserDTO();
        user.setFullName("Ashok");
        user.setEmail("ashok@gmail.com");
        user.setId(1L);

        PaymentLinkResponse res = paymentService.createOrder(user,booking,paymentMethod);
        return ResponseEntity.ok(res);

    }

    @GetMapping("/{paymentOrderId}")
    public ResponseEntity<PaymentOrder> getPaymentOrderById(
           @PathVariable Long paymentOrderId
    ) throws  Exception {
       PaymentOrder res = paymentService.getPaymentOrderById(paymentOrderId);
       return ResponseEntity.ok(res);


    }

    @PatchMapping("/proceed")
    public ResponseEntity<Boolean> proceedPayment(
            @RequestParam String paymentId,
            @RequestParam String paymentLinkId
    ) throws  Exception {

        PaymentOrder paymentOrder = paymentService.getPaymentOrderByPaymentId(paymentLinkId);
        Boolean res = paymentService.proceedPayment(paymentOrder,
                paymentId,
                paymentLinkId);
        return ResponseEntity.ok(res);


    }

}
