package util;

import org.mindrot.jbcrypt.BCrypt;

public class SeguridadUtil {
    public static boolean verificarPassword(String textoPlano, String hash) {
        return BCrypt.checkpw(textoPlano, hash);
    }

    public static String encriptarPassword(String textoPlano) {
        return BCrypt.hashpw(textoPlano, BCrypt.gensalt());
    }
}
