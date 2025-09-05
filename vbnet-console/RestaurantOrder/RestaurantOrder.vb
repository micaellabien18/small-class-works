Module RestaurantOrder
    Sub Main()
        Dim meals() As String = {"Adobo", "Lechon", "Bulalo", "Sinigang", "Mechado"}
        Dim mealPrices() As Decimal = {40.50D, 70.00D, 65.20D, 50.00D, 40.25D}

        Dim drinks() As String = {"Buko Juice", "Sago't Gulaman", "Kapeng Barako", "Kamias Shake", "Strawberry Wine"}
        Dim drinkPrices() As Decimal = {30.25D, 15.00D, 10.50D, 30.50D, 40.50D}

        Dim totalBill As Decimal = 0D
        Dim choice As Integer
        Dim qty As Integer
        Dim payment As Decimal

        Dim orderedItems As New List(Of String)
        Dim orderedQty As New List(Of Integer)
        Dim orderedPrice As New List(Of Decimal)


        Console.WriteLine(vbTab & "ELLA'S RESTAURANT" & vbCrLf)

        ' Display meals
        Console.WriteLine(vbTab & "     MEALS")
        For i As Integer = 0 To meals.Length - 1
            Console.WriteLine($"[{i + 1}] {meals(i)} ---------- Php {mealPrices(i)}")
        Next
        Console.WriteLine("[0] Done")

         ' Order meals
        Do
            Console.Write(vbCrLf & "Enter meal number: ")
            choice = CInt(Console.ReadLine())
            If choice = 0 Then Exit Do
            orderedItems.Add(meals(choice - 1))

            If choice >= 1 AndAlso choice <= meals.Length Then
                Console.Write($"Enter quantity for {meals(choice - 1)}: ")
                qty = CInt(Console.ReadLine())
                orderedQty.Add(qty)
                orderedPrice.Add(mealPrices(choice - 1) * qty)
                totalBill += mealPrices(choice - 1) * qty
            Else
                Console.WriteLine("Invalid meal number. Try again.")
            End If
        Loop
        
        ' Display drinks
        Console.WriteLine(vbCrLf & vbTab & "     DRINKS")
        For i As Integer = 0 To drinks.Length - 1
            Console.WriteLine($"[{i + 1}] {drinks(i)} ------ Php {drinkPrices(i)}")
        Next
        Console.WriteLine("[0] Done")

        ' Order drinks
        Do
            Console.Write(vbCrLf & "Enter drink number: ")
            choice = CInt(Console.ReadLine())
            If choice = 0 Then Exit Do
            orderedItems.Add(drinks(choice - 1))

            If choice >= 1 AndAlso choice <= drinks.Length Then
                Console.Write($"Enter quantity for {drinks(choice - 1)}: ")
                qty = CInt(Console.ReadLine())
                orderedQty.Add(qty)
                orderedPrice.Add(drinkPrices(choice - 1) * qty)
                totalBill += drinkPrices(choice - 1) * qty
            Else
                Console.WriteLine("Invalid drink number. Try again.")
            End If
        Loop

        ' Process payment
        Console.WriteLine(vbCrLf & "Qty     Item                 Price")
        Console.WriteLine("---------------------------------------")
        For i As Integer = 0 To orderedItems.Count - 1
            Console.WriteLine($"{orderedQty(i),-3}     {orderedItems(i),-20} Php {orderedPrice(i):0.00}")
        Next
        Console.WriteLine("---------------------------------------")

        Console.WriteLine(vbCrLf & $"Total bill: Php {totalBill}")

        Do
            Console.Write("Enter payment amount: ")
            payment = CDec(Console.ReadLine())
            If payment < totalBill Then
                Console.WriteLine("Insufficient payment. Please enter again.")
            End If
        Loop While payment < totalBill

        Dim change As Decimal = payment - totalBill
        Console.WriteLine($"Change: Php {change}")
    End Sub
End Module
