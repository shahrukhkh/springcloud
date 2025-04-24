package in.hcl.app.utils;

import java.util.Date;
import java.util.Random;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	
	private static final String SECRET_KEY="jkndsvcfewu93uru3495averystrongsecretkeythatis32byteslong";
	private static final long EXPIRATION_TIME = 86400000;
	private static final SecretKey key=Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	
	
	public String generateToken(UserDetails userDetails) {
		Random random= new Random();
		Integer jwtId = random.nextInt(10000, 99999999);
		System.out.println(jwtId);
		return Jwts.builder()
				.subject(userDetails.getUsername())
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()+EXPIRATION_TIME))
				.id(jwtId.toString())
				.issuer("by User Portfolio.")
				.signWith(key).compact();
    }

}
