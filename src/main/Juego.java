package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class Juego extends JFrame implements ActionListener {

    //atributos de la clase.
    private JPanel panelFrame;
    private JPanel panelTitulo, panelBotonInicio, panelDelJugador, panelHistoria, panelBotones;
    private JLabel tituloLabel;
    private JButton botonInicio;
    private EventoInicial eventoInicio = new EventoInicial();
    private JLabel nombreJugadorLabel, nombreLabel, hpLabel, valorHpLabel, armaLabel, armaEquipLabel;
    private JButton opcion1, opcion2, opcion3, opcion4;
    private final Font fontNormal = new Font("Times new Roman", 0, 14);
    private final Font fontTextArea = new Font("Times new Roman", 0, 28);
    private String nombre = "", arma = "Cuchillo";
    private String identificadorVentana = "";
    private String nuevaPartida = "";
    private int hpValor = 15;
    private int goblinVida = 24;
    private JTextArea textarea;

    //metodo constructor
    public Juego() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setResizable(false);
        this.setTitle("Juego de texto");
        this.setLocationRelativeTo(null);

        iniciarComponentes();
    }

    //metodo incializador de componentes
    private void iniciarComponentes() {
        panelFrame = new JPanel();
        panelFrame.setBackground(Color.black);
        panelFrame.setLayout(null);
        this.getContentPane().add(panelFrame);

        panelTitulo = new JPanel();
        panelTitulo.setBounds(100, 150, 600, 100);
        panelTitulo.setBackground(Color.black);
        panelFrame.add(panelTitulo);

        panelBotonInicio = new JPanel();
        panelBotonInicio.setBounds(200, 300, 400, 200);
        panelBotonInicio.setBackground(Color.black);
        panelFrame.add(panelBotonInicio);

        tituloLabel = new JLabel("TITULO INICIO");
        tituloLabel.setForeground(Color.white);
        tituloLabel.setFont(new Font("Times New Roman", 1, 60));
        panelTitulo.add(tituloLabel);

        botonInicio = new JButton("INICIO");
        botonInicio.setBackground(Color.BLACK);
        botonInicio.setFont(new Font("Times New Roman", 0, 28));
        botonInicio.setForeground(Color.white);
        botonInicio.setFocusPainted(false);
        botonInicio.addActionListener(eventoInicio);
        panelBotonInicio.add(botonInicio);

        panelDelJugador = new JPanel();
        panelDelJugador.setBackground(Color.black);
        panelDelJugador.setBounds(100, 10, 600, 60);
        panelDelJugador.setLayout(new GridLayout(1, 6));
        panelDelJugador.setVisible(false);
        panelFrame.add(panelDelJugador);

        panelHistoria = new JPanel();
        panelHistoria.setBackground(Color.red);
        panelHistoria.setBounds(100, 80, 600, 250);
        panelHistoria.setLayout(null);
        panelHistoria.setVisible(false);
        panelFrame.add(panelHistoria);

        panelBotones = new JPanel();
        panelBotones.setBackground(Color.red);
        panelBotones.setBounds(200, 340, 400, 200);
        panelBotones.setLayout(new GridLayout(4, 1));
        panelBotones.setVisible(false);
        panelFrame.add(panelBotones);

    }

    //metodo para juego ya iniciado
    private void JuegoIniciado() {
        nombre = JOptionPane.showInputDialog("BIENVENIDO \n Cual es tu nombre viajero?");

        identificadorVentana = "inicio";

        panelTitulo.setVisible(false);
        panelBotonInicio.setVisible(false);

        panelDelJugador.setVisible(true);
        panelHistoria.setVisible(true);
        panelBotones.setVisible(true);

        nombreJugadorLabel = new JLabel("Jugador:", SwingConstants.CENTER);
        nombreJugadorLabel.setForeground(Color.white);
        nombreJugadorLabel.setFont(fontNormal);
        nombreLabel = new JLabel(nombre);
        nombreLabel.setForeground(Color.white);
        nombreLabel.setFont(fontNormal);
        hpLabel = new JLabel("HP:", SwingConstants.CENTER);
        hpLabel.setForeground(Color.white);
        hpLabel.setFont(fontNormal);
        valorHpLabel = new JLabel("" + hpValor);
        valorHpLabel.setForeground(Color.white);
        valorHpLabel.setFont(fontNormal);
        armaLabel = new JLabel("Arma:", SwingConstants.CENTER);
        armaLabel.setForeground(Color.white);
        armaLabel.setFont(fontNormal);
        armaEquipLabel = new JLabel(arma);
        armaEquipLabel.setForeground(Color.white);
        armaEquipLabel.setFont(fontNormal);

        panelDelJugador.add(nombreJugadorLabel);
        panelDelJugador.add(nombreLabel);
        panelDelJugador.add(hpLabel);
        panelDelJugador.add(valorHpLabel);
        panelDelJugador.add(armaLabel);
        panelDelJugador.add(armaEquipLabel);

        textarea = new JTextArea("BIENVENIDO A ESTA DEMO " + nombre
                + "\n\nEstás en a las puertas de una cioudad."
                + "\nJusto frente de ti tienes un Guardia"
                + "\n\nQue deseas hacer?");
        textarea.setFont(fontTextArea);
        textarea.setForeground(Color.white);
        textarea.setSize(600, 250);
        textarea.setBackground(Color.black);
        panelHistoria.add(textarea);

        opcion1 = new JButton("Hablar con el guardia");
        opcion1.setBackground(Color.black);
        opcion1.setFocusPainted(false);
        opcion1.setFont(fontNormal);
        opcion1.setForeground(Color.white);
        opcion1.addActionListener(this);
        opcion2 = new JButton("atacar al guardia");
        opcion2.setBackground(Color.black);
        opcion2.setFocusPainted(false);
        opcion2.setFont(fontNormal);
        opcion2.setForeground(Color.white);
        opcion2.addActionListener(this);
        opcion3 = new JButton("irse");
        opcion3.setBackground(Color.black);
        opcion3.setFocusPainted(false);
        opcion3.setFont(fontNormal);
        opcion3.setForeground(Color.white);
        opcion3.addActionListener(this);
        opcion4 = new JButton("");
        opcion4.setBackground(Color.black);
        opcion4.setFocusPainted(false);
        opcion4.setFont(fontNormal);
        opcion4.setForeground(Color.white);
        opcion4.addActionListener(this);

        panelBotones.add(opcion1);
        panelBotones.add(opcion2);
        panelBotones.add(opcion3);
        panelBotones.add(opcion4);

    }

    private void JUEGOnuevo() {
        nombre = JOptionPane.showInputDialog("BIENVENIDO \n Cual es tu nombre viajero?");
        arma = "Cuchillo";
        identificadorVentana = "inicio";
        nuevaPartida = "";
        hpValor = 15;
        goblinVida = 24;
        nombreLabel.setText(nombre);
        valorHpLabel.setText("" + hpValor);
        armaEquipLabel.setText(arma);
        textarea.setText("BIENVENIDO A ESTA DEMO " + nombre
                + "\n\nEstás a las puertas de una ciudad."
                + "\nJusto frente de ti tienes un Guardia"
                + "\n\nQue deseas hacer?");
        opcion1.setText("Hablar con el guardia");
        opcion2.setText("atacar al guardia");
        opcion3.setText("irse");
        opcion4.setText("");
    }

    private void HablarGuardia() {
        identificadorVentana = "hablarGuardia1";
        textarea.setText("\n\nGuardia: \n\nNunca antes te habia por estos lados. \nNo puedo dejar que entres a la ciudad. Vete.");

        opcion1.setText("continuar...");
        opcion2.setText("atacar al guardia");
        opcion3.setText("");
    }

    private void AtarcarGuardia() {
        identificadorVentana = "atacarGuardia1";
        textarea.setText("""
                         Guardia: 
                         
                         NO SEAS ESTUPIDO! 
                         Con ese cuchillo no me har\u00e1s ni cosquillas!
                         
                         Guardia te ataca cuasando 3 de da\u00f1o.
                         Termina el combate.""");

        hpValor -= 3;
        valorHpLabel.setText("" + hpValor);

        opcion1.setText("continuar...");
        opcion2.setText("atacar al guardia");
        opcion3.setText("");
    }

    private void SeleccionCaminos() {
        
        if(identificadorVentana.equals("hablarGuardia1")||identificadorVentana.equals("atacarGuardia1")){
            textarea.setText("\nAbandonas la entrada de la ciudad y llegas a un \ncruce en el camino.\n\nQue desesa hacer?");
        } else {
            textarea.setText("\nTe encuentras en el cruce. \n\nQue desesa hacer?");
        }
        identificadorVentana = "SeleccionCaminos";
        
        opcion1.setText("Ir al Norte");
        opcion2.setText("ir al Este");
        opcion3.setText("ir al Oeste");
        opcion4.setText("ir al sur, regresar a la ciudad");
    }

    private void Norte() {
        identificadorVentana = "Norte";
        textarea.setText("\nTe encuentras con una fuente encantada.\nBebes sus aguas recuperando tus energias.");
        hpValor = 15;
        goblinVida = 24;
        valorHpLabel.setText("" + hpValor);
        opcion1.setText("Regresar al cruce.");
        opcion2.setText("");
        opcion3.setText("");
        opcion4.setText("");
    }

    private void Este() {
        identificadorVentana = "Este";
        textarea.setText("""
                         
                         Te adentras en el bosque encontrando una gran Espada
                         Tomas la espada y sientes una gran energ\u00eda!
                         
                         Has obtenido y equipaado una Espada.""");
        arma = "Espada";
        armaEquipLabel.setText(arma);
        opcion1.setText("Regresar al cruce.");
        opcion2.setText("");
        opcion3.setText("");
        opcion4.setText("");
    }

    private void Oeste() {
        identificadorVentana = "Oeste";
        textarea.setText("""
                         
                         Sientes una presencia peligrosa...
                         En medio de camino se encuentra un gran GOBLIN!
                         Te observa con mirada amenazante.
                         
                         Que haras?""");
        opcion1.setText("Atacar al Goblin");
        opcion2.setText("Analizar la situación");
        opcion3.setText("Regresar al cruce.");
        opcion4.setText("");
    }

    private void Analizar() {
        identificadorVentana = "analizar";
        textarea.setText("""
                         Se trata del GOBLIN que ha aterrorizado la region.
                         Si logra vencerlo, obtendr\u00e1s mucha reputacion y fama.
                         
                         GOBLIN, 24HP, da\u00f1o 3 a 6 por golpe.
                         """ + nombre + ", " + hpValor + "HP, arma " + arma);
        opcion1.setText("Atacar al Goblin");
        opcion2.setText("Regresar al cruce.");
        opcion3.setText("");
        opcion4.setText("");
    }

    private void CombateInicio() {
        if (arma.equals("Cuchillo")) {
            identificadorVentana = "combateCuchillo";
            textarea.setText("\nAtacas al GOBLIN sin dudarlo, causandole 2 de daño.\nEl Goblin te regresa el golpe de una garrotazo!\nTe causa 8 de daño!");
            hpValor -= 8;
            goblinVida -= 2;

            valorHpLabel.setText("" + hpValor);

            opcion1.setText("Atacar al Goblin");
            opcion2.setText("irse");
            opcion3.setText("");
            opcion4.setText("");
        } else if (arma.equals("Espada")) {
            identificadorVentana = "combate";
            textarea.setText("GOBLIN VIDA " + goblinVida + "\nAtacas al GOBLIN sin dudarlo, causandole 13 de daño.\nEl Goblin te regresa el golpe de una garrotazo!\nTe causa 6 de daño!");
            goblinVida -= 13;
            hpValor -= 6;

            valorHpLabel.setText("" + hpValor);

            opcion1.setText("Atacar al Goblin");
            opcion2.setText("irse");
            opcion3.setText("");
            opcion4.setText("");
        }
    }

    private void Combate() {
        if (arma.equals("Cuchillo")) {
            identificadorVentana = "combateCuchillo";
            textarea.setText("\nAtacas al GOBLIN sin dudarlo, causandole 2 de daño.\nEl Goblin te regresa el golpe de una garrotazo!\nTe causa 8 de daño!");
            hpValor -= 8;
            valorHpLabel.setText("" + hpValor);

            opcion1.setText("Atacar al Goblin");
            opcion2.setText("irse");
            opcion3.setText("");
            opcion4.setText("");
        } else if (arma.equals("Espada")) {
            identificadorVentana = "combate";
            textarea.setText("GOBLIN VIDA " + goblinVida + "\nVuelves a atacar al GOBLIN, causandole 13 de daño.\nEl Goblin cae abatido, sin antes darte un ultimo garrotazo.\nTe causa 6 de daño!");
            goblinVida -= 13;
            hpValor -= 6;
            valorHpLabel.setText("" + hpValor);

            opcion1.setText("Atacar al Goblin");
            opcion2.setText("irse");
            opcion3.setText("");
            opcion4.setText("");
        }
    }

    private void GameOver() {
        JOptionPane.showInternalMessageDialog(null, "Te has quedado sin energía\nEl juego ha terninado");
        nuevaPartida = JOptionPane.showInputDialog("Deseas iniciar una nueva partida?\ns, SI | n, NO");

    }

    private void combateFinalizado() {
        JOptionPane.showMessageDialog(null, "HAS VENCIDO AL GOBLIN!\n\nHas ganado mucha reputación y tu nombre\nes conocido en toda la región");
        JOptionPane.showMessageDialog(null, "Regresas a las puertas de la ciudad,\ndonde te reciben como un hereo y realizan una celebración en tu honor\n\nLARGA VIDA AL HEROE " + nombre);
        identificadorVentana = "finalizado";
        textarea.setText("\n\nFIN\n\nDemostración finalizada, muchas gracias por jugar.\n\nQue deseas hacer?");
        hpValor -= 8;

        opcion1.setText("Nueva Partida");
        opcion2.setText("Salir del juego");
        opcion3.setText("");
        opcion4.setText("");
    }

    //clase que inidica los eventos que se realizaran por cada ipcion en la botonera y de acuerdo a la ventana en que se encuentre el jugador
    @Override
    public void actionPerformed(ActionEvent e) {
        if (identificadorVentana.equals("inicio")) {

            if (e.getSource() == opcion1) {
                HablarGuardia();
            }
            if (e.getSource() == opcion2) {
                AtarcarGuardia();
            }
            if (e.getSource() == opcion3) {
                SeleccionCaminos();
            }
        } else if (identificadorVentana.equals("hablarGuardia1") || identificadorVentana.equals("atacarGuardia1")) {

            if (e.getSource() == opcion1) {
                SeleccionCaminos();
            }
            if (e.getSource() == opcion2) {
                AtarcarGuardia();
            }
        } else if (identificadorVentana.equals("SeleccionCaminos")) {
            if (e.getSource() == opcion1) {
                Norte();
            }
            if (e.getSource() == opcion2) {
                Este();
            }
            if (e.getSource() == opcion3) {
                Oeste();
            }
            if (e.getSource() == opcion4) {

            }

        } else if (identificadorVentana.equals("Norte")) {
            if (e.getSource() == opcion1) {
                SeleccionCaminos();
            }

        } else if (identificadorVentana.equals("Este")) {
            if (e.getSource() == opcion1) {
                SeleccionCaminos();
            }

        } else if (identificadorVentana.equals("Oeste")) {
            if (e.getSource() == opcion1) {
                CombateInicio();
            }
            if (e.getSource() == opcion2) {
                Analizar();
            }
            if (e.getSource() == opcion3) {
                SeleccionCaminos();
            }
            if (e.getSource() == opcion4) {

            }

        } else if (identificadorVentana.equals("analizar")) {
            if (e.getSource() == opcion1) {

            }
            if (e.getSource() == opcion2) {
                SeleccionCaminos();
            }

        } else if (identificadorVentana.equals("combateCuchillo") || identificadorVentana.equals("combate")) {
            if (e.getSource() == opcion1) {
                Combate();
            }
            if (e.getSource() == opcion2) {
                SeleccionCaminos();
            }

        }
        if (hpValor <= 0) {
            GameOver();
        } else if (goblinVida <= 0) {
            combateFinalizado();
        }

        if (nuevaPartida.equals("s")) {
            JUEGOnuevo();
        } else if (nuevaPartida.equals("n")) {
            System.exit(0);
        }

    }

    //clase que inicia el juego
    public class EventoInicial implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JuegoIniciado();

        }

    }

}
