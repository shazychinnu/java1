Sub FindMolCells()
    Dim ws As Object
    Dim r As Long, c As Long
    Dim found As String
    
    For Each ws In ThisWorkbook.Sheets
        For r = 1 To ws.UsedRange.Rows.Count
            For c = 1 To ws.UsedRange.Columns.Count
                On Error Resume Next
                Dim val As String
                val = CStr(ws.Cells(r, c).Value)
                On Error GoTo 0
                If InStr(val, "##MOL##") > 0 Then
                    found = found & "Sheet:" & ws.Name & " Row:" & r & " Col:" & c & Chr(10)
                End If
            Next c
        Next r
    Next ws
    
    If found = "" Then
        MsgBox "No ##MOL## found in any cell!"
    Else
        MsgBox "Found ##MOL## in:" & Chr(10) & found
    End If
End Sub