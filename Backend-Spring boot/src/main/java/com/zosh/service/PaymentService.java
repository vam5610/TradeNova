package com.TradeNova.service;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import com.TradeNova.domain.PaymentMethod;
import com.TradeNova.model.PaymentOrder;
import com.TradeNova.model.User;
import com.TradeNova.response.PaymentResponse;

public interface PaymentService {

    PaymentOrder createOrder(User user, Long amount, PaymentMethod paymentMethod);

    PaymentOrder getPaymentOrderById(Long id) throws Exception;

    Boolean ProccedPaymentOrder (PaymentOrder paymentOrder,
                                 String paymentId) throws RazorpayException;

    PaymentResponse createRazorpayPaymentLink(User user,
                                              Long Amount,
                                              Long orderId) throws RazorpayException;

    PaymentResponse createStripePaymentLink(User user, Long Amount,
                                            Long orderId) throws StripeException;
}

