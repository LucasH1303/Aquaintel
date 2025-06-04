package br.com.floodreport.auth;

import br.com.floodreport.dto.UsuarioDTO;
import br.com.floodreport.model.Usuario;
import br.com.floodreport.repository.UsuarioRepository;
import br.com.floodreport.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioRepository repository;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;

    @PostMapping("/register")
    public Map<String, String> register(@RequestBody UsuarioDTO dto) {
        if (repository.findByEmail(dto.email()).isPresent()) {
            throw new RuntimeException("Email já cadastrado");
        }

        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setSenha(encoder.encode(dto.senha()));

        repository.save(usuario);

        String token = jwtService.generateToken(usuario.getEmail());

        return Map.of("token", token);
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody UsuarioDTO dto) {
        var usuario = repository.findByEmail(dto.email())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!encoder.matches(dto.senha(), usuario.getSenha())) {
            throw new RuntimeException("Senha inválida");
        }

        String token = jwtService.generateToken(usuario.getEmail());

        return Map.of("token", token);
    }
}
