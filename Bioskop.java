package bioskop;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URI;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Bioskop {

    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy");
    static String tanggalHariIni = LocalDate.now().format(dtf);

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {}

        SwingUtilities.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }

    // 1. HALAMAN LOGIN
    static class LoginFrame extends JFrame {
        public LoginFrame() {
            setTitle("Login - Bioskop Aldo");
            setSize(450, 350);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(new BorderLayout());
            getContentPane().setBackground(Color.WHITE);

            JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
            panel.setBorder(new EmptyBorder(30, 50, 30, 50));
            panel.setBackground(Color.WHITE);

            JLabel titleLabel = new JLabel("LOGIN BIOSKOP ALDO", SwingConstants.CENTER);
            titleLabel.setFont(new Font("Arial", Font.BOLD, 26));

            JTextField txtUser = new JTextField();
            JPasswordField txtPass = new JPasswordField();

            JButton btnLogin = new JButton("MASUK");
            btnLogin.setBackground(new Color(30, 144, 255));
            btnLogin.setForeground(Color.WHITE);

            btnLogin.addActionListener(e -> {
                if (txtUser.getText().equals("aldo") && new String(txtPass.getPassword()).equals("aldo123")) {
                    dispose();
                    new MainFrame().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Username atau Password Salah!", "Gagal", JOptionPane.ERROR_MESSAGE);
                }
            });

            panel.add(titleLabel);
            panel.add(new JLabel("Username (aldo):"));
            panel.add(txtUser);
            panel.add(new JLabel("Password (aldo123):"));
            panel.add(txtPass);
            add(panel, BorderLayout.CENTER);
            add(btnLogin, BorderLayout.SOUTH);
        }
    }

    // 2. HALAMAN UTAMA (Data Film & Link Youtube Disimpan Disini)
    static class MainFrame extends JFrame {
        String[] namaFilm = {"Avatar: The Way of Water", "John Wick 4", "Transformers: Rise"};
        String[] jenisFilm = {"Sci-Fi / Action", "Action / Crime", "Action / Mecha"};
        int[] hargaFilm = {55000, 50000, 45000};
        
        // Link YouTube langsung sesuai request
        String[] linkYoutube = {
            "https://youtu.be/LU5nxqxucWY?si=3vpA7S2ZkXX15CGO", 
            "https://youtu.be/ZsILQqRpMp0?si=dYIxz_yya-2l7ccn", 
            "https://youtu.be/Gh44m59Jolc?si=oF9bqp1HExiKuTRr"
        };
        
        JSpinner[] spinners = new JSpinner[namaFilm.length];

        public MainFrame() {
            setTitle("Menu Utama - Bioskop Aldo");
            setSize(750, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(new BorderLayout());

            JPanel filmPanel = new JPanel();
            filmPanel.setLayout(new BoxLayout(filmPanel, BoxLayout.Y_AXIS));

            for (int i = 0; i < namaFilm.length; i++) {
                JPanel card = new JPanel(new BorderLayout(15, 15));
                card.setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 20, 10, 20), BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1)));

                JLabel lblNama = new JLabel("<html><h2>" + namaFilm[i] + "</h2><p>Genre: " + jenisFilm[i] + "</p><p style='color:green'>Harga: Rp " + hargaFilm[i] + "</p></html>");
                card.add(lblNama, BorderLayout.CENTER);

                JPanel orderPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                orderPanel.add(new JLabel("Pesan Tiket: "));
                spinners[i] = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
                orderPanel.add(spinners[i]);
                card.add(orderPanel, BorderLayout.EAST);

                filmPanel.add(card);
            }

            add(new JScrollPane(filmPanel), BorderLayout.CENTER);

            JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
            JButton btnLanjut = new JButton("TAMBAH PESANAN & BAYAR");
            btnLanjut.setBackground(new Color(46, 204, 113));
            
            btnLanjut.addActionListener(e -> {
                int totalHarga = 0;
                List<String> listPesanan = new ArrayList<>();
                String linkDiputar = null; // Menyimpan link film yang dipesan

                for (int i = 0; i < namaFilm.length; i++) {
                    int qty = (Integer) spinners[i].getValue();
                    if (qty > 0) {
                        totalHarga += qty * hargaFilm[i];
                        listPesanan.add(namaFilm[i] + " (x" + qty + ")");
                        if (linkDiputar == null) linkDiputar = linkYoutube[i]; // Ambil link video pertama yang dibeli
                    }
                }

                if (totalHarga > 0) {
                    dispose();
                    new PaymentFrame(listPesanan, totalHarga, linkDiputar).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Pilih minimal 1 film terlebih dahulu!");
                }
            });

            footerPanel.add(btnLanjut);
            add(footerPanel, BorderLayout.SOUTH);
        }
    }

    // 3. HALAMAN PEMBAYARAN
    static class PaymentFrame extends JFrame {
        public PaymentFrame(List<String> listPesanan, int totalHarga, String linkYoutube) {
            setTitle("Pembayaran - Bioskop Aldo");
            setSize(400, 300);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(new BorderLayout());

            JLabel lblTotal = new JLabel("Total Bayar: Rp " + totalHarga, SwingConstants.CENTER);
            lblTotal.setFont(new Font("Arial", Font.BOLD, 20));
            add(lblTotal, BorderLayout.CENTER);

            JButton btnBayar = new JButton("BAYAR SEKARANG");
            btnBayar.addActionListener(e -> {
                JOptionPane.showMessageDialog(this, "Pembayaran Berhasil! Membuka Film di YouTube...");
                bukaVideoYoutube(linkYoutube);
                dispose();
                new MainFrame().setVisible(true); // Kembali ke menu awal setelah nonton
            });

            add(btnBayar, BorderLayout.SOUTH);
        }

        // FUNGSI UNTUK BUKA LINK YOUTUBE DI BROWSER BAWAAN LAPTOP
        private void bukaVideoYoutube(String url) {
            try {
                if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                    Desktop.getDesktop().browse(new URI(url));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Gagal membuka browser.");
            }
        }
    }
}
