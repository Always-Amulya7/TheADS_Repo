/*console.log("ADS Is An Hacker")
console.log("It's Obivious")
setTimeout(()=>{
    console.log("Hello")
},2000);
console.log("The End")
/*const callback=(arg)=>{
    console.log(arg)
}
const LoadScript=(src,callback)=>{
    let Sc=document.createElement("script");
    Sc.src=src;
    Sc.onload=callback("ADS");
    document.head.append(Sc);
}
LoadScript("","Amulya")

//alert('ADS');

let Prom1=new Promise((resolve,reject)=>{
    let a=Math.random();
    if (a<0.5)
    {
        reject("No Support For You")
    }
    else
    {
        setTimeout(()=>{
        console.log("Yes We Are Done")
        resolve("ADS")
    },3000)
    }
    
})
let Prom2=new Promise((resolve,reject)=>{
    let a=Math.random();
    if (a<0.5)
    {
        reject("No Support For You 2")
    }
    else
    {
        setTimeout(()=>{
        console.log("Yes We Are Done 2")
        resolve("ADS")
    },1000)
    }
    
})
/*Prom1.then((a)=>{
    console.log(a)
}).catch((err)=>{
    console.log(err)
})
Prom2.then((a)=>{
    console.log(a)
}).catch((err)=>{
    console.log(err)
})

let Prom3=Promise.all([Prom1,Prom2])
Prom3.then((a)=>{
    console.log(a)
}).catch((err)=>{
    console.log(err)
})*/

/*function getData(){
    return new Promise((resolve,reject)=>{
        setTimeout(()=>{
            resolve(455)
        },3000);
    })
}
console.log("Loading Modules")
console.log("Do Something Else")
console.log("Loading Data")
let Data=getData()
//Method-1 By Creating Promise We Can Keep Data Continuing
Data.then(()=>{
    console.log(Data)
    console.log("Process Data")
    console.log("Task-2")
})*/

//Method-2

/*async function getData(){
    return new Promise((resolve,reject)=>{
        setTimeout(()=>{
            resolve(455)
        },3000);
    })
}
async function main(){
    console.log("Loading Modules");
    console.log("Do Something Else");
    console.log("Loading Data");
    let Data = await getData();
    console.log(Data)
    console.log("Process Data")
    console.log("Task-2")
}
main()*/

//Method-3
try{
async function getData(){
    let x= await fetch('https://jsonplaceholder.typicode.com/todos/1')
    let data=await x.json()
    console.log(data)
    return data
}}
catch(err){
    console.log("Error")
}
async function main(){
    console.log("Loading Modules");
    console.log("Do Something Else");
    console.log("Loading Data");
    //let Data = await getData();
    //console.log(Data)
    console.log("Process Data")
    console.log("Task-2")
}
main()