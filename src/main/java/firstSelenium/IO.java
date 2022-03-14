package firstSelenium;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class IO {

    public static void main(String[] args) throws IOException {




        ArrayList<String> names = new ArrayList<>();
        names.add("Ivan");
        names.add("Oleg");
        names.add("Oksana");
        names.add("Ruslan");
        names.add("Nadija");
        names.add("Yurij");
        names.add("Olena");
        names.add("Anton");
        names.add("Petro");
        names.add("Marichka");

        CSVPrinter(names);
        writeFromCSWtoXXLS("D:\\Anton\\code\\Test\\src\\main\\resources\\test.csv"
                , "D:\\Anton\\code\\Test\\src\\main\\resources\\tesFile.xlsx");

    }

    public static void writeFromCSWtoXXLS(String path, String fileName) throws IOException {


        BufferedReader reader = new BufferedReader(new FileReader(path));
        String s = reader.readLine();
        String[] split = s.split(",");

        Workbook workbook = new XSSFWorkbook();
        Sheet page = workbook.createSheet("page");
        int rowIndex = 0;
        while (rowIndex < split.length) {
            Row row = page.createRow(rowIndex);
            Cell cell = row.createCell(0);
            cell.setCellValue(split[rowIndex]);
            rowIndex++;
        }
        FileOutputStream fos = new FileOutputStream(fileName);
        workbook.write(fos);
        fos.close();


    }


    public static void CSVPrinter(ArrayList arr) throws IOException {
//        Files.deleteIfExists(Paths.get("D:\\Anton\\code\\Test\\src\\main\\resources\\test.csv"));
        BufferedWriter writer = Files
                .newBufferedWriter(Paths.get("D:\\Anton\\code\\Test\\src\\main\\resources\\test.csv"));
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
        if (arr.size() != 0) {
            for (int i = 0; i < arr.size(); i++) {
                csvPrinter.print(arr.get(i));
            }
            csvPrinter.flush();
        }
    }

}
