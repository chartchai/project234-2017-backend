package camt.se234.project.utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.ss.util.CellUtil;

public class AbstractDataLoadFromXlsx {
    protected String getCellData(Row row, String col) {
        int colIdx = CellReference.convertColStringToIndex(col);
        return getCellData(row, colIdx);
    }

    protected String getCellData(Row row, int colIndx) {
        Cell cell = CellUtil.getCell(row, colIndx);
        if (cell.getCellTypeEnum().equals(CellType.STRING)) {
            if (cell.getStringCellValue().equals("NULL"))
                return "";
            return cell.getStringCellValue();
        } else if (cell.getCellTypeEnum().equals(CellType.NUMERIC)) {
            cell.setCellType(CellType.STRING);
            return cell.getStringCellValue();
        }
        return "";
    }


    protected String getCellFormulaData(Row row, int colIndx, FormulaEvaluator evaluator){
        Cell cell = CellUtil.getCell(row, colIndx);
        if (cell.getCellTypeEnum() == CellType.FORMULA){
            CellValue cellValue = evaluator.evaluate(cell);
            return cellValue.getStringValue();
        }else {
            return getCellData(row,colIndx);
        }
    }

    protected String getCellFormulaData(Row row, String col, FormulaEvaluator evaluator){
        int colIdx = CellReference.convertColStringToIndex(col);
        return getCellFormulaData(row, colIdx,evaluator);
    }
    protected Integer parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    protected Object getAnyType(Row row, int colIndx) {
        Cell cell = row.getCell(colIndx);
        switch (cell.getCellTypeEnum()) {
            case STRING:
                if (cell.getStringCellValue().equals("NULL"))
                    return null;
                else
                    return getCellData(row,colIndx);
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue();
                } else {
                    return cell.getNumericCellValue();
                }
        }
        return getCellData(row,colIndx);
    }

    protected Object getAnyType(Row row, String col) {
        int colIdx = CellReference.convertColStringToIndex(col);
        return getAnyType(row,colIdx);
    }
}
