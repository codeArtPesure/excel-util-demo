package com.dengzhili;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * describe:
 *
 * @author dengzl
 * @date 2019/06/10
 */
@RestController
public class EasyPOIController {

    @RequestMapping("/exportExcel")
    public void export(HttpServletResponse response) throws Exception {
        //模拟数据库数据
        Goods goods1 = new Goods(110, "苹果", 1, new Date(), 0, "1");
        Goods goods2 = new Goods(111, "格子衫", 2, new Date(), 0, "0");
        Goods goods3 = new Goods(112, "拉菲红酒", 3, new Date(), 1, "1");
        Goods goods4 = new Goods(113, "玫瑰", 4, new Date(), 1, "0");

        List<Goods> goodsList = new ArrayList<Goods>();
        goodsList.add(goods1);
        goodsList.add(goods2);
        goodsList.add(goods3);
        goodsList.add(goods4);

        for (Goods goods : goodsList) {
            System.out.println(goods);
        }
        //导出
        FileUtil.exportExcel(goodsList,Goods.class,"商品.xls",response);
    }

    @RequestMapping("/importExcel")
    public void importExcel() throws NormalException {
        String filePath = "/Users/dengzhili/Downloads/商品.xls";
        //解析excel，
        List<Goods> goodsList = FileUtil.importExcel(filePath,0,1,Goods.class);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【"+goodsList.size()+"】行");

        //TODO 保存数据库
        for (Goods goods:goodsList) {
            System.out.println(goods);
        }
    }

}
