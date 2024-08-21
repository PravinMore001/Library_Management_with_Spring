//! fetch data from front
// fetch("http://localhost:8080/api/v1/authors/sort", {
//     method: 'GET',
//     headers: {
//         'Authorization': 'Basic ' + btoa('Ankit:ankit123') // Replace with your credentials
//     }
// }).then((val)=>{
//     console.log(val);
//     return val.json();
// }).then((res)=>{
//     console.log(res);
// })

// function displaydata(){
//     let name = document.getElementById("name").value
//     let email = document.getElementById("email").value
//     let mobile = document.getElementById("mobile").value
//     console.log(name);
//     console.log(email);
//     console.log(mobile);    
// }
//!--Push data from front end
const addButton = document.getElementById('addButton');
// const responseElement = document.getElementById('response');

addButton.addEventListener('click', () => {
  // Replace with your API endpoint and request body
  fetch('http://localhost:8080/api/v1/authors', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': 'Basic ' + btoa('Ankit:ankit123')
    },
    body: JSON.stringify({
      // Data to be sent in the request body
      name: document.getElementById("name").value,
      email: document.getElementById("email").value,
      mobile: document.getElementById("mobile").value
    })
  })
  .then(response => {
    if (response.ok) {
      return response.json();
    } else {
      throw new Error('POST request failed');
    }
  })
  .then(data => {
    console.log(data);
  })
  .catch(error => {
    console.error(error);
  });
});


// fetch('http://localhost:8080/api/v1/authors', 
//     { method: 'POST', 
//         headers: { 'Content-Type': 'application/json',
//             'Authorization': 'Basic ' + btoa('Ankit:ankit123')
//          }, 
//     body: JSON.stringify({ 
//         // Data to be sent in the request body 
//         name: 'John Doe', email: '[email address removed]' }) })
//          .then(response => { if (response.ok) { return response.json(); 

//          } 
//          else { throw new Error('POST request failed'); } }) 
//          .then(data => { console.log(data); 
//             // Process the response data 
//             }) .catch(error => { console.error(error); 

//             });