package com.app.controller.dashboard;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.domain.ToDoList;
import com.app.service.UserService;
import com.app.service.ToDoService;

@Controller
public class UserDashboardController {

    private ToDoService toDoService;
    private UserService userService;

    @Autowired
    public UserDashboardController(ToDoService toDoService, UserService userService) {
        this.toDoService = toDoService;
        this.userService = userService;
    }

    @RequestMapping("/dashboard")
    public String list(Model model) {
        model.addAttribute("todos", toDoService.list());
        return "todo/list";
    }

    @RequestMapping("/user/todo/{id}")
    public String view(@PathVariable Long id, Model model) {
        model.addAttribute("ToDoList", toDoService.get(id));
        return "todo/view";
    }

    // create | save

    @RequestMapping("/user/todo/create")
    public String create(Model model) {
        model.addAttribute("todo", new ToDoList());
        model.addAttribute("users", userService.list());
        return "todo/toDoForm";
    }

    @RequestMapping( value = "user/todo/save", method = RequestMethod.POST )
    public String save(@Valid ToDoList post, BindingResult bindingResult, Model model) {

        if( bindingResult.hasErrors() ){
            model.addAttribute("users", userService.list());
            return "/todo/toDoForm";
        } else {
            ToDoList savedPost = toDoService.save(post);
            return "redirect:/todo/" + savedPost.getId();
        }

    }

    @RequestMapping("/user/todo/edit/{id}")
    public String edit(@PathVariable Long id, Model model){
        model.addAttribute("post", toDoService.get(id));
        model.addAttribute("users", userService.list());
        return "todo/toDoForm";
    }

    @RequestMapping("/user/todo/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes redirectAttrs) {
        toDoService.delete(id);
        redirectAttrs.addFlashAttribute("message", "Post was deleted!");
        return "redirect:/dashboard";
    }

}
