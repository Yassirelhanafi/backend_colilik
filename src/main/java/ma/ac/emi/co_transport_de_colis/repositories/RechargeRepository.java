package ma.ac.emi.co_transport_de_colis.repositories;

import ma.ac.emi.co_transport_de_colis.entities.Recharge;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RechargeRepository extends MongoRepository<Recharge, String> {
}
