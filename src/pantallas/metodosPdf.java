/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pantallas;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceGray;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import java.awt.Desktop;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author regin
 */
public class metodosPdf {
    
    public String ruta=null;
    
    public static void pdfIngreso() {
        try{
            String ruta = "C:\\recibos\\"+ingresosalida.id+"ingreso.pdf";
            PdfWriter pdfWriter= new PdfWriter(ruta);
            PdfDocument pdfDocument=new PdfDocument(pdfWriter);
            pdfDocument.setDefaultPageSize(PageSize.A6);
            Document document=new Document(pdfDocument);
            float threecol=190f;
            float twocol=285f;
            float twocol150=twocol+150;
            float twocolumnWidth[]={twocol150,twocol};
            float fullwidth[]={threecol*3};
            Paragraph onesp=new Paragraph("\n");
            
            Table table= new Table(twocolumnWidth);
            table.addCell(new Cell().add(new Paragraph ("Ingreso")).setFontSize(20f).setBorder(Border.NO_BORDER).setBold());
            Table nestedtable = new Table(new float[]{twocol/2,twocol/2});
            nestedtable.addCell(new Cell().add(new Paragraph("Vehiculo No.")).setBold().setBorder(Border.NO_BORDER));
            nestedtable.addCell(new Cell().add(new Paragraph(""+ingresosalida.id)).setBorder(Border.NO_BORDER));
            
            nestedtable.addCell(new Cell().add(new Paragraph("Fecha de Ingreso.")).setBold().setBorder(Border.NO_BORDER));
            nestedtable.addCell(new Cell().add(new Paragraph(ingresosalida.fechaEntrada)).setFontSize(10f).setBorder(Border.NO_BORDER));
            
            table.addCell(new Cell().add(nestedtable).setBorder(Border.NO_BORDER));
            
            Border gb=new SolidBorder(new DeviceGray(0.5f) ,2f);
            
            Paragraph para1 = new Paragraph("Propietario: "+ingresosalida.propietario);
            Paragraph para2 = new Paragraph("Placa: "+ingresosalida.placa);
            Paragraph para3 = new Paragraph("Fecha de entrada: "+ingresosalida.fechaEntrada);
            
            
            Table divider=new Table(fullwidth);
            divider.setBorder(gb);
            document.add(table);
            document.add(onesp);
            document.add(divider);
            document.add(para1);
            document.add(para2);
            document.add(para3);
            
                        
            System.out.println("\nRECIBO DE INGRESO CREADO");
            document.close();
            try{
                File archivo= new File(ruta);
                Desktop.getDesktop().open(archivo);
            } catch (IOException e) {
            System.out.println("Ocurrió un error al intentar abrir el archivo: " + e.getMessage());}
           
        }catch(Exception e){}
    }
    
    public static void pdfSalida(){
        try{
            String ruta = "C:\\recibos\\"+ingresosalida.id+"salida.pdf";
            PdfWriter pdfWriter= new PdfWriter(ruta);
            PdfDocument pdfDocument=new PdfDocument(pdfWriter);
            pdfDocument.setDefaultPageSize(PageSize.A6);
            Document document=new Document(pdfDocument);
            float threecol=190f;
            float twocol=285f;
            float twocol150=twocol+150;
            float twocolumnWidth[]={twocol150,twocol};
            float fullwidth[]={threecol*3};
            Paragraph onesp=new Paragraph("\n");
            
            Table table= new Table(twocolumnWidth);
            table.addCell(new Cell().add(new Paragraph ("Salida")).setFontSize(20f).setBorder(Border.NO_BORDER).setBold());
            Table nestedtable = new Table(new float[]{twocol/2,twocol/2});
            nestedtable.addCell(new Cell().add(new Paragraph("Vehiculo No.")).setBold().setBorder(Border.NO_BORDER));
            nestedtable.addCell(new Cell().add(new Paragraph(""+ingresosalida.id)).setBorder(Border.NO_BORDER));
            
            nestedtable.addCell(new Cell().add(new Paragraph("Fecha de Salida.")).setBold().setBorder(Border.NO_BORDER));
            nestedtable.addCell(new Cell().add(new Paragraph(metodos.obtenerFecha())).setFontSize(10f).setBorder(Border.NO_BORDER));
            
            table.addCell(new Cell().add(nestedtable).setBorder(Border.NO_BORDER));
            
            Border gb=new SolidBorder(new DeviceGray(0.5f) ,2f);
            
            Paragraph para1 = new Paragraph("Propietario: "+ingresosalida.propietario);
            Paragraph para2 = new Paragraph("Placa: "+ingresosalida.placa);
            Paragraph para3 = new Paragraph("Fecha de salida: "+metodos.obtenerFecha());
            Paragraph para4 = new Paragraph("Precio a pagarr: "+ingresosalida.costoFinal);
            
            
            Table divider=new Table(fullwidth);
            divider.setBorder(gb);
            document.add(table);
            document.add(onesp);
            document.add(divider);
            document.add(para1);
            document.add(para2);
            document.add(para3);
            document.add(para4);
            
                        
            System.out.println("\nRECIBO DE SALIDA CREADO");
            document.close();
            try{
                File archivo= new File(ruta);
                Desktop.getDesktop().open(archivo);
            } catch (IOException e) {
            System.out.println("Ocurrió un error al intentar abrir el archivo: " + e.getMessage());}
        }catch(Exception e){}
    }
    
}
