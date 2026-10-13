# UTS Rekayasa Perangkat Lunak Lanjut
## Pemodelan Alur Kerja Bisnis (BPMN 2.0) dan Implementasi Aplikasi Berbasis Spring Boot & Camunda Engine

---

### Informasi Mahasiswa & Mata Kuliah
* **Nama Mahasiswa:** Siti Dibaj Trikusuma
* **NIM:** 117
* **Program Studi:** Teknik Informatika
* **Fakultas:** Sains dan Teknologi
* **Perguruan Tinggi:** Universitas Islam Negeri (UIN) Syarif Hidayatullah Jakarta
* **Mata Kuliah:** Rekayasa Perangkat Lunak Lanjut (UTS)
* **Dosen Pengampu:** Rizal Broer Bahaweres, S.Kom., M.Sc., Ph.D. (`rizalbroer@uinjkt.ac.id`)
* **Tahun Akademik:** 2024 / 2025

---

## Daftar Isi
1. [Ringkasan Proyek & Arsitektur Teknologi](#1-ringkasan-proyek--arsitektur-teknologi)
2. [Soal 1: Penjelasan 5W Spring Boot, BPM/BPMN, dan Integrasi J2EE (Bobot 10%)](#2-soal-1-penjelasan-5w-spring-boot-bpmbpmn-dan-integrasi-j2ee-bobot-10)
3. [Soal 2: Instalasi, Konfigurasi Tools BPMN, dan Hello World Test (Bobot 10%)](#3-soal-2-instalasi-konfigurasi-tools-bpmn-dan-hello-world-test-bobot-10)
4. [Soal 3: Studi Kasus Alur Kerja Pengajuan Proposal Skripsi (Bobot 50%)](#4-soal-3-studi-kasus-alur-kerja-pengajuan-proposal-skripsi-bobot-50)
5. [Soal 4 & 5: Panduan Print Screen, Skenario Rekaman, dan Prinsip ABC (Bobot 15%)](#5-soal-4--5-panduan-print-screen-skenario-rekaman-dan-prinsip-abc-bobot-15)
6. [Soal 6: Penggunaan Tools GitHub dan Petunjuk Pengumpulan (Bobot 15%)](#6-soal-6-penggunaan-tools-github-dan-petunjuk-pengumpulan-bobot-15)
7. [Petunjuk Menjalankan Aplikasi Secara Lokal](#7-petunjuk-menjalankan-aplikasi-secara-lokal)

---

## 1. Ringkasan Proyek & Arsitektur Teknologi

Aplikasi ini dibangun untuk memenuhi seluruh ketentuan Ujian Tengah Semester mata kuliah Rekayasa Perangkat Lunak Lanjut. Proyek ini mendemonstrasikan integrasi antara:
* **Framework:** Spring Boot 3.1.5 (Java 17 / 21)
* **Workflow Engine:** Camunda Platform 7.20.0 (BPMN 2.0 Engine & Webapp)
* **Database:** In-Memory H2 Database (ACID Transactional State Storage)
* **UI & Client:** Responsive Web Application (Vanilla CSS modern dengan glassmorphism dark aesthetic dan Fetch API AJAX)
* **Spesifikasi Model BPMN:**
  * `hello-world.bpmn`: Verifikasi instalasi dan fungsionalitas engine dasar.
  * `proposal-skripsi.bpmn`: Alur bisnis multi-peran pengajuan proposal skripsi mahasiswa Program Studi Teknik Informatika UIN Syarif Hidayatullah Jakarta.

---

## 2. Soal 1: Penjelasan 5W Spring Boot, BPM/BPMN, dan Integrasi J2EE (Bobot 10%)

> **Penerapan Prinsip ABC (Accuracy, Brevity, Clarity):**
> Penjelasan di bawah disusun secara akurat berlandaskan standar industri, padat dan ringkas tanpa repetisi, serta disajikan dalam tabel dan poin hierarkis yang logis.

### A. Analisis 5W Framework Spring / Spring Boot
| Aspek | Uraian Konseptual & Teknis |
| :--- | :--- |
| **What (Apa)** | **Spring Boot** adalah framework pengembangan aplikasi enterprise berbasis Java open-source yang memperluas ekosistem Spring Framework melalui fitur *opinionated defaults*, *auto-configuration*, dan *embedded web server* (Tomcat/Jetty/Undertow), sehingga aplikasi dapat berjalan langsung sebagai *standalone executable JAR*. |
| **Why (Mengapa)** | Menghilangkan kerumitan konfigurasi XML dan *boilerplate configuration* yang membebani pengembang pada era Java EE / J2EE klasik. Spring Boot secara dramatis mempercepat produktivitas (*time-to-market*), mempermudah pembuatan layanan Microservices terdistribusi, serta meminimalkan potensi konflik versi antar-*library*. |
| **Who (Siapa)** | Diprakarsai oleh Rod Johnson (2002) dan saat ini dikembangkan serta didukung penuh oleh **VMware Tanzu (Broadcom)** bersama jutaan software engineer di seluruh dunia. |
| **Where (Di mana)** | Diterapkan pada arsitektur web backend berskala besar, core-banking, portal layanan akademik kampus, platform e-commerce, hingga arsitektur microservices berbasis cloud container (Docker/Kubernetes). |
| **When (Kapan)** | Digunakan ketika organisasi membutuhkan sistem enterprise berbasis Java yang cepat dibangun, memiliki manajemen dependensi yang stabil, andal dalam penanganan concurrency, serta membutuhkan integrasi siap pakai dengan database (Spring Data) dan sistem keamanan (Spring Security). |

### B. Analisis 5W BPM dan BPMN
| Aspek | Uraian Konseptual & Teknis |
| :--- | :--- |
| **What (Apa)** | **BPM (Business Process Management)** adalah disiplin ilmu manajerial dan teknologi yang memadukan pemodelan, eksekusi, pemantauan, dan optimasi alur kerja bisnis. Sedangkan **BPMN (Business Process Model and Notation)** adalah standar grafis global resmi dari **OMG (Object Management Group)** versi 2.0 yang menyediakan simbol notasi visual terstandar (Events, Tasks, Gateways, Sequence Flows) yang dapat langsung dieksekusi oleh mesin proses (*executable XML*). |
| **Why (Mengapa)** | Menjembatani jurang komunikasi (*communication gap*) antara pemangku kepentingan bisnis/manajemen dengan tim rekayasa perangkat lunak teknis. Tanpa BPMN, logika alur persetujuan seringkali tertanam secara kaku (*hard-coded*) di dalam kode program, menyulitkan adaptasi ketika kebijakan organisasi berubah. |
| **Who (Siapa)** | Distandarisasi oleh konsorsium internasional **OMG**, dimodelkan bersama oleh Business Analyst dan Software Engineer, serta dieksekusi oleh workflow engine seperti **Camunda, Flowable, dan Activiti**. |
| **Where (Di mana)** | Diimplementasikan pada proses bisnis lintas divisi atau lintas peran yang melibatkan interaksi manusia (*User Tasks*) dan pemrosesan otomatis sistem (*Service Tasks*), seperti pengajuan proposal skripsi mahasiswa, persetujuan pinjaman perbankan, dan pengadaan logistik. |
| **When (Kapan)** | Digunakan saat proses bisnis memiliki tahapan verifikasi berjenjang, bersifat *long-running* (membutuhkan waktu berjam-jam hingga berminggu-minggu), atau menuntut pencatatan rekam jejak (*audit trail*) yang transparan dan akuntabel. |

### C. Keterkaitan Antara Spring Boot dan BPMN
Sinergi antara Spring Boot dan BPMN merepresentasikan integrasi dua pilar: **BPMN sebagai lapisan orkestrasi alur logika (orchestration layer)** dan **Spring Boot sebagai lapisan eksekusi bisnis dan data (execution & data layer)**.
1. **Penyuntikan Komponen (Spring Bean Injection):** Node *Service Task* di dalam file BPMN dapat memanggil Spring Bean secara langsung (contoh: ekspresi `${notifikasiService.kirimEmail(execution)}`).
2. **Manajemen Transaksi Terpadu (ACID Compliance):** Camunda terintegrasi ke dalam `PlatformTransactionManager` milik Spring Boot, menjamin konsistensi data antara database transaksional aplikasi dan state peralihan token alur kerja.
3. **Penyederhanaan Siklus Hidup:** File definisi BPMN otomatis terdeploy ke database saat booting aplikasi melalui `camunda-bpm-spring-boot-starter`.

### D. Manfaat dan Kegunaan BPM dalam Pengembangan J2EE / Jakarta EE
1. **Pemisahan Logika Alur dari Kode Teknis (Separation of Concerns):** Aturan birokrasi persetujuan tidak lagi bercampur dengan kode query SQL, controller REST, atau servlet, sehingga memudahkan perawatan (*maintainability*).
2. **Audit Trail dan Riwayat Otomatis:** Mesin Camunda merekam secara permanen aktor yang memproses tugas, durasi pemrosesan, serta variabel yang dikirimkan.
3. **Ketahanan Proses Jangka Panjang (Asynchronous & Fault Tolerance):** Status alur disimpan di tabel database (H2/PostgreSQL/Oracle), sehingga server yang di-restart tidak akan menghilangkan status penugasan mahasiswa.

---

## 3. Soal 2: Instalasi, Konfigurasi Tools BPMN, dan Hello World Test (Bobot 10%)

### A. Konfigurasi Dependensi Maven (`pom.xml`)
Integrasi engine BPMN ke dalam ekosistem Spring Boot dilakukan melalui penambahan starter resmi Camunda dan database JDBC H2:
```xml
<!-- Spring Boot Web & JDBC -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-jdbc</artifactId>
</dependency>

<!-- Camunda BPM Spring Boot Starter Webapp 7.20.0 -->
<dependency>
    <groupId>org.camunda.bpm.springboot</groupId>
    <artifactId>camunda-bpm-spring-boot-starter-webapp</artifactId>
    <version>7.20.0</version>
</dependency>

<!-- H2 In-Memory Database -->
<dependency>
    <groupId>com.h2database</groupId>
    <artifactId>h2</artifactId>
    <scope>runtime</scope>
</dependency>
```

### B. Konfigurasi Engine (`application.properties`)
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

### C. Pemodelan & Uji Coba Hello World BPMN
File proses `src/main/resources/processes/hello-world.bpmn` dibuat dengan struktur:
* **Process ID:** `hello-world-process`
* **Elemen:** `Start_Hello` &rarr; `Task_SayHello` (User Task) &rarr; `End_Hello`
* **Pengujian:**
  * Pengguna membuka endpoint `http://localhost:8080/hello-world`.
  * Mengklik tombol **Jalankan Hello World BPMN**.
  * Camunda mengeksekusi `runtimeService.startProcessInstanceByKey("hello-world-process")`, menampilkan Process Instance ID aktif, dan memunculkan tugas pada daftar task untuk kemudian diselesaikan (`taskService.complete`).

---

## 4. Soal 3: Studi Kasus Alur Kerja Pengajuan Proposal Skripsi (Bobot 50%)

### A. Latar Belakang & Deskripsi Kasus
Pada Program Studi Teknik Informatika Fakultas Sains dan Teknologi UIN Syarif Hidayatullah Jakarta, proses pengajuan proposal skripsi sering menghadapi kendala transparansi status dan kelambatan birokrasi manual. Studi kasus ini memodelkan dan mengotomatisasikan workflow pengajuan proposal skripsi dari mahasiswa hingga penetapan Surat Keputusan (SK) pembimbing.

### B. Pemodelan BPMN 2.0 (`proposal-skripsi.bpmn`)
Alur kerja dirancang dengan tahapan sekuensial yang melibatkan empat entitas peran:
1. **Start Event (Mahasiswa Mengajukan Proposal):** Mahasiswa memasukkan formulir data proposal (nama, NIM, bidang kajian, usulan dosen pembimbing, judul, dan abstrak).
2. **User Task 1 (Verifikasi Sekretaris Prodi - `Task_Verifikasi`):** Sekretaris Prodi memeriksa kelayakan administratif dan ketiadaan plagiasi topik.
3. **User Task 2 (Review Dosen Pembimbing - `Task_Review`):** Calon dosen pembimbing meninjau substansi akademik dan menyatakan kesediaan membimbing.
4. **User Task 3 (Persetujuan Ketua Prodi - `Task_Approval`):** Ketua Program Studi menyetujui secara resmi dan menerbitkan nomor SK pembimbing skripsi.
5. **End Event (Proposal Disetujui & SK Terbit):** Instance alur kerja selesai dengan sukses dan data diarsipkan ke `HistoryService`.

### C. Implementasi Kode Backend & Layanan Engine
1. **`ProposalDto.java` (`com.uts.rpllanjut.model`):** Struktur data untuk menampung seluruh variabel proses Camunda.
2. **`BpmnWorkflowService.java` (`com.uts.rpllanjut.service`):**
   * `submitProposal(...)`: Memulai instance proses BPMN baru dengan variabel form mahasiswa.
   * `getActiveProposalTasks()`: Mengambil daftar penugasan aktif dari `taskService` terfilter per peran.
   * `processTask(...)`: Menyelesaikan task aktif dan memajukan token proses ke tahap berikutnya.
   * `getAllProposalsHistory()`: Mengambil jejak audit dari `historyService`.
3. **`WorkflowApiController.java` (`com.uts.rpllanjut.controller`):** Endpoint RESTful JSON untuk interaksi UI frontend tanpa reload:
   * `POST /api/proposals/submit`
   * `GET /api/proposals/active-tasks`
   * `POST /api/proposals/process-task`
   * `GET /api/proposals/history`

### D. Tampilan Antarmuka Interaktif (`/studi-kasus`)
Halaman web dilengkapi dengan:
* **Tab 1: Formulir Pengajuan:** Form pengajuan lengkap beserta tombol *Isi Contoh Data Otomatis*.
* **Tab 2: Inbox Verifikasi Multi-Peran:** Kartu-kartu penugasan dinamis dengan indikator warna peran (Sekprodi, Dosen, Kaprodi) dan input catatan.
* **Tab 3: Pelacakan & Riwayat:** Tabel status real-time dengan status kelulusan berkas dan penerbitan nomor SK otomatis.
* **Tab 4: Diagram BPMN:** Penjelasan visual langkah demi langkah.

---

## 5. Soal 4 & 5: Panduan Print Screen, Skenario Rekaman, dan Prinsip ABC (Bobot 15%)

### A. Panduan Pengambilan Print Screen (Tangkapan Layar)
Untuk kelengkapan laporan, ambil tangkapan layar secara berurutan:
1. **Screenshot 1: Portal Utama (`http://localhost:8080/`)**
   * Menampilkan kartu profil Siti Dibaj Trikusuma (NIM: 117) dan status aktif Camunda Engine.
2. **Screenshot 2: Pengujian Hello World BPMN (`http://localhost:8080/hello-world`)**
   * Menampilkan hasil klik pemicuan instance Hello World dengan log konsol sukses.
3. **Screenshot 3: Formulir Pengajuan Proposal (`http://localhost:8080/studi-kasus` - Tab 1)**
   * Menampilkan form yang telah diisi data proposal skripsi.
4. **Screenshot 4: Inbox Verifikasi Tugas (`http://localhost:8080/studi-kasus` - Tab 2)**
   * Menampilkan kartu task Sekretaris Prodi / Dosen / Kaprodi yang sedang diproses.
5. **Screenshot 5: Tabel Riwayat & SK Terbit (`http://localhost:8080/studi-kasus` - Tab 3)**
   * Menampilkan proposal berstatus selesai dengan nomor SK pembimbing yang telah digenerate.

### B. Skenario Rekaman Video Presentasi Demo (Durasi: 3 - 5 Menit)
* **Menit 00:00 - 00:45:** Pembukaan salam, identitas mahasiswa (Siti Dibaj Trikusuma, NIM: 117, Prodi Teknik Informatika UIN Jakarta), pengantar tugas UTS RPL Lanjut.
* **Menit 00:45 - 01:30:** Penjelasan ringkas konsep 5W integrasi Spring Boot dan BPMN 2.0 (tunjukkan halaman `/teori-5w`).
* **Menit 01:30 - 02:15:** Demo Pengujian Hello World BPMN (buka `/hello-world`, klik trigger, tunjukkan log eksekusi dan selesaikan task).
* **Menit 02:15 - 04:15:** Demo Studi Kasus Proposal Skripsi (buka `/studi-kasus`, submit form, buka tab inbox verifikasi, klik setujui untuk Sekprodi, Dosen, dan Kaprodi, lalu tunjukkan nomor SK yang terbit di tab riwayat).
* **Menit 04:15 - 05:00:** Penutup, menunjukkan repositori GitHub, serta ucapan terima kasih kepada Dosen Pengampu Bapak Rizal Broer Bahaweres.

---

## 6. Soal 6: Penggunaan Tools GitHub dan Petunjuk Pengumpulan (Bobot 15%)

### A. Tautan Repositori Resmi GitHub
* **URL Repositori GitHub:** [https://github.com/babaj-dibaj/UTS-RPL-Lanjut](https://github.com/babaj-dibaj/UTS-RPL-Lanjut)
* **Clone URL:** `https://github.com/babaj-dibaj/UTS-RPL-Lanjut.git`
* **Pemilik Repositori:** **Siti Dibaj Trikusuma** (`babaj-dibaj`)

### B. Perintah Inisialisasi dan Push ke GitHub
```bash
# 1. Tambahkan remote URL ke repository GitHub resmi
git remote add origin https://github.com/babaj-dibaj/UTS-RPL-Lanjut.git

# 2. Set branch utama ke main dan push seluruh kode
git branch -M main
git push -u origin main
```

### B. Membagikan Repositori ke Dosen Pengampu
* **Email Dosen Pengampu:** `rizalbroer@uinjkt.ac.id`
* **Jika repositori disetel Private:**
  1. Masuk ke halaman repositori di GitHub.
  2. Buka menu **Settings &rarr; Collaborators &rarr; Add people**.
  3. Masukkan email `rizalbroer@uinjkt.ac.id` untuk mengundang beliau sebagai reviewer.
* **Kirimkan Email Pengumpulan Tugas:**
  * **Subjek:** UTS RPL Lanjut - Siti Dibaj Trikusuma - NIM 117
  * **Tujuan:** `rizalbroer@uinjkt.ac.id`
  * **Isi:** Tautan repositori GitHub, tautan video rekaman demo, dan lampiran dokumen laporan/print screen.

---

## 7. Petunjuk Menjalankan Aplikasi Secara Lokal

### Prasyarat:
* Java Development Kit (JDK) versi 17 atau 21 terpasang di sistem.
* Koneksi internet untuk unduhan Maven dependensi pertama kali.

### Perintah Menjalankan Aplikasi:
Buka PowerShell atau Command Prompt di direktori proyek ini, lalu jalankan:
```powershell
.\mvnw.cmd spring-boot:run
```
*(Atau di Linux/macOS: `./mvnw spring-boot:run`)*

### URL Akses Browser:
* **Portal Utama UTS:** [http://localhost:8080/](http://localhost:8080/)
* **Modul Hello World BPMN:** [http://localhost:8080/hello-world](http://localhost:8080/hello-world)
* **Modul Studi Kasus Proposal Skripsi:** [http://localhost:8080/studi-kasus](http://localhost:8080/studi-kasus)
* **Modul Teori 5W & BPMN:** [http://localhost:8080/teori-5w](http://localhost:8080/teori-5w)
* **Modul Dokumentasi & GitHub:** [http://localhost:8080/dokumentasi](http://localhost:8080/dokumentasi)
* **Konsol Database H2:** [http://localhost:8080/h2-console](http://localhost:8080/h2-console) (JDBC URL: `jdbc:h2:mem:camunda-db`, User: `sa`, Password: *(kosong)*)
* **Camunda Webapp:** [http://localhost:8080/camunda/app/](http://localhost:8080/camunda/app/)

---
*Dibuat dan disusun secara mandiri oleh Siti Dibaj Trikusuma (NIM: 117) untuk Ujian Tengah Semester Rekayasa Perangkat Lunak Lanjut Program Studi Teknik Informatika UIN Syarif Hidayatullah Jakarta.*
