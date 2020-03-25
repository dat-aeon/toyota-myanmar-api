package mm.aeon.com.zconfig.oauth2;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomPasswordEncoder implements PasswordEncoder {

	private static PasswordEncoder encoder;

	public CustomPasswordEncoder() {
		encoder = new StandardPasswordEncoder("template_toyota_myanmar");
	}

	@Override
	public String encode(CharSequence rawPassword) {
		return encoder.encode(rawPassword);
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return encoder.matches(rawPassword, encodedPassword);
	}

	public static String customEncode(CharSequence rawPassword) {
		return encoder.encode(rawPassword);
	}

	public static boolean customMatches(CharSequence rawPassword, String encodedPassword) {
		return encoder.matches(rawPassword, encodedPassword);
	}
}
