.model small
.stack 100h

.data
    msg1 db 13,10,, "Enter a number: $"
    msg2 db 13,10,, "Output: $"
    num db 0
    count db 0

.code
    main proc
        mov ax, @data
        mov ds, ax
        
        ; Display prompt message
        mov ah, 09h
        mov dx, offset msg1
        int 21h
        
        ; Read input number
        mov ah, 01h
        int 21h
        sub al, '0' ; convert ASCII to numerical value
        mov num, al
        
        ; Display output message
        mov ah, 09h
        mov dx, offset msg2
        int 21h
        
        ; Display number of '#' characters
        mov al, '#'
        mov count, 0
        
        mov cl, num ; Initialize cl with the input number
        
    loop_start:
        cmp count, cl
        jge end_loop
        
        mov ah, 02h
        mov dl, al
        int 21h
        
        inc count
        jmp loop_start
        
    end_loop:
        mov ah, 4ch ; exit program
        int 21h
    main endp
end main