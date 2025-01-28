package ma.ac.emi.co_transport_de_colis.services;

import ma.ac.emi.co_transport_de_colis.entities.Recharge;
import ma.ac.emi.co_transport_de_colis.entities.Item;
import ma.ac.emi.co_transport_de_colis.repositories.RechargeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RechargeService {

    @Autowired
    private RechargeRepository rechargeRepository;

    public Recharge createRecharge(Recharge recharge) {
        return rechargeRepository.save(recharge);
    }

    public List<Recharge> getAllRecharges() {
        return rechargeRepository.findAll();
    }

    public Optional<Recharge> getRechargeById(String idRecharge) {
        return rechargeRepository.findById(idRecharge);
    }

    public Recharge updateRecharge(String idRecharge, Recharge updatedRecharge) {
        return rechargeRepository.findById(idRecharge)
                .map(recharge -> {
                    recharge.setAmount(updatedRecharge.getAmount());
                    recharge.setDate(updatedRecharge.getDate());
                    return rechargeRepository.save(recharge);
                })
                .orElseThrow(() -> new RuntimeException("Recharge not found : " + idRecharge));
    }

    public void deleteRecharge(String idRecharge) {
        rechargeRepository.deleteById(idRecharge);
    }



}
