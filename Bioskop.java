package bioskop;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URI;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Modern Bioskop Aldo App
 * 100% Berjalan di NetBeans IDE 8.2 + Terintegrasi Link Streaming YouTube
 */
public class Bioskop {

    // Format Tanggal Otomatis
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy");
    static String tanggalHariIni = LocalDate.now().format(dtf);

    // Data Film Global (Nama, Genre, Harga, Poster URL, Link YouTube Langsung)
    static String[] namaFilm = {
        "Avatar: The Way of Water",
        "John Wick 4",
        "Transformers: Rise"
    };
    static String[] jenisFilm = {
        "Sci-Fi / Action",
        "Action / Crime",
        "Action / Mecha"
    };
    static int[] hargaFilm = {55000, 50000, 45000};
    static String[] gambarLokal = {
        "assets/film1.png",
        "assets/film2.png",
        "assets/film3.png"
    };
    static String[] posterUrl = {
        "https://img.youtube.com/vi/LU5nxqxucWY/hqdefault.jpg",
        "https://img.youtube.com/vi/ZsILQqRpMp0/hqdefault.jpg",
        "https://img.youtube.com/vi/Gh44m59Jolc/hqdefault.jpg"
    };
    static String[] linkYoutubeFilm = {
        "https://youtu.be/LU5nxqxucWY?si=3vpA7S2ZkXX15CGO",
        "https://youtu.be/ZsILQqRpMp0?si=dYIxz_yya-2l7ccn",
        "https://youtu.be/Gh44m59Jolc?si=oF9bqp1HExiKuTRr"
    };

