const fs=require("fs")
/* console.log(fs) */
console.log("Starting")
fs.writeFile("ADS-DataStore-1.txt","This Is How Legends Are Made",(()=>{
    console.log("Work Is Done")
}))
console.log("Ending")
fs.appendFile("ADS-DataStore-1.txt"," -Tony Stark",((e,d)=>{
    console.log(d)
}))