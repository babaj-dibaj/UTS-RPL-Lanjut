package com.uts.rpllanjut.model;

import java.io.Serializable;
import java.util.Map;

/**
 * Data Transfer Object untuk Pengajuan Proposal Skripsi
 * Mahasiswa Prodi Teknik Informatika UIN Syarif Hidayatullah Jakarta
 */
public class ProposalDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String processInstanceId;
    private String taskId;
    private String taskName;
    private String taskAssigneeRole;
    private String namaMahasiswa;
    private String nim;
    private String email;
    private String judulProposal;
    private String bidangKajian;
    private String calonPembimbing;
    private String abstrak;
    private String statusAlur;
    private String tanggalPengajuan;
    private String catatanSekretaris;
    private String catatanDosen;
    private String catatanKaprodi;
    private String nomorSk;
    private boolean selesai;

    public ProposalDto() {
    }

    public static ProposalDto fromVariables(String processInstanceId, Map<String, Object> vars) {
        ProposalDto dto = new ProposalDto();
        dto.setProcessInstanceId(processInstanceId);
        dto.setNamaMahasiswa((String) vars.getOrDefault("namaMahasiswa", "-"));
        dto.setNim((String) vars.getOrDefault("nim", "-"));
        dto.setEmail((String) vars.getOrDefault("email", "-"));
        dto.setJudulProposal((String) vars.getOrDefault("judulProposal", "-"));
        dto.setBidangKajian((String) vars.getOrDefault("bidangKajian", "-"));
        dto.setCalonPembimbing((String) vars.getOrDefault("calonPembimbing", "-"));
        dto.setAbstrak((String) vars.getOrDefault("abstrak", "-"));
        dto.setStatusAlur((String) vars.getOrDefault("statusAlur", "Diajukan"));
        dto.setTanggalPengajuan((String) vars.getOrDefault("tanggalPengajuan", "-"));
        dto.setCatatanSekretaris((String) vars.getOrDefault("catatanSekretaris", "-"));
        dto.setCatatanDosen((String) vars.getOrDefault("catatanDosen", "-"));
        dto.setCatatanKaprodi((String) vars.getOrDefault("catatanKaprodi", "-"));
        dto.setNomorSk((String) vars.getOrDefault("nomorSk", "-"));
        Object selesaiVal = vars.get("selesai");
        dto.setSelesai(selesaiVal instanceof Boolean && (Boolean) selesaiVal);
        return dto;
    }

    // Getters and Setters
    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskAssigneeRole() {
        return taskAssigneeRole;
    }

    public void setTaskAssigneeRole(String taskAssigneeRole) {
        this.taskAssigneeRole = taskAssigneeRole;
    }

    public String getNamaMahasiswa() {
        return namaMahasiswa;
    }

    public void setNamaMahasiswa(String namaMahasiswa) {
        this.namaMahasiswa = namaMahasiswa;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJudulProposal() {
        return judulProposal;
    }

    public void setJudulProposal(String judulProposal) {
        this.judulProposal = judulProposal;
    }

    public String getBidangKajian() {
        return bidangKajian;
    }

    public void setBidangKajian(String bidangKajian) {
        this.bidangKajian = bidangKajian;
    }

    public String getCalonPembimbing() {
        return calonPembimbing;
    }

    public void setCalonPembimbing(String calonPembimbing) {
        this.calonPembimbing = calonPembimbing;
    }

    public String getAbstrak() {
        return abstrak;
    }

    public void setAbstrak(String abstrak) {
        this.abstrak = abstrak;
    }

    public String getStatusAlur() {
        return statusAlur;
    }

    public void setStatusAlur(String statusAlur) {
        this.statusAlur = statusAlur;
    }

    public String getTanggalPengajuan() {
        return tanggalPengajuan;
    }

    public void setTanggalPengajuan(String tanggalPengajuan) {
        this.tanggalPengajuan = tanggalPengajuan;
    }

    public String getCatatanSekretaris() {
        return catatanSekretaris;
    }

    public void setCatatanSekretaris(String catatanSekretaris) {
        this.catatanSekretaris = catatanSekretaris;
    }

    public String getCatatanDosen() {
        return catatanDosen;
    }

    public void setCatatanDosen(String catatanDosen) {
        this.catatanDosen = catatanDosen;
    }

    public String getCatatanKaprodi() {
        return catatanKaprodi;
    }

    public void setCatatanKaprodi(String catatanKaprodi) {
        this.catatanKaprodi = catatanKaprodi;
    }

    public String getNomorSk() {
        return nomorSk;
    }

    public void setNomorSk(String nomorSk) {
        this.nomorSk = nomorSk;
    }

    public boolean isSelesai() {
        return selesai;
    }

    public void setSelesai(boolean selesai) {
        this.selesai = selesai;
    }
}
