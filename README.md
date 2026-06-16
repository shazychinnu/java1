Private Sub Workbook_SheetBeforeDoubleClick(ByVal Sh As Object, ByVal Target As Range, Cancel As Boolean)
    Dim cellText As String
    Dim markerPos As Long
    On Error Resume Next
    cellText = CStr(Target.Value)
    On Error GoTo 0
    If cellText = "" Then Exit Sub
    markerPos = InStr(cellText, "##MOL##")
    If markerPos > 0 Then
        Cancel = True
        Dim compoundId As String
        Dim molText As String
        Dim molPath As String
        Dim fileNum As Integer
        compoundId = Trim(Replace(Left(cellText, markerPos - 1), Chr(10), ""))
        molText = Mid(cellText, markerPos + 8)
        molPath = Environ("TEMP") & "\" & compoundId & ".mol"
        fileNum = FreeFile
        Open molPath For Output As #fileNum
        Print #fileNum, molText
        Close #fileNum
        Dim shp As Shape
        For Each shp In Sh.Shapes
            If Not Intersect(shp.TopLeftCell, Target) Is Nothing Then
                shp.Delete
                Exit For
            End If
        Next shp
        Dim ole As OLEObject
        Set ole = Sh.OLEObjects.Add( _
            Filename:=molPath, _
            Link:=False, _
            DisplayAsIcon:=False)
        With Target
            ole.Left   = .Left + 2
            ole.Top    = .Top + 2
            ole.Width  = .Width - 4
            ole.Height = .Height - 4
        End With
        Target.Value = Chr(10) & Chr(10) & Chr(10) & Chr(10) & compoundId
        MsgBox "Molecule opened in Biovia Draw!" & Chr(10) & _
               "Edit and save in Biovia, then save this Excel file.", _
               vbInformation, "CTAB Edit"
    End If
End Sub