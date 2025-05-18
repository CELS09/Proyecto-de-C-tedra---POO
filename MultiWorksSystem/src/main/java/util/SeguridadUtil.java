package util;

import org.mindrot.jbcrypt.BCrypt;

public class SeguridadUtil {
    public static String encriptar(String contrasena) {
        return BCrypt.hashpw(contrasena, BCrypt.gensalt());
    }

    public static boolean validar(String contrasenaPlano, String hash) {
        return BCrypt.checkpw(contrasenaPlano, hash);
    }
}
