package com.uts.rpllanjut.service;

import com.uts.rpllanjut.model.ProposalDto;
import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.history.HistoricProcessInstance;
import org.camunda.bpm.engine.history.HistoricVariableInstance;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.IdentityService;
import org.camunda.bpm.engine.identity.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class BpmnWorkflowService {

    public static final String PROCESS_KEY_HELLO = "hello-world-process";
    public static final String PROCESS_KEY_PROPOSAL = "proposal-skripsi-process";

    private final RuntimeService runtimeService;
    private final TaskService taskService;
    private final HistoryService historyService;
    private final RepositoryService repositoryService;
    private final IdentityService identityService;

    public BpmnWorkflowService(RuntimeService runtimeService,
                               TaskService taskService,
                               HistoryService historyService,
                               RepositoryService repositoryService,
                               IdentityService identityService) {
        this.runtimeService = runtimeService;
        this.taskService = taskService;
        this.historyService = historyService;
        this.repositoryService = repositoryService;
        this.identityService = identityService;
    }

    @PostConstruct
    public void initAdminUser() {
        try {
            identityService.unlockUser("admin");
            User user = identityService.createUserQuery().userId("admin").singleResult();
            if (user == null) {
                user = identityService.newUser("admin");
                user.setFirstName("Siti");
                user.setLastName("Dibaj");
                user.setEmail("sitidibaj117@mhs.uinjkt.ac.id");
            }
            user.setPassword("admin");
            identityService.saveUser(user);
            identityService.unlockUser("admin");
            System.out.println(">>> Camunda Admin Initialized! checkPassword: " + identityService.checkPassword("admin", "admin"));
        } catch (Exception e) {
            System.err.println(">>> Error initAdminUser: " + e.getMessage());
        }
    }

    // ==============================================================
    // 1. ENGINE HEALTH & DEPLOYMENT INFO
    // ==============================================================
    public Map<String, Object> getEngineStatus() {
        Map<String, Object> status = new HashMap<>();
        status.put("engineName", "Camunda Platform BPMN Engine");
        status.put("version", "7.20.0");
        status.put("framework", "Spring Boot 3.1.5 + Java 17");

        List<ProcessDefinition> definitions = repositoryService.createProcessDefinitionQuery().list();
        List<Map<String, String>> defDetails = new ArrayList<>();
        for (ProcessDefinition def : definitions) {
            Map<String, String> item = new HashMap<>();
            item.put("key", def.getKey());
            item.put("name", def.getName());
            item.put("version", String.valueOf(def.getVersion()));
            item.put("id", def.getId());
            defDetails.add(item);
        }
        status.put("deployedDefinitions", defDetails);
        status.put("totalDeployed", defDetails.size());

        long activeHelloInstances = runtimeService.createProcessInstanceQuery().processDefinitionKey(PROCESS_KEY_HELLO).count();
        long activeProposalInstances = runtimeService.createProcessInstanceQuery().processDefinitionKey(PROCESS_KEY_PROPOSAL).count();
        status.put("activeHelloInstances", activeHelloInstances);
        status.put("activeProposalInstances", activeProposalInstances);

        return status;
    }

    // ==============================================================
    // 2. HELLO WORLD WORKFLOW (POIN 2)
    // ==============================================================
    public Map<String, Object> startHelloWorld(String triggeredBy) {
        Map<String, Object> vars = new HashMap<>();
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));
        vars.put("penguji", triggeredBy != null && !triggeredBy.isBlank() ? triggeredBy : "Siti Dibaj Trikusuma (117)");
        vars.put("waktuMulai", time);
        vars.put("pesan", "Hello World! BPMN Engine Camunda 7.20 terintegrasi sukses dengan Spring Boot 3.");

        ProcessInstance instance = runtimeService.startProcessInstanceByKey(PROCESS_KEY_HELLO, vars);

        // Ambil task yang sedang menunggu
        Task task = taskService.createTaskQuery()
                .processInstanceId(instance.getId())
                .singleResult();

        Map<String, Object> result = new HashMap<>();
        result.put("status", "SUCCESS");
        result.put("message", "Instance Hello World BPMN berhasil dibuat!");
        result.put("processInstanceId", instance.getId());
        result.put("processDefinitionId", instance.getProcessDefinitionId());
        result.put("startTime", time);
        if (task != null) {
            result.put("activeTaskId", task.getId());
            result.put("activeTaskName", task.getName());
        }
        return result;
    }

    public List<Map<String, String>> getHelloWorldTasks() {
        List<Task> tasks = taskService.createTaskQuery()
                .processDefinitionKey(PROCESS_KEY_HELLO)
                .orderByTaskCreateTime().desc()
                .list();

        List<Map<String, String>> list = new ArrayList<>();
        for (Task t : tasks) {
            Map<String, Object> vars = taskService.getVariables(t.getId());
            Map<String, String> item = new HashMap<>();
            item.put("taskId", t.getId());
            item.put("taskName", t.getName());
            item.put("processInstanceId", t.getProcessInstanceId());
            item.put("penguji", String.valueOf(vars.getOrDefault("penguji", "-")));
            item.put("waktuMulai", String.valueOf(vars.getOrDefault("waktuMulai", "-")));
            item.put("pesan", String.valueOf(vars.getOrDefault("pesan", "-")));
            list.add(item);
        }
        return list;
    }

    public Map<String, Object> completeHelloWorldTask(String taskId) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        if (task == null) {
            Map<String, Object> error = new HashMap<>();
            error.put("status", "ERROR");
            error.put("message", "Task Hello World dengan ID " + taskId + " tidak ditemukan!");
            return error;
        }

        Map<String, Object> vars = new HashMap<>();
        vars.put("statusVerifikasi", "SUKSES");
        vars.put("waktuSelesai", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        taskService.complete(taskId, vars);

        Map<String, Object> result = new HashMap<>();
        result.put("status", "SUCCESS");
        result.put("message", "Task Hello World (" + task.getName() + ") berhasil diselesaikan!");
        result.put("taskId", taskId);
        return result;
    }

    // ==============================================================
    // 3. STUDI KASUS PROPOSAL SKRIPSI (POIN 3)
    // ==============================================================
    public ProposalDto submitProposal(String nama, String nim, String email,
                                      String judul, String bidang, String calonPembimbing,
                                      String abstrak) {
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

        Map<String, Object> vars = new HashMap<>();
        vars.put("namaMahasiswa", nama != null && !nama.isBlank() ? nama : "Siti Dibaj Trikusuma");
        vars.put("nim", nim != null && !nim.isBlank() ? nim : "117");
        vars.put("email", email != null && !email.isBlank() ? email : "sitidibaj117@mhs.uinjkt.ac.id");
        vars.put("judulProposal", judul != null && !judul.isBlank() ? judul : "Pengembangan Sistem Alur Kerja BPMN untuk Pengajuan Skripsi");
        vars.put("bidangKajian", bidang != null && !bidang.isBlank() ? bidang : "Rekayasa Perangkat Lunak");
        vars.put("calonPembimbing", calonPembimbing != null && !calonPembimbing.isBlank() ? calonPembimbing : "Rizal Broer Bahaweres, S.Kom., M.Sc., Ph.D.");
        vars.put("abstrak", abstrak != null && !abstrak.isBlank() ? abstrak : "Penelitian ini memodelkan dan mengimplementasikan workflow proposal skripsi menggunakan standar BPMN 2.0 dan framework Spring Boot.");
        vars.put("tanggalPengajuan", now);
        vars.put("statusAlur", "Tahap 1: Verifikasi Kelayakan (Sekretaris Prodi)");
        vars.put("catatanSekretaris", "-");
        vars.put("catatanDosen", "-");
        vars.put("catatanKaprodi", "-");
        vars.put("nomorSk", "-");
        vars.put("selesai", false);

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(PROCESS_KEY_PROPOSAL, vars);

        Task activeTask = taskService.createTaskQuery()
                .processInstanceId(processInstance.getId())
                .singleResult();

        ProposalDto dto = ProposalDto.fromVariables(processInstance.getId(), vars);
        if (activeTask != null) {
            dto.setTaskId(activeTask.getId());
            dto.setTaskName(activeTask.getName());
            dto.setTaskAssigneeRole("Sekretaris Prodi");
        }
        return dto;
    }

    public List<ProposalDto> getActiveProposalTasks() {
        List<Task> tasks = taskService.createTaskQuery()
                .processDefinitionKey(PROCESS_KEY_PROPOSAL)
                .orderByTaskCreateTime().desc()
                .list();

        List<ProposalDto> list = new ArrayList<>();
        for (Task t : tasks) {
            Map<String, Object> vars = taskService.getVariables(t.getId());
            ProposalDto dto = ProposalDto.fromVariables(t.getProcessInstanceId(), vars);
            dto.setTaskId(t.getId());
            dto.setTaskName(t.getName());

            // Tentukan peran penanggung jawab berdasarkan task ID di BPMN
            if ("Task_Verifikasi".equals(t.getTaskDefinitionKey())) {
                dto.setTaskAssigneeRole("Sekretaris Prodi");
            } else if ("Task_Review".equals(t.getTaskDefinitionKey())) {
                dto.setTaskAssigneeRole("Dosen Pembimbing");
            } else if ("Task_Approval".equals(t.getTaskDefinitionKey())) {
                dto.setTaskAssigneeRole("Ketua Program Studi (Kaprodi)");
            } else {
                dto.setTaskAssigneeRole("Admin Akademik");
            }

            list.add(dto);
        }
        return list;
    }

    public Map<String, Object> processTask(String taskId, String role, String action, String catatan) {
        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        if (task == null) {
            Map<String, Object> error = new HashMap<>();
            error.put("status", "ERROR");
            error.put("message", "Task dengan ID " + taskId + " tidak ditemukan!");
            return error;
        }

        String processInstanceId = task.getProcessInstanceId();
        Map<String, Object> vars = new HashMap<>();
        String timeNow = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"));

        if ("Task_Verifikasi".equals(task.getTaskDefinitionKey())) {
            vars.put("catatanSekretaris", (catatan != null && !catatan.isBlank()) ? catatan : "Dokumen lengkap dan memenuhi syarat administratif.");
            vars.put("statusAlur", "Tahap 2: Review Substansi (Dosen Pembimbing)");
        } else if ("Task_Review".equals(task.getTaskDefinitionKey())) {
            vars.put("catatanDosen", (catatan != null && !catatan.isBlank()) ? catatan : "Topik disetujui, siap membimbing skripsi mahasiswa.");
            vars.put("statusAlur", "Tahap 3: Persetujuan Akhir & SK (Ketua Prodi)");
        } else if ("Task_Approval".equals(task.getTaskDefinitionKey())) {
            String skNumber = "SK-TI/UINJKT/" + LocalDateTime.now().getYear() + "/" + String.format("%03d", new Random().nextInt(900) + 100);
            vars.put("catatanKaprodi", (catatan != null && !catatan.isBlank()) ? catatan : "SK Pembimbing Skripsi resmi disahkan.");
            vars.put("nomorSk", skNumber);
            vars.put("statusAlur", "Selesai: Proposal Disetujui & SK Terbit (" + skNumber + ")");
            vars.put("selesai", true);
        }

        taskService.complete(taskId, vars);

        // Cek task berikutnya
        Task nextTask = taskService.createTaskQuery()
                .processInstanceId(processInstanceId)
                .singleResult();

        Map<String, Object> response = new HashMap<>();
        response.put("status", "SUCCESS");
        response.put("processInstanceId", processInstanceId);
        response.put("completedTask", task.getName());
        response.put("completedAt", timeNow);
        if (nextTask != null) {
            response.put("nextTask", nextTask.getName());
            response.put("nextTaskId", nextTask.getId());
            response.put("isProcessFinished", false);
        } else {
            response.put("nextTask", "Alur Selesai (End Event)");
            response.put("isProcessFinished", true);
        }
        return response;
    }

    public List<ProposalDto> getAllProposalsHistory() {
        List<HistoricProcessInstance> historicInstances = historyService.createHistoricProcessInstanceQuery()
                .processDefinitionKey(PROCESS_KEY_PROPOSAL)
                .orderByProcessInstanceStartTime().desc()
                .list();

        List<ProposalDto> list = new ArrayList<>();
        for (HistoricProcessInstance hpi : historicInstances) {
            List<HistoricVariableInstance> varInstances = historyService.createHistoricVariableInstanceQuery()
                    .processInstanceId(hpi.getId())
                    .list();

            Map<String, Object> vars = new HashMap<>();
            for (HistoricVariableInstance vi : varInstances) {
                vars.put(vi.getName(), vi.getValue());
            }

            ProposalDto dto = ProposalDto.fromVariables(hpi.getId(), vars);

            // Cek apakah masih ada active task
            Task active = taskService.createTaskQuery().processInstanceId(hpi.getId()).singleResult();
            if (active != null) {
                dto.setTaskId(active.getId());
                dto.setTaskName(active.getName());
                dto.setSelesai(false);
            } else {
                dto.setTaskName("Selesai (SK Terbit)");
                dto.setSelesai(true);
            }

            list.add(dto);
        }
        return list;
    }
}
