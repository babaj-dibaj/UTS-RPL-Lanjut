# LAPORAN UJIAN TENGAH SEMESTER (UTS)
## REKAYASA PERANGKAT LUNAK LANJUT

### "Implementasi Pemodelan Alur Kerja Bisnis (BPMN 2.0) Menggunakan Framework Spring Boot dan Camunda Engine pada Studi Kasus Pengajuan Proposal Skripsi Mahasiswa Teknik Informatika UIN Syarif Hidayatullah Jakarta"

---

**Disusun Oleh:**
* **Nama:** Siti Dibaj Trikusuma
* **NIM:** 117
* **Program Studi:** Teknik Informatika
* **Fakultas:** Sains dan Teknologi
* **Perguruan Tinggi:** Universitas Islam Negeri Syarif Hidayatullah Jakarta

**Dosen Pengampu:**
* **Nama:** Rizal Broer Bahaweres, S.Kom., M.Sc., Ph.D.
* **Email:** `rizalbroer@uinjkt.ac.id`

**Semester / Tahun Akademik:** Ganjil / 2024 - 2025

---

## ABSTRAK
Dalam lanskap rekayasa perangkat lunak enterprise modern, pemisahan logika bisnis dari arsitektur teknis program merupakan kunci ketahanan dan skalabilitas sistem. Laporan ini mendokumentasikan perancangan dan implementasi alur kerja proses bisnis (*Business Process Management*) menggunakan standar notasi BPMN 2.0 yang terintegrasi dengan framework Spring Boot 3 dan workflow engine Camunda Platform 7.20. Studi kasus yang diangkat adalah sistem verifikasi dan persetujuan pengajuan proposal skripsi di Program Studi Teknik Informatika UIN Syarif Hidayatullah Jakarta. Melalui pendekatan ini, proses birokrasi berjenjang yang melibatkan Mahasiswa, Sekretaris Prodi, Calon Dosen Pembimbing, dan Ketua Program Studi dimodelkan secara visual dan dapat dieksekusi secara otomatis (*executable process*). Seluruh pengerjaan dan penulisan laporan ini disusun secara runtut dan teratur dengan mempedomani prinsip **ABC** (*Accuracy, Brevity, Clarity*).

**Kata Kunci:** *Spring Boot, Business Process Management (BPM), BPMN 2.0, Camunda Engine, J2EE/Jakarta EE, Proposal Skripsi.*

---

## BAB I: PENDAHULUAN & LANDASAN TEORI (5W & BPMN)

### 1.1 Penerapan Prinsip ABC dalam Laporan
Laporan ini mengadopsi prinsip komunikasi teknis ilmiah **ABC**:
* **Accuracy (Keakuratan):** Seluruh konsep rekayasa perangkat lunak, spesifikasi model OMG BPMN 2.0, dan konfigurasi Spring Boot berbasis fakta teknis yang teruji.
* **Brevity (Kepadatan & Keringkasan):** Penyampaian materi bersifat langsung pada pokok bahasan, padat informasi, dan bebas dari kalimat berulang yang tidak esensial.
* **Clarity (Kejelasan & Keteraturan):** Narasi disusun secara hierarkis, sistematis, dan logis dengan pembagian bab serta tabel pendukung.

### 1.2 Analisis 5W Framework Spring / Spring Boot
* **What (Apa):** Spring Boot adalah framework berbasis Java tingkat enterprise yang mengotomatisasi konfigurasi (*opinionated auto-configuration*) aplikasi Spring konvensional, menyediakan server servlet tertanam (*embedded container*), dan menghasilkan berkas *executable JAR* mandiri.
* **Why (Mengapa):** Dikembangkan untuk mengatasi tingginya kompleksitas konfigurasi XML dan *boilerplate code* pada era Java EE tradisional, mempercepat siklus pengiriman perangkat lunak (*time-to-market*), serta mempermudah pengembangan arsitektur *microservices*.
* **Who (Siapa):** Dimulai dari arsitektur dasar rancangan Rod Johnson dan dipelihara secara profesional oleh VMware Tanzu (Broadcom) didukung komunitas open-source global.
* **Where (Di mana):** Diimplementasikan secara luas pada sistem enterprise perbankan, portal akademik universitas, e-commerce, hingga arsitektur cloud terdistribusi.
* **When (Kapan):** Digunakan saat tim pengembang memerlukan backend tangguh dengan manajemen dependensi stabil, performa tinggi, serta integrasi ekosistem enterprise yang matang (Spring Data, Spring Security).

