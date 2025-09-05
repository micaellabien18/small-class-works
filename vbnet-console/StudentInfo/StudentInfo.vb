Module StudentInfo
    Sub Main()
        Dim studentNumber As Integer

        Console.Write("Enter Student Number: ")
        studentNumber = CInt(Console.ReadLine())

        Select Case studentNumber
            Case 1001
                Console.WriteLine("Name: Micaella Bien")
                Console.WriteLine("Course: BSCS")
            Case 1002
                Console.WriteLine("Name: Mark Santos")
                Console.WriteLine("Course: BSIS")
            Case 1003
                Console.WriteLine("Name: Anna Mendoza")
                Console.WriteLine("Course: BSIT")
            Case Else
                Console.WriteLine("Invalid Student Number.")
        End Select
    End Sub
End Module
