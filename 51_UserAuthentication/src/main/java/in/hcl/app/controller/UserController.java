package in.hcl.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.hcl.app.DTO.UserDTO;
import in.hcl.app.DTO.UserLogin;
import in.hcl.app.service.IUserService;
import in.hcl.app.utils.JwtUtil;

@RestController
@RequestMapping("/api/auth")
public class UserController {

	@Autowired
    private IUserService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;
	@PostMapping("/register")
	public ResponseEntity<String> doRegistration(@RequestBody UserDTO dto){
		boolean status = userService.saveUser(dto);
		
		if(status) {
			return new ResponseEntity<>("User Registration Successfull!",HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>("User Registration Failed!",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> doLogin(@RequestBody UserLogin login){
	    try {
	        Authentication authenticate = authenticationManager.authenticate(
	            new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPwd())
	        );

	        if (authenticate.isAuthenticated()) {
	            User user = (User) authenticate.getPrincipal();
	            String token = jwtUtil.generateToken(user);
	            return new ResponseEntity<>(token, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Authentication Failed", HttpStatus.BAD_REQUEST);
	        }

	    } catch (Exception e) {
	        e.printStackTrace(); // <--- This will show what's really going wrong
	        return new ResponseEntity<>("Authentication Failed: " + e.getMessage(), HttpStatus.FORBIDDEN);
	    }
	}

		
}
