package ConectarApiRest.D1_UD6.date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Pokemon(
        String name,
        Integer height,
        @JsonProperty("species") Species especies
) {
    public String toString() {
        return "Pokemon: " + name + "| Especie: " + especies != null? especies.name(): "desconocido";
    }
}
