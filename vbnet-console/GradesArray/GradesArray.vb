Module GradesArray
    Sub Main()
        Dim grades(4, 5) As Integer ' Rows 0-4, columns 0-5
        Dim failingCount As Integer = 0

        ' Accept input for each row and column
        For row As Integer = 0 To 4
            For col As Integer = 0 To 5
                Console.Write($"Enter grade for student {row + 1}, subject {col + 1}: ")
                grades(row, col) = CInt(Console.ReadLine())
            Next
        Next

        ' Loop through array and count grades below 75
        For row As Integer = 0 To 4
            For col As Integer = 0 To 5
                If grades(row, col) < 75 Then
                    failingCount += 1
                End If
            Next
        Next

        ' Print array in table format
        Console.WriteLine(vbCrLf & "Grades Table")
        For row As Integer = 0 To 4
            For col As Integer = 0 To 5
                Console.Write(grades(row, col).ToString().PadRight(6))
            Next
            Console.WriteLine()
        Next
        Console.WriteLine()

        ' Display the number of failing grades
        Console.WriteLine("Number of failing grades: " & failingCount)
    End Sub
End Module
