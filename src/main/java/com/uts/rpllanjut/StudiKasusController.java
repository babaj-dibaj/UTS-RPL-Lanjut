package com.uts.rpllanjut;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudiKasusController {

    @GetMapping(value = "/studi-kasus", produces = MediaType.TEXT_HTML_VALUE)
    public String halamanStudiKasus() {
        return """
                <!DOCTYPE html>
                <html lang="id">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Studi Kasus - Workflow Proposal Skripsi UIN Jakarta</title>
                    <style>
                        :root {
                            color-scheme: dark;
                            --bg: #0a0e1a;
                            --surface: #121829;
                            --surface-card: #182238;
                            --border: rgba(255, 255, 255, 0.12);
                            --primary: #6366f1;
                            --primary-hover: #4f46e5;
                            --primary-glow: rgba(99, 102, 241, 0.35);
                            --accent: #06b6d4;
                            --accent-green: #10b981;
                            --accent-amber: #f59e0b;
                            --accent-rose: #f43f5e;
                            --text: #f8fafc;
                            --text-muted: #94a3b8;
                            --font: 'Inter', system-ui, -apple-system, sans-serif;
                        }
                        * { box-sizing: border-box; margin: 0; padding: 0; }
                        body {
                            background: radial-gradient(circle at 10% 10%, rgba(99, 102, 241, 0.15) 0, transparent 35%),
                                        radial-gradient(circle at 90% 90%, rgba(6, 182, 212, 0.12) 0, transparent 35%),
                                        var(--bg);
                            font-family: var(--font);
                            color: var(--text);
                            min-height: 100vh;
                            line-height: 1.6;
                            padding-bottom: 60px;
                        }
                        nav {
                            background: rgba(18, 24, 41, 0.85);
                            backdrop-filter: blur(12px);
                            border-bottom: 1px solid var(--border);
                            position: sticky;
                            top: 0;
                            z-index: 100;
                            padding: 14px 24px;
                            display: flex;
                            align-items: center;
                            justify-content: space-between;
                        }
                        .nav-brand {
                            display: flex;
                            align-items: center;
                            gap: 12px;
                            font-weight: 700;
                            font-size: 1.1rem;
                            text-decoration: none;
                            color: var(--text);
                        }
                        .nav-badge {
                            background: linear-gradient(135deg, var(--primary), var(--accent));
                            color: #fff;
                            font-size: 0.72rem;
                            padding: 4px 8px;
                            border-radius: 6px;
                            font-weight: 700;
                            letter-spacing: 0.05em;
                        }
                        .nav-links {
                            display: flex;
                            gap: 16px;
                            align-items: center;
                        }
                        .nav-link {
                            color: var(--text-muted);
                            text-decoration: none;
                            font-size: 0.9rem;
                            font-weight: 500;
                            transition: color 0.2s ease;
                        }
                        .nav-link:hover, .nav-link.active {
                            color: var(--text);
                        }
                        .container {
                            max-width: 1200px;
                            margin: 32px auto 0;
                            padding: 0 20px;
                        }
                        .header-section {
                            margin-bottom: 28px;
                        }
                        .header-tag {
                            display: inline-flex;
                            align-items: center;
                            gap: 8px;
                            background: rgba(99, 102, 241, 0.15);
                            border: 1px solid rgba(99, 102, 241, 0.3);
                            color: #c7d2fe;
                            padding: 6px 14px;
                            border-radius: 999px;
                            font-size: 0.82rem;
                            font-weight: 600;
                            margin-bottom: 12px;
                        }
                        h1 {
                            font-size: clamp(1.8rem, 4vw, 2.4rem);
                            font-weight: 800;
                            letter-spacing: -0.03em;
                            margin-bottom: 8px;
                            background: linear-gradient(135deg, #ffffff 40%, #94a3b8);
                            -webkit-background-clip: text;
                            -webkit-text-fill-color: transparent;
                        }
                        .subtitle {
                            color: var(--text-muted);
                            font-size: 1rem;
                            max-width: 820px;
                        }
                        .stats-row {
                            display: grid;
                            grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
                            gap: 16px;
                            margin-bottom: 28px;
                        }
                        .stat-card {
                            background: var(--surface);
                            border: 1px solid var(--border);
                            border-radius: 16px;
                            padding: 18px 20px;
                            display: flex;
                            flex-direction: column;
                            gap: 6px;
                            box-shadow: 0 4px 20px rgba(0, 0, 0, 0.2);
                        }
                        .stat-num {
                            font-size: 1.8rem;
                            font-weight: 800;
                            color: #fff;
                        }
                        .stat-label {
                            color: var(--text-muted);
                            font-size: 0.82rem;
                            font-weight: 600;
                            text-transform: uppercase;
                            letter-spacing: 0.05em;
                        }
                        .tabs {
                            display: flex;
                            gap: 8px;
                            border-bottom: 1px solid var(--border);
                            margin-bottom: 24px;
                            overflow-x: auto;
                        }
                        .tab-btn {
                            background: none;
                            border: none;
                            color: var(--text-muted);
                            font-family: inherit;
                            font-size: 0.95rem;
                            font-weight: 600;
                            padding: 12px 18px;
                            cursor: pointer;
                            border-bottom: 2px solid transparent;
                            transition: all 0.2s ease;
                            white-space: nowrap;
                        }
                        .tab-btn:hover { color: var(--text); }
                        .tab-btn.active {
                            color: #fff;
                            border-bottom-color: var(--primary);
                        }
                        .tab-pane { display: none; }
                        .tab-pane.active { display: block; }
                        .card {
                            background: var(--surface);
                            border: 1px solid var(--border);
                            border-radius: 20px;
                            padding: 28px;
                            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.25);
                            margin-bottom: 24px;
                        }
                        .card-title {
                            font-size: 1.25rem;
                            font-weight: 700;
                            margin-bottom: 8px;
                            display: flex;
                            align-items: center;
                            justify-content: space-between;
                        }
                        .form-grid {
                            display: grid;
                            grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
                            gap: 18px;
                            margin-top: 18px;
                        }
                        .form-group {
                            display: flex;
                            flex-direction: column;
                            gap: 6px;
                        }
                        .form-group.full { grid-column: 1 / -1; }
                        label {
                            font-size: 0.86rem;
                            font-weight: 600;
                            color: #cbd5e1;
                        }
                        input, select, textarea {
                            background: var(--surface-card);
                            border: 1px solid var(--border);
                            border-radius: 12px;
                            padding: 12px 14px;
                            color: #fff;
                            font-family: inherit;
                            font-size: 0.92rem;
                            outline: none;
                            transition: border-color 0.2s;
                        }
                        input:focus, select:focus, textarea:focus {
                            border-color: var(--primary);
                            box-shadow: 0 0 0 3px var(--primary-glow);
                        }
                        textarea { resize: vertical; min-height: 90px; }
                        .btn-row {
                            display: flex;
                            gap: 12px;
                            margin-top: 20px;
                            align-items: center;
                            flex-wrap: wrap;
                        }
                        .btn {
                            background: linear-gradient(135deg, var(--primary), var(--accent));
                            color: #fff;
                            border: none;
                            border-radius: 12px;
                            padding: 12px 24px;
                            font-family: inherit;
                            font-size: 0.92rem;
                            font-weight: 700;
                            cursor: pointer;
                            transition: transform 0.2s, box-shadow 0.2s;
                            display: inline-flex;
                            align-items: center;
                            gap: 8px;
                        }
                        .btn:hover {
                            transform: translateY(-2px);
                            box-shadow: 0 8px 24px var(--primary-glow);
                        }
                        .btn-secondary {
                            background: rgba(255, 255, 255, 0.08);
                            border: 1px solid var(--border);
                        }
                        .btn-secondary:hover {
                            background: rgba(255, 255, 255, 0.12);
                            box-shadow: none;
                        }
                        .btn-success {
                            background: linear-gradient(135deg, #10b981, #059669);
                        }
                        .task-card {
                            background: var(--surface-card);
                            border: 1px solid var(--border);
                            border-radius: 16px;
                            padding: 22px;
                            margin-bottom: 16px;
                            display: flex;
                            flex-direction: column;
                            gap: 14px;
                            position: relative;
                            border-left: 5px solid var(--primary);
                        }
                        .task-header {
                            display: flex;
                            justify-content: space-between;
                            align-items: flex-start;
                            flex-wrap: wrap;
                            gap: 10px;
                        }
                        .role-badge {
                            padding: 4px 10px;
                            border-radius: 999px;
                            font-size: 0.75rem;
                            font-weight: 700;
                            text-transform: uppercase;
                            letter-spacing: 0.06em;
                        }
                        .role-sekprodi { background: rgba(59, 130, 246, 0.2); color: #93c5fd; border: 1px solid rgba(59, 130, 246, 0.4); }
                        .role-dosen { background: rgba(245, 158, 11, 0.2); color: #fcd34d; border: 1px solid rgba(245, 158, 11, 0.4); }
                        .role-kaprodi { background: rgba(16, 185, 129, 0.2); color: #6ee7b7; border: 1px solid rgba(16, 185, 129, 0.4); }
                        .task-body {
                            display: grid;
                            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
                            gap: 10px;
                            background: rgba(0,0,0,0.2);
                            padding: 14px;
                            border-radius: 10px;
                            font-size: 0.88rem;
                        }
                        .stepper {
                            display: flex;
                            align-items: center;
                            gap: 8px;
                            margin: 16px 0;
                            overflow-x: auto;
                            padding-bottom: 6px;
                        }
                        .step-item {
                            display: flex;
                            align-items: center;
                            gap: 8px;
                            font-size: 0.82rem;
                            color: var(--text-muted);
                            white-space: nowrap;
                        }
                        .step-dot {
                            width: 22px;
                            height: 22px;
                            border-radius: 50%;
                            background: rgba(255, 255, 255, 0.1);
                            display: flex;
                            align-items: center;
                            justify-content: center;
                            font-size: 0.75rem;
                            font-weight: 700;
                        }
                        .step-item.active .step-dot {
                            background: var(--primary);
                            color: #fff;
                            box-shadow: 0 0 10px var(--primary-glow);
                        }
                        .step-item.active { color: #fff; font-weight: 600; }
                        .step-item.done .step-dot {
                            background: var(--accent-green);
                            color: #fff;
                        }
                        .step-line {
                            width: 32px;
                            height: 2px;
                            background: var(--border);
                        }
                        .toast {
                            position: fixed;
                            bottom: 24px;
                            right: 24px;
                            background: #1e293b;
                            border: 1px solid var(--border);
                            border-left: 4px solid var(--primary);
                            padding: 14px 20px;
                            border-radius: 12px;
                            color: #fff;
                            box-shadow: 0 10px 30px rgba(0,0,0,0.5);
                            display: none;
                            z-index: 1000;
                            animation: slideIn 0.3s ease;
                        }
                        @keyframes slideIn {
                            from { transform: translateY(20px); opacity: 0; }
                            to { transform: translateY(0); opacity: 1; }
                        }
                        table {
                            width: 100%;
                            border-collapse: collapse;
                            margin-top: 14px;
                            font-size: 0.88rem;
                        }
                        th, td {
                            padding: 12px 14px;
                            text-align: left;
                            border-bottom: 1px solid var(--border);
                        }
                        th {
                            background: rgba(255, 255, 255, 0.04);
                            color: var(--text-muted);
                            font-weight: 600;
                        }
                        tr:hover { background: rgba(255, 255, 255, 0.02); }
                    </style>
                </head>
                <body>
                    <nav>
                        <a href="/" class="nav-brand">
                            <span>UTS RPL Lanjut</span>
                            <span class="nav-badge">BPMN 2.0</span>
                        </a>
                        <div class="nav-links">
                            <a href="/" class="nav-link">&larr; Beranda</a>
                            <a href="/hello-world" class="nav-link">Hello World BPMN</a>
                            <a href="/studi-kasus" class="nav-link active">Studi Kasus</a>
                            <a href="/teori-5w" class="nav-link">Teori 5W</a>
                            <a href="/dokumentasi" class="nav-link">Dokumentasi & GitHub</a>
                        </div>
                    </nav>

                    <div class="container">
                        <div class="header-section">
                            <div class="header-tag">
                                <span>&#10003; Soal Nomor 3 (Bobot 50%)</span>
                                <span>&bull;</span>
                                <span>Teknik Informatika UIN Jakarta</span>
                            </div>
                            <h1>Simulasi Alur Kerja Proposal Skripsi</h1>
                            <p class="subtitle">
                                Implementasi model BPMN 2.0 menggunakan Camunda BPM Engine yang terintegrasi langsung dengan Spring Boot 3. 
                                Memfasilitasi alur pengajuan proposal skripsi dari mahasiswa, verifikasi Sekretaris Prodi, review Dosen Pembimbing, hingga pengesahan SK oleh Ketua Prodi.
                            </p>
                        </div>

                        <div class="stats-row">
                            <div class="stat-card">
                                <span class="stat-label">Total Diajukan</span>
                                <span class="stat-num" id="statTotal">-</span>
                            </div>
                            <div class="stat-card">
                                <span class="stat-label">Menunggu Tindakan (Tasks)</span>
                                <span class="stat-num" id="statPending" style="color: #f59e0b;">-</span>
                            </div>
                            <div class="stat-card">
                                <span class="stat-label">Selesai & SK Terbit</span>
                                <span class="stat-num" id="statCompleted" style="color: #10b981;">-</span>
                            </div>
                            <div class="stat-card">
                                <span class="stat-label">Engine Platform</span>
                                <span class="stat-num" style="font-size: 1.2rem; color: #a5b4fc;">Camunda 7.20</span>
                            </div>
                        </div>

                        <div class="tabs">
                            <button class="tab-btn active" onclick="switchTab('tab-submit')">1. Ajukan Proposal</button>
                            <button class="tab-btn" onclick="switchTab('tab-tasks')">2. Inbox Verifikasi & Approval <span id="taskBadgeCount" style="background: var(--primary); padding: 2px 7px; border-radius: 999px; font-size: 0.72rem; margin-left: 4px;">0</span></button>
                            <button class="tab-btn" onclick="switchTab('tab-history')">3. Pelacakan & Riwayat</button>
                            <button class="tab-btn" onclick="switchTab('tab-bpmn')">4. Diagram Alur BPMN</button>
                        </div>

                        <!-- TAB 1: FORM AJUKAN -->
                        <div id="tab-submit" class="tab-pane active">
                            <div class="card">
                                <div class="card-title">
                                    <span>Formulir Pengajuan Proposal Skripsi Mahasiswa</span>
                                    <button type="button" class="btn btn-secondary" onclick="autoFillDemo()" style="padding: 6px 12px; font-size: 0.8rem;">
                                        &plus; Isi Contoh Data Otomatis
                                    </button>
                                </div>
                                <p style="color: var(--text-muted); font-size: 0.88rem;">
                                    Saat form ini disubmit, Camunda Engine akan menjalankan instance proses BPMN baru (<code>proposal-skripsi-process</code>) dan meneruskannya ke tugas verifikasi pertama.
                                </p>
                                <form id="formProposal" onsubmit="handleProposalSubmit(event)">
                                    <div class="form-grid">
                                        <div class="form-group">
                                            <label for="nama">Nama Mahasiswa</label>
                                            <input type="text" id="nama" required value="Siti Dibaj Trikusuma">
                                        </div>
                                        <div class="form-group">
                                            <label for="nim">NIM</label>
                                            <input type="text" id="nim" required value="117">
                                        </div>
                                        <div class="form-group">
                                            <label for="email">Email Mahasiswa</label>
                                            <input type="email" id="email" required value="sitidibaj117@mhs.uinjkt.ac.id">
                                        </div>
                                        <div class="form-group">
                                            <label for="bidang">Bidang Kajian / Konsentrasi</label>
                                            <select id="bidang" required>
                                                <option value="Rekayasa Perangkat Lunak">Rekayasa Perangkat Lunak (RPL)</option>
                                                <option value="Sistem Informasi Enterprise">Sistem Informasi Enterprise</option>
                                                <option value="Kecerdasan Buatan & Data Science">Kecerdasan Buatan & Data Science</option>
                                                <option value="Keamanan Jaringan & Komputasi Awan">Keamanan Jaringan & Komputasi Awan</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="pembimbing">Usulan Dosen Pembimbing</label>
                                            <input type="text" id="pembimbing" required value="Rizal Broer Bahaweres, S.Kom., M.Sc., Ph.D.">
                                        </div>
                                        <div class="form-group full">
                                            <label for="judul">Judul Proposal Skripsi</label>
                                            <input type="text" id="judul" required value="Implementasi Business Process Model and Notation (BPMN) dengan Framework Spring Boot untuk Manajemen Alur Kerja Proposal Skripsi">
                                        </div>
                                        <div class="form-group full">
                                            <label for="abstrak">Ringkasan / Abstrak Proposal</label>
                                            <textarea id="abstrak" required>Penelitian ini merancang dan merealisasikan alur verifikasi berkas dan penerbitan SK pembimbing proposal skripsi berbasis Camunda BPM Engine pada arsitektur Spring Boot, mengotomatisasi koordinasi antar mahasiswa, sekretaris prodi, pembimbing, dan ketua prodi.</textarea>
                                        </div>
                                    </div>
                                    <div class="btn-row">
                                        <button type="submit" class="btn" id="btnSubmitProposal">
                                            <span>Mulai Instance BPMN & Ajukan</span> &rarr;
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>

                        <!-- TAB 2: INBOX VERIFIKASI -->
                        <div id="tab-tasks" class="tab-pane">
                            <div class="card">
                                <div class="card-title">
                                    <span>Inbox Verifikasi & Persetujuan Berdasarkan Peran</span>
                                    <button class="btn btn-secondary" onclick="loadActiveTasks()" style="padding: 6px 12px; font-size: 0.8rem;">
                                        &#8635; Refresh Task
                                    </button>
                                </div>
                                <p style="color: var(--text-muted); font-size: 0.88rem; margin-bottom: 20px;">
                                    Tugas-tugas di bawah ini sedang aktif di Camunda <code>TaskService</code>. Klik aksi pada kartu terkait untuk memajukan token alur kerja ke langkah berikutnya!
                                </p>
                                <div id="tasksContainer">
                                    <p style="color: var(--text-muted);">Memuat tugas aktif...</p>
                                </div>
                            </div>
                        </div>

                        <!-- TAB 3: PELACAKAN STATUS & RIWAYAT -->
                        <div id="tab-history" class="tab-pane">
                            <div class="card">
                                <div class="card-title">
                                    <span>Pelacakan Status & Riwayat Instance (HistoryService)</span>
                                    <button class="btn btn-secondary" onclick="loadHistory()" style="padding: 6px 12px; font-size: 0.8rem;">
                                        &#8635; Refresh Riwayat
                                    </button>
                                </div>
                                <p style="color: var(--text-muted); font-size: 0.88rem; margin-bottom: 16px;">
                                    Menampilkan seluruh jejak audit proses pengajuan skripsi yang dicatat secara persisten oleh Camunda History Engine.
                                </p>
                                <div style="overflow-x: auto;">
                                    <table>
                                        <thead>
                                            <tr>
                                                <th>NIM</th>
                                                <th>Mahasiswa</th>
                                                <th>Judul Proposal</th>
                                                <th>Status Alur Kerja</th>
                                                <th>Catatan / Keterangan</th>
                                                <th>Nomor SK Pembimbing</th>
                                            </tr>
                                        </thead>
                                        <tbody id="historyTableBody">
                                            <tr><td colspan="6" style="text-align: center; color: var(--text-muted);">Memuat data riwayat...</td></tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>

                        <!-- TAB 4: DIAGRAM BPMN -->
                        <div id="tab-bpmn" class="tab-pane">
                            <div class="card">
                                <div class="card-title">Diagram Alur Proses BPMN 2.0 (proposal-skripsi.bpmn)</div>
                                <p style="color: var(--text-muted); font-size: 0.88rem; margin-bottom: 20px;">
                                    Proses ini dimodelkan sesuai standar OMG BPMN 2.0 dan dideploy secara otomatis oleh Camunda Spring Boot Starter ke dalam database H2.
                                </p>
                                
                                <div style="background: #0f172a; padding: 24px; border-radius: 14px; border: 1px solid var(--border); margin-bottom: 24px;">
                                    <div class="stepper">
                                        <div class="step-item active">
                                            <div class="step-dot" style="background: #10b981;">&#9679;</div>
                                            <span>1. Mahasiswa Mengajukan (Start Event)</span>
                                        </div>
                                        <div class="step-line"></div>
                                        <div class="step-item active">
                                            <div class="step-dot">2</div>
                                            <span>Verifikasi Sekretaris Prodi (User Task)</span>
                                        </div>
                                        <div class="step-line"></div>
                                        <div class="step-item active">
                                            <div class="step-dot">3</div>
                                            <span>Review Dosen Pembimbing (User Task)</span>
                                        </div>
                                        <div class="step-line"></div>
                                        <div class="step-item active">
                                            <div class="step-dot">4</div>
                                            <span>Persetujuan Ketua Prodi (User Task)</span>
                                        </div>
                                        <div class="step-line"></div>
                                        <div class="step-item active">
                                            <div class="step-dot" style="background: #ef4444;">&#9632;</div>
                                            <span>SK Terbit & Selesai (End Event)</span>
                                        </div>
                                    </div>
                                </div>

                                <h3 style="font-size: 1.1rem; margin-bottom: 12px;">Deskripsi Tanggung Jawab Peran:</h3>
                                <div style="display: grid; grid-template-columns: repeat(auto-fit, minmax(260px, 1fr)); gap: 14px;">
                                    <div style="background: var(--surface-card); padding: 16px; border-radius: 12px; border: 1px solid var(--border);">
                                        <h4 style="color: #93c5fd; margin-bottom: 6px;">1. Mahasiswa (Pelapor)</h4>
                                        <p style="font-size: 0.85rem; color: var(--text-muted);">
                                            Mengisi data proposal (judul, abstrak, usulan calon dosen pembimbing) dan memicu instance awal alur kerja.
                                        </p>
                                    </div>
                                    <div style="background: var(--surface-card); padding: 16px; border-radius: 12px; border: 1px solid var(--border);">
                                        <h4 style="color: #fcd34d; margin-bottom: 6px;">2. Sekretaris Program Studi</h4>
                                        <p style="font-size: 0.85rem; color: var(--text-muted);">
                                            Memeriksa kelayakan administratif, kesesuaian format proposal, dan ketiadaan duplikasi topik skripsi.
                                        </p>
                                    </div>
                                    <div style="background: var(--surface-card); padding: 16px; border-radius: 12px; border: 1px solid var(--border);">
                                        <h4 style="color: #6ee7b7; margin-bottom: 6px;">3. Dosen Calon Pembimbing</h4>
                                        <p style="font-size: 0.85rem; color: var(--text-muted);">
                                            Meninjau substansi keilmuan dan metodologi penelitian, serta mengonfirmasi kesediaan untuk membimbing.
                                        </p>
                                    </div>
                                    <div style="background: var(--surface-card); padding: 16px; border-radius: 12px; border: 1px solid var(--border);">
                                        <h4 style="color: #c084fc; margin-bottom: 6px;">4. Ketua Program Studi (Kaprodi)</h4>
                                        <p style="font-size: 0.85rem; color: var(--text-muted);">
                                            Memberikan persetujuan akhir (final approval) dan menerbitkan Surat Keputusan (SK) penetapan pembimbing secara formal.
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>

                    <div id="toast" class="toast">Notifikasi</div>

                    <script>
                        function showToast(msg) {
                            const t = document.getElementById('toast');
                            t.innerText = msg;
                            t.style.display = 'block';
                            setTimeout(() => { t.style.display = 'none'; }, 4000);
                        }

                        function switchTab(tabId) {
                            document.querySelectorAll('.tab-pane').forEach(el => el.classList.remove('active'));
                            document.querySelectorAll('.tab-btn').forEach(el => el.classList.remove('active'));
                            document.getElementById(tabId).classList.add('active');
                            event.currentTarget.classList.add('active');

                            if (tabId === 'tab-tasks') loadActiveTasks();
                            if (tabId === 'tab-history') loadHistory();
                        }

                        function autoFillDemo() {
                            document.getElementById('nama').value = 'Siti Dibaj Trikusuma';
                            document.getElementById('nim').value = '117';
                            document.getElementById('email').value = 'sitidibaj117@mhs.uinjkt.ac.id';
                            document.getElementById('judul').value = 'Rancang Bangun Sistem Alur Kerja BPMN untuk Pengajuan Proposal Skripsi Berbasis Spring Boot';
                            document.getElementById('pembimbing').value = 'Rizal Broer Bahaweres, S.Kom., M.Sc., Ph.D.';
                            document.getElementById('abstrak').value = 'Otomasi alur persetujuan skripsi multi-peran dengan integrasi Camunda BPMN engine dan arsitektur enterprise modern.';
                            showToast('Contoh data proposal otomatis terisi!');
                        }

                        async function refreshStats() {
                            try {
                                const res = await fetch('/api/proposals/history');
                                const history = await res.json();
                                const activeRes = await fetch('/api/proposals/active-tasks');
                                const activeTasks = await activeRes.json();

                                const total = history.length;
                                const completed = history.filter(h => h.selesai).length;
                                const pending = activeTasks.length;

                                document.getElementById('statTotal').innerText = total;
                                document.getElementById('statPending').innerText = pending;
                                document.getElementById('statCompleted').innerText = completed;
                                document.getElementById('taskBadgeCount').innerText = pending;
                            } catch(e) {
                                console.error(e);
                            }
                        }

                        async function handleProposalSubmit(e) {
                            e.preventDefault();
                            const btn = document.getElementById('btnSubmitProposal');
                            btn.disabled = true;
                            btn.innerText = 'Memproses ke BPMN Engine...';

                            const payload = {
                                nama: document.getElementById('nama').value,
                                nim: document.getElementById('nim').value,
                                email: document.getElementById('email').value,
                                bidang: document.getElementById('bidang').value,
                                pembimbing: document.getElementById('pembimbing').value,
                                judul: document.getElementById('judul').value,
                                abstrak: document.getElementById('abstrak').value
                            };

                            try {
                                const res = await fetch('/api/proposals/submit', {
                                    method: 'POST',
                                    headers: { 'Content-Type': 'application/json' },
                                    body: JSON.stringify(payload)
                                });
                                const data = await res.json();
                                showToast('Sukses! Instance BPMN terbentuk (ID: ' + data.processInstanceId + ')');
                                refreshStats();
                                setTimeout(() => {
                                    const tasksTabBtn = document.querySelectorAll('.tab-btn')[1];
                                    tasksTabBtn.click();
                                }, 1200);
                            } catch(err) {
                                alert('Gagal mengirim proposal: ' + err.message);
                            } finally {
                                btn.disabled = false;
                                btn.innerText = 'Mulai Instance BPMN & Ajukan \u2192';
                            }
                        }

                        async function loadActiveTasks() {
                            const container = document.getElementById('tasksContainer');
                            container.innerHTML = '<p style="color: var(--text-muted);">Memuat tugas aktif...</p>';

                            try {
                                const res = await fetch('/api/proposals/active-tasks');
                                const tasks = await res.json();

                                if (!tasks || tasks.length === 0) {
                                    container.innerHTML = `
                                        <div style="text-align: center; padding: 40px 20px; background: rgba(255,255,255,0.02); border-radius: 14px;">
                                            <p style="font-size: 1.1rem; color: #94a3b8; margin-bottom: 8px;">Tidak ada tugas yang menunggu verifikasi saat ini.</p>
                                            <p style="font-size: 0.86rem; color: #64748b;">Silakan ajukan proposal baru di tab "Ajukan Proposal" terlebih dahulu.</p>
                                        </div>
                                    `;
                                    refreshStats();
                                    return;
                                }

                                let html = '';
                                tasks.forEach(t => {
                                    let roleClass = 'role-sekprodi';
                                    let btnLabel = 'Setujui Kelayakan & Lanjutkan ke Dosen';
                                    let defaultNote = 'Berkas lengkap dan sesuai kriteria.';
                                    
                                    if (t.taskAssigneeRole.includes('Dosen')) {
                                        roleClass = 'role-dosen';
                                        btnLabel = 'Setujui & Bersedia Membimbing (Kirim ke Kaprodi)';
                                        defaultNote = 'Topik penelitian menarik dan disetujui untuk dibimbing.';
                                    } else if (t.taskAssigneeRole.includes('Ketua') || t.taskAssigneeRole.includes('Kaprodi')) {
                                        roleClass = 'role-kaprodi';
                                        btnLabel = 'Sahkan Proposal & Terbitkan SK Pembimbing';
                                        defaultNote = 'Disetujui. SK Pembimbing resmi diterbitkan.';
                                    }

                                    html += `
                                        <div class="task-card">
                                            <div class="task-header">
                                                <div>
                                                    <span class="role-badge ${roleClass}">${t.taskAssigneeRole}</span>
                                                    <h3 style="margin-top: 6px; font-size: 1.1rem; color: #fff;">${t.taskName}</h3>
                                                </div>
                                                <span style="font-size: 0.78rem; color: #94a3b8; background: rgba(255,255,255,0.05); padding: 4px 8px; border-radius: 6px;">
                                                    Task ID: ${t.taskId}
                                                </span>
                                            </div>
                                            <div class="task-body">
                                                <div><b style="color: #94a3b8;">Mahasiswa:</b><br>${t.namaMahasiswa} (${t.nim})</div>
                                                <div><b style="color: #94a3b8;">Bidang:</b><br>${t.bidangKajian}</div>
                                                <div><b style="color: #94a3b8;">Calon Pembimbing:</b><br>${t.calonPembimbing}</div>
                                                <div style="grid-column: 1 / -1;"><b style="color: #94a3b8;">Judul:</b><br>${t.judulProposal}</div>
                                            </div>
                                            <div style="margin-top: 6px;">
                                                <label style="font-size: 0.8rem; color: #94a3b8;">Catatan / Feedback Verifikator:</label>
                                                <input type="text" id="note-${t.taskId}" value="${defaultNote}" style="width: 100%; margin-top: 4px;">
                                            </div>
                                            <div class="btn-row" style="margin-top: 10px;">
                                                <button class="btn btn-success" onclick="processTask('${t.taskId}', '${t.taskAssigneeRole}')">
                                                    &#10003; ${btnLabel}
                                                </button>
                                            </div>
                                        </div>
                                    `;
                                });

                                container.innerHTML = html;
                                refreshStats();
                            } catch(err) {
                                container.innerHTML = '<p style="color: #f43f5e;">Gagal memuat tugas: ' + err.message + '</p>';
                            }
                        }

                        async function processTask(taskId, role) {
                            const noteInput = document.getElementById('note-' + taskId);
                            const catatan = noteInput ? noteInput.value : '';

                            try {
                                const res = await fetch('/api/proposals/process-task', {
                                    method: 'POST',
                                    headers: { 'Content-Type': 'application/json' },
                                    body: JSON.stringify({
                                        taskId: taskId,
                                        role: role,
                                        action: 'APPROVE',
                                        catatan: catatan
                                    })
                                });
                                const data = await res.json();
                                if (data.status === 'SUCCESS') {
                                    showToast('Tugas ' + data.completedTask + ' berhasil diproses! Lanjut ke: ' + data.nextTask);
                                    loadActiveTasks();
                                } else {
                                    alert('Gagal memproses tugas: ' + data.message);
                                }
                            } catch(e) {
                                alert('Error: ' + e.message);
                            }
                        }

                        async function loadHistory() {
                            const tbody = document.getElementById('historyTableBody');
                            tbody.innerHTML = '<tr><td colspan="6" style="text-align: center; color: var(--text-muted);">Memuat data riwayat...</td></tr>';

                            try {
                                const res = await fetch('/api/proposals/history');
                                const list = await res.json();

                                if (!list || list.length === 0) {
                                    tbody.innerHTML = '<tr><td colspan="6" style="text-align: center; color: var(--text-muted);">Belum ada riwayat proposal skripsi.</td></tr>';
                                    return;
                                }

                                let html = '';
                                list.forEach(item => {
                                    const statusBadge = item.selesai 
                                        ? '<span style="color: #34d399; font-weight: 700;">&#10003; Selesai (SK Terbit)</span>' 
                                        : '<span style="color: #fbbf24; font-weight: 600;">&#8635; ' + item.statusAlur + '</span>';
                                    
                                    const skBadge = item.nomorSk && item.nomorSk !== '-'
                                        ? '<span style="background: rgba(16,185,129,0.15); color: #6ee7b7; padding: 4px 8px; border-radius: 6px; font-weight: 700; font-family: monospace;">' + item.nomorSk + '</span>'
                                        : '<span style="color: #64748b;">Menunggu Approval Kaprodi</span>';

                                    let catatanDisplay = item.catatanKaprodi !== '-' ? 'Kaprodi: ' + item.catatanKaprodi :
                                                         item.catatanDosen !== '-' ? 'Dosen: ' + item.catatanDosen :
                                                         item.catatanSekretaris !== '-' ? 'Sekprodi: ' + item.catatanSekretaris : '-';

                                    html += `
                                        <tr>
                                            <td style="font-weight: 600; color: #a5b4fc;">${item.nim}</td>
                                            <td style="font-weight: 600;">${item.namaMahasiswa}</td>
                                            <td style="max-width: 320px;">${item.judulProposal}</td>
                                            <td>${statusBadge}</td>
                                            <td style="font-size: 0.82rem; color: #94a3b8;">${catatanDisplay}</td>
                                            <td>${skBadge}</td>
                                        </tr>
                                    `;
                                });

                                tbody.innerHTML = html;
                                refreshStats();
                            } catch(err) {
                                tbody.innerHTML = '<tr><td colspan="6" style="text-align: center; color: #f43f5e;">Gagal memuat: ' + err.message + '</td></tr>';
                            }
                        }

                        // Inisialisasi awal
                        refreshStats();
                    </script>
                </body>
                </html>
                """;
    }
}