package be.vdab.groenetenen.restservices;

import be.vdab.groenetenen.domain.Filiaal;
import be.vdab.groenetenen.exceptions.FiliaalHeeftNogWerknemersException;
import be.vdab.groenetenen.exceptions.FiliaalNietGevondenException;
import be.vdab.groenetenen.services.FiliaalService;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("filialen")
@ExposesResourceFor(Filiaal.class)
public class FiliaalRestController {
    private final FiliaalService filiaalService;
    FiliaalRestController(FiliaalService filiaalService){
        this.filiaalService = filiaalService;
    }

    @GetMapping("{filiaal}")
    Filiaal get(@PathVariable Optional<Filiaal> filiaal){
        if (filiaal.isPresent()){
            return filiaal.get();
        }
        throw new FiliaalNietGevondenException();
    }

    @ExceptionHandler(FiliaalNietGevondenException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    void filiaalNietGevonden(){
    }

    @DeleteMapping("{filiaal}")
    void delete(@PathVariable Optional<Filiaal> filiaal){
        if (!filiaal.isPresent()){
            throw new FiliaalNietGevondenException();
        }
        filiaalService.delete(filiaal.get());
    }

    @ExceptionHandler(FiliaalHeeftNogWerknemersException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    String filiaalHeeftNogWerknemers(){
        return "filiaal heeft nog werknemers";
    }

    @PostMapping
    void create(@RequestBody @Valid Filiaal filiaal){
        filiaalService.create(filiaal);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String filiaalMetVerkeerdeProporties(MethodArgumentNotValidException ex){
        StringBuilder fouten = new StringBuilder();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                fouten.append(error.getField()).append(':')
                    .append(error.getDefaultMessage()).append('\n'));
        fouten.deleteCharAt(fouten.length() -1);
        return fouten.toString();
    }

    @PutMapping("{id}")
    void update(@RequestBody @Valid Filiaal filiaal){
        filiaalService.update(filiaal);
    }
}
