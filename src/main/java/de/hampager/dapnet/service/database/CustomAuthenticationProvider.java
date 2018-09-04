package de.hampager.dapnet.service.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import de.hampager.dapnet.service.database.model.AuthResponse;

/**
 * This class implements a dummy authentication provider that accepts all
 * authentication requests and stores the credentials for later use.
 * 
 * @author Philipp Thiel
 */
@Component
class CustomAuthenticationProvider implements AuthenticationProvider {

	private final AuthService authService;

	@Autowired
	public CustomAuthenticationProvider(AuthService authService) {
		this.authService = authService;
	}

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		final String username = authentication.getName();
		final String password = authentication.getCredentials().toString();
		final AuthResponse response = authService.authenticate(username, password);
		final UserDetails user = new AppUser(response);

		return new UsernamePasswordAuthenticationToken(user, password, user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
