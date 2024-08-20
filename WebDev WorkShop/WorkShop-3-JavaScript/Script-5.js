import fs from "fs/promises"
/* let a=await fs.readFile("ADS-DataStore-1.txt")
let b=await fs.appendFile("ADS-DataStore-1.txt"," AI")
console.log(a.toString(),b) */
import path from "path"
console.log(path)
let MyPath="D:\\My Files\\Coding\\HTML Files\\Project-1\\JavaScript Complete\\ADS-DataBase-1.txt"
console.log(path.extname(MyPath))
console.log(path.basename(MyPath))
console.log(path.join("C:/","D:\\My Files\\Coding\\HTML Files\\Project-1\\JavaScript Complete\\ADS-DataBase-1.txt"))