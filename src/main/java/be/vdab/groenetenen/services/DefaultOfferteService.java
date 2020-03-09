package be.vdab.groenetenen.services;

import be.vdab.groenetenen.domain.Offerte;
import be.vdab.groenetenen.repositories.OfferteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DefaultOfferteService implements OfferteService{
    private final OfferteRepository offerteRepository;

    DefaultOfferteService(OfferteRepository offerteRepository){
        this.offerteRepository = offerteRepository;
    }

    @Override
    public void create(Offerte offerte){
        offerteRepository.save(offerte);
    }
}
