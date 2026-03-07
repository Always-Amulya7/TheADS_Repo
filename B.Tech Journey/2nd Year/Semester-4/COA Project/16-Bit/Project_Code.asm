.model small
.stack 100h

.data
    msg1        db 13, 10, 'Enter First Hex Number (0-FFFF): $'
    msg2        db 13, 10, 'Enter Second Hex Number (0-FFFF): $'
    msgAdd      db 13, 10, 10, 'Addition: $'
    msgSub      db 13, 10, 'Subtraction: $'
    msgMul      db 13, 10, 'Multiplication: $'
    msgDiv      db 13, 10, 'Division (Quotient): $'
    msgRem      db 13, 10, 'Division (Remainder): $'
    msgAnd      db 13, 10, 'AND: $'
    msgOr       db 13, 10, 'OR: $'
    msgXor      db 13, 10, 'XOR: $'
    msgNot1     db 13, 10, 'NOT Of First: $'
    msgNot2     db 13, 10, 'NOT Of Second: $'
    msgBin1     db 13, 10, 10, 'First In Binary: $'
    msgBin2     db 13, 10, 'Second In Binary: $'
    msgDec1     db 13, 10, 'First In Decimal: $'
    msgDec2     db 13, 10, 'Second In Decimal: $'
    newline     db 13, 10, '$'
    hexChars    db '0123456789ABCDEF'
    divByZero   db 13, 10, 'Division By Zero!', 13, 10, '$'
    promptRepeat db 13, 10, 10, 'Enter 0 To Exit Or 1 To Repeat: $'

.code
main:
    mov ax, @data
    mov ds, ax

program_loop:
    ; Print Message 1 And Read First Hex Number (16-bit)
    lea dx, msg1
    mov ah, 09h
    int 21h
    call ReadHex16   ; Now Reads 16-bit Value
    mov bx, ax      ; Store First Number In BX

    ; Print Message 2 And Read Second Hex Number (16-bit)
    lea dx, msg2
    mov ah, 09h
    int 21h
    call ReadHex16
    mov cx, ax      ; Store Second Number In CX

    ; ----------- ARITHMETIC OPERATIONS (16-bit) -----------
    ; Addition
    lea dx, msgAdd
    mov ah, 09h
    int 21h
    mov ax, bx
    add ax, cx
    call PrintHex16

    ; Subtraction
    lea dx, msgSub
    mov ah, 09h
    int 21h
    mov ax, bx
    sub ax, cx
    call PrintHex16

    ; Multiplication (16-bit   16-bit = 32-bit result)
    lea dx, msgMul
    mov ah, 09h
    int 21h
    mov ax, bx
    mul cx          ; DX:AX = AX * CX
    call PrintHex16 ; Print lower 16 bits (AX)

    ; Division (16-bit / 16-bit)
    lea dx, msgDiv
    mov ah, 09h
    int 21h
    cmp cx, 0
    je divisionError

    mov dx, 0       ; Clear Upper Part For Division
    mov ax, bx      ; Dividend In AX
    div cx          ; AX = Quotient, DX = Remainder

    push dx         ; Save Remainder

    ; Print Quotient
    call PrintHex16

    ; Print Remainder
    lea dx, msgRem
    mov ah, 09h
    int 21h
    pop ax          ; Restore Remainder
    call PrintHex16

    jmp afterDivision  ; Skip Error Label

divisionError:
    lea dx, divByZero
    mov ah, 09h
    int 21h

afterDivision:
    ; ----------- LOGICAL OPERATIONS (16-bit) -----------
    ; AND
    lea dx, msgAnd
    mov ah, 09h
    int 21h
    mov ax, bx
    and ax, cx
    call PrintHex16

    ; OR
    lea dx, msgOr
    mov ah, 09h
    int 21h
    mov ax, bx
    or ax, cx
    call PrintHex16

    ; XOR
    lea dx, msgXor
    mov ah, 09h
    int 21h
    mov ax, bx
    xor ax, cx
    call PrintHex16

    ; NOT (First Number)
    lea dx, msgNot1
    mov ah, 09h
    int 21h
    mov ax, bx
    not ax
    call PrintHex16

    ; NOT (Second Number)
    lea dx, msgNot2
    mov ah, 09h
    int 21h
    mov ax, cx
    not ax
    call PrintHex16

    ; ----------- NUMBER SYSTEM CONVERSIONS (16-bit) -----------
    ; First Number In Binary
    lea dx, msgBin1
    mov ah, 09h
    int 21h
    mov ax, bx
    call PrintBinary16

    ; Second Number In Binary
    lea dx, msgBin2
    mov ah, 09h
    int 21h
    mov ax, cx
    call PrintBinary16

    ; First Number In Decimal
    lea dx, msgDec1
    mov ah, 09h
    int 21h
    mov ax, bx
    call PrintDecimal16

    ; Second Number In Decimal
    lea dx, msgDec2
    mov ah, 09h
    int 21h
    mov ax, cx
    call PrintDecimal16

    ; Ask User If They Want To Repeat
    lea dx, promptRepeat
    mov ah, 09h
    int 21h
    
    ; Read User Choice
    mov ah, 01h
    int 21h
    
    cmp al, '1'
    je program_loop  ; Repeat If Input Is '1'
    
    ; Exit Program If Input Is Not '1'
    mov ah, 4Ch
    int 21h

