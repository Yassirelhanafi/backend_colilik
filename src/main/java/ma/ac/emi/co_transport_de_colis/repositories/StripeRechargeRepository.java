package ma.ac.emi.co_transport_de_colis.repositories;

import ma.ac.emi.co_transport_de_colis.entities.StripeRecharge;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StripeRechargeRepository extends MongoRepository<StripeRecharge, String> {
}
