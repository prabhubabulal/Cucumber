Set objExcel = CreateObject("Excel.Application")
objExcel.Workbooks.Open("C:\Users\babulalp\eclipse-workspace\cucmber\src\test\java\data\Macros.xlsm")
objExcel.Run "Update", WScript.Arguments.Item(0),WScript.Arguments.Item(1),WScript.Arguments.Item(2)
objExcel.ActiveWorkbook.Close
objExcel.Application.Quit