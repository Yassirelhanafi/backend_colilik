package ma.ac.emi.co_transport_de_colis.repositories;

import ma.ac.emi.co_transport_de_colis.entities.PaypalRecharge;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaypalRechargeRepository extends MongoRepository<PaypalRecharge, String> {
}
