// unfinished function

function postNewFlight(){



   var validJsonBook = JSON.stringify(newFlight);
   console.log(postNewFlight);

   $.ajax({
       url:"http://localhost8080/api/flight/add",
       type:"post",
       data: validJsonBook,
       contentType: "application/json",
       success: function(result) {
            console.log("success post data!");
            getData();
       }
   });
}