package be.vdab.groenetenen.domain;

import be.vdab.groenetenen.constraints.Postcode;
import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@Embeddable
@XmlAccessorType(XmlAccessType.FIELD)
@JsonAutoDetect(fieldVisibility= JsonAutoDetect.Visibility.ANY)
public class Adres {
    @NotBlank
    private String straat;
    @NotBlank
    private String huisNr;
    @NotNull
    @Postcode
    private int postcode;
    @NotBlank
    private String gemeente;

    public String getStraat() {
        return straat;
    }

    public String getHuisNr() {
        return huisNr;
    }

    public int getPostcode() {
        return postcode;
    }

    public String getGemeente() {
        return gemeente;
    }
}
