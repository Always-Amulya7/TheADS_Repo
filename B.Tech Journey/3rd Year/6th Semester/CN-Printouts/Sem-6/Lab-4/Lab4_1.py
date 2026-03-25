def create_matrix(key):
    key = key.replace("j", "i")
    matrix = []
    used = set()
    for c in key + "abcdefghijklmnopqrstuvwxyz":
        if c not in used and c.isalpha():
            used.add(c)
            matrix.append(c)
    return [matrix[i:i+5] for i in range(0, 25, 5)]
def find_pos(matrix, char):
    for i in range(5):
        for j in range(5):
            if matrix[i][j] == char:
                return i, j
def prepare_text(text):
    text = text.replace("j", "i")
    result = ""
    i = 0
    while i < len(text):
        a = text[i]
        b = text[i+1] if i+1 < len(text) else 'x'
        if a == b:
            result += a + 'x'
            i += 1
        else:
            result += a + b
            i += 2
    if len(result) % 2 != 0:
        result += 'x'
    return result
def encrypt_playfair(text, key):
    matrix = create_matrix(key)
    text = prepare_text(text)
    result = ""
    for i in range(0, len(text), 2):
        a, b = text[i], text[i+1]
        r1, c1 = find_pos(matrix, a)
        r2, c2 = find_pos(matrix, b)
        if r1 == r2:
            result += matrix[r1][(c1+1)%5] + matrix[r2][(c2+1)%5]
        elif c1 == c2:
            result += matrix[(r1+1)%5][c1] + matrix[(r2+1)%5][c2]
        else:
            result += matrix[r1][c2] + matrix[r2][c1]
    return result
def decrypt_playfair(text, key):
    matrix = create_matrix(key)
    result = ""
    for i in range(0, len(text), 2):
        a, b = text[i], text[i+1]
        r1, c1 = find_pos(matrix, a)
        r2, c2 = find_pos(matrix, b)
        if r1 == r2:
            result += matrix[r1][(c1-1)%5] + matrix[r2][(c2-1)%5]
        elif c1 == c2:
            result += matrix[(r1-1)%5][c1] + matrix[(r2-1)%5][c2]
        else:
            result += matrix[r1][c2] + matrix[r2][c1]
    return result
msg = "hello"
key = "key"
enc = encrypt_playfair(msg, key)
dec = decrypt_playfair(enc, key)
print("Encrypted:", enc)
print("Decrypted:", dec)
