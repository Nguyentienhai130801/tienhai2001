package vn.codegym.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.codegym.model.Customer;
import vn.codegym.model.RentType;
import vn.codegym.model.Service;
import vn.codegym.service.RentTypeService;
import vn.codegym.service.ServiceService;
import vn.codegym.service.ServiceTypeService;


@Controller
@RequestMapping("/service")
public class ServiceController {
    @Autowired
    ServiceService serviceService;
    @Autowired
    RentTypeService rentTypeService;
    @Autowired
    ServiceTypeService serviceTypeService;

    @GetMapping
    public String pageService(Model model, @PageableDefault(value = 5) Pageable pageable){
        model.addAttribute("service",new Service());
        model.addAttribute("rentTypeList",rentTypeService.findAll());
        model.addAttribute("serviceTypeList",serviceTypeService.findAll());
        model.addAttribute("serviceList", serviceService.getAll(pageable));
        return "service/list-service";
    }
    @PostMapping("/addNew")
    public String addNewCustomer(Service service){
        serviceService.save(service);
        return "redirect:/service";
    }

    @GetMapping("/deleteConfirm/{id}")
    public String deleteConfirm(@PathVariable String id){
        serviceService.delete(id);
        return "redirect:/service";
    }
}
