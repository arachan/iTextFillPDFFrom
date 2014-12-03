/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yusuke.itextfillpdfform;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *PDFフォームに任意の値を入れる
 * 
 * @author yusuke
 */
public class ITextPDFForm {
    
    public static final String pdfform="C:/Users/yusuke/pdfform.pdf";
    public static final String fillpdfform="C:/Users/yusuke/fillpdfform.pdf"; 
    
    public void manipulatePdf(String src,String dest)throws IOException,DocumentException{
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader,new FileOutputStream(dest));
        AcroFields form = stamper.getAcroFields();
        //フォームにテキストを挿入する処理
        form.setField("name", "荒川さん"); //TextBox
        form.setField("gender","男"); //ListBox
        stamper.close();
    }

    /**
     * @param args the command line arguments
     * @throws com.itextpdf.text.DocumentException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws DocumentException, IOException {
        // TODO code application logic here
        ITextPDFForm example = new ITextPDFForm();
        example.manipulatePdf(pdfform,fillpdfform);
    }
}
