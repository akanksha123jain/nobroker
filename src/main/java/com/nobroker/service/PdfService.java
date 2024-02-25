package com.nobroker.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.nobroker.entity.User;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class PdfService {

    public byte[] generatePdfReport(List<User> userList) throws DocumentException {
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter.getInstance(document, baos);

        document.open();
        //document.add(new Paragraph("User Report"));

//        for (User user : userList) {
//            document.add(new Paragraph("Id: " + user.getId()));
//            document.add(new Paragraph("Name: " + user.getName()));
//            document.add(new Paragraph("Email: " + user.getEmail()));
//            document.add(new Paragraph("Mobile: " + user.getMobile()));
//
//            document.add(new Paragraph("------------------------------------"));
//        }
//        document.close();
//
//        return baos.toByteArray();
//
//
        PdfPTable table = new PdfPTable(5);
        addTableHeader(table);

        for (User user : userList) {
            addTableRow(table, user);
        }

        document.add(table);
        document.close();
        return baos.toByteArray();
    }
    private void addTableHeader(PdfPTable table){
            table.addCell("ID");
            table.addCell("Name");
            table.addCell("Email");
            table.addCell("Mobile");
            table.addCell("Email Verified");
    }

    private void addTableRow(PdfPTable table, User user) {
        table.addCell(String.valueOf(user.getId()));
        table.addCell(user.getName());
        table.addCell(user.getEmail());
        table.addCell(user.getMobile());
        table.addCell(String.valueOf(user.isEmailVerified()));
    }
}
