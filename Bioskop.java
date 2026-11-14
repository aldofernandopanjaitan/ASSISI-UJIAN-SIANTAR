package bioskop;

import javax.imageio.ImageIO;
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
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * Modern Bioskop Aldo App
 * Kompatibel 100% dengan NetBeans IDE 8.2 & Terhubung ke GitHub Pages
 */
public class Bioskop {

    // URL Web HTML Bioskop Aldo di GitHub Pages
    static final String GITHUB_WEB_URL = "https://GANTI_DENGAN_LINK_GITHUB_PAGES_KAMU";

    // Format Tanggal Otomatis
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MMMM yyyy");
    static String tanggalHariIni = LocalDate.now().format(dtf);

    // Data Film & Link YouTube
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
    static String[] youtubeIds = {
        "LU5nxqxucWY",
        "ZsILQqRpMp0",
        "Gh44m59Jolc"
    };
    static String[] youtubeLinks = {
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
            setSize(450, 360);
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
            setSize(820, 630);
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
                final int index = i;
                JPanel card = new JPanel(new BorderLayout(15, 15));
                card.setBackground(Color.WHITE);
                card.setBorder(BorderFactory.createCompoundBorder(
                        new EmptyBorder(10, 20, 10, 20),
                        BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1)
                ));

                // Poster Film (Otomatis dari Thumbnail YouTube + Fallback Poster Grafis)
                JLabel lblGambar = new JLabel();
                lblGambar.setPreferredSize(new Dimension(110, 145));
                lblGambar.setIcon(buatPosterCadangan(namaFilm[i], i));
                muatThumbnailYouTubeAsync(youtubeIds[i], lblGambar);
                card.add(lblGambar, BorderLayout.WEST);

                // Info Film
                JPanel infoPanel = new JPanel(new GridLayout(4, 1));
                infoPanel.setBackground(Color.WHITE);

                JLabel lblNama = new JLabel(namaFilm[i]);
                lblNama.setFont(new Font("Arial", Font.BOLD, 18));

                JLabel lblJenis = new JLabel("Genre: " + jenisFilm[i]);

                String tglTerbit = LocalDate.now().minusDays(5L * (i + 1)).format(dtf);
                JLabel lblTerbit = new JLabel("Rilis: " + tglTerbit);

                JLabel lblHarga = new JLabel("Harga: Rp " + hargaFilm[i]);
                lblHarga.setForeground(new Color(39, 174, 96));
                lblHarga.setFont(new Font("Arial", Font.BOLD, 14));

                infoPanel.add(lblNama);
                infoPanel.add(lblJenis);
                infoPanel.add(lblTerbit);
                infoPanel.add(lblHarga);
                card.add(infoPanel, BorderLayout.CENTER);

                // Input Pesanan
                JPanel orderPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                orderPanel.setBackground(Color.WHITE);
                orderPanel.add(new JLabel("Pesan Tiket: "));
                spinners[index] = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
                orderPanel.add(spinners[index]);
                card.add(orderPanel, BorderLayout.EAST);

