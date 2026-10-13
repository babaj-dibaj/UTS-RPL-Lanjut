package com.uts.rpllanjut;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    // ==============================================================
    // 1. BERANDA / PORTAL UTAMA UTS
    // ==============================================================
    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String halamanUtama() {
        return """
                <!DOCTYPE html>
                <html lang="id">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>UTS Rekayasa Perangkat Lunak Lanjut - Siti Dibaj Trikusuma (117)</title>
                    <style>
                        :root {
                            color-scheme: dark;
                            --bg: #090d16;
                            --surface: #111726;
                            --surface-card: #172033;
                            --border: rgba(255, 255, 255, 0.12);
                            --primary: #6366f1;
                            --primary-hover: #4f46e5;
                            --primary-glow: rgba(99, 102, 241, 0.4);
                            --accent: #06b6d4;
                            --accent-green: #10b981;
                            --text: #f8fafc;
                            --text-muted: #94a3b8;
                            --font: 'Inter', system-ui, -apple-system, sans-serif;
                        }
                        * { box-sizing: border-box; margin: 0; padding: 0; }
                        body {
                            background: radial-gradient(circle at 15% 15%, rgba(99, 102, 241, 0.22) 0, transparent 40%),
                                        radial-gradient(circle at 85% 85%, rgba(6, 182, 212, 0.18) 0, transparent 40%),
                                        var(--bg);
                            font-family: var(--font);
                            color: var(--text);
                            min-height: 100vh;
                            line-height: 1.6;
                            padding: 40px 20px;
                            display: flex;
                            flex-direction: column;
                            align-items: center;
                        }
                        .container {
                            width: min(100%, 1050px);
                        }
                        .hero-card {
                            background: linear-gradient(145deg, rgba(23, 32, 51, 0.95), rgba(17, 23, 38, 0.95));
                            border: 1px solid var(--border);
                            border-radius: 28px;
                            padding: clamp(28px, 5vw, 48px);
                            box-shadow: 0 25px 70px rgba(0, 0, 0, 0.5), inset 0 1px 0 rgba(255, 255, 255, 0.1);
                            backdrop-filter: blur(20px);
                            margin-bottom: 28px;
                            position: relative;
                            overflow: hidden;
                        }
                        .hero-card::after {
                            content: '';
                            position: absolute;
                            top: -120px;
                            right: -100px;
                            width: 320px;
                            height: 320px;
                            background: linear-gradient(135deg, #6366f1, #06b6d4);
                            border-radius: 50%;
                            opacity: 0.18;
                            filter: blur(50px);
                            pointer-events: none;
                        }
                        .header-row {
                            display: flex;
                            justify-content: space-between;
                            align-items: flex-start;
                            gap: 20px;
                            flex-wrap: wrap;
                        }
                        .badge {
                            background: rgba(99, 102, 241, 0.18);
                            border: 1px solid rgba(99, 102, 241, 0.35);
                            color: #c7d2fe;
                            padding: 6px 14px;
                            border-radius: 999px;
                            font-size: 0.78rem;
                            font-weight: 700;
                            letter-spacing: 0.08em;
                            text-transform: uppercase;
                            display: inline-block;
                            margin-bottom: 12px;
                        }
                        h1 {
                            font-size: clamp(2rem, 5vw, 2.8rem);
                            font-weight: 800;
                            letter-spacing: -0.04em;
                            line-height: 1.15;
                            margin-bottom: 8px;
                        }
                        .sub-title {
                            color: var(--text-muted);
                            font-size: 1.05rem;
                            max-width: 680px;
                            margin-bottom: 24px;
                        }
                        .profile-grid {
                            display: grid;
                            grid-template-columns: repeat(auto-fit, minmax(200px, 1fr));
                            gap: 14px;
                            margin-bottom: 28px;
                        }
                        .profile-item {
                            background: rgba(255, 255, 255, 0.04);
                            border: 1px solid rgba(255, 255, 255, 0.06);
                            border-radius: 16px;
                            padding: 14px 18px;
                        }
                        .profile-label {
                            font-size: 0.78rem;
                            font-weight: 600;
                            color: #94a3b8;
                            text-transform: uppercase;
                            letter-spacing: 0.05em;
                        }
                        .profile-val {
                            font-size: 1.02rem;
                            font-weight: 700;
                            color: #f1f5f9;
                            margin-top: 4px;
                        }
                        .engine-status-box {
                            background: rgba(16, 185, 129, 0.08);
                            border: 1px solid rgba(16, 185, 129, 0.25);
                            border-radius: 16px;
                            padding: 14px 20px;
                            display: flex;
                            align-items: center;
                            justify-content: space-between;
                            flex-wrap: wrap;
                            gap: 12px;
                            margin-bottom: 28px;
                        }
                        .engine-dot {
                            width: 10px;
                            height: 10px;
                            background: #10b981;
                            border-radius: 50%;
                            box-shadow: 0 0 10px #10b981;
                            display: inline-block;
                            margin-right: 8px;
                        }
                        .grid-modules {
                            display: grid;
                            grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
                            gap: 18px;
                        }
                        .mod-card {
                            background: var(--surface);
                            border: 1px solid var(--border);
                            border-radius: 20px;
                            padding: 24px;
                            display: flex;
                            flex-direction: column;
                            justify-content: space-between;
                            transition: transform 0.25s ease, border-color 0.25s ease, box-shadow 0.25s ease;
                            text-decoration: none;
                            color: inherit;
                        }
                        .mod-card:hover {
                            transform: translateY(-4px);
                            border-color: rgba(99, 102, 241, 0.5);
                            box-shadow: 0 16px 36px rgba(0, 0, 0, 0.4);
                        }
                        .mod-tag {
                            font-size: 0.75rem;
                            font-weight: 700;
                            text-transform: uppercase;
                            letter-spacing: 0.06em;
                            padding: 4px 10px;
                            border-radius: 999px;
                            display: inline-block;
                            margin-bottom: 12px;
                            width: fit-content;
                        }
                        .tag-1 { background: rgba(59, 130, 246, 0.2); color: #93c5fd; }
                        .tag-2 { background: rgba(16, 185, 129, 0.2); color: #6ee7b7; }
                        .tag-3 { background: rgba(245, 158, 11, 0.2); color: #fcd34d; }
                        .tag-4 { background: rgba(236, 72, 153, 0.2); color: #f472b6; }
                        .mod-title {
                            font-size: 1.2rem;
                            font-weight: 700;
                            margin-bottom: 8px;
                            color: #fff;
                        }
                        .mod-desc {
                            color: var(--text-muted);
                            font-size: 0.88rem;
                            margin-bottom: 18px;
                            flex-grow: 1;
                        }
                        .mod-btn {
                            display: inline-flex;
                            align-items: center;
                            gap: 8px;
                            font-size: 0.88rem;
                            font-weight: 700;
                            color: #a5b4fc;
                        }
                        .mod-card:hover .mod-btn {
                            color: #fff;
                        }
                        footer {
                            margin-top: 40px;
                            text-align: center;
                            color: var(--text-muted);
                            font-size: 0.82rem;
                        }
                    </style>
                </head>
                <body>
                    <div class="container">
                        <main class="hero-card">
                            <div class="header-row">
                                <div>
                                    <span class="badge">Ujian Tengah Semester (UTS)</span>
                                    <h1>Rekayasa Perangkat Lunak Lanjut</h1>
                                </div>
                                <div style="display: flex; gap: 8px;">
                                    <span style="background: rgba(255,255,255,0.06); padding: 6px 12px; border-radius: 12px; font-size: 0.85rem; font-weight: 600;">
                                        T.A. 2024/2025
                                    </span>
                                </div>
                            </div>

                            <p class="sub-title">
                                Implementasi Pemodelan Alur Kerja Bisnis (BPM) dengan Notasi BPMN 2.0 dan Eksekusi Terintegrasi Framework Spring Boot 3 serta Camunda Engine.
                            </p>

                            <div class="profile-grid">
                                <div class="profile-item">
                                    <div class="profile-label">Mahasiswa</div>
                                    <div class="profile-val">Siti Dibaj Trikusuma</div>
                                </div>
                                <div class="profile-item">
                                    <div class="profile-label">NIM</div>
                                    <div class="profile-val">117</div>
                                </div>
                                <div class="profile-item">
                                    <div class="profile-label">Program Studi</div>
                                    <div class="profile-val">Teknik Informatika</div>
                                </div>
                                <div class="profile-item">
                                    <div class="profile-label">Dosen Pengampu</div>
                                    <div class="profile-val">Rizal Broer Bahaweres, S.Kom., M.Sc., Ph.D.</div>
                                </div>
                            </div>

                            <div class="engine-status-box">
                                <div>
                                    <span class="engine-dot"></span>
                                    <strong style="color: #6ee7b7;">BPM Engine Aktif:</strong>
                                    <span style="font-size: 0.9rem; color: #cbd5e1; margin-left: 6px;">Camunda Platform 7.20.0 + H2 Database In-Memory</span>
                                </div>
                                <div style="display: flex; gap: 10px;">
                                    <a href="/h2-console" target="_blank" style="color: #a5b4fc; font-size: 0.85rem; font-weight: 600; text-decoration: none;">&bull; H2 Console &rarr;</a>
                                    <a href="/camunda/app/" target="_blank" style="color: #a5b4fc; font-size: 0.85rem; font-weight: 600; text-decoration: none;">&bull; Camunda Webapp &rarr;</a>
                                </div>
                            </div>

                            <h2 style="font-size: 1.25rem; font-weight: 700; margin-bottom: 16px;">Modul Pengerjaan Soal UTS:</h2>

                            <div class="grid-modules">
                                <!-- Modul 3: Studi Kasus (Bobot 50%) -->
                                <a href="/studi-kasus" class="mod-card" style="border-color: rgba(99, 102, 241, 0.4);">
                                    <span class="mod-tag tag-3">Soal No. 3 &bull; Bobot 50%</span>
                                    <div class="mod-title">Studi Kasus: Workflow Proposal Skripsi</div>
                                    <p class="mod-desc">
                                        Simulasi live pengajuan proposal skripsi mahasiswa TI UIN Jakarta, verifikasi berkas Sekprodi, review Dosen Pembimbing, dan persetujuan SK Ketua Prodi.
                                    </p>
                                    <div class="mod-btn">Buka Aplikasi Studi Kasus &rarr;</div>
                                </a>

                                <!-- Modul 2: Hello World BPMN (Bobot 10%) -->
                                <a href="/hello-world" class="mod-card">
                                    <span class="mod-tag tag-2">Soal No. 2 &bull; Bobot 10%</span>
                                    <div class="mod-title">Pengujian Hello World BPMN</div>
                                    <p class="mod-desc">
                                        Pengujian instalasi dan konfigurasi Camunda Engine dengan Spring Boot melalui pemicuan proses BPMN Hello World interaktif.
                                    </p>
                                    <div class="mod-btn">Jalankan Uji Hello World &rarr;</div>
                                </a>

                                <!-- Modul 1: Teori 5W & BPMN (Bobot 10%) -->
                                <a href="/teori-5w" class="mod-card">
                                    <span class="mod-tag tag-1">Soal No. 1 &bull; Bobot 10%</span>
                                    <div class="mod-title">Penjelasan 5W & Keterkaitan BPMN</div>
                                    <p class="mod-desc">
                                        Uraian What, Why, Who, Where, When tentang Spring Boot & BPM/BPMN serta analisis manfaat BPM dalam pengembangan J2EE/Jakarta EE dengan Prinsip ABC.
                                    </p>
                                    <div class="mod-btn">Baca Teori & Kajian &rarr;</div>
                                </a>

                                <!-- Modul 4 & 5 & 6: Dokumentasi & GitHub (Bobot 30%) -->
                                <a href="/dokumentasi" class="mod-card">
                                    <span class="mod-tag tag-4">Soal No. 4, 5, 6 &bull; Bobot 30%</span>
                                    <div class="mod-title">Dokumentasi, Bukti & GitHub</div>
                                    <p class="mod-desc">
                                        Struktur laporan berprinsip ABC, panduan tangkapan layar (print screen), skrip rekaman video demo, dan tautan repositori GitHub untuk Pak Broer.
                                    </p>
                                    <div class="mod-btn">Lihat Panduan & Bukti &rarr;</div>
                                </a>
                            </div>
                        </main>

                        <footer>
                            &copy; 2026 Siti Dibaj Trikusuma (117) &bull; UIN Syarif Hidayatullah Jakarta &bull; Dosen: Rizal Broer Bahaweres, S.Kom., M.Sc., Ph.D.
                        </footer>
                    </div>
                </body>
                </html>
                """;
    }

    // ==============================================================
    // 2. MODUL HELLO WORLD BPMN (SOAL NO. 2)
    // ==============================================================
    @GetMapping(value = "/hello-world", produces = MediaType.TEXT_HTML_VALUE)
    public String halamanHelloWorld() {
        return """
                <!DOCTYPE html>
                <html lang="id">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Hello World BPMN - Pengujian Instalasi & Konfigurasi</title>
                    <style>
                        :root {
                            color-scheme: dark;
                            --bg: #0a0e1a;
                            --surface: #121829;
                            --surface-card: #182238;
                            --border: rgba(255, 255, 255, 0.12);
                            --primary: #10b981;
                            --primary-glow: rgba(16, 185, 129, 0.35);
                            --accent: #6366f1;
                            --text: #f8fafc;
                            --text-muted: #94a3b8;
                            --font: 'Inter', system-ui, -apple-system, sans-serif;
                        }
                        * { box-sizing: border-box; margin: 0; padding: 0; }
                        body {
                            background: radial-gradient(circle at 10% 10%, rgba(16, 185, 129, 0.12) 0, transparent 35%),
                                        radial-gradient(circle at 90% 90%, rgba(99, 102, 241, 0.15) 0, transparent 35%),
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
                            font-weight: 700;
                            text-decoration: none;
                            color: var(--text);
                        }
                        .nav-links { display: flex; gap: 16px; align-items: center; }
                        .nav-link { color: var(--text-muted); text-decoration: none; font-size: 0.9rem; font-weight: 500; }
                        .nav-link:hover, .nav-link.active { color: var(--text); }
                        .container { max-width: 960px; margin: 32px auto 0; padding: 0 20px; }
                        .card {
                            background: var(--surface);
                            border: 1px solid var(--border);
                            border-radius: 20px;
                            padding: 28px;
                            margin-bottom: 24px;
                            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.3);
                        }
                        h1 { font-size: 2.2rem; margin-bottom: 8px; }
                        .btn {
                            background: linear-gradient(135deg, #10b981, #059669);
                            color: #fff;
                            border: none;
                            border-radius: 12px;
                            padding: 12px 24px;
                            font-weight: 700;
                            cursor: pointer;
                            display: inline-flex;
                            align-items: center;
                            gap: 8px;
                            transition: transform 0.2s, box-shadow 0.2s;
                        }
                        .btn:hover {
                            transform: translateY(-2px);
                            box-shadow: 0 8px 24px var(--primary-glow);
                        }
                        .console-box {
                            background: #020617;
                            border: 1px solid rgba(255, 255, 255, 0.1);
                            border-radius: 14px;
                            padding: 18px;
                            font-family: 'Consolas', 'Courier New', monospace;
                            font-size: 0.88rem;
                            color: #38bdf8;
                            min-height: 140px;
                            overflow-y: auto;
                            margin-top: 14px;
                            white-space: pre-wrap;
                        }
                        .task-item {
                            background: var(--surface-card);
                            border: 1px solid var(--border);
                            border-radius: 12px;
                            padding: 16px;
                            margin-top: 12px;
                            display: flex;
                            align-items: center;
                            justify-content: space-between;
                            flex-wrap: wrap;
                            gap: 12px;
                        }
                    </style>
                </head>
                <body>
                    <nav>
                        <a href="/" class="nav-brand">UTS RPL Lanjut &bull; Siti Dibaj (117)</a>
                        <div class="nav-links">
                            <a href="/" class="nav-link">&larr; Beranda</a>
                            <a href="/hello-world" class="nav-link active">Hello World BPMN</a>
                            <a href="/studi-kasus" class="nav-link">Studi Kasus</a>
                            <a href="/teori-5w" class="nav-link">Teori 5W</a>
                            <a href="/dokumentasi" class="nav-link">Dokumentasi</a>
                        </div>
                    </nav>

                    <div class="container">
                        <div style="margin-bottom: 24px;">
                            <span style="background: rgba(16, 185, 129, 0.15); border: 1px solid rgba(16,185,129,0.3); color: #6ee7b7; padding: 4px 12px; border-radius: 999px; font-size: 0.8rem; font-weight: 700;">
                                Soal Nomor 2 (Bobot 10%)
                            </span>
                            <h1 style="margin-top: 10px;">Pengujian Hello World BPMN</h1>
                            <p style="color: var(--text-muted);">
                                Modul ini membuktikan bahwa Camunda Process Engine 7.20 telah berhasil diinstal, dikonfigurasikan dengan Spring Boot 3 & database H2, serta mampu mengeksekusi file definisi proses BPMN (<code>hello-world.bpmn</code>) dari awal hingga akhir.
                            </p>
                        </div>

                        <div class="card">
                            <h2 style="font-size: 1.25rem; margin-bottom: 8px;">1. Trigger Instance Hello World BPMN</h2>
                            <p style="color: var(--text-muted); font-size: 0.9rem; margin-bottom: 16px;">
                                Klik tombol di bawah untuk memicu pemanggilan <code>runtimeService.startProcessInstanceByKey("hello-world-process")</code>.
                            </p>
                            <div style="display: flex; gap: 12px; align-items: center; flex-wrap: wrap;">
                                <input type="text" id="pengujiName" value="Siti Dibaj Trikusuma (117)" style="background: var(--surface-card); border: 1px solid var(--border); padding: 10px 14px; border-radius: 10px; color: #fff; width: 280px;">
                                <button class="btn" onclick="startHello()">
                                    &#9658; Jalankan Hello World BPMN
                                </button>
                            </div>

                            <div class="console-box" id="consoleLog">Status Console: Menunggu trigger pengujian...</div>
                        </div>

                        <div class="card">
                            <div style="display: flex; justify-content: space-between; align-items: center;">
                                <h2 style="font-size: 1.25rem;">2. Daftar Tugas Aktif (TaskService)</h2>
                                <button onclick="loadHelloTasks()" style="background: rgba(255,255,255,0.06); border: 1px solid var(--border); color: #fff; padding: 6px 12px; border-radius: 8px; cursor: pointer;">&#8635; Refresh Task</button>
                            </div>
                            <p style="color: var(--text-muted); font-size: 0.9rem; margin-top: 4px;">
                                Task yang saat ini sedang menunggu penyelesaian pada proses Hello World:
                            </p>
                            <div id="tasksList">Memuat task...</div>
                        </div>
                    </div>

                    <script>
                        async function startHello() {
                            const penguji = document.getElementById('pengujiName').value;
                            const log = document.getElementById('consoleLog');
                            log.innerText = 'Mengirim perintah startProcessInstanceByKey ke Camunda Engine...';

                            try {
                                const res = await fetch('/api/hello-world/start', {
                                    method: 'POST',
                                    headers: { 'Content-Type': 'application/json' },
                                    body: JSON.stringify({ triggeredBy: penguji })
                                });
                                const data = await res.json();
                                log.innerText = `[SUCCESS] Instance BPMN Berhasil Dimulai!\\n` +
                                                `- Process Instance ID: ${data.processInstanceId}\\n` +
                                                `- Process Definition: ${data.processDefinitionId}\\n` +
                                                `- Active Task ID: ${data.activeTaskId || '-'}\\n` +
                                                `- Task Name: ${data.activeTaskName || '-'}\\n` +
                                                `- Waktu Eksekusi: ${data.startTime}`;
                                loadHelloTasks();
                            } catch(e) {
                                log.innerText = '[ERROR] Gagal memulai instance: ' + e.message;
                            }
                        }

                        async function loadHelloTasks() {
                            const list = document.getElementById('tasksList');
                            try {
                                const res = await fetch('/api/hello-world/tasks');
                                const tasks = await res.json();
                                if (!tasks || tasks.length === 0) {
                                    list.innerHTML = '<p style="color: #64748b; margin-top: 10px;">Tidak ada task Hello World yang tertunda. Semua alur telah selesai dieksekusi.</p>';
                                    return;
                                }
                                let html = '';
                                tasks.forEach(t => {
                                    html += `
                                        <div class="task-item">
                                            <div>
                                                <strong style="color: #6ee7b7;">${t.taskName}</strong><br>
                                                <span style="font-size: 0.8rem; color: #94a3b8;">Task ID: ${t.taskId} | Penguji: ${t.penguji} | Waktu: ${t.waktuMulai}</span>
                                            </div>
                                            <button onclick="completeHello('${t.taskId}')" style="background: #10b981; color: #fff; border: none; padding: 8px 16px; border-radius: 8px; font-weight: 700; cursor: pointer;">
                                                &#10003; Selesaikan Task
                                            </button>
                                        </div>
                                    `;
                                });
                                list.innerHTML = html;
                            } catch(e) {
                                list.innerHTML = '<p style="color: #f43f5e;">Gagal memuat task: ' + e.message + '</p>';
                            }
                        }

                        async function completeHello(taskId) {
                            const log = document.getElementById('consoleLog');
                            try {
                                const res = await fetch('/api/hello-world/complete', {
                                    method: 'POST',
                                    headers: { 'Content-Type': 'application/json' },
                                    body: JSON.stringify({ taskId: taskId })
                                });
                                const data = await res.json();
                                log.innerText += `\\n[COMPLETED] Task ID ${taskId} telah diselesaikan! Token BPMN mencapai End Event.`;
                                loadHelloTasks();
                            } catch(e) {
                                alert('Error: ' + e.message);
                            }
                        }

                        // Load task awal
                        loadHelloTasks();
                    </script>
                </body>
                </html>
                """;
    }

    // ==============================================================
    // 3. TEORI 5W & KETERKAITAN BPMN (SOAL NO. 1 & 5 - PRINSIP ABC)
    // ==============================================================
    @GetMapping(value = "/teori-5w", produces = MediaType.TEXT_HTML_VALUE)
    public String halamanTeori5W() {
        return """
                <!DOCTYPE html>
                <html lang="id">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Teori 5W & Keterkaitan BPMN - Siti Dibaj Trikusuma (117)</title>
                    <style>
                        :root {
                            color-scheme: dark;
                            --bg: #090d16;
                            --surface: #121829;
                            --surface-card: #182238;
                            --border: rgba(255, 255, 255, 0.12);
                            --primary: #6366f1;
                            --accent: #38bdf8;
                            --text: #f8fafc;
                            --text-muted: #94a3b8;
                            --font: 'Inter', system-ui, -apple-system, sans-serif;
                        }
                        * { box-sizing: border-box; margin: 0; padding: 0; }
                        body {
                            background: radial-gradient(circle at 10% 10%, rgba(99, 102, 241, 0.12) 0, transparent 35%),
                                        var(--bg);
                            font-family: var(--font);
                            color: var(--text);
                            line-height: 1.7;
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
                        .nav-brand { font-weight: 700; text-decoration: none; color: var(--text); }
                        .nav-links { display: flex; gap: 16px; align-items: center; }
                        .nav-link { color: var(--text-muted); text-decoration: none; font-size: 0.9rem; font-weight: 500; }
                        .nav-link:hover, .nav-link.active { color: var(--text); }
                        .container { max-width: 960px; margin: 32px auto 0; padding: 0 20px; }
                        .card {
                            background: var(--surface);
                            border: 1px solid var(--border);
                            border-radius: 20px;
                            padding: 32px;
                            margin-bottom: 24px;
                            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.25);
                        }
                        h1 { font-size: 2.2rem; margin-bottom: 8px; }
                        h2 { font-size: 1.4rem; color: #a5b4fc; margin: 24px 0 12px; border-bottom: 1px solid var(--border); padding-bottom: 8px; }
                        h3 { font-size: 1.15rem; color: #38bdf8; margin: 16px 0 8px; }
                        p { margin-bottom: 12px; color: #cbd5e1; font-size: 0.96rem; }
                        ul, ol { margin: 8px 0 16px 24px; color: #cbd5e1; font-size: 0.95rem; }
                        li { margin-bottom: 6px; }
                        .highlight-box {
                            background: rgba(99, 102, 241, 0.08);
                            border-left: 4px solid var(--primary);
                            padding: 16px 20px;
                            border-radius: 0 12px 12px 0;
                            margin: 16px 0;
                        }
                        table {
                            width: 100%;
                            border-collapse: collapse;
                            margin: 16px 0;
                            font-size: 0.9rem;
                        }
                        th, td {
                            padding: 12px 16px;
                            border: 1px solid var(--border);
                            text-align: left;
                        }
                        th { background: rgba(255, 255, 255, 0.05); color: #fff; }
                    </style>
                </head>
                <body>
                    <nav>
                        <a href="/" class="nav-brand">UTS RPL Lanjut &bull; Siti Dibaj (117)</a>
                        <div class="nav-links">
                            <a href="/" class="nav-link">&larr; Beranda</a>
                            <a href="/hello-world" class="nav-link">Hello World BPMN</a>
                            <a href="/studi-kasus" class="nav-link">Studi Kasus</a>
                            <a href="/teori-5w" class="nav-link active">Teori 5W</a>
                            <a href="/dokumentasi" class="nav-link">Dokumentasi</a>
                        </div>
                    </nav>

                    <div class="container">
                        <div style="margin-bottom: 24px;">
                            <span style="background: rgba(99, 102, 241, 0.15); border: 1px solid rgba(99,102,241,0.3); color: #c7d2fe; padding: 4px 12px; border-radius: 999px; font-size: 0.8rem; font-weight: 700;">
                                Soal Nomor 1 & 5 (Bobot 10% + 7.5% Prinsip ABC)
                            </span>
                            <h1 style="margin-top: 10px;">Analisis 5W: Spring Boot, BPM/BPMN, dan Integrasi J2EE</h1>
                            <p style="color: var(--text-muted);">
                                Disusun dengan menerapkan <strong>Prinsip ABC</strong> (<em>Accuracy, Brevity, Clarity</em>) untuk menyajikan penjelasan yang akurat secara teknis, ringkas dan padat, serta memiliki alur pemikiran yang logis dan mudah dipahami.
                            </p>
                        </div>

                        <div class="card">
                            <h2>1. Penerapan Prinsip ABC dalam Tulisan Ini</h2>
                            <p>
                                Dalam komunikasi teknis rekayasa perangkat lunak, prinsip <strong>ABC</strong> memastikan dokumen memiliki bobot ilmiah tinggi tanpa bertele-tele:
                            </p>
                            <ul>
                                <li><strong>Accuracy (Akurat):</strong> Setiap definisi dan terminologi teknis disesuaikan dengan standar industri (spesifikasi OMG BPMN 2.0, standar Jakarta EE/J2EE, dan arsitektur Spring Boot).</li>
                                <li><strong>Brevity (Ringkas & Padat):</strong> Menghindari repetisi kata dan pembahasan yang meluas di luar konteks, berfokus langsung pada esensi 5W serta relevansi praktisnya.</li>
                                <li><strong>Clarity (Jelas & Runtut):</strong> Disusun dengan struktur hierarkis, pemisahan tabel perbandingan, dan pointer logis sehingga pembaca dapat segera menangkap keterkaitan antarkomponen sistem.</li>
                            </ul>

                            <h2>2. Analisis 5W Framework Spring / Spring Boot</h2>
                            <table>
                                <thead>
                                    <tr>
                                        <th style="width: 15%;">Aspek 5W</th>
                                        <th>Uraian Konsep & Konteks Rekayasa Perangkat Lunak</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><strong>What</strong><br>(Apa)</td>
                                        <td><strong>Spring Boot</strong> adalah kerangka kerja (framework) berbasis Java open-source tingkat enterprise yang menyederhanakan inisialisasi dan pengembangan aplikasi Spring konvensional melalui pendekatan <em>opinionated configuration</em>, fitur <em>auto-configuration</em>, dan <em>embedded servlet container</em> (Tomcat/Jetty).</td>
                                    </tr>
                                    <tr>
                                        <td><strong>Why</strong><br>(Mengapa)</td>
                                        <td>Mengatasi kompleksitas konfigurasi XML dan boilerplate code yang rumit pada era Java EE tradisional. Spring Boot mempercepat waktu <em>time-to-market</em>, mempermudah pembuatan microservices mandiri berkinerja tinggi, serta menjamin pengelolaan dependency yang stabil lewat mekanisme <em>Starter Dependencies</em>.</td>
                                    </tr>
                                    <tr>
                                        <td><strong>Who</strong><br>(Siapa)</td>
                                        <td>Awalnya dirancang oleh Rod Johnson (2002) dan kini dikembangkan serta dipelihara secara aktif oleh <strong>VMware Tanzu (Broadcom)</strong> bersama komunitas open-source global, digunakan oleh para software engineer dan arsitek enterprise di seluruh dunia.</td>
                                    </tr>
                                    <tr>
                                        <td><strong>Where</strong><br>(Di mana)</td>
                                        <td>Diterapkan di berbagai arsitektur perangkat lunak modern: mulai dari sistem monolitik modular, layanan RESTful API, arsitektur Microservices berbasis cloud, komputasi serverless, hingga core banking dan sistem informasi akademik universitas.</td>
                                    </tr>
                                    <tr>
                                        <td><strong>When</strong><br>(Kapan)</td>
                                        <td>Tepat digunakan ketika organisasi membutuhkan aplikasi backend berbasis Java yang cepat dibangun, mudah diuji (unit & integration testing), mudah dideploy (menjadi executable JAR mandiri), serta memiliki ekosistem siap pakai untuk keamanan (Spring Security) dan data (Spring Data).</td>
                                    </tr>
                                </tbody>
                            </table>

                            <h2>3. Analisis 5W BPM (Business Process Management) & BPMN</h2>
                            <table>
                                <thead>
                                    <tr>
                                        <th style="width: 15%;">Aspek 5W</th>
                                        <th>Uraian Konsep & Konteks Rekayasa Perangkat Lunak</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td><strong>What</strong><br>(Apa)</td>
                                        <td><strong>BPM</strong> adalah metodologi disiplin ilmu manajemen operasional untuk memodelkan, mengotomatisasi, mengeksekusi, dan mengoptimalkan proses bisnis. Sedangkan <strong>BPMN</strong> (<em>Business Process Model and Notation</em>) adalah notasi grafis standar global (versi 2.0) yang ditetapkan oleh <strong>Object Management Group (OMG)</strong> untuk memvisualisasikan alur proses dalam format diagram dan file XML yang dapat langsung dieksekusi oleh workflow engine.</td>
                                    </tr>
                                    <tr>
                                        <td><strong>Why</strong><br>(Mengapa)</td>
                                        <td>Untuk menjembatani jurang komunikasi (<em>communication gap</em>) antara pemangku kepentingan non-teknis (analis bisnis, manajemen) dengan pengembang perangkat lunak teknis. Tanpa BPMN, logika alur kerja seringkali tertanam kaku (<em>hard-coded</em>) di dalam kode program sehingga sangat sulit diubah saat kebijakan operasional diperbarui.</td>
                                    </tr>
                                    <tr>
                                        <td><strong>Who</strong><br>(Siapa)</td>
                                        <td>Diciptakan dan distandarisasi oleh <strong>OMG (Object Management Group)</strong>, dioperasikan oleh Business Analyst bersama Software Engineer, serta dieksekusi oleh Workflow Engine terkemuka seperti <strong>Camunda, Flowable, dan Activiti</strong>.</td>
                                    </tr>
                                    <tr>
                                        <td><strong>Where</strong><br>(Di mana)</td>
                                        <td>Diterapkan pada proses bisnis multi-langkah (multi-step) dan multi-peran (multi-role) yang melibatkan koordinasi antarmanusia (Human Tasks) dan integrasi antarsistem (Service Tasks), seperti perizinan akademik, persetujuan kredit perbankan, dan pengadaan barang/jasa.</td>
                                    </tr>
                                    <tr>
                                        <td><strong>When</strong><br>(Kapan)</td>
                                        <td>Digunakan ketika aplikasi memiliki alur kerja yang melibatkan siklus persetujuan berjenjang, status penugasan yang berubah-ubah seiring waktu (asynchronous), atau kebutuhan audit jejak rekam (audit trail) secara transparan.</td>
                                    </tr>
                                </tbody>
                            </table>

                            <h2>4. Keterkaitan Antara Spring Boot dan BPMN</h2>
                            <div class="highlight-box">
                                <p style="margin: 0; color: #e2e8f0;">
                                    <strong>Sinergi Sempurna:</strong> BPMN menyediakan <em>arsitektur alur logika (orchestration layer)</em>, sedangkan Spring Boot bertindak sebagai <em>lapisan eksekusi teknis (execution & integration layer)</em>. 
                                </p>
                            </div>
                            <p>Keterkaitan erat keduanya termanifestasi dalam 3 aspek fundamental:</p>
                            <ol>
                                <li><strong>Java Delegate & Spring Beans Injection:</strong> Node Service Task di BPMN dapat memanggil Spring Bean secara native menggunakan ekspresi delegate (misalnya <code>#{notifikasiEmailService}</code>), memungkinkan integrasi data yang elegan dan teruji.</li>
                                <li><strong>Manajemen Transaksi Terpadu:</strong> Camunda Engine menggunakan <code>PlatformTransactionManager</code> milik Spring Boot, sehingga operasi basis data aplikasi dan state peralihan proses alur kerja berada dalam satu siklus transaksi ACID yang aman.</li>
                                <li><strong>Kemudahan Pengujian & Deployment:</strong> File diagram <code>.bpmn</code> ditempatkan di <code>src/main/resources/processes/</code> dan dideploy secara otomatis saat aplikasi Spring Boot booting tanpa konfigurasi server terpisah.</li>
                            </ol>

                            <h2>5. Manfaat Spesifik BPM dalam Pengembangan J2EE / Jakarta EE</h2>
                            <p>
                                Dalam pengembangan perangkat lunak berbasis J2EE / Jakarta EE, integrasi BPM memberikan keunggulan kompetitif yang signifikan:
                            </p>
                            <ul>
                                <li><strong>Pemisahan Alur Bisnis dari Logika Teknis (Separation of Concerns):</strong> Logika operasional (siapa menyetujui apa dan kapan) tidak lagi bercampur aduk dengan kode koneksi database atau servlet. Perubahan alur birokrasi cukup dilakukan pada file diagram BPMN tanpa merombak arsitektur inti program.</li>
                                <li><strong>Audit Trail dan Riwayat Otomatis:</strong> Camunda History Engine mencatat secara rinci siapa yang mengeksekusi tugas, kapan tugas selesai, variabel apa yang diubah, dan berapa lama durasi setiap tahap. Fitur ini krusial untuk standar tata kelola enterprise J2EE.</li>
                                <li><strong>Penanganan Asynchronous & Long-Running Process:</strong> Alur persetujuan skripsi memerlukan waktu berhari-hari (menunggu respon manusia). Engine BPMN mengelola status penugasan secara persisten ke database tanpa membebani memori server atau mempertahankan koneksi HTTP secara terus-menerus.</li>
                                <li><strong>Visibilitas Real-Time Operasional:</strong> Melalui dashboard Camunda Cockpit, administrator sistem dan pemangku kepentingan dapat melihat visualisasi diagram dengan indikator berapa banyak berkas yang sedang antre pada masing-masing tahapan.</li>
                            </ul>
                        </div>
                    </div>
                </body>
                </html>
                """;
    }

    // ==============================================================
    // 4. DOKUMENTASI, BUKTI PENGUJIAN & GITHUB (SOAL NO. 4, 5, 6)
    // ==============================================================
    @GetMapping(value = "/dokumentasi", produces = MediaType.TEXT_HTML_VALUE)
    public String halamanDokumentasi() {
        return """
                <!DOCTYPE html>
                <html lang="id">
                <head>
                    <meta charset="UTF-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1.0">
                    <title>Dokumentasi, Bukti & GitHub - Siti Dibaj Trikusuma (117)</title>
                    <style>
                        :root {
                            color-scheme: dark;
                            --bg: #090d16;
                            --surface: #121829;
                            --surface-card: #182238;
                            --border: rgba(255, 255, 255, 0.12);
                            --primary: #ec4899;
                            --accent: #6366f1;
                            --text: #f8fafc;
                            --text-muted: #94a3b8;
                            --font: 'Inter', system-ui, -apple-system, sans-serif;
                        }
                        * { box-sizing: border-box; margin: 0; padding: 0; }
                        body {
                            background: radial-gradient(circle at 10% 10%, rgba(236, 72, 153, 0.12) 0, transparent 35%),
                                        var(--bg);
                            font-family: var(--font);
                            color: var(--text);
                            line-height: 1.7;
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
                        .nav-brand { font-weight: 700; text-decoration: none; color: var(--text); }
                        .nav-links { display: flex; gap: 16px; align-items: center; }
                        .nav-link { color: var(--text-muted); text-decoration: none; font-size: 0.9rem; font-weight: 500; }
                        .nav-link:hover, .nav-link.active { color: var(--text); }
                        .container { max-width: 960px; margin: 32px auto 0; padding: 0 20px; }
                        .card {
                            background: var(--surface);
                            border: 1px solid var(--border);
                            border-radius: 20px;
                            padding: 32px;
                            margin-bottom: 24px;
                            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.25);
                        }
                        h1 { font-size: 2.2rem; margin-bottom: 8px; }
                        h2 { font-size: 1.35rem; color: #f472b6; margin: 24px 0 12px; border-bottom: 1px solid var(--border); padding-bottom: 8px; }
                        h3 { font-size: 1.1rem; color: #a5b4fc; margin: 16px 0 8px; }
                        p, li { color: #cbd5e1; font-size: 0.95rem; }
                        ul, ol { margin: 8px 0 16px 24px; }
                        li { margin-bottom: 8px; }
                        pre {
                            background: #020617;
                            border: 1px solid rgba(255, 255, 255, 0.1);
                            border-radius: 12px;
                            padding: 16px;
                            color: #38bdf8;
                            font-family: 'Consolas', monospace;
                            font-size: 0.88rem;
                            overflow-x: auto;
                            margin: 12px 0 16px;
                        }
                        .step-box {
                            background: var(--surface-card);
                            border: 1px solid var(--border);
                            border-radius: 14px;
                            padding: 18px 22px;
                            margin-bottom: 14px;
                        }
                    </style>
                </head>
                <body>
                    <nav>
                        <a href="/" class="nav-brand">UTS RPL Lanjut &bull; Siti Dibaj (117)</a>
                        <div class="nav-links">
                            <a href="/" class="nav-link">&larr; Beranda</a>
                            <a href="/hello-world" class="nav-link">Hello World BPMN</a>
                            <a href="/studi-kasus" class="nav-link">Studi Kasus</a>
                            <a href="/teori-5w" class="nav-link">Teori 5W</a>
                            <a href="/dokumentasi" class="nav-link active">Dokumentasi & GitHub</a>
                        </div>
                    </nav>

                    <div class="container">
                        <div style="margin-bottom: 24px;">
                            <span style="background: rgba(236, 72, 153, 0.15); border: 1px solid rgba(236,72,153,0.3); color: #f472b6; padding: 4px 12px; border-radius: 999px; font-size: 0.8rem; font-weight: 700;">
                                Soal Nomor 4, 5, 6 (Bobot 7.5% + 7.5% + 15% = 30%)
                            </span>
                            <h1 style="margin-top: 10px;">Panduan Dokumentasi, Rekaman & Repositori GitHub</h1>
                            <p style="color: var(--text-muted);">
                                Rujukan lengkap tata cara pengujian aplikasi, panduan pengambilan tangkapan layar (print screen), alur perekaman video demo mandiri, dan petunjuk pengumpulan via GitHub ke Dosen Pengampu: <strong>rizalbroer@uinjkt.ac.id</strong>.
                            </p>
                        </div>

                        <div class="card">
                            <h2>1. Repositori GitHub & Pengumpulan (Bobot 15% Nilai Plus)</h2>
                            <p>
                                Proyek ini telah dipersiapkan dengan struktur Git yang bersih dan rapi. Ikuti langkah-langkah di bawah untuk mem-push ke akun GitHub Anda dan membagikannya ke Pak Broer:
                            </p>
                            
                            <div class="step-box">
                                <h3>Langkah A: Buat Repositori Baru di Akun GitHub Anda</h3>
                                <ol>
                                    <li>Buka <strong>https://github.com/new</strong> dan login dengan akun GitHub Anda.</li>
                                    <li>Beri nama repositori: <code>uts-rpllanjut-sitidibaj-117</code>.</li>
                                    <li>Pilih visibilitas <strong>Public</strong> (atau <strong>Private</strong> lalu invite collaborator).</li>
                                    <li>Biarkan opsi README/gitignore tidak dicentang (karena sudah ada di lokal). Klik <strong>Create repository</strong>.</li>
                                </ol>
                            </div>

                            <div class="step-box">
                                <h3>Langkah B: Hubungkan dan Push dari Terminal Komputer Anda</h3>
                                <pre># Pastikan berada di folder proyek:
git remote add origin https://github.com/USERNAME-ANDA/uts-rpllanjut-sitidibaj-117.git
git branch -M main
git push -u origin main</pre>
                            </div>

                            <div class="step-box">
                                <h3>Langkah C: Bagikan Repositori ke Dosen Pengampu</h3>
                                <p>Jika repositori bersifat <strong>Private</strong>, tambahkan Pak Broer sebagai kolaborator:</p>
                                <ul>
                                    <li>Buka menu <strong>Settings &rarr; Collaborators &rarr; Add people</strong>.</li>
                                    <li>Masukkan email: <strong style="color: #f472b6;">rizalbroer@uinjkt.ac.id</strong>.</li>
                                </ul>
                                <p>Kirimkan juga email konfirmasi pengumpulan tugas kepada beliau dengan menyertakan tautan repositori GitHub dan rekaman video.</p>
                            </div>

                            <h2>2. Panduan Print Screen (Tangkapan Layar) Berurutan</h2>
                            <p>Untuk menyusun laporan dokumen yang runtut dan logis (Prinsip ABC), ambil 5 tangkapan layar kunci berikut:</p>
                            <ol>
                                <li><strong>Screenshot 1: Portal Utama (<code>http://localhost:8080/</code>)</strong> &mdash; Menampilkan identitas mahasiswa (Siti Dibaj Trikusuma, NIM 117) dan status Camunda BPM Engine aktif.</li>
                                <li><strong>Screenshot 2: Pengujian Hello World BPMN (<code>http://localhost:8080/hello-world</code>)</strong> &mdash; Bukti eksekusi pemicuan proses Hello World dan penyelesaian task.</li>
                                <li><strong>Screenshot 3: Pengajuan Proposal Mahasiswa (<code>http://localhost:8080/studi-kasus</code> Tab 1)</strong> &mdash; Form input pengajuan proposal skripsi sebelum dan sesudah disubmit.</li>
                                <li><strong>Screenshot 4: Inbox Verifikasi & Approval (<code>http://localhost:8080/studi-kasus</code> Tab 2)</strong> &mdash; Kartu tugas verifikasi Sekretaris Prodi, Dosen Pembimbing, dan Ketua Prodi yang sedang diproses.</li>
                                <li><strong>Screenshot 5: Riwayat & Penerbitan SK (<code>http://localhost:8080/studi-kasus</code> Tab 3)</strong> &mdash; Tabel riwayat dari Camunda HistoryService yang menunjukkan alur telah selesai dan nomor SK resmi telah terbit.</li>
                            </ol>

                            <h2>3. Skenario Rekaman Video Demo (Durasi Rekomendasi: 3 - 5 Menit)</h2>
                            <div class="step-box">
                                <h3>Struktur Alur Presentasi Rekaman:</h3>
                                <ul>
                                    <li><strong>Menit 00:00 - 00:45:</strong> Pembukaan, salam, perkenalan diri (Nama: Siti Dibaj Trikusuma, NIM: 117, Prodi TI UIN Jakarta), dan penjelasan singkat tujuan UTS RPL Lanjut.</li>
                                    <li><strong>Menit 00:45 - 01:30:</strong> Penjelasan singkat konsep 5W integrasi Spring Boot dan Camunda BPMN 2.0 (tunjukkan halaman <code>/teori-5w</code>).</li>
                                    <li><strong>Menit 01:30 - 02:15:</strong> Demonstrasi Pengujian Hello World BPMN (buka <code>/hello-world</code>, klik jalankan dan tunjukkan log eksekusi instan).</li>
                                    <li><strong>Menit 02:15 - 04:15:</strong> Demonstrasi Studi Kasus Alur Proposal Skripsi (buka <code>/studi-kasus</code>, isi form & submit, buka tab inbox verifikasi, klik approve untuk Sekprodi, Dosen, dan Kaprodi hingga nomor SK terbit di tab riwayat).</li>
                                    <li><strong>Menit 04:15 - 05:00:</strong> Penutup, menampilkan repositori GitHub, ucapan terima kasih kepada Dosen Pengampu Pak Broer.</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </body>
                </html>
                """;
    }
}