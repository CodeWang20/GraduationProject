package top.rainbowcat.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@Slf4j
@Data
@Component
public class JwtUtils {

    private final String secret = "bef1669773f7aab330679b50dd35589d";
    private final int expire = 604800;//默认7天过期
    //private final int expire = 20;

    /**
     * 生成token
     */
    public String getToken(String username){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, expire);
        //创建jwt builder
        return  Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(instance.getTime())
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String getToken(Map<String, Object> map){
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, expire);
        //创建jwt builder
        JwtBuilder jwtBuilder = Jwts.builder()
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, secret);

        map.forEach((k, v)->{
            jwtBuilder.claim(k, v);
        });
        return jwtBuilder.setExpiration(instance.getTime()).compact();
    }

    /**
     * 解析token，获取claims
     */
    public Claims parseJwt(String token){
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            return null;
        }
    }

    /**
     * token是否过期
     * @return  true：过期
     */
    public boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }
}
