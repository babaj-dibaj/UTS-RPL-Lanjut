package com.uts.rpllanjut.controller;

import com.uts.rpllanjut.model.ProposalDto;
import com.uts.rpllanjut.service.BpmnWorkflowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class WorkflowApiController {

    private final BpmnWorkflowService workflowService;

    public WorkflowApiController(BpmnWorkflowService workflowService) {
        this.workflowService = workflowService;
    }

    @GetMapping("/engine-status")
    public ResponseEntity<Map<String, Object>> getEngineStatus() {
        return ResponseEntity.ok(workflowService.getEngineStatus());
    }

    // ================== HELLO WORLD (POIN 2) ==================
    @PostMapping("/hello-world/start")
    public ResponseEntity<Map<String, Object>> startHelloWorld(@RequestBody(required = false) Map<String, String> body) {
        String triggeredBy = body != null ? body.get("triggeredBy") : null;
        return ResponseEntity.ok(workflowService.startHelloWorld(triggeredBy));
    }

    @GetMapping("/hello-world/tasks")
    public ResponseEntity<List<Map<String, String>>> getHelloWorldTasks() {
        return ResponseEntity.ok(workflowService.getHelloWorldTasks());
    }

    @PostMapping("/hello-world/complete")
    public ResponseEntity<Map<String, Object>> completeHelloWorldTask(@RequestBody Map<String, String> body) {
        String taskId = body.get("taskId");
        return ResponseEntity.ok(workflowService.completeHelloWorldTask(taskId));
    }

    // ================== STUDI KASUS PROPOSAL SKRIPSI (POIN 3) ==================
    @PostMapping("/proposals/submit")
    public ResponseEntity<ProposalDto> submitProposal(@RequestBody Map<String, String> payload) {
        String nama = payload.get("nama");
        String nim = payload.get("nim");
        String email = payload.get("email");
        String judul = payload.get("judul");
        String bidang = payload.get("bidang");
        String pembimbing = payload.get("pembimbing");
        String abstrak = payload.get("abstrak");

        ProposalDto dto = workflowService.submitProposal(nama, nim, email, judul, bidang, pembimbing, abstrak);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/proposals/active-tasks")
    public ResponseEntity<List<ProposalDto>> getActiveTasks() {
        return ResponseEntity.ok(workflowService.getActiveProposalTasks());
    }

    @PostMapping("/proposals/process-task")
    public ResponseEntity<Map<String, Object>> processTask(@RequestBody Map<String, String> payload) {
        String taskId = payload.get("taskId");
        String role = payload.get("role");
        String action = payload.get("action");
        String catatan = payload.get("catatan");

        Map<String, Object> result = workflowService.processTask(taskId, role, action, catatan);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/proposals/history")
    public ResponseEntity<List<ProposalDto>> getProposalHistory() {
        return ResponseEntity.ok(workflowService.getAllProposalsHistory());
    }
}
