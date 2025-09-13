package lk.ijse.cmjd_110.courseRegisterPro.secureConfig;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.cmjd_110.courseRegisterPro.dao.secure.UserSecureDao;
import lk.ijse.cmjd_110.courseRegisterPro.entities.secure.SecureUserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Optional;

@Component
@Configuration
@RequiredArgsConstructor
@Order(1)
public class AuthFilter extends OncePerRequestFilter {
    private final JWTUtils jwtUtils;
    private final UserSecureDao userSecureDao;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            var token = getToken(request);
            if(token != null && jwtUtils.validateToken(token)){
                var userNameFromToken = jwtUtils.getUserNameFromToken(token);
                var userDetails = userSecureDao.findByEmail(userNameFromToken);
                var authToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.get().getAuthorities());
                authToken.setDetails(new WebAuthenticationDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }
        filterChain.doFilter(request,response);
    }

    private String getToken(HttpServletRequest request){
        var authHeader = request.getHeader("Authorization");
        if(StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")){
            return authHeader.substring(7);
        }
        return null;
    }
}
