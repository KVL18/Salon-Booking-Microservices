package com.kvl.service.impl;

import com.kvl.domain.PaymentMethod;
import com.kvl.model.PaymentOrder;
import com.kvl.payload.dto.BookingDTO;
import com.kvl.payload.dto.UserDTO;
import com.kvl.payload.response.PaymentLinkResponse;
import com.kvl.service.PaymentService;
import com.razorpay.PaymentLink;
import com.stripe.Stripe;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    @Override
    public PaymentLinkResponse createOrder(UserDTO user, BookingDTO booking, PaymentMethod paymentMethod) {
        return null;
    }

    @Override
    public PaymentOrder getPaymentOrderById(Long id) {
        return null;
    }

    @Override
    public PaymentOrder getPaymentOrderByPaymentId(String paymentId) {
        return null;
    }

    @Override
    public PaymentLink createRazorpayPaymentLink(UserDTO user, Long amount, Long orderId) {
        return null;
    }

    @Override
    public Stripe createStripePaymentLink(UserDTO user, Long amount, Long orderId) {
        return null;
    }
}