    public static void main(String[] args) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            new LoginFrame().setVisible(true);
        });
    }

    // ==========================================
    // 1. HALAMAN LOGIN CUSTOMER
    // ==========================================
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
            titleLabel.setForeground(Color.BLACK);

            Font inputFont = new Font("Arial", Font.BOLD, 14);

            JLabel lblUser = new JLabel("Username (aldo):");
            lblUser.setForeground(Color.BLACK);
            JTextField txtUser = new JTextField();
            txtUser.setFont(inputFont);
            txtUser.setForeground(Color.BLACK);

            JLabel lblPass = new JLabel("Password (aldo123):");
            lblPass.setForeground(Color.BLACK);
            JPasswordField txtPass = new JPasswordField();
            txtPass.setFont(inputFont);
            txtPass.setForeground(Color.BLACK);

            JButton btnLogin = new JButton("MASUK");
            btnLogin.setBackground(new Color(30, 144, 255));
            btnLogin.setForeground(Color.WHITE);
            btnLogin.setFont(new Font("Arial", Font.BOLD, 16));

            btnLogin.addActionListener(e -> {
                String username = txtUser.getText().trim();
                String password = new String(txtPass.getPassword()).trim();

                if (username.equals("aldo") && password.equals("aldo123")) {
                    playSound("assets/sound.wav");
                    dispose();
                    new MainFrame().setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Username atau Password Salah!", "Gagal Login", JOptionPane.ERROR_MESSAGE);
                }
            });

            panel.add(titleLabel);
            panel.add(lblUser);
            panel.add(txtUser);
            panel.add(lblPass);
            panel.add(txtPass);

            add(panel, BorderLayout.CENTER);
            add(btnLogin, BorderLayout.SOUTH);
        }
    }

    // ==========================================
    // 2. HALAMAN UTAMA (PILIH FILM)
    // ==========================================
    static class MainFrame extends JFrame {
        JSpinner[] spinners = new JSpinner[namaFilm.length];

        public MainFrame() {
            setTitle("Menu Utama - Bioskop Aldo");
            setSize(780, 620);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(new BorderLayout());
            getContentPane().setBackground(new Color(245, 245, 245));

            // Header
            JPanel headerPanel = new JPanel(new GridLayout(2, 1));
            headerPanel.setBackground(new Color(44, 62, 80));

            JLabel headerTitle = new JLabel("BIOSKOP ALDO", SwingConstants.CENTER);
            headerTitle.setFont(new Font("Arial", Font.BOLD, 28));
            headerTitle.setForeground(Color.WHITE);

            JLabel headerDate = new JLabel("Tanggal Hari Ini: " + tanggalHariIni, SwingConstants.CENTER);
            headerDate.setFont(new Font("Arial", Font.PLAIN, 14));
            headerDate.setForeground(Color.LIGHT_GRAY);

            headerPanel.add(headerTitle);
            headerPanel.add(headerDate);
            headerPanel.setBorder(new EmptyBorder(15, 10, 15, 10));
            add(headerPanel, BorderLayout.NORTH);

            // Body - Daftar Film
            JPanel filmPanel = new JPanel();
            filmPanel.setLayout(new BoxLayout(filmPanel, BoxLayout.Y_AXIS));

            for (int i = 0; i < namaFilm.length; i++) {
                final int idx = i;
                JPanel card = new JPanel(new BorderLayout(15, 15));
                card.setBackground(Color.WHITE);
                card.setBorder(BorderFactory.createCompoundBorder(
                        new EmptyBorder(10, 20, 10, 20),
                        BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1)
                ));

                // Gambar Poster (Otomatis muat dari lokal atau URL Poster YouTube)
                JLabel lblGambar = new JLabel("MEMUAT...", SwingConstants.CENTER);
                lblGambar.setPreferredSize(new Dimension(110, 140));
                lblGambar.setOpaque(true);
                lblGambar.setBackground(Color.DARK_GRAY);
                lblGambar.setForeground(Color.WHITE);

                new Thread(() -> {
                    try {
                        Image img = null;
                        File imgFile = new File(gambarLokal[idx]);
                        if (imgFile.exists()) {
                            img = ImageIO.read(imgFile);
                        } else {
                            BufferedImage urlImg = ImageIO.read(new URL(posterUrl[idx]));
                            if (urlImg != null) {
                                img = urlImg;
                            }
                        }
                        if (img != null) {
                            Image scaled = img.getScaledInstance(110, 140, Image.SCALE_SMOOTH);
                            SwingUtilities.invokeLater(() -> {
                                lblGambar.setIcon(new ImageIcon(scaled));
                                lblGambar.setText("");
                            });
                        } else {
                            SwingUtilities.invokeLater(() -> lblGambar.setText("GAMBAR FILM"));
                        }
                    } catch (Exception ex) {
                        SwingUtilities.invokeLater(() -> lblGambar.setText("GAMBAR FILM"));
                    }
                }).start();

                card.add(lblGambar, BorderLayout.WEST);

                // Info Film
                JPanel infoPanel = new JPanel(new GridLayout(4, 1));
                infoPanel.setBackground(Color.WHITE);

                JLabel lblNama = new JLabel(namaFilm[i]);
                lblNama.setFont(new Font("Arial", Font.BOLD, 18));

                JLabel lblJenis = new JLabel("Genre: " + jenisFilm[i]);

                String tglTerbit = LocalDate.now().minusDays(5 * (i + 1)).format(dtf);
                JLabel lblTerbit = new JLabel("Rilis: " + tglTerbit);

                JLabel lblHarga = new JLabel("Harga: Rp " + hargaFilm[i]);
                lblHarga.setForeground(new Color(39, 174, 96));
                lblHarga.setFont(new Font("Arial", Font.BOLD, 14));

                infoPanel.add(lblNama);
                infoPanel.add(lblJenis);
                infoPanel.add(lblTerbit);
                infoPanel.add(lblHarga);
                card.add(infoPanel, BorderLayout.CENTER);

                // Input Pesanan > 1
                JPanel orderPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                orderPanel.setBackground(Color.WHITE);
                orderPanel.add(new JLabel("Pesan Tiket: "));
                spinners[i] = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
                orderPanel.add(spinners[i]);
                card.add(orderPanel, BorderLayout.EAST);

                filmPanel.add(card);
            }

            JScrollPane scrollPane = new JScrollPane(filmPanel);
            scrollPane.getVerticalScrollBar().setUnitIncrement(16);
            add(scrollPane, BorderLayout.CENTER);

            // Footer Tombol
            JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
            footerPanel.setBackground(Color.WHITE);

            JButton btnKembali = new JButton("KEMBALI");
            JButton btnHapus = new JButton("HAPUS PESANAN");
            JButton btnSave = new JButton("SAVE DATA");
            JButton btnLanjut = new JButton("TAMBAH PESANAN & BAYAR");

            btnKembali.addActionListener(e -> {
                dispose();
                new LoginFrame().setVisible(true);
            });

            btnHapus.addActionListener(e -> {
                for (JSpinner spinner : spinners) {
                    spinner.setValue(0);
                }
                JOptionPane.showMessageDialog(this, "Semua pesanan dihapus!");
            });

            btnSave.addActionListener(e -> {
                tanggalHariIni = LocalDate.now().format(dtf);
                headerDate.setText("Tanggal Hari Ini: " + tanggalHariIni);
                JOptionPane.showMessageDialog(this, "Data Film & Tanggal berhasil di-save dan diperbarui!");
            });

            btnLanjut.setBackground(new Color(46, 204, 113));
            btnLanjut.setForeground(Color.WHITE);
            btnLanjut.setFont(new Font("Arial", Font.BOLD, 14));

            btnLanjut.addActionListener(e -> {
                int totalHarga = 0;
                List<String> listPesanan = new ArrayList<>();
                List<Integer> indexFilmDipilih = new ArrayList<>();

                for (int i = 0; i < namaFilm.length; i++) {
                    int qty = (Integer) spinners[i].getValue();
                    if (qty > 0) {
                        int sub = qty * hargaFilm[i];
                        totalHarga += sub;
                        listPesanan.add(namaFilm[i] + " (x" + qty + ") = Rp " + sub);
                        indexFilmDipilih.add(i);
                    }
                }

                if (totalHarga > 0) {
                    dispose();
                    new PaymentFrame(listPesanan, indexFilmDipilih, totalHarga).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "Pilih minimal 1 film terlebih dahulu!");
                }
            });

            footerPanel.add(btnKembali);
            footerPanel.add(btnHapus);
            footerPanel.add(btnSave);
            footerPanel.add(btnLanjut);

            add(footerPanel, BorderLayout.SOUTH);
        }
    }

    // ==========================================
    // 3. HALAMAN PEMBAYARAN
    // ==========================================
    static class PaymentFrame extends JFrame {
        public PaymentFrame(List<String> listPesanan, List<Integer> indexFilmDipilih, int totalHarga) {
            setTitle("Pembayaran - Bioskop Aldo");
            setSize(500, 500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(new BorderLayout());

            JPanel panel = new JPanel(new GridLayout(6, 1, 5, 5));
            panel.setBorder(new EmptyBorder(20, 30, 20, 30));

            JLabel lblTitle = new JLabel("DETAIL PEMBAYARAN", SwingConstants.CENTER);
            lblTitle.setFont(new Font("Arial", Font.BOLD, 22));

            StringBuilder sb = new StringBuilder();
            sb.append("Tanggal Transaksi: ").append(tanggalHariIni).append("\n\n");
            for (String s : listPesanan) {
                sb.append("- ").append(s).append("\n");
            }

            JTextArea txtDetail = new JTextArea(sb.toString());
            txtDetail.setEditable(false);
            JScrollPane scrollDetail = new JScrollPane(txtDetail);

            JLabel lblTotal = new JLabel("Total Bayar: Rp " + totalHarga, SwingConstants.CENTER);
            lblTotal.setFont(new Font("Arial", Font.BOLD, 20));
            lblTotal.setForeground(Color.RED);

            JLabel lblMetode = new JLabel("Pilih Metode Pembayaran:");
            String[] metode = {
                "DANA QR", "GOPAY QR", "OVO QR",
                "Mobile Banking BCA", "Mobile Banking MANDIRI",
                "Mobile Banking BNI", "Mobile Banking BRI"
            };
            JComboBox<String> comboMetode = new JComboBox<>(metode);

            JButton btnBayar = new JButton("BAYAR SEKARANG");
            btnBayar.setBackground(new Color(41, 128, 185));
            btnBayar.setForeground(Color.WHITE);
            btnBayar.setFont(new Font("Arial", Font.BOLD, 16));

            JButton btnKembali = new JButton("Kembali");

            btnBayar.addActionListener(e -> {
                playSound("assets/sound.wav");
                JOptionPane.showMessageDialog(this, "Pembayaran berhasil menggunakan " + comboMetode.getSelectedItem() + " pada " + tanggalHariIni);
                dispose();
                new PlaybackFrame(indexFilmDipilih).setVisible(true);
            });

            btnKembali.addActionListener(e -> {
                dispose();
                new MainFrame().setVisible(true);
            });

            panel.add(lblTitle);
            panel.add(scrollDetail);
            panel.add(lblTotal);
            panel.add(lblMetode);
            panel.add(comboMetode);

            JPanel botPanel = new JPanel(new GridLayout(1, 2, 10, 10));
            botPanel.add(btnKembali);
            botPanel.add(btnBayar);
            panel.add(botPanel);

            add(panel, BorderLayout.CENTER);
        }
    }

    // ==========================================
    // 4. HALAMAN PEMUTARAN FILM & NEXT KE FILM BERIKUTNYA
    // ==========================================
    static class PlaybackFrame extends JFrame {
        int posisiAntrean = 0;
        int progress = 0;
        Timer timer;
        JLabel lblStatus;
        JLabel lblPoster;
        JProgressBar progressBar;
        JButton btnNext;
        JButton btnBukaYoutube;
        List<Integer> daftarIndexFilm;

        public PlaybackFrame(List<Integer> indexFilmDipilih) {
            this.daftarIndexFilm = indexFilmDipilih;

            setTitle("Bioskop Aldo - Sedang Menonton");
            setSize(680, 480);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(new BorderLayout(10, 10));
            getContentPane().setBackground(Color.BLACK);

            lblStatus = new JLabel("MEMPERSIAPKAN FILM...", SwingConstants.CENTER);
            lblStatus.setFont(new Font("Arial", Font.BOLD, 22));
            lblStatus.setForeground(Color.WHITE);
            lblStatus.setBorder(new EmptyBorder(15, 10, 5, 10));
            add(lblStatus, BorderLayout.NORTH);

            // Panel Tengah (Poster Film & Tombol Kontrol Streaming)
            JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
            centerPanel.setBackground(Color.BLACK);

            lblPoster = new JLabel("", SwingConstants.CENTER);
            centerPanel.add(lblPoster, BorderLayout.CENTER);

            JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
            btnPanel.setBackground(Color.BLACK);

            btnBukaYoutube = new JButton("TAYANGKAN VIDEO (YOUTUBE)");
            btnBukaYoutube.setBackground(new Color(41, 128, 185));
            btnBukaYoutube.setForeground(Color.WHITE);
            btnBukaYoutube.setFont(new Font("Arial", Font.BOLD, 13));

            btnNext = new JButton("NEXT FILM >>");
            btnNext.setBackground(new Color(231, 76, 60));
            btnNext.setForeground(Color.WHITE);
            btnNext.setFont(new Font("Arial", Font.BOLD, 14));

            btnPanel.add(btnBukaYoutube);
            btnPanel.add(btnNext);
            centerPanel.add(btnPanel, BorderLayout.SOUTH);

            add(centerPanel, BorderLayout.CENTER);

            progressBar = new JProgressBar(0, 100);
            progressBar.setStringPainted(true);
            progressBar.setForeground(Color.RED);
            progressBar.setBackground(Color.DARK_GRAY);
            add(progressBar, BorderLayout.SOUTH);

            // Aksi Buka Video YouTube Langsung Tanpa Download
            btnBukaYoutube.addActionListener(e -> {
                if (posisiAntrean < daftarIndexFilm.size()) {
                    int filmIdx = daftarIndexFilm.get(posisiAntrean);
                    bukaLinkBrowser(linkYoutubeFilm[filmIdx]);
                }
            });

            // Aksi Tombol NEXT FILM
            btnNext.addActionListener(e -> {
                progress = 0;
                posisiAntrean++;
                if (posisiAntrean < daftarIndexFilm.size()) {
                    muatFilmSekarang(true);
                } else {
                    selesaiMenonton();
                }
            });

            // Timer otomatis berjalan
            timer = new Timer(120, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (posisiAntrean < daftarIndexFilm.size()) {
                        progress++;
                        progressBar.setValue(progress);
                        if (progress >= 100) {
                            progress = 0;
                            posisiAntrean++;
                            if (posisiAntrean < daftarIndexFilm.size()) {
                                muatFilmSekarang(true);
                            } else {
                                selesaiMenonton();
                            }
                        }
                    }
                }
            });

            // Mulai film pertama
            muatFilmSekarang(true);
            timer.start();
        }

        private void muatFilmSekarang(boolean autoBukaBrowser) {
            int filmIdx = daftarIndexFilm.get(posisiAntrean);
            lblStatus.setText("SEDANG MEMUTAR (" + (posisiAntrean + 1) + "/" + daftarIndexFilm.size() + "): " + namaFilm[filmIdx]);

            if (posisiAntrean == daftarIndexFilm.size() - 1) {
                btnNext.setText("SELESAI MENONTON >>");
            } else {
                btnNext.setText("NEXT FILM >>");
            }

            // Tampilkan poster film yang sedang diputar
            new Thread(() -> {
                try {
                    BufferedImage img = ImageIO.read(new URL(posterUrl[filmIdx]));
                    if (img != null) {
                        Image scaled = img.getScaledInstance(320, 200, Image.SCALE_SMOOTH);
                        SwingUtilities.invokeLater(() -> lblPoster.setIcon(new ImageIcon(scaled)));
                    }
                } catch (Exception ignored) {}
            }).start();

            if (autoBukaBrowser) {
                bukaLinkBrowser(linkYoutubeFilm[filmIdx]);
            }
        }

        private void selesaiMenonton() {
            timer.stop();
            lblPoster.setVisible(false);
            btnBukaYoutube.setVisible(false);
            btnNext.setVisible(false);
            progressBar.setVisible(false);

            lblStatus.setText("<html><center><br><br>Terimakasih udah menonton<br>Bioskop aldo<br><br><font size='4' color='#bdc3c7'>Kembali otomatis ke Menu Utama Login Customer...</font></center></html>");

            // Otomatis kembali ke Halaman Login Customer setelah 3 detik
            Timer timerKembali = new Timer(3000, evt -> {
                dispose();
                new LoginFrame().setVisible(true);
            });
            timerKembali.setRepeats(false);
            timerKembali.start();
        }
    }

    // Membuka Link Film YouTube Langsung di Browser
    public static void bukaLinkBrowser(String url) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(url));
            }
        } catch (Exception e) {
            System.out.println("Gagal membuka link: " + url);
        }
    }

    // ==========================================
    // 5. FITUR AUDIO (SOUND EFFECT)
    // ==========================================
    public static void playSound(String filepath) {
        try {
            File audioFile = new File(filepath);
            if (audioFile.exists()) {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
            } else {
                Toolkit.getDefaultToolkit().beep();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
