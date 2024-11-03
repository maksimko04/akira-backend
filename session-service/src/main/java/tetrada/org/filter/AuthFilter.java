package tetrada.org.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class AuthFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if(request.getHeader("secretKey").equals("cbsoud;gbsu749fb2b4r[gh0h3 gaw94tvbg[h34q8rgf")){
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(null, null));
        }
        filterChain.doFilter(request, response);
    }
}