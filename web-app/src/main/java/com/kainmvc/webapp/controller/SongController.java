package com.kainmvc.webapp.controller;

import com.kainmvc.webapp.dto.SongRequestDto;
import com.kainmvc.webapp.entity.Song;
import com.kainmvc.webapp.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/songs")
public class SongController {
    private final ISongService iSongService;

    public SongController(ISongService iSongService) {
        this.iSongService = iSongService;
    }
    @GetMapping("")
    public String listAll(Model model){
        model.addAttribute("songList",iSongService.findAll());
        return "song/index";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("songRequestDto",new SongRequestDto());
        return "song/add";
    }

    @PostMapping("/add")
    public String validateAdd(@Validated @ModelAttribute SongRequestDto songRequestDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        Song song = new Song();
        new SongRequestDto().validate(songRequestDto,bindingResult);
        if(bindingResult.hasErrors()){
            return "/song/add";
        }
        BeanUtils.copyProperties(songRequestDto,song);
        redirectAttributes.addFlashAttribute("mess","thêm mới thành công");
        iSongService.add(song);
        return "redirect:/songs";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("songRequestDto",iSongService.findById(id));
        return "/song/update";
    }

    @PostMapping("/update")
    public String update(@Validated @ModelAttribute SongRequestDto songRequestDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        Song song = new Song();
        new SongRequestDto().validate(songRequestDto,bindingResult);
        if(bindingResult.hasErrors()){
            return "/song/update";
        }
        BeanUtils.copyProperties(songRequestDto,song);
        redirectAttributes.addFlashAttribute("mess", "cập nhật thành công");
        iSongService.update(song);
        return "redirect:/songs";

    }
}
