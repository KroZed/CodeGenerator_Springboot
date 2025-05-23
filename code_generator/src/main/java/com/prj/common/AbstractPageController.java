package com.prj.common;
import com.prj.config.ProjectConfig;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public abstract class AbstractPageController extends ControllerBase {
    protected abstract String getPrefix();
    protected abstract String getEntityTitle();
    protected abstract void setListModel(Model model);
    protected abstract void setShowListModel(Model model);
    protected abstract void setDisplayModel(Long id, Model model);
    protected abstract void setShowModel(Long id, Model model);
    protected abstract void setAddModel(Model model);
    protected abstract void setEditModel(Long id, Model model);
    protected abstract void setCommonModel(Long id, Model model);
    @RequestMapping("/list")
    public String list(Model model) {
        model.addAttribute("projectName", ProjectConfig.getProjectName());
        model.addAttribute("entityTitle", getEntityTitle());
        setCommonModel(null, model);
        setListModel(model);
        return getPrefix() + "_list";
    }
    @RequestMapping("/display/{id}")
    public String display(@PathVariable("id") Long id, Model model) {
        model.addAttribute("projectName", ProjectConfig.getProjectName());
        model.addAttribute("entityTitle", getEntityTitle());
        model.addAttribute("id", id);
        setCommonModel(id, model);
        setDisplayModel(id, model);
        return getPrefix() + "_display";
    }
    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("projectName", ProjectConfig.getProjectName());
        model.addAttribute("entityTitle", getEntityTitle());
        model.addAttribute("id", 0);
        setCommonModel(null, model);
        setAddModel(model);
        return getPrefix() + "_edit";
    }
    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("projectName", ProjectConfig.getProjectName());
        model.addAttribute("entityTitle", getEntityTitle());
        model.addAttribute("id", id);
        setCommonModel(id, model);
        setEditModel(id, model);
        return getPrefix() + "_edit";
    }
    @RequestMapping("/showlist")
    public String showlist(Model model) {
        model.addAttribute("projectName", ProjectConfig.getProjectName());
        model.addAttribute("entityTitle", getEntityTitle());
        setCommonModel(null, model);
        setShowListModel(model);
        return getPrefix() + "_showlist";
    }
    @RequestMapping("/show/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("projectName", ProjectConfig.getProjectName());
        model.addAttribute("entityTitle", getEntityTitle());
        model.addAttribute("id", id);
        setCommonModel(id, model);
        setShowModel(id, model);
        return getPrefix() + "_show";
    }
    protected void setShowPageModel(String page, Long id, Model model){}
    @RequestMapping("/showPage")
    public String show(@RequestParam(value = "id", required = false) Long id, @RequestParam(value = "page", required = true) String page, Model model) {
        model.addAttribute("projectName", ProjectConfig.getProjectName());
        model.addAttribute("entityTitle", getEntityTitle());
        model.addAttribute("id", id);
        setCommonModel(id, model);
        setShowPageModel(page, id, model);
        return getPrefix() + "_" + page;
    }
}
