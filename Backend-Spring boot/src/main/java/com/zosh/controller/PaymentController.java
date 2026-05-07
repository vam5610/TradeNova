package com.TradeNova.controller;

import com.razorpay.RazorpayException;
import com.stripe.exception.StripeException;
import com.TradeNova.domain.PaymentMethod;
import com.TradeNova.domain.PaymentOrderStatus;
import com.TradeNova.exception.UserException;
import com.TradeNova.model.PaymentOrder;
import com.TradeNova.model.User;
import com.TradeNova.repository.PaymentOrderRepository;
import com.TradeNova.response.PaymentResponse;
import com.TradeNova.service.PaymentService;
import com.TradeNova.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Autowired
    private UserService userService;

    @Autowired
    private PaymentService paymentService;



    @PostMapping("/api/payment/{paymentMethod}/amount/{amount}")
    public ResponseEntity<PaymentResponse> paymentHandler(
            @PathVariable PaymentMethod paymentMethod,
            @PathVariable Long amount,
            @RequestHeader("Authorization") String jwt) throws UserException, RazorpayException, StripeException {

        User user = userService.findUserProfileByJwt(jwt);

        PaymentResponse paymentResponse;

        PaymentOrder order= paymentService.createOrder(user, amount,paymentMethod);

        if(paymentMethod.equals(PaymentMethod.RAZORPAY)){
            paymentResponse=paymentService.createRazorpayPaymentLink(user,amount,
                    order.getId());
        }
        else{
            paymentResponse=paymentService.createStripePaymentLink(user,amount, order.getId());
        }

        return new ResponseEntity<>(paymentResponse, HttpStatus.CREATED);
    }


}

