fetch("http://localhost:8080/api/v1/authors/sort", {
        method: 'GET',
        headers: {
            'Authorization': 'Basic ' + btoa('Ankit:ankit123') // Replace with your credentials
        }
    }).then((val)=>{
        return val.json();
    }).then((res)=>{
        res.map((i)=>{
            console.log(i.name);
            
        })
    })