### 1.3 Analisis 5W BPM dan BPMN
* **What (Apa):** *Business Process Management* (BPM) adalah disiplin manajerial untuk memodelkan, mengotomatisasi, mengukur, dan memperbaiki alur proses operasional. *Business Process Model and Notation* (BPMN) adalah standar notasi grafis global dari *Object Management Group* (OMG) yang menyediakan representasi visual sekaligus file eksekusi XML (BPMN 2.0).
* **Why (Mengapa):** Berfungsi sebagai jembatan komunikasi (*lingua franca*) antara pemangku kepentingan akademik/bisnis dengan software engineer, serta mencegah penanaman logika alur yang kaku (*hard-coded*) di dalam source code.
* **Who (Siapa):** Distandarisasi oleh konsorsium OMG dan dieksekusi oleh mesin alur kerja open-source terkemuka seperti Camunda Platform.
* **Where (Di mana):** Diterapkan pada alur proses multi-langkah dan multi-peran seperti persetujuan akademik, perizinan administrasi, dan sistem transaksi keuangan.
* **When (Kapan):** Dibutuhkan ketika proses bisnis melibatkan penugasan manusia (*human-in-the-loop*), durasi proses yang panjang (*long-running process*), dan tuntutan audit jejak rekam yang ketat.

### 1.4 Keterkaitan Spring Boot dan BPMN
Integrasi Spring Boot dan BPMN menyatukan dua lapisan utama perangkat lunak:
1. **Lapisan Orkestrasi Alur (BPMN Engine):** Menentukan *siapa* yang bertugas, *kapan* giliran tugas tiba, dan kondisi percabangan logika.
2. **Lapisan Eksekusi Teknis (Spring Boot):** Mengelola transaksi database, validasi input formulir, pengiriman notifikasi, dan antarmuka web.

### 1.5 Manfaat BPM dalam Pengembangan J2EE / Jakarta EE
* **Pemisahan Perhatian (Separation of Concerns):** Logika alur proses terisolasi dari kode program teknis Java. Jika kebijakan prodi berubah (misalnya penambahan tahapan verifikasi berkas), perubahan hanya dilakukan pada diagram BPMN tanpa memodifikasi kode kontroler Java.
* **Audit Trail Otomatis:** Camunda Engine merekam riwayat seluruh perpindahan token proses, waktu eksekusi, aktor penanggung jawab, dan data masukan ke dalam tabel histori basis data.
* **Manajemen State Persisten:** Status proses disimpan di database relasional, sehingga aman terhadap gangguan kegagalan sistem (*system crash/restart*).

---

## BAB II: INSTALASI DAN KONFIGURASI TOOLS BPMN

### 2.1 Perangkat yang Digunakan
1. **IDE:** IntelliJ IDEA
2. **JDK:** OpenJDK 17 / 21
3. **Build Tool:** Apache Maven (via Maven Wrapper `mvnw.cmd`)
4. **BPM Engine:** Camunda Platform Spring Boot Starter Webapp 7.20.0
5. **Database:** H2 Database Engine In-Memory
6. **BPMN Modeling Tool:** Camunda Modeler & XML Editor terstandarisasi OMG BPMN 2.0

### 2.2 Konfigurasi Maven (`pom.xml`)
Dependensi inti yang dikonfigurasi mencakup:
* `spring-boot-starter-web`: Penyediaan HTTP Web Server dan REST Controller.
* `spring-boot-starter-jdbc`: Penyedia abstraksi koneksi basis data HikariCP dan Spring Transaction Manager.
* `camunda-bpm-spring-boot-starter-webapp`: Engine alur kerja Camunda terpadu dengan web application console.
* `h2`: Basis data relasional in-memory untuk penyimpanan state engine.

### 2.3 Konfigurasi Properti Aplikasi (`application.properties`)
```properties
server.port=8080
spring.datasource.url=jdbc:h2:mem:camunda-db;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true

camunda.bpm.database.type=h2
camunda.bpm.job-execution.enabled=false
camunda.bpm.generic-properties.properties.enforce-history-time-to-live=false
```

### 2.4 Pengujian Hello World BPMN
Untuk memvalidasi kesiapan engine, dibuat proses `hello-world.bpmn`:
* **Alur:** `Start_Hello` &rarr; `Task_SayHello` (User Task) &rarr; `End_Hello`.
* **Eksekusi:** Diuji melalui endpoint web `/hello-world` yang memicu pemanggilan `runtimeService.startProcessInstanceByKey("hello-world-process")`. Pengujian berhasil membuktikan pemicuan instance, pembacaan task pada `taskService`, serta penyelesaian tugas menuju `End Event`.

---

## BAB III: IMPLEMENTASI STUDI KASUS PROPOSAL SKRIPSI

### 3.1 Deskripsi Kasus
Studi kasus mengangkat alur pengajuan proposal tugas akhir mahasiswa Program Studi Teknik Informatika Fakultas Sains dan Teknologi UIN Syarif Hidayatullah Jakarta.

