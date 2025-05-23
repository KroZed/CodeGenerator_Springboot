package com.prj.controller;
import com.prj.common.ControllerBase;
import com.prj.persistence.EntityHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/front")
public class FrontController extends ControllerBase {
	private static final Integer PAGE_SIZE = 9999;
	@Autowired
	private EntityHelper entityHelper;
	private static final String PREFIX = "front/";
	@RequestMapping("/index")
	public String index(Model model) {
		setCommonData(model);
		return PREFIX + "index";
	}
	@RequestMapping("/login")
	public String login(Model model) {
		setCommonData(model);
		return PREFIX + "login";
	}
	@RequestMapping("/logout")
	public String logout(Model model) {
		request.getSession().invalidate();
		setCommonData(model);
		return PREFIX + "index";
	}
	@RequestMapping("/register")
	public String register(Model model) {
		setCommonData(model);
		return PREFIX + "register";
	}
	protected void setCommonData(Model model) {
	}
	@RequestMapping("/show")
	public String show(@RequestParam(value = "id", required = false) Long id, @RequestParam(value = "page", required = true) String page, Model model) {
		setCommonData(model);
		model.addAttribute("projectName", "定制化代码生成系统");
		model.addAttribute("id", id);
		return PREFIX + page;
	}
}
