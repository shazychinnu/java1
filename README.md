Sub FindMolCells()
    Dim ws As Object
    Dim r As Long
    Dim c As Long
    Dim found As String
    Dim val As String
    
    For Each ws In ThisWorkbook.Sheets
        For r = 1 To 100
            For c = 1 To 20
                val = ""
                On Error Resume Next
                val = CStr(ws.Cells(r, c).Value)
                On Error GoTo 0
                If InStr(val, "##MOL##") > 0 Then
                    found = found & "Sheet:" & ws.Name & _
                            " Row:" & r & " Col:" & c & Chr(10)
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