import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FrmJuego extends JFrame {

    JLabel lblDado1;
    JLabel lblDado2;
    JLabel lblLanzamientos;
    JLabel lblCenas;

    //Metodo Constructor
    public FrmJuego() {
        
        setSize(500, 400);
        setTitle("Juguemos a los dados");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        String nombreArchivo = "/imagenes/4.jpg";
        ImageIcon imgDado = new ImageIcon(getClass().getResource(nombreArchivo));
        
        lblDado1 = new JLabel();
        lblDado1.setIcon(imgDado);
        lblDado1.setBounds(10, 10, imgDado.getIconWidth(), imgDado.getIconHeight());
        getContentPane().add(lblDado1);

        lblDado2 = new JLabel();
        lblDado2.setIcon(imgDado);
        lblDado2.setBounds(10+imgDado.getIconWidth(), 10, imgDado.getIconWidth(), imgDado.getIconHeight());
        getContentPane().add(lblDado2);

        JLabel lblTituloLanzamientos = new JLabel("Lanzamientos");
        lblTituloLanzamientos.setHorizontalAlignment(SwingConstants.CENTER);
        lblTituloLanzamientos.setBounds(30 + 2 * imgDado.getIconWidth(), 10, 100, 25);
        getContentPane().add(lblTituloLanzamientos);

        JLabel lblTituloCenas = new JLabel("Cenas");
        lblTituloCenas.setHorizontalAlignment(SwingConstants.CENTER);
        lblTituloCenas.setBounds(140 + 2 * imgDado.getIconWidth(), 10, 100, 25);
        getContentPane().add(lblTituloCenas);

        lblLanzamientos = new JLabel("0");
        lblLanzamientos.setHorizontalAlignment(SwingConstants.RIGHT);
        lblLanzamientos.setFont(new Font("Tahoma", 1, 72));
        lblLanzamientos.setBackground(new Color(0,0,0));
        lblLanzamientos.setForeground(Color.decode("#c33FF00"));
        lblLanzamientos.setOpaque(true);
        lblLanzamientos.setBounds(30 + 2 * imgDado.getIconWidth(), 40, 100, 100);
        getContentPane().add(lblLanzamientos);

        lblCenas = new JLabel("0");
        lblCenas.setHorizontalAlignment(SwingConstants.RIGHT);
        lblCenas.setFont(new Font("Tahoma", 1, 72));
        lblCenas.setBackground(new Color(0,0,0));
        lblCenas.setForeground(Color.decode("#c33FF00"));
        lblCenas.setOpaque(true);
        lblCenas.setBounds(140 + 2 * imgDado.getIconWidth(), 40, 100, 100);
        getContentPane().add(lblCenas);

        JButton btnInciar = new JButton("Iniciar");
        btnInciar.setBounds(10, 150, 100, 25);
        getContentPane().add(btnInciar);

        JButton btnLanzar = new JButton("Lanzar");
        btnLanzar.setBounds(10, 180, 100, 25);
        getContentPane().add(btnLanzar);

        //Eventos
        btnInciar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                iniciar();
            }
        });

        btnLanzar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Lanzar();
            }
        });

        //Instancias
        dado1 = new Dado();
        dado2 = new Dado();
    }

    private Dado dado1, dado2;
    private Random r = new Random();

    private int Lanzamientos, Cenas;

    private void iniciar() {
        Lanzamientos = 0;
        Cenas = 0;
        lblLanzamientos.setText(String.valueOf(Lanzamientos));
        lblCenas.setText(String.valueOf(Cenas));
    }

    /**
     * 
     */
    private void Lanzar() { 
        dado1.lanzar(r);
        dado1.mostrar(lblDado1);

        dado2.lanzar(r);
        dado2.mostrar(lblDado2);

        Lanzamientos++;
        lblLanzamientos.setText(String.valueOf(Lanzamientos));

        if (dado1.getNumero() == 6 && dado2.getNumero() >= 11) {
            Cenas++;
            lblCenas.setText(String.valueOf(Cenas));
        }
    }
}

