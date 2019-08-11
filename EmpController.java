package com.sxt.controller;

import com.sxt.pojo.Emp;
import com.sxt.service.EmpService;
import com.sxt.util.EasyUIDataGridResult;
import com.sxt.util.JspResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    /**
     * 跳转页面
     * @param page
     * @return
     */
    @RequestMapping("/{page}" )
    public  String toJsp(@PathVariable String  page){
        return page;
    }

    @RequestMapping("add")
    @ResponseBody
    public JspResult addEmp(Emp e){

        JspResult jspResult = empService.addEmp(e);
        return jspResult;
    }



     @RequestMapping("/listP")
     @ResponseBody
   public EasyUIDataGridResult LostEmpPage(String ename,int page,int rows){
         EasyUIDataGridResult result = empService.ListEmpPage(ename,page, rows);
         return result;
     }
@RequestMapping("/del")
@ResponseBody
     public JspResult delCheckBox(Integer[]  ids){

    JspResult jspResult = new JspResult();
    for ( int i=0;i<ids.length;i++){
        int i1 = empService.delEmp(ids[i]);
        if(i1 ==0){
            return jspResult.errorMe("操作失败");
        }
    }
       return  jspResult.ok();
     }

     @RequestMapping("/update")
     @ResponseBody
     public JspResult updateEmp(Emp e){
     return      empService.updateEmp(e);
     }

}
