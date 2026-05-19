package com.kvl.service;

import com.kvl.domain.PaymentMethod;
import com.kvl.model.PaymentOrder;
import com.kvl.payload.dto.BookingDTO;
import com.kvl.payload.dto.UserDTO;
import com.kvl.payload.response.PaymentLinkResponse;
import com.razorpay.PaymentLink;
import com.stripe.Stripe;

public interface PaymentService {

    PaymentLinkResponse createOrder(UserDTO user, BookingDTO booking,
                                    PaymentMethod paymentMethod);

    PaymentOrder getPaymentOrderById(Long id);
    PaymentOrder getPaymentOrderByPaymentId(String paymentId);

    PaymentLink createRazorpayPaymentLink(UserDTO user,
                                          Long amount,
                                          Long orderId);

    Stripe createStripePaymentLink(UserDTO user,
                                   Long amount,
                                   Long orderId);
}