### 3.2 Spesifikasi Model Alur Kerja (`proposal-skripsi.bpmn`)
Diagram BPMN terdiri atas:
1. **Start Event (Mahasiswa Mengajukan Proposal):** Menerima masukan identitas, judul, usulan dosen pembimbing, dan abstrak.
2. **Task 1 (Verifikasi Sekretaris Prodi):** Verifikasi administrasi, syarat SKS, dan pencegahan duplikasi topik.
3. **Task 2 (Review Dosen Pembimbing):** Peninjauan substansi ilmiah dan konfirmasi kesediaan membimbing.
4. **Task 3 (Persetujuan Ketua Prodi):** Persetujuan resmi pimpinan jurusan dan penerbitan nomor SK Pembimbing.
5. **End Event (Proposal Disetujui & SK Terbit):** Alur selesai, sistem mencatat nomor SK secara otomatis.

### 3.3 Struktur Komponen Perangkat Lunak
* **`ProposalDto.java`:** Objek transfer data yang menampung atribut proposal dan status alur kerja.
* **`BpmnWorkflowService.java`:** Kelas layanan Spring Boot yang membungkus operasi Camunda:
  * `submitProposal(...)`: Memulai instance proses BPMN baru.
  * `getActiveProposalTasks()`: Menghasilkan penugasan aktif sesuai peran.
  * `processTask(...)`: Menyelesaikan tugas dan menghasilkan nomor SK resmi jika mencapai tahap akhir.
  * `getAllProposalsHistory()`: Mengakses jejak audit instansial dari `historyService`.
* **`WorkflowApiController.java`:** Kontroler REST API untuk integrasi asynchronous dengan browser.
* **`StudiKasusController.java`:** Antarmuka web interaktif berbasis HTML5, CSS kustom modern, dan JavaScript Fetch API.

---

## BAB IV: PANDUAN PENGUJIAN, BUKTI SCREENSHOT, DAN REKAMAN

### 4.1 Prosedur Pengujian Langkah demi Langkah
1. Jalankan aplikasi melalui terminal dengan perintah: `.\mvnw.cmd spring-boot:run`.
2. Buka peramban (browser) ke alamat: `http://localhost:8080/`.
3. Lakukan verifikasi modul Hello World pada menu `/hello-world`.
4. Masuk ke modul studi kasus pada menu `/studi-kasus`:
   * Klik tombol *Isi Contoh Data Otomatis* pada Tab 1 (Pengajuan Mahasiswa) lalu klik *Mulai Instance BPMN & Ajukan*.
   * Pindah ke Tab 2 (Inbox Verifikasi). Perhatikan munculnya tugas untuk *Sekretaris Prodi*. Klik *Setujui Kelayakan*.
   * Tugas otomatis berpindah ke *Dosen Pembimbing*. Masukkan catatan dosen dan klik *Setujui & Bersedia Membimbing*.
   * Tugas beralih ke *Ketua Prodi*. Klik *Sahkan Proposal & Terbitkan SK Pembimbing*.
   * Buka Tab 3 (Pelacakan & Riwayat). Verifikasi bahwa status telah bertanda *Selesai* dan nomor SK resmi (misal: `SK-TI/UINJKT/2026/...`) telah berhasil diterbitkan.

### 4.2 Skenario Rekaman Presentasi (Durasi: 3 - 5 Menit)
* **Menit 00:00 - 00:45:** Pembukaan, salam, identitas mahasiswa (Siti Dibaj Trikusuma, NIM: 117, Prodi Teknik Informatika UIN Jakarta).
* **Menit 00:45 - 01:30:** Pemaparan konsep 5W integrasi Spring Boot dan BPMN (menampilkan halaman `/teori-5w`).
* **Menit 01:30 - 02:15:** Demonstrasi pengujian Hello World BPMN (menampilkan halaman `/hello-world`).
* **Menit 02:15 - 04:15:** Demonstrasi workflow studi kasus proposal skripsi dari pengajuan hingga SK terbit (menampilkan halaman `/studi-kasus`).
* **Menit 04:15 - 05:00:** Penutup, menampilkan repositori GitHub, serta ucapan terima kasih kepada Dosen Pengampu Bapak Rizal Broer Bahaweres.

---

## BAB V: PENGGUNAAN GITHUB DAN PENUTUP

### 5.1 Dokumentasi Repositori GitHub
Proyek dikelola menggunakan Git Version Control System dan diunggah ke layanan GitHub.
* Tautan Repositori: `https://github.com/babaj-dibaj/UTS-RPL-Lanjut`
* Kolaborator/Reviewer: `rizalbroer@uinjkt.ac.id`

### 5.2 Kesimpulan
Integrasi model BPMN 2.0 dengan framework Spring Boot membuktikan efektivitas pemisahan logika bisnis dari arsitektur teknis perangkat lunak. Melalui mesin alur kerja Camunda, proses birokrasi pengajuan proposal skripsi di Teknik Informatika UIN Syarif Hidayatullah Jakarta dapat disimulasikan secara transparan, real-time, dan akuntabel sesuai standar industri rekayasa perangkat lunak.

---
*Laporan ini disusun secara mandiri oleh Siti Dibaj Trikusuma (NIM: 117) - Program Studi Teknik Informatika UIN Syarif Hidayatullah Jakarta.*
