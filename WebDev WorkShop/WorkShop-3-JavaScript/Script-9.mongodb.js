use("Cruddb");
console.log(db);
/* db.createCollection("DataStore") */
/* db.DataStore.insertOne({
    Name:"Amulya Shrivastava",
    Price:20000,
    Assignments:23,
    Projects:45
}) */

/* let a = db.DataStore.find({ Name: "Amulya Shrivastava" }); */
/* console.log(a.count()) */
/* console.log(a.toArray()); */

/* db.DataStore.update({Name:"Amulya Shrivastava"},{$set:{Name:"Amulya Always"}}) */

/* db.DataStore.deleteMany({Name:"Amulya Always"}) */
db.dropDatabase("Cruddb")