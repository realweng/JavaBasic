package com.javasm.test;
//import com.javasm.entity.base.Admin;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import java.io.FileOutputStream;

/**
 * @Author：wengxingguo
 * @Version：1.0
 * @Date：2021/5/14-19:22
 * @Since:jdk1.8
 * @Description:TODO
 */
public class ExcelTest {
    public static void main(String[] args) {
        readExcel();
    }


//    public static void writeExcel(List<Admin> admins){
//        try(FileOutputStream fileOutputStream = new FileOutputStream(new File("C:\\Users\\Administrator\\Desktop\\pn_admin123123.xls"));) {
//            SXSSFWorkbook workbook = new SXSSFWorkbook();
//            Sheet sheet = workbook.createSheet("1");//创建工作表
//            //创建title标题栏
//            Row row = sheet.createRow(0);
//            row.createCell(0).setCellValue("编号");
//            row.createCell(1).setCellValue("用户名");
//            row.createCell(2).setCellValue("角色编号");
//            row.createCell(3).setCellValue("状态");
//            row.createCell(4).setCellValue("图片");
//
//            for (int i = 1; i <= admins.size(); i++) {
//                Admin admin = admins.get(i - 1);
//                row = sheet.createRow(i);
//                Cell cell = row.createCell(0);
//                cell.setCellValue(admin.getId());
//                cell = row.createCell(1);
//                cell.setCellValue(admin.getUsername());
//                cell = row.createCell(2);
//                cell.setCellValue(admin.getRoleId());
//                cell = row.createCell(3);
//                cell.setCellValue(admin.getState());
//                cell = row.createCell(4);
//                cell.setCellValue(admin.getHeadImg());
//            }
//            workbook.write(fileOutputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    public static void readExcel(){
//        List<Admin> admins = new ArrayList<>();
//        try {
//            //创建工作簿对象
//            Workbook workbook = WorkbookFactory.create(new File("C:\\Users\\Administrator\\Desktop\\pn_admin.xls"));
//            //获取当前工作簿的sheet数量
//            int numberOfSheets = workbook.getNumberOfSheets();
//            for (int i = 0; i < numberOfSheets; i++) {
//                //根据索引获取sheet对象
//                Sheet sheetAt = workbook.getSheetAt(i);
//                //获取当前sheet的总数据条数
//                int lastRowNum = sheetAt.getLastRowNum();
//                for (int j = 1; j <= lastRowNum; j++) {
//                    Admin admin = new Admin();
//                    //获取指定行
//                    Row row = sheetAt.getRow(j);
//                    Cell cell0 = row.getCell(0); //id
//                    if (cell0 != null) {
//                        String stringCellValue = parseDateType(cell0);
//                        admin.setId(Integer.parseInt(stringCellValue));
//                    }
//                    Cell cell1 = row.getCell(1); //username
//                    if(cell1 != null){
//                        String stringCellValue = parseDateType(cell1);
//                        admin.setUsername(stringCellValue);
//                    }
//                    Cell cell2 = row.getCell(2); //roleid
//                    if(cell2 != null){
//                        String stringCellValue = parseDateType(cell2);
//                        admin.setRoleId(Integer.parseInt(stringCellValue));
//                    }
//                    Cell cell3 = row.getCell(3); //pwd
//                    if(cell3 != null){
//                        String stringCellValue = parseDateType(cell3);
//                        admin.setPwd(stringCellValue);
//                    }
//                    Cell cell4 = row.getCell(4); //state
//                    if(cell4 != null){
//                        String numericCellValue = parseDateType(cell4);
//                        admin.setState(Integer.parseInt(numericCellValue));
//                    }
//                    Cell cell5 = row.getCell(5); //tuxiang
//                    if(cell5 != null){
//                        String stringCellValue = parseDateType(cell5);
//                        admin.setHeadImg(stringCellValue);
//                    }
//                    admins.add(admin);
//                    System.out.println(admin);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InvalidFormatException e) {
//            e.printStackTrace();
//        }
//        System.out.println(admins);
        //保存到数据库
        //单个添加(效率极低)
//        admins.forEach(admin -> {
//            save(admin);
//        });
        //将list截取[使用list的长度除1000,取1000的余数大于0则页码+1]. 使用页码范围循环.
//        writeExcel(admins);
    }


    public static String parseDateType(Cell cell){
        int cellType = cell.getCellType();
        String value = null;
        switch (cellType){
            case Cell.CELL_TYPE_STRING :
                value = cell.getStringCellValue();
                break;
            case Cell.CELL_TYPE_NUMERIC :
                value = (int)cell.getNumericCellValue() + "";
                break;
        }
        return value;
    }
}