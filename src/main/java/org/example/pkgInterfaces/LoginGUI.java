package org.example.pkgInterfaces;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {

    private JButton ingresoButton;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JLabel bienvenidaLabel;

    public LoginWindow() {
        // Configurar la ventana
        setTitle("Inicio de Sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));

        // Crear componentes
        usernameLabel = new JLabel("Usuario:");
        passwordLabel = new JLabel("Contraseña:");
        textField = new JTextField();
        passwordField = new JPasswordField();
        ingresoButton = new JButton("Ingresar");
        bienvenidaLabel = new JLabel();

        // Agregar componentes a la ventana
        add(usernameLabel);
        add(textField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel()); // Espacio en blanco
        add(ingresoButton);
        add(new JLabel()); // Espacio en blanco
        add(bienvenidaLabel);

        // Configurar el botón de ingreso
        ingresoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = textField.getText();
                String password = new String(passwordField.getPassword());

                // Verificar las credenciales
                if (verificarCredenciales(username, password)) {
                    mostrarMenu();
                } else {
                    mostrarError();
                }
            }
        });
    }

    private boolean verificarCredenciales(String username, String password) {
        // Aquí debes implementar la lógica para verificar las credenciales
        // Puedes usar una base de datos, un archivo de texto, etc.
        // Por ahora, simplemente compararemos con valores fijos para demostración
        return username.equals("admin") && password.equals("123456");
    }

    private void mostrarMenu() {
        // Aquí debes implementar la lógica para mostrar el menú principal
        // Puedes crear una nueva ventana o cambiar el contenido de esta ventana
        // Por ahora, simplemente mostraremos un mensaje de bienvenida
        bienvenidaLabel.setText("¡Bienvenido!");
    }

    private void mostrarError() {
        // Aquí debes implementar la lógica para mostrar un mensaje de error
        // Puedes mostrar un diálogo emergente, cambiar el contenido de esta ventana, etc.
        // Por ahora, simplemente mostraremos un mensaje de error en la etiqueta de bienvenida
        bienvenidaLabel.setText("Error: Credenciales incorrectas");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LoginWindow loginWindow = new LoginWindow();
                loginWindow.setVisible(true);
            }
        });
    }
}
