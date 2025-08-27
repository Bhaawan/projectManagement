package bhaawan.project.ProjectManagement.services.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret.key}")
    private String secretKey;

    public String generateToken(UserDetails userDetails){
        return createToken(userDetails.getUsername());
    }

    private String createToken(String userName){
        Algorithm algo=Algorithm.HMAC256(secretKey);

        return JWT.create().withSubject(userName).withIssuedAt(new Date(System.currentTimeMillis())).withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)).sign(algo);
    }

}
