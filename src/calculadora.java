import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculadora {
    private JPanel panel;
    private JButton cero;
    private JButton uno;
    private JButton dos;
    private JButton tres;
    private JButton cuatro;
    private JButton cinco;
    private JButton seis;
    private JButton siete;
    private JButton ocho;
    private JButton nueve;
    private JButton punto;
    private JButton suma;
    private JButton resta;
    private JButton multiplicar;
    private JButton dividir;
    private JButton igual;
    private JButton limpiar;
    private JButton respuesta;
    private JButton borrar;
    private JButton potencia;
    private JButton raiz;
    private JButton seno;
    private JButton coseno;
    private JButton tangente;
    private JLabel vista;
    private JButton resanterior;

    private double primerNumero;
    private double resultado;
    private String operador;
    private boolean nuevoNumero;

    public calculadora() {
        primerNumero = 0;
        resultado = 0;
        operador = "";
        nuevoNumero = true;

        cero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numeroPresionado("0");
            }
        });

        uno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numeroPresionado("1");
            }
        });

        dos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numeroPresionado("2");
            }
        });

        tres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numeroPresionado("3");
            }
        });

        cuatro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numeroPresionado("4");
            }
        });

        cinco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numeroPresionado("5");
            }
        });

        seis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numeroPresionado("6");
            }
        });

        siete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numeroPresionado("7");
            }
        });

        ocho.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numeroPresionado("8");
            }
        });

        nueve.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numeroPresionado("9");
            }
        });

        punto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!vista.getText().contains(".")) {
                    vista.setText(vista.getText() + ".");
                }
            }
        });

        suma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operadorPresionado("+");
            }
        });

        resta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operadorPresionado("-");
            }
        });

        multiplicar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operadorPresionado("*");
            }
        });

        dividir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operadorPresionado("/");
            }
        });

        igual.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });

        limpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarCalculadora();
            }
        });

        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                borrarUltimoDigito();
            }
        });

        potencia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operadorPresionado("^");
            }
        });

        raiz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularRaiz();
            }
        });

        seno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularSeno();
            }
        });

        coseno.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularCoseno();
            }
        });

        tangente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularTangente();
            }
        });

        respuesta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                utilizarResultadoAnterior();
            }
        });


        resanterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                utilizarResultadoAnterior();
            }
        });
    }

    private void numeroPresionado(String numero) {
        if (nuevoNumero) {
            vista.setText(numero);
            nuevoNumero = false;
        } else {
            vista.setText(vista.getText() + numero);
        }
    }

    private void operadorPresionado(String operador) {
        this.operador = operador;
        primerNumero = Double.parseDouble(vista.getText());
        nuevoNumero = true;
    }

    private void calcular() {
        double segundoNumero = Double.parseDouble(vista.getText());

        switch (operador) {
            case "+":
                resultado = primerNumero + segundoNumero;
                break;
            case "-":
                resultado = primerNumero - segundoNumero;
                break;
            case "*":
                resultado = primerNumero * segundoNumero;
                break;
            case "/":
                resultado = primerNumero / segundoNumero;
                break;
            case "^":
                resultado = Math.pow(primerNumero, segundoNumero);
                break;
        }

        vista.setText(String.valueOf(resultado));
        nuevoNumero = true;
    }

    private void limpiarCalculadora() {
        vista.setText("");
        operador = "";
        primerNumero = 0;
        resultado = 0;
        nuevoNumero = true;
    }

    private void borrarUltimoDigito() {
        String texto = vista.getText();
        if (texto.length() > 0) {
            texto = texto.substring(0, texto.length() - 1);
            vista.setText(texto);
        }
    }

    private void calcularRaiz() {
        double numero = Double.parseDouble(vista.getText());
        resultado = Math.sqrt(numero);
        vista.setText(String.valueOf(resultado));
        nuevoNumero = true;
    }

    private void calcularSeno() {
        double angulo = Double.parseDouble(vista.getText());
        resultado = Math.sin(Math.toRadians(angulo));
        vista.setText(String.valueOf(resultado));
        nuevoNumero = true;
    }

    private void calcularCoseno() {
        double angulo = Double.parseDouble(vista.getText());
        resultado = Math.cos(Math.toRadians(angulo));
        vista.setText(String.valueOf(resultado));
        nuevoNumero = true;
    }

    private void calcularTangente() {
        double angulo = Double.parseDouble(vista.getText());
        resultado = Math.tan(Math.toRadians(angulo));
        vista.setText(String.valueOf(resultado));
        nuevoNumero = true;
    }

    private void utilizarResultadoAnterior() {
        vista.setText(String.valueOf(resultado));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora");
        frame.setContentPane(new calculadora().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}