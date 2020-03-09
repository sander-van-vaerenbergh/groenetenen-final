package be.vdab.groenetenen.services;

import be.vdab.groenetenen.domain.Filiaal;
import be.vdab.groenetenen.repositories.FiliaalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DefaultFiliaalService implements FiliaalService{
    private final FiliaalRepository filiaalRepository;

    public DefaultFiliaalService(FiliaalRepository filiaalRepository){
        this.filiaalRepository = filiaalRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Filiaal> findByPostcode(int van, int tot){
        return filiaalRepository.findByAdresPostcodeBetweenOrderByAdresPostcode(van, tot);
    }
}
