package be.vdab.groenetenen.services;

import be.vdab.groenetenen.domain.Filiaal;
import be.vdab.groenetenen.exceptions.FiliaalHeeftNogWerknemersException;
import be.vdab.groenetenen.repositories.FiliaalRepository;
import be.vdab.groenetenen.restservices.FilialenModel;
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

    @Override
    public void delete(Filiaal filiaal){
        if (!filiaal.getWerknemer().isEmpty()){
            throw new FiliaalHeeftNogWerknemersException();
        }
        filiaalRepository.delete(filiaal);
    }

    @Override
    public void create(Filiaal filiaal){
        filiaalRepository.save(filiaal);
    }

    @Override
    public void update(Filiaal filiaal){
        filiaalRepository.save(filiaal);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Filiaal> findAll(){
        return filiaalRepository.findAll();
    }
}
