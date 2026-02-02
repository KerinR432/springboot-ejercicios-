package ConectarApiRest.D1_UD6;

import ConectarApiRest.D1_UD6.date.Pokemon;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class ControllablePokemon {
    @GetMapping("/ver-pokemon")
    public Mono<Pokemon> verPokemon() {
        WebClient webClient = WebClient.create("https://pokeapi.co/api/v2");
        return webClient
                .get()
                .uri("/pokemon/bulbasaur")
                .retrieve()
                .bodyToMono(Pokemon.class);
    }
}
