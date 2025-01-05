package com.example.demo.controller;

import com.example.demo.service.DateTimeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/date")
public class DateController {

    private DateTimeService dateTimeService;

    public DateController(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }

    @GetMapping
    public String getDatePage(Model model) {
        String date = dateTimeService.getMoscowDate();
        String time = dateTimeService.getMoscowTime();

        model.addAttribute("date", date);
        model.addAttribute("time", time);
        return "date";
    }
}
