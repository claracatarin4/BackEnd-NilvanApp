package Gerenciamento.NilvanApp.controller;


import Gerenciamento.NilvanApp.dto.response.DashboardDTOResponse;
import Gerenciamento.NilvanApp.service.DashboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/dashboard")
@CrossOrigin("*")
public class DashboardController {
    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/admin")
    public ResponseEntity<DashboardDTOResponse> obterStatusDashboardAdministrador(){
        return ResponseEntity.ok(dashboardService.obterDashboardAdmin());
    }

    @GetMapping("/operador")
    public ResponseEntity<DashboardDTOResponse> obterStatusDashboardOperador(){
        return ResponseEntity.ok(dashboardService.obterDashboardOperador());
    }
}
