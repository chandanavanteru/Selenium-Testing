package multiplefiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class links_titles {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream f=new FileInputStream("D:\\Book2.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(f);
		XSSFSheet ws=wb.getSheet("sheet1");
		Row r=null;
		Cell c=null;
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		ChromeDriver d=new ChromeDriver();
		d.get("https://demo.guru99.com/test/newtours/");
		d.manage().window().maximize();
		WebElement drop=d.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table"));
		List<WebElement> drop1=drop.findElements(By.tagName("a"));
		System.out.println(drop1.size());
		for(int i=0;i<drop1.size();i++)
		{
			System.out.println(drop1.get(i).getText());
			r=ws.createRow(i);
			r.createCell(0).setCellValue(drop1.get(i).getText());
			drop1.get(i);
			if(!drop1.get(i).isSelected())
			{
				r.createCell(1).setCellValue("pass");
			}
			else
			{
				r.createCell(1).setCellValue("fail");
			}
			
		}
		FileOutputStream f1=new FileOutputStream("D://Book2.xlsx");
		wb.write(f1);
		f1.close();

	}

}
