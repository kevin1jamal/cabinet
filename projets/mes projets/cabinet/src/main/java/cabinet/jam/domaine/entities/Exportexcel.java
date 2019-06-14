package cabinet.jam.domaine.entities;

import java.util.List;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import cabinet.jam.service.IService;
 

public class Exportexcel extends AbstractXlsView {

	@Autowired
	private IService service;
	
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
	 HttpServletResponse response) throws Exception {
	  
	 response.setHeader("Content-Disposition", "attachment;filename=\"student.xls\"");
	 List<Requerant> listerequerant= service.getAllrequerantService();
	 Sheet sheet = workbook.createSheet("Requerant Data");
	 Row header = sheet.createRow(0);
	 header.createCell(0).setCellValue("Requerant ID");
	 header.createCell(1).setCellValue("Requerant Nom");
	 header.createCell(2).setCellValue("Requerant Prenom");
	 header.createCell(3).setCellValue("Requerant Tel");
	  
	 int rowNum = 1;
	 for(Requerant req:listerequerant){
	 Row row = sheet.createRow(rowNum++);
	 row.createCell(0).setCellValue(req.getId());
	 row.createCell(1).setCellValue(req.getNom());
	 row.createCell(2).setCellValue(req.getPrenom());
	 row.createCell(2).setCellValue(req.getTel());
	 }
	 }	
	
	
}