                filmPanel.add(card);
            }

            JScrollPane scrollPane = new JScrollPane(filmPanel);
            scrollPane.getVerticalScrollBar().setUnitIncrement(16);
            add(scrollPane, BorderLayout.CENTER);

            // Footer - Tombol Kontrol
            JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 10));
            footerPanel.setBackground(Color.WHITE);

            JButton btnKembali = new JButton("KEMBALI");
            JButton btnHapus = new JButton("HAPUS PESANAN");
            JButton btnSave = new JButton("SAVE DATA");
            JButton btnWeb = new JButton("BUKA WEB GITHUB");
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

            btnWeb.addActionListener(e -> bukaBrowser(GITHUB_WEB_URL));

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
            footerPanel.add(btnWeb);
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
            setSize(520, 500);
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
    // 4. HALAMAN PEMUTARAN SLIDE FILM & AUTO LOGIN
    // ==========================================
    static class PlaybackFrame extends JFrame {
        int slideAktif = 0;
        List<Integer> daftarIndexFilm;
        JLabel lblSlideInfo;
        JLabel lblJudulFilm;
        JLabel lblPosterBesar;
        JButton btnNextSlide;
        JButton btnBukaYoutube;

        public PlaybackFrame(List<Integer> indexFilmDipilih) {
            this.daftarIndexFilm = indexFilmDipilih;

            setTitle("Bioskop Aldo - Sedang Menonton");
            setSize(700, 480);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(new BorderLayout(10, 10));
            getContentPane().setBackground(Color.BLACK);

            lblSlideInfo = new JLabel("", SwingConstants.CENTER);
            lblSlideInfo.setFont(new Font("Arial", Font.BOLD, 16));
            lblSlideInfo.setForeground(new Color(231, 76, 60));
            lblSlideInfo.setBorder(new EmptyBorder(15, 10, 5, 10));
            add(lblSlideInfo, BorderLayout.NORTH);

            JPanel centerPanel = new JPanel(new BorderLayout(10, 10));
            centerPanel.setBackground(Color.BLACK);

            lblPosterBesar = new JLabel("", SwingConstants.CENTER);
            centerPanel.add(lblPosterBesar, BorderLayout.CENTER);

            lblJudulFilm = new JLabel("", SwingConstants.CENTER);
            lblJudulFilm.setFont(new Font("Arial", Font.BOLD, 22));
            lblJudulFilm.setForeground(Color.WHITE);
            centerPanel.add(lblJudulFilm, BorderLayout.SOUTH);

            add(centerPanel, BorderLayout.CENTER);

            JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
            controlPanel.setBackground(new Color(20, 20, 20));

            btnBukaYoutube = new JButton("PUTAR VIDEO YOUTUBE DI BROWSER");
            btnBukaYoutube.setBackground(new Color(41, 128, 185));
            btnBukaYoutube.setForeground(Color.WHITE);
            btnBukaYoutube.setFont(new Font("Arial", Font.BOLD, 13));

            btnNextSlide = new JButton("NEXT SLIDE >>");
            btnNextSlide.setBackground(new Color(229, 9, 20));
            btnNextSlide.setForeground(Color.WHITE);
            btnNextSlide.setFont(new Font("Arial", Font.BOLD, 14));

            btnBukaYoutube.addActionListener(e -> {
                int filmIdx = daftarIndexFilm.get(slideAktif);
                bukaBrowser(youtubeLinks[filmIdx]);
            });

            btnNextSlide.addActionListener(e -> {
                if (slideAktif < daftarIndexFilm.size() - 1) {
                    slideAktif++;
                    tampilkanSlide(slideAktif);
                } else {
                    selesaiMenonton();
                }
            });

            controlPanel.add(btnBukaYoutube);
            controlPanel.add(btnNextSlide);
            add(controlPanel, BorderLayout.SOUTH);

            tampilkanSlide(0);
        }

        private void tampilkanSlide(int idx) {
            int filmIdx = daftarIndexFilm.get(idx);
            lblSlideInfo.setText("SLIDE " + (idx + 1) + " DARI " + daftarIndexFilm.size());
            lblJudulFilm.setText("SEDANG MEMUTAR: " + namaFilm[filmIdx]);
            lblPosterBesar.setIcon(buatPosterCadangan(namaFilm[filmIdx], filmIdx));
            muatThumbnailYouTubeAsync(youtubeIds[filmIdx], lblPosterBesar);

            if (idx < daftarIndexFilm.size() - 1) {
                btnNextSlide.setText("NEXT SLIDE (" + namaFilm[daftarIndexFilm.get(idx + 1)] + ") >>");
            } else {
                btnNextSlide.setText("SELESAI MENONTON");
            }
        }

        private void selesaiMenonton() {
            lblSlideInfo.setText("");
            lblPosterBesar.setIcon(null);
            btnBukaYoutube.setVisible(false);
            btnNextSlide.setVisible(false);
            lblJudulFilm.setText("<html><center>Terimakasih udah menonton<br>Bioskop aldo</center></html>");

            // Otomatis kembali ke Menu Login Customer setelah 3 detik
            Timer timerKembali = new Timer(3000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    dispose();
                    new LoginFrame().setVisible(true);
                }
            });
            timerKembali.setRepeats(false);
            timerKembali.start();
        }
    }

    // ==========================================
    // 5. UTILITAS GAMBAR, BROWSER & AUDIO
    // ==========================================
    public static void muatThumbnailYouTubeAsync(String videoId, JLabel targetLabel) {
        new Thread(() -> {
            try {
                URL url = new URL("https://img.youtube.com/vi/" + videoId + "/hqdefault.jpg");
                BufferedImage img = ImageIO.read(url);
                if (img != null) {
                    int w = targetLabel.getWidth() > 0 ? targetLabel.getWidth() : 110;
                    int h = targetLabel.getHeight() > 0 ? targetLabel.getHeight() : 145;
                    Image scaled = img.getScaledInstance(w, h, Image.SCALE_SMOOTH);
                    SwingUtilities.invokeLater(() -> targetLabel.setIcon(new ImageIcon(scaled)));
                }
            } catch (Exception ignored) {
            }
        }).start();
    }

    public static ImageIcon buatPosterCadangan(String judul, int nomor) {
        BufferedImage img = new BufferedImage(110, 145, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = img.createGraphics();
        Color[] warna = {new Color(26, 82, 118), new Color(120, 40, 31), new Color(29, 131, 72)};
        g2.setColor(warna[nomor % warna.length]);
        g2.fillRect(0, 0, 110, 145);
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.BOLD, 12));
        g2.drawString("BIOSKOP ALDO", 10, 30);
        g2.drawString("FILM #" + (nomor + 1), 10, 55);
        g2.dispose();
        return new ImageIcon(img);
    }

    public static void bukaBrowser(String url) {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().browse(new URI(url));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Silakan buka link ini di browser:\n" + url);
        }
    }

    public static void playSound(String filepath) {
        try {
            File audioFile = new File(filepath);
            if (audioFile.exists()) {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
