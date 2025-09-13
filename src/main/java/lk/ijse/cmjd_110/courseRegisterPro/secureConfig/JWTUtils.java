package lk.ijse.cmjd_110.courseRegisterPro.secureConfig;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.GrantedAuthority;

import java.security.Key;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Configuration
public class JWTUtils {
    @Value("${signature}")
    private String signature;

    //create Key
    private Key key(){
       return Keys.hmacShaKeyFor(signature.getBytes());
    }
    //gen token
    public String generateToken(String username, Collection<? extends GrantedAuthority> authorities){
       String roles = authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
        return Jwts.builder()
                .setSubject(username)
                .claim("roles",roles)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();

    }
    //token validate
    public boolean validateToken(String token){
        try {
            Jwts.parser()
                    .setSigningKey(key()).build().parse(token);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
    //userName extract
    public String getUserNameFromToken(String token){
        return Jwts.parser()
                .setSigningKey(key()).build()
                .parseClaimsJws(token).getBody().getSubject();
    }

}
