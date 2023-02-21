package com.owls.owlworld.admin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // 라우터생성
    @RequestMapping("/crawling")
    public String crawling() throws InterruptedException {
        adminService.crawling();
        return "Hello Admin";
    }
}
