package com.sinaapp.moyun.control;

import com.sinaapp.moyun.model.po.User;
import com.sinaapp.moyun.service.imp.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Moy on ÎåÔÂ24  024.
 *
 */
@Controller
@RequestMapping(value = "/User")
public class UserControl {


    private @Autowired
    UserServiceImp service;

    @RequestMapping(value = "/queryAll")
    public @ResponseBody Object queryAll() {
        return service.queryAll();
    }

    @RequestMapping(value = "/save")
    public String save(@ModelAttribute User user) {
        service.save(user);
        return "";
    }

    @RequestMapping(value = "/queryByName")
    public @ResponseBody Object queryByName(@RequestParam("name") String name) {
        return service.queryByName(name);
    }

    @RequestMapping(value = "/deleteById")
    public String deleteById(@RequestParam Integer id) {
        service.delete(id);
        return "";
    }

    @RequestMapping(value = "/delete")
    public String delete(@ModelAttribute User user) {
        service.delete(user);
        return "";
    }


}
