def encrypt_vigenere(text, key):
    result = ""
    key = key.lower()
    j = 0
    for i in text:
        if i.isalpha():
            shift = ord(key[j % len(key)]) - 97
            result += chr((ord(i.lower()) - 97 + shift) % 26 + 97)
            j += 1
        else:
            result += i
    return result
def decrypt_vigenere(text, key):
    result = ""
    key = key.lower()
    j = 0
    for i in text:
        if i.isalpha():
            shift = ord(key[j % len(key)]) - 97
            result += chr((ord(i.lower()) - 97 - shift) % 26 + 97)
            j += 1
        else:
            result += i
    return result
msg = "SOA UNIVERSITY BBSR"
key = "AMULYA"
enc = encrypt_vigenere(msg, key)
dec = decrypt_vigenere(enc, key)
print("Encrypted:", enc)
print("Decrypted:", dec)
