package BBDD.pruebaMySql;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path="/demo")
public class UsuarioController {
    private RepositorioUsuarios repositorioUsuarios;

    public UsuarioController(RepositorioUsuarios repositorioUsuarios) {
        this.repositorioUsuarios = repositorioUsuarios;
    }

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam(name = "nombre") String nombre
            , @RequestParam(value = "email") String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Usuario n = new Usuario();
        n.setNombre(nombre);
        n.setEmail(email);
        repositorioUsuarios.save(n);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Usuario> getAllUsers() {
        // This returns a JSON or XML with the users
        return repositorioUsuarios.findAll();
    }
}
