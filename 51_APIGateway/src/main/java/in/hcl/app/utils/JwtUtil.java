package in.hcl.app.utils;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
@Component
public class JwtUtil {

	
	private static final String SECRET_KEY="jkndsvcfewu93uru3495averystrongsecretkeythatis32byteslong";
	private static final SecretKey key=Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	
	public boolean validateToken(String token) {
        try {
            Jwts.parser().verifyWith(key).build().parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
