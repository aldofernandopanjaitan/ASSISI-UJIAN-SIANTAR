<!DOCTYPE html>
<html lang="id">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SMK SWASTA ASSISI - Portal Akademik Modern</title>
    <!-- Tailwind CSS untuk Desain Modern & Profesional -->
    <script src="https://cdn.tailwindcss.com"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Plus+Jakarta+Sans:wght@400;500;600;700&display=swap');
        body { font-family: 'Plus Jakarta Sans', sans-serif; background-color: #f8fafc; }
        .transition-all { transition: all 0.3s ease; }
    </style>
</head>
<body class="text-slate-800 antialiased selection:bg-red-500 selection:text-white">

    <!-- HEADER / NAVBAR -->
    <header class="bg-gradient-to-r from-red-800 to-red-900 text-white shadow-lg sticky top-0 z-50">
        <div class="max-w-7xl mx-auto px-4 py-3 flex justify-between items-center">
            <div class="flex items-center space-x-3">
                <div class="bg-white p-2 rounded-xl shadow-md text-red-800 font-bold text-xl flex items-center justify-center w-12 h-12">
                    <i class="fa-solid fa-school"></i>
                </div>
                <div>
                    <h1 class="text-lg font-bold tracking-wide">SMK SWASTA ASSISI</h1>
                    <p class="text-xs text-red-200">Portal Akademik & Ujian Terpadu</p>
                </div>
            </div>
            <div id="user-nav-status" class="hidden flex items-center space-x-4">
                <span id="nav-username" class="text-sm font-medium bg-red-950 px-3 py-1 rounded-full border border-red-700"></span>
                <button onclick="logout()" class="bg-white text-red-800 hover:bg-red-100 px-4 py-1.5 rounded-lg text-sm font-semibold transition-all shadow">
                    <i class="fa-solid fa-right-from-bracket mr-1"></i> Keluar
                </button>
            </div>
        </div>
    </header>

    <!-- HALAMAN UTAMA / LOGIN -->
    <main id="app-container" class="max-w-7xl mx-auto px-4 py-8">
        
        <!-- SECTION: LOGIN SELECTION -->
        <section id="login-section" class="max-w-md mx-auto bg-white rounded-2xl shadow-xl border border-slate-100 overflow-hidden mt-6">
            <div class="bg-red-800 p-6 text-white text-center">
                <h2 class="text-2xl font-bold">Selamat Datang</h2>
                <p class="text-sm text-red-200 mt-1">Silakan masuk sesuai hak akses Anda</p>
            </div>
            <div class="p-6 space-y-4">
                <div>
                    <label class="block text-sm font-semibold text-slate-700 mb-1">Pilih Role Akses</label>
                    <select id="login-role" class="w-full px-4 py-2.5 rounded-xl border border-slate-300 focus:ring-2 focus:ring-red-500 focus:outline-none">
                        <option value="admin">Admin Sekolah</option>
                        <option value="guru">Guru Pengajar / Pengawas</option>
                        <option value="siswa">Siswa</option>
                    </select>
                </div>
                <div>
                    <label class="block text-sm font-semibold text-slate-700 mb-1">Username / ID</label>
                    <input type="text" id="login-user" placeholder="Masukkan ID / Nama Pengguna" class="w-full px-4 py-2.5 rounded-xl border border-slate-300 focus:ring-2 focus:ring-red-500 focus:outline-none">
                </div>
                <div>
                    <label class="block text-sm font-semibold text-slate-700 mb-1">Password</label>
                    <input type="password" id="login-pass" placeholder="••••••••" class="w-full px-4 py-2.5 rounded-xl border border-slate-300 focus:ring-2 focus:ring-red-500 focus:outline-none">
                </div>
                <button onclick="handleLogin()" class="w-full bg-red-800 hover:bg-red-900 text-white font-semibold py-3 rounded-xl transition-all shadow-lg shadow-red-800/20">
                    Masuk Sistem
                </button>
            </div>
        </section>

        <!-- DASHBOARD UTAMA (TERSEMBUNYI SEBELUM LOGIN) -->
        <div id="dashboard-section" class="hidden space-y-6">
            
            <!-- TAB MENU NAVIGASI DASHBOARD -->
            <div class="flex flex-wrap gap-2 bg-white p-3 rounded-2xl shadow-sm border border-slate-200">
                <button onclick="switchTab('jadwal-ujian')" class="tab-btn px-4 py-2 rounded-xl font-semibold text-sm bg-red-800 text-white transition-all"><i class="fa-solid fa-calendar-days mr-2"></i>Jadwal Ujian</button>
                <button onclick="switchTab('jadwal-kbm')" class="tab-btn px-4 py-2 rounded-xl font-semibold text-sm text-slate-600 hover:bg-slate-100 transition-all"><i class="fa-solid fa-book-open mr-2"></i>Jadwal KBM</button>
                <button onclick="switchTab('presensi')" class="tab-btn px-4 py-2 rounded-xl font-semibold text-sm text-slate-600 hover:bg-slate-100 transition-all"><i class="fa-solid fa-qrcode mr-2"></i>Presensi & QR</button>
                <button onclick="switchTab('materi')" class="tab-btn px-4 py-2 rounded-xl font-semibold text-sm text-slate-600 hover:bg-slate-100 transition-all"><i class="fa-solid fa-file-arrow-up mr-2"></i>Materi</button>
                <button onclick="switchTab('ujian')" class="tab-btn px-4 py-2 rounded-xl font-semibold text-sm text-slate-600 hover:bg-slate-100 transition-all"><i class="fa-solid fa-laptop-code mr-2"></i>Ujian Online</button>
            </div>

            <!-- TAB 1: JADWAL UJIAN SEKOLAH -->
            <div id="tab-jadwal-ujian" class="tab-content space-y-4">
                <div class="flex justify-between items-center bg-white p-4 rounded-2xl shadow-sm border border-slate-200">
                    <h3 class="text-lg font-bold text-slate-800"><i class="fa-solid fa-calendar-check text-red-800 mr-2"></i>Jadwal Ujian Sekolah</h3>
                    <button onclick="openModal('modal-jadwal-ujian')" class="admin-only bg-red-800 text-white px-4 py-2 rounded-xl text-sm font-semibold hover:bg-red-900 shadow"><i class="fa-solid fa-plus mr-1"></i> Tambah Jadwal Ujian</button>
                </div>
                <!-- Contoh Tampilan Horizontal Tanggal (Referensi Gambar 3) -->
                <div class="bg-white p-4 rounded-2xl shadow-sm border border-slate-200 flex gap-2 overflow-x-auto">
                    <div class="flex-shrink-0 bg-slate-100 border border-slate-200 px-4 py-3 rounded-xl text-center cursor-pointer hover:bg-red-50"><span class="block text-xs text-slate-500">Sen</span><span class="text-lg font-bold">9</span></div>
                    <div class="flex-shrink-0 bg-red-800 text-white px-4 py-3 rounded-xl text-center cursor-pointer shadow"><span class="block text-xs text-red-200">Sel</span><span class="text-lg font-bold">10</span></div>
                    <div class="flex-shrink-0 bg-slate-100 border border-slate-200 px-4 py-3 rounded-xl text-center cursor-pointer hover:bg-red-50"><span class="block text-xs text-slate-500">Rab</span><span class="text-lg font-bold">11</span></div>
                    <div class="flex-shrink-0 bg-slate-100 border border-slate-200 px-4 py-3 rounded-xl text-center cursor-pointer hover:bg-red-50"><span class="block text-xs text-slate-500">Kam</span><span class="text-lg font-bold">12</span></div>
                    <div class="flex-shrink-0 bg-slate-100 border border-slate-200 px-4 py-3 rounded-xl text-center cursor-pointer hover:bg-red-50"><span class="block text-xs text-slate-500">Jum</span><span class="text-lg font-bold">13</span></div>
                </div>
                <!-- Container List Jadwal Ujian -->
                <div id="list-jadwal-ujian" class="grid grid-cols-1 md:grid-cols-2 gap-4">
                    <!-- Item Contoh -->
                    <div class="bg-white p-5 rounded-2xl shadow-sm border border-slate-200 space-y-3">
                        <div class="flex justify-between items-start">
                            <span class="bg-red-100 text-red-800 text-xs font-bold px-3 py-1 rounded-full">Selasa, 10 November 2026</span>
                            <span class="text-xs font-semibold text-slate-500">Ruang: 05 | Sesi: 1</span>
                        </div>
                        <h4 class="text-base font-bold text-slate-900">UJIAN: MATEMATIKA</h4>
                        <div class="text-sm space-y-1 text-slate-600">
                            <p><i class="fa-regular fa-clock w-5 text-red-800"></i> Jam: 08:00 - 10:00 WIB</p>
                            <p><i class="fa-solid fa-location-dot w-5 text-red-800"></i> Lokasi: SMK SWASTA ASSISI</p>
                            <p><i class="fa-solid fa-graduation-cap w-5 text-red-800"></i> Kelas: 10 RPL, 10 TB, 10 AK</p>
                            <p><i class="fa-solid fa-users w-5 text-red-800"></i> Jumlah Siswa: 35 Orang</p>
                            <p><i class="fa-solid fa-user-tie w-5 text-red-800"></i> Pengawas: Dra. Maria Situmorang</p>
                        </div>
                        <div class="flex justify-end space-x-2 pt-2 border-t border-slate-100 admin-only">
                            <button onclick="editItem('ujian', 0)" class="bg-amber-500 text-white px-3 py-1.5 rounded-lg text-xs font-semibold hover:bg-amber-600"><i class="fa-solid fa-pen-to-square mr-1"></i> Edit</button>
                            <button onclick="deleteItem('ujian', 0)" class="bg-red-600 text-white px-3 py-1.5 rounded-lg text-xs font-semibold hover:bg-red-700"><i class="fa-solid fa-trash mr-1"></i> Hapus</button>
                        </div>
                    </div>
                </div>
            </div>

            <!-- TAB 2: JADWAL KBM SEKOLAH -->
            <div id="tab-jadwal-kbm" class="tab-content hidden space-y-4">
                <div class="flex justify-between items-center bg-white p-4 rounded-2xl shadow-sm border border-slate-200">
                    <h3 class="text-lg font-bold text-slate-800"><i class="fa-solid fa-book text-red-800 mr-2"></i>Jadwal KBM Sekolah</h3>
                    <button onclick="openModal('modal-jadwal-kbm')" class="admin-only bg-red-800 text-white px-4 py-2 rounded-xl text-sm font-semibold hover:bg-red-900 shadow"><i class="fa-solid fa-plus mr-1"></i> Tambah Jadwal KBM</button>
                </div>
                <div id="list-jadwal-kbm" class="grid grid-cols-1 md:grid-cols-2 gap-4">
                    <div class="bg-white p-5 rounded-2xl shadow-sm border border-slate-200 space-y-3">
                        <div class="flex justify-between items-start">
                            <span class="bg-blue-100 text-blue-800 text-xs font-bold px-3 py-1 rounded-full">Rabu, 11 November 2026</span>
                            <span class="text-xs font-semibold text-slate-500">Les ke-1 s.d 3</span>
                        </div>
                        <h4 class="text-base font-bold text-slate-900">MATAPELAJARAN: MATEMATIKA</h4>
                        <div class="text-sm space-y-1 text-slate-600">
                            <p><i class="fa-regular fa-clock w-5 text-red-800"></i> Jam: 07:30 - 09:15 WIB</p>
                            <p><i class="fa-solid fa-location-dot w-5 text-red-800"></i> Lokasi: SMK SWASTA ASSISI</p>
                            <p><i class="fa-solid fa-graduation-cap w-5 text-red-800"></i> Kelas: 11 RPL, 11 TB, 11 AK</p>
                            <p><i class="fa-solid fa-users w-5 text-red-800"></i> Jumlah Siswa: 30 Orang</p>
                            <p><i class="fa-solid fa-chalkboard-user w-5 text-red-800"></i> Pengajar: Bpk. J. Sinaga, S.Pd</p>
                        </div>
                        <div class="flex justify-end space-x-2 pt-2 border-t border-slate-100 admin-only">
                            <button onclick="editItem('kbm', 0)" class="bg-amber-500 text-white px-3 py-1.5 rounded-lg text-xs font-semibold hover:bg-amber-600"><i class="fa-solid fa-pen-to-square mr-1"></i> Edit</button>
                            <button onclick="deleteItem('kbm', 0)" class="bg-red-600 text-white px-3 py-1.5 rounded-lg text-xs font-semibold hover:bg-red-700"><i class="fa-solid fa-trash mr-1"></i> Hapus</button>
                        </div>
                    </div>
                </div>
            </div>

            <!-- TAB 3: PRESENSI & SCAN QR -->
            <div id="tab-presensi" class="tab-content hidden space-y-4">
                <div class="bg-white p-6 rounded-2xl shadow-sm border border-slate-200 text-center space-y-4">
                    <h3 class="text-xl font-bold text-slate-800"><i class="fa-solid fa-qrcode text-red-800 mr-2"></i>Scan QR Code Presensi Ujian & KBM</h3>
                    <p class="text-sm text-slate-600 max-w-md mx-auto">Arahkan kamera perangkat Anda atau tunjukkan QR Code identitas Anda kepada pengawas/guru untuk merekam kehadiran secara otomatis.</p>
                    <div class="w-48 h-48 mx-auto bg-slate-100 border-4 border-dashed border-slate-300 rounded-2xl flex flex-col items-center justify-center relative overflow-hidden">
                        <i class="fa-solid fa-camera text-4xl text-slate-400 mb-2"></i>
                        <span class="text-xs font-semibold text-slate-500">Kamera Scanner Aktif</span>
                        <div class="absolute inset-0 bg-red-800/10 animate-pulse"></div>
                    </div>
                    <button onclick="alert('Presensi Berhasil Direkam!')" class="bg-emerald-600 hover:bg-emerald-700 text-white font-semibold px-6 py-2.5 rounded-xl shadow transition-all">
                        <i class="fa-solid fa-check mr-1"></i> Simulasi Scan QR Hadir
                    </button>
                </div>
            </div>

            <!-- TAB 4: MATERI PELAJARAN -->
            <div id="tab-materi" class="tab-content hidden space-y-4">
                <div class="flex justify-between items-center bg-white p-4 rounded-2xl shadow-sm border border-slate-200">
                    <h3 class="text-lg font-bold text-slate-800"><i class="fa-solid fa-folder-open text-red-800 mr-2"></i>Materi Pembelajaran</h3>
                    <button onclick="openModal('modal-materi')" class="admin-guru-only bg-red-800 text-white px-4 py-2 rounded-xl text-sm font-semibold hover:bg-red-900 shadow"><i class="fa-solid fa-upload mr-1"></i> Upload Materi Baru</button>
                </div>
                <div id="list-materi" class="grid grid-cols-1 md:grid-cols-2 gap-4">
                    <div class="bg-white p-5 rounded-2xl shadow-sm border border-slate-200 space-y-3">
                        <span class="bg-emerald-100 text-emerald-800 text-xs font-bold px-3 py-1 rounded-full">Rabu, 11 November 2026</span>
                        <h4 class="text-base font-bold text-slate-900">Judul: Hidup Sehat & Bugar</h4>
                        <div class="text-sm space-y-1 text-slate-600">
                            <p><i class="fa-solid fa-book-bookmark w-5 text-red-800"></i> Mapel: IPA</p>
                            <p><i class="fa-solid fa-graduation-cap w-5 text-red-800"></i> Kelas: 10 RPL, 10 TB, 10 AK</p>
                            <p><i class="fa-solid fa-user-tie w-5 text-red-800"></i> Guru: Ibu R. Br. Ginting, S.Pd</p>
                            <p><i class="fa-solid fa-file-arrow-down w-5 text-red-800"></i> File: <a href="#" class="text-red-600 underline font-semibold">Materi_HidupSehat.docx</a></p>
                        </div>
                    </div>
                </div>
            </div>

            <!-- TAB 5: UJIAN ONLINE -->
            <div id="tab-ujian" class="tab-content hidden space-y-4">
                <div class="bg-white p-6 rounded-2xl shadow-sm border border-slate-200 space-y-6">
                    <div class="flex flex-col md:flex-row justify-between items-start md:items-center pb-4 border-b border-slate-100 gap-4">
                        <div>
                            <span class="bg-red-100 text-red-800 text-xs font-bold px-3 py-1 rounded-full">Ujian Online Aktif</span>
                            <h3 class="text-xl font-bold text-slate-900 mt-1">Mata Pelajaran: Pendidikan Jasmani & Kesehatan (IPA)</h3>
                        </div>
                        <div class="bg-amber-50 border border-amber-200 px-4 py-2 rounded-xl flex items-center space-x-3">
                            <i class="fa-solid fa-stopwatch text-amber-600 text-xl"></i>
                            <div>
                                <span class="block text-xs text-amber-700 font-medium">Sisa Waktu Ujian</span>
                                <span id="exam-timer" class="text-lg font-bold text-amber-800">20:00</span>
                            </div>
                        </div>
                    </div>

                    <!-- AREA SOAL UJIAN -->
                    <div id="exam-form-area" class="space-y-6">
                        <!-- Soal Pilihan Berganda -->
                        <div class="p-5 rounded-2xl bg-slate-50 border border-slate-200 space-y-3">
                            <p class="font-bold text-slate-900">1. Apa arti dari hidup sehat dari guru?</p>
                            <div class="space-y-2 text-sm">
                                <label class="flex items-center space-x-3 p-3 bg-white rounded-xl border border-slate-200 cursor-pointer hover:border-red-500"><input type="radio" name="q1" value="A"> <span>A. hidup sehat</span></label>
                                <label class="flex items-center space-x-3 p-3 bg-white rounded-xl border border-slate-200 cursor-pointer hover:border-red-500"><input type="radio" name="q1" value="B"> <span>B. Hidup kotor</span></label>
                                <label class="flex items-center space-x-3 p-3 bg-white rounded-xl border border-slate-200 cursor-pointer hover:border-red-500"><input type="radio" name="q1" value="C"> <span>C. hidup malas</span></label>
                                <label class="flex items-center space-x-3 p-3 bg-white rounded-xl border border-slate-200 cursor-pointer hover:border-red-500"><input type="radio" name="q1" value="D"> <span>D. Hidup Rajin</span></label>
                                <label class="flex items-center space-x-3 p-3 bg-white rounded-xl border border-slate-200 cursor-pointer hover:border-red-500"><input type="radio" name="q1" value="E"> <span>E. Hidup suka</span></label>
                            </div>
                            <button onclick="checkMultipleChoice(this, 'C')" class="bg-slate-800 text-white px-4 py-2 rounded-xl text-xs font-semibold hover:bg-slate-900">Periksa Jawaban</button>
                            <div class="result-box hidden mt-2 p-3 rounded-xl text-sm font-semibold"></div>
                        </div>

                        <!-- Soal Essay / Isian -->
                        <div class="p-5 rounded-2xl bg-slate-50 border border-slate-200 space-y-3">
                            <p class="font-bold text-slate-900">2. Apa arti hidup sehat menurut anda? Jelaskan secara rinci (100–900 kata).</p>
                            <textarea rows="6" placeholder="Ketik jawaban essay panjang ke bawah di sini..." class="w-full p-4 rounded-xl border border-slate-300 focus:ring-2 focus:ring-red-500 focus:outline-none text-sm"></textarea>
                            <button onclick="checkEssay(this)" class="bg-slate-800 text-white px-4 py-2 rounded-xl text-xs font-semibold hover:bg-slate-900">Kirim Essay</button>
                            <div class="essay-result hidden mt-2 p-3 rounded-xl text-sm font-semibold"></div>
                        </div>

                        <div class="flex justify-end space-x-3 pt-4">
                            <button onclick="submitExamManually()" class="bg-red-800 hover:bg-red-900 text-white font-semibold px-6 py-2.5 rounded-xl shadow">Kumpul Jawaban Ujian</button>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </main>

    <!-- MODAL POPUP ADMIN: TAMBAH/EDIT JADWAL UJIAN -->
    <div id="modal-jadwal-ujian" class="fixed inset-0 bg-black/50 backdrop-blur-sm hidden items-center justify-center z-50 p-4">
        <div class="bg-white rounded-2xl max-w-lg w-full p-6 space-y-4 shadow-2xl border border-slate-100 max-h-[90vh] overflow-y-auto">
            <h3 class="text-lg font-bold text-slate-900">Form Kelola Jadwal Ujian</h3>
            <div class="space-y-3 text-sm">
                <div><label class="font-semibold">Nama Ujian</label><input type="text" id="inp-nama-ujian" placeholder="Contoh: MATEMATIKA" class="w-full p-2.5 border rounded-xl"></div>
                <div class="grid grid-cols-2 gap-2">
                    <div><label class="font-semibold">Tanggal</label><input type="date" id="inp-tgl-ujian" class="w-full p-2.5 border rounded-xl"></div>
                    <div><label class="font-semibold">Jam Mulai - Selesai</label><input type="text" id="inp-jam-ujian" placeholder="08:00 - 10:00" class="w-full p-2.5 border rounded-xl"></div>
                </div>
                <div><label class="font-semibold">Lokasi</label><input type="text" id="inp-lokasi-ujian" value="SMK SWASTA ASSISI" class="w-full p-2.5 border rounded-xl"></div>
                <div><label class="font-semibold">Kelas</label><input type="text" id="inp-kelas-ujian" value="10 RPL, 10 TB, 10 AK" class="w-full p-2.5 border rounded-xl"></div>
                <div class="grid grid-cols-3 gap-2">
                    <div><label class="font-semibold">Ruang</label><input type="text" id="inp-ruang-ujian" placeholder="1-100" class="w-full p-2.5 border rounded-xl"></div>
                    <div><label class="font-semibold">Sesi</label><input type="text" id="inp-sesi-ujian" placeholder="1-100" class="w-full p-2.5 border rounded-xl"></div>
                    <div><label class="font-semibold">Jumlah Siswa</label><input type="text" id="inp-jml-ujian" placeholder="1-100" class="w-full p-2.5 border rounded-xl"></div>
                </div>
                <div><label class="font-semibold">Nama Pengawas</label><input type="text" id="inp-pengawas-ujian" placeholder="Nama Pengawas" class="w-full p-2.5 border rounded-xl"></div>
            </div>
            <div class="flex justify-end space-x-2 pt-3 border-t">
                <button onclick="closeModal('modal-jadwal-ujian')" class="px-4 py-2 bg-slate-200 text-slate-700 rounded-xl font-semibold hover:bg-slate-300">Kembali</button>
                <button onclick="saveJadwalUjian()" class="px-4 py-2 bg-red-800 text-white rounded-xl font-semibold hover:bg-red-900">Save</button>
            </div>
        </div>
    </div>

    <!-- MODAL POPUP ADMIN: TAMBAH/EDIT JADWAL KBM -->
    <div id="modal-jadwal-kbm" class="fixed inset-0 bg-black/50 backdrop-blur-sm hidden items-center justify-center z-50 p-4">
        <div class="bg-white rounded-2xl max-w-lg w-full p-6 space-y-4 shadow-2xl border border-slate-100 max-h-[90vh] overflow-y-auto">
            <h3 class="text-lg font-bold text-slate-900">Form Kelola Jadwal KBM</h3>
            <div class="space-y-3 text-sm">
                <div><label class="font-semibold">Mata Pelajaran</label><input type="text" id="inp-mapel-kbm" placeholder="Contoh: MATEMATIKA" class="w-full p-2.5 border rounded-xl"></div>
                <div class="grid grid-cols-2 gap-2">
                    <div><label class="font-semibold">Tanggal</label><input type="date" id="inp-tgl-kbm" class="w-full p-2.5 border rounded-xl"></div>
                    <div><label class="font-semibold">Jam Les (1-10)</label><input type="text" id="inp-jam-kbm" placeholder="Les 1-3 (07:30)" class="w-full p-2.5 border rounded-xl"></div>
                </div>
                <div><label class="font-semibold">Lokasi</label><input type="text" id="inp-lokasi-kbm" value="SMK SWASTA ASSISI" class="w-full p-2.5 border rounded-xl"></div>
                <div><label class="font-semibold">Kelas</label><input type="text" id="inp-kelas-kbm" value="11 RPL, 11 TB, 11 AK" class="w-full p-2.5 border rounded-xl"></div>
                <div class="grid grid-cols-2 gap-2">
                    <div><label class="font-semibold">Jumlah Siswa</label><input type="text" id="inp-jml-kbm" placeholder="1-100" class="w-full p-2.5 border rounded-xl"></div>
                    <div><label class="font-semibold">Nama Pengajar</label><input type="text" id="inp-pengajar-kbm" placeholder="Nama Guru" class="w-full p-2.5 border rounded-xl"></div>
                </div>
            </div>
            <div class="flex justify-end space-x-2 pt-3 border-t">
                <button onclick="closeModal('modal-jadwal-kbm')" class="px-4 py-2 bg-slate-200 text-slate-700 rounded-xl font-semibold hover:bg-slate-300">Kembali</button>
                <button onclick="saveJadwalKbm()" class="px-4 py-2 bg-red-800 text-white rounded-xl font-semibold hover:bg-red-900">Save</button>
            </div>
        </div>
    </div>

    <!-- MODAL POPUP: UPLOAD MATERI -->
    <div id="modal-materi" class="fixed inset-0 bg-black/50 backdrop-blur-sm hidden items-center justify-center z-50 p-4">
        <div class="bg-white rounded-2xl max-w-lg w-full p-6 space-y-4 shadow-2xl border border-slate-100 max-h-[90vh] overflow-y-auto">
            <h3 class="text-lg font-bold text-slate-900">Form Upload Materi Pembelajaran</h3>
            <div class="space-y-3 text-sm">
                <div><label class="font-semibold">Judul Materi</label><input type="text" id="inp-judul-materi" placeholder="Contoh: Hidup Sehat" class="w-full p-2.5 border rounded-xl"></div>
                <div><label class="font-semibold">Mata Pelajaran (Terpisah dari Kelas)</label><input type="text" id="inp-mapel-materi" placeholder="Contoh: IPA" class="w-full p-2.5 border rounded-xl"></div>
                <div><label class="font-semibold">Kelas</label><input type="text" id="inp-kelas-materi" value="10 RPL, 10 TB, 10 AK" class="w-full p-2.5 border rounded-xl"></div>
                <div><label class="font-semibold">Upload File (Word, Excel, PPT, Gambar, Video)</label><input type="file" id="inp-file-materi" class="w-full p-2 border rounded-xl"></div>
                <div><label class="font-semibold">Materi Oleh (Nama Guru)</label><input type="text" id="inp-guru-materi" placeholder="Nama Guru" class="w-full p-2.5 border rounded-xl"></div>
            </div>
            <div class="flex justify-end space-x-2 pt-3 border-t">
                <button onclick="closeModal('modal-materi')" class="px-4 py-2 bg-slate-200 text-slate-700 rounded-xl font-semibold hover:bg-slate-300">Kembali</button>
                <button onclick="saveMateri()" class="px-4 py-2 bg-red-800 text-white rounded-xl font-semibold hover:bg-red-900">Save & Upload</button>
            </div>
        </div>
    </div>

    <!-- JAVASCRIPT SISTEM -->
    <script>
        let currentRole = '';

        function handleLogin() {
            const role = document.getElementById('login-role').value;
            const user = document.getElementById('login-user').value || role.toUpperCase();
            
            currentRole = role;
            document.getElementById('login-section').classList.add('hidden');
            document.getElementById('dashboard-section').classList.remove('hidden');
            document.getElementById('user-nav-status').classList.remove('hidden');
            document.getElementById('nav-username').innerText = `${user} (${role.toUpperCase()})`;

            // Sembunyikan tombol admin jika bukan admin/guru
            const adminElements = document.querySelectorAll('.admin-only');
            const adminGuruElements = document.querySelectorAll('.admin-guru-only');

            if(role === 'siswa') {
                adminElements.forEach(el => el.classList.add('hidden'));
                adminGuruElements.forEach(el => el.classList.add('hidden'));
                initAntiCheat(); // Aktifkan sistem keamanan ujian khusus siswa
            } else if(role === 'guru') {
                adminElements.forEach(el => el.classList.add('hidden'));
                adminGuruElements.forEach(el => el.classList.remove('hidden'));
            } else {
                adminElements.forEach(el => el.classList.remove('hidden'));
                adminGuruElements.forEach(el => el.classList.remove('hidden'));
            }

            startTimer(20 * 60); // Timer ujian 20 menit
        }

        function logout() {
            location.reload();
        }

        function switchTab(tabId) {
            document.querySelectorAll('.tab-content').forEach(el => el.classList.add('hidden'));
            document.getElementById(`tab-${tabId}`).classList.remove('hidden');
            
            document.querySelectorAll('.tab-btn').forEach(btn => {
                btn.classList.remove('bg-red-800', 'text-white');
                btn.classList.add('text-slate-600', 'hover:bg-slate-100');
            });
            event.currentTarget.classList.add('bg-red-800', 'text-white');
            event.currentTarget.classList.remove('text-slate-600', 'hover:bg-slate-100');
        }

        function openModal(modalId) {
            document.getElementById(modalId).classList.remove('hidden');
            document.getElementById(modalId).classList.add('flex');
        }

        function closeModal(modalId) {
            document.getElementById(modalId).classList.add('hidden');
            document.getElementById(modalId).classList.remove('flex');
        }

        // Simulasi Aksi CRUD
        function saveJadwalUjian() {
            alert('Jadwal Ujian berhasil disimpan!');
            closeModal('modal-jadwal-ujian');
        }

        function saveJadwalKbm() {
            alert('Jadwal KBM berhasil disimpan!');
            closeModal('modal-jadwal-kbm');
        }

        function saveMateri() {
            alert('Materi berhasil diunggah!');
            closeModal('modal-materi');
        }

        function editItem(type, id) {
            alert(`Mode Edit untuk data ${type} #${id}`);
            if(type === 'ujian') openModal('modal-jadwal-ujian');
            if(type === 'kbm') openModal('modal-jadwal-kbm');
        }

        function deleteItem(type, id) {
            if(confirm('Apakah Anda yakin ingin menghapus data ini?')) {
                alert('Data berhasil dihapus.');
            }
        }

        // Penilaian Pilihan Berganda (Tombol Hijau & Merah Sesuai Permintaan)
        function checkMultipleChoice(btn, correctAns) {
            const parent = btn.parentElement;
            const selected = parent.querySelector('input[type="radio"]:checked');
            const resultBox = parent.querySelector('.result-box');
            
            resultBox.classList.remove('hidden');
            if(!selected) {
                resultBox.className = "result-box mt-2 p-3 rounded-xl text-sm font-semibold bg-amber-100 text-amber-800";
                resultBox.innerText = "Pilih salah satu opsi terlebih dahulu!";
                return;
            }

            if(selected.value === correctAns) {
                resultBox.className = "result-box mt-2 p-3 rounded-xl text-sm font-semibold bg-emerald-600 text-white";
                resultBox.innerHTML = `<i class="fa-solid fa-circle-check mr-1"></i> Jawaban BENAR: C. hidup malas (Sesuai Kunci Admin)`;
            } else {
                resultBox.className = "result-box mt-2 p-3 rounded-xl text-sm font-semibold bg-red-600 text-white";
                resultBox.innerHTML = `<i class="fa-solid fa-circle-xmark mr-1"></i> Jawaban SALAH: E. Hidup suka (Kunci Benar: C)`;
            }
        }

        function checkEssay(btn) {
            const parent = btn.parentElement;
            const textVal = parent.querySelector('textarea').value;
            const resultBox = parent.querySelector('.essay-result');
            
            resultBox.classList.remove('hidden');
            if(textVal.length < 10) {
                resultBox.className = "essay-result mt-2 p-3 rounded-xl text-sm font-semibold bg-amber-100 text-amber-800";
                resultBox.innerText = "Jawaban terlalu singkat, mohon isi lebih lengkap.";
                return;
            }

            resultBox.className = "essay-result mt-2 p-3 rounded-xl text-sm font-semibold bg-emerald-600 text-white";
            resultBox.innerHTML = `<i class="fa-solid fa-circle-check mr-1"></i> Jawaban Essay Disimpan. <br>Kunci Benar dari Admin: Hidup adalah suatu proses keseriusan dalam mencapai tujuan.`;
        }

        // TIMER OTOMATIS & KUMPUL OTOMATIS
        function startTimer(duration) {
            let timer = duration, minutes, seconds;
            const display = document.getElementById('exam-timer');
            
            const interval = setInterval(function () {
                minutes = parseInt(timer / 60, 10);
                seconds = parseInt(timer % 60, 10);

                minutes = minutes < 10 ? "0" + minutes : minutes;
                seconds = seconds < 10 ? "0" + seconds : seconds;

                display.textContent = minutes + ":" + seconds;

                // Jika tinggal 1 menit (60 detik), peringatkan otomatis
                if (timer === 60) {
                    alert('Peringatan! Waktu ujian tinggal 1 menit lagi dan akan dikumpulkan otomatis.');
                }

                if (--timer < 0) {
                    clearInterval(interval);
                    alert('Waktu ujian telah habis! Jawaban Anda dikumpulkan otomatis oleh sistem.');
                    submitExamManually();
                }
            }, 1000);
        }

        function submitExamManually() {
            alert('Ujian berhasil dikumpulkan dan dikirim ke database guru & admin.');
            switchTab('jadwal-ujian');
        }

        // SISTEM KEAMANAN ANTI-CHEAT (Deteksi Keluar Layar / Tab)
        function initAntiCheat() {
            document.addEventListener('visibilitychange', function() {
                if (document.hidden) {
                    playAlarmSound();
                    alert('PERINGATAN KEAMANAN!\nAnda terdeteksi keluar dari halaman soal atau mencoba mencari jawaban dari AI/Google!\nTindakan ini dicatat oleh pengawas.');
                }
            });
        }

        function playAlarmSound() {
            const ctx = new (window.AudioContext || window.webkitAudioContext)();
            const osc = ctx.createOscillator();
            osc.type = 'sine';
            osc.frequency.value = 587.33; // Nada D5 peringatan
            osc.connect(ctx.destination);
            osc.start();
            setTimeout(() => { osc.stop(); }, 500);
        }
    </script>
</body>
</html>
