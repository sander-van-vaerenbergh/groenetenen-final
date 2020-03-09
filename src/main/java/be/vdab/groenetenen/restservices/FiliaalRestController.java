package be.vdab.groenetenen.restservices;

import be.vdab.groenetenen.domain.Filiaal;
import be.vdab.groenetenen.services.FiliaalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("filialen")
public class FiliaalRestController {
    private final FiliaalService filiaalService;
    FiliaalRestController(FiliaalService filiaalService){
        this.filiaalService = filiaalService;
    }

    @GetMapping("{filiaal}")
    Filiaal get(@PathVariable Optional<Filiaal> filiaal){
        return filiaal.get();
    }
}
