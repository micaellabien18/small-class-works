.model small
.stack 100h

.data
    firstNumPrompt db 'Enter First Number: $'
    secondNumPrompt db 13,10, 'Enter Second Number: $'
    addPrompt db 13,10, 'A - Add $'
    subtractPrompt db 13,10, 'S - Subtract $'
    multiplyPrompt db 13,10, 'M - Multiply $'
    dividePrompt db 13,10, 'D - Divide $'
    operationPrompt db 13,10, 'Choose among the operations: $'
    invalidOperationPrompt db 13,10, 'Invalid operation choice! $'
    resultPrompt db 13,10, 'Answer: $'

    firstNum db ?
    secondNum db ?
    choice db ?
    result db ?

.code
    main proc
        mov ax, @data
        mov ds, ax

        ; Display prompt for the first number
        mov ah, 09h
        lea dx, firstNumPrompt
        int 21h

        ; Read the first number from the user
        mov ah, 01h
        int 21h
        sub al, 30h
        mov firstNum, al

        ; Display prompt for the second number
        mov ah, 09h
        lea dx, secondNumPrompt
        int 21h

        ; Read the second number from the user
        mov ah, 01h
        int 21h
        sub al, 30h
        mov secondNum, al

        ; Display the operation choices
        mov ah, 09h
        lea dx, addPrompt
        int 21h

        mov ah, 09h
        lea dx, subtractPrompt
        int 21h

        mov ah, 09h
        lea dx, multiplyPrompt
        int 21h

        mov ah, 09h
        lea dx, dividePrompt
        int 21h     
        
        ; Display prompt for the operation choice
        mov ah, 09h
        lea dx, operationPrompt
        int 21h

        ; Read the operation choice from the user
        mov ah, 01h
        int 21h
        mov choice, al

        ; Perform the chosen operation
        cmp choice, 'A'
        je addNumbers
        cmp choice, 'S'
        je subtractNumbers
        cmp choice, 'M'
        je multiplyNumbers
        cmp choice, 'D'
        je divideNumbers

        ; Invalid operation choice
        mov ah, 09h
        lea dx, invalidOperationPrompt
        int 21h
        jmp exitProgram

    addNumbers:
        mov al, firstNum
        add al, secondNum
        mov result, al
        jmp displayResult

    subtractNumbers:
        mov al, firstNum
        sub al, secondNum
        mov result, al
        jmp displayResult

    multiplyNumbers:
        mov al, firstNum
        mul secondNum
        mov result, al
        jmp displayResult

    divideNumbers:
        mov al, firstNum
        xor ah, ah
        div secondNum
        mov result, al
        jmp displayResult

    displayResult:
        ; Display the result prompt
        mov ah, 09h
        lea dx, resultPrompt
        int 21h

        ; Display the result
        mov dl, result
        add dl, 30h
        mov ah, 02h
        int 21h

    exitProgram:
        mov ah, 4Ch
        int 21h
    main endp

end main