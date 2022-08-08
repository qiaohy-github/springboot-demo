package com.example.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.api.Condition;
import com.example.demo.api.Query;
import com.example.demo.api.R;
import com.example.demo.entity.Employee;
import com.example.demo.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;

@RestController //相当于 @Controller 和 @ResponseBody
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    @GetMapping("/page")
    public R<IPage<Employee>> page(Query query, Employee employee){

        IPage<Employee> page = employeeService.page(Condition.getPage(query), Wrappers.<Employee>lambdaQuery()
            .eq(StringUtils.isNotBlank(employee.getName()), Employee::getName, employee.getName())
            .eq(StringUtils.isNotBlank(employee.getHonorsAwards()), Employee::getHonorsAwards, employee.getHonorsAwards())
            .orderByDesc(StringUtils.isBlank(query.getDescs()) && StringUtils.isBlank(query.getAscs()), Employee::getUpdateTime));

        return R.data(page);
    }

    /**
     * 详情
     */
    @GetMapping("/detail") //相当于 @RequestMapping(method = {RequestMethod.GET})
    public R<Employee> detail(Long id) {
        if(id == null){
            return R.fail("id 不能为空！");
        }
        Employee detail = employeeService.getById(id);
        return R.data(detail);
    }

    /**
     * 新增或修改
     */
    @PostMapping("/submit") //相当于 @RequestMapping(method = {RequestMethod.POST})
    public R submit(@RequestBody Employee employee) { //
        if(employee == null){
            return R.fail("employee不能为null！");
        }
        if(employee.getId() == null){
            employee.setCreateTime(new Date());
            employee.setUpdateTime(new Date());
        }else{
            employee.setUpdateTime(new Date());
        }
        return R.status(employeeService.saveOrUpdate(employee));
    }

    /**
     * 删除
     */
    @DeleteMapping("/remove")
    public R remove(String ids) {
        if(StringUtils.isBlank(ids) || ids.split(",").length <= 0){
            return R.fail("ids 不能为空！");
        }
        return R.status(employeeService.remove(Wrappers.<Employee>lambdaQuery()
            .in(Employee::getId, ids.split(","))));
    }




    File file = new File("D:\\1.txt");
    //private final String DATAFILEPATH = "/files/data/";

    @GetMapping("/test")
    public List<Employee> test(HttpServletRequest request){

        //HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        //ServletContext context = request.getSession().getServletContext();

       /* int idx = (int) (Math.random() * 27);
        File file = new File(context.getRealPath("/") + DATAFILEPATH
                + "data_" + UUID.randomUUID().toString().replace("-", "").substring(idx, idx + 6) + ".txt");
        if (!file.exists()) {
            file.mkdirs();
        }*/

        Employee bean = new Employee();
        bean.setId(1234l);
        bean.setName("张三");
        bean.setBirthday(new Date());

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            //这里的定义fos要在Try外面创建，方便在Finally里面释放，IO记得要释放，容易忘记，而分配空间则需要在try内捕捉异常，
            //oos.writeObject("{\"id\":1234,\"name\":\"张三\",\"gender\":null,\"birthday\":\"2021-11-07T07:54:48.467+00:00\",\"nation\":null,\"nativePlace\":null,\"birthplace\":null,\"idCard\":null,\"workTime\":null,\"politicsStatus\":null,\"education\":null,\"workUnit\":null,\"positionRank\":null,\"grantRewards\":null,\"honorsAwards\":null,\"resume\":null}");

            oos.writeObject(bean);
            //write括号内写入你要存储的信息
            oos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    @GetMapping("/test2")
    public Employee test2(HttpServletRequest request){

        ServletContext context = request.getSession().getServletContext();
        //File file = new File(context.getRealPath("/") + DATAFILEPATH);

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Employee employee = null;

        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            //if (obj instanceof Employee) {
                employee = (Employee) obj;
            //}
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return employee;
    }

    @GetMapping("/test3")
    public List<Employee> test3(){

        return null;
    }

}
