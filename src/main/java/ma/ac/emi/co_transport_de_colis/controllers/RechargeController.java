package ma.ac.emi.co_transport_de_colis.controllers;

import com.stripe.Stripe;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import ma.ac.emi.co_transport_de_colis.entities.PaymentRequest;
import ma.ac.emi.co_transport_de_colis.entities.Recharge;
import ma.ac.emi.co_transport_de_colis.entities.User;
import ma.ac.emi.co_transport_de_colis.services.RechargeService;
import ma.ac.emi.co_transport_de_colis.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/payments")
public class RechargeController {

    @Value("${stripe.secret.key}")
    private String stripeApiKey;

    private RechargeService rechargeService;
    private UserService userService;

    @Autowired
    public RechargeController(RechargeService rechargeService, UserService userService) {
        Stripe.apiKey = stripeApiKey;
        this.rechargeService = rechargeService;
        this.userService = userService;
    }

    public RechargeController() {
        Stripe.apiKey = stripeApiKey;
    }

    @PostMapping("/charge")
    public ResponseEntity<?> createPaymentIntent(@RequestBody @Validated PaymentRequest request) {
        try {
            // Créer les paramètres du PaymentIntent
            System.out.println(request.getAmount());
            System.out.println(request.getCurrency());
            PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                    .setAmount(request.getAmount())
                    .setCurrency("mad")
                    .setAutomaticPaymentMethods(
                            PaymentIntentCreateParams.AutomaticPaymentMethods.builder().setEnabled(true).build()
                    )
                    .build();

            System.out.println(params.getStatementDescriptorSuffix());

            PaymentIntent paymentIntent = PaymentIntent.create(params);

            System.out.println(paymentIntent.getId());
            System.out.println(ResponseEntity.ok().body(paymentIntent.getClientSecret()));

            Recharge recharge = new Recharge();
            recharge.setAmount(request.getAmount());
            recharge.setId(paymentIntent.getId());
            recharge.setDate(LocalDateTime.now());
            recharge.setId_user(request.getId_user());


            rechargeService.createRecharge(recharge);
            User user = userService.getUser(request.getId_user());

            userService.rechargeSolde(user, request.getAmount()/100);

            return ResponseEntity.ok().body(paymentIntent.getClientSecret());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error creating PaymentIntent: " + e.getMessage());
        }
    }
}
