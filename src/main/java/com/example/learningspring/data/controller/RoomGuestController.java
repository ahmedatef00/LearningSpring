package com.example.learningspring.data.controller;


import com.example.learningspring.business.domain.RoomGuest;
import com.example.learningspring.business.service.GuestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/guests")
public class RoomGuestController {
    public final GuestService geustService;

    public RoomGuestController(GuestService geustService) {
        this.geustService = geustService;
    }

    @GetMapping
    public String getGuest(Model model) {
        List<RoomGuest> roomGuests = this.geustService.getAllGuests();
        model.addAttribute("roomGuests", roomGuests);
        return "guests";

    }
}
