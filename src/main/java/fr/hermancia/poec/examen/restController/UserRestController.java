package fr.hermancia.poec.examen.restController;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hermancia.poec.examen.DTO.AuthenticationDTO;
import fr.hermancia.poec.examen.DTO.RegistrationUserDTO;
import fr.hermancia.poec.examen.entity.User;
import fr.hermancia.poec.examen.json_views.JsonViews;
import fr.hermancia.poec.examen.security.JwtService;
import fr.hermancia.poec.examen.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;



    @Validated
    @RestController
    @AllArgsConstructor
    @RequestMapping("/api/user")
    public class UserRestController {


        private AuthenticationManager authenticationManager;
        private UserService userService;
        private JwtService jwtService;

        @GetMapping
        @JsonView(JsonViews.UserListView.class)
        List<User> findAll() {
            return userService.findAll();
        }


        @ResponseStatus(value = HttpStatus.CREATED)
        @PostMapping(path = "/inscription")
        @JsonView(JsonViews.UserListView.class)
        public void create(@Valid @RequestBody RegistrationUserDTO registrationUserDTO) {
            this.userService.create(registrationUserDTO);
            System.out.println("Hello, World!");
        }



        @ResponseStatus(value = HttpStatus.CREATED)
        @PostMapping(path = "/activation")
        public void activate(@Valid @RequestBody Map<String, String> activation) {
            this.userService.activation(activation);

        }

        @PostMapping(path = "/login")
        public Map<String, String> connect(@RequestBody AuthenticationDTO authenticationDTO) {
            Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationDTO.username(), authenticationDTO.password())
            );

            if (authenticate.isAuthenticated()) {
                return this.jwtService.generate(authenticationDTO.username());
            }
            return null;


        }
    }

