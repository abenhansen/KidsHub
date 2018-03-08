package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;

@Controller
public class HomeController {
    boolean load = true;
    ArrayList<Kid> barn = new ArrayList<>();

    @GetMapping("/")
    public String index (){
        return "index";
    }


    @GetMapping("oplys")
    public String oplys(Model model) throws Exception {
       /* if (barn.size() == 0) {
            barn.add(new Kid(1, "Svend", "Erik", "2", "Lars Larsen", "2121121", new Date()));
        }*/
        if (load) {
            Kid.hentKids("C:\\Users\\abenh\\Desktop\\GardenKinder\\src\\main\\resources\\static\\GemteKids.txt", barn);
            load=false;
        }
        model.addAttribute("barn", barn);
        return "oplys";
    }
    /*

     */

    @GetMapping("/create")
    public String create (Model model) {
        model.addAttribute("kid", new Kid());
        return "create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Kid kid) throws Exception{
        int index = barn.size() + 1;
        kid.setID(index);
        barn.add(kid);
        Kid.GemKid("C:\\Users\\abenh\\Desktop\\GardenKinder\\src\\main\\resources\\static\\GemteKids.txt", barn);
        return "redirect:/oplys";
    }

    @GetMapping("/details")
    public String details(@RequestParam(value = "id", defaultValue = "1") int id, Model model) {
        model.addAttribute("kid", barn.get(id - 1));
        return "details";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(value = "id", defaultValue = "1") int id, Model model) {
        model.addAttribute("kid", barn.get(id - 1));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(@ModelAttribute Kid kid) {
        barn.remove(kid.getID() - 1);
        return "redirect:/oplys";
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(value = "id", defaultValue = "1") int id, Model model) {
        model.addAttribute("kid", barn.get(id - 1));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute Kid kid) {
        int index = kid.getID();
        kid.setID(index);
        barn.set(index -1,kid);
        return "redirect:/oplys";
    }
}

