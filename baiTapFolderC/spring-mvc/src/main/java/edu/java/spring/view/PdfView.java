package edu.java.spring.view;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import edu.java.spring.controller.JavaClazz;
import edu.java.spring.controller.Student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class PdfView extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws DocumentException {
        JavaClazz clazz = (JavaClazz) model.get("clazzObj");
        PdfPTable talbe = new PdfPTable(3);
        talbe.setWidthPercentage(100.0f);
        talbe.setWidths(new float[]{2.0f, 3.0f, 1.5f});
        talbe.setSpacingBefore(10);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.WHITE);
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(BaseColor.CYAN);
        cell.setPadding(5);
        cell.setPhrase(new Phrase("ID", font));
        talbe.addCell(cell);
        cell.setPhrase(new Phrase("Name", font));
        talbe.addCell(cell);
        cell.setPhrase(new Phrase("Age", font));
        talbe.addCell(cell);
        talbe.completeRow();
        for (Student stu : clazz.getStudents()) {
            talbe.addCell(String.valueOf(stu.getId()));
            talbe.addCell(stu.getName());
            talbe.addCell(String.valueOf(stu.getAge()));
            talbe.completeRow();
        }
        doc.add(talbe);
    }
}
