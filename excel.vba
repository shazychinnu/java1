Private Sub Workbook_SheetBeforeDoubleClick(ByVal Sh As Object, ByVal Target As Range, Cancel As Boolean)
    
    Dim cellText As String
    Dim markerPos As Long
    
    On Error Resume Next
    cellText = CStr(Target.Value)
    On Error GoTo 0
    
    ' Debug — show what cell was clicked and its value
    MsgBox "Clicked: " & Target.Address & Chr(10) & _
           "Value length: " & Len(cellText) & Chr(10) & _
           "Has ##MOL##: " & (InStr(cellText, "##MOL##") > 0) & Chr(10) & _
           "First 50 chars: " & Left(cellText, 50), _
           vbInformation, "Debug"
    
    markerPos = InStr(cellText, "##MOL##")
    
    If markerPos > 0 Then
        Cancel = True
        
        Dim compoundId As String
        Dim molText As String
        Dim molPath As String
        Dim fileNum As Integer
        
        compoundId = Trim(Replace(Left(cellText, markerPos - 1), Chr(10), ""))
        molText    = Mid(cellText, markerPos + 8)
        molPath    = Environ("TEMP") & "\" & compoundId & ".mol"
        
        ' Debug mol info
        MsgBox "CompoundId: " & compoundId & Chr(10) & _
               "Mol length: " & Len(molText) & Chr(10) & _
               "Mol path: " & molPath, _
               vbInformation, "Debug mol"
        
        ' Save mol to temp file
        fileNum = FreeFile
        Open molPath For Output As #fileNum
        Print #fileNum, molText
        Close #fileNum
        
        ' Remove existing PNG
        Dim shp As Shape
        For Each shp In Sh.Shapes
            If Not Intersect(shp.TopLeftCell, Target) Is Nothing Then
                shp.Delete
                Exit For
            End If
        Next shp
        
        ' Try OLE embed with error capture
        Dim ole As OLEObject
        Dim oleErr As String
        On Error Resume Next
        Set ole = Sh.OLEObjects.Add( _
            Filename:=molPath, _
            Link:=False, _
            DisplayAsIcon:=False)
        oleErr = Err.Description
        On Error GoTo 0
        
        If ole Is Nothing Then
            MsgBox "OLE failed: " & oleErr & Chr(10) & _
                   "Mol path: " & molPath & Chr(10) & _
                   "File exists: " & (Dir(molPath) <> ""), _
                   vbCritical, "OLE Error"
        Else
            With Target
                ole.Left   = .Left + 2
                ole.Top    = .Top + 2
                ole.Width  = .Width - 4
                ole.Height = .Height - 4
            End With
            Target.Value = Chr(10) & Chr(10) & Chr(10) & Chr(10) & compoundId
            MsgBox "Success! Biovia object embedded.", vbInformation, "Done"
        End If
        
    End If
    
End Sub