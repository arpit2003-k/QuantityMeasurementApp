package com.app.quantitymeasurement.security;

import com.app.quantitymeasurement.model.User;
import com.app.quantitymeasurement.repository.UserRepository;
import com.app.quantitymeasurement.service.JwtService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class OAuth2SuccessHandler implements AuthenticationSuccessHandler {

    private final UserRepository repository;
    private final JwtService jwtService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {

        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        
        // Handle different attribute names for Google and GitHub
        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");
        
        if (email == null) {
            // Fallback for GitHub if email is not public
            email = oAuth2User.getAttribute("login") + "@github.com";
        }
        
        if (name == null) {
            name = oAuth2User.getAttribute("login");
        }

        final String finalEmail = email;
        final String finalName = name != null ? name : "OAuth User";

        User user = repository.findByEmail(finalEmail)
                .orElseGet(() -> repository.save(
                        User.builder()
                                .email(finalEmail)
                                .name(finalName)
                                .mobileNumber("0000000000")
                                .password("oauth")
                                .build()
                ));

        String token = jwtService.generateToken(user);

        // Redirect back to Angular app with the token
        String redirectUrl = "http://localhost:4200/auth?token=" + token;
        response.sendRedirect(redirectUrl);
    }
}