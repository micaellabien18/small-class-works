Module DisplayName
    Sub Main()
        Dim firstName, middleName, lastName As String

        Console.Write("First Name: ")
        firstName = Console.ReadLine()

        Console.Write("Middle Name: ")
        middleName = Console.ReadLine()

        Console.Write("Last Name: ")
        lastName = Console.ReadLine()

        Dim middleInitial As String = middleName.Substring(0, 1)
        Console.WriteLine(vbCrLf & $"{firstName} {middleInitial}. {lastName}")
    End Sub
End Module
