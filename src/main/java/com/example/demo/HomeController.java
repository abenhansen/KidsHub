package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {
    boolean load = true;
    boolean load2 = true;
    ArrayList<Kid> barn = new ArrayList<>();
    ArrayList<Employee> employees = new ArrayList<Employee>();

    @GetMapping("/")
    public String index (){
        return "index";
    }

    @GetMapping("index")
    public String indexredirect (){
        return "index";
    }


    @GetMapping("oplysKid")
    public String oplysKid(Model model) throws Exception {
       /* if (barn.size() == 0) {
            barn.add(new Kid(1, "Svend", "Erik", "2", "Lars Larsen", "2121121", new Date()));
        }*/
        if (load) {
            Kid.hentKids("C:\\Users\\abenh\\Desktop\\GardenKinder\\src\\main\\resources\\static\\GemteKids.txt", barn);
            load=false;
        }
        model.addAttribute("barn", barn);
        return "oplysKid";
    }
    /*

     */

    @GetMapping("/createKid")
    public String createKid (Model model) {
        model.addAttribute("kid", new Kid());
        return "createKid";
    }

    @PostMapping("/createKid")
    public String createKid(@ModelAttribute Kid kid) throws Exception{
        int index = barn.size() + 1;
        kid.setID(index);
        barn.add(kid);
        Kid.GemKid("C:\\Users\\abenh\\Desktop\\GardenKinder\\src\\main\\resources\\static\\GemteKids.txt", barn);
        return "redirect:/oplysKid";
    }

    @GetMapping("/detailsKid")
    public String detailsKid(@RequestParam(value = "id", defaultValue = "1") int id, Model model) {
        model.addAttribute("kid", barn.get(id - 1));
        return "detailsKid";
    }

    @GetMapping("/deleteKid")
    public String deleteKid(@RequestParam(value = "id", defaultValue = "1") int id, Model model) {
        model.addAttribute("kid", barn.get(id - 1));
        return "deleteKid";
    }

    @PostMapping("/deleteKid")
    public String deleteKid(@ModelAttribute Kid kid) throws Exception {
        barn.remove(kid.getID() - 1);
        Kid.GemKid("C:\\Users\\abenh\\Desktop\\GardenKinder\\src\\main\\resources\\static\\GemteKids.txt", barn);
        return "redirect:/oplysKid";
    }

    @GetMapping("/editKid")
    public String editKid(@RequestParam(value = "id", defaultValue = "1") int id, Model model) {
        model.addAttribute("kid", barn.get(id - 1));
        return "editKid";
    }

    @PostMapping("/editKid")
    public String editKid(@ModelAttribute Kid kid) throws Exception {
        int index = kid.getID();
        kid.setID(index);
        barn.set(index -1,kid);
        Kid.GemKid("C:\\Users\\abenh\\Desktop\\GardenKinder\\src\\main\\resources\\static\\GemteKids.txt", barn);
        return "redirect:/oplysKid";
    }

    @GetMapping("oplysEmp")
    public String oplysEmp(Model model) throws Exception {
       /* if (barn.size() == 0) {
            barn.add(new Kid(1, "Svend", "Erik", "2", "Lars Larsen", "2121121", new Date()));
        }*/
        if (load2) {
            Employee.hentEmp("C:\\Users\\abenh\\Desktop\\GardenKinder\\src\\main\\resources\\static\\GemteEmp.txt", employees);
            load2=false;
        }
        model.addAttribute("employees", employees);
        return "oplysEmp";
    }
    /*

     */

    @GetMapping("/createEmp")
    public String createEmp (Model model) {
        model.addAttribute("employee", new Employee());
        return "createEmp";
    }

    @PostMapping("/createEmp")
    public String createEmp(@ModelAttribute Employee employee) throws Exception{
        int index = employees.size() + 1;
        employee.setID(index);
        employees.add(employee);
        Employee.GemEmp("C:\\Users\\abenh\\Desktop\\GardenKinder\\src\\main\\resources\\static\\GemteEmp.txt", employees);
        return "redirect:/oplysEmp";
    }

    @GetMapping("/detailsEmp")
    public String detailsEmp(@RequestParam(value = "id", defaultValue = "1") int id, Model model) {
        model.addAttribute("employee", employees.get(id - 1));
        return "detailsEmp";
    }

    @GetMapping("/deleteEmp")
    public String deleteEmp(@RequestParam(value = "id", defaultValue = "1") int id, Model model) {
        model.addAttribute("employee", employees.get(id - 1));
        return "deleteEmp";
    }

    @PostMapping("/deleteEmp")
    public String deleteEmp(@ModelAttribute Employee employee) throws Exception {

        Employee.GemEmp("C:\\Users\\abenh\\Desktop\\GardenKinder\\src\\main\\resources\\static\\GemteEmp.txt", employees);
        return "redirect:/oplysEmp";
    }

    @GetMapping("/editEmp")
    public String editEmp(@RequestParam(value = "id", defaultValue = "1") int id, Model model) {
        model.addAttribute("employee", employees.get(id - 1));
        return "editEmp";
    }

    @PostMapping("/editEmp")
    public String editEmp(@ModelAttribute Employee employee) throws Exception {
        int index = employee.getID();
        employee.setID(index);
        employees.set(index -1,employee);
        Employee.GemEmp("C:\\Users\\abenh\\Desktop\\GardenKinder\\src\\main\\resources\\static\\GemteEmp.txt", employees);
        return "redirect:/oplysEmp";
    }
}

