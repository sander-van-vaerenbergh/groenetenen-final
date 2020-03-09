package be.vdab.groenetenen.restservices;

import be.vdab.groenetenen.domain.Filiaal;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.EntityLinks;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class FiliaalModel extends RepresentationModel<FiliaalModel> {
    @SuppressWarnings("unused")
    private Filiaal filiaal;
    FiliaalModel(){}
    FiliaalModel(Filiaal filiaal, EntityLinks entityLinks){
        this.filiaal = filiaal;
        super.add(entityLinks.linkToItemResource(
                Filiaal.class, filiaal.getId()));
        super.add(entityLinks.linkForItemResource(Filiaal.class, filiaal.getId())
                .slash("werknemers").withRel("werknemers"));
    }
}
