.model small
.stack 100h

.data
    msg1        db 13, 10, 'Enter First Hex Digit (0-9, A-F): $'
    msg2        db 13, 10, 'Enter Second Hex Digit (0-9, A-F): $'
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
    ; Print Message 1 And Read First Hex Digit
    lea dx, msg1
    mov ah, 09h
    int 21h
    call ReadHex
    mov bl, al      ; Store First Number In BL

    ; Print Message 2 And Read Second Hex Digit
    lea dx, msg2
    mov ah, 09h
    int 21h
    call ReadHex
    mov bh, al      ; Store Second Number In BH

    ; ----------- ARITHMETIC OPERATIONS -----------
    ; Addition
    lea dx, msgAdd
    mov ah, 09h
    int 21h
    mov al, bl
    add al, bh
    call PrintHex

    ; Subtraction
    lea dx, msgSub
    mov ah, 09h
    int 21h
    mov al, bl
    sub al, bh
    call PrintHex

    ; Multiplication
    lea dx, msgMul
    mov ah, 09h
    int 21h
    mov al, bl
    mov ah, 0       ; Clear AH For Multiplication
    mul bh          ; AX = AL * BH
    call PrintHex   ; Prints AL (Lower Byte Of Result)

    ; Division (With Check For Division By Zero)
    lea dx, msgDiv
    mov ah, 09h
    int 21h
    cmp bh, 0
    je divisionError

    mov al, bl
    mov ah, 0
    div bh          ; AL = Quotient, AH = Remainder

    mov cl, ah      ; Store Remainder

    ; Print Quotient
    call PrintHex

    ; Print Remainder
    lea dx, msgRem
    mov ah, 09h
    int 21h
    mov al, cl
    call PrintHex

    jmp afterDivision  ; Skip Error Label

divisionError:
    lea dx, divByZero
    mov ah, 09h
    int 21h

afterDivision:
    ; ----------- LOGICAL OPERATIONS -----------
    ; AND
    lea dx, msgAnd
    mov ah, 09h
    int 21h
    mov al, bl
    and al, bh
    call PrintHex

    ; OR
    lea dx, msgOr
    mov ah, 09h
    int 21h
    mov al, bl
    or al, bh
    call PrintHex

    ; XOR
    lea dx, msgXor
    mov ah, 09h
    int 21h
    mov al, bl
    xor al, bh
    call PrintHex

    ; NOT (First Number)
    lea dx, msgNot1
    mov ah, 09h
    int 21h
    mov al, bl
    not al
    and al, 0FFh    ; Mask To 8 Bits
    call PrintHex

    ; NOT (Second Number)
    lea dx, msgNot2
    mov ah, 09h
    int 21h
    mov al, bh
    not al
    and al, 0FFh    ; Mask to 8 bits
    call PrintHex

    ; ----------- NUMBER SYSTEM CONVERSIONS -----------
    ; First Number In Binary
    lea dx, msgBin1
    mov ah, 09h
    int 21h
    mov al, bl
    call PrintBinary

    ; Second Number In Binary
    lea dx, msgBin2
    mov ah, 09h
    int 21h
    mov al, bh
    call PrintBinary

    ; First Number In Decimal
    lea dx, msgDec1
    mov ah, 09h
    int 21h
    mov al, bl
    call PrintDecimal

    ; Second Number In Decimal
    lea dx, msgDec2
    mov ah, 09h
    int 21h
    mov al, bh
    call PrintDecimal

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

; Subroutine: ReadHex
; Reads One Hex Digit (0-9, A-F) And Converts To Number (0-15)
; Returns: AL = Numeric Value (0-15)
ReadHex:
    mov ah, 01h
    int 21h         ; Input Character In AL

    ; Convert ASCII To Hex Value
    cmp al, '0'
    jb InvalidChar
    cmp al, '9'
    jbe Digit
    cmp al, 'A'
    jb InvalidChar
    cmp al, 'F'
    jbe AlphaUpper
    cmp al, 'a'
    jb InvalidChar
    cmp al, 'f'
    jbe AlphaLower

InvalidChar:
    mov al, 0       ; Default To 0 On Invalid Input
    ret

Digit:
    sub al, '0'     ; Convert '0'-'9' To 0-9
    ret

AlphaUpper:
    sub al, 'A'     ; Convert 'A'-'F' To 10-15
    add al, 10
    ret

AlphaLower:
    sub al, 'a'     ; Convert 'a'-'f' To 10-15
    add al, 10
    ret

; Subroutine: PrintHex
; Prints AL (8-Bit Value) In 2-digit HEX
PrintHex:
    push ax
    push bx
    push cx
    push dx

    mov cl, al      ; Save Original Value
    lea bx, hexChars ; Point To Hex Character Table

    ; High Nibble
    mov al, cl
    shr al, 4
    and al, 0Fh     ; Ensure Only 4 Bits
    xlat            ; Convert To Hex Character
    mov dl, al
    mov ah, 02h
    int 21h

    ; Low Nibble
    mov al, cl
    and al, 0Fh
    xlat            ; Convert To Hex Character
    mov dl, al
    mov ah, 02h
    int 21h

    pop dx
    pop cx
    pop bx
    pop ax
    ret

; Subroutine: PrintBinary
; Prints AL (8-bit Value) In Binary Format
PrintBinary:
    push ax
    push bx
    push cx
    push dx

    mov bl, al      ; Save Original Value
    mov cx, 8       ; 8 Bits To Print

PrintBit:
    rol bl, 1       ; Rotate Left Through Carry
    mov dl, '0'
    jnc PrintZero
    mov dl, '1'
PrintZero:
    push ax
    mov ah, 02h
    int 21h
    pop ax
    loop PrintBit

    pop dx
    pop cx
    pop bx
    pop ax
    ret

; Subroutine: PrintDecimal
; Prints AL (8-bit Value) In Decimal Format
PrintDecimal:
    push ax
    push bx
    push cx
    push dx

    mov bl, al      ; Save Original Value
    mov ah, 0       ; Clear AH For Division
    mov al, bl      ; Restore Value To AX (AH=0, AL=value)

    ; Handle 3 Digits (0-255)
    mov cl, 100
    div cl          ; AL = Hundreds Digit, AH = Remainder
    mov ch, ah      ; Save Remainder
    add al, '0'     ; Convert To ASCII
    mov dl, al
    mov ah, 02h
    int 21h         ; Print Hundreds Digit
    
    mov al, ch      ; Restore Remainder
    mov ah, 0
    mov cl, 10
    div cl          ; AL = Tens Digit, AH = Units Digit
    mov bx, ax      ; Save Both Digits

    add bl, '0'     ; Convert Tens To ASCII
    mov dl, bl
    mov ah, 02h
    int 21h         ; Print Tens Digit

    add bh, '0'     ; Convert Units To ASCII
    mov dl, bh
    mov ah, 02h
    int 21h         ; Print Units Digit

    pop dx
    pop cx
    pop bx
    pop ax
    ret

end main