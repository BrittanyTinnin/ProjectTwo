console.log("connected")

class Person{
	constructor(name, age){
		this.name=name;
		this.age=age;
	}
	toString(){
		return `{"name":"${this.name}", "age":${this.age}}`;
	}
}
let susan = new Person("susan", 76);
fetch("http://localhost:8080/Jackson-Body-Example/read.json",{
	method:"POST",
	body:susan.toString()
})

//change all this, testing out json