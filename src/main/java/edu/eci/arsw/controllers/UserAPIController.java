package edu.eci.arsw.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import edu.eci.arsw.error.ExceptionLoginEmailPassword;
import edu.eci.arsw.model.User;
import edu.eci.arsw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.apache.coyote.http11.Constants.a;

/**
 *   COSAS POR HACER:
 *      - Cambiar "cell" por "cellphone" en la respuesta de '/login'
 *      - NO devolver el 'password' en la respuesta del login
 *      - Verificar por que el usuario tiene rol "SAOKO" en lugar de "USER" o "ADMIN"
 *          - El ROLE se debe asignar automáticamente en el back y por defecto debe ser "USER"
 *      - Retornar un mensaje con STATUS = 200 que diga que el usuario fue creado exitosamente
 *      
 */


@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/user")
public class UserAPIController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            // $
            // BEFORE
            // userService.registerUser(user);
            // return new ResponseEntity<>(HttpStatus.OK);

            // $
            // AFTER
            User myUser = userService.registerUser(user);
            return new ResponseEntity<>(myUser, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> loginUser(@RequestBody User user) {
        try {
            // $
            // TODO: ¿ESTO PARA QUE ES?
            // return new ResponseEntity<>(new Gson().toJson(json(userService.loginUser(user))), HttpStatus.ACCEPTED);

            return new ResponseEntity<>(userService.loginUser(user), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        } catch (ExceptionLoginEmailPassword e) {
            return new ResponseEntity<>("Correo o constraseña invalido", HttpStatus.BAD_REQUEST);
        }
    }

    private JsonObject json(User user) {
        JsonObject p = new JsonObject();
        p.addProperty("userid", user.getUserId());
        p.addProperty("firstname", user.getFirstName());
        p.addProperty("lastname", user.getLastName());
        p.addProperty("email", user.getEmail());
        p.addProperty("cell", user.getCell());
        p.addProperty("role", user.getRole());
        p.addProperty("password", user.getPassword());
        return p;
    }
}
