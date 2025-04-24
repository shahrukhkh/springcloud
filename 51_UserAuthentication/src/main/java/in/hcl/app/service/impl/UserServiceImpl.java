package in.hcl.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import in.hcl.app.DTO.UserDTO;
import in.hcl.app.entity.UserEntity;
import in.hcl.app.repo.UserEntityRepo;
import in.hcl.app.service.IUserService;
@Service
public class UserServiceImpl implements IUserService,UserDetailsService{

	@Autowired
	private UserEntityRepo entityRepo;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	@Override
	public boolean saveUser(UserDTO userDTO) {
		return entityRepo.save(UserEntity.builder()
				.email(userDTO.getEmail())
				.username(userDTO.getUsername())
				.pwd(passwordEncoder.encode(userDTO.getPwd())).build())
				.getUserId()!=null;
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    UserEntity user = entityRepo.findByEmail(username)
	        .orElseThrow(() -> new UsernameNotFoundException(username + " NOT FOUND!"));

	    System.out.println("Loaded user: " + user.getEmail());

	    return new User(
	        user.getEmail(),
	        user.getPwd(), // Already encoded in the database
	        List.of(new SimpleGrantedAuthority("ROLE_USER")) // Add roles/authorities if needed
	    );
	}


}