; Subroutine: ReadHex16
; Reads A 4-digit Hex Number (0-FFFF) And Returns In AX
ReadHex16:
    push bx
    push cx
    push dx

    mov cx, 4       ; Read 4 hex digits (16-bit)
    xor bx, bx      ; Clear BX For Result

ReadNextDigit:
    mov ah, 01h
    int 21h         ; Input Character In AL

    ; Convert ASCII To Hex Value
    cmp al, '0'
    jb InvalidChar16
    cmp al, '9'
    jbe Digit16
    cmp al, 'A'
    jb InvalidChar16
    cmp al, 'F'
    jbe AlphaUpper16
    cmp al, 'a'
    jb InvalidChar16
    cmp al, 'f'
    jbe AlphaLower16

InvalidChar16:
    mov al, 0       ; Default To 0 On Invalid Input
    jmp SkipShift16

Digit16:
    sub al, '0'     ; Convert '0'-'9' To 0-9
    jmp ShiftAndAdd16

AlphaUpper16:
    sub al, 'A'     ; Convert 'A'-'F' To 10-15
    add al, 10
    jmp ShiftAndAdd16

AlphaLower16:
    sub al, 'a'     ; Convert 'a'-'f' To 10-15
    add al, 10

ShiftAndAdd16:
    shl bx, 4       ; Shift Left By 4 bits (For Next Digit)
    or bl, al       ; Add The New Digit

SkipShift16:
    loop ReadNextDigit

    mov ax, bx      ; Return Result In AX

    pop dx
    pop cx
    pop bx
    ret

; Subroutine: PrintHex16
; Prints AX (16-bit value) In 4-digit HEX
PrintHex16:
    push ax
    push bx
    push cx
    push dx

    mov cx, ax      ; Save Original Value
    lea bx, hexChars ; Point To Hex Character Table

    ; Print High Byte First
    mov al, ch      ; High byte
    shr al, 4
    and al, 0Fh
    xlat
    mov dl, al
    mov ah, 02h
    int 21h

    mov al, ch
    and al, 0Fh
    xlat
    mov dl, al
    mov ah, 02h
    int 21h

    ; Print Low Byte
    mov al, cl      ; Low Byte
    shr al, 4
    and al, 0Fh
    xlat
    mov dl, al
    mov ah, 02h
    int 21h

    mov al, cl
    and al, 0Fh
    xlat
    mov dl, al
    mov ah, 02h
    int 21h

    pop dx
    pop cx
    pop bx
    pop ax
    ret

; Subroutine: PrintBinary16
; Prints AX (16-bit value) In Binary Format
PrintBinary16:
    push ax
    push bx
    push cx
    push dx

    mov bx, ax      ; Save Original Value
    mov cx, 16      ; 16 Bits To Print

PrintBit16:
    rol bx, 1       ; Rotate Left Through Carry
    mov dl, '0'
    jnc PrintZero16
    mov dl, '1'
PrintZero16:
    push ax
    mov ah, 02h
    int 21h
    pop ax
    loop PrintBit16

    pop dx
    pop cx
    pop bx
    pop ax
    ret

; Subroutine: PrintDecimal16
; Prints AX (16-bit value) in Decimal Format (0-65535)
PrintDecimal16:
    push ax
    push bx
    push cx
    push dx

    mov bx, ax      ; Save Original Value
    mov ax, bx
    mov cx, 0       ; Initialize Digit Counter

DivideLoop:
    mov dx, 0
    mov bx, 10
    div bx          ; AX = Quotient, DX = Remainder
    push dx         ; Push Digit (0-9)
    inc cx
    cmp ax, 0
    jne DivideLoop

PrintLoop:
    pop dx
    add dl, '0'     ; Convert To ASCII
    mov ah, 02h
    int 21h
    loop PrintLoop

    pop dx
    pop cx
    pop bx
    pop ax
    ret

end main