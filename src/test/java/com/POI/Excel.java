package com.POI;


import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author jiejie
 * @date 2020/7/2 22:45
 */
public class Excel {
    String PATH="C:\\Users\\asus\\Desktop\\workplace\\java\\selenium\\src\\test\\java\\com\\POI\\";

    //03HSSFWorkbook
    @Test
    public void tesWrites03() throws Exception {
        //创建一个工作簿
        Workbook workbook = new HSSFWorkbook();
        //创建一个工作表
        Sheet sheet = workbook.createSheet("统计表");
        //创建一个行(1,1)
        Row row1 = sheet.createRow(0);
        //创建一个单元格
        Cell cell11 = row1.createCell(1);
        cell11.setCellValue(666);

        //第二行
        Row row2 = sheet.createRow(1);
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("统计时间");
        //(2,2)
        Cell cell22 = row2.createCell(1);
        String time = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cell22.setCellValue(time);

        //生成一张表(IO流)   03版本就是使用xls结尾
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "统计表03.xls");
        workbook.write(fileOutputStream);
        //关闭流
        fileOutputStream.close();
    }
    @Test
    //07XSSFWorkbook
    public void tesWrites07() throws IOException {
        //创建一个工作簿
        Workbook workbook = new XSSFWorkbook();
        //创建一个工作表
        Sheet sheet = workbook.createSheet("统计表");
        //创建一个行(1,1)
        Row row1 = sheet.createRow(0);
        //创建一个单元格
        Cell cell11 = row1.createCell(1);
        cell11.setCellValue(666);

        //第二行
        Row row2 = sheet.createRow(1);
        Cell cell21 = row2.createCell(0);
        cell21.setCellValue("统计时间");
        //(2,2)
        Cell cell22 = row2.createCell(1);
        String time = new DateTime().toString("yyyy-MM-dd HH:mm:ss");
        cell22.setCellValue(time);

        //生成一张表(IO流)   03版本就是使用xlsx结尾
        FileOutputStream fileOutputStream = new FileOutputStream(PATH + "统计表07.xlsx");
        workbook.write(fileOutputStream);
        //关闭流
        fileOutputStream.close();
    }
    @Test
    public void testWrite03BigData() throws IOException {
        //创建一个开始时间
        long begin = System.currentTimeMillis();
        //创建一个薄
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        for (int rowNum = 0; rowNum < 65536; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        System.out.println("over");
        FileOutputStream fileOutputStream = new FileOutputStream(PATH+"testWrite03BigData.xls");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        long end = System.currentTimeMillis();
        System.out.println((double)(end-begin)/1000 );

    }
    //07版需要时间要大于03的
    @Test
    public void testWrite07BigData() throws IOException {
        //创建一个开始时间
        long begin = System.currentTimeMillis();
        //创建一个薄
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        for (int rowNum = 0; rowNum < 65536; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        System.out.println("over");
        FileOutputStream fileOutputStream = new FileOutputStream(PATH+"testWrite07BigData.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        long end = System.currentTimeMillis();
        System.out.println((double)(end-begin)/1000 );

    }
    @Test
    public void testWrite07BigDataS() throws IOException {

        //创建一个开始时间
        long begin = System.currentTimeMillis();
        //创建一个薄
        Workbook workbook = new SXSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        for (int rowNum = 0; rowNum < 65536; rowNum++) {
            Row row = sheet.createRow(rowNum);
            for (int cellNum = 0; cellNum < 10; cellNum++) {
                Cell cell = row.createCell(cellNum);
                cell.setCellValue(cellNum);
            }
        }
        System.out.println("over");
        FileOutputStream fileOutputStream = new FileOutputStream(PATH+"testWrite07BigDataS.xlsx");
        workbook.write(fileOutputStream);
        fileOutputStream.close();
        //清除临时文件
        ((SXSSFWorkbook)workbook).dispose();
        long end = System.currentTimeMillis();
        System.out.println((double)(end-begin)/1000 );
    }
}
