package util;

// Clase utilitaria para validar entradas comunes del Sistema
public class ValidacionUtil {

    // Valida si una cadena no es nula ni vacía
    public static boolean esTextoValido(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    // Valida si un número entero es positivo (mayor a 0)
    public static boolean esNumeroPositivo(int numero) {
        return numero > 0;
    }

    // Valida si un número decimal es positivo (mayor a 0.0)
    public static boolean esDecimalPositivo(double numero) {
        return numero > 0.0;
    }

    // Valida si una dirección de correo tiene un formato básico válido
    public static boolean esCorreoValido(String correo) {
        return correo != null && correo.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }

    // Valida si una cadena representa un número entero válido
    public static boolean esEntero(String valor) {
        if (!esTextoValido(valor)) return false;
        try {
            Integer.parseInt(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // Valida si una cadena representa un número decimal válido
    public static boolean esDecimal(String valor) {
        if (!esTextoValido(valor)) return false;
        try {
            Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
