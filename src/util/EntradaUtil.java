package util;

import javax.swing.*;

public class EntradaUtil {

    public static String lerTexto(String mensagem) {
        return JOptionPane.showInputDialog(mensagem);
    }

    public static int lerInteiro(String mensagem) {
        return Integer.parseInt(JOptionPane.showInputDialog(mensagem));
    }

    public static double lerDouble(String mensagem) {
        return Double.parseDouble(JOptionPane.showInputDialog(mensagem));
    }

    public static void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }
}